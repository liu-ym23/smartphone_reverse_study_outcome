package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIDataStore;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k<OWNER extends BaseMVIDataStore<?>, T> {
    public final n<OWNER, T> a;

    public k(n<OWNER, T> r1) {
        this.a = r1;
    }

    public final h a(KProperty r10) {
        n<OWNER, T> r0 = this.a;
        r0.a = r10.getName();
        return new h(r0);
    }
}
