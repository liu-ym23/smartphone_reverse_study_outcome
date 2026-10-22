package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class MultiInstanceInvalidationClient {
    final Context mAppContext;
    final IMultiInstanceInvalidationCallback mCallback;
    int mClientId;
    final Executor mExecutor;
    final InvalidationTracker mInvalidationTracker;
    final String mName;
    final InvalidationTracker$Observer mObserver;
    final Runnable mRemoveObserverRunnable;
    IMultiInstanceInvalidationService mService;
    final ServiceConnection mServiceConnection;
    final Runnable mSetUpRunnable;
    final AtomicBoolean mStopped;

    public void stop() {
        if (this.mStopped.compareAndSet(false, true) == false) goto L13;
        this.mInvalidationTracker.removeObserver(this.mObserver);
        IMultiInstanceInvalidationService r0 = this.mService;     // Catch: RemoteException -> L10
        if (r0 == null) goto L8;
        r0.unregisterCallback(this.mCallback, this.mClientId);     // Catch: RemoteException -> L10
    L8:
        this.mAppContext.unbindService(this.mServiceConnection);
        return;
    }

    public MultiInstanceInvalidationClient(Context r4, String r5, Intent r6, InvalidationTracker r7, Executor r8) {
        this.mCallback = new 1(this);
        this.mStopped = new AtomicBoolean(false);
        2 r0 = new 2(this);
        this.mServiceConnection = r0;
        this.mSetUpRunnable = new 3(this);
        this.mRemoveObserverRunnable = new 4(this);
        Context r9 = r4.getApplicationContext();
        this.mAppContext = r9;
        this.mName = r5;
        this.mInvalidationTracker = r7;
        this.mExecutor = r8;
        this.mObserver = new 5(this, (String[]) r7.mTableIdLookup.keySet().toArray(new String[0]));
        r9.bindService(r6, r0, 1);
    }
}
