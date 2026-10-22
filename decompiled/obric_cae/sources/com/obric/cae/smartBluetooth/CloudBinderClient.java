package com.obric.cae.smartBluetooth;

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
import com.obric.cae.utils.CaeUtil;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public class CloudBinderClient {
    private static final int BIND_RETRY_INTERVAL_MS = 2000;
    private static final String TAG = "CloudBinderClient";
    private static ICloud sService;
    private CaeCloudEventCallbackWrapper mCallbackWrapper;
    private ServiceConnection mConnection;
    private Context mContext;
    private ServiceDeathRecipient mDeathRecipient;
    private Handler mHandler;
    private ReentrantReadWriteLock mServiceLock;

    public class CaeCloudEventCallbackWrapper extends ICloudEventCallback.Stub {
        final /* synthetic */ CloudBinderClient this$0;

        private CaeCloudEventCallbackWrapper(CloudBinderClient r8) {
            this.this$0 = r8;
        }

        public void addRegistration() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (CloudBinderClient.access$300() != null) goto L15;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            CloudBinderClient.access$300().registerCallbackWithType(1, this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            CaeLog.e(CloudBinderClient.access$100(), "" + e);     // Catch: Throwable -> L12
            goto L10
        }

        @Override // com.obric.cae.libs.cloud.ICloudEventCallback
        public void onCloudDataChange(String r8) {
            SmartBluetoothManager.getInstance(CloudBinderClient.access$800(this.this$0)).getCloudSyncer().onCloudDataChange(r8);
        }

        @Override // com.obric.cae.libs.cloud.ICloudEventCallback
        public void onPostStateChange(int r8, String r10, String r11) {
            SmartBluetoothManager.getInstance(CloudBinderClient.access$800(this.this$0)).getCloudSyncer().onPostStateChange(r8, r10, r11);
        }

        public void removeRegistration() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (CloudBinderClient.access$300() != null) goto L15;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            CloudBinderClient.access$300().unregisterCallback(this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            CaeLog.e(CloudBinderClient.access$100(), "" + e);     // Catch: Throwable -> L12
            goto L10
        }

        public /* synthetic */ CaeCloudEventCallbackWrapper(CloudBinderClient r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class ServiceDeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ CloudBinderClient this$0;

        private ServiceDeathRecipient(CloudBinderClient r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(ServiceDeathRecipient r8) {
            r8.lambda$binderDied$0();
        }

        private /* synthetic */ void lambda$binderDied$0() {
            CloudBinderClient.access$1000(this.this$0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CaeLog.e(CloudBinderClient.access$100(), "cae cloud service is dead !!!");
            CloudBinderClient.access$200(this.this$0).writeLock().lock();
            CloudBinderClient.access$302(null);
            CloudBinderClient.access$900(this.this$0).postDelayed(new a(this, 0), 2000);
            CloudBinderClient.access$200(this.this$0).writeLock().unlock();
        }

        public /* synthetic */ ServiceDeathRecipient(CloudBinderClient r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public CloudBinderClient(Context r8) {
        this.mServiceLock = new ReentrantReadWriteLock();
        this.mConnection = new AnonymousClass1(this);
        this.mContext = r8;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mDeathRecipient = new ServiceDeathRecipient(this, null);
        doBind();
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ void access$1000(CloudBinderClient r8) {
        r8.attemptDeadServiceRecovery();
    }

    public static /* synthetic */ ReentrantReadWriteLock access$200(CloudBinderClient r8) {
        return r8.mServiceLock;
    }

    public static /* synthetic */ ICloud access$300() {
        return sService;
    }

    public static /* synthetic */ ICloud access$302(ICloud r8) {
        sService = r8;
        return r8;
    }

    public static /* synthetic */ ServiceDeathRecipient access$400(CloudBinderClient r8) {
        return r8.mDeathRecipient;
    }

    public static /* synthetic */ CaeCloudEventCallbackWrapper access$500(CloudBinderClient r8) {
        return r8.mCallbackWrapper;
    }

    public static /* synthetic */ CaeCloudEventCallbackWrapper access$502(CloudBinderClient r8, CaeCloudEventCallbackWrapper r10) {
        r8.mCallbackWrapper = r10;
        return r10;
    }

    public static /* synthetic */ void access$700(CloudBinderClient r8) {
        r8.checkLatestIssueVersion();
    }

    public static /* synthetic */ Context access$800(CloudBinderClient r8) {
        return r8.mContext;
    }

    public static /* synthetic */ Handler access$900(CloudBinderClient r8) {
        return r8.mHandler;
    }

    private void attemptDeadServiceRecovery() {
        CaeLog.e(TAG, "Cae cloud service dead, attempting to recover");
        doBind();
    }

    private void checkLatestIssueVersion() {
        uploadLatestIssueVersion(1, CaeUtil.getLatestIssueVersion(this.mContext));
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

    public void postCaeEventToCloud(String r8) {
        ICloud r10 = sService;
        if (r10 == null) goto L11;
        r10.postToCloud(r8);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        defpackage.b.n("", e, TAG);
        return;
    }

    public void uploadLatestIssueVersion(int r8, String r10) {
        ICloud r11 = sService;
        if (r11 == null) goto L11;
        r11.updateUserConfigData(r8, r10);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        defpackage.b.n("", e, TAG);
        return;
    }
}
