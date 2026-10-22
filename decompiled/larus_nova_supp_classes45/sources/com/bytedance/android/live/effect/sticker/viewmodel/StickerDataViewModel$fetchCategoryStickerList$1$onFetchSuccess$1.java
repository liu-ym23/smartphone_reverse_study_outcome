package com.bytedance.android.live.effect.sticker.viewmodel;

import com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerLoadingStatus;
import com.bytedance.android.livesdkapi.depend.model.InsertStickerInfo;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel$fetchCategoryStickerList$1$onFetchSuccess$1", f = "StickerDataViewModel.kt", i = {}, l = {213}, m = "invokeSuspend", n = {}, s = {})
public final class StickerDataViewModel$fetchCategoryStickerList$1$onFetchSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $effectList;
    int label;
    final /* synthetic */ StickerDataViewModel.C03161 this$0;

    public StickerDataViewModel$fetchCategoryStickerList$1$onFetchSuccess$1(StickerDataViewModel.C03161 r1, List r2, Continuation r3) {
        this.this$0 = r1;
        this.$effectList = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new StickerDataViewModel$fetchCategoryStickerList$1$onFetchSuccess$1(this.this$0, this.$effectList, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Sticker r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        List<Sticker> r6 = (List) r5;
        StickerDataViewModel.C03161 r3 = this.this$0;
        StickerDataViewModel r4 = r3.a;
        String r7 = r3.b;
        InsertStickerInfo r8 = r4.getInsertStickerInfo();
        if (r8 == null) goto L14;
        r2 = r8.getSticker();
    L14:
        r4.dealWithInsertStickerIfNeed(r7, r2, r6);
        this.this$0.a.removeStickerForSaas(r6);
        this.this$0.a.getNormalCategoryInfoMap().update(this.this$0.b, r6);
        this.this$0.a.getTabLoadingStatusMap().update(this.this$0.b, StickerLoadingStatus.Normal);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        StickerDataViewModel$fetchCategoryStickerList$1$onFetchSuccess$1$stickerList$1 r11 = new StickerDataViewModel$fetchCategoryStickerList$1$onFetchSuccess$1$stickerList$1(this, null);
        this.label = 1;
        r5 = BuildersKt.withContext(r9, r11, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
