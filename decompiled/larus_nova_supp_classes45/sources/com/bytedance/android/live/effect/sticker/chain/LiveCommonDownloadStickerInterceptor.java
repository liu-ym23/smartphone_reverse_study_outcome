package com.bytedance.android.live.effect.sticker.chain;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.common.LiveCommonStickerUIViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveCommonDownloadStickerInterceptor implements m {

    public static final class a extends com.bytedance.android.live.effect.api.l.c {
        public final /* synthetic */ LiveCommonDownloadStickerInterceptor$intercept$1 a;
        public final /* synthetic */ LiveCommonDownloadStickerInterceptor$intercept$2 b;
        public final /* synthetic */ Sticker c;

        @Override // com.bytedance.android.live.effect.api.l.b
        public final void b() {
            this.b.invoke(this.c);
        }

        @Override // com.bytedance.android.live.effect.api.l.b
        public final void a(Sticker r2) {
            Intrinsics.checkNotNullParameter(r2, "sticker");
            this.a.invoke(r2);
        }

        public a(LiveCommonDownloadStickerInterceptor$intercept$1 r1, LiveCommonDownloadStickerInterceptor$intercept$2 r2, Sticker r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public LiveCommonDownloadStickerInterceptor() {
    }

    @Override // com.bytedance.android.live.effect.sticker.chain.m
    public final void a(l r7) {
        Intrinsics.checkNotNullParameter(r7, "chain");
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = r7.e;
        String r2 = r7.f;
        r0.getClass();
        LiveCommonStickerUIViewModel r3 = (LiveCommonStickerUIViewModel) StickerBaseViewModel.a.b(r1, r2, LiveCommonStickerUIViewModel.class);
        List<String> r4 = LiveEffectContext.h;
        com.bytedance.android.live.effect.api.k r5 = LiveEffectContext.a.a(r7.getType()).b().r();
        com.bytedance.android.live.effect.api.l r6 = LiveEffectContext.a.a(r7.getType()).b().j();
        LiveCommonDownloadStickerInterceptor$intercept$1 r8 = new LiveCommonDownloadStickerInterceptor$intercept$1(r3, r7);
        LiveCommonDownloadStickerInterceptor$intercept$2 r9 = new LiveCommonDownloadStickerInterceptor$intercept$2(r3, r7);
        Sticker r11 = r7.g;
        if (r5.q(r11) == false) goto L5;
        r8.invoke(r11);
        return;
    L5:
        r11.setDownloading(true);
        if (r3 == null) goto L10;
        com.bytedance.live.datacontext.k<Sticker> r12 = r3.getStickerDownloadStartEvent();
        if (r12 == null) goto L10;
        r12.post(r11);
    L10:
        r6.b(r7.f, r11, new a(r8, r9, r11));
    }
}
