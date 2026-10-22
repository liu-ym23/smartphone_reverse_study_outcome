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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent$removeCard$1", f = "FeedListComponent.kt", i = {}, l = {861}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nFeedListComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$removeCard$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1384:1\n827#2:1385\n855#2,2:1386\n295#2,2:1388\n*S KotlinDebug\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$removeCard$1\n*L\n859#1:1385\n859#1:1386,2\n860#1:1388,2\n*E\n"})
final class FeedListComponent$removeCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardId;
    final /* synthetic */ int $widgetId;
    int label;
    final /* synthetic */ s this$0;

    public FeedListComponent$removeCard$1(s r5, String r10, int r11, Continuation<? super FeedListComponent$removeCard$1> r12) {
        this.this$0 = r5;
        this.$cardId = r10;
        this.$widgetId = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new FeedListComponent$removeCard$1(this.this$0, this.$cardId, this.$widgetId, r10);
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
    L24:
        this.this$0.d(new z((List) r10));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        List r12 = ((v) ((com.obric.flow.cardlistpage.mvi.a) this.this$0.f11531a).b()).b();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        Object r15 = r14.next();
        if ((((BaseCardModel) r15) instanceof FakeWidgetCardModel) == true) goto L10;
        r13.add(r15);
        goto L10
    L14:
        s r16 = this.this$0;
        String r17 = this.$cardId;
        Iterator r18 = r13.iterator();
    L16:
        if (r18.hasNext() == false) goto L20;
        Object r19 = r18.next();
        if (Intrinsics.areEqual(((BaseCardModel) r19).getId(), r17) == false) goto L16;
    L21:
        s.k(r16, (BaseCardModel) r19);
        u r20 = this.this$0.f11601i;
        String r21 = this.$cardId;
        int r22 = this.$widgetId;
        this.label = 1;
        r10 = r20.b(r13, r21, r22, this);
        if (r10 != r5) goto L24;
        return r5;
    L20:
        r19 = null;
        goto L21
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((FeedListComponent$removeCard$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
