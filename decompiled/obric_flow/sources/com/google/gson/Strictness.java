package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public final enum Strictness extends Enum<Strictness> {
    private static final /* synthetic */ Strictness[] $VALUES = null;
    public static final Strictness LEGACY_STRICT = null;
    public static final Strictness LENIENT = null;
    public static final Strictness STRICT = null;

    private static /* synthetic */ Strictness[] $values() {
        return new Strictness[]{LENIENT, LEGACY_STRICT, STRICT};
    }

    static {
        LENIENT = new Strictness("LENIENT", 0);
        LEGACY_STRICT = new Strictness("LEGACY_STRICT", 1);
        STRICT = new Strictness("STRICT", 2);
        $VALUES = $values();
    }

    private Strictness(String r5, int r10) {
        super(r5, r10);
    }

    public static Strictness valueOf(String r5) {
        return (Strictness) Enum.valueOf(Strictness.class, r5);
    }

    public static Strictness[] values() {
        return (Strictness[]) $VALUES.clone();
    }
}
