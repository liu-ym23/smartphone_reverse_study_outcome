package com.bytedance.android.live.effect.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z {
    public static final boolean a(LiveEffectScene r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isGiftMenu");
        if (r1 != LiveEffectScene.GiftMenuPreview) goto L5;
    L8:
        return true;
    L5:
        if (r1 == LiveEffectScene.GiftMenuLive) goto L8;
        return false;
    }
}
