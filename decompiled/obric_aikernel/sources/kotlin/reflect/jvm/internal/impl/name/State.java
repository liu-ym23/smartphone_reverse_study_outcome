package kotlin.reflect.jvm.internal.impl.name;

/* JADX INFO: loaded from: classes3.dex */
final enum State extends Enum<State> {
    private static final /* synthetic */ State[] $VALUES = null;
    public static final State AFTER_DOT = null;
    public static final State BEGINNING = null;
    public static final State MIDDLE = null;

    private static final /* synthetic */ State[] $values() {
        return new State[]{BEGINNING, MIDDLE, AFTER_DOT};
    }

    static {
        BEGINNING = new State("BEGINNING", 0);
        MIDDLE = new State("MIDDLE", 1);
        AFTER_DOT = new State("AFTER_DOT", 2);
        $VALUES = $values();
    }

    private State(String r10, int r11) {
        super(r10, r11);
    }

    public static State valueOf(String r10) {
        return (State) Enum.valueOf(State.class, r10);
    }

    public static State[] values() {
        return (State[]) $VALUES.clone();
    }
}
