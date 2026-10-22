package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e<STATE extends MVIState<?>> {
    public final Set<BaseMVIDataStore<?>> a;
    public final Map<Object, com.bytedance.android.anya.j<?>> b;
    public final l0<STATE> c;

    public final void a(com.bytedance.android.anya.t r10) {
        Set<BaseMVIDataStore<?>> r0 = this.a;
        if (r10 == null) goto L10;
        n r1 = (n) r10;
        if (r0.contains(r1.b) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(("Selecting property " + r10 + " is not permitted: owner " + r1.b + " is not in dataStores " + this.a).toString());
    L10:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.MVIDataPropertyImpl<*, *>");
    }

    public final com.bytedance.android.anya.j b(com.bytedance.android.anya.t r10) {
        if (r10 == null) goto L12;
        n r0 = (n) r10;
        com.bytedance.android.anya.j<?> r11 = this.b.get(r10);
        if ((r11 instanceof com.bytedance.android.anya.j) == true) goto L6;
        r11 = null;
    L6:
        com.bytedance.android.anya.j<?> r12 = r11;
        if (r12 == null) goto L10;
        return r12;
    L10:
        return new com.bytedance.android.anya.j(null, r0.a(), false);
    L12:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.MVIDataPropertyImpl<DATA_STORE, T>");
    }

    public final void e(com.bytedance.android.anya.t r10, Function2 r11) {
        Map<Object, com.bytedance.android.anya.j<?>> r0 = this.b;
        a(r10);
        if (r0.containsKey(r10) == false) goto L6;
        r11.invoke(this.c, b(r10));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Set<? extends BaseMVIDataStore<?>> r1, Map<Object, ? extends com.bytedance.android.anya.j<?>> r10, l0<STATE> r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void d(com.bytedance.android.anya.t r10, com.bytedance.android.anya.t r11, Function3 r12) {
        Map<Object, com.bytedance.android.anya.j<?>> r0 = this.b;
        a(r10);
        if (r0.containsKey(r10) == true) goto L6;
        Map<Object, com.bytedance.android.anya.j<?>> r1 = this.b;
        a(r11);
        if (r1.containsKey(r11) == true) goto L6;
        return;
    L6:
        r12.invoke(this.c, b(r10), b(r11));
    }

    public final void c(com.bytedance.android.anya.t r10, com.bytedance.android.anya.t r11, com.bytedance.android.anya.t r12, Function4 r13) {
        Map<Object, com.bytedance.android.anya.j<?>> r0 = this.b;
        a(r10);
        if (r0.containsKey(r10) == true) goto L8;
        Map<Object, com.bytedance.android.anya.j<?>> r1 = this.b;
        a(r11);
        if (r1.containsKey(r11) == true) goto L8;
        Map<Object, com.bytedance.android.anya.j<?>> r14 = this.b;
        a(r12);
        if (r14.containsKey(r12) == true) goto L8;
        return;
    L8:
        r13.invoke(this.c, b(r10), b(r11), b(r12));
    }
}
