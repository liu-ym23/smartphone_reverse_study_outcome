package io.noties.markwon.html;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.html.jsoup.parser.ParseErrorList;
import io.noties.markwon.html.jsoup.parser.Token;
import io.noties.markwon.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes6.dex */
public class n extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Set<String> f16598a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f16599b = null;
    private static final Set<String> c = null;
    private final g d;
    private final Map<String, u> e;
    private final v f;
    private final Set<String> g;
    private final Set<String> h;
    private final List<k.b> i;
    private k.a j;
    private boolean k;
    private boolean l;

    /* JADX INFO: renamed from: io.noties.markwon.html.n$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16600a = null;

        static {
            int[] r0 = new int[Token.TokenType.values().length];
            f16600a = r0;
            r0[Token.TokenType.StartTag.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f16600a[Token.TokenType.EndTag.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f16600a[Token.TokenType.Character.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f16598a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"a", "abbr", "acronym", "b", "bdo", "big", "br", "button", "cite", "code", "dfn", "em", "i", "img", "input", "kbd", AnnotatedPrivateKey.LABEL, "map", "object", "q", "samp", "script", "select", "small", "span", "strong", "sub", "sup", "textarea", OaidModel.KEY_TIME, "tt", "var"})));
        f16599b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"area", "base", "br", "col", "embed", "hr", "img", "input", "keygen", "link", "meta", AutoTestConstant.PARAM, AILabCheckPermissionTask.KEY_SOURCE, "track", "wbr"})));
        c = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{MemoryKeyInfoEntity.KEY_ADDRESS, "article", "aside", "blockquote", "canvas", "dd", "div", "dl", "dt", "fieldset", "figcaption", "figure", "footer", "form", "h1", "h2", "h3", "h4", "h5", "h6", "header", "hgroup", "hr", "li", "main", "nav", "noscript", "ol", "output", "p", "pre", "section", "table", "tfoot", "ul", "video"})));
    }

    n(g r3, Map<String, u> r4, v r5, Set<String> r6, Set<String> r7) {
        Map<String, u> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Set<String> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        this.i = new ArrayList(0);
        this.j = k.a.l();
        this.d = r3;
        this.e = r8;
        this.f = r5;
        this.g = r9;
        this.h = r10;
    }

    public static n a(g r8, Map<String, u> r9, Set<String> r10, Set<String> r11) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        return new n(r8, r4, v.a(), r6, r7);
    }

    public static Map<String, String> a(Token.g r4) {
        io.noties.markwon.html.jsoup.nodes.b r5 = r4.e;
        int r0 = r5.a();
        if (r0 <= 0) goto L10;
        HashMap r1 = new HashMap(r0);
        Iterator<io.noties.markwon.html.jsoup.nodes.a> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L12;
        io.noties.markwon.html.jsoup.nodes.a r2 = (io.noties.markwon.html.jsoup.nodes.a) ZeusTransformUtils.preCheckCast(r6.next(), io.noties.markwon.html.jsoup.nodes.a.class, "com.obric.memorydata.plugin");
        r1.put(r2.a().toLowerCase(Locale.US), r2.b());
        goto L6
    L12:
        return Collections.unmodifiableMap(r1);
    L10:
        return Collections.emptyMap();
    }

    public static boolean a(x r2, j r3) {
        if (((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin")).b() != r2.length()) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T extends Appendable & CharSequence> void b(T r3) {
        Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
        int r0 = ((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length();
        if (r0 > 0) goto L5;
        return;
    L5:
        if ('\n' == ((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).charAt(r0 - 1)) goto L9;
        a.a(r4, '\n');
        return;
    }

    public static boolean c(String r1) {
        return f16598a.contains(r1);
    }

    private void d(x r3, j r4) {
        j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
        c(r3, r5);
        if (a(r3, r5) == false) goto L6;
        b(r3, r5);
        return;
    }

    public static boolean d(String r1) {
        return f16599b.contains(r1);
    }

    public static boolean e(String r1) {
        return c.contains(r1);
    }

    private boolean f(String r1) {
        return this.h.contains(r1);
    }

    private boolean g(String r1) {
        return this.g.contains(r1);
    }

    public k.b a(String r5) {
        int r0 = this.i.size();
    L3:
        r0 = r0 - 1;
        if (r0 <= (-1)) goto L11;
        k.b r1 = (k.b) ZeusTransformUtils.preCheckCast(this.i.get(r0), k.b.class, "com.obric.memorydata.plugin");
        if (r5.equals(r1.f16594a) == false) goto L3;
        if (r1.d >= 0) goto L3;
        return r1;
    L11:
        return null;
    }

    @Override // io.noties.markwon.html.m
    public void a() {
        this.i.clear();
        this.j = k.a.l();
    }

    @Override // io.noties.markwon.html.m
    public void a(int r5, m.a<j.b> r6) {
        m.a r7 = (m.a) ZeusTransformUtils.wrapperContextForParams(r6, m.a.class, "com.obric.memorydata.plugin");
        if (this.i.size() > 0) goto L5;
        r7.a(Collections.emptyList());
        return;
    L5:
        if (r5 <= (-1)) goto L10;
        Iterator<k.b> r0 = this.i.iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        ((k.b) ZeusTransformUtils.preCheckCast(r0.next(), k.b.class, "com.obric.memorydata.plugin")).a(r5);
    L10:
        ArrayList r8 = new ArrayList(this.i);
        Collections.reverse(r8);
        r7.a(r8);
        this.i.clear();
    }

    public void a(k.a r2, k.a r3) {
        List r1 = r2.g;
        if (r1 != null) goto L5;
        r1 = new ArrayList(2);
        r2.g = r1;
    L5:
        r1.add(r3);
    }

    public void a(x r3, Token.f r4) {
        k.b r5 = a(r4.c);
        if (r5 == null) goto L6;
        r5.a(r3.subSequence(r5.b(), r3.length()));
        d(r3, r5);
        r5.a(r3.length());
        return;
    }

    public void a(x r5, Token.g r6) {
        String r0 = r6.c;
        k.b r1 = new k.b(r0, r5.length(), a(r6));
        a(r5);
        if (d(r0) == false) goto L5;
    L6:
        r1.a(r5.subSequence(r1.b(), r5.length()));
        d(r5, r1);
        r1.a(r5.length());
    L7:
        this.i.add(r1);
        return;
    L5:
        if (r6.d == false) goto L7;
        goto L6
    }

    @Override // io.noties.markwon.html.m
    public void a(x r5, String r6) {
        io.noties.markwon.html.jsoup.parser.c r0 = new io.noties.markwon.html.jsoup.parser.c(new io.noties.markwon.html.jsoup.parser.a(r6), ParseErrorList.noTracking());
    L3:
        Token r7 = r0.a();
        Token.TokenType r1 = r7.f16583a;
        if (Token.TokenType.EOF == r1) goto L5;
        int r2 = AnonymousClass1.f16600a[r1.ordinal()];
        if (r2 != 1) goto L9;
        Token.g r3 = (Token.g) ZeusTransformUtils.preCheckCast(r7, Token.g.class, "com.obric.memorydata.plugin");
        if (c(r3.c) == false) goto L24;
    L27:
        a(r5, r3);
    L28:
        r7.a();
        goto L3
    L24:
        if (f(r3.c) == true) goto L27;
        b(r5, r3);
        goto L28
    L9:
        if (r2 != 2) goto L11;
        Token.f r4 = (Token.f) ZeusTransformUtils.preCheckCast(r7, Token.f.class, "com.obric.memorydata.plugin");
        if (c(r4.c) == false) goto L17;
    L20:
        a(r5, r4);
        goto L28
    L17:
        if (f(r4.c) == true) goto L20;
        b(r5, r4);
        goto L28
    L11:
        if (r2 != 3) goto L28;
        a(r5, (Token.b) ZeusTransformUtils.preCheckCast(r7, Token.b.class, "com.obric.memorydata.plugin"));
        goto L28
    }

    public <T extends Appendable & CharSequence> void a(T r3) {
        Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
        if (this.l == false) goto L6;
        b(r4);
        this.l = false;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends Appendable & CharSequence> void a(T r3, Token.b r4) {
        Appendable r5 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
        if (this.k == false) goto L5;
        a.a(r5, r4.b());
        return;
    L5:
        a(r5);
        this.f.a(r5, r4.b());
    }

    public k.a b(String r2) {
        k.a r1 = this.j;
    L3:
        if (r1 == null) goto L9;
        if (r2.equals(r1.f16594a) == true) goto L9;
        if (r1.d() == true) goto L9;
        r1 = r1.f;
    L9:
        return r1;
    }

    @Override // io.noties.markwon.html.m
    public void b(int r3, m.a<j.a> r4) {
        m.a r5 = (m.a) ZeusTransformUtils.wrapperContextForParams(r4, m.a.class, "com.obric.memorydata.plugin");
        k.a r0 = this.j;
    L4:
        if (r0.f == null) goto L7;
        r0 = r0.f;
        goto L4
    L7:
        if (r3 <= (-1)) goto L9;
        r0.a(r3);
    L9:
        List<j.a> r6 = r0.j();
        if (r6.size() > 0) goto L13;
        r6 = Collections.emptyList();
    L13:
        r5.a(r6);
        this.j = k.a.l();
    }

    public void b(x r3, j r4) {
        j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
        String r2 = this.d.a(r5);
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.length() <= 0) goto L9;
        a.a(r3, r2);
        return;
    }

    public void b(x r5, Token.f r6) {
        String r0 = r6.c;
        k.a r7 = b(r6.c);
        if (r7 == null) goto L20;
        boolean r2 = false;
        if ("pre".equals(r0) == false) goto L7;
        this.k = false;
    L7:
        r7.a(r5.subSequence(r7.b(), r5.length()));
        d(r5, r7);
        r7.a(r5.length());
        if (r7.k() == true) goto L16;
        if (e(r7.f16594a) == false) goto L12;
    L13:
        r2 = true;
    L14:
        this.l = r2;
        goto L16
    L12:
        if (g(r0) == false) goto L14;
    L16:
        if ("p".equals(r0) == false) goto L18;
        a.a(r5, '\n');
    L18:
        this.j = r7.f;
        return;
    }

    public void b(x r5, Token.g r6) {
        String r0 = r6.c;
        if ("p".equals(this.j.f16594a) == false) goto L7;
        this.j.a(r5.length());
        a.a(r5, '\n');
    L5:
        this.j = this.j.f;
    L12:
        if (e(r0) == false) goto L14;
    L17:
        this.k = "pre".equals(r0);
        b(r5);
    L18:
        k.a r1 = k.a.a(r0, r5.length(), a(r6), this.j);
        if (d(r0) == false) goto L21;
    L24:
        boolean r7 = true;
    L25:
        if (r7 == false) goto L27;
        r1.a(r5.subSequence(r1.b(), r5.length()));
        d(r5, r1);
        r1.a(r5.length());
    L27:
        a(r1.f, r1);
        if (r7 == true) goto L31;
        this.j = r1;
        return;
    L31:
        return;
    L21:
        if (r6.d == true) goto L24;
        r7 = false;
        goto L25
    L14:
        if (g(r0) == true) goto L17;
        a(r5);
        goto L18
    L7:
        if ("li".equals(r0) == false) goto L12;
        if ("li".equals(this.j.f16594a) == false) goto L12;
        this.j.a(r5.length());
        goto L5
    }

    public void c(x r4, j r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin");
        u r0 = (u) ZeusTransformUtils.preCheckCast(this.e.get(r6.a()), u.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L10;
        CharSequence r3 = r0.a(r6, this.d);
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3 == r6.f()) goto L12;
        r4.a(r6.b());
        r4.a(r3);
        return;
    L12:
        return;
    }
}
