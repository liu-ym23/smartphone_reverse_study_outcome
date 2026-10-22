package com.obric.flow.cardlistpage.ui;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.HeaderWidgetCardModel;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.CardFeedUtils$checkWidgetProvidersChanged$1", f = "CardFeedUtils.kt", i = {0, 0}, l = {129, 135}, m = "invokeSuspend", n = {"installed", "removed"}, s = {"L$0", "L$1"})
@SourceDebugExtension({"SMAP\nCardFeedUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CardFeedUtils.kt\ncom/obric/flow/cardlistpage/ui/CardFeedUtils$checkWidgetProvidersChanged$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,219:1\n774#2:220\n865#2,2:221\n1863#2:223\n1755#2,3:224\n1864#2:227\n*S KotlinDebug\n*F\n+ 1 CardFeedUtils.kt\ncom/obric/flow/cardlistpage/ui/CardFeedUtils$checkWidgetProvidersChanged$1\n*L\n121#1:220\n121#1:221,2\n121#1:223\n125#1:224,3\n121#1:227\n*E\n"})
final class CardFeedUtils$checkWidgetProvidersChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppWidgetHost $appWidgetHost;
    final /* synthetic */ AppWidgetManager $appWidgetManager;
    final /* synthetic */ List<BaseCardModel> $items;
    final /* synthetic */ List<BaseCardModel> $itemsSnapshot;
    final /* synthetic */ Function1<List<? extends BaseCardModel>, Unit> $onCardsUpdated;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: renamed from: com.obric.flow.cardlistpage.ui.CardFeedUtils$checkWidgetProvidersChanged$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.flow.cardlistpage.ui.CardFeedUtils$checkWidgetProvidersChanged$1$3", f = "CardFeedUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<BaseCardModel> $items;
        final /* synthetic */ Function1<List<? extends BaseCardModel>, Unit> $onCardsUpdated;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function1<? super List<? extends BaseCardModel>, Unit> r5, List<BaseCardModel> r10, Continuation<? super AnonymousClass3> r11) {
            this.$onCardsUpdated = r5;
            this.$items = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass3(this.$onCardsUpdated, this.$items, r10);
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
            this.$onCardsUpdated.invoke(this.$items);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass3) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardFeedUtils$checkWidgetProvidersChanged$1(AppWidgetManager r5, List<? extends BaseCardModel> r10, List<BaseCardModel> r11, AppWidgetHost r12, Function1<? super List<? extends BaseCardModel>, Unit> r13, Continuation<? super CardFeedUtils$checkWidgetProvidersChanged$1> r14) {
        this.$appWidgetManager = r5;
        this.$itemsSnapshot = r10;
        this.$items = r11;
        this.$appWidgetHost = r12;
        this.$onCardsUpdated = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CardFeedUtils$checkWidgetProvidersChanged$1(this.$appWidgetManager, this.$itemsSnapshot, this.$items, this.$appWidgetHost, this.$onCardsUpdated, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L9;
        if (r10 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L43:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Iterator r11 = (Iterator) this.L$4;
        AppWidgetHost r12 = (AppWidgetHost) this.L$3;
        AppWidgetManager r13 = (AppWidgetManager) this.L$2;
        List r14 = (List) this.L$1;
        List<AppWidgetProviderInfo> r16 = (List) this.L$0;
        ResultKt.throwOnFailure(r15);
    L18:
        if (r11.hasNext() == false) goto L38;
        BaseCardModel r17 = (BaseCardModel) r11.next();
        Integer r18 = StringsKt.toIntOrNull(r17.getOriginalId());
        if (r18 == null) goto L18;
        int r19 = r18.intValue();
        AppWidgetProviderInfo r20 = r13.getAppWidgetInfo(r19);
        if (r20 == null) goto L34;
        Intrinsics.checkNotNull(r16);
        if (r16 != null) goto L26;
    L28:
        Iterator<T> r110 = r16.iterator();
    L30:
        if (r110.hasNext() == false) goto L34;
        if (Intrinsics.areEqual(((AppWidgetProviderInfo) r110.next()).provider, r20.provider) == false) goto L30;
    L26:
        if (r16.isEmpty() == false) goto L28;
    L34:
        r14.add(r17);
        r12.deleteAppWidgetId(r19);
        com.obric.flow.cardlistpage.c r21 = com.obric.flow.cardlistpage.c.f11462b.f();
        String r111 = r17.getId();
        this.L$0 = r16;
        this.L$1 = r14;
        this.L$2 = r13;
        this.L$3 = r12;
        this.L$4 = r11;
        this.label = 1;
        if (r21.b(r111, this) != r5) goto L18;
        return r5;
    L38:
        if (r14.isEmpty() == true) goto L43;
        this.$items.removeAll(r14);
        MainCoroutineDispatcher r112 = Dispatchers.getMain();
        AnonymousClass3 r22 = new AnonymousClass3(this.$onCardsUpdated, this.$items, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.label = 2;
        if (BuildersKt.withContext(r112, r22, this) != r5) goto L43;
        return r5;
    L10:
        ResultKt.throwOnFailure(r15);
        List<AppWidgetProviderInfo> r113 = this.$appWidgetManager.getInstalledProviders();
        ArrayList r23 = new ArrayList();
        List<BaseCardModel> r24 = this.$itemsSnapshot;
        ArrayList r25 = new ArrayList();
        Iterator<T> r26 = r24.iterator();
    L12:
        if (r26.hasNext() == false) goto L16;
        Object r27 = r26.next();
        if ((((BaseCardModel) r27) instanceof HeaderWidgetCardModel) == true) goto L12;
        r25.add(r27);
        goto L12
    L16:
        AppWidgetManager r28 = this.$appWidgetManager;
        AppWidgetHost r29 = this.$appWidgetHost;
        r16 = r113;
        r14 = r23;
        r11 = r25.iterator();
        r13 = r28;
        r12 = r29;
        goto L18
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((CardFeedUtils$checkWidgetProvidersChanged$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
