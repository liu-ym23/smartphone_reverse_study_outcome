package com.bytedance.crypto.cloudsync.account;

import com.bytedance.crypto.bridge.IAccountBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
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
    public static final void init(IAccountBridge r2) {
        IAccountBridge r3 = (IAccountBridge) ZeusTransformUtils.wrapperContextForParams(r2, IAccountBridge.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "callback");
        mAccountBridge = r3;
    }

    public final String getUserId() {
        IAccountBridge r0 = mAccountBridge;
        if (r0 == null) goto L7;
        String r1 = r0.onGetUserId();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return "";
    }

    public final Map<String, String> getXttTokenMap() {
        Map<String, String> r1 = MapsKt.emptyMap();
        IAccountBridge r0 = mAccountBridge;
        if (r0 == null) goto L10;
        Map<String, String> r2 = r0.onGetXttTokenMap();
        if (r2 != null) goto L9;
        return r1;
    L9:
        return r2;
    L10:
        return r1;
    }

    public final boolean isLogin() {
        IAccountBridge r0 = mAccountBridge;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.onIsAccountLogin();
    }
}
