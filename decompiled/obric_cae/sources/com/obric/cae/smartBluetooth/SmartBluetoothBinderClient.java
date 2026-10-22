package com.obric.cae.smartBluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.AttributionSource;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.BdimPredictEvent;
import com.obric.cae.libs.bluetooth.BtDeviceInfoExtEvent;
import com.obric.cae.libs.bluetooth.CaeBluetoothEvent;
import com.obric.cae.libs.bluetooth.ICaeBluetooth;
import com.obric.cae.libs.bluetooth.ICaeBluetoothEventCallback;
import com.obric.cae.log.CaeLog;
import com.obric.cae.utils.CaeUtil;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public class SmartBluetoothBinderClient {
    private static final int BIND_RETRY_INTERVAL_MS = 3000;
    private static final String TAG = "SmartBluetoothBinderClient";
    private static final int WRITE_LOCK_TIMEOUT_MS = 500;
    private static ServiceDeathRecipient mDeathRecipient;
    private static ICaeBluetooth sService;
    private CaeBluetoothEventCallbackWrapper mCallbackWrapper;
    private final ServiceConnection mConnection;
    private Context mContext;
    private Handler mHandler;
    private ReentrantReadWriteLock mServiceLock;

    public class CaeBluetoothEventCallbackWrapper extends ICaeBluetoothEventCallback.Stub {
        final /* synthetic */ SmartBluetoothBinderClient this$0;

        private CaeBluetoothEventCallbackWrapper(SmartBluetoothBinderClient r8) {
            this.this$0 = r8;
        }

        public void addRegistration() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (SmartBluetoothBinderClient.access$300() != null) goto L15;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            SmartBluetoothBinderClient.access$300().registerEventCallback(this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            CaeLog.e(SmartBluetoothBinderClient.access$100(), "" + e);     // Catch: Throwable -> L12
            goto L10
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetoothEventCallback
        public void onDeviceInfoEventReported(BtDeviceInfoExtEvent r8) {
            CaeLog.d(SmartBluetoothBinderClient.access$100(), "onDeviceInfoEventReported");
            SmartBluetoothEventHandler r10 = SmartBluetoothManager.getInstance(SmartBluetoothBinderClient.access$700(this.this$0)).getEventHandler();
            if (r10 == null) goto L6;
            r10.onDeviceInfoEventReported(r8);
            return;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetoothEventCallback
        public void onDeviceInfoFactorsReported(BdimPredictEvent r8) {
            CaeLog.d(SmartBluetoothBinderClient.access$100(), "onDeviceInfoFactorsReported");
            SmartBluetoothEventHandler r10 = SmartBluetoothManager.getInstance(SmartBluetoothBinderClient.access$700(this.this$0)).getEventHandler();
            if (r10 == null) goto L6;
            r10.onDeviceInfoFactorsReported(r8);
            return;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetoothEventCallback
        public void onEventReported(CaeBluetoothEvent r8) {
        }

        public void removeRegistration() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (SmartBluetoothBinderClient.access$300() != null) goto L15;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            SmartBluetoothBinderClient.access$300().unregisterEventCallback(this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            CaeLog.e(SmartBluetoothBinderClient.access$100(), "" + e);     // Catch: Throwable -> L12
            goto L10
        }

        public /* synthetic */ CaeBluetoothEventCallbackWrapper(SmartBluetoothBinderClient r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class ServiceDeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ SmartBluetoothBinderClient this$0;

        private ServiceDeathRecipient(SmartBluetoothBinderClient r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(ServiceDeathRecipient r8) {
            r8.lambda$binderDied$0();
        }

        private /* synthetic */ void lambda$binderDied$0() {
            SmartBluetoothBinderClient.access$900(this.this$0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CaeLog.e(SmartBluetoothBinderClient.access$100(), "cae bluetooth service is dead !!!");
            SmartBluetoothBinderClient.access$200(this.this$0).writeLock().tryLock(500, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L5
            SmartBluetoothBinderClient.access$302(null);     // Catch: InterruptedException -> L5
            SmartBluetoothBinderClient.access$800(this.this$0).postDelayed(new b(this, 1), 3000);     // Catch: InterruptedException -> L5
            SmartBluetoothBinderClient.access$200(this.this$0).writeLock().unlock();     // Catch: InterruptedException -> L5
            return;
        L5:
            e = move-exception;
            CaeLog.e(SmartBluetoothBinderClient.access$100(), "write interrupted", e);
        }

        public /* synthetic */ ServiceDeathRecipient(SmartBluetoothBinderClient r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public SmartBluetoothBinderClient(Context r8) {
        this.mServiceLock = new ReentrantReadWriteLock();
        this.mConnection = new AnonymousClass1(this);
        this.mContext = r8;
        this.mHandler = new Handler(Looper.getMainLooper());
        mDeathRecipient = new ServiceDeathRecipient(this, null);
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ ReentrantReadWriteLock access$200(SmartBluetoothBinderClient r8) {
        return r8.mServiceLock;
    }

    public static /* synthetic */ ICaeBluetooth access$300() {
        return sService;
    }

    public static /* synthetic */ ICaeBluetooth access$302(ICaeBluetooth r8) {
        sService = r8;
        return r8;
    }

    public static /* synthetic */ ServiceDeathRecipient access$400() {
        return mDeathRecipient;
    }

    public static /* synthetic */ CaeBluetoothEventCallbackWrapper access$500(SmartBluetoothBinderClient r8) {
        return r8.mCallbackWrapper;
    }

    public static /* synthetic */ CaeBluetoothEventCallbackWrapper access$502(SmartBluetoothBinderClient r8, CaeBluetoothEventCallbackWrapper r10) {
        r8.mCallbackWrapper = r10;
        return r10;
    }

    public static /* synthetic */ Context access$700(SmartBluetoothBinderClient r8) {
        return r8.mContext;
    }

    public static /* synthetic */ Handler access$800(SmartBluetoothBinderClient r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ void access$900(SmartBluetoothBinderClient r8) {
        r8.attemptDeadServiceRecovery();
    }

    private void attemptDeadServiceRecovery() {
        if (BluetoothAdapter.getDefaultAdapter().isEnabled() == true) goto L5;
        return;
    L5:
        CaeLog.e(TAG, "Cae bluetooth service dead, attempting to recover");
        doBind();
    }

    private void doUnbind() {
        ServiceConnection r8 = this.mConnection;
        monitor-enter(r8);
        CaeLog.d(TAG, "Unbinding cae bluetooth service...");     // Catch: Throwable -> L10
        if (sService == null) goto L7;
        this.mContext.unbindService(this.mConnection);     // Catch: Throwable -> L10
    L7:
        this.mServiceLock.writeLock().lock();     // Catch: Throwable -> L10
        sService = null;     // Catch: Throwable -> L10
        this.mServiceLock.writeLock().unlock();     // Catch: Throwable -> L10
        monitor-exit(r8);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static ICaeBluetooth getService() {
        return sService;
    }

    public void addDeviceToDatabase(String r8, BluetoothDevice r10) {
        if (sService == null) goto L12;
        if (r10 == null) goto L13;
        CaeLog.i(TAG, "addDeviceToDatabase: feature: " + r8 + ", device: " + CaeUtil.maskMacOrBssid(r10.getAddress()));     // Catch: RemoteException -> L7
        sService.addDeviceToDatabase(r8, r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        defpackage.b.n("", e, TAG);
        return;
    L13:
        return;
    }

    public void addDeviceToStaticExtDatabase(String r8, BluetoothDevice r10) {
        if (sService == null) goto L12;
        if (r10 == null) goto L13;
        CaeLog.i(TAG, "addDeviceToStaticExtDatabase: feature: " + r8 + ", device: " + CaeUtil.maskMacOrBssid(r10.getAddress()));     // Catch: RemoteException -> L7
        sService.addDeviceToStaticExtDatabase(r8, r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        defpackage.b.n("", e, TAG);
        return;
    L13:
        return;
    }

    public void close() {
        CaeLog.d(TAG, "close");
        doUnbind();
    }

    public boolean doBind() {
        ServiceConnection r8 = this.mConnection;
        monitor-enter(r8);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (sService != null) goto L17;
        String r10 = TAG;     // Catch: Throwable -> L19
        CaeLog.d(r10, "Binding cae bluetooth service...");     // Catch: Throwable -> L19
        Intent r11 = new Intent(ICaeBluetooth.class.getName());     // Catch: Throwable -> L19
        ComponentName r12 = r11.resolveSystemService(this.mContext.getPackageManager(), 0);     // Catch: Throwable -> L19
        r11.setComponent(r12);     // Catch: Throwable -> L19
        if (r12 != null) goto L9;
    L14:
        CaeLog.e(r10, "Fail to bind to: " + r11);     // Catch: Throwable -> L19
        monitor-exit(r8);     // Catch: Throwable -> L19
        return false;
    L9:
        if (this.mContext.bindService(r11, this.mConnection, 0) == false) goto L14;
        monitor-exit(r8);     // Catch: Throwable -> L19
        return true;
    L17:
        monitor-exit(r8);     // Catch: Throwable -> L19
        return false;
    }

    public BdimPredictEvent getBdimEvent(BluetoothDevice r8) {
        ICaeBluetooth r10 = sService;
        if (r10 == null) goto L13;
        if (r8 == null) goto L14;
        return r10.getBdimEvent(r8);
    L7:
        e = move-exception;
        defpackage.b.n("RemoteException occurred:", e, TAG);
        return null;
    L14:
        return null;
    L13:
        return null;
    }

    public int getProductId(BluetoothDevice r8) {
        ICaeBluetooth r10 = sService;
        if (r10 == null) goto L13;
        if (r8 == null) goto L14;
        return r10.getProductId(r8);
    L7:
        e = move-exception;
        defpackage.b.n("", e, TAG);
        return 0;
    L14:
        return 0;
    L13:
        return 0;
    }

    public void removeDeviceFromDatabase(String r8, BluetoothDevice r10) {
        if (sService == null) goto L12;
        if (r10 == null) goto L13;
        CaeLog.i(TAG, "removeDeviceFromDatabase: feature: " + r8 + ", device: " + CaeUtil.maskMacOrBssid(r10.getAddress()));     // Catch: RemoteException -> L7
        sService.removeDeviceFromDatabase(r8, r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        defpackage.b.n("", e, TAG);
        return;
    L13:
        return;
    }

    public void removeDeviceFromStaticExtDatabase(String r8, BluetoothDevice r10) {
        if (sService == null) goto L12;
        if (r10 == null) goto L13;
        CaeLog.i(TAG, "removeDeviceFromStaticExtDatabase: feature: " + r8 + ", device: " + CaeUtil.maskMacOrBssid(r10.getAddress()));     // Catch: RemoteException -> L7
        sService.removeDeviceFromStaticExtDatabase(r8, r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        defpackage.b.n("", e, TAG);
        return;
    L13:
        return;
    }

    public void requestLeConnectionPriority(int r8, AttributionSource r10) {
        ICaeBluetooth r11 = sService;
        if (r11 == null) goto L11;
        r11.requestLeConnectionPriority(r8, r10);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        defpackage.b.n("", e, TAG);
        return;
    }

    public void setAac3mPacketEnabled(boolean r8) {
        ICaeBluetooth r10 = sService;
        if (r10 == null) goto L11;
        r10.setAac3mPacketEnabled(r8);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        defpackage.b.n("", e, TAG);
        return;
    }

    public void setBqrEventState(int r8) {
        ICaeBluetooth r10 = sService;
        if (r10 == null) goto L11;
        r10.setBqrEventState(r8);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        defpackage.b.n("", e, TAG);
        return;
    }

    public void setHARStatusChanged(int r8) {
        if (CaeUtil.isBleAlwaysOnSupported(this.mContext) == true) goto L5;
        return;
    L5:
        ICaeBluetooth r10 = sService;
        if (r10 == null) goto L14;
        r10.setHARStatusChanged(r8);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        defpackage.b.n("", e, TAG);
        return;
    }

    public void setLoctionState(String r8) {
        if (CaeUtil.isBleAlwaysOnSupported(this.mContext) == true) goto L5;
        return;
    L5:
        ICaeBluetooth r10 = sService;
        if (r10 == null) goto L14;
        r10.setLocationState(r8);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        defpackage.b.n("", e, TAG);
        return;
    }

    public void setModelPredictType(BluetoothDevice r8, String r10) {
        ICaeBluetooth r11 = sService;
        if (r11 == null) goto L13;
        if (r8 == null) goto L14;
        if (r10 == null) goto L15;
        r11.setModelPredictType(r8, r10);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        defpackage.b.n("RemoteException occurred:", e, TAG);
        return;
    L15:
        return;
    L14:
        return;
    }
}
