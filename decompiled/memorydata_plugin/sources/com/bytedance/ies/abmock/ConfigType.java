package com.bytedance.ies.abmock;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ConfigType extends Enum<ConfigType> {
    private static final /* synthetic */ ConfigType[] $VALUES = null;
    public static final ConfigType CONFIG_CENTER = null;
    public static final ConfigType CUSTOM_LOADER = null;
    public static final ConfigType EXP = null;
    public static final ConfigType PRECISE_EXP = null;
    private static final int SERVER_TYPE_CONFIG_CENTER = 2;
    private static final int SERVER_TYPE_CUSTOM_LOADER = 3;
    private static final int SERVER_TYPE_EXP = 0;
    private static final int SERVER_TYPE_PRECISE_EXP = 1;
    public static final ConfigType UNKNOWN = null;

    static {
        ConfigType r0 = new ConfigType("UNKNOWN", 0);
        UNKNOWN = r0;
        ConfigType r1 = new ConfigType("EXP", 1);
        EXP = r1;
        ConfigType r3 = new ConfigType("PRECISE_EXP", 2);
        PRECISE_EXP = r3;
        ConfigType r5 = new ConfigType("CONFIG_CENTER", 3);
        CONFIG_CENTER = r5;
        ConfigType r7 = new ConfigType("CUSTOM_LOADER", 4);
        CUSTOM_LOADER = r7;
        $VALUES = new ConfigType[]{r0, r1, r3, r5, r7};
    }

    private ConfigType(String r1, int r2) {
        super(r1, r2);
    }

    public static ConfigType fromTypeValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return UNKNOWN;
    L12:
        return CUSTOM_LOADER;
    L14:
        return CONFIG_CENTER;
    L16:
        return PRECISE_EXP;
    L18:
        return EXP;
    }

    public static ConfigType valueOf(String r2) {
        return (ConfigType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ConfigType.class, r2), ConfigType.class, "com.obric.memorydata.plugin");
    }

    public static ConfigType[] values() {
        return (ConfigType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ConfigType[].class, "com.obric.memorydata.plugin");
    }
}
