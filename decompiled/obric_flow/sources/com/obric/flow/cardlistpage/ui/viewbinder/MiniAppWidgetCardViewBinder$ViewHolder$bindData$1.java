package com.obric.flow.cardlistpage.ui.viewbinder;

import android.view.View;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
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
import kotlinx.coroutines.CoroutineScope;
import obric.flow.miniappwidget.l;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.viewbinder.MiniAppWidgetCardViewBinder$ViewHolder$bindData$1", f = "MiniAppWidgetCardViewBinder.kt", i = {}, l = {119, 121}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppWidgetCardViewBinder$ViewHolder$bindData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ obric.flow.miniappwidget.a $existingHostedWidget;
    final /* synthetic */ MiniAppWidgetCardModel $item;
    int label;
    final /* synthetic */ f this$0;
    final /* synthetic */ MiniAppWidgetCardViewBinder$ViewHolder this$1;

    public MiniAppWidgetCardViewBinder$ViewHolder$bindData$1(obric.flow.miniappwidget.a r5, f r10, MiniAppWidgetCardModel r11, MiniAppWidgetCardViewBinder$ViewHolder r12, Continuation<? super MiniAppWidgetCardViewBinder$ViewHolder$bindData$1> r13) {
        this.$existingHostedWidget = r5;
        this.this$0 = r10;
        this.$item = r11;
        this.this$1 = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MiniAppWidgetCardViewBinder$ViewHolder$bindData$1(this.$existingHostedWidget, this.this$0, this.$item, this.this$1, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L14;
        if (r10 == 1) goto L12;
        if (r10 != 2) goto L11;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L8
    L26:
        obric.flow.miniappwidget.a r14 = (obric.flow.miniappwidget.a) r13;     // Catch: Exception -> L8
    L28:
        if (Intrinsics.areEqual(this.this$1.e, this.$item.getInstanceId()) == false) goto L30;
        if (r14 == null) goto L33;
        View r15 = r14.f.getView();     // Catch: Exception -> L8
    L34:
        if (r15 != null) goto L41;
        MiniAppWidgetCardViewBinder$ViewHolder.b(this.this$1);     // Catch: Exception -> L8
        String r16 = "bind mini app widget failed: view is null instanceId=" + this.$item.getInstanceId();     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter("MiniAppWidgetCardViewBinder", "tag");     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter(r16, "msg");     // Catch: Exception -> L8
        org.koin.core.a r11 = su.a.f22013b;     // Catch: Exception -> L8
        if (r11 == null) goto L40;
        ((ju.b) r11.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppWidgetCardViewBinder", r16);     // Catch: Exception -> L8
        return Unit.INSTANCE;
    L40:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Exception -> L8
    L41:
        MiniAppWidgetCardViewBinder$ViewHolder.a(this.this$1, this.$item, r15);     // Catch: Exception -> L8
        MiniAppWidgetCardViewBinder$ViewHolder r12 = this.this$1;     // Catch: Exception -> L8
        r12.d();     // Catch: Exception -> L8
        MiniAppWidgetCardViewBinder$ViewHolder.c(r15);     // Catch: Exception -> L8
        d r17 = new d(r12, r15);     // Catch: Exception -> L8
        r12.f = r15;     // Catch: Exception -> L8
        r12.g = r17;     // Catch: Exception -> L8
        r15.getViewTreeObserver().addOnGlobalLayoutListener(r17);     // Catch: Exception -> L8
        MiniAppWidgetCardViewBinder$ViewHolder r18 = this.this$1;     // Catch: Exception -> L8
        r15.setOnClickListener(new com.google.android.material.snackbar.a(1, r18.f11863h, this.$item));     // Catch: Exception -> L8
    L50:
        return Unit.INSTANCE;
    L33:
        r15 = null;
        goto L34
    L30:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L8
    L22:
        r14 = (obric.flow.miniappwidget.a) r13;     // Catch: Exception -> L8
        goto L28
    L14:
        ResultKt.throwOnFailure(r13);
        r14 = this.$existingHostedWidget;     // Catch: Exception -> L8
        if (r14 != null) goto L28;
        l r19 = this.this$0.d;     // Catch: Exception -> L8
        String r20 = this.$item.getInstanceId();     // Catch: Exception -> L8
        r19.getClass();     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter(r20, "instanceId");     // Catch: Exception -> L8
        if (r19.f20494h.remove(r20) == false) goto L23;
        f r110 = this.this$0;     // Catch: Exception -> L8
        l r21 = r110.d;     // Catch: Exception -> L8
        obric.flow.miniappwidget.c r111 = wn.f.e(this.$item, r110.f11874c);     // Catch: Exception -> L8
        this.label = 1;     // Catch: Exception -> L8
        r13 = r21.c(r111, false, this);     // Catch: Exception -> L8
        if (r13 != r5) goto L22;
        return r5;
    L23:
        f r112 = this.this$0;     // Catch: Exception -> L8
        l r22 = r112.d;     // Catch: Exception -> L8
        obric.flow.miniappwidget.c r113 = wn.f.e(this.$item, r112.f11874c);     // Catch: Exception -> L8
        this.label = 2;     // Catch: Exception -> L8
        r13 = r22.c(r113, true, this);     // Catch: Exception -> L8
        if (r13 != r5) goto L26;
        return r5;
    L8:
        e = move-exception;
        if (Intrinsics.areEqual(this.this$1.e, this.$item.getInstanceId()) == false) goto L46;
        MiniAppWidgetCardViewBinder$ViewHolder.b(this.this$1);
    L46:
        String r114 = "bind mini app widget failed instanceId=" + this.$item.getInstanceId();
        Intrinsics.checkNotNullParameter("MiniAppWidgetCardViewBinder", "tag");
        Intrinsics.checkNotNullParameter(r114, "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r23 = su.a.f22013b;
        if (r23 == null) goto L52;
        ((ju.b) r23.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppWidgetCardViewBinder", r114, e);
        goto L50
    L52:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((MiniAppWidgetCardViewBinder$ViewHolder$bindData$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
