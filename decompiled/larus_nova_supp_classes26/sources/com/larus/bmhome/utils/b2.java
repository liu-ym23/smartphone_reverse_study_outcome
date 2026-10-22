package com.larus.bmhome.utils;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.fragment.app.FragmentActivity;
import com.larus.common_ui.utils.ViewExtKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b2 implements Function1 {
    public final /* synthetic */ View a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ c2 c;
    public final /* synthetic */ Function1 d;

    public /* synthetic */ b2(View r1, FragmentActivity r2, c2 r3, com.larus.bmhome.chat.z3 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r6) {
        View r0 = this.a;
        FragmentActivity r1 = this.b;
        c2 r2 = this.c;
        Function1 r3 = this.d;
        Insets r7 = (Insets) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        if (ViewExtKt.h(r0) == false) goto L5;
        int r8 = r7.bottom - com.larus.utils.u.b(r1);
    L7:
        if (r2.b == r8) goto L10;
        r2.b = r8;
        r3.invoke(Integer.valueOf(r8));
    L10:
        return Unit.INSTANCE;
    L5:
        r8 = 0;
        goto L7
    }
}
