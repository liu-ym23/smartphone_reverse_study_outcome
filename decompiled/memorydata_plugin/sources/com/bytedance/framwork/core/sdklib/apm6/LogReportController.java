package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
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

    /* JADX INFO: renamed from: com.bytedance.framwork.core.sdklib.apm6.LogReportController$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static LogReportController f2574a;

        static {
            f2574a = new LogReportController(null);
        }
    }

    static {
        RETRY_INTERVALS = new long[]{120000, 300000, 600000, THIRTY_MINUTES, 3600000};
    }

    private LogReportController() {
        this.shortFailCount = 0;
        this.collectLogSwitch = true;
        this.encryptMap = new ConcurrentHashMap();
        this.isEncrypt = true;
        this.stopCollectLogTime = new AtomicLong(0);
        this.startDropDataTime = new AtomicLong();
    }

    /* synthetic */ LogReportController(AnonymousClass1 r1) {
        this();
    }

    private static List<String> convertReportUrl(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        LinkedList r0 = new LinkedList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        r0.add((ReportConsts.HTTPS + new URL((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin")).getHost()) + "/monitor/collect/batch/");     // Catch: MalformedURLException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r0;
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
        return a.f2574a;
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

    long getMaxRetryCount() {
        return 5;
    }

    List<String> getReportList() {
        if (ListUtils.isEmpty(this.reportUrlList) == false) goto L7;
        return ReportConsts.DEFAULT_LOG_REPORT;
    L7:
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
        int r0 = 300000;
    L5:
        this.stopInterval = r0;
    L15:
        if (j.d() == false) goto L17;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "longBackOff:" + this.stopInterval + " netFailCount:" + this.netFailCount);
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

    public void setEncrypt(String r3, boolean r4) {
        this.encryptMap.put(r3, Boolean.valueOf(r4));
        Iterator<Boolean> r5 = this.encryptMap.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5.next(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L4;
        boolean r6 = true;
    L9:
        this.isEncrypt = r6;
        return;
    L8:
        r6 = false;
        goto L9
    }

    public void setReportUrlList(String r2, List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (ListUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (ListUtils.isEmpty(this.reportUrlList) == false) goto L10;
        this.reportUrlList = convertReportUrl(r4);
        return;
    }

    void shortBackOff() {
        if (this.shortFailCount != 0) goto L7;
        this.shortFailCount = 1;
        int r0 = 30000;
    L5:
        this.shortStopInterval = r0;
        if (j.d() == false) goto L19;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "shortStopInterval:" + this.shortStopInterval + " shortFailCount:" + this.shortFailCount);
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
}
