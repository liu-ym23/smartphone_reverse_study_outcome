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
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent$refreshCards$1", f = "FeedListComponent.kt", i = {1}, l = {757, 762, 765}, m = "invokeSuspend", n = {"cards"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nFeedListComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$refreshCards$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1384:1\n827#2:1385\n855#2,2:1386\n*S KotlinDebug\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$refreshCards$1\n*L\n759#1:1385\n759#1:1386,2\n*E\n"})
final class FeedListComponent$refreshCards$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFirstLoad;
    final /* synthetic */ boolean $refreshStepCounter;
    Object L$0;
    int label;
    final /* synthetic */ s this$0;

    public FeedListComponent$refreshCards$1(s r5, boolean r10, boolean r11, Continuation<? super FeedListComponent$refreshCards$1> r12) {
        this.this$0 = r5;
        this.$isFirstLoad = r10;
        this.$refreshStepCounter = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new FeedListComponent$refreshCards$1(this.this$0, this.$isFirstLoad, this.$refreshStepCounter, r10);
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
        if (r11 == 0) goto L12;
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L10;
        if (r11 != 3) goto L9;
        ResultKt.throwOnFailure(r10);
    L30:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        List r12 = (List) this.L$0;
        ResultKt.throwOnFailure(r10);
    L24:
        this.this$0.y();
        if (this.$refreshStepCounter == false) goto L30;
        s r13 = this.this$0;
        this.L$0 = null;
        this.label = 3;
        if (s.m(r13, r12, this) != r5) goto L30;
        return r5;
    L11:
        ResultKt.throwOnFailure(r10);
    L21:
        r12 = (List) r10;
        this.this$0.d(new z(r12));
        s r14 = this.this$0;
        this.L$0 = r12;
        this.label = 2;
        if (s.l(r14, r12, this) != r5) goto L24;
        return r5;
    L12:
        ResultKt.throwOnFailure(r10);
        s r15 = this.this$0;
        u r16 = r15.f11601i;
        boolean r17 = this.$isFirstLoad;
        List r18 = ((v) ((com.obric.flow.cardlistpage.mvi.a) r15.f11531a).b()).b();
        ArrayList r19 = new ArrayList();
        Iterator r110 = r18.iterator();
    L14:
        if (r110.hasNext() == false) goto L18;
        Object r20 = r110.next();
        if ((((BaseCardModel) r20) instanceof FakeWidgetCardModel) == true) goto L14;
        r19.add(r20);
        goto L14
    L18:
        this.label = 1;
        r10 = r16.a(r17, r19, this);
        if (r10 != r5) goto L21;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((FeedListComponent$refreshCards$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
