package com.obric.feature.miniapp.widget;

import android.content.Context;
import com.bytedance.ai.ex.widget.model.MiniAppWidgetDataSnapshot;
import com.bytedance.ai.ex.widget.model.MiniAppWidgetInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetDataSnapshot;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper$createWidget$snapshot$1$1", f = "MiniAppWidgetManagerWrapper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MiniAppWidgetManagerWrapper$createWidget$snapshot$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MiniAppWidgetDataSnapshot>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f11395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MiniAppWidgetInfo f11396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11397c;

    public MiniAppWidgetManagerWrapper$createWidget$snapshot$1$1(Context r5, MiniAppWidgetInfo r10, int r11, Continuation r12) {
        this.f11395a = r5;
        this.f11396b = r10;
        this.f11397c = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new MiniAppWidgetManagerWrapper$createWidget$snapshot$1$1(this.f11395a, this.f11396b, this.f11397c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super MiniAppWidgetDataSnapshot> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        return MiniAppWidgetManagerWrapper.INSTANCE.queryWidgetData(this.f11395a, this.f11396b.getAppletId(), this.f11396b.getWidgetId(), this.f11397c);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super MiniAppWidgetDataSnapshot> r10) {
        return ((MiniAppWidgetManagerWrapper$createWidget$snapshot$1$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
