package com.obric.flow.cardlistpage.ui.component.feedlist;

import android.appwidget.AppWidgetProviderInfo;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.WidgetCardModel;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent$updateEditedWidget$1", f = "FeedListComponent.kt", i = {}, l = {995}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nFeedListComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$updateEditedWidget$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1384:1\n360#2,7:1385\n*S KotlinDebug\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$updateEditedWidget$1\n*L\n974#1:1385,7\n*E\n"})
final class FeedListComponent$updateEditedWidget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $appWidgetId;
    int label;
    final /* synthetic */ s this$0;

    /* JADX INFO: renamed from: com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent$updateEditedWidget$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent$updateEditedWidget$1$1", f = "FeedListComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WidgetCardModel $updatedModel;
        int label;
        final /* synthetic */ s this$0;

        public AnonymousClass1(s r5, WidgetCardModel r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r5;
            this.$updatedModel = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass1(this.this$0, this.$updatedModel, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            this.this$0.f(new n(this.$updatedModel));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public FeedListComponent$updateEditedWidget$1(s r5, int r10, Continuation<? super FeedListComponent$updateEditedWidget$1> r11) {
        this.this$0 = r5;
        this.$appWidgetId = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new FeedListComponent$updateEditedWidget$1(this.this$0, this.$appWidgetId, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r17) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
    L32:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        AppWidgetProviderInfo r11 = this.this$0.g.getAppWidgetInfo(this.$appWidgetId);
        if (r11 == null) goto L11;
        List r12 = ((v) ((com.obric.flow.cardlistpage.mvi.a) this.this$0.f11531a).b()).b();
        int r13 = this.$appWidgetId;
        Iterator r14 = r12.iterator();
        int r15 = 0;
    L14:
        if (r14.hasNext() == false) goto L21;
        BaseCardModel r16 = (BaseCardModel) r14.next();
        if ((r16 instanceof WidgetCardModel) == false) goto L20;
        if (Intrinsics.areEqual(r16.getOriginalId(), String.valueOf(r13)) == false) goto L20;
    L22:
        if (r15 == (-1)) goto L24;
        Object r18 = r12.get(r15);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.obric.flow.cardlistpage.data.WidgetCardModel");
        WidgetCardModel r19 = (WidgetCardModel) r18;
        String r20 = r19.getId();
        String r21 = r19.getOriginalId();
        int r22 = r19.getSpanX();
        int r23 = r19.getSpanY();
        String r24 = r11.label;
        if (r24 != null) goto L28;
        r24 = "";
    L28:
        WidgetCardModel r110 = new WidgetCardModel(r20, r21, r22, r23, r24, r19.getDescription(), r19.isVisible(), r19.getSortIndex(), r19.getCreateTime(), Boxing.boxLong(System.currentTimeMillis()));
        MainCoroutineDispatcher r25 = Dispatchers.getMain();
        AnonymousClass1 r26 = new AnonymousClass1(this.this$0, r110, null);
        this.label = 1;
        if (BuildersKt.withContext(r25, r26, this) != r5) goto L32;
        return r5;
    L24:
        return Unit.INSTANCE;
    L20:
        r15 = r15 + 1;
        goto L14
    L21:
        r15 = -1;
        goto L22
    L11:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((FeedListComponent$updateEditedWidget$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
