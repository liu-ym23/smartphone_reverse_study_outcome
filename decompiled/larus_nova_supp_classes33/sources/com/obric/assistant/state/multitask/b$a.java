package com.obric.assistant.state.multitask;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b$a {
    public static final /* synthetic */ b$a a = null;

    static {
        a = new b$a();
    }

    public b$a() {
    }

    public static void a(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "eventBuilder");
        b r0 = c.a;
        b r1 = c.a;
        if (r1.isEnabled() == false) goto L6;
        r1.a((a) r2.invoke());
        return;
    }
}
