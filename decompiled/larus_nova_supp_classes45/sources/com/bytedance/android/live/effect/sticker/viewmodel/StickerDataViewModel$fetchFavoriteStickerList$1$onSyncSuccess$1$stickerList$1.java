package com.bytedance.android.live.effect.sticker.viewmodel;

import com.bytedance.android.live.effect.sticker.ui.SpecialTabType;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel$fetchFavoriteStickerList$1$onSyncSuccess$1$stickerList$1", f = "StickerDataViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class StickerDataViewModel$fetchFavoriteStickerList$1$onSyncSuccess$1$stickerList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<Sticker>>, Object> {
    int label;
    final /* synthetic */ StickerDataViewModel$fetchFavoriteStickerList$1$onSyncSuccess$1 this$0;

    public StickerDataViewModel$fetchFavoriteStickerList$1$onSyncSuccess$1$stickerList$1(StickerDataViewModel$fetchFavoriteStickerList$1$onSyncSuccess$1 r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new StickerDataViewModel$fetchFavoriteStickerList$1$onSyncSuccess$1$stickerList$1(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r4);
        StickerDataViewModel r5 = this.this$0.this$0.a;
        String r0 = SpecialTabType.FAVORITE.getTabKey();
        StickerDataViewModel$fetchFavoriteStickerList$1$onSyncSuccess$1 r1 = this.this$0;
        StickerDataViewModel r2 = r1.this$0.a;
        EffectCategoryResponse r3 = r1.$response;
        if (r3 == null) goto L8;
        List r6 = r3.getTotalEffects();
        if (r6 == null) goto L8;
    L10:
        return r5.dealWithPopUpStickerIfNeed(r0, StickerDataViewModel.access$convertEffectListToStickerList(r2, r6));
    L8:
        r6 = CollectionsKt.emptyList();
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
