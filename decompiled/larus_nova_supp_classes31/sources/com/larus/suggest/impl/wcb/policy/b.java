package com.larus.suggest.impl.wcb.policy;

import com.larus.suggest.impl.wcb.request.WcbRequestTrigger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final String a(com.larus.suggest.impl.wcb.request.f r4, hx9.l r5) {
        Intrinsics.checkNotNullParameter(r4, "snapshot");
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r4.f.b != WcbRequestTrigger.REGENERATE) goto L6;
        return null;
    L6:
        if (r5.d() == false) goto L9;
        return "minor mode";
    L9:
        wc9.e r6 = r5.O8();
        if (r6 != null) goto L14;
        return "conversation unavailable";
    L14:
        if (Intrinsics.areEqual(r6.a, r4.b) == true) goto L18;
        return "new conversation changed";
    L18:
        return null;
    }
}
