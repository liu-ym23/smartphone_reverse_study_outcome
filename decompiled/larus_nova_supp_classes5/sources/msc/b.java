package msc;

import io.noties.markwon.core.CoreProps;
import lsc.m$c;
import org.commonmark.node.Heading;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements m$c<Heading> {
    public b() {
    }

    @Override // lsc.m$c
    public final void a(lsc.m r5, uvc.b r6) {
        Heading r7 = (Heading) r6;
        r5.C(r7);
        int r0 = r5.length();
        r5.c(r7);
        CoreProps.f.c(r5.r(), Integer.valueOf(r7.h));
        r5.G(r7, r0);
        r5.q(r7);
    }
}
