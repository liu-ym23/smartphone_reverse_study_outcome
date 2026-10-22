package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfig;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        RETRY_INTERVALS = new long[]{120000, 300000, 600000, THIRTY_MINUTES, 3600000};
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

    /* synthetic */ LogReportController(AnonymousClass1 r1) {
        this();
    }

    private long getDelayTime() {
        if (this.stopInterval <= this.shortStopInterval) goto L5;
        int r0 = this.stopInterval;
    L6:
        long r1 = r0;
        if (r1 <= this.delayTime) goto L10;
        return r1;
    L10:
        return this.delayTime;
    L5:
        r0 = this.shortStopInterval;
        goto L6
    }

    public static LogReportController getInstance() {
        return InnerHolder.instance;
    }

    private void setCollectDelay() {
        this.collectLogSwitch = false;
        this.stopCollectLogTime.set(System.currentTimeMillis());
    }

    void delayReport(long r3) {
        this.delayTime = (int) (r3 * 1000);
        setCollectDelay();
    }

    void dropData() {
        longBackOff();
        this.stopCollect = true;
        this.startDropDataTime.set(System.currentTimeMillis());
    }

    List<String> getExceptionUrlList() {
        SlardarHandlerConfig r0 = this.config;
        if (r0 == null) goto L9;
        if (ListUtils.isEmpty(r0.getExceptionUrl()) == true) goto L9;
        return this.config.getExceptionUrl();
    L9:
        return this.exceptionUrlList;
    }

    List<String> getReportList() {
        SlardarHandlerConfig r0 = this.config;
        if (r0 == null) goto L9;
        if (ListUtils.isEmpty(r0.getReportUrlList()) == true) goto L9;
        return this.config.getReportUrlList();
    L9:
        return this.reportUrlList;
    }

    long getRetryInterval(int r2) {
        int r3 = r2 - 1;
        if (r3 >= 0) goto L6;
        return 0;
    L6:
        long[] r1 = RETRY_INTERVALS;
        if (r3 < r1.length) goto L11;
        return r1[r1.length - 1];
    L11:
        return r1[r3];
    }

    List<String> getTraceUrlList() {
        SlardarHandlerConfig r0 = this.config;
        if (r0 == null) goto L9;
        if (ListUtils.isEmpty(r0.getTraceReportUrl()) == true) goto L9;
        return this.config.getTraceReportUrl();
    L9:
        return this.traceUrlList;
    }

    boolean isEncrypt() {
        SlardarHandlerConfig r0 = this.config;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.isEncrypt();
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
        int r0 = 300000;
    L5:
        this.stopInterval = r0;
    L15:
        if (ApmContext.isDebugMode() == false) goto L17;
        Logger.d(Constants.TAG, "longBackOff:" + this.stopInterval + " netFailCount:" + this.netFailCount);
    L17:
        setCollectDelay();
        return;
    L7:
        if (this.netFailCount != 1) goto L10;
        this.netFailCount = 2;
        r0 = THIRD_STOP_INTERVAL;
        goto L5
    L10:
        if (this.netFailCount != 2) goto L12;
        int r1 = 3;
    L13:
        this.netFailCount = r1;
        this.stopInterval = LAST_STOP_INTERVAL;
        goto L15
    L12:
        r1 = 4;
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

    public void setDefaultExceptionUrlList(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (ListUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        this.exceptionUrlList.clear();
        this.exceptionUrlList.addAll(r4);
    }

    public void setDefaultReportUrlList(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (ListUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        this.reportUrlList.clear();
        this.reportUrlList.addAll(r4);
    }

    public void setTraceReportUrlList(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (ListUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        this.traceUrlList.clear();
        this.traceUrlList.addAll(r4);
    }

    void shortBackOff() {
        if (this.shortFailCount != 0) goto L7;
        this.shortFailCount = 1;
        int r0 = 30000;
    L5:
        this.shortStopInterval = r0;
        if (ApmContext.isDebugMode() == false) goto L19;
        Logger.d(Constants.TAG, "shortStopInterval:" + this.shortStopInterval + " shortFailCount:" + this.shortFailCount);
    L19:
        setCollectDelay();
        return;
    L7:
        if (this.shortFailCount != 1) goto L10;
        this.shortFailCount = 2;
        r0 = 60000;
        goto L5
    L10:
        if (this.shortFailCount != 2) goto L13;
        this.shortFailCount = 3;
        r0 = 120000;
        goto L5
    L13:
        if (this.shortFailCount != 3) goto L15;
        this.shortFailCount = 4;
        r0 = SHORT_DELAY_FOURTH;
        goto L5
    L15:
        this.shortFailCount = 5;
        r0 = 300000;
        goto L5
    }

    public void updateConfig(SlardarHandlerConfig r1) {
        this.config = r1;
    }
}
