package fh8;

import android.content.Context;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r {
    public final Function2<View, lw8.f, Unit> a;
    public final Function4<Context, View, lw8.f, View, Unit> b;
    public final Function2<Context, gw8.b, Unit> c;
    public final Function2<Context, gw8.b, Unit> d;
    public final Function2<gw8.b, View, Unit> e;
    public final Function1<lw8.g, Unit> f;
    public final Function1<lw8.g, Unit> g;
    public final Function2<lw8.f, by7.e, Unit> h;
    public final Function3<Integer, lw8.k, View, Unit> i;
    public final Function0<Unit> j;
    public final Function0<Unit> k;
    public final Function2<View, View, Unit> l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode();
    }

    public final String toString() {
        return "MarkdownTextWidgetEventDelegator(onClickShareButton=" + this.a + ", onClickCopyButton=" + this.b + ", jumpToCodePage=" + this.c + ", jumpToTablePage=" + this.d + ", onFullScreenPreviewClick=" + this.e + ", onClickCitation=" + this.f + ", onInlineCitationSpanShow=" + this.g + ", onCopyShow=" + this.h + ", onSoftLinkShow=" + this.i + ", onFootnoteLinkShow=" + this.j + ", onFootnoteLinkClick=" + this.k + ", onClickSoftLink=" + this.l + ')';
    }

    public r(fm8.n r2, fm8.o r3, fm8.p r4, fm8.b r5, fm8.c r6, fm8.d r7, fm8.e r8, fm8.f r9, fm8.g r10, fm8.h r11, fm8.i r12, fm8.j r13) {
        Intrinsics.checkNotNullParameter(r2, "onClickShareButton");
        Intrinsics.checkNotNullParameter(r3, "onClickCopyButton");
        Intrinsics.checkNotNullParameter(r4, "jumpToCodePage");
        Intrinsics.checkNotNullParameter(r5, "jumpToTablePage");
        Intrinsics.checkNotNullParameter(r6, "onFullScreenPreviewClick");
        Intrinsics.checkNotNullParameter(r7, "onClickCitation");
        Intrinsics.checkNotNullParameter(r8, "onInlineCitationSpanShow");
        Intrinsics.checkNotNullParameter(r9, "onCopyShow");
        Intrinsics.checkNotNullParameter(r10, "onSoftLinkShow");
        Intrinsics.checkNotNullParameter(r11, "onFootnoteLinkShow");
        Intrinsics.checkNotNullParameter(r12, "onFootnoteLinkClick");
        Intrinsics.checkNotNullParameter(r13, "onClickSoftLink");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
