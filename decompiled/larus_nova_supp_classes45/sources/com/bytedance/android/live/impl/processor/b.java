package com.bytedance.android.live.impl.processor;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.CombineInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends BaseFactorProcessor {
    @Override // com.bytedance.android.live.impl.processor.BaseFactorProcessor
    public final LiveData f(CombineInfo r2, LiveData r3) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "data");
        return r3;
    }

    public b() {
    }
}
