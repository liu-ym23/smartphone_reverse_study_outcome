package com.obric.oui.constraintlayout.core.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class CLToken extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Type f13594a;

    static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type FALSE = null;
        public static final Type NULL = null;
        public static final Type TRUE = null;
        public static final Type UNKNOWN = null;

        static {
            Type r0 = new Type("UNKNOWN", 0);
            UNKNOWN = r0;
            Type r1 = new Type("TRUE", 1);
            TRUE = r1;
            Type r3 = new Type("FALSE", 2);
            FALSE = r3;
            Type r5 = new Type("NULL", 3);
            NULL = r5;
            $VALUES = new Type[]{r0, r1, r3, r5};
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

    public Type getType() {
        return this.f13594a;
    }
}
