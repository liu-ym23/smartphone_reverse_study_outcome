package com.bytedance.android.live.effect.sticker.chain;

import com.bytedance.android.live.effect.common.LiveCommonStickerUIViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"onDownloadSuccess", "", "sticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class LiveCommonDownloadStickerInterceptor$intercept$1 extends Lambda implements Function1<Sticker, Unit> {
    final /* synthetic */ l $chain;
    final /* synthetic */ LiveCommonStickerUIViewModel $stickerUIViewModel;

    public LiveCommonDownloadStickerInterceptor$intercept$1(LiveCommonStickerUIViewModel r1, l r2) {
        this.$stickerUIViewModel = r1;
        this.$chain = r2;
        super(1);
    }

    public final void invoke(Sticker r3) {
        Intrinsics.checkNotNullParameter(r3, "sticker");
        r3.setDownloading(false);
        r3.setDownloaded(true);
        LiveCommonStickerUIViewModel r0 = this.$stickerUIViewModel;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.k<Sticker> r1 = r0.getStickerDownloadCompleteEvent();
        if (r1 == null) goto L7;
        r1.post(r3);
    L7:
        l r2 = this.$chain;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.g = r3;
        this.$chain.a();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Sticker) r1);
        return Unit.INSTANCE;
    }
}
