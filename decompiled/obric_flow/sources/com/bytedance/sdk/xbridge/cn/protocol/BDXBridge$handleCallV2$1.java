package com.bytedance.sdk.xbridge.cn.protocol;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "INPUT", "OUTPUT", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$handleCallV2$1", f = "BDXBridge.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BDXBridge$handleCallV2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f7429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ bj.a f7430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f7431c;

    public BDXBridge$handleCallV2$1(c r5, bj.a r10, e r11, Continuation r12) {
        this.f7429a = r5;
        this.f7430b = r10;
        this.f7431c = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new BDXBridge$handleCallV2$1(this.f7429a, this.f7430b, this.f7431c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((BDXBridge$handleCallV2$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        this.f7429a.p(this.f7430b, this.f7431c);
        return Unit.INSTANCE;
    }
}
