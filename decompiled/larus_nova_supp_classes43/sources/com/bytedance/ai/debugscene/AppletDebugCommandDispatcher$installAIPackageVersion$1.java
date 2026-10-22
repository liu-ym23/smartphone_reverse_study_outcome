package com.bytedance.ai.debugscene;

import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.AIPackageManager;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.bytedance.ai.debugscene.AppletDebugCommandDispatcher$installAIPackageVersion$1", f = "AppletDebugCommandDispatcher.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebugCommandDispatcher$installAIPackageVersion$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ String $packageName;
    final /* synthetic */ Long $versionCode;
    int label;

    public AppletDebugCommandDispatcher$installAIPackageVersion$1(String r1, String r10, Long r11, Continuation<? super AppletDebugCommandDispatcher$installAIPackageVersion$1> r12) {
        this.$appId = r1;
        this.$packageName = r10;
        this.$versionCode = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletDebugCommandDispatcher$installAIPackageVersion$1(this.$appId, this.$packageName, this.$versionCode, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        AIManager r12 = AIManager.a;
        String r13 = this.$appId;
        String r10 = this.$packageName;
        long r14 = this.$versionCode.longValue();
        this.label = 1;
        com.bytedance.ai.utils.g.a.d("AIManager", "install AIPackage with packageName: " + r10 + ", appId: " + r13 + ", versionCode: " + r14);
        Object r15 = AIPackageManager.j(AIPackageManager.a, new AIPackageManager.a(r13, r10), r14, new com.bytedance.ai.resource.g(null), this);
        if (r15 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r15 = Unit.INSTANCE;
    L12:
        if (r15 != r0) goto L15;
        return r0;
    }
}
