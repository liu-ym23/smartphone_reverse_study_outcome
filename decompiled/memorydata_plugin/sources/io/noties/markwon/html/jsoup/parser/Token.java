package io.noties.markwon.html.jsoup.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Token {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TokenType f16583a;

    public static final enum TokenType extends Enum<TokenType> {
        private static final /* synthetic */ TokenType[] $VALUES = null;
        public static final TokenType Character = null;
        public static final TokenType Comment = null;
        public static final TokenType Doctype = null;
        public static final TokenType EOF = null;
        public static final TokenType EndTag = null;
        public static final TokenType StartTag = null;

        static {
            TokenType r0 = new TokenType("Doctype", 0);
            Doctype = r0;
            TokenType r1 = new TokenType("StartTag", 1);
            StartTag = r1;
            TokenType r3 = new TokenType("EndTag", 2);
            EndTag = r3;
            TokenType r5 = new TokenType("Comment", 3);
            Comment = r5;
            TokenType r7 = new TokenType("Character", 4);
            Character = r7;
            TokenType r9 = new TokenType("EOF", 5);
            EOF = r9;
            $VALUES = new TokenType[]{r0, r1, r3, r5, r7, r9};
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

    public static final class a extends b {
        a(String r1) {
            a(r1);
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token.b
        public String toString() {
            return "<![CDATA[" + b() + "]]>";
        }
    }

    public static class b extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f16584b;

        b() {
            super(TokenType.Character);
        }

        b a(String r1) {
            this.f16584b = r1;
            return this;
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token a() {
            this.f16584b = null;
            return this;
        }

        public String b() {
            return this.f16584b;
        }

        public String toString() {
            return b();
        }
    }

    public static final class c extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final StringBuilder f16585b;
        boolean c;

        c() {
            super(TokenType.Comment);
            this.f16585b = new StringBuilder();
            this.c = false;
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token a() {
            a(this.f16585b);
            this.c = false;
            return this;
        }

        String b() {
            return this.f16585b.toString();
        }

        public String toString() {
            return "<!--" + b() + "-->";
        }
    }

    public static final class d extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final StringBuilder f16586b;
        String c;
        final StringBuilder d;
        final StringBuilder e;
        boolean f;

        d() {
            super(TokenType.Doctype);
            this.f16586b = new StringBuilder();
            this.c = null;
            this.d = new StringBuilder();
            this.e = new StringBuilder();
            this.f = false;
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token a() {
            a(this.f16586b);
            this.c = null;
            a(this.d);
            a(this.e);
            this.f = false;
            return this;
        }
    }

    public static final class e extends Token {
        e() {
            super(TokenType.EOF);
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token a() {
            return this;
        }
    }

    public static final class f extends h {
        f() {
            super(TokenType.EndTag);
        }

        public String toString() {
            return "</" + e() + ">";
        }
    }

    public static final class g extends h {
        public g() {
            super(TokenType.StartTag);
            this.e = new io.noties.markwon.html.jsoup.nodes.b();
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token.h, io.noties.markwon.html.jsoup.parser.Token
        public /* synthetic */ Token a() {
            return b();
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token.h
        public h b() {
            super.b();
            this.e = new io.noties.markwon.html.jsoup.nodes.b();
            return this;
        }

        public String toString() {
            if (this.e != null) goto L5;
        L9:
            StringBuilder r0 = new StringBuilder().append("<");
            String r3 = e();
        L8:
            return r0.append(r3).append(">").toString();
        L5:
            if (this.e.a() <= 0) goto L9;
            r0 = new StringBuilder().append("<").append(e()).append(" ");
            r3 = this.e.toString();
            goto L8
        }
    }

    public static abstract class h extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16587b;
        public String c;
        public boolean d;
        public io.noties.markwon.html.jsoup.nodes.b e;
        private String f;
        private StringBuilder g;
        private String h;
        private boolean i;
        private boolean j;

        public h(TokenType r1) {
            super(r1);
            this.g = new StringBuilder();
            this.i = false;
            this.j = false;
            this.d = false;
        }

        private void g() {
            this.j = true;
            String r0 = this.h;
            if (r0 == null) goto L6;
            this.g.append(r0);
            this.h = null;
            return;
        }

        final h a(String r1) {
            this.f16587b = r1;
            this.c = io.noties.markwon.html.jsoup.a.a.a(r1);
            return this;
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public /* synthetic */ Token a() {
            return b();
        }

        final void a(char r1) {
            b(String.valueOf(r1));
        }

        final void a(int[] r5) {
            g();
            int r0 = r5.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            int r2 = r5[r1];
            this.g.appendCodePoint(r2);
            r1 = r1 + 1;
            goto L3
        }

        public h b() {
            this.f16587b = null;
            this.c = null;
            this.f = null;
            a(this.g);
            this.h = null;
            this.i = false;
            this.j = false;
            this.d = false;
            this.e = null;
            return this;
        }

        final void b(char r1) {
            c(String.valueOf(r1));
        }

        final void b(String r2) {
            String r0 = this.f16587b;
            if (r0 == null) goto L6;
            r2 = r0.concat(r2);
        L6:
            this.f16587b = r2;
            this.c = io.noties.markwon.html.jsoup.a.a.a(r2);
        }

        final void c() {
            if (this.e != null) goto L5;
            this.e = new io.noties.markwon.html.jsoup.nodes.b();
        L5:
            String r0 = this.f;
            if (r0 == null) goto L20;
            String r1 = r0.trim();
            this.f = r1;
            if (r1.length() <= 0) goto L20;
            if (this.j == false) goto L16;
            if (this.g.length() <= 0) goto L14;
            String r2 = this.g.toString();
        L19:
            this.e.a(this.f, r2);
            goto L20
        L14:
            r2 = this.h;
            goto L19
        L16:
            if (this.i == false) goto L18;
            r2 = "";
            goto L19
        L18:
            r2 = null;
        L20:
            this.f = null;
            this.i = false;
            this.j = false;
            a(this.g);
            this.h = null;
        }

        final void c(char r1) {
            g();
            this.g.append(r1);
        }

        final void c(String r2) {
            String r0 = this.f;
            if (r0 == null) goto L6;
            r2 = r0.concat(r2);
        L6:
            this.f = r2;
        }

        final void d() {
            if (this.f == null) goto L6;
            c();
            return;
        }

        final void d(String r2) {
            g();
            if (this.g.length() != 0) goto L5;
            this.h = r2;
            return;
        L5:
            this.g.append(r2);
        }

        final String e() {
            String r0 = this.f16587b;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            io.noties.markwon.html.jsoup.a.b.b(r1);
            return this.f16587b;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        final void f() {
            this.i = true;
        }
    }

    public Token(TokenType r1) {
        this.f16583a = r1;
    }

    static void a(StringBuilder r2) {
        if (r2 == null) goto L5;
        r2.delete(0, r2.length());
        return;
    }

    public abstract Token a();
}
