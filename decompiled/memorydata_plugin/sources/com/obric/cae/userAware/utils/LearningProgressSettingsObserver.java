package com.obric.cae.userAware.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.obric.cae.log.a;
import com.obric.cae.userAware.WifiAwareInfoManager;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
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

    public LearningProgressSettingsObserver(Context r3, WifiAwareInfoManager r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mLastSuccess = null;
        this.mRegistered = false;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mResolver = r6.getContentResolver();
        this.mWifiAwareInfoManager = r4;
        final Handler r7 = new Handler(Looper.getMainLooper());
        this.mObserver = new AnonymousClass1(this, r7);
    }

    public static /* synthetic */ void access$000(LearningProgressSettingsObserver r0) {
        r0.handleLearningProgressChanged();
    }

    private void handleLearningProgressChanged() {
        String r1 = UserAwareUtil.getHostSettingsString(this.mContext, this.mResolver, AwareStateListener.SETTINGS_GLOBAL_USER_LEARNING_PROGRESS);     // Catch: Throwable -> L23
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        if (r1.isEmpty() == false) goto L9;
    L13:
        boolean r2 = false;
    L14:
        Boolean r3 = this.mLastSuccess;     // Catch: Throwable -> L23
        if (r3 != null) goto L17;
    L19:
        this.mLastSuccess = Boolean.valueOf(r2);     // Catch: Throwable -> L23
        a.e(TAG, "Learning progress update: success=" + r2 + ", len=" + r1.length());     // Catch: Throwable -> L23
        WifiAwareInfoManager r5 = this.mWifiAwareInfoManager;     // Catch: Throwable -> L23
        if (r5 == null) goto L28;
        r5.notifyLearningSuccess(r2);     // Catch: Throwable -> L23
        return;
    L28:
        return;
    L17:
        if (r3.booleanValue() != r2) goto L19;
        return;
    L9:
        if (r1.contains(LEARNING_DONE_COMPANY) == false) goto L13;
        if (r1.contains(LEARNING_DONE_HOME) == false) goto L13;
        r2 = true;
    L23:
        th = move-exception;
        a.a(TAG, "handleLearningProgressChanged failed", th);
    }

    public void register() {
        if (this.mRegistered == false) goto L13;
        return;
    L13:
        Uri r0 = UserAwareUtil.getHostSettingsUri(this.mContext, AwareStateListener.SETTINGS_GLOBAL_USER_LEARNING_PROGRESS);     // Catch: Throwable -> L9
        if (r0 == null) goto L11;
        ZeusProviderTransform.registerContentObserver(this.mResolver, r0, false, this.mObserver, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        this.mRegistered = true;     // Catch: Throwable -> L9
    L11:
        handleLearningProgressChanged();
        return;
    L9:
        th = move-exception;
        a.a(TAG, "register failed", th);
        goto L11
    }

    public void unregister() {
        if (this.mRegistered == true) goto L15;
        return;
    L15:
        ZeusProviderTransform.unregisterContentObserver(this.mResolver, this.mObserver, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
    L10:
        this.mRegistered = false;
        return;
    L8:
        th = move-exception;
        a.a(TAG, "unregister failed", th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mRegistered = false;
        throw th;
    }
}
