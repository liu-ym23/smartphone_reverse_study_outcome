package t7b;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.commonmark.internal.n;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import v7b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements x7b.a {
    public static final Pattern a = null;
    public static final Pattern b = null;

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
            return new b();
        }
    }

    public b() {
    }

    static {
        a = PatternProtector.compile("^[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*$");
        b = PatternProtector.compile("^([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)$");
    }

    @Override // x7b.a
    public final h a(x7b.c r6) {
        x7b.e r7 = ((n) r6).f;
        r7.g();
        x7b.d r0 = r7.k();
        if (r7.b('>') <= 0) goto L14;
        w7b.g r1 = r7.c(r0, r7.k());
        String r2 = r1.a();
        r7.g();
        if (a.matcher(r2).matches() == false) goto L8;
        String r3 = r2;
    L11:
        if (r3 == null) goto L14;
        v7b.n r4 = new v7b.n(r3, null);
        b0 r5 = new b0(r2);
        r5.n(r1.b());
        r4.e(r5);
        return new h(r4, r7.k());
    L8:
        if (b.matcher(r2).matches() == false) goto L10;
        r3 = "mailto:" + r2;
        goto L11
    L10:
        r3 = null;
    L14:
        return null;
    }
}
