package com.bytedance.android.live.effect.sticker.viewmodel;

import com.bytedance.android.live.effect.sticker.ui.SpecialTabType;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel$fetchCampaignStickerListFromCacheAndUpdate$1$stickerList$1", f = "StickerDataViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class StickerDataViewModel$fetchCampaignStickerListFromCacheAndUpdate$1$stickerList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<Sticker>>, Object> {
    int label;
    final /* synthetic */ StickerDataViewModel.AnonymousClass1 this$0;

    public StickerDataViewModel$fetchCampaignStickerListFromCacheAndUpdate$1$stickerList$1(StickerDataViewModel.AnonymousClass1 r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new StickerDataViewModel$fetchCampaignStickerListFromCacheAndUpdate$1$stickerList$1(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        StickerDataViewModel r6 = this.this$0.this$0;
        String r0 = SpecialTabType.CAMPAIGN.getTabKey();
        StickerDataViewModel r1 = this.this$0.this$0;
        return r6.dealWithPopUpStickerIfNeed(r0, StickerDataViewModel.access$convertEffectListToStickerList(r1, StickerDataViewModel.access$getStickerDataManager$p(r1).c(StickerDataViewModel.access$getPanel$p(this.this$0.this$0))));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
