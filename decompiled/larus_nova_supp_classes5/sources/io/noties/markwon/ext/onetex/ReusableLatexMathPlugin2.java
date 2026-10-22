package io.noties.markwon.ext.onetex;

import android.app.Application;
import android.content.Context;
import android.text.Spanned;
import android.widget.TextView;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.icon.LaTeXIcon;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManagerKt;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.depend.c;
import iw8.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import lsc.r;
import msc.s;
import zsc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ReusableLatexMathPlugin2 extends o {
    public static final x o = null;
    public final Context f;
    public final f g;
    public final int h;
    public final iw8.d i;
    public final b j;
    public final Function2<String, Object, Unit> k;
    public final boolean l;
    public final boolean m;
    public final j n;

    public static final class a {
    }

    static {
        o = new x();
    }

    public static void s(CharSequence r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L27
        Unit r1 = null;
        if ((r7 instanceof Spanned) == false) goto L5;
        Spanned r2 = (Spanned) r7;     // Catch: Throwable -> L27
    L6:
        if (r2 == null) goto L25;
        int r3 = 0;
        c[] r8 = (c[]) r2.getSpans(0, ((Spanned) r7).length(), c.class);     // Catch: Throwable -> L27
        if (r8 == null) goto L25;
        int r4 = r8.length;     // Catch: Throwable -> L27
    L10:
        if (r3 >= r4) goto L24;
        b r5 = r8[r3].e;     // Catch: Throwable -> L27
        x r6 = o;     // Catch: Throwable -> L27
        String r9 = ((wsc.a) r5).a;     // Catch: Throwable -> L27
        Integer r10 = r5.o;     // Catch: Throwable -> L27
        LaTeXIcon r11 = r5.n;     // Catch: Throwable -> L27
        r6.getClass();     // Catch: Throwable -> L27
        if (r9 == null) goto L23;
        if (r10 == null) goto L23;
        if (r11 == null) goto L23;
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, LaTeXIcon>> r12 = r6.a;     // Catch: Throwable -> L27
        ConcurrentHashMap<Integer, LaTeXIcon> r13 = r12.get(r9);     // Catch: Throwable -> L27
        if (r13 != null) goto L22;
        r13 = new ConcurrentHashMap();     // Catch: Throwable -> L27
        ConcurrentHashMap<Integer, LaTeXIcon> r14 = r12.putIfAbsent(r9, r13);     // Catch: Throwable -> L27
        if (r14 == null) goto L22;
        r13 = r14;
    L22:
        r13.put(r10, r11);     // Catch: Throwable -> L27
    L23:
        r3 = r3 + 1;     // Catch: Throwable -> L27
        goto L10
    L24:
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L25:
        Object r15 = Result.constructor-impl(r1);     // Catch: Throwable -> L27
    L29:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L42;
        com.larus.business.markdown.api.depend.d r17 = IMarkdownLoggerKt.a();
        if (r17 == null) goto L43;
        r17.e("ReusableLatexMathPlugin2", "crash, throwable:" + r16.getCause() + " message:" + r16.getMessage());
        return;
    L43:
        return;
    L42:
        return;
    L5:
        r2 = null;
    L27:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }

    @Override // io.noties.markwon.ext.onetex.o, lsc.a, lsc.j
    public final void G4(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        super.G4(r3);     // Catch: Throwable -> L8
        if (this.m == true) goto L6;
        o.a.clear();     // Catch: Throwable -> L8
    L6:
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L18;
        c r1 = IMarkdownEnsureManagerKt.a();
        if (r1 == null) goto L19;
        r1.ensureNotReachHere(r5, "ReusableLatexMathPlugin2 afterSetText");
        return;
    L19:
        return;
    L18:
        return;
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // lsc.a, lsc.j
    public final void j(lsc.j.a r5) {
        Intrinsics.checkNotNullParameter(r5, "registry");
        LaTexHelper.d.d(this.f, new LaTexHelper.a(this.g.l));
        if (this.g.c == false) goto L14;
        zsc.j.b r6 = ((l) ((r) r5).c(l.class)).a;
        int r0 = this.h;
        if (r0 != 1) goto L7;
        f r1 = this.g;
        zsc.j.c r7 = (zsc.j.c) r6;
        r7.a(new n(r1.d, r1.i));
        return;
    L7:
        if (r0 != 2) goto L9;
        zsc.j.c r8 = (zsc.j.c) r6;
        r8.b(zsc.b.class);
        r8.a(new v());
        r8.a(new zsc.b());
        return;
    L9:
        if (r0 == 3) goto L15;
        f r2 = this.g;
        zsc.j.c r9 = (zsc.j.c) r6;
        r9.a(new n(r2.d, r2.i));
        r9.b(zsc.b.class);
        r9.a(new v());
        r9.a(new zsc.b());
        return;
    L15:
        return;
    }

    @Override // lsc.a, lsc.j
    public final void k(vvc.e.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        if (this.g.b == false) goto L14;
        int r0 = this.h;
        if (r0 != 1) goto L7;
        r3.a(new m$a());
        return;
    L7:
        if (r0 != 2) goto L9;
        r3.a(new u$a());
        return;
    L9:
        if (r0 == 3) goto L15;
        r3.a(new m$a());
        r3.a(new u$a());
        return;
    L15:
        return;
    }

    @Override // io.noties.markwon.ext.onetex.o
    public final List<LaTeXIcon> q(LaTeXParam r8) {
        Intrinsics.checkNotNullParameter(r8, "latexParam");
        getSplitTexIcons.createTexIcon.1 r0 = new getSplitTexIcons.createTexIcon.1(r8, this);
        if (this.l == false) goto L5;
        x r1 = o;
        Context r2 = this.f;
        String r9 = r8.getContent();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r9, "latex");
        boolean r3 = false;
    L25:
        e = move-exception;
        c r4 = IMarkdownEnsureManagerKt.a();
        if (r4 == null) goto L29;
        r4.ensureNotReachHere(e, "ReuseDrawablePoolNew obtain exception");
    L29:
        ArrayList r5 = null;
    L30:
        if (r5 != null) goto L32;
    L33:
        r3 = true;
    L34:
        if (r3 == true) goto L36;
        return r5;
    L36:
        return (List) r0.invoke();
    L32:
        if (r5.isEmpty() == false) goto L34;
    L8:
        if ((r2.getResources().getConfiguration().uiMode & 48) != 32) goto L10;
        boolean r6 = true;
    L12:
        if (Intrinsics.areEqual(Boolean.valueOf(r6), r1.b) == true) goto L14;
        r1.a.clear();     // Catch: Exception -> L25
        r1.b = Boolean.valueOf(r6);     // Catch: Exception -> L25
    L14:
        ConcurrentHashMap<Integer, LaTeXIcon> r10 = r1.a.get(r9);     // Catch: Exception -> L25
        if (r10 == null) goto L29;
        Set<Map.Entry<Integer, LaTeXIcon>> r11 = r10.entrySet();     // Catch: Exception -> L25
        if (r11 == null) goto L29;
        List r12 = CollectionsKt.sortedWith(r11, new w());     // Catch: Exception -> L25
        if (r12 == null) goto L29;
        List r13 = r12;     // Catch: Exception -> L25
        r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));     // Catch: Exception -> L25
        Iterator r14 = r13.iterator();     // Catch: Exception -> L25
    L21:
        if (r14.hasNext() == false) goto L30;
        r5.add((LaTeXIcon) ((Map.Entry) r14.next()).getValue());     // Catch: Exception -> L25
        goto L21
    L10:
        r6 = false;
        goto L12
    L5:
        return (List) r0.invoke();
    }

    @Override // lsc.a, lsc.j
    public final void f(TextView r2, Spanned r3) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        Intrinsics.checkNotNullParameter(r3, "markdown");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        wsc.e.b(r2);     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L15;
        c r7 = IMarkdownEnsureManagerKt.a();
        if (r7 == null) goto L16;
        r7.ensureNotReachHere(r6, "ReusableLatexMathPlugin2 beforeSetText");
        return;
    L16:
        return;
    L15:
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // lsc.a, lsc.j
    public final void i(CharSequence r2, uvc.b r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        s(r2);
    }

    @Override // lsc.a, lsc.j
    public final void l(TextView r2, uvc.b r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        if (r2 == null) goto L5;
        CharSequence r4 = r2.getText();
    L6:
        s(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // lsc.a
    public final void m(uvc.b r2, lsc.p r3) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Intrinsics.checkNotNullParameter(r3, "visitor");
        if (this.m == false) goto L6;
        o.a.clear();
        return;
    }

    @Override // io.noties.markwon.ext.onetex.o
    public final wsc.f o(s r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "theme");
        Intrinsics.checkNotNullParameter(r6, "latex");
        iw8.d r0 = this.i;
        h r1 = null;
        if (r0 == null) goto L5;
        wsc.a r2 = r0.a(this.f, new createFallbackSpan.drawable.1(r6));
    L7:
        if ((r2 instanceof h) == false) goto L9;
        r1 = (h) r2;
    L9:
        if (r1 != null) goto L12;
        r1 = new h(r6, this.n, this.c);
    L12:
        return new i(r5, r1);
    L5:
        r2 = null;
        goto L7
    }

    @Override // lsc.a, lsc.j
    public final void d(CharSequence r1, uvc.b r2, lsc.p r3) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Intrinsics.checkNotNullParameter(r3, "visitor");
        if (this.m == false) goto L6;
        o.a.clear();
        return;
    }

    public ReusableLatexMathPlugin2(Context r2, f r3, int r4, iw8.d r5, b r6, Function2 r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "config");
        super(r2, r3);
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.k = r7;
        this.l = true;
        this.m = r8;
        j r9 = new j(r2);
        r9.a = r7;
        this.n = r9;
    }

    @Override // io.noties.markwon.ext.onetex.o
    public final wsc.f p(s r19, String r20, boolean r21, LaTeXIcon r22, Integer r23, Integer r24, Float r25) {
        Intrinsics.checkNotNullParameter(r19, "theme");
        Intrinsics.checkNotNullParameter(r20, "latex");
        iw8.d r15 = this.i;
        b r16 = null;
        if (r15 == null) goto L5;
        wsc.a r1 = r15.a(this.f, new obtainDrawable.drawable.1(r20, r21, r23, r24, r25));
    L7:
        if ((r1 instanceof b) == false) goto L9;
        r16 = (b) r1;
    L9:
        if (r16 != null) goto L70;
        b r2 = this.j;
        if (r2 == null) goto L54;
        Context r4 = this.f;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r20, "urlKey");
        if ((r4.getResources().getConfiguration().uiMode & 48) != 32) goto L15;
        boolean r5 = true;
    L17:
        if (Intrinsics.areEqual(Boolean.valueOf(r5), r2.b) == true) goto L19;
        r2.a.evictAll();
        r2.b = Boolean.valueOf(r5);
    L19:
        iw8.a r3 = r2.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r20, "urlKey");
        wsc.a r6 = (wsc.a) r3.get(new iw8.c(r20, r23));
        if (r6 == null) goto L54;
        if ((r6 instanceof b) == false) goto L40;
        b r7 = (b) r6;
        if (Intrinsics.areEqual(((wsc.a) r7).a, r20) == false) goto L40;
        if (((wsc.a) r7).c != null) goto L40;
        if (r7.m != r21) goto L40;
        if (Intrinsics.areEqual(r7.o, r23) == false) goto L40;
        if (Intrinsics.areEqual(r7.p, r24) == false) goto L40;
        if (Intrinsics.areEqual(r7.q, r25) == false) goto L40;
        if (r6.a() == false) goto L40;
        com.larus.business.markdown.api.depend.d r8 = IMarkdownLoggerKt.a();
        if (r8 == null) goto L72;
        r8.d("ReusableLatexMathPlugin2", "can find LatexAsyncDrawable " + ((wsc.a) r7).a);
    L72:
        return new c(r19, r7);
    L40:
        o.b r9 = this.a;
        if (r21 == false) goto L43;
        wsc.p r10 = this.b;
    L44:
        r7 = new b(r20, r9, r10, r21);
        r7.n = r22;
        r7.o = r23;
        r7.p = r24;
        r7.q = r25;
        com.larus.business.markdown.api.depend.d r11 = IMarkdownLoggerKt.a();
        if (r11 == null) goto L48;
        r11.d("ReusableLatexMathPlugin2", "can not find .. recycle " + ((wsc.a) r7).a);
    L48:
        if ((this.f instanceof Application) == true) goto L72;
        iw8.d r12 = this.i;
        if (r12 == null) goto L52;
        Intrinsics.checkNotNullParameter(r7, "drawable");
        r12.a.add(r7);
    L52:
        this.j.a(r7, r23);
        goto L72
    L43:
        r10 = this.c;
        goto L44
    L15:
        r5 = false;
    L54:
        o.b r13 = this.a;
        if (r21 == false) goto L57;
        wsc.p r14 = this.b;
    L58:
        b r17 = new b(r20, r13, r14, r21);
        r17.n = r22;
        r17.o = r23;
        r17.p = r24;
        r17.q = r25;
        com.larus.business.markdown.api.depend.d r18 = IMarkdownLoggerKt.a();
        if (r18 == null) goto L62;
        r18.d("ReusableLatexMathPlugin2", "can not find ... " + ((wsc.a) r17).a);
    L62:
        if ((this.f instanceof Application) == true) goto L69;
        iw8.d r26 = this.i;
        if (r26 == null) goto L66;
        Intrinsics.checkNotNullParameter(r17, "drawable");
        r26.a.add(r17);
    L66:
        b r27 = this.j;
        if (r27 == null) goto L69;
        r27.a(r17, r23);
    L69:
        r16 = r17;
        goto L70
    L57:
        r14 = this.c;
    L70:
        r7 = r16;
        goto L72
    L5:
        r1 = null;
        goto L7
    }
}
