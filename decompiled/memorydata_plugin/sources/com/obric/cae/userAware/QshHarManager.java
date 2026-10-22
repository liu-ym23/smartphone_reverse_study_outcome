package com.obric.cae.userAware;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.SparseArray;
import com.obric.cae.libs.useraware.HarEventData;
import com.obric.cae.libs.useraware.HarMonitorParams;
import com.obric.cae.libs.useraware.QshHarEventData;
import com.obric.cae.libs.useraware.QshHarRuntimeParamData;
import com.obric.cae.libs.useraware.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import vendor.oak.qshhar.QshHarEventParcel;
import vendor.oak.qshhar.QshHarRuntimeParamParcel;
import vendor.oak.qshhar.QshHarWifiStandardData;
import vendor.oak.qshhar.a;

/* JADX INFO: loaded from: classes3.dex */
public class QshHarManager {
    private static final String TAG = "QshHarManager";
    private final a mBridgeListener;
    private QshHarRuntimeParamData mCurrentQshHarParam;
    private final SparseArray<RemoteCallbackList<e>> mMotionBuckets;
    private final QshHalInterface mQshHarInterface;

    public QshHarManager() {
        this.mMotionBuckets = new SparseArray();
        this.mBridgeListener = new AnonymousClass1(this);
        this.mQshHarInterface = QshHalInterface.getInstance();
    }

    public static /* synthetic */ QshHarEventData access$000(QshHarEventParcel r0) {
        return convertToAppEvent(r0);
    }

    public static /* synthetic */ void access$100(QshHarManager r0, int r1, QshHarEventData r2) {
        r0.notifyBucket(r1, r2);
    }

    private static QshHarEventData convertToAppEvent(QshHarEventParcel r3) {
        return new QshHarEventData.a().a(r3.event).a(r3.confidence).b(r3.value).b(r3.trigger_reason).c(r3.speed).d(r3.frequency).a(r3.duration_ms).b(r3.timestamp).a();
    }

    private void notifyBucket(int r7, QshHarEventData r8) {
        SparseArray<RemoteCallbackList<e>> r0 = this.mMotionBuckets;
        monitor-enter(r0);
        RemoteCallbackList r6 = (RemoteCallbackList) ZeusTransformUtils.preCheckCast(this.mMotionBuckets.get(r7), RemoteCallbackList.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        if (r6 != null) goto L8;
        return;
    L8:
        int r1 = r6.beginBroadcast();
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L19;
        ((e) ZeusTransformUtils.preCheckCast(r6.getBroadcastItem(r2), e.class, "com.obric.memorydata.plugin")).a(r8);     // Catch: RemoteException -> L13 Throwable -> L16
    L15:
        r2 = r2 + 1;
    L13:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "notify motionState=" + r7 + " failed", e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r6.finishBroadcast();
        throw th;
    L19:
        r6.finishBroadcast();
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public void clearListeners() {
        SparseArray<RemoteCallbackList<e>> r0 = this.mMotionBuckets;
        monitor-enter(r0);
        int r1 = 0;
    L17:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r1 >= this.mMotionBuckets.size()) goto L11;
        this.mQshHarInterface.unsubscribe(this.mBridgeListener, this.mMotionBuckets.keyAt(r1));     // Catch: Throwable -> L14
        RemoteCallbackList r2 = (RemoteCallbackList) ZeusTransformUtils.preCheckCast(this.mMotionBuckets.valueAt(r1), RemoteCallbackList.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r2 == null) goto L10;
        r2.kill();     // Catch: Throwable -> L14
    L10:
        r1 = r1 + 1;     // Catch: Throwable -> L14
        goto L17
    L11:
        this.mMotionBuckets.clear();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    public void configQshHarWakeupEvent(int[] r1) {
        this.mQshHarInterface.configQshHarWakeupEvent(r1);
    }

    public void configureHarMonitorParams(HarMonitorParams r1) {
        this.mQshHarInterface.configureHarMonitorParams(r1);
    }

    public void configureRuntimeEnvironment(QshHarRuntimeParamData r3) {
        if (r3 != null) goto L5;
        com.obric.cae.log.a.i(TAG, "configureRuntimeEnvironment: param is null");
        return;
    L5:
        QshHarRuntimeParamParcel r0 = new QshHarRuntimeParamParcel();
        r0.sample_rate_hz = r3.getSampleRate();
        r0.confidence_threshold = r3.getConfidenceThreshold();
        r0.power_mode = r3.getPowerMode();
        this.mQshHarInterface.configureRuntime(r0);
        this.mCurrentQshHarParam = new QshHarRuntimeParamData(r3);
    }

    public void notifyHarEvent(HarEventData r1) {
        this.mQshHarInterface.notifyHarEvent(r1);
    }

    public void sendWifiStandardData(QshHarWifiStandardData r1) {
        this.mQshHarInterface.sendWifiStandardData(r1);
    }

    public void subscribeEventListener(e r5, int r6, int r7, int r8) {
        e r9 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L6;
        com.obric.cae.log.a.i(TAG, "subscribeEventListener: listener is null");
        return;
    L6:
        SparseArray<RemoteCallbackList<e>> r0 = this.mMotionBuckets;
        monitor-enter(r0);
        RemoteCallbackList<e> r1 = (RemoteCallbackList) ZeusTransformUtils.preCheckCast(this.mMotionBuckets.get(r7), RemoteCallbackList.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r1 != null) goto L11;
        r1 = new RemoteCallbackList();     // Catch: Throwable -> L14
        this.mMotionBuckets.put(r7, r1);     // Catch: Throwable -> L14
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L14
        r1.register(r9);
        this.mQshHarInterface.subscribe(this.mBridgeListener, r6, r7, r8);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void unsubscribeEventListener(e r5, int r6) {
        e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L6;
        com.obric.cae.log.a.i(TAG, "unsubscribeEventListener: listener is null");
        return;
    L6:
        SparseArray<RemoteCallbackList<e>> r0 = this.mMotionBuckets;
        monitor-enter(r0);
        RemoteCallbackList r1 = (RemoteCallbackList) ZeusTransformUtils.preCheckCast(this.mMotionBuckets.get(r6), RemoteCallbackList.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);     // Catch: Throwable -> L25
        boolean r2 = false;
        if (r1 == null) goto L22;
        r1.unregister(r7);
        SparseArray<RemoteCallbackList<e>> r8 = this.mMotionBuckets;
        monitor-enter(r8);
        int r3 = r1.beginBroadcast();     // Catch: Throwable -> L19
        r1.finishBroadcast();     // Catch: Throwable -> L19
        if (r3 != 0) goto L17;
        r1.kill();     // Catch: Throwable -> L19
        this.mMotionBuckets.remove(r6);     // Catch: Throwable -> L19
        r2 = true;
    L17:
        monitor-exit(r8);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L22:
        if (r2 == false) goto L32;
        this.mQshHarInterface.unsubscribe(this.mBridgeListener, r6);
        return;
    L32:
        return;
    L25:
        th = move-exception;
        throw th;
    }
}
