package com.bytedance.ai.resource;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/ai/resource/f0;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedance/ai/resource/f0;"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$getInstallPackageFromGeckoJob$2", f = "AIPackageManager.kt", i = {0, 0}, l = {730}, m = "invokeSuspend", n = {"manifestPath", "pageInfo"}, s = {"L$0", "L$1"})
@SourceDebugExtension({"SMAP\nAIPackageManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageManager.kt\ncom/bytedance/ai/resource/AIPackageManager$getInstallPackageFromGeckoJob$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,729:1\n318#2,11:730\n*S KotlinDebug\n*F\n+ 1 AIPackageManager.kt\ncom/bytedance/ai/resource/AIPackageManager$getInstallPackageFromGeckoJob$2\n*L\n543#1:730,11\n*E\n"})
final class AIPackageManager$getInstallPackageFromGeckoJob$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f0>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2510b;

    public AIPackageManager$getInstallPackageFromGeckoJob$2(String r5, Continuation r10) {
        this.f2510b = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIPackageManager$getInstallPackageFromGeckoJob$2(this.f2510b, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super f0> r10) {
        String r11 = this.f2510b;
        return new AIPackageManager$getInstallPackageFromGeckoJob$2(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2509a;
        int r12 = 1;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        ResultKt.throwOnFailure(r10);
        return r10;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        r r13 = r.f2752a;
        String r14 = r.j(this.f2510b);
        if (r14 != null) goto L12;
    L20:
        String r15 = androidx.room.jarjarred.org.antlr.runtime.a.v(new StringBuilder("baseUrl is empty. packageName: "), this.f2510b, "AIPackageManager", "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L25;
        r16.e("AIPackageManager", r15);
        return null;
    L25:
        return null;
    L12:
        if (r14.length() == 0) goto L20;
        LruCache r17 = e0.f2711a;
        String r18 = e0.g(this.f2510b, r14, false);
        f0 r19 = new f0(6, this.f2510b, false);
        String r20 = this.f2510b;
        this.f2509a = 1;
        kotlinx.coroutines.l r21 = new kotlinx.coroutines.l(1, IntrinsicsKt.intercepted(this));
        r21.w();
        e0.k(r19.e, r18, new m(r20, r21, r19), new com.bytedance.ai.bridge.method.phoneNum.d(r12, r20, r21), true);
        Object r22 = r21.v();
        if (r22 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(this);
    L17:
        if (r22 != r5) goto L19;
        return r5;
    L19:
        return r22;
    }
}
