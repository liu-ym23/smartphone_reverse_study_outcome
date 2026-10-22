package t7b;

import com.ss.android.lark.commonmark.internal.n;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import v7b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements x7b.a {

    public static class a implements x7b.b {
        public a() {
        }

        @Override // x7b.b
        public final Set<Character> a() {
            HashSet r0 = new HashSet(1);
            Object r1 = new Object[]{'`'}[0];
            Objects.requireNonNull(r1);
            if (r0.add(r1) == false) goto L7;
            return Collections.unmodifiableSet(r0);
        L7:
            throw new IllegalArgumentException("duplicate element: " + r1);
        }

        @Override // x7b.b
        public final x7b.a create() {
            return new d();
        }
    }

    public d() {
    }

    @Override // x7b.a
    public final h a(x7b.c r9) {
        x7b.e r10 = ((n) r9).f;
        x7b.d r0 = r10.k();
        int r2 = r10.f('`');
        x7b.d r3 = r10.k();
    L4:
        if (r10.b('`') <= 0) goto L27;
        x7b.d r4 = r10.k();
        if (r10.f('`') != r2) goto L4;
        v7b.d r1 = new v7b.d();
        String r5 = r10.c(r3, r4).a().replace('\n', ' ');
        if (r5.length() < 3) goto L24;
        boolean r6 = false;
        if (r5.charAt(0) != ' ') goto L24;
        if (r5.charAt(r5.length() - 1) != ' ') goto L24;
        int r7 = r5.length();
        int r8 = 0;
    L14:
        if (r8 >= r7) goto L19;
        if (r5.charAt(r8) != ' ') goto L20;
        r8 = r8 + 1;
    L20:
        if (r8 == r7) goto L22;
        r6 = true;
    L22:
        if (r6 == false) goto L24;
        r5 = r5.substring(1, r5.length() - 1);
        goto L24
    L19:
        r8 = r7;
    L24:
        r1.j = r5;
        return new h(r1, r10.k());
    L27:
        return new h(new b0(r10.c(r0, r3).a()), r3);
    }
}
