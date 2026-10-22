package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends com.bytedance.ies.web.jsbridge2.g<Object, Object> {
    public final com.bytedance.android.scope.j a;

    public c(com.bytedance.android.scope.j r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        Intrinsics.checkNotNullParameter(r4, "p1");
        i12.d r5 = i12.m.e2.a();
        if (r5 == null) goto L5;
        Object r6 = com.bytedance.android.scope.m.e.d(r5, oc6.o.class);
    L6:
        oc6.o r7 = (oc6.o) r6;
        if (r7 == null) goto L9;
        r7.dismissGiftDialog(BuildConfig.FLAVOR);
    L9:
        return null;
    L5:
        r6 = null;
        goto L6
    }
}
