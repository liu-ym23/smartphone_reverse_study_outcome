package com.bytedance.ai.resource;

import com.bytedance.ai.resource.core.AIPackageConfig;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AppletResourceTool$ensureAppletResourceLoaderInitialized$1$dir$1", f = "AppletResourceTool.kt", i = {}, l = {1052}, m = "invokeSuspend", n = {}, s = {})
final class AppletResourceTool$ensureAppletResourceLoaderInitialized$1$dir$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2546a;

    public AppletResourceTool$ensureAppletResourceLoaderInitialized$1$dir$1(Continuation r5) {
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AppletResourceTool$ensureAppletResourceLoaderInitialized$1$dir$1(r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super String> r10) {
        return new AppletResourceTool$ensureAppletResourceLoaderInitialized$1$dir$1(r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2546a;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        ResultKt.throwOnFailure(r5);
        return r5;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        String r12 = AIPackageConfig.f2571a;
        this.f2546a = 1;
        Object r13 = ((kotlinx.coroutines.s) AIPackageConfig.f2572b).d(this);
        if (r13 != r10) goto L12;
        return r10;
    L12:
        return r13;
    }
}
