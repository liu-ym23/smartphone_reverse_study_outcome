package msc;

import io.noties.markwon.core.CoreProps;
import lsc.m$c;
import org.commonmark.node.Block;
import org.commonmark.node.ListBlock;
import org.commonmark.node.Paragraph;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e implements m$c<Paragraph> {
    public e() {
    }

    @Override // lsc.m$c
    public final void a(lsc.m r6, uvc.b r7) {
        Paragraph r8 = (Paragraph) r7;
        Block r0 = (Block) r8.a;
        boolean r1 = false;
        if (r0 == null) goto L7;
        Block r2 = (Block) r0.a;
        if ((r2 instanceof ListBlock) == false) goto L7;
        boolean r3 = ((ListBlock) r2).h;
    L9:
        if (r0 == null) goto L13;
        Block r4 = (Block) r0.a;
        if ((r4 instanceof ListBlock) == false) goto L13;
        boolean r5 = !((ListBlock) r4).h;
    L14:
        if (r3 == true) goto L21;
        if (r5 == true) goto L18;
    L20:
        r1 = true;
        goto L21
    L18:
        if (r6.B().a.A == false) goto L20;
    L21:
        if (r1 == false) goto L23;
        r6.C(r8);
    L23:
        int r9 = r6.length();
        r6.c(r8);
        CoreProps.i.c(r6.r(), Boolean.valueOf(r3));
        r6.G(r8, r9);
        if (r1 == false) goto L27;
        r6.q(r8);
        return;
    L27:
        return;
    L13:
        r5 = false;
    L7:
        r3 = false;
        goto L9
    }
}
