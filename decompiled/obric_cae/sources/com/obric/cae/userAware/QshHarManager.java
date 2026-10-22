package com.obric.cae.userAware;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.SparseArray;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.cae.libs.useraware.HarEventData;
import com.obric.cae.libs.useraware.HarMonitorParams;
import com.obric.cae.libs.useraware.IQshHarEventCallback;
import com.obric.cae.libs.useraware.QshHarEventData;
import com.obric.cae.libs.useraware.QshHarRuntimeParamData;
import com.obric.cae.log.CommSenseLog;
import vendor.oak.qshhar.IQshHarEventListener;
import vendor.oak.qshhar.QshHarEventParcel;
import vendor.oak.qshhar.QshHarRuntimeParamParcel;
import vendor.oak.qshhar.QshHarWifiStandardData;

/* JADX INFO: loaded from: classes2.dex */
public class QshHarManager {
    private static final String TAG = "QshHarManager";
    private final IQshHarEventListener mBridgeListener;
    private QshHarRuntimeParamData mCurrentQshHarParam;
    private final SparseArray<RemoteCallbackList<IQshHarEventCallback>> mMotionBuckets;
    private final QshHalInterface mQshHarInterface;

    public QshHarManager() {
        this.mMotionBuckets = new SparseArray();
        this.mBridgeListener = new AnonymousClass1(this);
        this.mQshHarInterface = QshHalInterface.getInstance();
    }

    public static /* synthetic */ QshHarEventData access$000(QshHarEventParcel r8) {
        return convertToAppEvent(r8);
    }

    public static /* synthetic */ void access$100(QshHarManager r8, int r10, QshHarEventData r11) {
        r8.notifyBucket(r10, r11);
    }

    private static QshHarEventData convertToAppEvent(QshHarEventParcel r8) {
        return new QshHarEventData.Builder().setEvent(r8.f12926a).setConfidence(r8.f12927b).setValue(r8.f12928m).setTriggerReason(r8.f12929n).setSpeed(r8.f12930o).setFrequency(r8.f12931p).setDurationMs(r8.f12932q).setTimestamp(r8.f12933r).build();
    }

    private void notifyBucket(int r8, QshHarEventData r10) {
        SparseArray<RemoteCallbackList<IQshHarEventCallback>> r11 = this.mMotionBuckets;
        monitor-enter(r11);
        RemoteCallbackList<IQshHarEventCallback> r12 = this.mMotionBuckets.get(r8);     // Catch: Throwable -> L21
        monitor-exit(r11);     // Catch: Throwable -> L21
        if (r12 != null) goto L8;
        return;
    L8:
        int r13 = r12.beginBroadcast();
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L19;
        ((IQshHarEventCallback) r12.getBroadcastItem(r14)).onRecvQshHarEvent(r10);     // Catch: RemoteException -> L13 Throwable -> L16
    L15:
        r14 = r14 + 1;
    L13:
        e = move-exception;
        CommSenseLog.e(TAG, "notify motionState=" + r8 + " failed", e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r12.finishBroadcast();
        throw th;
    L19:
        r12.finishBroadcast();
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public void clearListeners() {
        SparseArray<RemoteCallbackList<IQshHarEventCallback>> r8 = this.mMotionBuckets;
        monitor-enter(r8);
        int r10 = 0;
    L17:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r10 >= this.mMotionBuckets.size()) goto L11;
        this.mQshHarInterface.unsubscribe(this.mBridgeListener, this.mMotionBuckets.keyAt(r10));     // Catch: Throwable -> L14
        RemoteCallbackList<IQshHarEventCallback> r11 = this.mMotionBuckets.valueAt(r10);     // Catch: Throwable -> L14
        if (r11 == null) goto L10;
        r11.kill();     // Catch: Throwable -> L14
    L10:
        r10 = r10 + 1;     // Catch: Throwable -> L14
        goto L17
    L11:
        this.mMotionBuckets.clear();     // Catch: Throwable -> L14
        monitor-exit(r8);     // Catch: Throwable -> L14
    }

    public void configQshHarWakeupEvent(@ApWakeEvent int[] r8) {
        this.mQshHarInterface.configQshHarWakeupEvent(r8);
    }

    public void configureHarMonitorParams(HarMonitorParams r8) {
        this.mQshHarInterface.configureHarMonitorParams(r8);
    }

    public void configureRuntimeEnvironment(QshHarRuntimeParamData r8) {
        if (r8 != null) goto L5;
        CommSenseLog.e(TAG, "configureRuntimeEnvironment: param is null");
        return;
    L5:
        QshHarRuntimeParamParcel r10 = new QshHarRuntimeParamParcel();
        r10.f12934a = r8.getSampleRate();
        r10.f12935b = r8.getConfidenceThreshold();
        r10.f12936m = r8.getPowerMode();
        this.mQshHarInterface.configureRuntime(r10);
        this.mCurrentQshHarParam = new QshHarRuntimeParamData(r8);
    }

    public void notifyHarEvent(HarEventData r8) {
        this.mQshHarInterface.notifyHarEvent(r8);
    }

    public void sendWifiStandardData(QshHarWifiStandardData r8) {
        this.mQshHarInterface.sendWifiStandardData(r8);
    }

    public void subscribeEventListener(IQshHarEventCallback r8, int r10, int r11, int r12) {
        if (r8 != null) goto L5;
        CommSenseLog.e(TAG, "subscribeEventListener: listener is null");
        return;
    L5:
        SparseArray<RemoteCallbackList<IQshHarEventCallback>> r13 = this.mMotionBuckets;
        monitor-enter(r13);
        RemoteCallbackList<IQshHarEventCallback> r14 = this.mMotionBuckets.get(r11);     // Catch: Throwable -> L13
        if (r14 != null) goto L10;
        r14 = new RemoteCallbackList();     // Catch: Throwable -> L13
        this.mMotionBuckets.put(r11, r14);     // Catch: Throwable -> L13
    L10:
        monitor-exit(r13);     // Catch: Throwable -> L13
        r14.register(r8);
        this.mQshHarInterface.subscribe(this.mBridgeListener, r10, r11, r12);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void unsubscribeEventListener(IQshHarEventCallback r8, int r10) {
        if (r8 != null) goto L5;
        CommSenseLog.e(TAG, "unsubscribeEventListener: listener is null");
        return;
    L5:
        SparseArray<RemoteCallbackList<IQshHarEventCallback>> r11 = this.mMotionBuckets;
        monitor-enter(r11);
        RemoteCallbackList<IQshHarEventCallback> r12 = this.mMotionBuckets.get(r10);     // Catch: Throwable -> L24
        monitor-exit(r11);     // Catch: Throwable -> L24
        boolean r13 = false;
        if (r12 == null) goto L21;
        r12.unregister(r8);
        SparseArray<RemoteCallbackList<IQshHarEventCallback>> r14 = this.mMotionBuckets;
        monitor-enter(r14);
        int r15 = r12.beginBroadcast();     // Catch: Throwable -> L18
        r12.finishBroadcast();     // Catch: Throwable -> L18
        if (r15 != 0) goto L16;
        r12.kill();     // Catch: Throwable -> L18
        this.mMotionBuckets.remove(r10);     // Catch: Throwable -> L18
        r13 = true;
    L16:
        monitor-exit(r14);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L21:
        if (r13 == false) goto L31;
        this.mQshHarInterface.unsubscribe(this.mBridgeListener, r10);
        return;
    L31:
        return;
    L24:
        th = move-exception;
        throw th;
    }
}
