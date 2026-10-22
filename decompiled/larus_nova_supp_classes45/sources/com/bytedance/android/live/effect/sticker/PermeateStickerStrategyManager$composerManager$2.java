package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "invoke"}, k = 3, mv = {1, 4, 3})
final class PermeateStickerStrategyManager$composerManager$2 extends Lambda implements Function0<ILiveEffectComposerManager> {
    public static final PermeateStickerStrategyManager$composerManager$2 INSTANCE = null;

    static {
        INSTANCE = new PermeateStickerStrategyManager$composerManager$2();
    }

    public PermeateStickerStrategyManager$composerManager$2() {
        super(0);
    }

    public final ILiveEffectComposerManager invoke() {
        List<String> r0 = LiveEffectContext.h;
        return LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m746invoke() {
        return invoke();
    }
}
