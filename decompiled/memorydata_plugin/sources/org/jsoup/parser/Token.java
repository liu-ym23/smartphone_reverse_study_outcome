package org.jsoup.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import okio.Utf8;

/* JADX INFO: loaded from: classes7.dex */
abstract class Token {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TokenType f18276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18277b;
    private int c;

    /* JADX INFO: renamed from: org.jsoup.parser.Token$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final enum TokenType extends Enum<TokenType> {
        private static final /* synthetic */ TokenType[] $VALUES = null;
        public static final TokenType Character = null;
        public static final TokenType Comment = null;
        public static final TokenType Doctype = null;
        public static final TokenType EOF = null;
        public static final TokenType EndTag = null;
        public static final TokenType StartTag = null;

        private static /* synthetic */ TokenType[] $values() {
            return new TokenType[]{Doctype, StartTag, EndTag, Comment, Character, EOF};
        }

        static {
            Doctype = new TokenType("Doctype", 0);
            StartTag = new TokenType("StartTag", 1);
            EndTag = new TokenType("EndTag", 2);
            Comment = new TokenType("Comment", 3);
            Character = new TokenType("Character", 4);
            EOF = new TokenType("EOF", 5);
            $VALUES = $values();
        }

        private TokenType(String r1, int r2) {
            super(r1, r2);
        }

