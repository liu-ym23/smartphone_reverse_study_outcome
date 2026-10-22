package com.obric.flow.cardlistpage.ui;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.CardFeedUtils$refreshData$1", f = "CardFeedUtils.kt", i = {}, l = {89, 92, 99}, m = "invokeSuspend", n = {}, s = {})
final class CardFeedUtils$refreshData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppWidgetHost $appWidgetHost;
    final /* synthetic */ AppWidgetManager $appWidgetManager;
    final /* synthetic */ String $desc;
    final /* synthetic */ int $headerSpacerHeightPx;
    final /* synthetic */ Function1<List<? extends BaseCardModel>, Unit> $onCardsUpdated;
    final /* synthetic */ RecyclerView $recyclerView;
    int label;

    /* JADX INFO: renamed from: com.obric.flow.cardlistpage.ui.CardFeedUtils$refreshData$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.flow.cardlistpage.ui.CardFeedUtils$refreshData$1$1", f = "CardFeedUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<BaseCardModel> $newCards;
        final /* synthetic */ Function1<List<? extends BaseCardModel>, Unit> $onCardsUpdated;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super List<? extends BaseCardModel>, Unit> r5, List<? extends BaseCardModel> r10, Continuation<? super AnonymousClass1> r11) {
            this.$onCardsUpdated = r5;
            this.$newCards = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass1(this.$onCardsUpdated, this.$newCards, r10);
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
            this.$onCardsUpdated.invoke(this.$newCards);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardFeedUtils$refreshData$1(String r5, RecyclerView r10, AppWidgetManager r11, AppWidgetHost r12, int r13, Function1<? super List<? extends BaseCardModel>, Unit> r14, Continuation<? super CardFeedUtils$refreshData$1> r15) {
        this.$desc = r5;
        this.$recyclerView = r10;
        this.$appWidgetManager = r11;
        this.$appWidgetHost = r12;
        this.$headerSpacerHeightPx = r13;
        this.$onCardsUpdated = r14;
        super(2, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CardFeedUtils$refreshData$1(this.$desc, this.$recyclerView, this.$appWidgetManager, this.$appWidgetHost, this.$headerSpacerHeightPx, this.$onCardsUpdated, r11);
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
        if (r10 == 0) goto L12;
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L10;
        if (r10 != 3) goto L9;
        ResultKt.throwOnFailure(r12);
    L25:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r12);
    L21:
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        Function1<List<? extends BaseCardModel>, Unit> r13 = this.$onCardsUpdated;
        AnonymousClass1 r14 = new AnonymousClass1(r13, (List) r12, null);
        this.label = 3;
        if (BuildersKt.withContext(r11, r14, this) != r5) goto L25;
        return r5;
    L11:
        ResultKt.throwOnFailure(r12);
    L18:
        i r15 = i.f11777a;
        String r16 = this.$desc;
        RecyclerView r17 = this.$recyclerView;
        AppWidgetManager r18 = this.$appWidgetManager;
        AppWidgetHost r19 = this.$appWidgetHost;
        int r20 = this.$headerSpacerHeightPx;
        this.label = 2;
        r12 = i.a(r15, r16, r17, r18, r19, r20, this);
        if (r12 != r5) goto L21;
        return r5;
    L12:
        ResultKt.throwOnFailure(r12);
        if (i.f11778b == false) goto L15;
        i.f11778b = false;
        goto L18
    L15:
        this.label = 1;
        if (DelayKt.delay(300, this) != r5) goto L18;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((CardFeedUtils$refreshData$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
