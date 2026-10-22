package com.bytedance.ai.widget;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.WidgetManager$widgetUpdateListener$1$onCompleteUpdate$1", f = "WidgetManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WidgetManager$widgetUpdateListener$1$onCompleteUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f2928c;

    public WidgetManager$widgetUpdateListener$1$onCompleteUpdate$1(String r5, String r10, o r11, Continuation r12) {
        this.f2926a = r5;
        this.f2927b = r10;
        this.f2928c = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new WidgetManager$widgetUpdateListener$1$onCompleteUpdate$1(this.f2926a, this.f2927b, this.f2928c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((WidgetManager$widgetUpdateListener$1$onCompleteUpdate$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        StringBuilder r10 = new StringBuilder("onCompleteUpdate ");
        r10.append(this.f2926a);
        r10.append(' ');
        String r11 = androidx.room.jarjarred.org.antlr.runtime.a.v(r10, this.f2927b, "WidgetManager", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L5;
        r12.d("WidgetManager", r11);
    L5:
        this.f2928c.f.add(TuplesKt.to(this.f2926a, this.f2927b));
        return Unit.INSTANCE;
    }
}
