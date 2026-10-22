package com.larus.photopicker.v2.impl;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d0 implements Function0<ViewModelStoreOwner> {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ Class<?> b;

    public d0(Fragment r1, Class<?> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        Fragment r0 = this.a;
        int r1 = e0.a;
        Fragment r2 = e0.a(r0, this.b);
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("ownerProducer is null");
    }
}
