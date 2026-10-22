package iy7;

import com.lark.kmp.containerization.c;
import com.lark.kmp.containerization.d;
import gy7.q;
import gy7.r;
import gy7.s;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static com.lark.kmp.containerization.b a() {
        Map<d<?>, c<?>> r0 = com.lark.kmp.containerization.a.a;
        return com.lark.kmp.containerization.a.a(b.a).a(Unit.INSTANCE);
    }

    public static com.lark.kmp.containerization.b b(q r10) {
        Intrinsics.checkNotNullParameter(r10, "session");
        Map<d<?>, c<?>> r0 = com.lark.kmp.containerization.a.a;
        d<q> r1 = b.b;
        com.lark.kmp.containerization.b r11 = com.lark.kmp.containerization.a.a(r1).a(r10);
        if (r11 != null) goto L9;
        c r12 = com.lark.kmp.containerization.a.a(r1);
        Map<q, q> r13 = s.a;
        q r14 = s.a(r.a);
        if (r14 == null) goto L8;
        return r12.b(r14, null);
    L8:
        throw new IllegalStateException("can not find absent user session");
    L9:
        return r11;
    }
}