        public static TokenType valueOf(String r2) {
            return (TokenType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TokenType.class, r2), TokenType.class, "com.obric.memorydata.plugin");
        }

        public static TokenType[] values() {
            return (TokenType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TokenType[].class, "com.obric.memorydata.plugin");
        }
    }

    static final class a extends b {
        a(String r1) {
            a(r1);
        }

        @Override // org.jsoup.parser.Token.b
        public String toString() {
            return "<![CDATA[" + q() + "]]>";
        }
    }

    static class b extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f18278b;

        b() {
            super(null);
            this.f18276a = TokenType.Character;
        }

        b a(String r1) {
            this.f18278b = r1;
            return this;
        }

        @Override // org.jsoup.parser.Token
        Token b() {
            super.b();
            this.f18278b = null;
            return this;
        }

        String q() {
            return this.f18278b;
        }

        public String toString() {
            return q();
        }
    }

    static final class c extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f18279b;
        private final StringBuilder c;
        private String d;

        c() {
            super(null);
            this.c = new StringBuilder();
            this.f18279b = false;
            this.f18276a = TokenType.Comment;
        }

        private void r() {
            String r0 = this.d;
            if (r0 == null) goto L6;
            this.c.append(r0);
            this.d = null;
            return;
        }

        final c a(char r2) {
            r();
            this.c.append(r2);
            return this;
        }

        final c a(String r2) {
            r();
            if (this.c.length() != 0) goto L5;
            this.d = r2;
        L6:
            return this;
        L5:
            this.c.append(r2);
            goto L6
        }

        @Override // org.jsoup.parser.Token
        Token b() {
            super.b();
            a(this.c);
            this.d = null;
            this.f18279b = false;
            return this;
        }

        String q() {
            String r0 = this.d;
            if (r0 == null) goto L6;
            return r0;
        L6:
            return this.c.toString();
        }

        public String toString() {
            return "<!--" + q() + "-->";
        }
    }

    static final class d extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final StringBuilder f18280b;
        String c;
        final StringBuilder d;
        final StringBuilder e;
        boolean f;

        d() {
            super(null);
            this.f18280b = new StringBuilder();
            this.c = null;
            this.d = new StringBuilder();
            this.e = new StringBuilder();
            this.f = false;
            this.f18276a = TokenType.Doctype;
        }

        @Override // org.jsoup.parser.Token
        Token b() {
            super.b();
            a(this.f18280b);
            this.c = null;
            a(this.d);
            a(this.e);
            this.f = false;
            return this;
        }

        String q() {
            return this.f18280b.toString();
        }

        String r() {
            return this.c;
        }

        String s() {
            return this.d.toString();
        }

        public String t() {
            return this.e.toString();
        }

        public String toString() {
            return "<!doctype " + q() + ">";
        }

        public boolean u() {
            return this.f;
        }
    }

    static final class e extends Token {
        e() {
            super(null);
            this.f18276a = TokenType.EOF;
        }

        @Override // org.jsoup.parser.Token
        Token b() {
            super.b();
            return this;
        }

        public String toString() {
            return "";
        }
    }

    static final class f extends h {
        f() {
            this.f18276a = TokenType.EndTag;
        }

        public String toString() {
            return "</" + w() + ">";
        }
    }

    static final class g extends h {
        g() {
            this.f18276a = TokenType.StartTag;
        }

        g a(String r1, org.jsoup.nodes.b r2) {
            this.f18281b = r1;
            this.e = r2;
            this.c = org.jsoup.parser.d.c(this.f18281b);
            return this;
        }

        @Override // org.jsoup.parser.Token.h, org.jsoup.parser.Token
        /* synthetic */ Token b() {
            return q();
        }

        @Override // org.jsoup.parser.Token.h
        h q() {
            super.q();
            this.e = null;
            return this;
        }

        public String toString() {
            if (s() == true) goto L5;
        L9:
            StringBuilder r0 = new StringBuilder().append("<");
            String r3 = w();
        L8:
            return r0.append(r3).append(">").toString();
        L5:
            if (this.e.a() <= 0) goto L9;
            r0 = new StringBuilder().append("<").append(w()).append(" ");
            r3 = this.e.toString();
            goto L8
        }
    }

    static abstract class h extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f18281b;
        protected String c;
        boolean d;
        org.jsoup.nodes.b e;
        private final StringBuilder f;
        private String g;
        private boolean h;
        private final StringBuilder i;
        private String j;
        private boolean k;
        private boolean l;

        h() {
            super(null);
            this.f = new StringBuilder();
            this.h = false;
            this.i = new StringBuilder();
            this.k = false;
            this.l = false;
            this.d = false;
        }

        private void A() {
            this.k = true;
            String r0 = this.j;
            if (r0 == null) goto L6;
            this.i.append(r0);
            this.j = null;
            return;
        }

        private void z() {
            this.h = true;
            String r0 = this.g;
            if (r0 == null) goto L6;
            this.f.append(r0);
            this.g = null;
            return;
        }

        final void a(char r1) {
            c(String.valueOf(r1));
        }

        final void a(int[] r5) {
            A();
            int r0 = r5.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            int r2 = r5[r1];
            this.i.appendCodePoint(r2);
            r1 = r1 + 1;
            goto L3
        }

        final boolean a(String r1) {
            org.jsoup.nodes.b r0 = this.e;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.g(r1) == false) goto L7;
            return true;
        }

        final h b(String r1) {
            this.f18281b = r1;
            this.c = org.jsoup.parser.d.c(r1);
            return this;
        }

        @Override // org.jsoup.parser.Token
        /* synthetic */ Token b() {
            return q();
        }

        final void b(char r1) {
            z();
            this.f.append(r1);
        }

        final void c(char r1) {
            A();
            this.i.append(r1);
        }

        final void c(String r3) {
            String r4 = r3.replace(0, Utf8.REPLACEMENT_CHARACTER);
            String r0 = this.f18281b;
            if (r0 == null) goto L6;
            r4 = r0.concat(r4);
        L6:
            this.f18281b = r4;
            this.c = org.jsoup.parser.d.c(r4);
        }

        final void d(String r3) {
            String r4 = r3.replace(0, Utf8.REPLACEMENT_CHARACTER);
            z();
            if (this.f.length() != 0) goto L5;
            this.g = r4;
            return;
        L5:
            this.f.append(r4);
        }

        final void e(String r2) {
            A();
            if (this.i.length() != 0) goto L5;
            this.j = r2;
            return;
        L5:
            this.i.append(r2);
        }

        h q() {
            super.b();
            this.f18281b = null;
            this.c = null;
            a(this.f);
            this.g = null;
            this.h = false;
            a(this.i);
            this.j = null;
            this.l = false;
            this.k = false;
            this.d = false;
            this.e = null;
            return this;
        }

        final void r() {
            if (this.e != null) goto L6;
            this.e = new org.jsoup.nodes.b();
        L6:
            if (this.h == true) goto L8;
        L26:
            a(this.f);
            this.g = null;
            this.h = false;
            a(this.i);
            this.j = null;
            this.k = false;
            this.l = false;
            return;
        L8:
            if (this.e.a() >= 512) goto L26;
            if (this.f.length() <= 0) goto L12;
            String r0 = this.f.toString();
        L13:
            String r1 = r0.trim();
            if (r1.length() <= 0) goto L26;
            if (this.k == false) goto L22;
            if (this.i.length() <= 0) goto L20;
            String r2 = this.i.toString();
        L25:
            this.e.a(r1, r2);
            goto L26
        L20:
            r2 = this.j;
            goto L25
        L22:
            if (this.l == false) goto L24;
            r2 = "";
            goto L25
        L24:
            r2 = null;
            goto L25
        L12:
            r0 = this.g;
            goto L13
        }

        final boolean s() {
            if (this.e == null) goto L5;
            return true;
        L5:
            return false;
        }

        final void t() {
            if (this.h == false) goto L6;
            r();
            return;
        }

        final String u() {
            String r0 = this.f18281b;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            org.jsoup.helper.b.b(r1);
            return this.f18281b;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        final String v() {
            return this.c;
        }

        final String w() {
            String r0 = this.f18281b;
            if (r0 != null) goto L7;
            return "[unset]";
        L7:
            return r0;
        }

        final boolean x() {
            return this.d;
        }

        final void y() {
            this.l = true;
        }
    }

    private Token() {
        this.c = -1;
    }

    /* synthetic */ Token(AnonymousClass1 r1) {
        this();
    }

    static void a(StringBuilder r2) {
        if (r2 == null) goto L5;
        r2.delete(0, r2.length());
        return;
    }

    String a() {
        return getClass().getSimpleName();
    }

    void a(int r1) {
        this.f18277b = r1;
    }

    Token b() {
        this.f18277b = -1;
        this.c = -1;
        return this;
    }

    void b(int r1) {
        this.c = r1;
    }

    int c() {
        return this.f18277b;
    }

    int d() {
        return this.c;
    }

    final boolean e() {
        if (this.f18276a != TokenType.Doctype) goto L5;
        return true;
    L5:
        return false;
    }

    final d f() {
        return (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");
    }

    final boolean g() {
        if (this.f18276a != TokenType.StartTag) goto L5;
        return true;
    L5:
        return false;
    }

    final g h() {
        return (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");
    }

    final boolean i() {
        if (this.f18276a != TokenType.EndTag) goto L5;
        return true;
    L5:
        return false;
    }

    final f j() {
        return (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin");
    }

    final boolean k() {
        if (this.f18276a != TokenType.Comment) goto L5;
        return true;
    L5:
        return false;
    }

    final c l() {
        return (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");
    }

    final boolean m() {
        if (this.f18276a != TokenType.Character) goto L5;
        return true;
    L5:
        return false;
    }

    final boolean n() {
        return ZeusTransformUtils.instanceOf(this, a.class);
    }

    final b o() {
        return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
    }

    final boolean p() {
        if (this.f18276a != TokenType.EOF) goto L5;
        return true;
    L5:
        return false;
    }
}
