package com.bytedance.android.livesdk.gift.fastgift.di;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.gift.fastgift.FastGiftViewV3;
import h12.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements h {
    public d() {
    }

    @Override // h12.h
    public final FastGiftViewV3 a(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        return new FastGiftViewV3(r4, r5, 4, 0);
    }
}
