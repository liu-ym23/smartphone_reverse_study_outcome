package com.bytedance.android.live.effect.sticker.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/live/effect/sticker/viewmodel/StickerDataViewModel$updateStickerFavoriteStatus$1$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel$updateStickerFavoriteStatus$1$1", f = "StickerDataViewModel.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
public final class StickerDataViewModel$updateStickerFavoriteStatus$$inlined$let$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EffectCategoryResponse $it;
    int label;
    final /* synthetic */ StickerDataViewModel this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel$updateStickerFavoriteStatus$$inlined$let$lambda$1$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/live/effect/sticker/viewmodel/StickerDataViewModel$updateStickerFavoriteStatus$1$1$stickerList$1"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel$updateStickerFavoriteStatus$1$1$stickerList$1", f = "StickerDataViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<Sticker>>, Object> {
        int label;
        final /* synthetic */ StickerDataViewModel$updateStickerFavoriteStatus$$inlined$let$lambda$1 this$0;

        public AnonymousClass1(StickerDataViewModel$updateStickerFavoriteStatus$$inlined$let$lambda$1 r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass1(this.this$0, r3);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            StickerDataViewModel$updateStickerFavoriteStatus$$inlined$let$lambda$1 r3 = this.this$0;
            return StickerDataViewModel.access$convertEffectListToStickerList(r3.this$0, r3.$it.getTotalEffects());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public StickerDataViewModel$updateStickerFavoriteStatus$$inlined$let$lambda$1(EffectCategoryResponse r1, Continuation r2, StickerDataViewModel r3) {
        this.$it = r1;
        this.this$0 = r3;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new StickerDataViewModel$updateStickerFavoriteStatus$$inlined$let$lambda$1(this.$it, r4, this.this$0);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        MutableLiveData r2 = StickerDataViewModel.access$get_favoriteCategoryInfo$p(this.this$0);
        r2.setValue((List) r5);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoroutineDispatcher r6 = Dispatchers.getIO();
        AnonymousClass1 r3 = new AnonymousClass1(this, null);
        this.label = 1;
        r5 = BuildersKt.withContext(r6, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
