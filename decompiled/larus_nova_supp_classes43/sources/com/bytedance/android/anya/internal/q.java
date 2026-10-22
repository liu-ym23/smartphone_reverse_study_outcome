package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.o0;
import com.bytedance.android.anya.x;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q<OWNER extends MVIState<?>, STATE extends x<?>> extends c<OWNER, STATE> implements o0<OWNER, STATE>, ReadOnlyProperty<OWNER, o0<OWNER, STATE>> {
    public final Class<STATE> f;

    @Override // com.bytedance.android.anya.internal.c
    public final String toString() {
        return "{ \"name\": \"" + this.a + "@r\", \"value\": " + ((x) this.b) + " }";
    }

    @Override // com.bytedance.android.anya.internal.c
    public final boolean b(Object r10) {
        x r11 = (x) r10;
        if (Intrinsics.areEqual(r11.getClass(), this.f) == false) goto L7;
        STATE r0 = c();
        i.a(r0, r11);
        return !r0.modifiedProperties.isEmpty();
    L7:
        throw new IllegalStateException(("Incoming state value type [" + x.class + "] is different from previous [" + this.f + ']').toString());
    }

    public final Object getValue(Object r1, KProperty r10) {
        MVIState r11 = (MVIState) r1;
        return this;
    }

    public q(Class r1, x r10, Function1 r11, Function1 r12) {
        super(r10, r11, r12);
        this.f = r1;
    }
}
