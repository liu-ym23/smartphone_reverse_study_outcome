package org.apache.commons.csv;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class Token {
    final StringBuilder content;
    boolean isReady;
    Type type;

    static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type COMMENT = null;
        public static final Type EOF = null;
        public static final Type EORECORD = null;
        public static final Type INVALID = null;
        public static final Type TOKEN = null;

        static {
            Type r0 = new Type("INVALID", 0);
            INVALID = r0;
            Type r1 = new Type("TOKEN", 1);
            TOKEN = r1;
            Type r3 = new Type("EOF", 2);
            EOF = r3;
            Type r5 = new Type("EORECORD", 3);
            EORECORD = r5;
            Type r7 = new Type("COMMENT", 4);
            COMMENT = r7;
            $VALUES = new Type[]{r0, r1, r3, r5, r7};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
        }
    }

    Token() {
        this.type = Type.INVALID;
        this.content = new StringBuilder(50);
    }

    void reset() {
        this.content.setLength(0);
        this.type = Type.INVALID;
        this.isReady = false;
    }

    public String toString() {
        return this.type.name() + " [" + this.content.toString() + "]";
    }
}
