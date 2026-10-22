package com.bytedance.crypto.cloudsync.account;

import com.bytedance.crypto.bridge.IAccountBridge;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class AccountApi {
    public static final AccountApi INSTANCE = null;
    private static final String TAG = "AccountApi";
    private static IAccountBridge mAccountBridge;

    static {
        INSTANCE = new AccountApi();
    }

    private AccountApi() {
    }

    @JvmStatic
    public static final void init(IAccountBridge r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        mAccountBridge = r10;
    }

    public final String getUserId() {
        IAccountBridge r10 = mAccountBridge;
        if (r10 == null) goto L7;
        String r11 = r10.onGetUserId();
        if (r11 == null) goto L7;
        return r11;
    L7:
        return "";
    }

    public final Map<String, String> getXttTokenMap() {
        Map<String, String> r10 = MapsKt.emptyMap();
        IAccountBridge r11 = mAccountBridge;
        if (r11 == null) goto L10;
        Map<String, String> r12 = r11.onGetXttTokenMap();
        if (r12 != null) goto L9;
        return r10;
    L9:
        return r12;
    L10:
        return r10;
    }

    public final boolean isLogin() {
        IAccountBridge r10 = mAccountBridge;
        if (r10 != null) goto L6;
        return false;
    L6:
        return r10.onIsAccountLogin();
    }
}
