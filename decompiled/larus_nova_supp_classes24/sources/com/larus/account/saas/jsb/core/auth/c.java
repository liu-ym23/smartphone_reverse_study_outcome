package com.larus.account.saas.jsb.core.auth;

import android.app.Activity;
import android.os.Bundle;
import b48.i;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.Request;
import com.larus.account.saas.jsb.core.FlowAccountThirdPartyAuthCore;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import y38.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    static {
    }

    public static void a(Activity r6, i.a r7, u r8) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "callback");
        IDouYin2Service r0 = AuthorizeFramework.getService(IDouYin2Service.class);
        if (r0 != null) goto L6;
        com.larus.account.saas.runtime.internal.delegate.a.a.a("FlowAccountThirdPartyAuthCore", "douyin authorize service is not initialized.");
        FlowAccountThirdPartyAuthCore.Error r9 = FlowAccountThirdPartyAuthCore.Error.SERVICE_UNAVAILABLE;
        r8.a(new x38.a(r9.getCode(), r9.getMessage(), null));
        return;
    L6:
        Request.Builder r2 = new Request.Builder().setScopes(SetsKt.mutableSetOf(new String[]{"user_info"})).setState("dy_authorize").setCallerLocalEntry("com.larus.nova.douyinapi.DouYinEntryActivity");
        Bundle r3 = new Bundle();
        r3.putString("comment_id", r7.b);
        if (r0.authorize(r6, r2.setExtra(r3).setAuthType(0).build(), new b(r8, r7)) == true) goto L10;
        FlowAccountThirdPartyAuthCore.Error r10 = FlowAccountThirdPartyAuthCore.Error.REQUEST_REJECTED;
        r8.a(new x38.a(r10.getCode(), r10.getMessage(), null));
        return;
    }
}
