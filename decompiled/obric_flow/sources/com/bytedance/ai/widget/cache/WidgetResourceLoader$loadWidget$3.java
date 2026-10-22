package com.bytedance.ai.widget.cache;

import com.bytedance.ai.model.objects.Widget;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/model/objects/Widget;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader$loadWidget$3", f = "WidgetResourceLoader.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
final class WidgetResourceLoader$loadWidget$3 extends SuspendLambda implements Function1<Continuation<? super Widget>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f2971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f2973c;

    public WidgetResourceLoader$loadWidget$3(e r5, Continuation r10) {
        this.f2973c = r5;
        super(1, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation r5) {
        return new WidgetResourceLoader$loadWidget$3(this.f2973c, r5);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Widget> r5) {
        e r10 = this.f2973c;
        return new WidgetResourceLoader$loadWidget$3(r10, r5).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2972b;
        boolean r12 = true;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        e r13 = this.f2971a;
        ResultKt.throwOnFailure(r5);
    L12:
        r13.f2990c = (Widget) r5;
        Widget r14 = this.f2973c.f2990c;
        if (r14 == null) goto L24;
        boolean r15 = a.f2980a;
        Intrinsics.checkNotNullParameter(r14, "widget");
        if (a.f2980a == false) goto L19;
        ConcurrentHashMap r16 = a.f2981b;
        if (r16.size() >= 3) goto L19;
        r14.g();
        Widget r17 = (Widget) r16.put(a.a(r14.f2259b, r14.F), r14);
        if (r17 == null) goto L23;
        r17.h();
    L23:
        Boxing.boxBoolean(r12);
    L28:
        return this.f2973c.f2990c;
    L19:
        r12 = false;
        goto L23
    L24:
        e r18 = this.f2973c;
        String r19 = f4.a.b(new StringBuilder("Loader("), r18.f2989b, ") loadWidget: ERROR, widget is NULL");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L28;
        r20.e("WidgetResourceLoader", r19);
        goto L28
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        e r21 = this.f2973c;
        this.f2971a = r21;
        this.f2972b = 1;
        Object r22 = e.b(r21, this);
        if (r22 != r10) goto L11;
        return r10;
    L11:
        r13 = r21;
        r5 = r22;
        goto L12
    }
}
