package com.larus.avlink.plugins;

import com.larus.dora.api.LightEffectBrightness;
import com.larus.dora.api.LightEffectStatus;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s3 extends e {
    public final Lazy i;
    public final Lazy j;

    @Override // com.larus.avlink.plugins.e
    public final void o3() {
    }

    @Override // com.larus.avlink.plugins.e
    public final String l3() {
        return (String) this.i.getValue();
    }

    @Override // com.larus.avlink.plugins.e
    public final String m3() {
        return (String) this.j.getValue();
    }

    public s3(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.i = LazyKt.lazy(new q3());
        this.j = LazyKt.lazy(new r3());
    }

    @Override // com.larus.avlink.plugins.e
    public final void n3(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        r4 r0 = (r4) getContext().c(Reflection.getOrCreateKotlinClass(r4.class), null);
        if (r0 == null) goto L6;
        r0.N2(LightEffectStatus.RAPID_FLASHING, LightEffectBrightness.LOW, r4);
        return;
    }
}
