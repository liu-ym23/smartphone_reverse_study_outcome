package com.obric.assistant.state.multitask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class TaskFlowManager$c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[TaskFlowManager$EntryLifecycle.values().length];
        r0[TaskFlowManager$EntryLifecycle.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[TaskFlowManager$EntryLifecycle.CLOSING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[TaskFlowManager$EntryLifecycle.CLOSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
