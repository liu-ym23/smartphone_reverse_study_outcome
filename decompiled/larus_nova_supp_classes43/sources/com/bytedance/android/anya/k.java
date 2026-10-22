package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@AnyaDSL
public final class k<STATE extends MVIState<?>> {
    public final STATE a;
    public final DiffContext b;
    public final com.bytedance.android.anya.internal.s<STATE> c;

    public k() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends MVIState<?>> k<T> a(u0<?, T> r10) {
        com.bytedance.android.anya.internal.s<STATE> r0 = this.c;
        if (r0.e == false) goto L9;
        com.bytedance.android.anya.internal.s<?> r11 = r0.b.get(r10);
        if ((r11 instanceof com.bytedance.android.anya.internal.s) == true) goto L7;
        r11 = null;
    L7:
        com.bytedance.android.anya.internal.s<?> r12 = r11;
    L15:
        if (r12 != null) goto L17;
        return null;
    L17:
        return new k(r12.c, this.b, r12);
    L9:
        if (r0.d == false) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        r12 = new com.bytedance.android.anya.internal.s((MVIState) ((SubStatePropertyImpl) r10).c(), r0.d, false, null);
        goto L15
    L14:
        r12 = null;
        goto L15
    L11:
        r1 = CollectionsKt.contains(r0.c.modifiedProperties, r10);
        goto L12
    }

    public k(MVIState r10, DiffContext r11, boolean r12) {
        this(r10, r11, new com.bytedance.android.anya.internal.s(r10, r12, false, null));
    }

    public k(STATE r1, DiffContext r10, com.bytedance.android.anya.internal.s<STATE> r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
