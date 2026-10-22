package com.bytedance.crypto.monitor;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crypto.monitor.proto.CryptoSDKInfo;
import com.bytedance.crypto.monitor.proto.NormalTrace;
import com.bytedance.crypto.utils.LogUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class NormalEvent {
    private static final long DELAY_TIME = 21600000;
    private static final String TAG = "NormalEvent";
    private static volatile NormalEvent normalEvent;
    private static final HashMap<String, NormalTrace> normalTraceMap = null;
    private final Object LOCK;
    private boolean isInit;
    private Handler mHandler;
    private Runnable mTimerTask;

    static {
        normalTraceMap = new HashMap();
    }

    public NormalEvent() {
        this.isInit = false;
        this.LOCK = new Object();
    }

    public static /* synthetic */ void a(String r10, NormalTrace r11) {
        lambda$executeTask$0(r10, r11);
    }

    public static /* synthetic */ void access$000(NormalEvent r10) {
        r10.executeTask();
    }

    public static /* synthetic */ Handler access$100(NormalEvent r10) {
        return r10.mHandler;
    }

    private void executeTask() {
        Object r10 = this.LOCK;
        monitor-enter(r10);
        HashMap<String, NormalTrace> r11 = normalTraceMap;     // Catch: Throwable -> L12
        if (r11.size() > 0) goto L9;
        LogUtils.i(TAG, "normalTraceMap is empty, no need to write event");     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L9:
        LogUtils.i(TAG, "NormalEvent executeTask, normalTraceMap size = " + r11.size());     // Catch: Throwable -> L12
        r11.forEach(a.f1469a);     // Catch: Throwable -> L12
        r11.clear();     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static NormalEvent getInstance() {
        if (normalEvent != null) goto L15;
        monitor-enter(NormalEvent.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (normalEvent != null) goto L9;
        normalEvent = new NormalEvent();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NormalEvent.class);     // Catch: Throwable -> L11
    L15:
        return normalEvent;
    }

    private static /* synthetic */ void lambda$executeTask$0(String r10, NormalTrace r11) {
        Monitor.writeEvent(CryptoSDKInfo.newBuilder().setVersion(1).setTimestamp(System.currentTimeMillis()).addNormalTrace(r11));
    }

    public void eventRecord(int r18, int r19, String r20, String r21, long r22, long r24) {
        LogUtils.d(TAG, "eventRecord, module: " + r18 + ", event: " + r19 + ", pkgName: " + r20 + ", appid: " + r21 + ", timeConsumption: " + r22 + ", dataSize: " + r24);
        Object r10 = this.LOCK;
        monitor-enter(r10);
        String r11 = r18 + "_" + r19 + "_" + r20 + "_" + r21;     // Catch: Throwable -> L12
        HashMap<String, NormalTrace> r12 = normalTraceMap;     // Catch: Throwable -> L12
        NormalTrace r13 = r12.get(r11);     // Catch: Throwable -> L12
        if (r13 == null) goto L8;
        int r14 = r13.getTotalCalls() + 1;     // Catch: Throwable -> L12
        long r15 = r22 + r13.getTimeConsumption();     // Catch: Throwable -> L12
        NormalTrace.Builder r16 = NormalTrace.newBuilder().setModuleId(r18).setEventId(r19).setPackageName(r20).setAppId(r21).setUserid(0).setErrCode(0).setTotalCalls(r14).setTimeConsumption(r15).setTotalDataSize(r13.getTotalDataSize() + r24);     // Catch: Throwable -> L12
    L9:
        r12.put(r11, r16.build());     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L8:
        r16 = NormalTrace.newBuilder().setModuleId(r18).setEventId(r19).setPackageName(r20).setAppId(r21).setUserid(0).setErrCode(0).setTotalCalls(1).setTimeConsumption(r22).setTotalDataSize(r24);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public void eventReport(int r10, int r11, String r12, String r13, long r14) {
        LogUtils.d(TAG, "eventReport, module: " + r10 + ", event: " + r11 + ", pkgName: " + r12 + ", appid: " + r13 + ", timeConsumption: " + r14);
        Monitor.writeEvent(CryptoSDKInfo.newBuilder().setVersion(1).setTimestamp(System.currentTimeMillis()).addNormalTrace(NormalTrace.newBuilder().setModuleId(r10).setEventId(r11).setPackageName(r12).setAppId(r13).setUserid(0).setErrCode(0).setTotalCalls(1).setTimeConsumption(r14).setTotalDataSize(0)));
    }

    public void init() {
        String r10 = TAG;
        LogUtils.d(r10, CommonConsts.APM_INNER_EVENT_COST_INIT);
        if (this.isInit == false) goto L6;
        LogUtils.i(r10, "init already!");
        return;
    L6:
        this.mHandler = new Handler(Looper.getMainLooper());
        Runnable r11 = new AnonymousClass1(this);
        this.mTimerTask = r11;
        this.mHandler.postDelayed(r11, DELAY_TIME);
        this.isInit = true;
    }
}
