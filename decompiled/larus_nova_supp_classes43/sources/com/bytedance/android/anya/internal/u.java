package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t0;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u<OWNER extends MVIState<?>, STATE extends MVIState<?>> extends c<OWNER, s0<STATE>> implements t0<OWNER, STATE>, ReadOnlyProperty<OWNER, t0<OWNER, STATE>> {
    @Override // com.bytedance.android.anya.internal.c
    public final boolean b(Object r10) {
        s0 r11 = (s0) r10;
        if (c() != r11) goto L5;
    L7:
        return false;
    L5:
        if (((t) c()).q(r11) == false) goto L7;
        return true;
    }

    public final Object getValue(Object r1, KProperty r10) {
        MVIState r11 = (MVIState) r1;
        return this;
    }

    public u(final List r10, Function1 r11, Function1 r12) {
        super(new t(null), r11, r12);
        t r13 = (t) c();
        r13.a = new StateListPropertyImpl$$special$$inlined$let$lambda$1(this, r10);
        r13.addAll(r10);
    }
}
