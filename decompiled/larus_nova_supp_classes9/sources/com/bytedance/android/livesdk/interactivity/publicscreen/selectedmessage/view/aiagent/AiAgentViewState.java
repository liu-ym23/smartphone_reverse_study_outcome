package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/AiAgentViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "desc", "DEFAULT", "NO_OR_OLD_AI", "AI_AGENT_EMPTY", "AI_AGENT_MESSAGE", "AI_AGENT_FOLD", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AiAgentViewState extends Enum<AiAgentViewState> {
    public static final AiAgentViewState AI_AGENT_EMPTY = null;
    public static final AiAgentViewState AI_AGENT_FOLD = null;
    public static final AiAgentViewState AI_AGENT_MESSAGE = null;
    public static final AiAgentViewState DEFAULT = null;
    public static final AiAgentViewState NO_OR_OLD_AI = null;
    public static final /* synthetic */ AiAgentViewState[] a = null;

    static {
        AiAgentViewState r1 = new AiAgentViewState("DEFAULT", 0);
        DEFAULT = r1;
        AiAgentViewState r2 = new AiAgentViewState("NO_OR_OLD_AI", 1);
        NO_OR_OLD_AI = r2;
        AiAgentViewState r3 = new AiAgentViewState("AI_AGENT_EMPTY", 2);
        AI_AGENT_EMPTY = r3;
        AiAgentViewState r4 = new AiAgentViewState("AI_AGENT_MESSAGE", 3);
        AI_AGENT_MESSAGE = r4;
        AiAgentViewState r5 = new AiAgentViewState("AI_AGENT_FOLD", 4);
        AI_AGENT_FOLD = r5;
        a = new AiAgentViewState[]{r1, r2, r3, r4, r5};
    }

    public static AiAgentViewState valueOf(String r1) {
        return (AiAgentViewState) r27.a.a(AiAgentViewState.class, r1);
    }

    public static AiAgentViewState[] values() {
        return (AiAgentViewState[]) a.clone();
    }

    public final String desc() {
        int r0 = j.a[ordinal()];
        if (r0 != 1) goto L5;
        return "DEFAULT";
    L5:
        if (r0 != 2) goto L7;
        return "NO_OR_OLD_AI";
    L7:
        if (r0 != 3) goto L9;
        return "AI_AGENT_EMPTY";
    L9:
        if (r0 != 4) goto L11;
        return "AI_AGENT_MESSAGE";
    L11:
        if (r0 != 5) goto L14;
        return "AI_AGENT_FOLD";
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public AiAgentViewState(String r1, int r2) {
        super(r1, r2);
    }
}
