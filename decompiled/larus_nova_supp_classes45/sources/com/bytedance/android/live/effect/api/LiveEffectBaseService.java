package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.effect.sticker.LiveStickerDownloadHelper;
import com.bytedance.android.live.effect.sticker.presenter.LiveStickerDataManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveEffectBaseService implements g {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    @Override // com.bytedance.android.live.effect.api.g
    public final LiveStickerDataManager a() {
        return (LiveStickerDataManager) this.b.getValue();
    }

    @Override // com.bytedance.android.live.effect.api.g
    public final com.bytedance.android.live.effect.sticker.presenter.z b() {
        return (com.bytedance.android.live.effect.sticker.presenter.z) this.a.getValue();
    }

    @Override // com.bytedance.android.live.effect.api.g
    public final com.bytedance.android.live.effect.sticker.presenter.r c() {
        return (com.bytedance.android.live.effect.sticker.presenter.r) this.e.getValue();
    }

    @Override // com.bytedance.android.live.effect.api.g
    public final com.bytedance.android.live.effect.b d() {
        return (com.bytedance.android.live.effect.b) this.d.getValue();
    }

    @Override // com.bytedance.android.live.effect.api.g
    public final com.bytedance.android.live.effect.sticker.presenter.q e() {
        return (com.bytedance.android.live.effect.sticker.presenter.q) this.f.getValue();
    }

    @Override // com.bytedance.android.live.effect.api.g
    public final LiveStickerDownloadHelper f() {
        return (LiveStickerDownloadHelper) this.c.getValue();
    }

    public LiveEffectBaseService(final LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = LazyKt.lazy(new LiveEffectBaseService$liveStickerPresenter$2(r2));
        this.b = LazyKt.lazy(new LiveEffectBaseService$liveStickerDataManager$2(r2));
        this.c = LazyKt.lazy(new LiveEffectBaseService$liveStickerDownloadHelper$2(r2));
        this.d = LazyKt.lazy(new LiveEffectBaseService$liveAreaSmallItemBeautyHelper$2(r2));
        this.e = LazyKt.lazy(LiveEffectBaseService$liveCommonInteractStickerManager$2.INSTANCE);
        this.f = LazyKt.lazy(LiveEffectBaseService$liveBeautyModeManager$2.INSTANCE);
    }
}
