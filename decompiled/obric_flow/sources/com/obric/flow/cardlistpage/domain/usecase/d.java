package com.obric.flow.cardlistpage.domain.usecase;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import obric.flow.miniappwidget.MiniAppWidgetRuntimeValidity;
import obric.flow.miniappwidget.l;
import obric.flow.miniappwidget.n;
import obric.flow.miniappwidget.o;
import obric.flow.miniappwidget.p;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f11520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f11521b;

    public d(l r5) {
        Intrinsics.checkNotNullParameter(r5, "runtimeValidator");
        this.f11520a = r5;
    }

    @Override // com.obric.flow.cardlistpage.domain.usecase.g
    public final boolean a(BaseCardModel r5) {
        Intrinsics.checkNotNullParameter(r5, "card");
        return r5 instanceof MiniAppWidgetCardModel;
    }

    @Override // com.obric.flow.cardlistpage.domain.usecase.g
    public final Object b(BaseCardModel r10, Continuation r11) {
        if ((r11 instanceof MiniAppWidgetProviderValidator$shouldRemove$1) == false) goto L7;
        MiniAppWidgetProviderValidator$shouldRemove$1 r5 = (MiniAppWidgetProviderValidator$shouldRemove$1) r11;
        int r12 = r5.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.label;
        boolean r16 = false;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L38:
        if (((o) r13).f20508a != MiniAppWidgetRuntimeValidity.INVALID) goto L41;
        r16 = true;
    L41:
        return Boxing.boxBoolean(r16);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        MiniAppWidgetCardModel r17 = (MiniAppWidgetCardModel) r5.L$1;
        d r18 = (d) r5.L$0;
        ResultKt.throwOnFailure(r13);
        MiniAppWidgetCardModel r19 = r17;
        d this = r18;
    L27:
        if (((Boolean) r13).booleanValue() == false) goto L29;
        l r20 = this.f11520a;
        String r110 = r19.getAppletId();
        String r21 = r19.getWidgetId();
        String r111 = r19.getDefinitionId();
        if (StringsKt.isBlank(r111) == false) goto L34;
        r111 = null;
    L34:
        n r22 = new n(r110, r21, r111);
        r5.L$0 = null;
        r5.L$1 = null;
        r5.label = 2;
        r13 = r20.b(r22, r5);
        if (r13 != r14) goto L38;
        return r14;
    L29:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r13);
        if ((r10 instanceof MiniAppWidgetCardModel) == false) goto L19;
        r19 = (MiniAppWidgetCardModel) r10;
    L20:
        if (r19 == null) goto L22;
        r5.L$0 = this;
        r5.L$1 = r19;
        r5.label = 1;
        r13 = d(r5);
        if (r13 != r14) goto L27;
        return r14;
    L22:
        return Boxing.boxBoolean(false);
    L19:
        r19 = null;
    L7:
        r5 = new MiniAppWidgetProviderValidator$shouldRemove$1(this, r11);
        goto L8
    }

    @Override // com.obric.flow.cardlistpage.domain.usecase.g
    public final Unit c(BaseCardModel r5) {
        if ((r5 instanceof MiniAppWidgetCardModel) == false) goto L5;
        MiniAppWidgetCardModel r10 = (MiniAppWidgetCardModel) r5;
    L6:
        if (r10 == null) goto L8;
        String r11 = r10.getInstanceId();
        String r12 = r10.getAppletId();
        String r13 = r10.getWidgetId();
        p r14 = new p(r11, r12, r13);
        l r15 = this.f11520a;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r14, "request");
        r15.d(r11, r12, r13);
        return Unit.INSTANCE;
    L8:
        return Unit.INSTANCE;
    L5:
        r10 = null;
        goto L6
    }

    public final Object d(ContinuationImpl r5) {
        if ((r5 instanceof MiniAppWidgetProviderValidator$isCatalogReady$1) == false) goto L7;
        MiniAppWidgetProviderValidator$isCatalogReady$1 r10 = (MiniAppWidgetProviderValidator$isCatalogReady$1) r5;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        d this = (d) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L21:
        this.f11521b = Boxing.boxBoolean(((Boolean) r12).booleanValue());
        return r12;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        Boolean r15 = this.f11521b;
        if (r15 != null) goto L17;
        r10.L$0 = this;
        r10.label = 1;
        r12 = this.f11520a.g(r10);
        if (r12 != r13) goto L21;
        return r13;
    L17:
        return Boxing.boxBoolean(r15.booleanValue());
    L7:
        r10 = new MiniAppWidgetProviderValidator$isCatalogReady$1(this, r5);
        goto L8
    }
}
