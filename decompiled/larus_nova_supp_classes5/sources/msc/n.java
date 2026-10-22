package msc;

import lsc.m$c;
import lsc.x;
import org.commonmark.node.Image;
import org.commonmark.node.Link;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class n implements m$c<Image> {
    public n() {
    }

    @Override // lsc.m$c
    public final void a(lsc.m r7, uvc.b r8) {
        Image r9 = (Image) r8;
        x r0 = ((lsc.l) r7.B().e).a(Image.class);
        if (r0 != null) goto L5;
        r7.c(r9);
        return;
    L5:
        int r1 = r7.length();
        r7.c(r9);
        if (r1 != r7.length()) goto L8;
        r7.builder().a(65532);
    L8:
        lsc.h r2 = r7.B();
        boolean r3 = r9.a instanceof Link;
        xsc.a r4 = r2.d;
        String r10 = r9.h;
        ((xsc.a.C0033a) r4).getClass();
        lsc.t r5 = r7.r();
        wsc.n.a.c(r5, r10);
        wsc.n.b.c(r5, Boolean.valueOf(r3));
        wsc.n.c.c(r5, null);
        r7.o(r1, r0.a(r2, r5));
    }
}
