package com.google.crypto.tink;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyTemplate {

    public static final enum OutputPrefixType extends Enum<OutputPrefixType> {
        private static final /* synthetic */ OutputPrefixType[] $VALUES = null;
        public static final OutputPrefixType CRUNCHY = null;
        public static final OutputPrefixType LEGACY = null;
        public static final OutputPrefixType RAW = null;
        public static final OutputPrefixType TINK = null;

        static {
            OutputPrefixType r0 = new OutputPrefixType("TINK", 0);
            TINK = r0;
            OutputPrefixType r1 = new OutputPrefixType("LEGACY", 1);
            LEGACY = r1;
            OutputPrefixType r3 = new OutputPrefixType("RAW", 2);
            RAW = r3;
            OutputPrefixType r5 = new OutputPrefixType("CRUNCHY", 3);
            CRUNCHY = r5;
            $VALUES = new OutputPrefixType[]{r0, r1, r3, r5};
        }

        private OutputPrefixType(String r1, int r2) {
            super(r1, r2);
        }

        public static OutputPrefixType valueOf(String r2) {
            return (OutputPrefixType) ZeusTransformUtils.preCheckCast(Enum.valueOf(OutputPrefixType.class, r2), OutputPrefixType.class, "com.obric.memorydata.plugin");
        }

        public static OutputPrefixType[] values() {
            return (OutputPrefixType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OutputPrefixType[].class, "com.obric.memorydata.plugin");
        }
    }
}
