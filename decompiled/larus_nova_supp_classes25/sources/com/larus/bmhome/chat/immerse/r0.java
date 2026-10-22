package com.larus.bmhome.chat.immerse;

import androidx.core.graphics.Insets;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r0 implements Function1 {
    public final /* synthetic */ MessageListMaskWrapper a;

    public /* synthetic */ r0(MessageListMaskWrapper r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        MessageListMaskWrapper r0 = this.a;
        Intrinsics.checkNotNullParameter((Insets) r6, "insets");
        if (r0.s == true) goto L6;
        r0.i();
    L6:
        if (Intrinsics.areEqual(r0.l, Boolean.TRUE) == false) goto L11;
        if (r0.s == true) goto L11;
        r0.o((int) (((double) r0.h) * 0.45d));
        r0.a(r0.k);
    L11:
        return Unit.INSTANCE;
    }
}
