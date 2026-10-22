package javax.annotation.meta;

/* JADX INFO: loaded from: classes3.dex */
public final enum When extends Enum<When> {
    public static final When ALWAYS = null;
    public static final When MAYBE = null;
    public static final When NEVER = null;
    public static final When UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ When[] f18313a = null;

    static {
        When r5 = new When("ALWAYS", 0);
        ALWAYS = r5;
        When r10 = new When("UNKNOWN", 1);
        UNKNOWN = r10;
        When r11 = new When("MAYBE", 2);
        MAYBE = r11;
        When r12 = new When("NEVER", 3);
        NEVER = r12;
        f18313a = new When[]{r5, r10, r11, r12};
    }

    public static When valueOf(String r5) {
        return (When) Enum.valueOf(When.class, r5);
    }

    public static When[] values() {
        return (When[]) f18313a.clone();
    }
}
