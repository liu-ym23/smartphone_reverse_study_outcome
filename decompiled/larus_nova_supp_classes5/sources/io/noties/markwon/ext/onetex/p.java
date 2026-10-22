package io.noties.markwon.ext.onetex;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.icon.LaTeXIcon;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.noties.markwon.onetex.LatexMathBlock;
import java.util.List;
import lsc.m;
import lsc.m$c;
import lsc.y;
import uvc.b;
import zs7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class p<N extends b> implements m$c<LatexMathBlock> {
    public final /* synthetic */ o a;

    public p(o r1) {
        this.a = r1;
    }

    @Override // lsc.m$c
    public final void a(m r27, b r28) {
        LatexMathBlock r2 = (LatexMathBlock) r28;
        r27.C(r2);
        String r12 = r2.h;
        o r3 = this.a;
        if (r3.e.g == true) goto L5;
    L7:
        o r4 = this.a;
        t r5 = r4.e.a;
        float r6 = r5.b;
        int r7 = r5.f;
        Resources r8 = r4.d.getResources();
        DisplayMetrics r9 = WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics());
        a r14 = new a(Float.MAX_VALUE, 0);
        a r13 = new a(r6, 0);
        if (r7 == 0) goto L10;
        int r20 = r7;
    L11:
        LaTeXParam r10 = new LaTeXParam(r12, r14, r13, r9.density, 0, 0.0d, null, r20, 0, false, false, null, false, 8048, null);
        List<LaTeXIcon> r11 = this.a.q(r10);
        if (r11 == null) goto L18;
        int r15 = r11.size();
        int r16 = 0;
    L14:
        if (r16 >= r15) goto L16;
        int r17 = r27.length();
        wsc.f r18 = this.a.p(r27.B().a, r12, false, (LaTeXIcon) ListProtector.get(r11, r16), Integer.valueOf(r16), Integer.valueOf(r7), Float.valueOf(r6));
        r27.builder().c(" ");
        r27.o(r17, r18);
        r16 = r16 + 1;
        goto L14
    L16:
        r27.q(r2);
        return;
    L18:
        if (this.a.e.g == false) goto L24;
        int r19 = r27.length();
        y r21 = r27.builder();
        this.a.getClass();
        r21.c(o.r(r12));
        r27.o(r19, this.a.o(r27.B().a, r12));
        r27.q(r2);
        return;
    L24:
        return;
    L10:
        r20 = -16777216;
        goto L11
    L5:
        if (o.n(r3, r12) == true) goto L7;
        int r22 = r27.length();
        y r23 = r27.builder();
        this.a.getClass();
        r23.c(o.r(r12));
        r27.o(r22, this.a.o(r27.B().a, r12));
        r27.q(r2);
    }
}
