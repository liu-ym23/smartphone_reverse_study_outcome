package io.noties.markwon.ext.onetex;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.icon.LaTeXIcon;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.List;
import lsc.m;
import lsc.m$c;
import lsc.y;
import uvc.b;
import zs7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class q<N extends b> implements m$c<LatexMathNode> {
    public final /* synthetic */ o a;

    public q(o r1) {
        this.a = r1;
    }

    @Override // lsc.m$c
    public final void a(m r26, b r27) {
        String r2 = ((LatexMathNode) r27).h;
        o r3 = this.a;
        t r4 = r3.e.a;
        float r12 = r4.a;
        int r6 = r4.e;
        Resources r5 = r3.d.getResources();
        DisplayMetrics r7 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics());
        o r8 = this.a;
        if (r8.e.g == true) goto L5;
    L7:
        a r9 = new a(Float.MAX_VALUE, 0);
        a r15 = new a(r12, 0);
        if (r6 == 0) goto L10;
        int r20 = r6;
    L11:
        LaTeXParam r10 = new LaTeXParam(r2, r9, r15, r7.density, 0, 0.0d, null, r20, 0, false, false, null, false, 8048, null);
        long r11 = System.currentTimeMillis();
        List<LaTeXIcon> r13 = this.a.q(r10);
        LaTexHelper.d.b(System.currentTimeMillis() - r11);
        if (r13 == null) goto L17;
        int r14 = r13.size();
        int r16 = 0;
    L14:
        if (r16 >= r14) goto L23;
        int r17 = r26.length();
        wsc.f r18 = this.a.p(r26.B().a, r2, false, (LaTeXIcon) ListProtector.get(r13, r16), Integer.valueOf(r16), Integer.valueOf(r6), Float.valueOf(r12));
        r26.builder().c(" ");
        r26.o(r17, r18);
        r16 = r16 + 1;
        goto L14
    L23:
        return;
    L17:
        if (this.a.e.g == false) goto L22;
        int r19 = r26.length();
        y r21 = r26.builder();
        this.a.getClass();
        r21.c(o.r(r2));
        r26.o(r19, this.a.o(r26.B().a, r2));
        return;
    L22:
        return;
    L10:
        r20 = -16777216;
        goto L11
    L5:
        if (o.n(r8, r2) == true) goto L7;
        int r22 = r26.length();
        y r23 = r26.builder();
        this.a.getClass();
        r23.c(o.r(r2));
        r26.o(r22, this.a.o(r26.B().a, r2));
    }
}
