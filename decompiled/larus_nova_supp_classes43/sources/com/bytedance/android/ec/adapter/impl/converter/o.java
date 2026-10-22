package com.bytedance.android.ec.adapter.impl.converter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class o<Source, Target> extends a<Source, Target> {
    public Target b;

    public o() {
    }

    @Override // com.bytedance.android.ec.adapter.impl.converter.a
    public final Target a(Source r10) {
        if (this.b != null) goto L5;
        this.b = c(r10);
    L5:
        Target r11 = this.b;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("singleTon");
    L8:
        return r11;
    }
}
