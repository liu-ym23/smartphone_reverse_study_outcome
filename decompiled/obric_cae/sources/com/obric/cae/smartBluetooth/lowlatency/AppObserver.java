package com.obric.cae.smartBluetooth.lowlatency;

import android.app.ActivityManager;
import android.app.IActivityManagerExt;
import android.app.IObricObserver;
import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppObserver {
    private static final String TAG = "AppObserver";
    private IActivityManagerExt mIActivityManagerExt;
    private final ObricObServerWrapper mObricObServerWrapper;
    private ProcessStateCallback mProcessStateCallback;

    /* JADX INFO: renamed from: com.obric.cae.smartBluetooth.lowlatency.AppObserver$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class ObricObServerWrapper extends IObricObserver.Stub {
        final /* synthetic */ AppObserver this$0;

        private ObricObServerWrapper(AppObserver r8) {
            this.this$0 = r8;
        }

        public void onProcessDied(String r8, int r10, int r11) {
            if (AppObserver.access$100(this.this$0) == null) goto L6;
            AppObserver.access$100(this.this$0).onProcessDied(r8, r10, r11);
            return;
        }

        public void onProcessStart(String r8, int r10, int r11) {
            if (AppObserver.access$100(this.this$0) == null) goto L6;
            AppObserver.access$100(this.this$0).onProcessStart(r8, r10, r11);
            return;
        }

        public /* synthetic */ ObricObServerWrapper(AppObserver r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public AppObserver(Context r8) {
        this.mIActivityManagerExt = null;
        this.mObricObServerWrapper = new ObricObServerWrapper(this, null);
        ActivityManager r10 = (ActivityManager) r8.getSystemService("activity");     // Catch: RemoteException -> L5
        this.mIActivityManagerExt = ActivityManager.getService().getIExt();     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Log.d(TAG, "" + e);
    }

    public static /* synthetic */ ProcessStateCallback access$100(AppObserver r8) {
        return r8.mProcessStateCallback;
    }

    public void registerObserver(List<String> r8, ProcessStateCallback r10) {
        IActivityManagerExt r11 = this.mIActivityManagerExt;     // Catch: RemoteException -> L8
        if (r11 == null) goto L13;
        ObricObServerWrapper r12 = this.mObricObServerWrapper;     // Catch: RemoteException -> L8
        if (r12 == null) goto L14;
        this.mProcessStateCallback = r10;     // Catch: RemoteException -> L8
        r11.registerObricObserver(r12, r8);     // Catch: RemoteException -> L8
        return;
    L14:
        return;
    L13:
        return;
    L8:
        e = move-exception;
        Log.d(TAG, "" + e);
    }

    public void unregisterObserver() {
        IActivityManagerExt r8 = this.mIActivityManagerExt;     // Catch: RemoteException -> L8
        if (r8 == null) goto L13;
        ObricObServerWrapper r10 = this.mObricObServerWrapper;     // Catch: RemoteException -> L8
        if (r10 == null) goto L14;
        this.mProcessStateCallback = null;     // Catch: RemoteException -> L8
        r8.unregisterObricObserver(r10);     // Catch: RemoteException -> L8
        return;
    L14:
        return;
    L13:
        return;
    L8:
        e = move-exception;
        Log.d(TAG, "" + e);
    }
}
