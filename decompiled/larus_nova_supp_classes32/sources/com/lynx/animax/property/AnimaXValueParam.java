package com.lynx.animax.property;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXValueParam {
    public final Type a;
    public final String b;
    public final Number c;
    public final Boolean d;
    public final b e;
    public final Integer f;
    public final Integer g;

    public static final enum Type extends Enum<Type> {
        public static final Type BOOLEAN = null;
        public static final Type COLOR = null;
        public static final Type COLOR_FILTER = null;
        public static final Type COORDINATE = null;
        public static final Type NULL = null;
        public static final Type NUMBER = null;
        public static final Type STRING = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r0 = new Type("STRING", 0);
            STRING = r0;
            Type r1 = new Type("NUMBER", 1);
            NUMBER = r1;
            Type r3 = new Type("BOOLEAN", 2);
            BOOLEAN = r3;
            Type r5 = new Type("COORDINATE", 3);
            COORDINATE = r5;
            Type r7 = new Type("COLOR", 4);
            COLOR = r7;
            Type r9 = new Type("COLOR_FILTER", 5);
            COLOR_FILTER = r9;
            Type r11 = new Type("NULL", 6);
            NULL = r11;
            a = new Type[]{r0, r1, r3, r5, r7, r9, r11};
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

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Type.values().length];
            a = r0;
            r0[Type.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            a[Type.NUMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            a[Type.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            a[Type.COORDINATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            a[Type.COLOR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            a[Type.COLOR_FILTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            a[Type.NULL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static class b {
        public final double a;
        public final double b;
        public final double c;

        public b(double r1, double r3, double r5) {
            this.a = r1;
            this.b = r3;
            this.c = r5;
        }
    }

    public boolean getBooleanValue() {
        Boolean r0 = this.d;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public int getColorValue() {
        Type r0 = this.a;
        boolean r2 = true;
        if (r0 != Type.COLOR) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L14:
        Integer r3 = this.f;
        if (r3 != null) goto L17;
        return 0;
    L17:
        return r3.intValue();
    L8:
        if (r0 == Type.COLOR_FILTER) goto L11;
        r2 = false;
    L11:
        if (r2 == true) goto L14;
        return 0;
    L5:
        r1 = false;
        goto L6
    }

    public int getFilterMode() {
        if (this.a != Type.COLOR_FILTER) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return 0;
    L8:
        return (int) getNumberValue();
    L5:
        r0 = false;
        goto L6
    }

    public double getNumberValue() {
        Number r0 = this.c;
        if (r0 != null) goto L7;
        return 0.0d;
    L7:
        return r0.doubleValue();
    }

    public int getTargetFrame() {
        Integer r0 = this.g;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.intValue();
    }

    public int getTypeIndex() {
        return this.a.ordinal();
    }

    public double getX() {
        b r0 = this.e;
        if (r0 != null) goto L7;
        return 0.0d;
    L7:
        return r0.a;
    }

    public double getY() {
        b r0 = this.e;
        if (r0 != null) goto L7;
        return 0.0d;
    L7:
        return r0.b;
    }

    public double getZ() {
        b r0 = this.e;
        if (r0 != null) goto L7;
        return 0.0d;
    L7:
        return r0.c;
    }

    public final String toString() {
        int r0 = getTargetFrame();
        switch(a.a[this.a.ordinal()]) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            default: goto L4;
        };
    L4:
        return "AnimaXValueParam{unknown}";
    L7:
        return "AnimaXValueParam{null, targetFrame=" + r0 + "}";
    L9:
        return "AnimaXValueParam{colorValue=" + getColorValue() + ", mode=" + getNumberValue() + ", targetFrame=" + r0 + "}";
    L11:
        return "AnimaXValueParam{colorValue=" + getColorValue() + ", targetFrame=" + r0 + "}";
    L13:
        return "AnimaXValueParam{coordinateValue=(" + getX() + "," + getY() + "," + getZ() + "), targetFrame=" + r0 + "}";
    L15:
        return "AnimaXValueParam{booleanValue=" + getBooleanValue() + ", targetFrame=" + r0 + "}";
    L17:
        return "AnimaXValueParam{numberValue=" + getNumberValue() + ", targetFrame=" + r0 + "}";
    L19:
        return "AnimaXValueParam{stringValue='" + this.b + "', targetFrame=" + r0 + "}";
    }

    public String getStringValue() {
        return this.b;
    }

    public static AnimaXValueParam fromBoolean(boolean r8) {
        return new AnimaXValueParam(Type.BOOLEAN, null, null, Boolean.valueOf(r8), null, null);
    }

    public static AnimaXValueParam fromColor(int r8) {
        return new AnimaXValueParam(Type.COLOR, null, null, null, null, Integer.valueOf(r8));
    }

    public static AnimaXValueParam fromNumber(double r8) {
        return new AnimaXValueParam(Type.NUMBER, null, Double.valueOf(r8), null, null, null);
    }

    public static AnimaXValueParam fromString(String r8) {
        return new AnimaXValueParam(Type.STRING, r8, null, null, null, null);
    }

    public static AnimaXValueParam a(double r15, double r17) {
        return new AnimaXValueParam(Type.COORDINATE, null, null, null, new b(r15, r17, 0.0d), null);
    }

    public static AnimaXValueParam fromColorFilter(int r8, int r9) {
        return new AnimaXValueParam(Type.COLOR_FILTER, null, Double.valueOf(r9), null, null, Integer.valueOf(r8));
    }

    public static AnimaXValueParam fromCoordinate(double r15, double r17, double r19) {
        return new AnimaXValueParam(Type.COORDINATE, null, null, null, new b(r15, r17, r19), null);
    }

    public AnimaXValueParam(Type r1, String r2, Number r3, Boolean r4, b r5, Integer r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = null;
    }
}
