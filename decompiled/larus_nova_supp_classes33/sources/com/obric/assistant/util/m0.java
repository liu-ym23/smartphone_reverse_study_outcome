package com.obric.assistant.util;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class m0 implements Function2 {
    public final /* synthetic */ s0 a;

    public /* synthetic */ m0(s0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4, Object r5) {
        s0 r0 = this.a;
        View r6 = (View) r4;
        float r7 = ((Float) r5).floatValue();
        Intrinsics.checkNotNullParameter(r6, "view");
        if (r6.getId() != 2131381249) goto L7;
        ViewGroup r1 = r0.d;
        if (r1 == null) goto L7;
        float r2 = r1.getPaddingBottom();
    L8:
        r6.setTranslationY(r7 + r2);
        return Unit.INSTANCE;
    L7:
        r2 = 0.0f;
        goto L8
    }
}
