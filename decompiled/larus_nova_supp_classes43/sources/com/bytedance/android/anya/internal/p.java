package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.m0;
import com.bytedance.android.anya.n0;
import com.bytedance.android.anya.u0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public final MVIState<?> a;
    public final p b;

    public static final class a<E extends MVIState<?>> implements m0<E> {
        public final Function0<E> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<? extends E> r1) {
            this.a = r1;
        }
    }

    public static final class b<T extends com.bytedance.android.anya.v<?, E>, E> implements n0<T, E> {
        public final Function0<T> a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function0<? extends T> r1) {
            this.a = r1;
        }
    }

    public final a c(Class r10) {
        p r0 = this.b;
    L3:
        if (r0 == null) goto L10;
        final MVIState<?> r1 = r0.a;
        if (Intrinsics.areEqual(r1.getClass(), r10) == true) goto L7;
        r0 = r0.b;
        goto L3
    L7:
        return new a(new ReduceContextImpl$parentStateOfType$1(r1));
    L10:
        return new a(ReduceContextImpl$parentStateOfType$2.INSTANCE);
    }

    public final b d(final u0 r10) {
        return new b(new ReduceContextImpl$toNode$1(r10));
    }

    public p(MVIState<?> r1, p r10) {
        this.a = r1;
        this.b = r10;
    }

    public final b a(final n0 r10, final Function1 r11) {
        b r0 = (b) r10;
        return new b(new ReduceContextImpl$get$1(r10, r11));
    }

    public final b b(final a r10, final Function1 r11) {
        return new b(new ReduceContextImpl$get$3(r10, r11));
    }
}
