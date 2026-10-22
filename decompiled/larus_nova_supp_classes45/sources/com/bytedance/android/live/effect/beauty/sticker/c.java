package com.bytedance.android.live.effect.beauty.sticker;

import com.bytedance.android.live.effect.utils.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements i {
    public final /* synthetic */ LiveStickerBeautyFragment a;

    public c(LiveStickerBeautyFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.beauty.sticker.i
    public final void a(Sticker r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "sticker");
        LiveStickerBeautyFragment r0 = this.a;
        int r1 = LiveStickerBeautyFragment.o;
        r0.getClass();
        List<String> r2 = q.a;
        q.h(String.valueOf(r13.getId()), r13.isVideoUsedSticker(), r14, "", r0.k, r0.m, r13.getTopTips(), r13.getStickerType(), "");
    }
}
