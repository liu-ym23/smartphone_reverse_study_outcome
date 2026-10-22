package com.obric.cae.userAware.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.WifiAwareInfoManager;
import com.obric.cae.userAware.datacollection.AwareStateListener;

/* JADX INFO: loaded from: classes2.dex */
public class LearningProgressSettingsObserver {
    private static final String LEARNING_DONE_COMPANY = "公司学习完成";
    private static final String LEARNING_DONE_HOME = "家庭学习完成";
    private static final String TAG = "LearningProgressSettingsObserver";
    private final Context mContext;
    private volatile Boolean mLastSuccess;
    private final ContentObserver mObserver;
    private volatile boolean mRegistered;
    private final ContentResolver mResolver;
    private final WifiAwareInfoManager mWifiAwareInfoManager;

    public LearningProgressSettingsObserver(Context r8, WifiAwareInfoManager r10) {
        this.mLastSuccess = null;
        this.mRegistered = false;
        Context r11 = r8.getApplicationContext();
        this.mContext = r11;
        this.mResolver = r11.getContentResolver();
        this.mWifiAwareInfoManager = r10;
        final Handler r12 = new Handler(Looper.getMainLooper());
        this.mObserver = new AnonymousClass1(this, r12);
    }

    public static /* synthetic */ void access$000(LearningProgressSettingsObserver r8) {
        r8.handleLearningProgressChanged();
    }

    private void handleLearningProgressChanged() {
        String r8 = Settings.Global.getString(this.mResolver, AwareStateListener.SETTINGS_GLOBAL_USER_LEARNING_PROGRESS);     // Catch: Throwable -> L23
        if (r8 != null) goto L7;
        r8 = "";
    L7:
        if (r8.isEmpty() == false) goto L9;
    L13:
        boolean r10 = false;
    L14:
        Boolean r11 = this.mLastSuccess;     // Catch: Throwable -> L23
        if (r11 != null) goto L17;
    L19:
        this.mLastSuccess = Boolean.valueOf(r10);     // Catch: Throwable -> L23
        CommSenseLog.i(TAG, "Learning progress update: success=" + r10 + ", len=" + r8.length());     // Catch: Throwable -> L23
        WifiAwareInfoManager r12 = this.mWifiAwareInfoManager;     // Catch: Throwable -> L23
        if (r12 == null) goto L28;
        r12.notifyLearningSuccess(r10);     // Catch: Throwable -> L23
        return;
    L28:
        return;
    L17:
        if (r11.booleanValue() != r10) goto L19;
        return;
    L9:
        if (r8.contains(LEARNING_DONE_COMPANY) == false) goto L13;
        if (r8.contains(LEARNING_DONE_HOME) == false) goto L13;
        r10 = true;
    L23:
        th = move-exception;
        CommSenseLog.e(TAG, "handleLearningProgressChanged failed", th);
    }

    public void register() {
        if (this.mRegistered == false) goto L13;
        return;
    L13:
        Uri r8 = Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_USER_LEARNING_PROGRESS);     // Catch: Throwable -> L9
        if (r8 == null) goto L11;
        this.mResolver.registerContentObserver(r8, false, this.mObserver);     // Catch: Throwable -> L9
        this.mRegistered = true;     // Catch: Throwable -> L9
    L11:
        handleLearningProgressChanged();
        return;
    L9:
        th = move-exception;
        CommSenseLog.e(TAG, "register failed", th);
        goto L11
    }

    public void unregister() {
        if (this.mRegistered == true) goto L15;
        return;
    L15:
        this.mResolver.unregisterContentObserver(this.mObserver);     // Catch: Throwable -> L8
    L7:
        this.mRegistered = false;
        return;
    L8:
        th = move-exception;
        CommSenseLog.e(TAG, "unregister failed", th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mRegistered = false;
        throw th;
    }
}
