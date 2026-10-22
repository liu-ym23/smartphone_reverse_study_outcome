package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfig;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class LogReportController {
    private static final long FIVE_MINUTES = 300000;
    private static final int LAST_STOP_INTERVAL = 1800000;
    private static final int MINUTE_IN_MILLIS = 60000;
    private static final long[] RETRY_INTERVALS = null;
    private static final int SECOND_IN_MILLIS = 1000;
    private static final int SECOND_STOP_INTERVAL = 300000;
    private static final int SHORT_BASE_DELAY = 15;
    private static final int SHORT_DELAY_FIFTH = 300000;
    private static final int SHORT_DELAY_FIRST = 30000;
    private static final int SHORT_DELAY_FOURTH = 240000;
    private static final int SHORT_DELAY_SECOND = 60000;
    private static final int SHORT_DELAY_THIRD = 120000;
    private static final long SIXTY_MINUTES = 3600000;
    private static final long TEN_MINUTES = 600000;
    private static final int THIRD_STOP_INTERVAL = 900000;
    private static final long THIRTY_MINUTES = 1800000;
    private static final long TWO_MINUTES = 120000;
    private volatile boolean collectLogSwitch;
    private SlardarHandlerConfig config;
    private volatile int delayTime;
    private List<String> exceptionUrlList;
    private volatile int netFailCount;
    private List<String> reportUrlList;
    private volatile int shortFailCount;
    private volatile int shortStopInterval;
    private AtomicLong startDropDataTime;
    private volatile boolean stopCollect;
    private AtomicLong stopCollectLogTime;
    private volatile int stopInterval;
    private List<String> traceUrlList;

    /* JADX INFO: renamed from: com.bytedance.apm6.consumer.slardar.send.LogReportController$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class InnerHolder {
        static LogReportController instance;

        static {
            instance = new LogReportController(null);
        }

        InnerHolder() {
        }
    }

    static {
        RETRY_INTERVALS = new long[]{120000, 300000, TEN_MINUTES, THIRTY_MINUTES, SIXTY_MINUTES};
    }

    private LogReportController() {
        this.shortFailCount = 0;
        this.collectLogSwitch = true;
        this.reportUrlList = new ArrayList();
        this.traceUrlList = new ArrayList();
        this.exceptionUrlList = new ArrayList();
        this.stopCollectLogTime = new AtomicLong(0);
        this.startDropDataTime = new AtomicLong();
    }

    /* synthetic */ LogReportController(AnonymousClass1 r10) {
        this();
    }

    private long getDelayTime() {
        if (this.stopInterval <= this.shortStopInterval) goto L5;
        int r10 = this.stopInterval;
    L6:
        long r11 = r10;
        if (r11 <= this.delayTime) goto L10;
        return r11;
    L10:
        return this.delayTime;
    L5:
        r10 = this.shortStopInterval;
        goto L6
    }

    public static LogReportController getInstance() {
        return InnerHolder.instance;
    }

    private void setCollectDelay() {
        this.collectLogSwitch = false;
        this.stopCollectLogTime.set(System.currentTimeMillis());
    }

    void delayReport(long r10) {
        this.delayTime = (int) (r10 * 1000);
        setCollectDelay();
    }

    void dropData() {
        longBackOff();
        this.stopCollect = true;
        this.startDropDataTime.set(System.currentTimeMillis());
    }

    List<String> getExceptionUrlList() {
        SlardarHandlerConfig r10 = this.config;
        if (r10 == null) goto L9;
        if (ListUtils.isEmpty(r10.getExceptionUrl()) == true) goto L9;
        return this.config.getExceptionUrl();
    L9:
        return this.exceptionUrlList;
    }

    List<String> getReportList() {
        SlardarHandlerConfig r10 = this.config;
        if (r10 == null) goto L9;
        if (ListUtils.isEmpty(r10.getReportUrlList()) == true) goto L9;
        return this.config.getReportUrlList();
    L9:
        return this.reportUrlList;
    }

    long getRetryInterval(int r10) {
        int r11 = r10 - 1;
        if (r11 >= 0) goto L6;
        return 0;
    L6:
        long[] r12 = RETRY_INTERVALS;
        if (r11 < r12.length) goto L11;
        return r12[r12.length - 1];
    L11:
        return r12[r11];
    }

    List<String> getTraceUrlList() {
        SlardarHandlerConfig r10 = this.config;
        if (r10 == null) goto L9;
        if (ListUtils.isEmpty(r10.getTraceReportUrl()) == true) goto L9;
        return this.config.getTraceReportUrl();
    L9:
        return this.traceUrlList;
    }

    boolean isEncrypt() {
        SlardarHandlerConfig r10 = this.config;
        if (r10 != null) goto L5;
        return true;
    L5:
        return r10.isEncrypt();
    }

    boolean isReportLogEnable() {
        if (this.collectLogSwitch == false) goto L5;
        return true;
    L5:
        if ((System.currentTimeMillis() - this.stopCollectLogTime.get()) > getDelayTime()) goto L10;
        return false;
    L10:
        return true;
    }

    boolean isStopCollect() {
        if (this.stopCollect == false) goto L10;
        if ((System.currentTimeMillis() - this.startDropDataTime.get()) > getDelayTime()) goto L7;
        return true;
    L7:
        return false;
    L10:
        return this.stopCollect;
    }

    void longBackOff() {
        if (this.netFailCount != 0) goto L7;
        this.netFailCount = 1;
        int r10 = 300000;
    L5:
        this.stopInterval = r10;
    L15:
        if (ApmBaseContext.isDebugMode() == false) goto L17;
        Logger.d(Constants.TAG, "longBackOff:" + this.stopInterval + " netFailCount:" + this.netFailCount);
    L17:
        setCollectDelay();
        return;
    L7:
        if (this.netFailCount != 1) goto L10;
        this.netFailCount = 2;
        r10 = THIRD_STOP_INTERVAL;
        goto L5
    L10:
        if (this.netFailCount != 2) goto L12;
        int r11 = 3;
    L13:
        this.netFailCount = r11;
        this.stopInterval = LAST_STOP_INTERVAL;
        goto L15
    L12:
        r11 = 4;
        goto L13
    }

    void recoveryFromDropData() {
        this.stopCollect = false;
    }

    void restore() {
        this.collectLogSwitch = true;
        this.stopCollect = false;
        this.netFailCount = 0;
        this.stopInterval = 0;
        this.shortFailCount = 0;
        this.shortStopInterval = 0;
        this.delayTime = 0;
        this.startDropDataTime.set(0);
        this.stopCollectLogTime.set(0);
    }

    public void setDefaultExceptionUrlList(List<String> r10) {
        if (ListUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.exceptionUrlList.clear();
        this.exceptionUrlList.addAll(r10);
    }

    public void setDefaultReportUrlList(List<String> r10) {
        if (ListUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.reportUrlList.clear();
        this.reportUrlList.addAll(r10);
    }

    public void setTraceReportUrlList(List<String> r10) {
        if (ListUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.traceUrlList.clear();
        this.traceUrlList.addAll(r10);
    }

    void shortBackOff() {
        if (this.shortFailCount != 0) goto L7;
        this.shortFailCount = 1;
        int r10 = SHORT_DELAY_FIRST;
    L5:
        this.shortStopInterval = r10;
        if (ApmBaseContext.isDebugMode() == false) goto L19;
        Logger.d(Constants.TAG, "shortStopInterval:" + this.shortStopInterval + " shortFailCount:" + this.shortFailCount);
    L19:
        setCollectDelay();
        return;
    L7:
        if (this.shortFailCount != 1) goto L10;
        this.shortFailCount = 2;
        r10 = 60000;
        goto L5
    L10:
        if (this.shortFailCount != 2) goto L13;
        this.shortFailCount = 3;
        r10 = SHORT_DELAY_THIRD;
        goto L5
    L13:
        if (this.shortFailCount != 3) goto L15;
        this.shortFailCount = 4;
        r10 = SHORT_DELAY_FOURTH;
        goto L5
    L15:
        this.shortFailCount = 5;
        r10 = 300000;
        goto L5
    }

    public void updateConfig(SlardarHandlerConfig r10) {
        this.config = r10;
    }
}
