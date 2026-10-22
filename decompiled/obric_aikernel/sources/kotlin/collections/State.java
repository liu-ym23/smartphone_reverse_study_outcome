package kotlin.collections;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
final enum State extends Enum<State> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ State[] $VALUES = null;
    public static final State Done = null;
    public static final State Failed = null;
    public static final State NotReady = null;
    public static final State Ready = null;

    private static final /* synthetic */ State[] $values() {
        return new State[]{Ready, NotReady, Done, Failed};
    }

    static {
        Ready = new State("Ready", 0);
        NotReady = new State("NotReady", 1);
        Done = new State("Done", 2);
        Failed = new State("Failed", 3);
        State[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = EnumEntriesKt.enumEntries(r10);
    }

    private State(String r10, int r11) {
        super(r10, r11);
    }

    public static EnumEntries<State> getEntries() {
        return $ENTRIES;
    }

    public static State valueOf(String r10) {
        return (State) Enum.valueOf(State.class, r10);
    }

    public static State[] values() {
        return (State[]) $VALUES.clone();
    }
}
