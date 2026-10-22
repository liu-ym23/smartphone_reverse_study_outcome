package com.bytedance.android.live.revlink.impl.utils;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements k {
    public final int[] a;

    public l(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "modes");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.utils.k
    public final boolean a(int r2) {
        return !ArraysKt.contains(this.a, r2);
    }
}
