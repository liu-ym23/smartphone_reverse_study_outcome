package com.obric.cae.smartBluetooth;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.IBleAlwaysOn;
import com.obric.cae.libs.bluetooth.IBleAlwaysOnCallback;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.btaware.SmartBluetoothAwareManager;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public class SmartBleAlwaysOnBinderClient {
    private static final int BIND_RETRY_INTERVAL_MS = 2000;
    private static final int MSG_WAKE_LOCK_TIME_OUT = 1;
    private static final String TAG = "SmartBleAlwaysOnBinderClient";
    private static final int WRITE_LOCK_TIMEOUT_MS = 500;
    private static ServiceDeathRecipient mDeathRecipient;
    private static IBleAlwaysOn sService;
    private BleAlwaysOnCallbackWrapper mCallbackWrapper;
    private final ServiceConnection mConnection;
    private Context mContext;
    private Handler mHandler;
    private ReentrantReadWriteLock mServiceLock;

    public class BleAlwaysOnCallbackWrapper extends IBleAlwaysOnCallback.Stub {
        final /* synthetic */ SmartBleAlwaysOnBinderClient this$0;

        private BleAlwaysOnCallbackWrapper(SmartBleAlwaysOnBinderClient r8) {
            this.this$0 = r8;
        }

        public void addRegistration() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (SmartBleAlwaysOnBinderClient.access$200() != null) goto L15;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            SmartBleAlwaysOnBinderClient.access$200().registerEventCallback(this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            CaeLog.e(SmartBleAlwaysOnBinderClient.access$000(), "" + e);     // Catch: Throwable -> L12
            goto L10
        }

        @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOnCallback
        public void onEventReported(Bundle r8) {
            CaeLog.d(SmartBleAlwaysOnBinderClient.access$000(), "onEventReported, data is " + r8);
            if (r8 != null) goto L5;
            return;
        L5:
            SmartBluetoothAwareManager.getInstance(SmartBleAlwaysOnBinderClient.access$900(this.this$0)).onEventReported(r8);
        }

        public void removeRegistration() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (SmartBleAlwaysOnBinderClient.access$200() != null) goto L15;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            SmartBleAlwaysOnBinderClient.access$200().unregisterEventCallback(this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            CaeLog.e(SmartBleAlwaysOnBinderClient.access$000(), "" + e);     // Catch: Throwable -> L12
            goto L10
        }

        public /* synthetic */ BleAlwaysOnCallbackWrapper(SmartBleAlwaysOnBinderClient r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class ServiceDeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ SmartBleAlwaysOnBinderClient this$0;

        private ServiceDeathRecipient(SmartBleAlwaysOnBinderClient r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(ServiceDeathRecipient r8) {
            r8.lambda$binderDied$0();
        }

        public static /* synthetic */ void b(ServiceDeathRecipient r8) {
            r8.lambda$binderDied$2();
        }

        public static /* synthetic */ void c(ServiceDeathRecipient r8) {
            r8.lambda$binderDied$1();
        }

        private /* synthetic */ void lambda$binderDied$0() {
            SmartBleAlwaysOnBinderClient.access$700(this.this$0);
        }

        private /* synthetic */ void lambda$binderDied$1() {
            SmartBleAlwaysOnBinderClient.access$700(this.this$0);
        }

        private /* synthetic */ void lambda$binderDied$2() {
            SmartBleAlwaysOnBinderClient.access$700(this.this$0);
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x007a: MOVE (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:23:0x007a */
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CaeLog.e(SmartBleAlwaysOnBinderClient.access$000(), "BleAlwaysOn service is dead !!!");
            int r8 = 0;
            boolean r10 = SmartBleAlwaysOnBinderClient.access$100(this.this$0).writeLock().tryLock(500, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L14 InterruptedException -> L16
            if (r10 == true) goto L6;
            CaeLog.e(SmartBleAlwaysOnBinderClient.access$000(), "Failed to acquire write lock in binderDied");     // Catch: InterruptedException -> L12 Throwable -> L22
            Handler r11 = SmartBleAlwaysOnBinderClient.access$600(this.this$0);     // Catch: InterruptedException -> L12 Throwable -> L22
            Runnable r12 = new a(this, 1);     // Catch: InterruptedException -> L12 Throwable -> L22
        L7:
            r11.postDelayed(r12, 2000);     // Catch: InterruptedException -> L12 Throwable -> L22
            if (r10 == false) goto L31;
        L20:
            SmartBleAlwaysOnBinderClient.access$100(this.this$0).writeLock().unlock();
            return;
        L31:
            return;
        L6:
            SmartBleAlwaysOnBinderClient.access$202(null);     // Catch: InterruptedException -> L12 Throwable -> L22
            r11 = SmartBleAlwaysOnBinderClient.access$600(this.this$0);     // Catch: InterruptedException -> L12 Throwable -> L22
            r12 = new b(this, r8);     // Catch: InterruptedException -> L12 Throwable -> L22
        L12:
            e = e;
        L18:
            CaeLog.e(SmartBleAlwaysOnBinderClient.access$000(), "write interrupted", e);     // Catch: Throwable -> L22
            SmartBleAlwaysOnBinderClient.access$600(this.this$0).postDelayed(new c(this, r8), 2000);     // Catch: Throwable -> L22
            if (r10 == true) goto L20;
            return;
        L22:
            th = th;
            r8 = r3;
        L24:
            if (r8 == 0) goto L26;
            SmartBleAlwaysOnBinderClient.access$100(this.this$0).writeLock().unlock();
        L26:
            throw th;
        L16:
            e = e;
            r10 = false;
        L14:
            th = th;
            goto L24
        }

        public /* synthetic */ ServiceDeathRecipient(SmartBleAlwaysOnBinderClient r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public SmartBleAlwaysOnBinderClient(Context r8) {
        this.mServiceLock = new ReentrantReadWriteLock();
        this.mConnection = new AnonymousClass1(this);
        this.mContext = r8;
        this.mHandler = new Handler(Looper.getMainLooper());
        mDeathRecipient = new ServiceDeathRecipient(this, null);
    }

    public static /* synthetic */ void a(SmartBleAlwaysOnBinderClient r8) {
        r8.lambda$setWakeLockState$0();
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ ReentrantReadWriteLock access$100(SmartBleAlwaysOnBinderClient r8) {
        return r8.mServiceLock;
    }

    public static /* synthetic */ IBleAlwaysOn access$200() {
        return sService;
    }

    public static /* synthetic */ IBleAlwaysOn access$202(IBleAlwaysOn r8) {
        sService = r8;
        return r8;
    }

    public static /* synthetic */ BleAlwaysOnCallbackWrapper access$300(SmartBleAlwaysOnBinderClient r8) {
        return r8.mCallbackWrapper;
    }

    public static /* synthetic */ BleAlwaysOnCallbackWrapper access$302(SmartBleAlwaysOnBinderClient r8, BleAlwaysOnCallbackWrapper r10) {
        r8.mCallbackWrapper = r10;
        return r10;
    }

    public static /* synthetic */ ServiceDeathRecipient access$500() {
        return mDeathRecipient;
    }

    public static /* synthetic */ Handler access$600(SmartBleAlwaysOnBinderClient r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ void access$700(SmartBleAlwaysOnBinderClient r8) {
        r8.attemptDeadServiceRecovery();
    }

    public static /* synthetic */ Context access$900(SmartBleAlwaysOnBinderClient r8) {
        return r8.mContext;
    }

    private void attemptDeadServiceRecovery() {
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

    public static IBleAlwaysOn getService() {
        return sService;
    }

    private /* synthetic */ void lambda$setWakeLockState$0() {
        setWakeLockState(false, 0);
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
        CaeLog.d(r10, "Binding BleAlwaysOn bluetooth service...");     // Catch: Throwable -> L19
        Intent r11 = new Intent(IBleAlwaysOn.class.getName());     // Catch: Throwable -> L19
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

    public void setWakeLockState(boolean r8, int r10) {
        CaeLog.e(TAG, "setWakeLockState, lockState is " + r8 + " timeout " + r10);
        if (sService != null) goto L5;
        return;
    L5:
        if (r8 == false) goto L16;
        if (r10 <= 0) goto L16;
        int r11 = 1;
        if (this.mHandler.hasMessages(1) == false) goto L10;
        this.mHandler.removeMessages(1);
    L10:
        this.mHandler.postDelayed(new c(this, r11), r10);
    L16:
        sService.setCaeWakeLockState(r8);     // Catch: RemoteException -> L13
        return;
    L13:
        e = move-exception;
        CaeLog.d(TAG, "setWakeLockState RemoteException " + e);
    }
}
