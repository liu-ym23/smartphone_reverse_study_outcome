package jha;

import com.obric.assistant.state.multitask.core.TaskFlowDispatchStrategy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class f$b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[TaskFlowDispatchStrategy.values().length];
        r0[TaskFlowDispatchStrategy.SHARED_SERIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[TaskFlowDispatchStrategy.PRODUCER_SERIALIZED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[TaskFlowDispatchStrategy.CALLER_CONTEXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
