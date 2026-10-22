package com.bytedance.ai.resource;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0}, l = {365, 383}, m = "updateAIPackage", n = {com.bytedance.android.ec.core.event.a.KEY_RESULT}, s = {"L$0"})
final class AIManager$updateAIPackage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIManager this$0;

    public AIManager$updateAIPackage$1(AIManager r1, Continuation<? super AIManager$updateAIPackage$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AIManager r11 = this.this$0;
        r11.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        AIManager$updateAIPackage$1 r0 = this;
    L6:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 != 0) goto L9;
        ResultKt.throwOnFailure(r12);
        AIManager.g(null);
        throw null;
    L9:
        if (r14 == 1) goto L14;
        if (r14 != 2) goto L13;
        ResultKt.throwOnFailure(r12);
    L18:
        return r12;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        CompletableDeferred r15 = (CompletableDeferred) r0.L$0;
        ResultKt.throwOnFailure(r12);
        r0.L$0 = null;
        r0.label = 2;
        r12 = r15.await(r0);
        if (r12 != r13) goto L18;
        return r13;
    L5:
        r0 = new AIManager$updateAIPackage$1(r11, this);
        goto L6
    }
}
