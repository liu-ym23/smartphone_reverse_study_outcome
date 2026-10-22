package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l0<STATE extends MVIState<?>> extends h<STATE, l0<STATE>> {
    public STATE a;
    public final k0<STATE, ?> b;

    @AnyaDSL
    public static final class a<T extends MVIState<?>> {
        public final T a;
        public final l0<T> b;

        public a(T r1, l0<T> r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public l0() {
        this(0);
    }

    public final STATE f() {
        STATE r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L5:
        return r0;
    }

    public /* synthetic */ l0(int r1) {
        this(new k0.a());
    }

    public static void d(t0 r0) {
        ((e0) ((com.bytedance.android.anya.internal.u) r0).c()).clear();
    }

    public final <T extends MVIState<?>> r i(T r10) {
        k0<STATE, ?> r0 = this.b;
        if (r0 == null) goto L7;
        return r10.toBusinessState(r0);
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.ReadOnlyStateContext<STATE, *>");
    }

    public l0(k0<STATE, ?> r1) {
        this.b = r1;
    }

    public static void c(t0 r0, Collection r1) {
        ((e0) ((com.bytedance.android.anya.internal.u) r0).c()).addAll(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a e(t0 r10, int r11) {
        return new a((MVIState) ((com.bytedance.android.anya.internal.u) r10).c().get(r11), new l0(0));
    }

    public static void g(t0 r0, List r1) {
        ((e0) ((com.bytedance.android.anya.internal.u) r0).c()).q(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(r0 r0, Object r1) {
        ((com.bytedance.android.anya.internal.c) r0).a(r1);
    }
}
