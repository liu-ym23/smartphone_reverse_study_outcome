package com.bytedance.ai.model;

import com.bytedance.ai.model.objects.PageInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.AppletRuntime$createPage$1", f = "AppletRuntime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nAppletRuntime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppletRuntime.kt\ncom/bytedance/ai/model/AppletRuntime$createPage$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1001:1\n1#2:1002\n*E\n"})
final class AppletRuntime$createPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w0.f f2211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PageInfo f2212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2213c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Function3 e;

    public AppletRuntime$createPage$1(w0.f r5, PageInfo r10, String r11, String r12, Function3 r13, Continuation r14) {
        this.f2211a = r5;
        this.f2212b = r10;
        this.f2213c = r11;
        this.d = r12;
        this.e = r13;
        super(2, r14);
    }

    public static final Unit a(Function3 r5, w0.f r10, Integer r11) {
        if (r11 == null) goto L5;
        String r12 = r11.toString();
        if (r12 == null) goto L5;
    L6:
        if (r5 == null) goto L9;
        r5.invoke(r10, Boolean.TRUE, r12);
    L9:
        return Unit.INSTANCE;
    L5:
        r12 = "";
        goto L6
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r10, Continuation r11) {
        return new AppletRuntime$createPage$1(this.f2211a, this.f2212b, this.f2213c, this.d, this.e, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((AppletRuntime$createPage$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r23) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r23);
        w0.f r5 = this.f2211a;
        PageInfo r11 = new PageInfo(this.f2212b.getPageName(), this.f2213c, this.f2212b.getContext(), this.d, this.f2212b.getPageType(), this.f2212b.getBotId(), this.f2212b.getPageId(), this.f2212b.getPageSettings(), null, this.f2212b.getPos(), this.f2212b.getAlignLeft(), this.f2212b.getReplyFor(), null, null, null, null, 61696, null);
        PageInfo r10 = this.f2212b;
        r11.setTraceInfo(r10.getTraceInfo());
        r11.setPackageName(r10.getPackageName());
        Function3 r12 = this.e;
        w0.f r13 = this.f2211a;
        r5.b(r11, new k(0, r12, r13), new k(1, r12, r13));
        return Unit.INSTANCE;
    }

    public static final Unit a(Function3 r5, w0.f r10, String r11) {
        if (r5 == null) goto L5;
        r5.invoke(r10, Boolean.FALSE, r11);
    L5:
        return Unit.INSTANCE;
    }
}
