package com.bytedance.android.live.effect.sticker.chain;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerPreviewStatus;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerPreviewViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerRenderViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k implements m {
    public k() {
    }

    @Override // com.bytedance.android.live.effect.sticker.chain.m
    public final void a(l r14) {
        Intrinsics.checkNotNullParameter(r14, "chain");
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = r14.e;
        r0.getClass();
        StickerDialogUIViewModel r2 = (StickerDialogUIViewModel) StickerBaseViewModel.a.a(r1, StickerDialogUIViewModel.class);
        StickerPreviewViewModel r3 = (StickerPreviewViewModel) StickerBaseViewModel.a.a(r14.e, StickerPreviewViewModel.class);
        StickerRenderViewModel r4 = (StickerRenderViewModel) StickerBaseViewModel.a.a(r14.e, StickerRenderViewModel.class);
        long r5 = r14.g.getId();
        if (r4 == null) goto L12;
        LiveData<Sticker> r6 = r4.getRenderStickerData();
        if (r6 == null) goto L12;
        Sticker r7 = (Sticker) r6.getValue();
        if (r7 == null) goto L12;
        if (r5 != r7.getId()) goto L12;
        if (r3 == null) goto L46;
        StickerPreviewViewModel.updatePreviewStatus$default(r3, StickerPreviewStatus.None, null, null, null, 12, null);
    L46:
        r14.a();
        return;
    L12:
        boolean r8 = true;
        if (r4 == null) goto L15;
        boolean r9 = r4.isAllowOtherStickerPreview();
    L16:
        ALogger.i("PreviewStickerInterceptor", "intercept: allowOtherEffectPreview = " + r9);
        List<Integer> r11 = com.bytedance.android.live.effect.sticker.a.a;
        IPerformanceManager r12 = jc1.k.f(IPerformanceManager.class);
        double r13 = 0.0d;
        if (r12 == null) goto L19;
        double r15 = r12.getCpuRate();
    L20:
        IPerformanceManager r16 = jc1.k.f(IPerformanceManager.class);
        long r17 = 0;
        if (r16 == null) goto L23;
        long r18 = r16.getJavaHeapLeave();
    L24:
        IPerformanceManager r19 = jc1.k.f(IPerformanceManager.class);
        if (r19 == null) goto L27;
        r17 = r19.getNativeHeapLeave();
    L27:
        IPerformanceManager r21 = jc1.k.f(IPerformanceManager.class);
        if (r21 == null) goto L30;
        r13 = r21.getStreamRealFps();
    L30:
        ALogger.i("ttlive_anchor_effect_EffectPreviewHelper", "current cpuRate=" + r15 + ",jMem=" + r18 + ",nMem=" + r17 + ",fps=" + r13);
        l90.b r22 = LiveEffectSettings.LIVE_ANCHOR_EFFECT_PREVIEW_CONFIG.getValue().a();
        if (r13 > 0) goto L33;
    L35:
        if (r8 == true) goto L37;
    L44:
        if (r3 == null) goto L46;
        r3.updatePreviewStatus(StickerPreviewStatus.Downgrade, r14.g, r14.h, r14.a);
        goto L46
    L37:
        if (r14.g.getDisableEffectPreview() != 0) goto L44;
        if (r14.e == LiveEffectScene.GiftMenuPreview) goto L44;
        if (r9 == false) goto L44;
        if (r3 == null) goto L46;
        r3.updatePreviewStatus(StickerPreviewStatus.Preview, r14.g, r14.h, r14.a);
        goto L46
    L33:
        if (r13 >= r22.a()) goto L35;
        r8 = false;
        goto L35
    L23:
        r18 = 0;
        goto L24
    L19:
        r15 = 0.0d;
        goto L20
    L15:
        r9 = true;
        goto L16
    }
}
