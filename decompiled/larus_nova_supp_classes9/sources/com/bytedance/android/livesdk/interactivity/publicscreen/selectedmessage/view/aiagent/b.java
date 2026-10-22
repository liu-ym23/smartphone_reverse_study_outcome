package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r0 = new int[AiAgentViewState.values().length];
        a = r0;
        AiAgentViewState r1 = AiAgentViewState.NO_OR_OLD_AI;
        r0[r1.ordinal()] = 1;
        AiAgentViewState r2 = AiAgentViewState.AI_AGENT_EMPTY;
        r0[r2.ordinal()] = 2;
        AiAgentViewState r4 = AiAgentViewState.AI_AGENT_MESSAGE;
        r0[r4.ordinal()] = 3;
        AiAgentViewState r6 = AiAgentViewState.AI_AGENT_FOLD;
        r0[r6.ordinal()] = 4;
        int[] r3 = new int[AiAgentViewState.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
        int[] r5 = new int[AiAgentViewState.values().length];
        c = r5;
        r5[r2.ordinal()] = 1;
        r5[r4.ordinal()] = 2;
        r5[r6.ordinal()] = 3;
        int[] r7 = new int[AiAgentViewState.values().length];
        d = r7;
        r7[r1.ordinal()] = 1;
        r7[r2.ordinal()] = 2;
        r7[r6.ordinal()] = 3;
        r7[r4.ordinal()] = 4;
    }
}
