package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements ntb.h {
    public k() {
    }

    @Override // ntb.h
    public final boolean isEnable(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return FeatureGatingModule.getFeatureGatingService().isEnable(r2);
    L5:
        return false;
    }
}
