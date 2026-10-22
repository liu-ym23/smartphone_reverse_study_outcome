package kotlinx.coroutines.channels;

/* JADX INFO: loaded from: classes3.dex */
public final enum TickerMode extends Enum<TickerMode> {
    private static final /* synthetic */ TickerMode[] $VALUES = null;
    public static final TickerMode FIXED_DELAY = null;
    public static final TickerMode FIXED_PERIOD = null;

    private static final /* synthetic */ TickerMode[] $values() {
        return new TickerMode[]{FIXED_PERIOD, FIXED_DELAY};
    }

    static {
        FIXED_PERIOD = new TickerMode("FIXED_PERIOD", 0);
        FIXED_DELAY = new TickerMode("FIXED_DELAY", 1);
        $VALUES = $values();
    }

    private TickerMode(String r10, int r11) {
        super(r10, r11);
    }

    public static TickerMode valueOf(String r10) {
        return (TickerMode) Enum.valueOf(TickerMode.class, r10);
    }

    public static TickerMode[] values() {
        return (TickerMode[]) $VALUES.clone();
    }
}
