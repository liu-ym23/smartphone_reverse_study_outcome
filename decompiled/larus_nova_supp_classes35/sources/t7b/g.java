package t7b;

import com.ss.android.lark.commonmark.internal.n;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import v7b.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements x7b.a {
    public static final a8b.a a = null;
    public static final a8b.a b = null;
    public static final a8b.a c = null;
    public static final a8b.a d = null;
    public static final a8b.a e = null;
    public static final a8b.a f = null;

    public static class a implements x7b.b {
        public a() {
        }

        @Override // x7b.b
        public final Set<Character> a() {
            HashSet r0 = new HashSet(1);
            Object r1 = new Object[]{'<'}[0];
            Objects.requireNonNull(r1);
            if (r0.add(r1) == false) goto L7;
            return Collections.unmodifiableSet(r0);
        L7:
            throw new IllegalArgumentException("duplicate element: " + r1);
        }

        @Override // x7b.b
        public final x7b.a create() {
            return new g();
        }
    }

    public g() {
    }

    static {
        a8b.a.C0003a r0 = a8b.a.a();
        r0.b('A', 'Z');
        r0.b('a', 'z');
        a8b.a r1 = new a8b.a(r0);
        a = r1;
        b = r1;
        a8b.a.C0003a r2 = r1.b();
        r2.b('0', '9');
        r2.a('-');
        c = new a8b.a(r2);
        a8b.a.C0003a r3 = r1.b();
        r3.a('_');
        r3.a(':');
        a8b.a r4 = new a8b.a(r3);
        d = r4;
        a8b.a.C0003a r5 = r4.b();
        r5.b('0', '9');
        r5.a('.');
        r5.a('-');
        e = new a8b.a(r5);
        a8b.a.C0003a r6 = a8b.a.a();
        r6.a(' ');
        r6.a('\t');
        r6.a('\n');
        r6.a(11);
        r6.a('\f');
        r6.a('\r');
        r6.a('\"');
        r6.a('\'');
        r6.a('=');
        r6.a('<');
        r6.a('>');
        r6.a('`');
        f = new a8b.a(r6);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0099 -> B:40:0x009b). Please report as a decompilation issue!!! */
    @Override // x7b.a
    public final h a(x7b.c r11) {
        x7b.e r12 = ((n) r11).f;
        x7b.d r0 = r12.k();
        r12.g();
        char r1 = r12.j();
        a8b.a r2 = b;
        boolean r6 = false;
        if (r2.a.get(r1) == false) goto L46;
        r12.g();
        r12.e(c);
        if (r12.m() < 1) goto L7;
        x7b.d r3 = r0;
        x7b.e r4 = r12;
    L40:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L42;
        if (r12.e(d) < 1) goto L42;
        r12.e(e);
        if (r12.m() < 1) goto L15;
        r5 = true;
    L17:
        if (r12.h('=') == false) goto L9;
        r12.m();
        char r7 = r12.j();
        if (r7 != '\'') goto L25;
        r12.g();
        if (r12.b('\'') < 0) goto L43;
        r12.g();
    L39:
        if (r12.m() >= 1) goto L40;
        r5 = false;
    L43:
        if (r6 == true) goto L45;
        return null;
    L45:
        return b(r3, r4);
    L25:
        if (r7 != '\"') goto L30;
        r12.g();
        if (r12.b('\"') < 0) goto L43;
        r12.g();
        goto L39
    L30:
        a8b.a r8 = f;
        int r9 = 0;
    L31:
        char r10 = r12.j();
        if (r10 == 0) goto L33;
        if (r8.a.get(r10) == true) goto L36;
        r9 = r9 + 1;
        r12.g();
    L36:
        if (r9 > 0) goto L39;
    L33:
        r9 = -1;
        goto L36
    L15:
        r5 = false;
    L42:
        r12.h('/');
        r6 = r12.h('>');
        goto L43
    L7:
        r3 = r0;
        r4 = r12;
        r5 = false;
        goto L9
    L46:
        if (r1 != '/') goto L54;
        r12.g();
        if (r12.e(r2) < 1) goto L50;
        r12.e(c);
        r12.m();
        r6 = r12.h('>');
    L50:
        if (r6 == true) goto L52;
        return null;
    L52:
        return b(r0, r12);
    L54:
        if (r1 != '?') goto L65;
        r12.g();
    L57:
        if (r12.b('?') <= 0) goto L61;
        r12.g();
        if (r12.h('>') == false) goto L57;
        r6 = true;
    L61:
        if (r6 == true) goto L63;
        return null;
    L63:
        return b(r0, r12);
    L65:
        if (r1 != '!') goto L135;
        r12.g();
        char r13 = r12.j();
        if (r13 != '-') goto L87;
        r12.g();
        if (r12.h('-') == true) goto L72;
    L83:
        if (r6 == true) goto L85;
        return null;
    L85:
        return b(r0, r12);
    L72:
        if (r12.h('>') == false) goto L74;
    L82:
        r6 = true;
        goto L83
    L74:
        if (r12.i("->") == true) goto L82;
    L77:
        if (r12.b('-') < 0) goto L83;
        if (r12.i("-->") == true) goto L82;
        r12.g();
        goto L77
    L87:
        if (r13 != '[') goto L99;
        r12.g();
        if (r12.i("CDATA[") == true) goto L91;
    L96:
        if (r6 == true) goto L98;
        return null;
    L98:
        return b(r0, r12);
    L91:
        if (r12.b(']') < 0) goto L96;
        if (r12.i("]]>") == true) goto L94;
        r12.g();
        goto L91
    L94:
        r6 = true;
        goto L96
    L99:
        a8b.a r14 = a;
        if (r14.a.get(r13) == false) goto L138;
        r12.e(r14);
        if (r12.m() > 0) goto L105;
    L107:
        if (r6 == true) goto L109;
        return null;
    L109:
        return b(r0, r12);
    L105:
        if (r12.b('>') < 0) goto L107;
        r12.g();
        r6 = true;
        goto L107
    L138:
        return null;
    L135:
        return null;
    }

    public static h b(x7b.d r1, x7b.e r2) {
        String r3 = r2.c(r1, r2.k()).a();
        k r0 = new k();
        r0.j = r3;
        return new h(r0, r2.k());
    }
}
