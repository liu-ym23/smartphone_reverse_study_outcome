package org.bouncycastle.crypto.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public final class DERMacData {

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BILATERALU = null;
        public static final Type BILATERALV = null;
        public static final Type UNILATERALU = null;
        public static final Type UNILATERALV = null;
        private final String enc;

        static {
            Type r0 = new Type("UNILATERALU", 0, "KC_1_U");
            UNILATERALU = r0;
            Type r1 = new Type("UNILATERALV", 1, "KC_1_V");
            UNILATERALV = r1;
            Type r3 = new Type("BILATERALU", 2, "KC_2_U");
            BILATERALU = r3;
            Type r5 = new Type("BILATERALV", 3, "KC_2_V");
            BILATERALV = r5;
            $VALUES = new Type[]{r0, r1, r3, r5};
        }

        private Type(String r1, int r2, String r3) {
            super(r1, r2);
            this.enc = r3;
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
        }

        public byte[] getHeader() {
            return Strings.toByteArray(this.enc);
        }
    }
}
