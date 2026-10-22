package com.bytedance.ai.resource.core;

import com.bytedance.ai.resource.core.db.AIPackageDao;
import com.bytedance.ai.resource.core.db.AIPackageDatabase;
import com.bytedance.ai.utils.g;
import java.util.ArrayList;
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
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 1}, l = {249, 252}, m = "queryAllAIPackages", n = {"aiPackages", "aiPackages"}, s = {"L$0", "L$0"})
final class AIPackageStorage$queryAllAIPackages$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageStorage this$0;

    public AIPackageStorage$queryAllAIPackages$1(AIPackageStorage r1, Continuation<? super AIPackageStorage$queryAllAIPackages$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AIPackageStorage r11 = this.this$0;
        r11.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        AIPackageStorage$queryAllAIPackages$1 r0 = this;
    L6:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r14 = r0.label;
        if (r14 == 0) goto L22;
        if (r14 == 1) goto L17;
        if (r14 != 2) goto L16;
        ?? r15 = (List) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L13
        r15 = r15;
    L33:
        List r16 = (List) r12;     // Catch: Exception -> L13
        if (r16 == null) goto L45;
        r15.addAll(r16);     // Catch: Exception -> L13
    L45:
        return r15;
    L13:
        e = e;
        r14 = r15;
    L38:
        g.a.e("AIPackageStorage", "query all installed AIPackage info database error : " + ExceptionsKt.stackTraceToString(e));
        return r14;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        List r17 = (List) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L20
        r14 = r17;
    L26:
        List r18 = (List) r12;     // Catch: Exception -> L20
        if (r18 == null) goto L29;
        r14.addAll(r18);     // Catch: Exception -> L20
    L29:
        AIPackageDao r19 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L20
        r0.L$0 = r14;     // Catch: Exception -> L20
        r0.label = 2;     // Catch: Exception -> L20
        r12 = r19.o(r0);     // Catch: Exception -> L20
        if (r12 == r13) goto L46;
        r15 = r14;
        goto L33
    L46:
        return r13;
    L22:
        ResultKt.throwOnFailure(r12);
        ArrayList r20 = new ArrayList();
        AIPackageDao r21 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L20
        r0.L$0 = r20;     // Catch: Exception -> L20
        r0.label = 1;     // Catch: Exception -> L20
        r12 = r21.p(r0);     // Catch: Exception -> L20
        r14 = r20;
        if (r12 != r13) goto L26;
        return r13;
    L20:
        e = e;
        goto L38
    L5:
        r0 = new AIPackageStorage$queryAllAIPackages$1(r11, this);
        goto L6
    }
}
