package msc;

import io.noties.markwon.core.CoreProps;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lsc.m$c;
import org.commonmark.node.Link;
import org.commonmark.node.Text;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class q<N extends uvc.b> implements m$c {
    public static final q<N> a = null;

    static {
        a = new q();
    }

    public q() {
    }

    @Override // lsc.m$c
    public final void a(lsc.m r7, uvc.b r8) {
        Link r9 = (Link) r8;
        Intrinsics.checkNotNullParameter(r7, "visitor");
        Intrinsics.checkNotNullParameter(r9, "link");
        int r0 = r7.length();
        r7.c(r9);
        CoreProps.g.c(r7.r(), r9.h);
        lsc.q<String> r1 = p.d;
        lsc.t r2 = r7.r();
        String r3 = r9.i;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
        String r5 = r9.i;
    L20:
        r1.c(r2, r5);
        r7.G(r9, r0);
        return;
    L11:
        uvc.b r6 = r9.b;
        if ((r6 instanceof Text) == false) goto L14;
        Text r10 = (Text) r6;
    L15:
        if (r10 == null) goto L17;
        r5 = r10.h;
    L18:
        if (r5 != null) goto L20;
        r5 = "";
        goto L20
    L17:
        r5 = null;
        goto L18
    L14:
        r10 = null;
        goto L15
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r4 = false;
        goto L9
    }
}
