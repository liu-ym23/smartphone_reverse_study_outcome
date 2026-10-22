package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.u0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SubStatePropertyImpl<OWNER extends MVIState<?>, STATE extends MVIState<?>> extends c<OWNER, STATE> implements u0<OWNER, STATE>, ReadOnlyProperty<OWNER, u0<OWNER, STATE>> {
    public final Class<STATE> f;

    @Override // com.bytedance.android.anya.internal.c
    public final String toString() {
        return "{ \"name\": \"" + this.a + "@s\", \"value\": " + ((MVIState) this.b) + ", \"type\": \"" + this.f.getCanonicalName() + "\" } ";
    }

    @Override // com.bytedance.android.anya.internal.c
    public final boolean b(Object r10) {
        MVIState r11 = (MVIState) r10;
        if (Intrinsics.areEqual(r11.getClass(), this.f) == false) goto L7;
        STATE r0 = c();
        i.a(r0, r11);
        return !r0.modifiedProperties.isEmpty();
    L7:
        throw new IllegalStateException(("Incoming state value type [" + r11.getClass() + "] is different from previous [" + this.f + ']').toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(MVIState<?> r10) {
        this.b = r10;
        r10.notifyParentNodeChange = new SubStatePropertyImpl$initValue$1(this);
    }

    public final Object getValue(Object r1, KProperty r10) {
        MVIState r11 = (MVIState) r1;
        return this;
    }

    public SubStatePropertyImpl(Class r1, MVIState r10, final Function1 r11, Function1 r12) {
        super(r10, r11, r12);
        this.f = r1;
        if (r10 == null) goto L6;
        r10.notifyParentNodeChange = new AnonymousClass1(this, r11);
        return;
    }
}
