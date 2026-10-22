package com.obric.flow.cardlistpage.ui.component.feedlist;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.WidgetCardModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent$refreshStepCounterWidgetIfNeeded$hasStepCounterWidget$1", f = "FeedListComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nFeedListComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$refreshStepCounterWidgetIfNeeded$hasStepCounterWidget$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1384:1\n808#2,11:1385\n1755#2,3:1396\n*S KotlinDebug\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$refreshStepCounterWidgetIfNeeded$hasStepCounterWidget$1\n*L\n807#1:1385,11\n808#1:1396,3\n*E\n"})
final class FeedListComponent$refreshStepCounterWidgetIfNeeded$hasStepCounterWidget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<BaseCardModel> $cards;
    int label;
    final /* synthetic */ s this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public FeedListComponent$refreshStepCounterWidgetIfNeeded$hasStepCounterWidget$1(List<? extends BaseCardModel> r5, s r10, Continuation<? super FeedListComponent$refreshStepCounterWidgetIfNeeded$hasStepCounterWidget$1> r11) {
        this.$cards = r5;
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new FeedListComponent$refreshStepCounterWidgetIfNeeded$hasStepCounterWidget$1(this.$cards, this.this$0, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Boolean> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r5);
        List<BaseCardModel> r10 = this.$cards;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        Object r13 = r12.next();
        if ((r13 instanceof WidgetCardModel) == false) goto L6;
        r11.add(r13);
        goto L6
    L10:
        s r14 = this.this$0;
        boolean r15 = false;
        if (r11.isEmpty() == true) goto L29;
        Iterator r16 = r11.iterator();
    L15:
        if (r16.hasNext() == false) goto L29;
        Integer r17 = StringsKt.toIntOrNull(((WidgetCardModel) r16.next()).getOriginalId());
        if (r17 == null) goto L25;
        AppWidgetProviderInfo r18 = r14.g.getAppWidgetInfo(r17.intValue());
        if (r18 == null) goto L23;
        ComponentName r19 = r18.provider;
        if (r19 == null) goto L23;
        String r20 = r19.getPackageName();
    L24:
        boolean r21 = Intrinsics.areEqual(r20, "com.obric.health");
    L26:
        if (r21 == false) goto L15;
        r15 = true;
    L23:
        r20 = null;
        goto L24
    L25:
        r21 = false;
    L29:
        return Boxing.boxBoolean(r15);
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Boolean> r10) {
        return ((FeedListComponent$refreshStepCounterWidgetIfNeeded$hasStepCounterWidget$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
