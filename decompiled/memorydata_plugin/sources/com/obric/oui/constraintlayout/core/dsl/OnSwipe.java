package com.obric.oui.constraintlayout.core.dsl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class OnSwipe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drag f13544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Side f13545b;
    private String c;
    private String d;
    private TouchUp e;
    private String f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private Boundary o;
    private Mode p;

    public static final enum Boundary extends Enum<Boundary> {
        private static final /* synthetic */ Boundary[] $VALUES = null;
        public static final Boundary BOUNCE_BOTH = null;
        public static final Boundary BOUNCE_END = null;
        public static final Boundary BOUNCE_START = null;
        public static final Boundary OVERSHOOT = null;

        static {
            Boundary r0 = new Boundary("OVERSHOOT", 0);
            OVERSHOOT = r0;
            Boundary r1 = new Boundary("BOUNCE_START", 1);
            BOUNCE_START = r1;
            Boundary r3 = new Boundary("BOUNCE_END", 2);
            BOUNCE_END = r3;
            Boundary r5 = new Boundary("BOUNCE_BOTH", 3);
            BOUNCE_BOTH = r5;
            $VALUES = new Boundary[]{r0, r1, r3, r5};
        }

        private Boundary(String r1, int r2) {
            super(r1, r2);
        }

        public static Boundary valueOf(String r2) {
            return (Boundary) ZeusTransformUtils.preCheckCast(Enum.valueOf(Boundary.class, r2), Boundary.class, "com.obric.memorydata.plugin");
        }

        public static Boundary[] values() {
            return (Boundary[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Boundary[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Drag extends Enum<Drag> {
        private static final /* synthetic */ Drag[] $VALUES = null;
        public static final Drag ANTICLOCKWISE = null;
        public static final Drag CLOCKWISE = null;
        public static final Drag DOWN = null;
        public static final Drag END = null;
        public static final Drag LEFT = null;
        public static final Drag RIGHT = null;
        public static final Drag START = null;
        public static final Drag UP = null;

        static {
            Drag r0 = new Drag("UP", 0);
            UP = r0;
            Drag r1 = new Drag("DOWN", 1);
            DOWN = r1;
            Drag r3 = new Drag("LEFT", 2);
            LEFT = r3;
            Drag r5 = new Drag("RIGHT", 3);
            RIGHT = r5;
            Drag r7 = new Drag("START", 4);
            START = r7;
            Drag r9 = new Drag("END", 5);
            END = r9;
            Drag r11 = new Drag("CLOCKWISE", 6);
            CLOCKWISE = r11;
            Drag r13 = new Drag("ANTICLOCKWISE", 7);
            ANTICLOCKWISE = r13;
            $VALUES = new Drag[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private Drag(String r1, int r2) {
            super(r1, r2);
        }

        public static Drag valueOf(String r2) {
            return (Drag) ZeusTransformUtils.preCheckCast(Enum.valueOf(Drag.class, r2), Drag.class, "com.obric.memorydata.plugin");
        }

        public static Drag[] values() {
            return (Drag[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Drag[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode SPRING = null;
        public static final Mode VELOCITY = null;

        static {
            Mode r0 = new Mode("VELOCITY", 0);
            VELOCITY = r0;
            Mode r1 = new Mode("SPRING", 1);
            SPRING = r1;
            $VALUES = new Mode[]{r0, r1};
        }

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static Mode valueOf(String r2) {
            return (Mode) ZeusTransformUtils.preCheckCast(Enum.valueOf(Mode.class, r2), Mode.class, "com.obric.memorydata.plugin");
        }

        public static Mode[] values() {
            return (Mode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Mode[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Side extends Enum<Side> {
        private static final /* synthetic */ Side[] $VALUES = null;
        public static final Side BOTTOM = null;
        public static final Side END = null;
        public static final Side LEFT = null;
        public static final Side MIDDLE = null;
        public static final Side RIGHT = null;
        public static final Side START = null;
        public static final Side TOP = null;

        static {
            Side r0 = new Side("TOP", 0);
            TOP = r0;
            Side r1 = new Side("LEFT", 1);
            LEFT = r1;
            Side r3 = new Side("RIGHT", 2);
            RIGHT = r3;
            Side r5 = new Side("BOTTOM", 3);
            BOTTOM = r5;
            Side r7 = new Side("MIDDLE", 4);
            MIDDLE = r7;
            Side r9 = new Side("START", 5);
            START = r9;
            Side r11 = new Side("END", 6);
            END = r11;
            $VALUES = new Side[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private Side(String r1, int r2) {
            super(r1, r2);
        }

        public static Side valueOf(String r2) {
            return (Side) ZeusTransformUtils.preCheckCast(Enum.valueOf(Side.class, r2), Side.class, "com.obric.memorydata.plugin");
        }

        public static Side[] values() {
            return (Side[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Side[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum TouchUp extends Enum<TouchUp> {
        private static final /* synthetic */ TouchUp[] $VALUES = null;
        public static final TouchUp AUTOCOMPLETE = null;
        public static final TouchUp DECELERATE = null;
        public static final TouchUp DECELERATE_COMPLETE = null;
        public static final TouchUp NEVER_COMPLETE_END = null;
        public static final TouchUp NEVER_COMPLETE_START = null;
        public static final TouchUp STOP = null;
        public static final TouchUp TO_END = null;
        public static final TouchUp TO_START = null;

        static {
            TouchUp r0 = new TouchUp("AUTOCOMPLETE", 0);
            AUTOCOMPLETE = r0;
            TouchUp r1 = new TouchUp("TO_START", 1);
            TO_START = r1;
            TouchUp r3 = new TouchUp("NEVER_COMPLETE_END", 2);
            NEVER_COMPLETE_END = r3;
            TouchUp r5 = new TouchUp("TO_END", 3);
            TO_END = r5;
            TouchUp r7 = new TouchUp("STOP", 4);
            STOP = r7;
            TouchUp r9 = new TouchUp("DECELERATE", 5);
            DECELERATE = r9;
            TouchUp r11 = new TouchUp("DECELERATE_COMPLETE", 6);
            DECELERATE_COMPLETE = r11;
            TouchUp r13 = new TouchUp("NEVER_COMPLETE_START", 7);
            NEVER_COMPLETE_START = r13;
            $VALUES = new TouchUp[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private TouchUp(String r1, int r2) {
            super(r1, r2);
        }

        public static TouchUp valueOf(String r2) {
            return (TouchUp) ZeusTransformUtils.preCheckCast(Enum.valueOf(TouchUp.class, r2), TouchUp.class, "com.obric.memorydata.plugin");
        }

        public static TouchUp[] values() {
            return (TouchUp[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TouchUp[].class, "com.obric.memorydata.plugin");
        }
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("OnSwipe:{\n");
        if (this.c == null) goto L6;
        r0.append("anchor:'").append(this.c).append("',\n");
    L6:
        if (this.f13544a == null) goto L9;
        r0.append("direction:'").append(this.f13544a.toString().toLowerCase()).append("',\n");
    L9:
        if (this.f13545b == null) goto L12;
        r0.append("side:'").append(this.f13545b.toString().toLowerCase()).append("',\n");
    L12:
        if (Float.isNaN(this.i) == true) goto L15;
        r0.append("scale:'").append(this.i).append("',\n");
    L15:
        if (Float.isNaN(this.j) == true) goto L18;
        r0.append("threshold:'").append(this.j).append("',\n");
    L18:
        if (Float.isNaN(this.g) == true) goto L21;
        r0.append("maxVelocity:'").append(this.g).append("',\n");
    L21:
        if (Float.isNaN(this.h) == true) goto L24;
        r0.append("maxAccel:'").append(this.h).append("',\n");
    L24:
        if (this.d == null) goto L27;
        r0.append("limitBounds:'").append(this.d).append("',\n");
    L27:
        if (this.p == null) goto L30;
        r0.append("mode:'").append(this.p.toString().toLowerCase()).append("',\n");
    L30:
        if (this.e == null) goto L33;
        r0.append("touchUp:'").append(this.e.toString().toLowerCase()).append("',\n");
    L33:
        if (Float.isNaN(this.l) == true) goto L36;
        r0.append("springMass:'").append(this.l).append("',\n");
    L36:
        if (Float.isNaN(this.m) == true) goto L39;
        r0.append("springStiffness:'").append(this.m).append("',\n");
    L39:
        if (Float.isNaN(this.k) == true) goto L42;
        r0.append("springDamping:'").append(this.k).append("',\n");
    L42:
        if (Float.isNaN(this.n) == true) goto L45;
        r0.append("stopThreshold:'").append(this.n).append("',\n");
    L45:
        if (this.o == null) goto L48;
        r0.append("springBoundary:'").append(this.o).append("',\n");
    L48:
        if (this.f == null) goto L50;
        r0.append("around:'").append(this.f).append("',\n");
    L50:
        r0.append("},\n");
        return r0.toString();
    }
}
