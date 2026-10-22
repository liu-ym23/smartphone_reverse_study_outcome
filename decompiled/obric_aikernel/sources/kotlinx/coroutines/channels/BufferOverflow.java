package kotlinx.coroutines.channels;

/* JADX INFO: loaded from: classes3.dex */
public final enum BufferOverflow extends Enum<BufferOverflow> {
    private static final /* synthetic */ BufferOverflow[] $VALUES = null;
    public static final BufferOverflow DROP_LATEST = null;
    public static final BufferOverflow DROP_OLDEST = null;
    public static final BufferOverflow SUSPEND = null;

    private static final /* synthetic */ BufferOverflow[] $values() {
        return new BufferOverflow[]{SUSPEND, DROP_OLDEST, DROP_LATEST};
    }

    static {
        SUSPEND = new BufferOverflow("SUSPEND", 0);
        DROP_OLDEST = new BufferOverflow("DROP_OLDEST", 1);
        DROP_LATEST = new BufferOverflow("DROP_LATEST", 2);
        $VALUES = $values();
    }

    private BufferOverflow(String r10, int r11) {
        super(r10, r11);
    }

    public static BufferOverflow valueOf(String r10) {
        return (BufferOverflow) Enum.valueOf(BufferOverflow.class, r10);
    }

    public static BufferOverflow[] values() {
        return (BufferOverflow[]) $VALUES.clone();
    }
}
