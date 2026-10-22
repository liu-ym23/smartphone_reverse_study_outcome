package com.bytedance.ai.debugscene;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIManager;
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
@DebugMetadata(c = "com.bytedance.ai.debugscene.AppletDebugCommandDispatcher$uninstallAIPackage$1", f = "AppletDebugCommandDispatcher.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebugCommandDispatcher$uninstallAIPackage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ String $packageName;
    int label;

    public AppletDebugCommandDispatcher$uninstallAIPackage$1(String r1, String r10, Continuation<? super AppletDebugCommandDispatcher$uninstallAIPackage$1> r11) {
        this.$packageName = r1;
        this.$id = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletDebugCommandDispatcher$uninstallAIPackage$1(this.$packageName, this.$id, r11);
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
        String r12 = this.$packageName;
        String r13 = this.$id;
        AIPackage.AIPackageType r14 = AIPackage.AIPackageType.UNKNOWN;
        this.label = 1;
        if (r11.K(r12, r13, r14, this) != r0) goto L12;
        return r0;
    }
}
