package com.bytedance.ai.debugscene;

import com.bytedance.ai.resource.AIManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.debugscene.AIDebugManager$installAIPackagesWithVersionCodeFromRemoteDebug$2", f = "AIDebugManager.kt", i = {}, l = {1036}, m = "invokeSuspend", n = {}, s = {})
final class AIDebugManager$installAIPackagesWithVersionCodeFromRemoteDebug$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Boolean, Boolean, String, Unit> $callback;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $packageName;
    final /* synthetic */ int $source;
    final /* synthetic */ String $token;
    final /* synthetic */ long $versionCode;
    final /* synthetic */ String $xToken;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AIDebugManager$installAIPackagesWithVersionCodeFromRemoteDebug$2(int r1, String r10, long r11, String r12, String r13, String r14, Function3<? super Boolean, ? super Boolean, ? super String, Unit> r15, Continuation<? super AIDebugManager$installAIPackagesWithVersionCodeFromRemoteDebug$2> r16) {
        this.$source = r1;
        this.$packageName = r10;
        this.$versionCode = r11;
        this.$deviceId = r12;
        this.$token = r13;
        this.$xToken = r14;
        this.$callback = r15;
        super(2, r16);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new AIDebugManager$installAIPackagesWithVersionCodeFromRemoteDebug$2(this.$source, this.$packageName, this.$versionCode, this.$deviceId, this.$token, this.$xToken, this.$callback, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        AIManager r10 = AIManager.a;
        int r14 = this.$source;
        final String r11 = this.$packageName;
        long r12 = this.$versionCode;
        String r15 = this.$deviceId;
        String r16 = this.$token;
        String r17 = this.$xToken;
        final Function3<Boolean, Boolean, String, Unit> r18 = this.$callback;
        Function4<? super Boolean, ? super Boolean, ? super com.bytedance.ai.resource.d0, ? super String, Unit> r19 = new u(r18, r11);
        this.label = 1;
        if (r10.u(r14, r11, r12, r15, r16, r17, null, r19, this) != r0) goto L12;
        return r0;
    }
}
