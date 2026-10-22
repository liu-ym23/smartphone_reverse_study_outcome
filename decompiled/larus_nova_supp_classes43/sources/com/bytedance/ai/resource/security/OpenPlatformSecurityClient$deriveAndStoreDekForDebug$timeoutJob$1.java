package com.bytedance.ai.resource.security;

import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.security.OpenPlatformSecurityClient$deriveAndStoreDekForDebug$timeoutJob$1", f = "OpenPlatformSecurityClient.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
final class OpenPlatformSecurityClient$deriveAndStoreDekForDebug$timeoutJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $packageName;
    final /* synthetic */ j.a $requestContext;
    final /* synthetic */ long $versionCode;
    int label;

    public OpenPlatformSecurityClient$deriveAndStoreDekForDebug$timeoutJob$1(j.a r1, String r10, long r11, Continuation<? super OpenPlatformSecurityClient$deriveAndStoreDekForDebug$timeoutJob$1> r12) {
        this.$requestContext = r1;
        this.$packageName = r10;
        this.$versionCode = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new OpenPlatformSecurityClient$deriveAndStoreDekForDebug$timeoutJob$1(this.$requestContext, this.$packageName, this.$versionCode, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "waiting debug dek timeout");
        j.b r11 = j.b.remove(this.$requestContext.a);
        if (r11 == null) goto L15;
        r11.e.invoke(new TimeoutException("debug DEK decrypt timeout. package=" + this.$packageName + " version=" + this.$versionCode));
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        this.label = 1;
        if (DelayKt.delay(30000, this) != r0) goto L11;
        return r0;
    }
}
