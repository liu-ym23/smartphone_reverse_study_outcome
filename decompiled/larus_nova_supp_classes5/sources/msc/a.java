package msc;

import lsc.m$c;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements m$c<ThematicBreak> {
    public a() {
    }

    @Override // lsc.m$c
    public final void a(lsc.m r4, uvc.b r5) {
        ThematicBreak r6 = (ThematicBreak) r5;
        r4.C(r6);
        int r0 = r4.length();
        r4.builder().a(160);
        r4.G(r6, r0);
        r4.q(r6);
    }
}
