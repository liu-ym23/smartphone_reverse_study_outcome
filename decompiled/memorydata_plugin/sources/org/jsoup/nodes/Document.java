package org.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public class Document extends Element {
    private static final org.jsoup.select.c k = null;
    private OutputSettings f;
    private org.jsoup.parser.e g;
    private QuirksMode h;
    private final String i;
    private boolean j;

    public static class OutputSettings implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Entities.CoreCharset f18247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Entities.EscapeMode f18248b;
        private Charset c;
        private final ThreadLocal<CharsetEncoder> d;
        private boolean e;
        private boolean f;
        private int g;
        private int h;
        private Syntax i;

        public static final enum Syntax extends Enum<Syntax> {
            private static final /* synthetic */ Syntax[] $VALUES = null;
            public static final Syntax html = null;
            public static final Syntax xml = null;

            private static /* synthetic */ Syntax[] $values() {
                return new Syntax[]{html, xml};
            }

            static {
                html = new Syntax("html", 0);
                xml = new Syntax("xml", 1);
                $VALUES = $values();
            }

            private Syntax(String r1, int r2) {
                super(r1, r2);
            }

            public static Syntax valueOf(String r2) {
                return (Syntax) ZeusTransformUtils.preCheckCast(Enum.valueOf(Syntax.class, r2), Syntax.class, "com.obric.memorydata.plugin");
            }

            public static Syntax[] values() {
                return (Syntax[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Syntax[].class, "com.obric.memorydata.plugin");
            }
        }

        public OutputSettings() {
            this.f18248b = Entities.EscapeMode.base;
            this.c = org.jsoup.helper.a.f18245a;
            this.d = new ThreadLocal();
            this.e = true;
            this.f = false;
            this.g = 1;
            this.h = 30;
            this.i = Syntax.html;
        }

        public OutputSettings a(String r1) {
            a(Charset.forName(r1));
            return this;
        }

        public OutputSettings a(Charset r1) {
            this.c = r1;
            return this;
        }

        public Entities.EscapeMode a() {
            return this.f18248b;
        }

        CharsetEncoder b() {
            CharsetEncoder r0 = this.c.newEncoder();
            this.d.set(r0);
            this.f18247a = Entities.CoreCharset.byName(r0.charset().name());
            return r0;
        }

        CharsetEncoder c() {
            CharsetEncoder r0 = (CharsetEncoder) ZeusTransformUtils.preCheckCast(this.d.get(), CharsetEncoder.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L6;
            return r0;
        L6:
            return b();
        }

        public /* synthetic */ Object clone() {
            return i();
        }

        public Syntax d() {
            return this.i;
        }

        public boolean e() {
            return this.e;
        }

        public boolean f() {
            return this.f;
        }

        public int g() {
            return this.g;
        }

        public int h() {
            return this.h;
        }

        public OutputSettings i() {
            OutputSettings r0 = (OutputSettings) ZeusTransformUtils.preCheckCast(super.clone(), OutputSettings.class, "com.obric.memorydata.plugin");     // Catch: CloneNotSupportedException -> L5
            r0.a(this.c.name());
            r0.f18248b = Entities.EscapeMode.valueOf(this.f18248b.name());
            return r0;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }
    }

    public static final enum QuirksMode extends Enum<QuirksMode> {
        private static final /* synthetic */ QuirksMode[] $VALUES = null;
        public static final QuirksMode limitedQuirks = null;
        public static final QuirksMode noQuirks = null;
        public static final QuirksMode quirks = null;

        private static /* synthetic */ QuirksMode[] $values() {
            return new QuirksMode[]{noQuirks, quirks, limitedQuirks};
        }

        static {
            noQuirks = new QuirksMode("noQuirks", 0);
            quirks = new QuirksMode("quirks", 1);
            limitedQuirks = new QuirksMode("limitedQuirks", 2);
            $VALUES = $values();
        }

        private QuirksMode(String r1, int r2) {
            super(r1, r2);
        }

        public static QuirksMode valueOf(String r2) {
            return (QuirksMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(QuirksMode.class, r2), QuirksMode.class, "com.obric.memorydata.plugin");
        }

        public static QuirksMode[] values() {
            return (QuirksMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), QuirksMode[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        k = new org.jsoup.select.c.an("title");
    }

    public Document(String r3) {
        super(org.jsoup.parser.f.a("#root", org.jsoup.parser.d.f18288a), r3);
        this.f = new OutputSettings();
        this.h = QuirksMode.noQuirks;
        this.j = false;
        this.i = r3;
        this.g = org.jsoup.parser.e.f();
    }

    private Element ai() {
        Iterator<Element> r0 = z().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin");
        if (r1.r().equals("html") == false) goto L4;
        return r1;
    L9:
        return j("html");
    }

    public static Document e(String r2) {
        org.jsoup.helper.b.a(r2);
        Document r0 = new Document(r2);
        r0.g = r0.l();
        Element r3 = r0.j("html");
        r3.j("head");
        r3.j("body");
        return r0;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.j
    public String a() {
        return "#document";
    }

    public Document a(OutputSettings r1) {
        org.jsoup.helper.b.a(r1);
        this.f = r1;
        return this;
    }

    public Document a(QuirksMode r1) {
        this.h = r1;
        return this;
    }

    public Document a(org.jsoup.parser.e r1) {
        this.g = r1;
        return this;
    }

    public Element b() {
        Element r5 = ai();
        Iterator<Element> r0 = r5.z().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin");
        if ("body".equals(r1.r()) == true) goto L9;
        if ("frameset".equals(r1.r()) == false) goto L4;
    L9:
        return r1;
    L11:
        return r5.j("body");
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.j
    public /* synthetic */ Object clone() {
        return h();
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.j
    public /* synthetic */ j d() {
        return h();
    }

    @Override // org.jsoup.nodes.Element
    public Element f(String r2) {
        b().f(r2);
        return this;
    }

    public Document h() {
        Document r0 = (Document) ZeusTransformUtils.preCheckCast(super.m(), Document.class, "com.obric.memorydata.plugin");
        r0.f = this.f.i();
        return r0;
    }

    public Document i() {
        Document r0 = new Document(g());
        if (this.f18250b == null) goto L5;
        r0.f18250b = this.f18250b.e();
    L5:
        r0.f = this.f.i();
        return r0;
    }

    public OutputSettings j() {
        return this.f;
    }

    public QuirksMode k() {
        return this.h;
    }

    public org.jsoup.parser.e l() {
        return this.g;
    }

    @Override // org.jsoup.nodes.Element
    public /* synthetic */ Element m() {
        return h();
    }

    @Override // org.jsoup.nodes.j
    public String x_() {
        return super.R();
    }
}
