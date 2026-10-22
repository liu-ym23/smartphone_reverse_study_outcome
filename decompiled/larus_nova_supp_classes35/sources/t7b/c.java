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
public final class c implements x7b.a {
    public static final Pattern a = null;

    public static class a implements x7b.b {
        public a() {
        }

        @Override // x7b.b
        public final Set<Character> a() {
            HashSet r0 = new HashSet(1);
            Object r1 = new Object[]{'\\'}[0];
            Objects.requireNonNull(r1);
            if (r0.add(r1) == false) goto L7;
            return Collections.unmodifiableSet(r0);
        L7:
            throw new IllegalArgumentException("duplicate element: " + r1);
        }

        @Override // x7b.b
        public final x7b.a create() {
            return new c();
        }
    }

    public c() {
    }

    static {
        a = PatternProtector.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
    }

    @Override // x7b.a
    public final h a(x7b.c r4) {
        x7b.e r5 = ((n) r4).f;
        r5.g();
        char r0 = r5.j();
        if (r0 != '\n') goto L7;
        r5.g();
        return new h(new v7b.h(), r5.k());
    L7:
        if (a.matcher(String.valueOf(r0)).matches() == false) goto L11;
        r5.g();
        return new h(new b0(String.valueOf(r0)), r5.k());
    L11:
        return new h(new b0("\\"), r5.k());
    }
}
