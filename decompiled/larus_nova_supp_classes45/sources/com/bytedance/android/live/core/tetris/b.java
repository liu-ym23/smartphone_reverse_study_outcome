package com.bytedance.android.live.core.tetris;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements f70.a {
    public final ViewGroup a;

    public b(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "masterView");
        this.a = r2;
    }

    @Override // f70.a
    public final ViewGroup a(f70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        return this.a;
    }
}
