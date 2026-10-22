package msc;

import io.noties.markwon.core.CoreProps;
import lsc.m$c;
import org.commonmark.node.Link;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f implements m$c<Link> {
    public f() {
    }

    @Override // lsc.m$c
    public final void a(lsc.m r5, uvc.b r6) {
        Link r7 = (Link) r6;
        int r0 = r5.length();
        r5.c(r7);
        String r1 = r7.h;
        CoreProps.g.c(r5.r(), r1);
        r5.G(r7, r0);
    }
}
