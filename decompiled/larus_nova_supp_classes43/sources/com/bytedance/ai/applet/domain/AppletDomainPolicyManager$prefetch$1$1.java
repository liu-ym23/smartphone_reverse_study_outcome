package com.bytedance.ai.applet.domain;

import com.bytedance.ai.utils.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.domain.AppletDomainPolicyManager$prefetch$1$1", f = "AppletDomainPolicyManager.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
final class AppletDomainPolicyManager$prefetch$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $normalizedAppKey;
    final /* synthetic */ String $source;
    final /* synthetic */ AppletDomainPolicyManager $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public AppletDomainPolicyManager$prefetch$1$1(AppletDomainPolicyManager r1, String r10, String r11, Continuation<? super AppletDomainPolicyManager$prefetch$1$1> r12) {
        this.$this_runCatching = r1;
        this.$normalizedAppKey = r10;
        this.$source = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AppletDomainPolicyManager$prefetch$1$1 r0 = new AppletDomainPolicyManager$prefetch$1$1(this.$this_runCatching, this.$normalizedAppKey, this.$source, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L10;
        if (r11 != 1) goto L9;
        String r12 = (String) this.L$1;
        String r13 = (String) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L20
        Object r14 = ((Result) r10).unbox-impl();     // Catch: Throwable -> L20
    L15:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L20
        if (r15 == null) goto L18;
        g.a.e("AppletDomainPolicyManager", "prefetch failed, appKey:" + r13 + ", source:" + r12 + ", error:" + r15.getMessage());     // Catch: Throwable -> L20
    L18:
        Object r16 = Result.constructor-impl(Result.box-impl(r14));     // Catch: Throwable -> L20
    L22:
        String r0 = this.$normalizedAppKey;
        String r17 = this.$source;
        Throwable r18 = Result.exceptionOrNull-impl(r16);
        if (r18 == null) goto L26;
        g.a.e("AppletDomainPolicyManager", "prefetch crashed, appKey:" + r0 + ", source:" + r17 + ", error:" + r18.getMessage());
    L26:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r19 = (CoroutineScope) this.L$0;
        AppletDomainPolicyManager r110 = this.$this_runCatching;
        r13 = this.$normalizedAppKey;
        String r20 = this.$source;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L20
        this.L$0 = r13;     // Catch: Throwable -> L20
        this.L$1 = r20;     // Catch: Throwable -> L20
        this.label = 1;     // Catch: Throwable -> L20
        AppletDomainPolicyManager r22 = AppletDomainPolicyManager.a;     // Catch: Throwable -> L20
        r14 = r110.g(r13, r20, this);     // Catch: Throwable -> L20
        if (r14 != r1) goto L14;
        return r1;
    L14:
        r12 = r20;
    L20:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
