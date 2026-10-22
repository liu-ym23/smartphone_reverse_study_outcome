package com.bytedance.ai.widget.cache;

import com.lynx.tasm.TemplateBundle;
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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/lynx/tasm/TemplateBundle;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader$loadTemplateBundle$3", f = "WidgetResourceLoader.kt", i = {}, l = {270}, m = "invokeSuspend", n = {}, s = {})
final class WidgetResourceLoader$loadTemplateBundle$3 extends SuspendLambda implements Function1<Continuation<? super TemplateBundle>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f2961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2962c;
    public final /* synthetic */ String d;

    public WidgetResourceLoader$loadTemplateBundle$3(e r5, String r10, String r11, Continuation r12) {
        this.f2961b = r5;
        this.f2962c = r10;
        this.d = r11;
        super(1, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation r5) {
        return new WidgetResourceLoader$loadTemplateBundle$3(this.f2961b, this.f2962c, this.d, r5);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super TemplateBundle> r5) {
        return ((WidgetResourceLoader$loadTemplateBundle$3) create(r5)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2960a;
        boolean r12 = true;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        TemplateBundle r13 = (TemplateBundle) r10;
        if (r13 != null) goto L14;
    L26:
        String r14 = f4.a.b(new StringBuilder("Loader("), this.f2961b.f2989b, ") loadTemplateBundle: ERROR, widget is NULL");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L30;
        r15.e("WidgetResourceLoader", r14);
    L30:
        return this.f2961b.d;
    L14:
        if (r13.d() == false) goto L26;
        this.f2961b.d = r13;
        boolean r16 = a.f2980a;
        String r17 = this.f2962c;
        String r18 = this.d;
        Intrinsics.checkNotNullParameter(r17, "packageName");
        Intrinsics.checkNotNullParameter(r18, "widgetId");
        Intrinsics.checkNotNullParameter(r13, "templateBundle");
        if (a.f2980a == true) goto L19;
    L24:
        r12 = false;
    L25:
        Boxing.boxBoolean(r12);
        goto L30
    L19:
        if (a.f2981b.size() >= 3) goto L24;
        if (a.f2982c.put(a.a(r17, r18), r13) != null) goto L24;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        e r19 = this.f2961b;
        this.f2960a = 1;
        r10 = e.g(r19, this);
        if (r10 != r5) goto L11;
        return r5;
    }
}
