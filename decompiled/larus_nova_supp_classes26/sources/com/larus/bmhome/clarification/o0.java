package com.larus.bmhome.clarification;

import android.view.View;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.h9;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class o0 implements Function1 {
    public final /* synthetic */ ClarificationComponent a;

    public /* synthetic */ o0(ClarificationComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7) {
        ClarificationComponent r0 = this.a;
        g9.c r8 = (g9.c) r7;
        int r1 = ClarificationComponent.k0;
        Intrinsics.checkNotNullParameter(r8, "$this$Config");
        d2 r2 = r0.n.a;
        View r3 = null;
        if (r2 == null) goto L9;
        List<z1> r4 = r2.l;
        if (r4 == null) goto L9;
        z1 r5 = (z1) CollectionsKt.getOrNull(r4, r2.j);
        if (r5 == null) goto L9;
        ze8.c r6 = y1.a(r5, null);
    L10:
        boolean r9 = false;
        if (r6 == null) goto L26;
        r8.a().e(r6.a);
        g9.b r10 = r8.a;
        r10.getClass();
        View r11 = r10.a;
        if (r11 == null) goto L16;
        r3 = r11.findViewById(2131362060);
    L16:
        if (r3 == null) goto L18;
        r3.setVisibility(8);
    L18:
        h9 r12 = r8.h();
        r12.e(r6.c);
        r12.b(r6.c);
        r12.a(1.0f);
        h9 r13 = r8.i();
        r13.e(false);
        r13.b(false);
        r8.e().e(r6.d);
        va8.o r14 = r0.G3();
        if (r14 == null) goto L21;
        r14.JP(Boolean.valueOf(r6.d));
    L21:
        va8.o r15 = r0.G3();
        if (r15 == null) goto L24;
        r15.FD(Boolean.FALSE);
    L24:
        r8.d().e(true);
        r8.g().e(false);
        r8.f().e(false);
        r8.k().e(true);
        r8.j().e(false);
        r9 = true;
    L26:
        return Boolean.valueOf(r9);
    L9:
        r6 = null;
        goto L10
    }
}
