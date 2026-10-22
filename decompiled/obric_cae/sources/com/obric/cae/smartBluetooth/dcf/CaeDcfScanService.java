package com.obric.cae.smartBluetooth.dcf;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes.dex */
public final class CaeDcfScanService extends Service {
    private static final String TAG = "CaeDcfScanService";
    private CaeDcfScanBinderServer mBinder;

    public CaeDcfScanService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r8) {
        String r10 = TAG;
        StringBuilder r11 = new StringBuilder("onBind: ");
        if (r8 == null) goto L5;
        String r12 = r8.getAction();
    L6:
        android.aimedia.a.r(r11, r12, r10);
        return this.mBinder;
    L5:
        r12 = "null";
        goto L6
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        CaeLog.i(TAG, "onCreate: create DCF scan binder");
        this.mBinder = new CaeDcfScanBinderServer(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        CaeLog.i(TAG, "onDestroy");
        CaeDcfScanBinderServer r8 = this.mBinder;
        if (r8 == null) goto L5;
        r8.cleanup();
        this.mBinder = null;
    L5:
        super.onDestroy();
    }
}
