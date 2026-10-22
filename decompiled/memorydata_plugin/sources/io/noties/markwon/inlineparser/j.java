package io.noties.markwon.inlineparser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.internal.Bracket;
import org.commonmark.internal.Delimiter;
import org.commonmark.internal.inline.AsteriskDelimiterProcessor;
import org.commonmark.internal.inline.EmphasisDelimiterProcessor;
import org.commonmark.internal.inline.UnderscoreDelimiterProcessor;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserContext;
import org.commonmark.parser.InlineParserFactory;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* JADX INFO: loaded from: classes6.dex */
public class j implements l, InlineParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Pattern f16628a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Pattern f16629b = null;
    private static final Pattern c = null;
    private static final Pattern d = null;
    private static final Pattern e = null;
    private final InlineParserContext f;
    private final boolean g;
    private final boolean h;
    private final BitSet i;
    private final Map<Character, List<i>> j;
    private final Map<Character, DelimiterProcessor> k;
    private Node l;
    private String m;
    private int n;
    private Delimiter o;
    private Bracket p;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f16630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f16631b;
        final boolean c;

        a(int r1, boolean r2, boolean r3) {
            this.f16630a = r1;
            this.c = r2;
            this.f16631b = r3;
        }
    }

    public interface b {
        b a(i r1);

        b a(Class<? extends i> r1);

        InlineParserFactory a();
    }

    static class c implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<i> f16632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<DelimiterProcessor> f16633b;
        private boolean c;
        private boolean d;

        c() {
            this.f16632a = new ArrayList(3);
            this.f16633b = new ArrayList(3);
            this.d = false;
        }

        @Override // io.noties.markwon.inlineparser.j.b
        public b a(i r2) {
            this.f16632a.add(r2);
            return this;
        }

        @Override // io.noties.markwon.inlineparser.j.b
        public b a(Class<? extends i> r6) {
            int r0 = this.f16632a.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            if (r6.equals(((i) ZeusTransformUtils.preCheckCast(this.f16632a.get(r1), i.class, "com.obric.memorydata.plugin")).getClass()) == true) goto L6;
            r1 = r1 + 1;
            goto L3
        L6:
            this.f16632a.remove(r1);
        L8:
            return this;
        }

        @Override // io.noties.markwon.inlineparser.j.b
        public InlineParserFactory a() {
            return new d(this.c, this.d, this.f16632a, this.f16633b);
        }

        public b b() {
            this.c = true;
            this.f16632a.addAll(Arrays.asList(new i[]{new io.noties.markwon.inlineparser.a(), new io.noties.markwon.inlineparser.b(), new io.noties.markwon.inlineparser.c(), new io.noties.markwon.inlineparser.d(), new e(), new f(), new g(), new n(), new o()}));
            this.f16633b.addAll(Arrays.asList(new EmphasisDelimiterProcessor[]{new AsteriskDelimiterProcessor(), new UnderscoreDelimiterProcessor()}));
            return this;
        }
    }

    static class d implements InlineParserFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f16634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f16635b;
        private final List<i> c;
        private final List<DelimiterProcessor> d;

        d(boolean r3, boolean r4, List<i> r5, List<DelimiterProcessor> r6) {
            List<i> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            List<DelimiterProcessor> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            this.f16634a = r3;
            this.f16635b = r4;
            this.c = r7;
            this.d = r8;
        }

        @Override // org.commonmark.parser.InlineParserFactory
        public InlineParser create(InlineParserContext r7) {
            InlineParserContext r1 = (InlineParserContext) ZeusTransformUtils.wrapperContextForParams(r7, InlineParserContext.class, "com.obric.memorydata.plugin");
            List<DelimiterProcessor> r8 = r1.getCustomDelimiterProcessors();
            if (r8 == null) goto L5;
            int r0 = r8.size();
        L6:
            if (r0 <= 0) goto L8;
            ArrayList r2 = new ArrayList(r0 + this.d.size());
            r2.addAll(this.d);
            r2.addAll(r8);
            List<DelimiterProcessor> r5 = r2;
        L10:
            return new j(r1, this.f16634a, this.f16635b, this.c, r5);
        L8:
            r5 = this.d;
            goto L10
        L5:
            r0 = 0;
            goto L6
        }
    }

    static {
        c = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
        d = Pattern.compile("^ *(?:\n *)?");
        e = Pattern.compile("^[\\p{Zs}\t\r\n\f]");
        f16628a = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
        f16629b = Pattern.compile("\\s+");
    }

    public j(InlineParserContext r3, boolean r4, boolean r5, List<i> r6, List<DelimiterProcessor> r7) {
        InlineParserContext r8 = (InlineParserContext) ZeusTransformUtils.wrapperContextForParams(r3, InlineParserContext.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.f = r8;
        this.g = r4;
        this.h = r5;
        Map<Character, List<i>> r11 = a(r9);
        this.j = r11;
        Map<Character, DelimiterProcessor> r12 = b(r10);
        this.k = r12;
        this.i = a(r11.keySet(), r12.keySet());
    }

    public static b a() {
        return new c().b();
    }

    private static BitSet a(Set<Character> r4, Set<Character> r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        BitSet r0 = new BitSet();
        Iterator r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r0.set(((Character) ZeusTransformUtils.preCheckCast(r8.next(), Character.class, "com.obric.memorydata.plugin")).charValue());
        goto L4
    L6:
        Iterator r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        r0.set(((Character) ZeusTransformUtils.preCheckCast(r9.next(), Character.class, "com.obric.memorydata.plugin")).charValue());
        goto L8
    L10:
        return r0;
    }

    private static Map<Character, List<i>> a(List<i> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap(r7.size());
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        i r2 = (i) ZeusTransformUtils.preCheckCast(r8.next(), i.class, "com.obric.memorydata.plugin");
        char r3 = r2.a();
        List r4 = (List) ZeusTransformUtils.preCheckCast(r0.get(Character.valueOf(r3)), List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r4 = new ArrayList(1);
        r0.put(Character.valueOf(r3), r4);
    L8:
        r4.add(r2);
        goto L4
    L9:
        return r0;
    }

    private Node a(DelimiterProcessor r11, char r12) {
        a r13 = b((DelimiterProcessor) ZeusTransformUtils.wrapperContextForParams(r11, DelimiterProcessor.class, "com.obric.memorydata.plugin"), r12);
        if (r13 != null) goto L6;
        return null;
    L6:
        int r0 = r13.f16630a;
        int r1 = this.n;
        int r2 = r1 + r0;
        this.n = r2;
        Text r3 = a(this.m, r1, r2);
        Delimiter r4 = new Delimiter(r3, r12, r13.c, r13.f16631b, this.o);
        this.o = r4;
        r4.length = r0;
        this.o.originalLength = r0;
        if (this.o.previous == null) goto L9;
        Delimiter r14 = this.o.previous;
        r14.next = this.o;
    L9:
        return r3;
    }

    private static void a(char r2, DelimiterProcessor r3, Map<Character, DelimiterProcessor> r4) {
        if (((DelimiterProcessor) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")).put(Character.valueOf(r2), (DelimiterProcessor) ZeusTransformUtils.wrapperContextForParams(r3, DelimiterProcessor.class, "com.obric.memorydata.plugin")), DelimiterProcessor.class, "com.obric.memorydata.plugin")) != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + r2 + "'");
    }

    private static void a(Iterable<DelimiterProcessor> r6, Map<Character, DelimiterProcessor> r7) {
        Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L18;
        DelimiterProcessor r0 = (DelimiterProcessor) ZeusTransformUtils.preCheckCast(r10.next(), DelimiterProcessor.class, "com.obric.memorydata.plugin");
        char r2 = r0.getOpeningCharacter();
        char r3 = r0.getClosingCharacter();
        if (r2 == r3) goto L7;
        a(r2, r0, r9);
        a(r3, r0, r9);
        goto L4
    L7:
        DelimiterProcessor r4 = (DelimiterProcessor) ZeusTransformUtils.preCheckCast(r9.get(Character.valueOf(r2)), DelimiterProcessor.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L16;
        if (r4.getOpeningCharacter() != r4.getClosingCharacter()) goto L16;
        if (ZeusTransformUtils.instanceOf(r4, p.class) == false) goto L14;
        p r5 = (p) ZeusTransformUtils.preCheckCast(r4, p.class, "com.obric.memorydata.plugin");
    L15:
        r5.a(r0);
        r9.put(Character.valueOf(r2), r5);
        goto L4
    L14:
        p r11 = new p(r2);
        r11.a(r4);
        r5 = r11;
    L16:
        a(r2, r0, r9);
        goto L4
    }

    private void a(Delimiter r2, Delimiter r3) {
        Delimiter r4 = r3.previous;
    L3:
        if (r4 == null) goto L6;
        if (r4 == r2) goto L9;
        Delimiter r0 = r4.previous;
        c(r4);
        r4 = r0;
        goto L3
    L9:
        return;
    }

    private a b(DelimiterProcessor r10, char r11) {
        DelimiterProcessor r12 = (DelimiterProcessor) ZeusTransformUtils.wrapperContextForParams(r10, DelimiterProcessor.class, "com.obric.memorydata.plugin");
        int r0 = this.n;
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (b() != r11) goto L7;
        r2 = r2 + 1;
        this.n++;
        goto L4
    L7:
        if (r2 >= r12.getMinLength()) goto L10;
        this.n = r0;
        return null;
    L10:
        String r3 = "\n";
        if (r0 != 0) goto L13;
        String r5 = "\n";
    L14:
        char r6 = b();
        if (r6 == 0) goto L18;
        r3 = String.valueOf(r6);
    L18:
        Pattern r7 = c;
        boolean r8 = r7.matcher(r5).matches();
        Pattern r9 = e;
        boolean r13 = r9.matcher(r5).matches();
        boolean r14 = r7.matcher(r3).matches();
        boolean r4 = r9.matcher(r3).matches();
        if (r4 == true) goto L24;
        if (r14 == false) goto L23;
        if (r13 == true) goto L23;
        if (r8 == false) goto L24;
    L23:
        boolean r15 = true;
    L25:
        if (r13 == false) goto L27;
    L32:
        boolean r16 = false;
    L34:
        if (r11 != '_') goto L44;
        if (r15 == false) goto L39;
        if (r16 == false) goto L38;
        if (r8 == false) goto L39;
    L38:
        boolean r17 = true;
    L40:
        if (r16 == false) goto L54;
        if (r15 == false) goto L43;
        if (r14 == false) goto L54;
    L43:
        r1 = true;
    L54:
        this.n = r0;
        return new a(r2, r17, r1);
    L39:
        r17 = false;
        goto L40
    L44:
        if (r15 == true) goto L46;
    L48:
        boolean r18 = false;
    L49:
        if (r16 == true) goto L51;
    L53:
        r17 = r18;
        goto L54
    L51:
        if (r11 != r12.getClosingCharacter()) goto L53;
        r1 = true;
        goto L53
    L46:
        if (r11 != r12.getOpeningCharacter()) goto L48;
        r18 = true;
        goto L49
    L27:
        if (this.h == true) goto L31;
        if (r8 == false) goto L31;
        if (r4 == true) goto L31;
        if (r14 == false) goto L32;
    L31:
        r16 = true;
    L24:
        r15 = false;
        goto L25
    L13:
        r5 = this.m.substring(r0 - 1, r0);
        goto L14
    }

    private static Map<Character, DelimiterProcessor> b(List<DelimiterProcessor> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        a(r3, r0);
        return r0;
    }

    private void b(Delimiter r2) {
        r2.node.unlink();
        d(r2);
    }

    private void c(String r1) {
        this.m = r1;
        this.n = 0;
        this.o = null;
        this.p = null;
    }

    private void c(Delimiter r1) {
        d(r1);
    }

    private void d(Delimiter r3) {
        if (r3.previous == null) goto L6;
        Delimiter r0 = r3.previous;
        r0.next = r3.next;
    L6:
        if (r3.next != null) goto L8;
        this.o = r3.previous;
        return;
    L8:
        Delimiter r2 = r3.next;
        r2.previous = r3.previous;
    }

    private Node m() {
        char r0 = b();
        Node r1 = null;
        if (r0 != 0) goto L5;
        return null;
    L5:
        List r2 = (List) ZeusTransformUtils.preCheckCast(this.j.get(Character.valueOf(r0)), List.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L14;
        int r3 = this.n;
        Iterator r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L18;
        r1 = ((i) ZeusTransformUtils.preCheckCast(r4.next(), i.class, "com.obric.memorydata.plugin")).a(this);
        if (r1 != null) goto L18;
        this.n = r3;
    L18:
        if (r1 == null) goto L20;
        return r1;
    L20:
        this.n++;
        return a(String.valueOf(r0));
    L14:
        DelimiterProcessor r5 = (DelimiterProcessor) ZeusTransformUtils.preCheckCast(this.k.get(Character.valueOf(r0)), DelimiterProcessor.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L17;
        r1 = a(r5, r0);
        goto L18
    L17:
        r1 = n();
        goto L18
    }

    private Node n() {
        int r0 = this.n;
        int r1 = this.m.length();
    L3:
        int r2 = this.n;
        if (r2 == r1) goto L9;
        if (this.i.get(this.m.charAt(r2)) == true) goto L9;
        this.n++;
    L9:
        int r3 = this.n;
        if (r0 != r3) goto L12;
        return null;
    L12:
        return a(this.m, r0, r3);
    }

    @Override // io.noties.markwon.inlineparser.l
    public String a(Pattern r4) {
        if (this.n < this.m.length()) goto L5;
        return null;
    L5:
        Matcher r5 = r4.matcher(this.m);
        r5.region(this.n, this.m.length());
        if (r5.find() == false) goto L9;
        this.n = r5.end();
        return r5.group();
    L9:
        return null;
    }

    @Override // io.noties.markwon.inlineparser.l
    public Text a(String r1) {
        return new Text(r1);
    }

    @Override // io.noties.markwon.inlineparser.l
    public Text a(String r1, int r2, int r3) {
        return new Text(r1.substring(r2, r3));
    }

    @Override // io.noties.markwon.inlineparser.l
    public void a(int r1) {
        this.n = r1;
    }

    @Override // io.noties.markwon.inlineparser.l
    public void a(Bracket r3) {
        Bracket r0 = this.p;
        if (r0 == null) goto L5;
        r0.bracketAfter = true;
    L5:
        this.p = r3;
    }

    @Override // io.noties.markwon.inlineparser.l
    public void a(Delimiter r12) {
        HashMap r0 = new HashMap();
        Delimiter r1 = this.o;
    L3:
        if (r1 == null) goto L7;
        if (r1.previous == r12) goto L7;
        r1 = r1.previous;
    L7:
        if (r1 == null) goto L39;
        char r2 = r1.delimiterChar;
        DelimiterProcessor r3 = (DelimiterProcessor) ZeusTransformUtils.preCheckCast(this.k.get(Character.valueOf(r2)), DelimiterProcessor.class, "com.obric.memorydata.plugin");
        if (r1.canClose == false) goto L38;
        if (r3 == null) goto L38;
        char r4 = r3.getOpeningCharacter();
        Delimiter r5 = r1.previous;
        int r7 = 0;
        boolean r8 = false;
    L13:
        boolean r9 = true;
        if (r5 == null) goto L26;
        if (r5 == r12) goto L26;
        if (r5 == r0.get(Character.valueOf(r2))) goto L26;
        if (r5.canOpen == false) goto L25;
        if (r5.delimiterChar != r4) goto L25;
        r7 = r3.getDelimiterUse(r5, r1);
        r8 = true;
        if (r7 <= 0) goto L25;
    L27:
        if (r9 == true) goto L32;
        if (r8 == true) goto L38;
        r0.put(Character.valueOf(r2), r1.previous);
        if (r1.canOpen == true) goto L38;
        c(r1);
        goto L38
    L32:
        Text r6 = r5.node;
        Text r10 = r1.node;
        r5.length -= r7;
        r1.length -= r7;
        r6.setLiteral(r6.getLiteral().substring(0, r6.getLiteral().length() - r7));
        r10.setLiteral(r10.getLiteral().substring(0, r10.getLiteral().length() - r7));
        a(r5, r1);
        h.a(r6, r10);
        r3.process(r6, r10, r7);
        if (r5.length != 0) goto L36;
        b(r5);
    L36:
        if (r1.length != 0) goto L7;
        Delimiter r11 = r1.next;
        b(r1);
        r1 = r11;
    L25:
        r5 = r5.previous;
    L26:
        r9 = false;
    L38:
        r1 = r1.next;
    L39:
        Delimiter r13 = this.o;
        if (r13 == null) goto L43;
        if (r13 == r12) goto L66;
        c(r13);
        goto L39
    L66:
        return;
    }

    @Override // io.noties.markwon.inlineparser.l
    public char b() {
        if (this.n < this.m.length()) goto L5;
        return 0;
    L5:
        return this.m.charAt(this.n);
    }

    @Override // io.noties.markwon.inlineparser.l
    public LinkReferenceDefinition b(String r2) {
        if (this.g == true) goto L7;
        return null;
    L7:
        return this.f.getLinkReferenceDefinition(r2);
    }

    @Override // io.noties.markwon.inlineparser.l
    public Node c() {
        return this.l;
    }

    @Override // io.noties.markwon.inlineparser.l
    public String d() {
        return this.m;
    }

    @Override // io.noties.markwon.inlineparser.l
    public int e() {
        return this.n;
    }

    @Override // io.noties.markwon.inlineparser.l
    public Bracket f() {
        return this.p;
    }

    @Override // io.noties.markwon.inlineparser.l
    public Delimiter g() {
        return this.o;
    }

    @Override // io.noties.markwon.inlineparser.l
    public void h() {
        this.p = this.p.previous;
    }

    @Override // io.noties.markwon.inlineparser.l
    public void i() {
        a(d);
    }

    @Override // io.noties.markwon.inlineparser.l
    public String j() {
        int r0 = LinkScanner.scanLinkDestination(this.m, this.n);
        if (r0 != (-1)) goto L7;
        return null;
    L7:
        if (b() != '<') goto L9;
        String r1 = this.m.substring(this.n + 1, r0 - 1);
    L10:
        this.n = r0;
        return Escaping.unescapeString(r1);
    L9:
        r1 = this.m.substring(this.n, r0);
        goto L10
    }

    @Override // io.noties.markwon.inlineparser.l
    public String k() {
        int r0 = LinkScanner.scanLinkTitle(this.m, this.n);
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        String r1 = this.m.substring(this.n + 1, r0 - 1);
        this.n = r0;
        return Escaping.unescapeString(r1);
    }

    @Override // io.noties.markwon.inlineparser.l
    public int l() {
        if (this.n < this.m.length()) goto L5;
    L19:
        return 0;
    L5:
        if (this.m.charAt(this.n) != '[') goto L19;
        int r0 = this.n + 1;
        int r1 = LinkScanner.scanLinkLabelContent(this.m, r0);
        int r2 = r1 - r0;
        if (r1 == (-1)) goto L19;
        if (r2 > 999) goto L19;
        if (r1 >= this.m.length()) goto L19;
        if (this.m.charAt(r1) != ']') goto L19;
        this.n = r1 + 1;
        return r2 + 2;
    }

    @Override // org.commonmark.parser.InlineParser
    public void parse(String r1, Node r2) {
        c(r1.trim());
        this.l = r2;
    L3:
        Node r3 = m();
        if (r3 == null) goto L6;
        r2.appendChild(r3);
        goto L3
    L6:
        a(null);
        h.a(r2);
    }
}
