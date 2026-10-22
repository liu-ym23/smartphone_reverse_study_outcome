package com.bytedance.android.live.effect.sticker.ui;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/presenter/s;", "kotlin.jvm.PlatformType", "invoke", "()Lcom/bytedance/android/live/effect/sticker/presenter/s;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LiveStickerComposerListAdapterKt$aigcTaskManager$2 extends Lambda implements Function0<com.bytedance.android.live.effect.sticker.presenter.s> {
    final /* synthetic */ LiveStickerComposerListAdapterKt this$0;

    public LiveStickerComposerListAdapterKt$aigcTaskManager$2(LiveStickerComposerListAdapterKt r1) {
        this.this$0 = r1;
        super(0);
    }

    public final com.bytedance.android.live.effect.sticker.presenter.s invoke() {
        List<String> r0 = LiveEffectContext.h;
        return LiveEffectContext.a.a(this.this$0.getType()).b().i();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m754invoke() {
        return invoke();
    }
}
