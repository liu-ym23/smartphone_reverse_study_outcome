package com.obric.cae.smartNetwork;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.obric.cae.libs.cloud.ICloud;
import com.obric.cae.libs.cloud.ICloudEventCallback;
import com.obric.cae.log.CaeLog;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class CloudBinder {
    private static final int BIND_RETRY_INTERVAL_MS = 2000;
    private static final String TAG = "CloudBinder";
    private static ICloud sService;
    private CaeCloudEventCallbackWrapper mCallbackWrapper;
    private CloudConfigParseAndSave mCloudConfigParseAndSave;
    private ServiceConnection mConnection;
    private Context mContext;
    private ServiceDeathRecipient mDeathRecipient;
    private Handler mHandler;
    private ReentrantReadWriteLock mServiceLock;

    public class CaeCloudEventCallbackWrapper extends ICloudEventCallback.Stub {
        final /* synthetic */ CloudBinder this$0;

        private CaeCloudEventCallbackWrapper(CloudBinder r8) {
            this.this$0 = r8;
        }

        public void addRegistration() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (CloudBinder.access$300() != null) goto L15;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            CloudBinder.access$300().registerCallbackWithType(3, this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            CaeLog.e(CloudBinder.access$100(), "" + e);     // Catch: Throwable -> L12
            goto L10
        }

        @Override // com.obric.cae.libs.cloud.ICloudEventCallback
        public void onCloudDataChange(String r8) {
            CloudBinder.access$700(this.this$0).onCloudDataChange(r8);
        }

        @Override // com.obric.cae.libs.cloud.ICloudEventCallback
        public void onPostStateChange(int r8, String r10, String r11) {
        }

        public void removeRegistration() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (CloudBinder.access$300() != null) goto L15;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            CloudBinder.access$300().unregisterCallback(this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            CaeLog.e(CloudBinder.access$100(), "" + e);     // Catch: Throwable -> L12
            goto L10
        }

        public /* synthetic */ CaeCloudEventCallbackWrapper(CloudBinder r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class ServiceDeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ CloudBinder this$0;

        private ServiceDeathRecipient(CloudBinder r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(ServiceDeathRecipient r8) {
            r8.lambda$binderDied$0();
        }

        private /* synthetic */ void lambda$binderDied$0() {
            CloudBinder.access$900(this.this$0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CaeLog.e(CloudBinder.access$100(), "cae cloud service is dead !!!");
            CloudBinder.access$200(this.this$0).writeLock().lock();
            CloudBinder.access$302(null);
            CloudBinder.access$800(this.this$0).postDelayed(new a(this), 2000);
            CloudBinder.access$200(this.this$0).writeLock().unlock();
        }

        public /* synthetic */ ServiceDeathRecipient(CloudBinder r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public CloudBinder(Context r8, CloudConfigParseAndSave r10) {
        this.mServiceLock = new ReentrantReadWriteLock();
        this.mConnection = new AnonymousClass1(this);
        this.mContext = r8;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mDeathRecipient = new ServiceDeathRecipient(this, null);
        this.mCloudConfigParseAndSave = r10;
        doBind();
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ ReentrantReadWriteLock access$200(CloudBinder r8) {
        return r8.mServiceLock;
    }

    public static /* synthetic */ ICloud access$300() {
        return sService;
    }

    public static /* synthetic */ ICloud access$302(ICloud r8) {
        sService = r8;
        return r8;
    }

    public static /* synthetic */ ServiceDeathRecipient access$400(CloudBinder r8) {
        return r8.mDeathRecipient;
    }

    public static /* synthetic */ CaeCloudEventCallbackWrapper access$500(CloudBinder r8) {
        return r8.mCallbackWrapper;
    }

    public static /* synthetic */ CaeCloudEventCallbackWrapper access$502(CloudBinder r8, CaeCloudEventCallbackWrapper r10) {
        r8.mCallbackWrapper = r10;
        return r10;
    }

    public static /* synthetic */ CloudConfigParseAndSave access$700(CloudBinder r8) {
        return r8.mCloudConfigParseAndSave;
    }

    public static /* synthetic */ Handler access$800(CloudBinder r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ void access$900(CloudBinder r8) {
        r8.attemptDeadServiceRecovery();
    }

    private void attemptDeadServiceRecovery() {
        CaeLog.e(TAG, "Cae cloud service dead, attempting to recover");
        doBind();
    }

    private boolean doBind() {
        ServiceConnection r8 = this.mConnection;
        monitor-enter(r8);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (sService != null) goto L17;
        String r10 = TAG;     // Catch: Throwable -> L19
        CaeLog.d(r10, "Binding cae cloud service...");     // Catch: Throwable -> L19
        Intent r11 = new Intent(ICloud.class.getName());     // Catch: Throwable -> L19
        ComponentName r12 = r11.resolveSystemService(this.mContext.getPackageManager(), 0);     // Catch: Throwable -> L19
        r11.setComponent(r12);     // Catch: Throwable -> L19
        if (r12 != null) goto L9;
    L14:
        CaeLog.e(r10, "Fail to bind to: " + r11);     // Catch: Throwable -> L19
        monitor-exit(r8);     // Catch: Throwable -> L19
        return false;
    L9:
        if (this.mContext.bindService(r11, this.mConnection, 65) == false) goto L14;
        monitor-exit(r8);     // Catch: Throwable -> L19
        return true;
    L17:
        monitor-exit(r8);     // Catch: Throwable -> L19
        return false;
    }

    private void doUnbind() {
        ServiceConnection r8 = this.mConnection;
        monitor-enter(r8);
        CaeLog.d(TAG, "Unbinding cae cloud service...");     // Catch: Throwable -> L10
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

    public static ICloud getService() {
        return sService;
    }

    public void close() {
        CaeLog.d(TAG, "close");
        doUnbind();
    }
}
