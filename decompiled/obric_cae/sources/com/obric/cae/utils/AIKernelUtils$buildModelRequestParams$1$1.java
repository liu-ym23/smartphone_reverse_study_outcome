package com.obric.cae.utils;

import android.os.Bundle;
import ge.l;
import he.i;
import he.j;

/* JADX INFO: loaded from: classes2.dex */
public final class AIKernelUtils$buildModelRequestParams$1$1 extends j implements l<Bundle, xd.j> {
    final /* synthetic */ String $featureKey;
    final /* synthetic */ float[] $features;

    public AIKernelUtils$buildModelRequestParams$1$1(String r8, float[] r10) {
        this.$featureKey = r8;
        this.$features = r10;
        super(1);
    }

    @Override // ge.l
    public /* bridge */ /* synthetic */ xd.j invoke(Bundle r8) {
        invoke2(r8);
        return xd.j.f13877a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Bundle r8) {
        i.f(r8, "$this$setCustomArgs");
        r8.putFloatArray(this.$featureKey, this.$features);
    }
}
