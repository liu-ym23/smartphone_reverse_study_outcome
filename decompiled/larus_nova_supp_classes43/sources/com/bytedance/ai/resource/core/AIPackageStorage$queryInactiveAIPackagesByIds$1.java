package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 0}, l = {196}, m = "queryInactiveAIPackagesByIds", n = {"packages", "aiPackages"}, s = {"L$0", "L$1"})
final class AIPackageStorage$queryInactiveAIPackagesByIds$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageStorage this$0;

    public AIPackageStorage$queryInactiveAIPackagesByIds$1(AIPackageStorage r1, Continuation<? super AIPackageStorage$queryInactiveAIPackagesByIds$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0084: INVOKE (r2 I:int) = (r11 I:java.util.List) INTERFACE call: java.util.List.size():int A[MD:():int (c)] (LINE:16777348), block:B:26:0x007b */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List] */
    public final Object invokeSuspend(Object r13) {
        this.result = r13;
        this.label |= Integer.MIN_VALUE;
        AIPackageStorage r14 = this.this$0;
        r14.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        AIPackageStorage$queryInactiveAIPackagesByIds$1 r0 = this;
    L6:
        Object r15 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 != 0) goto L9;
        ResultKt.throwOnFailure(r15);
        new ArrayList();
        throw null;     // Catch: Exception -> L20
    L9:
        if (r11 != 1) goto L23;
        Iterator r12 = (Iterator) r0.L$2;
        List r16 = (List) r0.L$1;
        List r17 = (List) r0.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L20
    L12:
        AIPackage r18 = (AIPackage) r15;     // Catch: Exception -> L20
        if (r18 == null) goto L16;
        r16.add(r18);     // Catch: Exception -> L20
    L16:
        if (r12.hasNext() == false) goto L28;
        AIPackageManager.a r19 = (AIPackageManager.a) r12.next();     // Catch: Exception -> L20
        AIPackageStorage r20 = AIPackageStorage.a;     // Catch: Exception -> L20
        AIPackage.AIPackageType r21 = AIPackage.AIPackageType.UNKNOWN;     // Catch: Exception -> L20
        r0.L$0 = r17;     // Catch: Exception -> L20
        r0.L$1 = r16;     // Catch: Exception -> L20
        r0.L$2 = r12;     // Catch: Exception -> L20
        r0.label = 1;     // Catch: Exception -> L20
        r15 = r20.h(r19, r21, 0, r0);     // Catch: Exception -> L20
        if (r15 != r10) goto L12;
        return r10;
    L28:
        return r16;
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        e = move-exception;
        g.a.e("AIPackageStorage", "query packages(size=" + r11.size() + ") info database error : " + ExceptionsKt.stackTraceToString(e));
        goto L28
    L5:
        r0 = new AIPackageStorage$queryInactiveAIPackagesByIds$1(r14, this);
        goto L6
    }
}
