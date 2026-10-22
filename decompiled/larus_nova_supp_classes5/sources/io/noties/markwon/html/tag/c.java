package io.noties.markwon.html.tag;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.noties.markwon.core.CoreProps;
import java.util.Arrays;
import java.util.Collection;
import lsc.t;
import lsc.x;
import org.commonmark.node.Heading;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c extends i {
    @Override // tsc.a0
    public final Collection<String> c() {
        return Arrays.asList(new String[]{"h1", "h2", "h3", "h4", "h5", "h6"});
    }

    public c() {
    }

    @Override // io.noties.markwon.html.tag.i
    public final Object e(lsc.h r4, t r5, tsc.l r6) {
        x r0 = ((lsc.l) r4.e).a(Heading.class);
        if (r0 != null) goto L17;
        return null;
    L17:
        int r7 = CastIntegerProtector.parseInt(r6.name().substring(1));     // Catch: NumberFormatException -> L8
    L10:
        if (r7 >= 1) goto L12;
    L16:
        return null;
    L12:
        if (r7 > 6) goto L16;
        CoreProps.f.c(r5, Integer.valueOf(r7));
        return r0.a(r4, r5);
    L8:
        e = move-exception;
        e.printStackTrace();
        r7 = 0;
        goto L10
    }
}
