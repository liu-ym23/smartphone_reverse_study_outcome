package tsc;

import io.noties.markwon.html.jsoup.nodes.a;
import io.noties.markwon.html.jsoup.nodes.b;
import io.noties.markwon.html.jsoup.parser.Token;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r extends q {
    public static final Set<String> j = null;
    public static final Set<String> k = null;
    public static final Set<String> l = null;
    public final g a;
    public final Map<String, a0> b;
    public final b0 c;
    public final Set<String> d;
    public final Set<String> e;
    public final List<m.b> f;
    public m.a g;
    public boolean h;
    public boolean i;

    static {
        j = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"a", "abbr", "acronym", "b", "bdo", "big", "br", "button", "cite", "code", "dfn", "em", "i", "img", "input", "kbd", "label", "map", "object", "q", "samp", "script", "select", "small", "span", "strong", "sub", "sup", "textarea", "time", "tt", "var"})));
        k = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"area", "base", "br", "col", "embed", "hr", "img", "input", "keygen", "link", "meta", "param", "source", "track", "wbr"})));
        l = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"address", "article", "aside", "blockquote", "canvas", "dd", "div", "dl", "dt", "fieldset", "figcaption", "figure", "footer", "form", "h1", "h2", "h3", "h4", "h5", "h6", "header", "hgroup", "hr", "li", "main", "nav", "noscript", "ol", "output", "p", "pre", "section", "table", "tfoot", "ul", "video"})));
    }

    public static Map<String, String> a(Token.g r6) {
        b r7 = ((Token.h) r6).j;
        int r0 = r7.a;
        if (r0 <= 0) goto L16;
        HashMap r1 = new HashMap(r0);
        int r2 = 0;
    L6:
        if (r2 >= r7.a) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L20;
        String r4 = r7.c[r2];
        String r5 = r7.b[r2];
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        a r8 = new a(r5, r4, r7);
        r2 = r2 + 1;
        r1.put(r8.a.toLowerCase(Locale.US), r8.b);
        goto L6
    L20:
        return Collections.unmodifiableMap(r1);
    L8:
        r3 = false;
        goto L9
    L16:
        return Collections.emptyMap();
    }

    public final void b(lsc.y r3, m r4) {
        a0 r0 = this.b.get(r4.a);
        if (r0 == null) goto L10;
        CharSequence r1 = r0.b(r4, this.a);
        if (r1 == null) goto L10;
        if (r1 == r4.e) goto L10;
        r3.e(r4.b);
        r3.b(r1);
    L10:
        if (r4.b != r3.length()) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L23;
        this.a.getClass();
        String r5 = g.a(r4);
        if (r5 != null) goto L17;
        return;
    L17:
        if (r5.length() <= 0) goto L27;
        r3.append(r5);     // Catch: IOException -> L20
        return;
    L20:
        e = move-exception;
        throw new RuntimeException(e);
    L27:
        return;
    L23:
        return;
    L12:
        r2 = false;
        goto L13
    }

    public r(g r6, Map r7, b0.a r8, Set r9, Set r10) {
        this.f = new ArrayList(0);
        this.g = new m.a("", 0, Collections.emptyMap(), null);
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
    }
}
