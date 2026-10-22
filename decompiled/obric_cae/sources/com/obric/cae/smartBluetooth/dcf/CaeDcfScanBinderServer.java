package com.obric.cae.smartBluetooth.dcf;

import android.content.Context;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.CaeDcfScanResult;
import com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanCallbackExporter;
import com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter;
import com.obric.cae.log.CaeLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaeDcfScanBinderServer extends ICaeDcfScanExporter.Stub {
    private static final String CAE_BT_ACCESS_PERM = "com.obric.cae.permission.BT_CLIENT_ACCESS_PERMISSION";
    private static final String CAE_BT_ACCESS_PERM_ERROR = "BT_ACCESS permission required";
    private static final String TAG = "CaeDcfScanBinderServer";
    private final RemoteCallbackList<ICaeDcfScanCallbackExporter> mCallbacks;
    private final Context mContext;
    private boolean mDcfListenerRegistered;
    private final DcfDevicesListener mDevicesListener;

    public CaeDcfScanBinderServer(Context r8) {
        this.mCallbacks = new RemoteCallbackList();
        this.mDevicesListener = new AnonymousClass1(this);
        this.mContext = r8.getApplicationContext();
    }

    public static /* synthetic */ void access$000(CaeDcfScanBinderServer r8, List r10) {
        r8.broadcastDevices(r10);
    }

    private void broadcastDevices(List<DcfDevice> r8) {
        List<CaeDcfScanResult> r10 = toScanResults(r8);
        RemoteCallbackList<ICaeDcfScanCallbackExporter> r11 = this.mCallbacks;
        monitor-enter(r11);
        int r12 = this.mCallbacks.beginBroadcast();     // Catch: Throwable -> L19
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L16;
        ((ICaeDcfScanCallbackExporter) this.mCallbacks.getBroadcastItem(r13)).onDevicesChanged(r10);     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        r13 = r13 + 1;
    L11:
        e = move-exception;
        CaeLog.w(TAG, "broadcastDevices RemoteException: " + e.getMessage());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.mCallbacks.finishBroadcast();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L16:
        this.mCallbacks.finishBroadcast();     // Catch: Throwable -> L19
        monitor-exit(r11);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private synchronized void ensureDcfStackInitialized() {
        monitor-enter(this);
        CaeLog.i(TAG, "Init QeSDK and DCF scan manager for first scan client");     // Catch: Throwable -> L6
        QeSdkHelper.getInstance().init(this.mContext);     // Catch: Throwable -> L6
        DcfScanManager.getInstance().init(this.mContext);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private List<CaeDcfScanResult> toScanResults(List<DcfDevice> r8) {
        ArrayList r10 = new ArrayList();
        if (r8 != null) goto L5;
        return r10;
    L5:
        Iterator<DcfDevice> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        DcfDevice r12 = r11.next();
        if (r12 == null) goto L7;
        r10.add(new CaeDcfScanResult(r12.getDeviceId(), r12.getRawData(), r12.getLastUpdateTime()));
        goto L7
    L12:
        return r10;
    }

    public void cleanup() {
        RemoteCallbackList<ICaeDcfScanCallbackExporter> r8 = this.mCallbacks;
        monitor-enter(r8);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mDcfListenerRegistered == false) goto L7;
        DcfScanManager.getInstance().unregisterDcfDevicesListener(this.mDevicesListener);     // Catch: Throwable -> L10
        this.mDcfListenerRegistered = false;     // Catch: Throwable -> L10
    L7:
        this.mCallbacks.kill();     // Catch: Throwable -> L10
        monitor-exit(r8);     // Catch: Throwable -> L10
    }

    @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
    public boolean isDcfScanSupported() {
        this.mContext.enforceCallingOrSelfPermission(CAE_BT_ACCESS_PERM, CAE_BT_ACCESS_PERM_ERROR);
        ensureDcfStackInitialized();
        return QeSdkHelper.getInstance().isPlatformReady();
    }

    @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
    public void registerDcfScanCallback(ICaeDcfScanCallbackExporter r8) {
        this.mContext.enforceCallingOrSelfPermission(CAE_BT_ACCESS_PERM, CAE_BT_ACCESS_PERM_ERROR);
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "registerDcfScanCallback: callback is null");
        return;
    L6:
        RemoteCallbackList<ICaeDcfScanCallbackExporter> r10 = this.mCallbacks;
        monitor-enter(r10);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (this.mCallbacks.getRegisteredCallbackCount() != 0) goto L11;
        boolean r11 = true;
    L12:
        boolean r12 = this.mCallbacks.register(r8);     // Catch: Throwable -> L17
        CaeLog.d(TAG, "registerDcfScanCallback added=" + r12 + ", count=" + this.mCallbacks.getRegisteredCallbackCount());     // Catch: Throwable -> L17
        if (r11 == false) goto L15;
        ensureDcfStackInitialized();     // Catch: Throwable -> L17
        DcfScanManager.getInstance().registerDcfDevicesListener(this.mDevicesListener);     // Catch: Throwable -> L17
        this.mDcfListenerRegistered = true;     // Catch: Throwable -> L17
    L15:
        monitor-exit(r10);     // Catch: Throwable -> L17
        return;
    L11:
        r11 = false;
        goto L12
    }

    @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
    public void unregisterDcfScanCallback(ICaeDcfScanCallbackExporter r8) {
        this.mContext.enforceCallingOrSelfPermission(CAE_BT_ACCESS_PERM, CAE_BT_ACCESS_PERM_ERROR);
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "unregisterDcfScanCallback: callback is null");
        return;
    L6:
        RemoteCallbackList<ICaeDcfScanCallbackExporter> r10 = this.mCallbacks;
        monitor-enter(r10);
        boolean r11 = this.mCallbacks.unregister(r8);     // Catch: Throwable -> L15
        CaeLog.d(TAG, "unregisterDcfScanCallback removed=" + r11 + ", count=" + this.mCallbacks.getRegisteredCallbackCount());     // Catch: Throwable -> L15
        if (this.mCallbacks.getRegisteredCallbackCount() == 0) goto L11;
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L11:
        if (this.mDcfListenerRegistered == false) goto L13;
        DcfScanManager.getInstance().unregisterDcfDevicesListener(this.mDevicesListener);     // Catch: Throwable -> L15
        this.mDcfListenerRegistered = false;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}
