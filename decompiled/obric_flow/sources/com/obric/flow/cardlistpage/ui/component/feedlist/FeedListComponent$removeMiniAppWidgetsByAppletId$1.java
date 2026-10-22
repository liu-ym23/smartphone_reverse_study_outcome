package com.obric.flow.cardlistpage.ui.component.feedlist;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.FakeWidgetCardModel;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent$removeMiniAppWidgetsByAppletId$1", f = "FeedListComponent.kt", i = {0}, l = {916}, m = "invokeSuspend", n = {"updatedCards"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nFeedListComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$removeMiniAppWidgetsByAppletId$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1384:1\n827#2:1385\n855#2,2:1386\n808#2,11:1388\n774#2:1399\n865#2,2:1400\n1863#2,2:1402\n*S KotlinDebug\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$removeMiniAppWidgetsByAppletId$1\n*L\n897#1:1385\n897#1:1386,2\n900#1:1388,11\n901#1:1399\n901#1:1400,2\n914#1:1402,2\n*E\n"})
final class FeedListComponent$removeMiniAppWidgetsByAppletId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ s this$0;

    public FeedListComponent$removeMiniAppWidgetsByAppletId$1(s r5, String r10, Continuation<? super FeedListComponent$removeMiniAppWidgetsByAppletId$1> r11) {
        this.this$0 = r5;
        this.$appletId = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new FeedListComponent$removeMiniAppWidgetsByAppletId$1(this.this$0, this.$appletId, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.util.ArrayList] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0154 -> B:43:0x0155). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r17) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        Ref.ObjectRef r11 = (Ref.ObjectRef) this.L$3;
        Iterator r12 = (Iterator) this.L$2;
        s r13 = (s) this.L$1;
        Ref.ObjectRef r14 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r17);
        T r15 = r17;
    L43:
        r11.element = r15;
        r11 = r14;
    L38:
        if (r12.hasNext() == false) goto L44;
        MiniAppWidgetCardModel r16 = (MiniAppWidgetCardModel) r12.next();
        s.k(r13, r16);
        List r18 = (List) r11.element;
        String r19 = r16.getId();
        this.L$0 = r11;
        this.L$1 = r13;
        this.L$2 = r12;
        this.L$3 = r11;
        this.label = 1;
        Object r20 = r13.f11601i.c(r18, r19, this);
        if (r20 != r5) goto L42;
        return r5;
    L42:
        r14 = r11;
        r15 = r20;
        goto L43
    L44:
        this.this$0.d(new z((List) r11.element));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        List r21 = ((v) ((com.obric.flow.cardlistpage.mvi.a) this.this$0.f11531a).b()).b();
        ?? r22 = new ArrayList();
        Iterator r23 = r21.iterator();
    L10:
        if (r23.hasNext() == false) goto L14;
        Object r24 = r23.next();
        if ((((BaseCardModel) r24) instanceof FakeWidgetCardModel) == true) goto L10;
        r22.add(r24);
        goto L10
    L14:
        ArrayList r25 = new ArrayList();
        Iterator r26 = r22.iterator();
    L16:
        if (r26.hasNext() == false) goto L20;
        Object r27 = r26.next();
        if ((r27 instanceof MiniAppWidgetCardModel) == false) goto L16;
        r25.add(r27);
        goto L16
    L20:
        String r28 = this.$appletId;
        ArrayList r29 = new ArrayList();
        Iterator r30 = r25.iterator();
    L22:
        if (r30.hasNext() == false) goto L27;
        Object r31 = r30.next();
        if (Intrinsics.areEqual(((MiniAppWidgetCardModel) r31).getAppletId(), r28) == false) goto L22;
        r29.add(r31);
        goto L22
    L27:
        if (r29.isEmpty() == false) goto L34;
        String r32 = androidx.constraintlayout.motion.widget.a.p("miniAppWidget removeByApplet skipped hostId=", this.this$0.f11600h.f20491a, " appletId=", this.$appletId);
        Intrinsics.checkNotNullParameter("FeedListComponent", "tag");
        Intrinsics.checkNotNullParameter(r32, "msg");
        org.koin.core.a r33 = su.a.f22013b;
        if (r33 == null) goto L33;
        ((ju.b) r33.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("FeedListComponent", r32);
        return Unit.INSTANCE;
    L33:
        throw new IllegalStateException("KoinApplication has not been started");
    L34:
        String r34 = this.this$0.f11600h.f20491a;
        String r110 = this.$appletId;
        int r111 = r29.size();
        StringBuilder r35 = androidx.constraintlayout.motion.widget.a.y("miniAppWidget removeByApplet hostId=", r34, " appletId=", r110, " count=");
        r35.append(r111);
        String r36 = r35.toString();
        Intrinsics.checkNotNullParameter("FeedListComponent", "tag");
        Intrinsics.checkNotNullParameter(r36, "msg");
        org.koin.core.a r37 = su.a.f22013b;
        if (r37 == null) goto L47;
        ((ju.b) r37.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("FeedListComponent", r36);
        r11 = new Ref.ObjectRef();
        r11.element = r22;
        s r38 = this.this$0;
        r12 = r29.iterator();
        r13 = r38;
        goto L38
    L47:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((FeedListComponent$removeMiniAppWidgetsByAppletId$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
