package com.obric.cae.location.warm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.obric.cae.commonsense.R;
import com.obric.cae.log.CommSenseLog;
import com.qti.location.sdk.IZatFeatureNotSupportedException;
import com.qti.location.sdk.IZatFlpService;
import com.qti.location.sdk.IZatIllegalArgumentException;
import com.qti.location.sdk.IZatManager;
import com.qti.location.sdk.IZatServiceUnavailableException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class StarWarmModeManager {
    private static final String TAG = "StarLocation-WarmMode";

    @SuppressLint({"StaticFieldLeak"})
    private static volatile StarWarmModeManager sInstance;
    private final Context mContext;
    private IZatFlpService mIZatFlpService;
    private final AtomicBoolean mIsFlpServiceConnected;
    private final AtomicBoolean mIsKeepWarmSessionStarted;
    private IZatFlpService.IZatFlpSessionHandle mKeepWarmSessionHandle;
    private final IZatFlpService.IFlpLocationCallback mLocationCallback;
    private final IZatFlpService.IFlpStatusCallback mStatusCallback;

    private StarWarmModeManager(Context r8) {
        AtomicBoolean r10 = new AtomicBoolean(false);
        this.mIsFlpServiceConnected = r10;
        this.mIsKeepWarmSessionStarted = new AtomicBoolean(false);
        this.mLocationCallback = new AnonymousClass1(this);
        this.mStatusCallback = new AnonymousClass2(this);
        this.mContext = r8.getApplicationContext();
        r10.set(initQcomFlpService());
    }

    public static synchronized StarWarmModeManager getInstance(Context r8) {
        monitor-enter(StarWarmModeManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new StarWarmModeManager(r8);     // Catch: Throwable -> L10
    L7:
        StarWarmModeManager r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(StarWarmModeManager.class);
        return r10;
    }

    private boolean initQcomFlpService() {
        if (Build.VERSION.SDK_INT >= 36) goto L7;
        CommSenseLog.e(TAG, "initQcomFlpService failed, SDK_INT < BAKLAVA");
        return false;
    L7:
        if (this.mContext.getResources().getBoolean(R.bool.cae_supported_gnss_keep_warm_mode) == true) goto L11;
        CommSenseLog.e(TAG, "cae_supported_gnss_keep_warm_mode is false");
        return false;
    L11:
        if (this.mIZatFlpService == null) goto L13;
        return true;
    L13:
        IZatManager r8 = IZatManager.getInstance(this.mContext);
        if (r8 != null) goto L23;
        CommSenseLog.e(TAG, "initQcomFlpService failed, mIZatManager is null");
        return false;
    L23:
        this.mIZatFlpService = r8.connectFlpService();     // Catch: IZatServiceUnavailableException -> L20
        CommSenseLog.d(TAG, "initQcomFlpService success");
        return true;
    L20:
        e = move-exception;
        CommSenseLog.e(TAG, "initQcomFlpService failed", e);
        return false;
    }

    private boolean startKeepWarmSession() {
        IZatFlpService.IzatFlpKeepWarmRequest r8 = IZatFlpService.IzatFlpRequest.getKeepWarmFlprequest();
        IZatFlpService.IZatFlpSessionHandle r10 = this.mIZatFlpService.startFlpSession(this.mLocationCallback, r8);     // Catch: RuntimeException -> L8 IZatIllegalArgumentException -> L10 IZatFeatureNotSupportedException -> L12
        this.mKeepWarmSessionHandle = r10;     // Catch: RuntimeException -> L8 IZatIllegalArgumentException -> L10 IZatFeatureNotSupportedException -> L12
        if (r10 == null) goto L19;
        r10.registerForSessionStatus(this.mStatusCallback);     // Catch: RuntimeException -> L8 IZatIllegalArgumentException -> L10 IZatFeatureNotSupportedException -> L12
        return true;
    L19:
        return false;
    L8:
        e = e;
        String r11 = "Failed to start the session !!";
    L14:
        CommSenseLog.e(TAG, r11, e);
        return false;
    L12:
        e = e;
        r11 = "startKeepWarmSession failed, IZatFeatureNotSupportedException";
    L10:
        e = e;
        r11 = "startKeepWarmSession failed, IZatIllegalArgumentException ";
        goto L14
    }

    private boolean stopKeepWarmSession() {
        IZatFlpService.IZatFlpSessionHandle r8 = this.mKeepWarmSessionHandle;
        if (r8 == null) goto L18;
        this.mIZatFlpService.stopFlpSession(r8);     // Catch: RuntimeException -> L7 IZatIllegalArgumentException -> L9 IZatFeatureNotSupportedException -> L11
        this.mKeepWarmSessionHandle.unregisterForSessionStatus();     // Catch: RuntimeException -> L7 IZatIllegalArgumentException -> L9 IZatFeatureNotSupportedException -> L11
        this.mKeepWarmSessionHandle = null;     // Catch: RuntimeException -> L7 IZatIllegalArgumentException -> L9 IZatFeatureNotSupportedException -> L11
        return true;
    L11:
        e = e;
        String r10 = "stopKeepWarmSession failed, IZatFeatureNotSupportedException ";
    L13:
        CommSenseLog.e(TAG, r10, e);
        return false;
    L9:
        e = e;
        r10 = "stopKeepWarmSession failed, IZatIllegalArgumentException ";
    L7:
        e = e;
        r10 = "Failed to stop the session !!";
        goto L13
    L18:
        return false;
    }

    public synchronized boolean setWarmMode(boolean r8) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsFlpServiceConnected.get() == true) goto L10;
        CommSenseLog.e(TAG, "setWarmMode failed, mIZatFlpService not connected");     // Catch: Throwable -> L22
        monitor-exit(this);
        return false;
    L10:
        if (this.mIsKeepWarmSessionStarted.get() != r8) goto L14;
        CommSenseLog.d(TAG, "setWarmMode failed, session status not changed");     // Catch: Throwable -> L22
        monitor-exit(this);
        return false;
    L14:
        if (r8 == false) goto L16;
        boolean r10 = startKeepWarmSession();     // Catch: Throwable -> L22
    L17:
        if (r10 == false) goto L19;
        this.mIsKeepWarmSessionStarted.set(r8);     // Catch: Throwable -> L22
    L19:
        CommSenseLog.d(TAG, "setWarmMode enabled: " + r8 + ", success: " + r10);     // Catch: Throwable -> L22
        monitor-exit(this);
        return r10;
    L16:
        r10 = stopKeepWarmSession();     // Catch: Throwable -> L22
        goto L17
    }
}
