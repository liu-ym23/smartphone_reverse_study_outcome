package com.bytedance.ai.resource;

import com.bytedance.ai.model.objects.AIPackage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {}, l = {519}, m = "isAIPackageRunning$ai_sdk_release", n = {}, s = {})
final class AIManager$isAIPackageRunning$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIManager this$0;

    public AIManager$isAIPackageRunning$1(AIManager r1, Continuation<? super AIManager$isAIPackageRunning$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        AIManager r1 = this.this$0;
        r1.getClass();
        int r12 = this.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r12 - Integer.MIN_VALUE;
        AIManager$isAIPackageRunning$1 r10 = this;
    L6:
        Object r13 = r10.result;
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        boolean r15 = true;
        if (r14 == 0) goto L12;
        if (r14 != 1) goto L11;
        ResultKt.throwOnFailure(r13);
    L15:
        AIPackage r16 = (AIPackage) r13;
        boolean r17 = false;
        if (r16 == null) goto L23;
        if (r16.H.get() != 0) goto L21;
        r15 = false;
    L21:
        r17 = r15;
    L23:
        return Boxing.boxBoolean(r17);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r13);
        r10.label = 1;
        r13 = AIManager.B(r1, null, null, null, false, null, r10, 24);
        if (r13 != r0) goto L15;
        return r0;
    L5:
        r10 = new AIManager$isAIPackageRunning$1(r1, this);
        goto L6
    }
}
