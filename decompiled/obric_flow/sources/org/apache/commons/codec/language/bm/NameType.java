package org.apache.commons.codec.language.bm;

/* JADX INFO: loaded from: classes3.dex */
public final enum NameType extends Enum<NameType> {
    public static final NameType ASHKENAZI = null;
    public static final NameType GENERIC = null;
    public static final NameType SEPHARDIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NameType[] f20943a = null;
    private final String name;

    static {
        NameType r5 = new NameType("ASHKENAZI", 0, "ash");
        ASHKENAZI = r5;
        NameType r10 = new NameType("GENERIC", 1, "gen");
        GENERIC = r10;
        NameType r11 = new NameType("SEPHARDIC", 2, "sep");
        SEPHARDIC = r11;
        f20943a = new NameType[]{r5, r10, r11};
    }

    public NameType(String r5, int r10, String r11) {
        super(r5, r10);
        this.name = r11;
    }

    public static NameType valueOf(String r5) {
        return (NameType) Enum.valueOf(NameType.class, r5);
    }

    public static NameType[] values() {
        return (NameType[]) f20943a.clone();
    }

    public String getName() {
        return this.name;
    }
}
