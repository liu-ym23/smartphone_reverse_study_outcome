package com.larus.account.saas.jsb.core.auth;

import android.app.Activity;
import b48.i;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.larus.account.saas.jsb.core.FlowAccountThirdPartyAuthCore;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import y38.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Activity r2, final i.b r3, final u r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "callback");
        final IGoogleService r0 = AuthorizeFramework.getService(IGoogleService.class);
        if (r0 != null) goto L6;
        com.larus.account.saas.runtime.internal.delegate.a.a.a("FlowAccountThirdPartyAuthCore", "google authorize service is not initialized.");
        FlowAccountThirdPartyAuthCore.Error r5 = FlowAccountThirdPartyAuthCore.Error.SERVICE_UNAVAILABLE;
        r4.a(new x38.a(r5.getCode(), r5.getMessage(), null));
        return;
    L6:
        ConcurrentHashMap<String, a.C0063a> r1 = a.a;
        a.a(r2, new GoogleAuthorizer$authorize$1(r0, r3, r4), new GoogleAuthorizer$authorize$2(r4));
    }
}
