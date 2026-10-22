package com.obric.cae.smartNetwork.networkHandover;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.activity.j;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkUnswitchLimiter {
    private static final String TAG = "NetworkUnswitchLimiter";
    private static volatile NetworkUnswitchLimiter sInstance;
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final HandoverParameterManager mHandoverParameterManager;
    private boolean mIsNetworkUnswitchLimited;

    private NetworkUnswitchLimiter(Context r8) {
        this.mIsNetworkUnswitchLimited = false;
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        HandlerThread r11 = new HandlerThread(TAG);
        this.mHandlerThread = r11;
        r11.start();
        this.mHandler = new Handler(r11.getLooper());
        this.mHandoverParameterManager = HandoverParameterManager.getInstance(r10);
    }

    public static /* synthetic */ void a(NetworkUnswitchLimiter r8) {
        r8.lambda$notifyNetworkSwitch$0();
    }

    public static NetworkUnswitchLimiter getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(NetworkUnswitchLimiter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NetworkUnswitchLimiter(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkUnswitchLimiter.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private /* synthetic */ void lambda$notifyNetworkSwitch$0() {
        this.mIsNetworkUnswitchLimited = false;
    }

    public boolean isNetworkUnswitchLimited() {
        return this.mIsNetworkUnswitchLimited;
    }

    public void notifyNetworkSwitch() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mIsNetworkUnswitchLimited = true;
        this.mHandler.postDelayed(new j(this, 24), this.mHandoverParameterManager.getUnswitchDelayTimeout());
    }
}
