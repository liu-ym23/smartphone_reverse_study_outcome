package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes3.dex */
public final enum SharingCommand extends Enum<SharingCommand> {
    private static final /* synthetic */ SharingCommand[] $VALUES = null;
    public static final SharingCommand START = null;
    public static final SharingCommand STOP = null;
    public static final SharingCommand STOP_AND_RESET_REPLAY_CACHE = null;

    private static final /* synthetic */ SharingCommand[] $values() {
        return new SharingCommand[]{START, STOP, STOP_AND_RESET_REPLAY_CACHE};
    }

    static {
        START = new SharingCommand("START", 0);
        STOP = new SharingCommand("STOP", 1);
        STOP_AND_RESET_REPLAY_CACHE = new SharingCommand("STOP_AND_RESET_REPLAY_CACHE", 2);
        $VALUES = $values();
    }

    private SharingCommand(String r10, int r11) {
        super(r10, r11);
    }

    public static SharingCommand valueOf(String r10) {
        return (SharingCommand) Enum.valueOf(SharingCommand.class, r10);
    }

    public static SharingCommand[] values() {
        return (SharingCommand[]) $VALUES.clone();
    }
}
