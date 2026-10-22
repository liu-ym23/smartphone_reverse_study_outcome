package com.obric.flow.cardlistpage.ui.component.feedlist;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.FakeWidgetCardModel;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent$addMiniAppWidget$1", f = "FeedListComponent.kt", i = {0}, l = {1044}, m = "invokeSuspend", n = {"currentCards"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nFeedListComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$addMiniAppWidget$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1384:1\n827#2:1385\n855#2,2:1386\n808#2,11:1388\n295#2:1399\n2632#2,3:1400\n296#2:1403\n388#2,7:1404\n*S KotlinDebug\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$addMiniAppWidget$1\n*L\n1038#1:1385\n1038#1:1386,2\n1050#1:1388,11\n1051#1:1399\n1052#1:1400,3\n1051#1:1403\n1058#1:1404,7\n*E\n"})
final class FeedListComponent$addMiniAppWidget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventName;
    final /* synthetic */ obric.flow.miniappwidget.f $input;
    final /* synthetic */ Integer $insertPosition;
    Object L$0;
    int label;
    final /* synthetic */ s this$0;

    public FeedListComponent$addMiniAppWidget$1(s r5, obric.flow.miniappwidget.f r10, Integer r11, String r12, Continuation<? super FeedListComponent$addMiniAppWidget$1> r13) {
        this.this$0 = r5;
        this.$input = r10;
        this.$insertPosition = r11;
        this.$eventName = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new FeedListComponent$addMiniAppWidget$1(this.this$0, this.$input, this.$insertPosition, this.$eventName, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        List r11 = (List) this.L$0;
        ResultKt.throwOnFailure(r14);
    L20:
        List r15 = (List) r14;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r15.iterator();
    L22:
        if (r13.hasNext() == false) goto L26;
        Object r16 = r13.next();
        if ((r16 instanceof MiniAppWidgetCardModel) == false) goto L22;
        r12.add(r16);
        goto L22
    L26:
        Iterator r17 = r12.iterator();
    L28:
        if (r17.hasNext() == false) goto L40;
        Object r18 = r17.next();
        MiniAppWidgetCardModel r19 = (MiniAppWidgetCardModel) r18;
        if (r11 != null) goto L32;
    L34:
        Iterator r20 = r11.iterator();
    L36:
        if (r20.hasNext() == false) goto L41;
        if (Intrinsics.areEqual(((BaseCardModel) r20.next()).getId(), r19.getId()) == false) goto L36;
    L41:
        MiniAppWidgetCardModel r21 = (MiniAppWidgetCardModel) r18;
        if (r21 == null) goto L50;
        obric.flow.miniappwidget.l r22 = this.this$0.f11600h;
        String r23 = r21.getInstanceId();
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "instanceId");
        if (StringsKt.isBlank(r23) == true) goto L50;
        r22.f20494h.add(r23);
        String r24 = androidx.constraintlayout.motion.widget.a.t(new StringBuilder("markNextBindAsAdd hostId="), r22.f20491a, " instanceId=", r23);
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");
        Intrinsics.checkNotNullParameter(r24, "msg");
        org.koin.core.a r25 = su.a.f22013b;
        if (r25 == null) goto L49;
        ((ju.b) r25.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetHost", r24);
        goto L50
    L49:
        throw new IllegalStateException("KoinApplication has not been started");
    L50:
        this.this$0.d(new z(r15));
        Integer r26 = this.$insertPosition;
        if (r26 == null) goto L53;
        int r110 = r26.intValue();
    L64:
        if (r110 == (-1)) goto L66;
        this.this$0.e.smoothScrollToPosition(r110);
    L66:
        eq.b r111 = com.lynx.tasm.utils.k.r();
        String r27 = this.$eventName;
        JSONObject r28 = new JSONObject();
        obric.flow.miniappwidget.f r112 = this.$input;
        String r29 = r112.f20477c;
        if (r29 != null) goto L69;
        r29 = r112.f20476b;
    L69:
        r28.put("widget_name", r29);
        r28.put("applet_id", r112.f20475a);
        Unit r113 = Unit.INSTANCE;
        r111.a(r27, r28);
        return Unit.INSTANCE;
    L53:
        obric.flow.miniappwidget.f r30 = this.$input;
        ListIterator r114 = r15.listIterator(r15.size());
    L55:
        if (r114.hasPrevious() == false) goto L63;
        BaseCardModel r31 = (BaseCardModel) r114.previous();
        if ((r31 instanceof MiniAppWidgetCardModel) == false) goto L55;
        MiniAppWidgetCardModel r32 = (MiniAppWidgetCardModel) r31;
        if (Intrinsics.areEqual(r32.getAppletId(), r30.f20475a) == false) goto L55;
        if (Intrinsics.areEqual(r32.getWidgetId(), r30.f20476b) == false) goto L55;
        r110 = r114.nextIndex();
        goto L64
    L63:
        r110 = -1;
        goto L64
    L32:
        if (r11.isEmpty() == false) goto L34;
    L40:
        r18 = null;
        goto L41
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        List r115 = ((v) ((com.obric.flow.cardlistpage.mvi.a) this.this$0.f11531a).b()).b();
        ArrayList r33 = new ArrayList();
        Iterator r116 = r115.iterator();
    L10:
        if (r116.hasNext() == false) goto L14;
        Object r34 = r116.next();
        if ((((BaseCardModel) r34) instanceof FakeWidgetCardModel) == true) goto L10;
        r33.add(r34);
        goto L10
    L14:
        String r117 = this.this$0.f11600h.f20491a;
        obric.flow.miniappwidget.f r35 = this.$input;
        StringBuilder r118 = androidx.constraintlayout.motion.widget.a.y("miniAppWidget add hostId=", r117, " appletId=", r35.f20475a, " widgetId=");
        r118.append(r35.f20476b);
        r118.append(" definitionId=");
        String r119 = androidx.room.jarjarred.org.antlr.runtime.a.w(r118, r35.f20479i, "FeedListComponent", "tag", "msg");
        org.koin.core.a r36 = su.a.f22013b;
        if (r36 == null) goto L72;
        ((ju.b) r36.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("FeedListComponent", r119);
        u r120 = this.this$0.f11601i;
        obric.flow.miniappwidget.f r37 = this.$input;
        Integer r38 = this.$insertPosition;
        this.L$0 = r33;
        this.label = 1;
        r14 = com.obric.flow.cardlistpage.domain.usecase.a.a(r120.e, r37, r33, r38, this);
        if (r14 != r5) goto L19;
        return r5;
    L19:
        r11 = r33;
        goto L20
    L72:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((FeedListComponent$addMiniAppWidget$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
