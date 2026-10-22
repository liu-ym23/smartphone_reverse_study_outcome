package com.obric.assistant.live.island;

import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ComplexTaskQueueingIslandModule$getQueueingTasks$2 extends FunctionReferenceImpl implements Function1<DMTaskState, Long> {
    public ComplexTaskQueueingIslandModule$getQueueingTasks$2(Object r8) {
        super(1, r8, p.class, "getQueueingTaskTimestamp", "getQueueingTaskTimestamp(Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;)J", 0);
    }

    public final Long invoke(DMTaskState r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        p r0 = (p) ((CallableReference) this).receiver;
        int r1 = p.e;
        r0.getClass();
        String r4 = (String) r3.getExtra().get("o_task_queue_timestamp");
        if (r4 == null) goto L7;
        Long r5 = StringsKt.toLongOrNull(r4);
        if (r5 == null) goto L7;
        long r2 = r5.longValue();
    L9:
        return Long.valueOf(r2);
    L7:
        r2 = LongCompanionObject.MAX_VALUE;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((DMTaskState) r1);
    }
}
