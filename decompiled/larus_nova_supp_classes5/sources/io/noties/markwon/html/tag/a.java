package io.noties.markwon.html.tag;

import java.util.Collection;
import java.util.Collections;
import lsc.x;
import lsc.y;
import org.commonmark.node.BlockQuote;
import tsc.a0;
import tsc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a extends a0 {
    @Override // tsc.a0
    public final Collection<String> c() {
        return Collections.singleton("blockquote");
    }

    public a() {
    }

    @Override // tsc.a0
    public final void a(lsc.m r3, v r4, tsc.l r5) {
        if (r5.isBlock() == false) goto L5;
        a0.d(r3, r4, r5.a());
    L5:
        lsc.h r6 = r3.B();
        x r0 = ((lsc.l) r6.e).a(BlockQuote.class);
        if (r0 == null) goto L9;
        y.f(r3.builder(), r0.a(r6, r3.r()), r5.start(), r5.end());
        return;
    }
}
