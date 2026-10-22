package com.obric.oui.constraintlayout.core.state;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Dimension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f13598a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f13599b = null;
    public static final Object c = null;
    public static final Object d = null;
    public static final Object e = null;
    public static final Object f = null;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type FIXED = null;
        public static final Type MATCH_CONSTRAINT = null;
        public static final Type MATCH_PARENT = null;
        public static final Type WRAP = null;

        static {
            Type r0 = new Type("FIXED", 0);
            FIXED = r0;
            Type r1 = new Type("WRAP", 1);
            WRAP = r1;
            Type r3 = new Type("MATCH_PARENT", 2);
            MATCH_PARENT = r3;
            Type r5 = new Type("MATCH_CONSTRAINT", 3);
            MATCH_CONSTRAINT = r5;
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

    static {
        f13598a = new String("FIXED_DIMENSION");
        f13599b = new String("WRAP_DIMENSION");
        c = new String("SPREAD_DIMENSION");
        d = new String("PARENT_DIMENSION");
        e = new String("PERCENT_DIMENSION");
        f = new String("RATIO_DIMENSION");
    }
}
