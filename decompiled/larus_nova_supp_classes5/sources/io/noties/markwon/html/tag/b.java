package io.noties.markwon.html.tag;

import java.util.Arrays;
import java.util.Collection;
import lsc.t;
import lsc.x;
import org.commonmark.node.Emphasis;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b extends i {
    @Override // tsc.a0
    public final Collection<String> c() {
        return Arrays.asList(new String[]{"i", "em", "cite", "dfn"});
    }

    public b() {
    }

    @Override // io.noties.markwon.html.tag.i
    public final Object e(lsc.h r2, t r3, tsc.l r4) {
        x r5 = ((lsc.l) r2.e).a(Emphasis.class);
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.a(r2, r3);
    }
}
