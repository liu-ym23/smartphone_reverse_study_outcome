package com.bytedance.ies.argus.api.params;

import kotlin.Lazy;
import kotlin.LazyKt;
import m.f0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends f0 {
    public final Lazy f;

    public b() {
        this.f = LazyKt.lazy(new BaseAspectParams$rewritePayload$2(this));
    }
}
