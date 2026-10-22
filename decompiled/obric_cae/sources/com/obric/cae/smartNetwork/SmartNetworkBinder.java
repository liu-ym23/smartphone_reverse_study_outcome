package com.obric.cae.smartNetwork;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import androidx.activity.k;
import com.cae.caed.ISmartNetworkService;
import com.obric.cae.log.CaeLog;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class SmartNetworkBinder {
    private static final int BIND_RETRY_INTERVAL_MS = 2000;
    private static final long REMOTE_CALL_SLOW_THRESHOLD_MS = 1000;
    private static final String SMART_NETWORK_SERVER_NAME = "caed_smartnetwork";
    private static final String TAG = "SmartNetworkBinder";
    private static SmartNetworkBinder sInstance;
    private ServiceDeathRecipient mDeathRecipient;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private ReentrantReadWriteLock mServiceLock;
    private ISmartNetworkService mSmartNetworkService;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.SmartNetworkBinder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface AidlMethod {
        int call(ISmartNetworkService r8);
    }

    public class ServiceDeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ SmartNetworkBinder this$0;

        private ServiceDeathRecipient(SmartNetworkBinder r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(ServiceDeathRecipient r8) {
            r8.lambda$binderDied$0();
        }

        private /* synthetic */ void lambda$binderDied$0() {
            SmartNetworkBinder.access$500(this.this$0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CaeLog.e(SmartNetworkBinder.access$100(), "caed_smartnetwork service is dead !!!");
            SmartNetworkBinder.access$200(this.this$0).writeLock().lock();
            SmartNetworkBinder.access$302(this.this$0, null);
            SmartNetworkBinder.access$200(this.this$0).writeLock().unlock();
            SmartNetworkBinder.access$400(this.this$0).postDelayed(new b(this, 0), 2000);
        }

        public /* synthetic */ ServiceDeathRecipient(SmartNetworkBinder r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    private SmartNetworkBinder() {
        this.mServiceLock = new ReentrantReadWriteLock();
        HandlerThread r8 = new HandlerThread("SmartNetworkBinder");
        this.mHandlerThread = r8;
        r8.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mDeathRecipient = new ServiceDeathRecipient(this, null);
        this.mSmartNetworkService = null;
        bindService();
    }

    public static /* synthetic */ void a(SmartNetworkBinder r8) {
        r8.lambda$bindService$0();
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ ReentrantReadWriteLock access$200(SmartNetworkBinder r8) {
        return r8.mServiceLock;
    }

    public static /* synthetic */ ISmartNetworkService access$302(SmartNetworkBinder r8, ISmartNetworkService r10) {
        r8.mSmartNetworkService = r10;
        return r10;
    }

    public static /* synthetic */ Handler access$400(SmartNetworkBinder r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ void access$500(SmartNetworkBinder r8) {
        r8.bindService();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock] */
    private void bindService() {
        this.mServiceLock.writeLock().lock();
        if (this.mSmartNetworkService == null) goto L6;
        this.mServiceLock.writeLock().unlock();
        return;
    L6:
        this.mSmartNetworkService = ISmartNetworkService.Stub.H2(ServiceManager.getService(SMART_NETWORK_SERVER_NAME));
        String r8 = TAG;
        CaeLog.d(r8, "get mSmartNetworkService = " + this.mSmartNetworkService);
        if (this.mSmartNetworkService != null) goto L9;
        this.mHandler.postDelayed(new k(this, 19), 2000);
    L9:
        this.mServiceLock.writeLock().unlock();
        this.mServiceLock.readLock().lock();
        ISmartNetworkService r10 = this.mSmartNetworkService;
        if (r10 != null) goto L25;
        this.mServiceLock.readLock().unlock();
        CaeLog.e(r8, "Failed to get service");
        return;
    L25:
        r10.asBinder().linkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L15 RemoteException -> L17
    L14:
        SmartNetworkBinder this = this.mServiceLock.readLock();
        this.unlock();
        return;
    L17:
        e = move-exception;
        CaeLog.e(TAG, "Failed to register DeathRecipient", e);     // Catch: Throwable -> L15
        this.mSmartNetworkService = null;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.mServiceLock.readLock().unlock();
        throw th;
    }

    public static SmartNetworkBinder getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(SmartNetworkBinder.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SmartNetworkBinder();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SmartNetworkBinder.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private /* synthetic */ void lambda$bindService$0() {
        this.mServiceLock.writeLock().lock();
        this.mSmartNetworkService = ISmartNetworkService.Stub.H2(ServiceManager.getService(SMART_NETWORK_SERVER_NAME));
        this.mServiceLock.writeLock().unlock();
    }

    public int callRemoteMethod(AidlMethod r10) {
        long r8 = SystemClock.elapsedRealtime();
        this.mServiceLock.readLock().lock();     // Catch: Throwable -> L15 RemoteException -> L17
        ISmartNetworkService r11 = this.mSmartNetworkService;     // Catch: Throwable -> L15 RemoteException -> L17
        if (r11 == null) goto L11;
        int r12 = r10.call(r11);     // Catch: Throwable -> L15 RemoteException -> L17
        long r13 = SystemClock.elapsedRealtime() - r8;
        if (r13 <= 1000) goto L9;
        CaeLog.w(TAG, "Slow binder call to caed_smartnetwork, duration=" + r13 + "ms");
    L9:
        this.mServiceLock.readLock().unlock();
        return r12;
    L11:
        String r14 = TAG;     // Catch: Throwable -> L15 RemoteException -> L17
        CaeLog.e(r14, "mSmartNetworkService is null!!!!");     // Catch: Throwable -> L15 RemoteException -> L17
        long r15 = SystemClock.elapsedRealtime() - r8;
        if (r15 <= 1000) goto L22;
        CaeLog.w(r14, "Slow binder call to caed_smartnetwork, duration=" + r15 + "ms");
    L22:
        this.mServiceLock.readLock().unlock();
        return -1;
    L15:
        th = move-exception;
        long r16 = SystemClock.elapsedRealtime() - r8;
        if (r16 <= 1000) goto L27;
        CaeLog.w(TAG, "Slow binder call to caed_smartnetwork, duration=" + r16 + "ms");
    L27:
        this.mServiceLock.readLock().unlock();
        throw th;
    L17:
        e = move-exception;
        String r17 = TAG;     // Catch: Throwable -> L15
        CaeLog.e(r17, "Failed to SwitchNetByUid", e);     // Catch: Throwable -> L15
        long r18 = SystemClock.elapsedRealtime() - r8;
        if (r18 <= 1000) goto L22;
        CaeLog.w(r17, "Slow binder call to caed_smartnetwork, duration=" + r18 + "ms");
        goto L22
    }
}
