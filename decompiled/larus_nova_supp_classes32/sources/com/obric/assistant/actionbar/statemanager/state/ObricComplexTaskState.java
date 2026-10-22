package com.obric.assistant.actionbar.statemanager.state;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/actionbar/statemanager/state/ObricComplexTaskState;", "Lcom/obric/assistant/actionbar/statemanager/interfaces/ObricTaskState;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IDLE", "CLARIFYING", "RUNNING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricComplexTaskState extends Enum<ObricComplexTaskState> {
    public static final ObricComplexTaskState CLARIFYING = null;
    public static final ObricComplexTaskState IDLE = null;
    public static final ObricComplexTaskState RUNNING = null;
    public static final /* synthetic */ ObricComplexTaskState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ObricComplexTaskState> getEntries() {
        return b;
    }

    static {
        ObricComplexTaskState r0 = new ObricComplexTaskState("IDLE", 0, "complex_idle");
        IDLE = r0;
        ObricComplexTaskState r1 = new ObricComplexTaskState("CLARIFYING", 1, "complex_clarifying");
        CLARIFYING = r1;
        ObricComplexTaskState r2 = new ObricComplexTaskState("RUNNING", 2, "complex_running");
        RUNNING = r2;
        ObricComplexTaskState[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static ObricComplexTaskState[] values() {
        return (ObricComplexTaskState[]) a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static ObricComplexTaskState valueOf(String r1) {
        return (ObricComplexTaskState) a.a(ObricComplexTaskState.class, r1);
    }

    public ObricComplexTaskState(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
