package msc;

import lsc.m$c;
import lsc.y;
import org.commonmark.node.Code;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k implements m$c<Code> {
    public k() {
    }

    @Override // lsc.m$c
    public final void a(lsc.m r6, uvc.b r7) {
        Code r8 = (Code) r7;
        int r0 = r6.length();
        y r1 = r6.builder();
        r1.a.append(160);
        String r2 = r8.h;
        r1.a.append(r2);
        r1.a(160);
        r6.G(r8, r0);
    }
}
