package com.obric.flow.cardlistpage.ui.component.feedlist;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.FakeWidgetCardModel;
import com.obric.flow.cardlistpage.data.WidgetCardModel;
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
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent$addCardFromPicker$1", f = "FeedListComponent.kt", i = {}, l = {948}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nFeedListComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$addCardFromPicker$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1384:1\n827#2:1385\n855#2,2:1386\n360#2,7:1388\n*S KotlinDebug\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$addCardFromPicker$1\n*L\n953#1:1385\n953#1:1386,2\n959#1:1388,7\n*E\n"})
final class FeedListComponent$addCardFromPicker$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $cellHeight;
    final /* synthetic */ int $cellWidth;
    final /* synthetic */ Integer $insertPosition;
    final /* synthetic */ int $spacingY;
    final /* synthetic */ int $widgetId;
    int label;
    final /* synthetic */ s this$0;

    public FeedListComponent$addCardFromPicker$1(s r5, int r10, int r11, int r12, int r13, Integer r14, Continuation<? super FeedListComponent$addCardFromPicker$1> r15) {
        this.this$0 = r5;
        this.$widgetId = r10;
        this.$cellWidth = r11;
        this.$cellHeight = r12;
        this.$spacingY = r13;
        this.$insertPosition = r14;
        super(2, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new FeedListComponent$addCardFromPicker$1(this.this$0, this.$widgetId, this.$cellWidth, this.$cellHeight, this.$spacingY, this.$insertPosition, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L17:
        List r13 = (List) r12;
        if (r13 == null) goto L20;
        this.this$0.d(new z(r13));
        int r11 = this.$widgetId;
        Iterator r14 = r13.iterator();
        int r15 = 0;
    L23:
        if (r14.hasNext() == false) goto L30;
        BaseCardModel r16 = (BaseCardModel) r14.next();
        if ((r16 instanceof WidgetCardModel) == false) goto L29;
        if (Intrinsics.areEqual(r16.getOriginalId(), String.valueOf(r11)) == false) goto L29;
    L31:
        if (r15 == (-1)) goto L34;
        this.this$0.e.smoothScrollToPosition(r15);
    L34:
        return Unit.INSTANCE;
    L29:
        r15 = r15 + 1;
        goto L23
    L30:
        r15 = -1;
        goto L31
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        s r17 = this.this$0;
        u r18 = r17.f11601i;
        int r19 = this.$widgetId;
        int r20 = this.$cellWidth;
        int r21 = this.$cellHeight;
        int r22 = this.$spacingY;
        List r110 = ((v) ((com.obric.flow.cardlistpage.mvi.a) r17.f11531a).b()).b();
        ArrayList r23 = new ArrayList();
        Iterator r111 = r110.iterator();
    L10:
        if (r111.hasNext() == false) goto L14;
        Object r24 = r111.next();
        if ((((BaseCardModel) r24) instanceof FakeWidgetCardModel) == true) goto L10;
        r23.add(r24);
        goto L10
    L14:
        Integer r25 = this.$insertPosition;
        this.label = 1;
        r12 = r18.e.b(r19, r20, r21, r22, r23, r25, this);
        if (r12 != r5) goto L17;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((FeedListComponent$addCardFromPicker$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
