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
@DebugMetadata(c = "com.bytedance.ai.debugscene.AIDebugManager$installAIPackagesWithVersionTagInMemory$2", f = "AIDebugManager.kt", i = {}, l = {1109}, m = "invokeSuspend", n = {}, s = {})
final class AIDebugManager$installAIPackagesWithVersionTagInMemory$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Boolean, Boolean, String, Unit> $callback;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $packageName;
    final /* synthetic */ int $source;
    final /* synthetic */ String $versionTag;
    final /* synthetic */ String $xToken;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AIDebugManager$installAIPackagesWithVersionTagInMemory$2(int r1, String r10, String r11, String r12, String r13, Function3<? super Boolean, ? super Boolean, ? super String, Unit> r14, Continuation<? super AIDebugManager$installAIPackagesWithVersionTagInMemory$2> r15) {
        this.$source = r1;
        this.$packageName = r10;
        this.$versionTag = r11;
        this.$deviceId = r12;
        this.$xToken = r13;
        this.$callback = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIDebugManager$installAIPackagesWithVersionTagInMemory$2(this.$source, this.$packageName, this.$versionTag, this.$deviceId, this.$xToken, this.$callback, r11);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AIManager r11 = AIManager.a;
        int r12 = this.$source;
        final String r13 = this.$packageName;
        final String r14 = this.$versionTag;
        String r15 = this.$deviceId;
        String r16 = this.$xToken;
        final Function3<Boolean, Boolean, String, Unit> r17 = this.$callback;
        Function4<? super Boolean, ? super Boolean, ? super com.bytedance.ai.resource.d0, ? super String, Unit> r18 = new v(r13, r14, r17);
        this.label = 1;
        if (r11.v(r12, r13, r14, r15, r16, r18, this) != r0) goto L12;
        return r0;
    }
}
