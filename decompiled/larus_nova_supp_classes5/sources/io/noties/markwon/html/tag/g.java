package io.noties.markwon.html.tag;

import android.text.TextUtils;
import io.noties.markwon.core.CoreProps;
import java.util.Collection;
import java.util.Collections;
import lsc.t;
import lsc.x;
import org.commonmark.node.Link;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class g extends i {
    @Override // tsc.a0
    public final Collection<String> c() {
        return Collections.singleton("a");
    }

    public g() {
    }

    @Override // io.noties.markwon.html.tag.i
    public Object e(lsc.h r3, t r4, tsc.l r5) {
        String r6 = r5.b().get("href");
        if (TextUtils.isEmpty(r6) == true) goto L8;
        x r0 = ((lsc.l) r3.e).a(Link.class);
        if (r0 == null) goto L10;
        CoreProps.g.c(r4, r6);
        return r0.a(r3, r4);
    L10:
        return null;
    L8:
        return null;
    }
}
