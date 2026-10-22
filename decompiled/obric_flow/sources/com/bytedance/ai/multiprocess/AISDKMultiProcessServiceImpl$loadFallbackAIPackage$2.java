package com.bytedance.ai.multiprocess;

import com.bytedance.ai.model.objects.AIPackage;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/model/objects/AIPackage;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.multiprocess.AISDKMultiProcessServiceImpl$loadFallbackAIPackage$2", f = "AISDKMultiProcessServiceImpl.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
final class AISDKMultiProcessServiceImpl$loadFallbackAIPackage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AIPackage>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f2396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2398c;
    public final /* synthetic */ AIPackage.AIPackageType d;

    public AISDKMultiProcessServiceImpl$loadFallbackAIPackage$2(a r5, String r10, String r11, AIPackage.AIPackageType r12, Continuation r13) {
        this.f2396a = r5;
        this.f2397b = r10;
        this.f2398c = r11;
        this.d = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r10, Continuation r11) {
        return new AISDKMultiProcessServiceImpl$loadFallbackAIPackage$2(this.f2396a, this.f2397b, this.f2398c, this.d, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super AIPackage> r10) {
        return ((AISDKMultiProcessServiceImpl$loadFallbackAIPackage$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        u0.c r10 = this.f2396a.f2400a;
        return null;
    }
}
