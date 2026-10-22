package com.lynx.animax.property;

import ai.j0;
import com.lynx.animax.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class AnimaXValueParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f9685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Double f9687c;
    public final Boolean d;
    public final a e;
    public final Integer f;

    public static final enum Type extends Enum<Type> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Type f9688a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Type f9689b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Type f9690c = null;
        public static final Type d = null;
        public static final Type e = null;
        public static final Type f = null;
        public static final /* synthetic */ Type[] g = null;

        static {
            Type r5 = new Type("STRING", 0);
            f9688a = r5;
            Type r10 = new Type("NUMBER", 1);
            f9689b = r10;
            Type r11 = new Type("BOOLEAN", 2);
            f9690c = r11;
            Type r12 = new Type("COORDINATE", 3);
            d = r12;
            Type r13 = new Type("COLOR", 4);
            e = r13;
            Type r14 = new Type("COLOR_FILTER", 5);
            f = r14;
            g = new Type[]{r5, r10, r11, r12, r13, r14, new Type("NULL", 6)};
        }

        public Type(String r5, int r10) {
            super(r5, r10);
        }

        public static Type valueOf(String r5) {
            return (Type) Enum.valueOf(Type.class, r5);
        }

        public static Type[] values() {
            return (Type[]) g.clone();
        }
    }

    public AnimaXValueParam(Type r5, String r10, Double r11, Boolean r12, a r13, Integer r14) {
        this.f9685a = r5;
        this.f9686b = r10;
        this.f9687c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @CalledByNative
    public static AnimaXValueParam fromBoolean(boolean r10) {
        return new AnimaXValueParam(Type.f9690c, null, null, Boolean.valueOf(r10), null, null);
    }

    @CalledByNative
    public static AnimaXValueParam fromColor(int r10) {
        return new AnimaXValueParam(Type.e, null, null, null, null, Integer.valueOf(r10));
    }

    @CalledByNative
    public static AnimaXValueParam fromColorFilter(int r10, int r11) {
        return new AnimaXValueParam(Type.f, null, Double.valueOf(r11), null, null, Integer.valueOf(r10));
    }

    @CalledByNative
    public static AnimaXValueParam fromCoordinate(double r15, double r17, double r19) {
        return new AnimaXValueParam(Type.d, null, null, null, new a(r15, r17, r19), null);
    }

    @CalledByNative
    public static AnimaXValueParam fromNumber(double r10) {
        return new AnimaXValueParam(Type.f9689b, null, Double.valueOf(r10), null, null, null);
    }

    @CalledByNative
    public static AnimaXValueParam fromString(String r10) {
        return new AnimaXValueParam(Type.f9688a, r10, null, null, null, null);
    }

    @CalledByNative
    public boolean getBooleanValue() {
        Boolean r5 = this.d;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.booleanValue();
    }

    @CalledByNative
    public int getColorValue() {
        Type r5 = Type.e;
        Type r10 = this.f9685a;
        if (r10 != r5) goto L6;
    L7:
        Integer r11 = this.f;
        if (r11 != null) goto L10;
    L11:
        return 0;
    L10:
        return r11.intValue();
    L6:
        if (r10 != Type.f) goto L11;
        goto L7
    }

    @CalledByNative
    public int getFilterMode() {
        if (this.f9685a == Type.f) goto L5;
        return 0;
    L5:
        return (int) getNumberValue();
    }

    @CalledByNative
    public double getNumberValue() {
        Double r5 = this.f9687c;
        if (r5 != null) goto L5;
        return 0.0d;
    L5:
        return r5.doubleValue();
    }

    @CalledByNative
    public String getStringValue() {
        return this.f9686b;
    }

    @CalledByNative
    public int getTargetFrame() {
        return -1;
    }

    @CalledByNative
    public int getTypeIndex() {
        return this.f9685a.ordinal();
    }

    @CalledByNative
    public double getX() {
        a r5 = this.e;
        if (r5 != null) goto L5;
        return 0.0d;
    L5:
        return r5.f9691a;
    }

    @CalledByNative
    public double getY() {
        a r5 = this.e;
        if (r5 != null) goto L5;
        return 0.0d;
    L5:
        return r5.f9692b;
    }

    @CalledByNative
    public double getZ() {
        a r5 = this.e;
        if (r5 != null) goto L5;
        return 0.0d;
    L5:
        return r5.f9693c;
    }

    public final String toString() {
        int r5 = getTargetFrame();
        switch(this.f9685a.ordinal()) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L4;
        };
    L4:
        return "AnimaXValueParam{unknown}";
    L12:
        StringBuilder r10 = new StringBuilder("AnimaXValueParam{coordinateValue=(");
        r10.append(getX());
        r10.append(",");
        r10.append(getY());
        r10.append(",");
        r10.append(getZ());
        r10.append("), targetFrame=");
        return androidx.constraintlayout.motion.widget.a.s(r10, r5, "}");
    L7:
        return j0.h(r5, "AnimaXValueParam{null, targetFrame=", "}");
    L9:
        return "AnimaXValueParam{colorValue=" + getColorValue() + ", mode=" + getNumberValue() + ", targetFrame=" + r5 + "}";
    L11:
        return "AnimaXValueParam{colorValue=" + getColorValue() + ", targetFrame=" + r5 + "}";
    L15:
        return "AnimaXValueParam{booleanValue=" + getBooleanValue() + ", targetFrame=" + r5 + "}";
    L17:
        return "AnimaXValueParam{numberValue=" + getNumberValue() + ", targetFrame=" + r5 + "}";
    L19:
        return "AnimaXValueParam{stringValue='" + this.f9686b + "', targetFrame=" + r5 + "}";
    }
}
