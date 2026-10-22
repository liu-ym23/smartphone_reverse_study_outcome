package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r<OWNER extends MVIState<?>, T> extends c<OWNER, T> implements r0<OWNER, T>, ReadOnlyProperty<OWNER, r0<OWNER, T>> {
    public final Object getValue(Object r1, KProperty r10) {
        MVIState r11 = (MVIState) r1;
        return this;
    }

    public r(Object r1, Function1 r10, Function1 r11) {
        super(r1, r10, r11);
    }
}
