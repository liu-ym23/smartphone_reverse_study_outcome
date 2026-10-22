package com.obric.aikernel.model_preset.api;

/* JADX INFO: loaded from: classes2.dex */
public final enum PresetType extends Enum<PresetType> {
    private static final /* synthetic */ PresetType[] $VALUES = null;
    public static final PresetType Assets = null;
    public static final PresetType None = null;
    public static final PresetType OS = null;
    private final String des;

    private static final /* synthetic */ PresetType[] $values() {
        return new PresetType[]{Assets, OS, None};
    }

    static {
        Assets = new PresetType("Assets", 0, "Assets");
        OS = new PresetType("OS", 1, "OS");
        None = new PresetType("None", 2, "none");
        $VALUES = $values();
    }

    private PresetType(String r10, int r11, String r12) {
        super(r10, r11);
        this.des = r12;
    }

    public static PresetType valueOf(String r10) {
        return (PresetType) Enum.valueOf(PresetType.class, r10);
    }

    public static PresetType[] values() {
        return (PresetType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.des;
    }
}
