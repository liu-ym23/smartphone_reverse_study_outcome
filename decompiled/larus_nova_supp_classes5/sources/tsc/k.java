package tsc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lsc.m$c;
import org.commonmark.node.HtmlInline;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k<N extends b> implements m$c<HtmlInline> {
    public final /* synthetic */ i a;

    public k(i r1) {
        this.a = r1;
    }

    @Override // lsc.m$c
    public final void a(lsc.m r7, b r8) {
        HtmlInline r9 = (HtmlInline) r8;
        b r0 = r9.a;
        if (r0 == null) goto L5;
        String r1 = r0.getClass().getName();
    L7:
        if (Intrinsics.areEqual(r1, "org.commonmark.ext.gfm.tables.TableCell") == false) goto L17;
        String r2 = r9.h;
        if (r2 != null) goto L11;
    L12:
        String r3 = r9.h;
        if (r3 == null) goto L17;
        if (StringsKt.startsWith$default(r3, "</data-inline", false, 2, null) != true) goto L17;
        return;
    L11:
        if (StringsKt.startsWith$default(r2, "<data-inline", false, 2, null) != true) goto L12;
        return;
    L17:
        this.a.o(r7, r9.h);
        return;
    L5:
        r1 = null;
        goto L7
    }
}
