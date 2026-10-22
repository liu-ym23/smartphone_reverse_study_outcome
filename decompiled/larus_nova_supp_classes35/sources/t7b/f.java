package t7b;

import com.ss.android.lark.commonmark.internal.n;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import v7b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements x7b.a {
    public static final a8b.a a = null;
    public static final a8b.a b = null;
    public static final a8b.a c = null;
    public static final a8b.a d = null;

    public static class a implements x7b.b {
        public a() {
        }

        @Override // x7b.b
        public final Set<Character> a() {
            HashSet r0 = new HashSet(1);
            Object r1 = new Object[]{'&'}[0];
            Objects.requireNonNull(r1);
            if (r0.add(r1) == false) goto L7;
            return Collections.unmodifiableSet(r0);
        L7:
            throw new IllegalArgumentException("duplicate element: " + r1);
        }

        @Override // x7b.b
        public final x7b.a create() {
            return new f();
        }
    }

    public f() {
    }

    static {
        a8b.a.C0003a r0 = a8b.a.a();
        r0.b('0', '9');
        r0.b('A', 'F');
        r0.b('a', 'f');
        a = new a8b.a(r0);
        a8b.a.C0003a r1 = a8b.a.a();
        r1.b('0', '9');
        b = new a8b.a(r1);
        a8b.a.C0003a r2 = a8b.a.a();
        r2.b('A', 'Z');
        r2.b('a', 'z');
        a8b.a r3 = new a8b.a(r2);
        c = r3;
        a8b.a.C0003a r4 = r3.b();
        r4.b('0', '9');
        d = new a8b.a(r4);
    }

    @Override // x7b.a
    public final h a(x7b.c r5) {
        x7b.e r6 = ((n) r5).f;
        x7b.d r0 = r6.k();
        r6.g();
        char r1 = r6.j();
        if (r1 != '#') goto L26;
        r6.g();
        if (r6.h('x') == false) goto L7;
    L17:
        int r2 = r6.e(a);
        if (1 <= r2) goto L20;
        return null;
    L20:
        if (r2 <= 6) goto L22;
        return null;
    L22:
        if (r6.h(';') == true) goto L24;
        return null;
    L24:
        return b(r6, r0);
    L7:
        if (r6.h('X') == true) goto L17;
        int r3 = r6.e(b);
        if (1 <= r3) goto L12;
        return null;
    L12:
        if (r3 <= 7) goto L14;
        return null;
    L14:
        if (r6.h(';') == true) goto L16;
        return null;
    L16:
        return b(r6, r0);
    L26:
        if (c.a.get(r1) == false) goto L38;
        r6.e(d);
        if (r6.h(';') == true) goto L30;
        return null;
    L30:
        return b(r6, r0);
    L38:
        return null;
    }

    public static h b(x7b.e r1, x7b.d r2) {
        return new h(new b0(u7b.b.a(r1.c(r2, r1.k()).a())), r1.k());
    }
}
