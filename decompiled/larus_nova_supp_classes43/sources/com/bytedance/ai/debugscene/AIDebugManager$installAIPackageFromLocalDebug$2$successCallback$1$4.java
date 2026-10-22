package com.bytedance.ai.debugscene;

import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.debugscene.AIDebugManager$installAIPackageFromLocalDebug$2$successCallback$1$4", f = "AIDebugManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AIDebugManager$installAIPackageFromLocalDebug$2$successCallback$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $manifest;
    final /* synthetic */ AIPackageManifestBean $manifestBean;
    final /* synthetic */ Function0<Unit> $resolve;
    int label;

    public AIDebugManager$installAIPackageFromLocalDebug$2$successCallback$1$4(String r1, AIPackageManifestBean r10, Function0<Unit> r11, Continuation<? super AIDebugManager$installAIPackageFromLocalDebug$2$successCallback$1$4> r12) {
        this.$manifest = r1;
        this.$manifestBean = r10;
        this.$resolve = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIDebugManager$installAIPackageFromLocalDebug$2$successCallback$1$4(this.$manifest, this.$manifestBean, this.$resolve, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        AIDebugManager r11 = AIDebugManager.a;
        this.$resolve.invoke();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
