package com.lynx.animax.ui;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum ObjectPosition extends Enum<ObjectPosition> {
    public static final ObjectPosition BOTTOM = null;
    public static final ObjectPosition BOTTOM_LEFT = null;
    public static final ObjectPosition BOTTOM_RIGHT = null;
    public static final ObjectPosition CENTER = null;
    public static final ObjectPosition LEFT = null;
    public static final ObjectPosition RIGHT = null;
    public static final ObjectPosition TOP = null;
    public static final ObjectPosition TOP_LEFT = null;
    public static final ObjectPosition TOP_RIGHT = null;
    public static final /* synthetic */ ObjectPosition[] a = null;

    static {
        ObjectPosition r0 = new ObjectPosition("CENTER", 0);
        CENTER = r0;
        ObjectPosition r1 = new ObjectPosition("LEFT", 1);
        LEFT = r1;
        ObjectPosition r3 = new ObjectPosition("RIGHT", 2);
        RIGHT = r3;
        ObjectPosition r5 = new ObjectPosition("TOP", 3);
        TOP = r5;
        ObjectPosition r7 = new ObjectPosition("BOTTOM", 4);
        BOTTOM = r7;
        ObjectPosition r9 = new ObjectPosition("TOP_LEFT", 5);
        TOP_LEFT = r9;
        ObjectPosition r11 = new ObjectPosition("TOP_RIGHT", 6);
        TOP_RIGHT = r11;
        ObjectPosition r13 = new ObjectPosition("BOTTOM_LEFT", 7);
        BOTTOM_LEFT = r13;
        ObjectPosition r15 = new ObjectPosition("BOTTOM_RIGHT", 8);
        BOTTOM_RIGHT = r15;
        a = new ObjectPosition[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
    }

    public static ObjectPosition[] values() {
        return (ObjectPosition[]) a.clone();
    }

    public static ObjectPosition valueOf(String r1) {
        return (ObjectPosition) a.a(ObjectPosition.class, r1);
    }

    public ObjectPosition(String r1, int r2) {
        super(r1, r2);
    }
}
