package com.obric.aikernel.model_preset.api;

/* JADX INFO: loaded from: classes2.dex */
public final enum DecryptType extends Enum<DecryptType> {
    private static final /* synthetic */ DecryptType[] $VALUES = null;
    public static final DecryptType DecryptToFile = null;
    public static final DecryptType ReEncryptKey = null;

    private static final /* synthetic */ DecryptType[] $values() {
        return new DecryptType[]{DecryptToFile, ReEncryptKey};
    }

    static {
        DecryptToFile = new DecryptType("DecryptToFile", 0);
        ReEncryptKey = new DecryptType("ReEncryptKey", 1);
        $VALUES = $values();
    }

    private DecryptType(String r10, int r11) {
        super(r10, r11);
    }

    public static DecryptType valueOf(String r10) {
        return (DecryptType) Enum.valueOf(DecryptType.class, r10);
    }

    public static DecryptType[] values() {
        return (DecryptType[]) $VALUES.clone();
    }
}
