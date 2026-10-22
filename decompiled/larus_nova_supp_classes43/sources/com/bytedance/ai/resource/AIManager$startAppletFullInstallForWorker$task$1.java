package com.bytedance.ai.resource;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/resource/AIManager$AppletFullReadyResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager$startAppletFullInstallForWorker$task$1", f = "AIManager.kt", i = {}, l = {1051}, m = "invokeSuspend", n = {}, s = {})
public final class AIManager$startAppletFullInstallForWorker$task$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AIManager.a>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ String $packageName;
    final /* synthetic */ long $versionCode;
    int label;

    public AIManager$startAppletFullInstallForWorker$task$1(String r1, String r10, long r11, Continuation<? super AIManager$startAppletFullInstallForWorker$task$1> r12) {
        this.$packageName = r1;
        this.$appId = r10;
        this.$versionCode = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIManager$startAppletFullInstallForWorker$task$1(this.$packageName, this.$appId, this.$versionCode, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AIManager.a> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        com.bytedance.ai.utils.g.a.i("AIManager", "startAppletFullInstallForWorker start. packageName: " + this.$packageName + ", appId: " + this.$appId + ", versionCode: " + this.$versionCode);
        AIManager r10 = AIManager.a;
        String r12 = this.$packageName;
        String r13 = this.$appId;
        long r14 = this.$versionCode;
        this.label = 1;
        r11 = AIManager.c(r10, r12, r13, r14, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
