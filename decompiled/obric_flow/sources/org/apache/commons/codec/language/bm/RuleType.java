package org.apache.commons.codec.language.bm;

/* JADX INFO: loaded from: classes3.dex */
public final enum RuleType extends Enum<RuleType> {
    public static final RuleType APPROX = null;
    public static final RuleType EXACT = null;
    public static final RuleType RULES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RuleType[] f20944a = null;
    private final String name;

    static {
        RuleType r5 = new RuleType("APPROX", 0, "approx");
        APPROX = r5;
        RuleType r10 = new RuleType("EXACT", 1, "exact");
        EXACT = r10;
        RuleType r11 = new RuleType("RULES", 2, "rules");
        RULES = r11;
        f20944a = new RuleType[]{r5, r10, r11};
    }

    public RuleType(String r5, int r10, String r11) {
        super(r5, r10);
        this.name = r11;
    }

    public static RuleType valueOf(String r5) {
        return (RuleType) Enum.valueOf(RuleType.class, r5);
    }

    public static RuleType[] values() {
        return (RuleType[]) f20944a.clone();
    }

    public String getName() {
        return this.name;
    }
}
