package com.obric.cae.location.warm;

import android.content.Context;
import android.os.Build;
import com.obric.cae.log.a;
import com.obric.memorydata.plugin.R;
import com.qti.location.sdk.IZatFeatureNotSupportedException;
import com.qti.location.sdk.IZatFlpService;
import com.qti.location.sdk.IZatIllegalArgumentException;
import com.qti.location.sdk.IZatManager;
import com.qti.location.sdk.IZatServiceUnavailableException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class StarWarmModeManager {
    private static final String TAG = "StarLocation-WarmMode";
    private static volatile StarWarmModeManager sInstance;
    private final Context mContext;
    private IZatFlpService mIZatFlpService;
    private final AtomicBoolean mIsFlpServiceConnected;
    private final AtomicBoolean mIsKeepWarmSessionStarted;
    private IZatFlpService.IZatFlpSessionHandle mKeepWarmSessionHandle;
    private final IZatFlpService.IFlpLocationCallback mLocationCallback;
    private final IZatFlpService.IFlpStatusCallback mStatusCallback;

    private StarWarmModeManager(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AtomicBoolean r0 = new AtomicBoolean(false);
        this.mIsFlpServiceConnected = r0;
        this.mIsKeepWarmSessionStarted = new AtomicBoolean(false);
        this.mLocationCallback = new AnonymousClass1(this);
        this.mStatusCallback = new AnonymousClass2(this);
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        r0.set(initQcomFlpService());
    }

    public static synchronized StarWarmModeManager getInstance(Context r3) {
        monitor-enter(StarWarmModeManager.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (sInstance != null) goto L7;
        sInstance = new StarWarmModeManager(r4);     // Catch: Throwable -> L10
    L7:
        StarWarmModeManager r5 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(StarWarmModeManager.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean initQcomFlpService() {
        if (Build.VERSION.SDK_INT >= 36) goto L7;
        a.i(TAG, "initQcomFlpService failed, SDK_INT < BAKLAVA");
        return false;
    L7:
        if (ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getBoolean(ZeusTransformUtils.mapRes(R.bool.cae_supported_gnss_keep_warm_mode, "bool", "cae_supported_gnss_keep_warm_mode")) == true) goto L11;
        a.i(TAG, "cae_supported_gnss_keep_warm_mode is false");
        return false;
    L11:
        if (this.mIZatFlpService == null) goto L13;
        return true;
    L13:
        IZatManager r0 = IZatManager.getInstance(this.mContext);
        if (r0 != null) goto L23;
        a.i(TAG, "initQcomFlpService failed, mIZatManager is null");
        return false;
    L23:
        this.mIZatFlpService = r0.connectFlpService();     // Catch: IZatServiceUnavailableException -> L20
        a.c(TAG, "initQcomFlpService success");
        return true;
    L20:
        e = move-exception;
        a.a(TAG, "initQcomFlpService failed", e);
        return false;
    }

    private boolean startKeepWarmSession() {
        IZatFlpService.IzatFlpKeepWarmRequest r1 = IZatFlpService.IzatFlpRequest.getKeepWarmFlprequest();
        IZatFlpService.IZatFlpSessionHandle r2 = this.mIZatFlpService.startFlpSession(this.mLocationCallback, r1);     // Catch: RuntimeException -> L8 IZatIllegalArgumentException -> L10 IZatFeatureNotSupportedException -> L12
        this.mKeepWarmSessionHandle = r2;     // Catch: RuntimeException -> L8 IZatIllegalArgumentException -> L10 IZatFeatureNotSupportedException -> L12
        if (r2 == null) goto L19;
        r2.registerForSessionStatus(this.mStatusCallback);     // Catch: RuntimeException -> L8 IZatIllegalArgumentException -> L10 IZatFeatureNotSupportedException -> L12
        return true;
    L19:
        return false;
    L8:
        e = e;
        String r3 = "Failed to start the session !!";
    L14:
        a.a(TAG, r3, e);
        return false;
    L12:
        e = e;
        r3 = "startKeepWarmSession failed, IZatFeatureNotSupportedException";
    L10:
        e = e;
        r3 = "startKeepWarmSession failed, IZatIllegalArgumentException ";
        goto L14
    }

    private boolean stopKeepWarmSession() {
        IZatFlpService.IZatFlpSessionHandle r1 = this.mKeepWarmSessionHandle;
        if (r1 == null) goto L18;
        this.mIZatFlpService.stopFlpSession(r1);     // Catch: RuntimeException -> L7 IZatIllegalArgumentException -> L9 IZatFeatureNotSupportedException -> L11
        this.mKeepWarmSessionHandle.unregisterForSessionStatus();     // Catch: RuntimeException -> L7 IZatIllegalArgumentException -> L9 IZatFeatureNotSupportedException -> L11
        this.mKeepWarmSessionHandle = null;     // Catch: RuntimeException -> L7 IZatIllegalArgumentException -> L9 IZatFeatureNotSupportedException -> L11
        return true;
    L11:
        e = e;
        String r2 = "stopKeepWarmSession failed, IZatFeatureNotSupportedException ";
    L13:
        a.a(TAG, r2, e);
        return false;
    L9:
        e = e;
        r2 = "stopKeepWarmSession failed, IZatIllegalArgumentException ";
    L7:
        e = e;
        r2 = "Failed to stop the session !!";
        goto L13
    L18:
        return false;
    }

    public synchronized boolean setWarmMode(boolean r4) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsFlpServiceConnected.get() == true) goto L9;
        a.i(TAG, "setWarmMode failed, mIZatFlpService not connected");     // Catch: Throwable -> L21
        monitor-exit(this);
        return false;
    L9:
        if (this.mIsKeepWarmSessionStarted.get() != r4) goto L13;
        a.c(TAG, "setWarmMode failed, session status not changed");     // Catch: Throwable -> L21
        monitor-exit(this);
        return false;
    L13:
        if (r4 == false) goto L15;
        boolean r0 = startKeepWarmSession();     // Catch: Throwable -> L21
    L16:
        if (r0 == false) goto L18;
        this.mIsKeepWarmSessionStarted.set(r4);     // Catch: Throwable -> L21
    L18:
        a.c(TAG, "setWarmMode enabled: " + r4 + ", success: " + r0);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r0;
    L15:
        r0 = stopKeepWarmSession();     // Catch: Throwable -> L21
        goto L16
    }
}
