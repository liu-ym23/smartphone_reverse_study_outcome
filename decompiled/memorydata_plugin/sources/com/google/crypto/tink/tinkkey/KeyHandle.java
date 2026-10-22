package com.google.crypto.tink.tinkkey;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class KeyHandle {

    public static final enum KeyStatusType extends Enum<KeyStatusType> {
        private static final /* synthetic */ KeyStatusType[] $VALUES = null;
        public static final KeyStatusType DESTROYED = null;
        public static final KeyStatusType DISABLED = null;
        public static final KeyStatusType ENABLED = null;

        static {
            KeyStatusType r0 = new KeyStatusType("ENABLED", 0);
            ENABLED = r0;
            KeyStatusType r1 = new KeyStatusType("DISABLED", 1);
            DISABLED = r1;
            KeyStatusType r3 = new KeyStatusType("DESTROYED", 2);
            DESTROYED = r3;
            $VALUES = new KeyStatusType[]{r0, r1, r3};
        }

        private KeyStatusType(String r1, int r2) {
            super(r1, r2);
        }

        public static KeyStatusType valueOf(String r2) {
            return (KeyStatusType) ZeusTransformUtils.preCheckCast(Enum.valueOf(KeyStatusType.class, r2), KeyStatusType.class, "com.obric.memorydata.plugin");
        }

        public static KeyStatusType[] values() {
            return (KeyStatusType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), KeyStatusType[].class, "com.obric.memorydata.plugin");
        }
    }
}
