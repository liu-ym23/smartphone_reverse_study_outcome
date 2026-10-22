package aha;

import com.obric.assistant.state.api.multitask.state.ObricInteractionStateType;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o {
    public static final jha.g<n> a(String r4, ObricInteractionStateType r5) {
        Intrinsics.checkNotNullParameter(r4, "ownerId");
        Intrinsics.checkNotNullParameter(r5, "interactionType");
        p r0 = p.a;
        int r1 = com.obric.assistant.state.multitask.ext.f.a;
        return TaskFlowDslKt.b(r0, com.obric.assistant.state.multitask.ext.g.a(new com.obric.assistant.state.multitask.ext.g(), new String[]{r4, r5.getTaskId()}));
    }
}
