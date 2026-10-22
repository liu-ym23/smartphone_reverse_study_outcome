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
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0}, l = {313}, m = "queryAIPackagesByBotId", n = {"botId"}, s = {"L$0"})
final class AIPackageStorage$queryAIPackagesByBotId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageStorage this$0;

    public AIPackageStorage$queryAIPackagesByBotId$1(AIPackageStorage r1, Continuation<? super AIPackageStorage$queryAIPackagesByBotId$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AIPackageStorage r11 = this.this$0;
        r11.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        AIPackageStorage$queryAIPackagesByBotId$1 r0 = this;
    L6:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L16;
        if (r14 != 1) goto L15;
        String r15 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L12
    L21:
        Object r16 = (List) r12;     // Catch: Exception -> L12
        if (r16 != null) goto L29;
        r16 = new ArrayList();     // Catch: Exception -> L12
    L29:
        return r16;
    L12:
        e = move-exception;
        String r17 = r15;
        e = e;
        String r18 = r17;
    L27:
        g.a.e("AIPackageStorage", "query AIPackage info by BotId = " + r18 + " error : " + ExceptionsKt.stackTraceToString(e));
        r16 = new ArrayList();
        goto L29
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r12);
        r18 = null;
        AIPackageDao r19 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L26
        r0.L$0 = null;     // Catch: Exception -> L26
        r0.label = 1;     // Catch: Exception -> L26
        Object r20 = r19.q(r0);     // Catch: Exception -> L26
        if (r20 == r13) goto L34;
        r15 = null;
        r12 = r20;
        goto L21
    L34:
        return r13;
    L26:
        e = e;
        goto L27
    L5:
        r0 = new AIPackageStorage$queryAIPackagesByBotId$1(r11, this);
        goto L6
    }
}
