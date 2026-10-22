package com.bytedance.android.live.effect.sticker.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/live/effect/sticker/ui/LiveStickerComposerPageAdapterKt$generateSearchPageView$keywordView$1$1"}, k = 3, mv = {1, 4, 3})
final class LiveStickerComposerPageAdapterKt$generateSearchPageView$$inlined$apply$lambda$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $keyword$inlined;
    final /* synthetic */ LiveStickerComposerPageAdapterKt this$0;

    public LiveStickerComposerPageAdapterKt$generateSearchPageView$$inlined$apply$lambda$3(LiveStickerComposerPageAdapterKt r1, String r2) {
        this.this$0 = r1;
        this.$keyword$inlined = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m757invoke() {
        m90.c<Boolean> r0 = m90.b.p;
        LiveStickerComposerPageAdapterKt r1 = this.this$0;
        int r2 = LiveStickerComposerPageAdapterKt.a;
        r1.getClass();
        r0.e(null, Boolean.TRUE);
        this.this$0.getClass();
        xs2.b.a().post(new a(this.$keyword$inlined));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m757invoke();
        return Unit.INSTANCE;
    }
}
