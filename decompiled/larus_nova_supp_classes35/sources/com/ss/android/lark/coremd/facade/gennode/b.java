package com.ss.android.lark.coremd.facade.gennode;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u9b.c;
import v7b.i;
import v7b.q;
import v7b.s;
import v7b.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements c {
    public static final a b = null;
    public static final Map<Class<? extends s>, Integer> c = null;
    public final InterfaceC0181b a;

    public static final class a implements InterfaceC0181b {
        public a() {
        }

        @Override // com.ss.android.lark.coremd.facade.gennode.b.InterfaceC0181b
        public final int a(s r2) {
            Intrinsics.checkNotNullParameter(r2, "node");
            Integer r3 = b.c.get(r2.getClass());
            if (r3 != null) goto L7;
            return Integer.MAX_VALUE;
        L7:
            return r3.intValue();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.facade.gennode.b$b, reason: collision with other inner class name */
    public interface InterfaceC0181b {
        int a(s r1);
    }

    static {
        b = new a();
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to(v7b.b.class, 1), TuplesKt.to(i.class, 2), TuplesKt.to(q.class, 3), TuplesKt.to(v.class, 4)});
    }

    public b() {
        a r0 = b;
        Intrinsics.checkNotNullParameter(r0, "config");
        this.a = r0;
    }

    @Override // u9b.c
    public final int a(s r2, s r3) {
        Intrinsics.checkNotNullParameter(r2, "o1");
        Intrinsics.checkNotNullParameter(r3, "o2");
        return this.a.a(r2) - this.a.a(r3);
    }
}
