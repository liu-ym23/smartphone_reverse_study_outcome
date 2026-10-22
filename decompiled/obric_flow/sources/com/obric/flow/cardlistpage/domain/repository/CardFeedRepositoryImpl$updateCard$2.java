package com.obric.flow.cardlistpage.domain.repository;

import androidx.room.CoroutinesRoom;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.c;
import com.obric.flow.cardlistpage.data.g;
import com.obric.flow.cardlistpage.data.h;
import com.obric.flow.cardlistpage.data.j;
import com.obric.flow.cardlistpage.data.l;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.domain.repository.CardFeedRepositoryImpl$updateCard$2", f = "CardFeedRepositoryImpl.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
final class CardFeedRepositoryImpl$updateCard$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseCardModel $card;
    int label;

    public CardFeedRepositoryImpl$updateCard$2(BaseCardModel r5, Continuation<? super CardFeedRepositoryImpl$updateCard$2> r10) {
        this.$card = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new CardFeedRepositoryImpl$updateCard$2(this.$card, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        c r12 = c.f11462b.f();
        BaseCardModel r13 = this.$card;
        this.label = 1;
        j r14 = l.a(r13, null, 3);
        h r15 = (h) r12.f11464a;
        r15.getClass();
        g r16 = new g(r15, r14, 1);
        Object r17 = CoroutinesRoom.execute(r15.f11479a, true, r16, this);
        if (r17 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r17 = Unit.INSTANCE;
    L12:
        if (r17 != r5) goto L15;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((CardFeedRepositoryImpl$updateCard$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
