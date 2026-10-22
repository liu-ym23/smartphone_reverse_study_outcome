package com.bytedance.ai.lynx;

import com.bytedance.ai.resource.e0;
import com.lynx.tasm.TemplateBundle;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/lynx/tasm/TemplateBundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.lynx.AppletLynxViewApi$getTemplateBundle$2", f = "AppletLynxViewApi.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
final class AppletLynxViewApi$getTemplateBundle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TemplateBundle>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2170c;

    public AppletLynxViewApi$getTemplateBundle$2(String r5, String r10, Continuation r11) {
        this.f2169b = r5;
        this.f2170c = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AppletLynxViewApi$getTemplateBundle$2(this.f2169b, this.f2170c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super TemplateBundle> r10) {
        String r11 = this.f2169b;
        String r12 = this.f2170c;
        return new AppletLynxViewApi$getTemplateBundle$2(r11, r12, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2168a;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        ResultKt.throwOnFailure(r10);
        return r10;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        String r12 = this.f2169b;
        String r13 = this.f2170c;
        this.f2168a = 1;
        SafeContinuation r14 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        AtomicBoolean r15 = new AtomicBoolean(false);
        e0.k(r12, r13, new h(r15, r14, 0), new h(r15, r14, 1), false);
        Object r16 = r14.getOrThrow();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        DebugProbesKt.probeCoroutineSuspended(this);
    L12:
        if (r16 != r5) goto L14;
        return r5;
    L14:
        return r16;
    }
}
