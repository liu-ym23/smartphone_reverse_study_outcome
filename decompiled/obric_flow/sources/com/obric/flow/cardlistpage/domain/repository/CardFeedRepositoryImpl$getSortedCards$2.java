package com.obric.flow.cardlistpage.domain.repository;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/obric/flow/cardlistpage/base/BaseCardModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.domain.repository.CardFeedRepositoryImpl$getSortedCards$2", f = "CardFeedRepositoryImpl.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
final class CardFeedRepositoryImpl$getSortedCards$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends BaseCardModel>>, Object> {
    int label;

    public CardFeedRepositoryImpl$getSortedCards$2(Continuation<? super CardFeedRepositoryImpl$getSortedCards$2> r5) {
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new CardFeedRepositoryImpl$getSortedCards$2(r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super List<? extends BaseCardModel>> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        m r12 = m.f11499a;
        this.label = 1;
        r5 = r12.a(this);
        if (r5 != r10) goto L11;
        return r10;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super List<? extends BaseCardModel>> r10) {
        return ((CardFeedRepositoryImpl$getSortedCards$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
