package com.lynx.tasm.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class SizeValue {
    public final float a;
    public final Type b;

    public static final enum Type extends Enum<Type> {
        public static final Type DEVICE_PX = null;
        public static final Type PERCENTAGE = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r0 = new Type("UNKNOWN", 0);
            UNKNOWN = r0;
            Type r1 = new Type("PERCENTAGE", 1);
            PERCENTAGE = r1;
            Type r3 = new Type("DEVICE_PX", 2);
            DEVICE_PX = r3;
            a = new Type[]{r0, r1, r3};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public SizeValue() {
        this.b = Type.UNKNOWN;
        this.a = 0.0f;
    }

    public static SizeValue b(String r3) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L6:
        if (r0 <= 1) goto L12;
        if (r3.endsWith("%") == false) goto L12;
        float r4 = n.a(r3, 0.0f);
        return new SizeValue(Type.PERCENTAGE, r4);
    L12:
        if (r0 > 2) goto L14;
        return null;
    L14:
        if (r3.endsWith("px") == false) goto L19;
        float r5 = n.a(r3, 0.0f);
        return new SizeValue(Type.DEVICE_PX, r5);
    L19:
        return null;
    L4:
        r0 = r3.length();
        goto L6
    }

    public final float a(float r3) {
        Type r0 = this.b;
        if (r0 != Type.PERCENTAGE) goto L7;
        return this.a * r3;
    L7:
        if (r0 == Type.DEVICE_PX) goto L9;
        return 0.0f;
    L9:
        return this.a;
    }

    public SizeValue(Type r1, float r2) {
        this.b = r1;
        this.a = r2;
    }
}
