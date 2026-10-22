package tsc;

import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.noties.markwon.html.jsoup.parser.ParseErrorList;
import io.noties.markwon.html.jsoup.parser.Token;
import io.noties.markwon.html.tag.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class h extends lsc.a {
    public final v.a a;
    public final a b;
    public r c;
    public s d;
    public final g e;

    public static class a {
        public final Map<String, a0> a;
        public final Set<String> b;
        public final Set<String> c;
        public boolean d;

        public a() {
            this.a = new HashMap(2);
            this.b = new HashSet();
            this.c = new HashSet();
        }

        public final void a(a0 r4) {
            Iterator<String> r0 = r4.c().iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            String r1 = r0.next();
            if (((HashMap) this.a).containsKey(r1) == true) goto L4;
            ((HashMap) this.a).put(r1, r4);
            goto L4
        }
    }

    public h() {
        this.e = new g();
        this.a = new v.a();
        this.b = new a();
    }

    @Override // lsc.a, lsc.j
    public final void g(lsc.h.a r11) {
        v.a r12 = this.a;
        this.b.getClass();
        this.b.a(new io.noties.markwon.html.tag.e(new io.noties.markwon.html.tag.f(new c.a())));
        this.b.a(new io.noties.markwon.html.tag.g());
        this.b.a(new io.noties.markwon.html.tag.a());
        this.b.a(new io.noties.markwon.html.tag.l());
        this.b.a(new io.noties.markwon.html.tag.m());
        this.b.a(new io.noties.markwon.html.tag.k());
        this.b.a(new io.noties.markwon.html.tag.j());
        this.b.a(new io.noties.markwon.html.tag.n());
        this.b.a(new io.noties.markwon.html.tag.h());
        this.b.a(new b());
        this.b.a(new io.noties.markwon.html.tag.c());
        a r0 = this.b;
        if (r0.d == true) goto L19;
        r0.d = true;
        Map<String, a0> r1 = Collections.unmodifiableMap(r0.a);
        g r4 = this.e;
        a r3 = this.b;
        Set<String> r7 = r3.b;
        Set<String> r8 = r3.c;
        this.c = new r(r4, r1, new b0.a(), r7, r8);
        boolean r5 = r12.c;
        if (r5 == true) goto L17;
        r12.a = r1;
        if (r5 == true) goto L15;
        r12.c = true;
        if (r1.size() <= 0) goto L11;
        v r2 = new v(r12.b, r12.a);
    L12:
        this.d = r2;
        return;
    L11:
        r2 = new w();
        goto L12
    L15:
        throw new IllegalStateException("Builder has been already built");
    L17:
        throw new IllegalStateException("Builder has been already built");
    L19:
        throw new IllegalStateException("Builder has been already built");
    }

    public final void n(a0 r5) {
        a r0 = this.b;
        if (r0.d == true) goto L10;
        Iterator<String> r1 = r5.c().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        String r2 = r1.next();
        ((HashMap) r0.a).put(r2, r5);
        goto L6
    L8:
        return;
    L10:
        throw new IllegalStateException("Builder has been already built");
    }

    public void o(lsc.m r13, String r14) {
        if (r14 == null) goto L154;
        r r0 = this.c;
        lsc.y r15 = r13.builder();
        r0.getClass();
        io.noties.markwon.html.jsoup.parser.c r1 = new io.noties.markwon.html.jsoup.parser.c(new io.noties.markwon.html.jsoup.parser.a(r14), ParseErrorList.noTracking());
    L4:
        Token.b r16 = r1.o();
        Token.TokenType r2 = ((Token) r16).a;
        if (Token.TokenType.EOF == r2) goto L181;
        int r3 = r.a.a[r2.ordinal()];
        boolean r4 = true;
        if (r3 == 1) goto L92;
        if (r3 != 2) goto L11;
        Token.f r5 = (Token.f) r16;
        if (r.j.contains(((Token.h) r5).c) == false) goto L50;
    L79:
        String r6 = ((Token.h) r5).c;
        int r7 = ((ArrayList) r0.f).size() - 1;
    L80:
        if (r7 <= (-1)) goto L87;
        m r8 = (m.b) ListProtector.get(r0.f, r7);
        if (r6.equals(r8.a) == false) goto L86;
        if (r8.d >= 0) goto L86;
    L88:
        if (r8 == null) goto L153;
        r8.e = r15.subSequence(r8.b, r15.length()).toString();
        r0.b(r15, r8);
        int r9 = r15.length();
        if (r8.isClosed() == true) goto L153;
        r8.d = r9;
    L153:
        r16.a();
    L86:
        r7 = r7 - 1;
        goto L80
    L87:
        r8 = null;
        goto L88
    L50:
        if (r0.e.contains(((Token.h) r5).c) == true) goto L79;
        String r10 = ((Token.h) r5).c;
        m.a r11 = r0.g;
    L53:
        if (r11 == null) goto L59;
        if (r10.equals(r11.a) == true) goto L59;
        if (r11.isClosed() == true) goto L59;
        r11 = r11.f;
    L59:
        if (r11 == null) goto L153;
        if ("pre".equals(r10) == false) goto L63;
        r0.h = false;
    L63:
        r11.e = r15.subSequence(r11.b, r15.length()).toString();
        r0.b(r15, r11);
        r11.c(r15.length());
        if (r11.b != r11.d) goto L66;
        boolean r12 = true;
    L67:
        if (r12 == true) goto L76;
        if (r.l.contains(r11.a) == false) goto L71;
    L74:
        r0.i = r4;
        goto L76
    L71:
        if (r0.d.contains(r10) == true) goto L74;
        r4 = false;
    L76:
        if ("p".equals(r10) == false) goto L78;
        tsc.a.a(r15, '\n');
    L78:
        r0.g = r11.f;
        goto L153
    L66:
        r12 = false;
        goto L67
    L11:
        if (r3 != 3) goto L153;
        Token.b r17 = r16;
        if (r0.h == false) goto L22;
        r15.append(r17.b);     // Catch: IOException -> L18
    L18:
        e = move-exception;
        throw new RuntimeException(e);
    L22:
        if (r0.i == false) goto L29;
        int r18 = r15.length();
        if (r18 > 0) goto L26;
    L28:
        r0.i = false;
        goto L29
    L26:
        if ('\n' == r15.charAt(r18 - 1)) goto L28;
        tsc.a.a(r15, '\n');
    L29:
        b0 r19 = r0.c;
        String r20 = r17.b;
        ((b0.a) r19).getClass();
        int r21 = r15.length();
        int r22 = r20.length();
        int r23 = 0;
        boolean r24 = false;
    L31:
        if (r23 >= r22) goto L43;
        char r110 = r20.charAt(r23);
        if (Character.isWhitespace(r110) == false) goto L35;
        r24 = true;
    L42:
        r23 = r23 + 1;
        goto L31
    L35:
        if (r24 == false) goto L41;
        int r25 = r15.length();
        if (r25 <= 0) goto L41;
        if (Character.isWhitespace(r15.charAt(r25 - 1)) == true) goto L41;
        tsc.a.a(r15, ' ');
    L41:
        tsc.a.a(r15, r110);
        r24 = false;
        goto L42
    L43:
        if (r24 == false) goto L153;
        if (r21 >= r15.length()) goto L153;
        tsc.a.a(r15, ' ');
        goto L153
    L92:
        Token.g r26 = (Token.g) r16;
        if (r.j.contains(((Token.h) r26).c) == false) goto L95;
    L137:
        String r27 = ((Token.h) r26).c;
        int r28 = r15.length();
        m r29 = new m.b(r27, r28, r.a(r26));
        if (r0.i == false) goto L146;
        int r30 = r15.length();
        if (r30 > 0) goto L142;
    L144:
        r0.i = false;
        goto L146
    L142:
        if ('\n' == r15.charAt(r30 - 1)) goto L144;
        tsc.a.a(r15, '\n');
    L146:
        if (r.k.contains(r27) == false) goto L148;
    L149:
        r29.e = r15.subSequence(r28, r15.length()).toString();
        r0.b(r15, r29);
        int r31 = r15.length();
        if (r29.isClosed() == true) goto L152;
        r29.d = r31;
    L152:
        ((ArrayList) r0.f).add(r29);
        goto L153
    L148:
        if (((Token.h) r26).i == false) goto L152;
    L95:
        if (r0.e.contains(((Token.h) r26).c) == true) goto L137;
        String r32 = ((Token.h) r26).c;
        if ("p".equals(r0.g.a) == false) goto L101;
        r0.g.c(r15.length());
        tsc.a.a(r15, '\n');
        r0.g = r0.g.f;
    L106:
        if (r.l.contains(r32) == false) goto L108;
    L118:
        r0.h = "pre".equals(r32);
        int r33 = r15.length();
        if (r33 > 0) goto L121;
    L123:
        int r34 = r15.length();
        Map<String, String> r35 = r.a(r26);
        m.a r36 = r0.g;
        m.a r111 = new m.a(r32, r34, r35, r36);
        if (r.k.contains(r32) == false) goto L126;
    L129:
        if (r4 == false) goto L131;
        r111.e = r15.subSequence(r34, r15.length()).toString();
        r0.b(r15, r111);
        r111.c(r15.length());
    L131:
        List r37 = r36.g;
        if (r37 != null) goto L134;
        r37 = new ArrayList(2);
        r36.g = r37;
    L134:
        r37.add(r111);
        if (r4 == true) goto L153;
        r0.g = r111;
        goto L153
    L126:
        if (((Token.h) r26).i == true) goto L129;
        r4 = false;
        goto L129
    L121:
        if ('\n' == r15.charAt(r33 - 1)) goto L123;
        tsc.a.a(r15, '\n');
        goto L123
    L108:
        if (r0.d.contains(r32) == true) goto L118;
        if (r0.i == false) goto L123;
        int r38 = r15.length();
        if (r38 > 0) goto L115;
    L117:
        r0.i = false;
        goto L123
    L115:
        if ('\n' == r15.charAt(r38 - 1)) goto L117;
        tsc.a.a(r15, '\n');
        goto L117
    L101:
        if ("li".equals(r32) == false) goto L106;
        if ("li".equals(r0.g.a) == false) goto L106;
        r0.g.c(r15.length());
        r0.g = r0.g.f;
        goto L106
    L181:
        return;
    }

    @Override // lsc.a, lsc.j
    public final void a(TextView r1, uvc.b r2, lsc.p r3) {
        s r4 = this.d;
        if (r4 == null) goto L7;
        r4.a(r3, this.c);
        return;
    L7:
        throw new IllegalStateException("Unexpected state, html-renderer is not defined");
    }

    @Override // lsc.a, lsc.j
    public final void d(CharSequence r1, uvc.b r2, lsc.p r3) {
        s r4 = this.d;
        if (r4 == null) goto L7;
        r4.a(r3, this.c);
        return;
    L7:
        throw new IllegalStateException("Unexpected state, html-renderer is not defined");
    }
}
