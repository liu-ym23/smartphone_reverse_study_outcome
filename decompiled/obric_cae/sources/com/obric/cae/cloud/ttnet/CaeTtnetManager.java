package com.obric.cae.cloud.ttnet;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.UserManager;
import com.obric.cae.log.CommSenseLog;

/* JADX INFO: loaded from: classes.dex */
public class CaeTtnetManager {
    private static final String TAG = "CaeTtnetManager";
    public static Application mApplication;
    public static Context mContext;
    private static BroadcastReceiver mUserUnlockedReceiver;

    static {
        mUserUnlockedReceiver = new AnonymousClass1();
    }

    public CaeTtnetManager() {
    }

    public static void init(Context r8, Application r10) {
        mContext = r8;
        if (isUserUnlocked(r8) == false) goto L5;
        CommSenseLog.d(TAG, "init isUserUnlocked ");
        InitTTNetHelper.initTTNet(mContext, r10);
        return;
    L5:
        initIntentFiler();
    }

    private static void initIntentFiler() {
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.intent.action.USER_UNLOCKED");
        mContext.registerReceiver(mUserUnlockedReceiver, r8);
    }

    public static boolean isUserUnlocked(Context r8) {
        return ((UserManager) r8.getSystemService(UserManager.class)).isUserUnlocked();
    }
}
