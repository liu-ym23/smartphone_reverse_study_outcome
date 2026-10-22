package com.bytedance.android.live.effect.beauty.sticker;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.sticker.ui.LiveStickerComposerListAdapterKt;
import com.bytedance.android.live.effect.utils.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements LiveStickerComposerListAdapterKt.b {
    public final /* synthetic */ LiveStickerBeautyFragment a;

    public b(LiveStickerBeautyFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.LiveStickerComposerListAdapterKt.b
    public final void a(Sticker r11, com.bytedance.android.live.effect.base.e r12) {
        HashMap<String, String> r8 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("event_page", this.a.m)});
        if (r11 != null) goto L5;
        List<String> r13 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.a.getType()).a().t(d0.c, "LiveStickerBeautyFragment_onSelectNull", r8);
    L6:
        this.a.e = r11;
        return;
    L5:
        List<String> r0 = LiveEffectContext.h;
        ILiveEffectComposerManager.f.c(LiveEffectContext.a.a(this.a.getType()).a(), d0.c, this.a.e, r11, "LiveStickerBeautyFragment_onSelectNew", r8, r12);
        List<String> r14 = q.a;
        q.g(r11, "", this.a.getType(), this.a.m, false, "");
        goto L6
    }
}
