package com.bytedance.ies.abmock;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SaveConfigType {

    public static final enum ConfigType extends Enum<ConfigType> {
        private static final /* synthetic */ ConfigType[] $VALUES = null;
        public static final ConfigType BOOLEAN = null;
        public static final ConfigType DOUBLE = null;
        public static final ConfigType FLOAT = null;
        public static final ConfigType INT = null;
        public static final ConfigType LONG = null;
        public static final ConfigType OBJECT = null;
        public static final ConfigType STRING = null;
        public static final ConfigType STRING_ARRAY = null;

        static {
            ConfigType r0 = new ConfigType("BOOLEAN", 0);
            BOOLEAN = r0;
            ConfigType r1 = new ConfigType("INT", 1);
            INT = r1;
            ConfigType r3 = new ConfigType("LONG", 2);
            LONG = r3;
            ConfigType r5 = new ConfigType("DOUBLE", 3);
            DOUBLE = r5;
            ConfigType r7 = new ConfigType("FLOAT", 4);
            FLOAT = r7;
            ConfigType r9 = new ConfigType("STRING", 5);
            STRING = r9;
            ConfigType r11 = new ConfigType("STRING_ARRAY", 6);
            STRING_ARRAY = r11;
            ConfigType r13 = new ConfigType("OBJECT", 7);
            OBJECT = r13;
            $VALUES = new ConfigType[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private ConfigType(String r1, int r2) {
            super(r1, r2);
        }

        public static ConfigType valueOf(String r2) {
            return (ConfigType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ConfigType.class, r2), ConfigType.class, "com.obric.memorydata.plugin");
        }

        public static ConfigType[] values() {
            return (ConfigType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ConfigType[].class, "com.obric.memorydata.plugin");
        }
    }
}
