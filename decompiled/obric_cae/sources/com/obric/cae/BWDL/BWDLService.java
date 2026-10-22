package com.obric.cae.BWDL;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.utils.ALogUtil;
import com.sdk.bwdl.ExternalAPI.BWDLManager;

/* JADX INFO: loaded from: classes.dex */
public class BWDLService extends Service {
    private static final String TAG = "BWDLService";
    private BWDLManager mBWDLManager;
    private BwdlDropManager mBwdlDropManager;
    private Context mContext;
    private Handler mainHandler;

    public BWDLService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r8) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.app.Service
    public void onCreate() {
        CaeLog.d(TAG, "onCreate");
        this.mainHandler = new Handler(Looper.myLooper());
        this.mContext = this;
        ALogUtil.initAlogAsync(getApplicationContext());
        this.mBWDLManager = BWDLManager.getInstance(this.mContext);
        this.mBwdlDropManager = BwdlDropManager.getInstance(this.mContext);
    }

    @Override // android.app.Service
    public void onDestroy() {
        CaeLog.d(TAG, "onDestroy");
        super.onDestroy();
        BwdlDropManager r8 = this.mBwdlDropManager;
        if (r8 == null) goto L5;
        r8.exit();
    L5:
        this.mBWDLManager.exit();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r8, int r10, int r11) {
        return super.onStartCommand(r8, r10, r11);
    }
}
