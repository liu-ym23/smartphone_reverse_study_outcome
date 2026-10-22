package org.ehcache.jsr107.config;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract enum ConfigurationElementState extends Enum<ConfigurationElementState> {
    private static final /* synthetic */ ConfigurationElementState[] $VALUES = null;
    public static final ConfigurationElementState DISABLED = null;
    public static final ConfigurationElementState ENABLED = null;
    public static final ConfigurationElementState UNSPECIFIED = null;

    static {
        final String r1 = "UNSPECIFIED";
        final int r2 = 0;
        ConfigurationElementState r0 = new AnonymousClass1(r1, r2);
        UNSPECIFIED = r0;
        final String r3 = "DISABLED";
        final int r4 = 1;
        ConfigurationElementState r5 = new AnonymousClass2(r3, r4);
        DISABLED = r5;
        final String r6 = "ENABLED";
        final int r7 = 2;
        ConfigurationElementState r8 = new AnonymousClass3(r6, r7);
        ENABLED = r8;
        $VALUES = new ConfigurationElementState[]{r0, r5, r8};
    }

    private ConfigurationElementState(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ ConfigurationElementState(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static ConfigurationElementState valueOf(String r2) {
        return (ConfigurationElementState) ZeusTransformUtils.preCheckCast(Enum.valueOf(ConfigurationElementState.class, r2), ConfigurationElementState.class, "com.obric.memorydata.plugin");
    }

    public static ConfigurationElementState[] values() {
        return (ConfigurationElementState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ConfigurationElementState[].class, "com.obric.memorydata.plugin");
    }

    public abstract boolean asBoolean();
}
