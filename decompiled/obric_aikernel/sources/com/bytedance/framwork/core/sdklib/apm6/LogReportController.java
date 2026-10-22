package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class LogReportController {
    public static final String COLLECT_PATH = "/monitor/collect/batch/";
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
    private volatile int delayTime;
    private final ConcurrentHashMap<String, Boolean> encryptMap;
    private volatile boolean isEncrypt;
    private volatile int netFailCount;
    private List<String> reportUrlList;
    private volatile int shortFailCount;
    private volatile int shortStopInterval;
    private AtomicLong startDropDataTime;
    private volatile boolean stopCollect;
    private AtomicLong stopCollectLogTime;
    private volatile int stopInterval;

    static /* synthetic */ class a {
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static LogReportController f1891a;

        static {
            f1891a = new LogReportController(null);
        }
    }

    static {
        RETRY_INTERVALS = new long[]{120000, 300000, TEN_MINUTES, THIRTY_MINUTES, SIXTY_MINUTES};
    }

    private LogReportController() {
        this.shortFailCount = 0;
        this.collectLogSwitch = true;
        this.encryptMap = new ConcurrentHashMap();
        this.isEncrypt = true;
        this.stopCollectLogTime = new AtomicLong(0);
        this.startDropDataTime = new AtomicLong();
    }

    /* synthetic */ LogReportController(a r10) {
        this();
    }

    private static List<String> convertReportUrl(List<String> r10) {
        LinkedList r11 = new LinkedList();
        Iterator<String> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        r11.add((ReportConsts.HTTPS + new URL(r12.next()).getHost()) + "/monitor/collect/batch/");     // Catch: MalformedURLException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r11;
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
        return b.f1891a;
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

    long getMaxRetryCount() {
        return 5;
    }

    List<String> getReportList() {
        if (ListUtils.isEmpty(this.reportUrlList) == false) goto L7;
        return ReportConsts.DEFAULT_LOG_REPORT;
    L7:
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

    boolean isEncrypt() {
        return this.isEncrypt;
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
        if (j.f() == false) goto L17;
        j3.c.a("APM-SDK", "longBackOff:" + this.stopInterval + " netFailCount:" + this.netFailCount);
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

    public void setEncrypt(String r10, boolean r11) {
        this.encryptMap.put(r10, Boolean.valueOf(r11));
        Iterator<Boolean> r12 = this.encryptMap.values().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        if (r12.next().booleanValue() == false) goto L4;
        boolean r13 = true;
    L9:
        this.isEncrypt = r13;
        return;
    L8:
        r13 = false;
        goto L9
    }

    public void setReportUrlList(String r10, List<String> r11) {
        if (ListUtils.isEmpty(r11) == false) goto L5;
        return;
    L5:
        if (ListUtils.isEmpty(this.reportUrlList) == false) goto L10;
        this.reportUrlList = convertReportUrl(r11);
        return;
    }

    void shortBackOff() {
        if (this.shortFailCount != 0) goto L7;
        this.shortFailCount = 1;
        int r10 = SHORT_DELAY_FIRST;
    L5:
        this.shortStopInterval = r10;
        if (j.f() == false) goto L19;
        j3.c.a("APM-SDK", "shortStopInterval:" + this.shortStopInterval + " shortFailCount:" + this.shortFailCount);
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
}
