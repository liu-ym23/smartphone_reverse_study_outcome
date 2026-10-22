package com.bytedance.android.livesdk.gift.platform.core.preview;

import com.bytedance.android.livesdk.gift.model.h1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final b a(h1 r9) {
        Intrinsics.checkNotNullParameter(r9, "$this$toGiftStruct");
        return new b(r9.getId(), r9.getPrimaryEffectId(), r9.getName(), r9.getDiamondCount(), r9.getImage());
    }
}
