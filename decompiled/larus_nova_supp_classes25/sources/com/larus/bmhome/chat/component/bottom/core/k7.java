package com.larus.bmhome.chat.component.bottom.core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k7 implements Function1<ICoreInputAbility.e, Boolean> {
    public final /* synthetic */ CharSequence a;

    public k7(CharSequence r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        ICoreInputAbility.e r3 = (ICoreInputAbility.e) r2;
        Intrinsics.checkNotNullParameter(r3, "$this$intercept");
        CharSequence r0 = this.a;
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r3.h(r1);
        return Boolean.FALSE;
    L5:
        r1 = null;
        goto L6
    }
}
