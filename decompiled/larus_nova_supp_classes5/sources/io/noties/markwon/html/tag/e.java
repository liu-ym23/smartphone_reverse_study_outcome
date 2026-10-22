package io.noties.markwon.html.tag;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import lsc.t;
import lsc.x;
import org.commonmark.node.Image;
import tsc.d;
import wsc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e extends i {
    public final a a;

    public interface a {
    }

    @Override // tsc.a0
    public final Collection<String> c() {
        return Collections.singleton("img");
    }

    public e(f r1) {
        this.a = r1;
    }

    @Override // io.noties.markwon.html.tag.i
    public final Object e(lsc.h r13, t r14, tsc.l r15) {
        String r0 = r15.b().get("src");
        o r2 = null;
        if (TextUtils.isEmpty(r0) == true) goto L5;
    L7:
        x r1 = ((lsc.l) r13.e).a(Image.class);
        if (r1 != null) goto L11;
        return null;
    L11:
        if (TextUtils.isEmpty(r0) == true) goto L13;
        ((xsc.a.C0033a) r13.d).getClass();
    L14:
        a r3 = this.a;
        Map<String, String> r4 = r15.b();
        f r5 = (f) r3;
        r5.getClass();
        String r6 = r4.get("style");
        if (TextUtils.isEmpty(r6) == true) goto L28;
        ((tsc.c.a) r5.a).getClass();
        tsc.c.a.a.a r7 = new tsc.c.a.a.a(new tsc.c.a.a(r6));
        o.a r8 = null;
        o.a r9 = null;
    L18:
        if (r7.hasNext() == false) goto L29;
        d r10 = (d) r7.next();
        String r11 = r10.a;
        if ("width".equals(r11) == false) goto L23;
        r8 = f.a(r10.b);
    L25:
        if (r8 == null) goto L18;
        if (r9 == null) goto L18;
    L23:
        if ("height".equals(r11) == false) goto L25;
        r9 = f.a(r10.b);
    L29:
        if (r8 == null) goto L32;
        if (r9 == null) goto L32;
        r2 = new o(r8, r9);
    L40:
        wsc.n.a.c(r14, r0);
        wsc.n.c.c(r14, r2);
        wsc.n.b.c(r14, Boolean.FALSE);
        wsc.n.d.c(r14, Integer.valueOf(r15.start()));
        wsc.n.e.c(r14, Integer.valueOf(r15.end()));
        return r1.a(r13, r14);
    L32:
        if (r8 != null) goto L34;
        r8 = f.a(r4.get("width"));
    L34:
        if (r9 != null) goto L36;
        r9 = f.a(r4.get("height"));
    L36:
        if (r8 != null) goto L39;
        if (r9 == null) goto L40;
    L39:
        r2 = new o(r8, r9);
        goto L40
    L28:
        r8 = null;
        r9 = null;
        goto L29
    L13:
        r0 = "";
        goto L14
    L5:
        if (r13.a.z == true) goto L7;
        return null;
    }
}
