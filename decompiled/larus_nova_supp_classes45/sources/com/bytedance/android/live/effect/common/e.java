package com.bytedance.android.live.effect.common;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.effect.sticker.ui.StickerItemView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements f {
    public e() {
    }

    @Override // com.bytedance.android.live.effect.common.f
    public final View a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new StickerItemView(r5, null, 6, 0);
    }
}
