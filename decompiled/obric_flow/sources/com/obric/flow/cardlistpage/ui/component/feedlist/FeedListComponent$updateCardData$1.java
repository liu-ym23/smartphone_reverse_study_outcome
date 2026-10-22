package com.obric.flow.cardlistpage.ui.component.feedlist;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.FakeWidgetCardModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent$updateCardData$1", f = "FeedListComponent.kt", i = {}, l = {849}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nFeedListComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$updateCardData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1384:1\n827#2:1385\n855#2,2:1386\n*S KotlinDebug\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$updateCardData$1\n*L\n850#1:1385\n850#1:1386,2\n*E\n"})
final class FeedListComponent$updateCardData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseCardModel $card;
    int label;
    final /* synthetic */ s this$0;

    public FeedListComponent$updateCardData$1(s r5, BaseCardModel r10, Continuation<? super FeedListComponent$updateCardData$1> r11) {
        this.this$0 = r5;
        this.$card = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new FeedListComponent$updateCardData$1(this.this$0, this.$card, r10);
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
    L17:
        this.this$0.d(new z((List) r10));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        s r12 = this.this$0;
        u r13 = r12.f11601i;
        List r14 = ((v) ((com.obric.flow.cardlistpage.mvi.a) r12.f11531a).b()).b();
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L10:
        if (r16.hasNext() == false) goto L14;
        Object r17 = r16.next();
        if ((((BaseCardModel) r17) instanceof FakeWidgetCardModel) == true) goto L10;
        r15.add(r17);
        goto L10
    L14:
        BaseCardModel r18 = this.$card;
        this.label = 1;
        r10 = r13.d(r15, r18, this);
        if (r10 != r5) goto L17;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((FeedListComponent$updateCardData$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
