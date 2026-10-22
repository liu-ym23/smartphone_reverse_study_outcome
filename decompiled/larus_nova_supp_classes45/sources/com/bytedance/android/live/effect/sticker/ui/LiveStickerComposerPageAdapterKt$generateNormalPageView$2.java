package com.bytedance.android.live.effect.sticker.ui;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"loadTabStickers", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveStickerComposerPageAdapterKt$generateNormalPageView$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ d $holder;
    final /* synthetic */ CharSequence $pageTitle;
    final /* synthetic */ int $position;
    final /* synthetic */ LoadingStatusView $statusView;
    final /* synthetic */ LiveStickerComposerPageAdapterKt this$0;

    public LiveStickerComposerPageAdapterKt$generateNormalPageView$2(LiveStickerComposerPageAdapterKt r1, int r2, CharSequence r3, d r4, LoadingStatusView r5) {
        this.this$0 = r1;
        this.$position = r2;
        this.$pageTitle = r3;
        this.$holder = r4;
        this.$statusView = r5;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m756invoke() {
        List<String> r0 = LiveEffectContext.h;
        LiveStickerComposerPageAdapterKt r1 = this.this$0;
        int r2 = LiveStickerComposerPageAdapterKt.a;
        r1.getClass();
        LiveEffectContext.a.a(null);
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m756invoke();
        return Unit.INSTANCE;
    }
}
