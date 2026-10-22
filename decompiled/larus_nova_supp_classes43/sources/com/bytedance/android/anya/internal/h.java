package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIDataStore;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h<OWNER extends BaseMVIDataStore<?>, P> implements ReadOnlyProperty<OWNER, P> {
    public final P a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(n r1) {
        this.a = r1;
    }

    public final Object getValue(Object r1, KProperty r10) {
        BaseMVIDataStore r11 = (BaseMVIDataStore) r1;
        return this.a;
    }
}
