package com.bytedance.android.live.effect.sticker.presenter;

import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LiveStickerDataManager$fetchAllSticker$fetchEffectChannelListener$1$onSuccess$1 extends FunctionReferenceImpl implements Function1<Effect, Boolean> {
    public LiveStickerDataManager$fetchAllSticker$fetchEffectChannelListener$1$onSuccess$1(LiveStickerDataManager r8) {
        super(1, r8, LiveStickerDataManager.class, "getEffectDownloadStatusSync", "getEffectDownloadStatusSync(Lcom/ss/android/ugc/effectmanager/effect/model/Effect;)Z", 0);
    }

    public final boolean invoke(Effect r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        LiveStickerDataManager r0 = (LiveStickerDataManager) ((CallableReference) this).receiver;
        int r1 = LiveStickerDataManager.m;
        return r0.t().isEffectDownloaded(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((Effect) r1));
    }
}
