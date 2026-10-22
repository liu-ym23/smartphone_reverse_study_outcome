package javax.annotation.meta;

/* JADX INFO: loaded from: classes2.dex */
public final enum When extends Enum<When> {
    private static final /* synthetic */ When[] $VALUES = null;
    public static final When ALWAYS = null;
    public static final When MAYBE = null;
    public static final When NEVER = null;
    public static final When UNKNOWN = null;

    static {
        When r10 = new When("ALWAYS", 0);
        ALWAYS = r10;
        When r11 = new When("UNKNOWN", 1);
        UNKNOWN = r11;
        When r12 = new When("MAYBE", 2);
        MAYBE = r12;
        When r13 = new When("NEVER", 3);
        NEVER = r13;
        $VALUES = new When[]{r10, r11, r12, r13};
    }

    private When(String r10, int r11) {
        super(r10, r11);
    }

    public static When valueOf(String r10) {
        return (When) Enum.valueOf(When.class, r10);
    }

    public static When[] values() {
        return (When[]) $VALUES.clone();
    }
}
