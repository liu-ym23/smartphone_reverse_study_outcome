package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.utils.g;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 1}, l = {71, 73}, m = "updateAIPackage", n = {"info", "info"}, s = {"L$0", "L$0"})
final class AIPackageStorage$updateAIPackage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageStorage this$0;

    public AIPackageStorage$updateAIPackage$1(AIPackageStorage r1, Continuation<? super AIPackageStorage$updateAIPackage$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ai.model.objects.AIPackage, com.bytedance.ai.resource.core.AIPackageStorage$updateAIPackage$1] */
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AIPackageStorage r11 = this.this$0;
        r11.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        ?? r0 = this;
    L6:
        Object r12 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L20;
        boolean r14 = true;
        if (r13 != 1) goto L11;
        AIPackage r15 = (AIPackage) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L23
    L26:
        return Boxing.boxBoolean(r14);
    L11:
        if (r13 != 2) goto L16;
        AIPackage r16 = (AIPackage) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L23
        g.a.d("AIPackageStorage", "packageName: " + r16.b + ", appId: " + ((Applet) r16).K + " ===> end update database");     // Catch: Exception -> L23
        goto L26
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r12);
        g r17 = g.a;     // Catch: Exception -> L23
        throw null;     // Catch: Exception -> L23
    L23:
        e = move-exception;
        g.a.e("AIPackageStorage", "packageName: " + r0.b + ", appId: " + r0.a() + " ===> update database error : " + ExceptionsKt.stackTraceToString(e));
        r14 = false;
        goto L26
    L5:
        r0 = new AIPackageStorage$updateAIPackage$1(r11, this);
        goto L6
    }
}
