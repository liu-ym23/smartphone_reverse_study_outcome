package com.larus.bmhome.clarification;

import android.view.View;
import android.widget.TextView;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.h9;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class m0 implements Function1 {
    public final /* synthetic */ ClarificationComponent a;

    public /* synthetic */ m0(ClarificationComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7) {
        ClarificationComponent r0 = this.a;
        g9.c r8 = (g9.c) r7;
        int r1 = ClarificationComponent.k0;
        Intrinsics.checkNotNullParameter(r8, "$this$Config");
        d2 r2 = r0.n.a;
        View r3 = null;
        if (r2 == null) goto L18;
        List<z1> r4 = r2.l;
        if (r4 == null) goto L18;
        z1 r5 = (z1) CollectionsKt.getOrNull(r4, r2.j);
        if (r5 == null) goto L18;
        View r6 = r8.j().a;
        if ((r6 instanceof TextView) == false) goto L11;
        TextView r9 = (TextView) r6;
    L12:
        if (r9 == null) goto L16;
        CharSequence r10 = r9.getText();
        if (r10 == null) goto L16;
        String r11 = r10.toString();
    L17:
        ze8.c r12 = y1.a(r5, r11);
    L19:
        boolean r13 = false;
        if (r12 == null) goto L35;
        r8.a().e(r12.a);
        g9.b r14 = r8.a;
        r14.getClass();
        View r15 = r14.a;
        if (r15 == null) goto L25;
        r3 = r15.findViewById(2131362060);
    L25:
        if (r3 == null) goto L27;
        r3.setVisibility(8);
    L27:
        h9 r16 = r8.h();
        r16.e(r12.c);
        r16.b(r12.c);
        r16.a(1.0f);
        h9 r17 = r8.i();
        r17.e(r12.b);
        r17.b(r12.b);
        r17.a(1.0f);
        r8.e().e(r12.d);
        va8.o r18 = r0.G3();
        if (r18 == null) goto L30;
        r18.JP(Boolean.valueOf(r12.d));
    L30:
        va8.o r19 = r0.G3();
        if (r19 == null) goto L33;
        r19.FD(Boolean.FALSE);
    L33:
        r8.d().e(false);
        r8.g().e(false);
        r8.f().e(false);
        r8.k().d(4);
        r13 = true;
        r8.j().e(true);
    L35:
        return Boolean.valueOf(r13);
    L16:
        r11 = null;
        goto L17
    L11:
        r9 = null;
    L18:
        r12 = null;
        goto L19
    }
}
