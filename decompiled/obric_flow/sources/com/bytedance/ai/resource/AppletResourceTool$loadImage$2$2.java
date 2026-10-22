package com.bytedance.ai.resource;

import android.util.LruCache;
import java.util.concurrent.atomic.AtomicReference;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AppletResourceTool$loadImage$2$2", f = "AppletResourceTool.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AppletResourceTool$loadImage$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2552c;

    public AppletResourceTool$loadImage$2$2(String r5, String r10, AtomicReference r11, Continuation r12) {
        this.f2550a = r5;
        this.f2551b = r10;
        this.f2552c = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AppletResourceTool$loadImage$2$2(this.f2550a, this.f2551b, this.f2552c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((AppletResourceTool$loadImage$2$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        LruCache r10 = e0.f2711a;
        String r11 = this.f2550a;
        String r12 = this.f2551b;
        AtomicReference r13 = this.f2552c;
        e0.k(r11, r12, new com.bytedance.ai.process.resource.b(r13, 2), new com.bytedance.ai.process.resource.b(r13, 3), false);
        return Unit.INSTANCE;
    }
}
