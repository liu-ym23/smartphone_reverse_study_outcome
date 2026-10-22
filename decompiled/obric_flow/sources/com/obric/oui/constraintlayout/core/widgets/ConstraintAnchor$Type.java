package com.obric.oui.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes3.dex */
public final enum ConstraintAnchor$Type extends Enum<ConstraintAnchor$Type> {
    public static final ConstraintAnchor$Type BASELINE = null;
    public static final ConstraintAnchor$Type BOTTOM = null;
    public static final ConstraintAnchor$Type CENTER = null;
    public static final ConstraintAnchor$Type CENTER_X = null;
    public static final ConstraintAnchor$Type CENTER_Y = null;
    public static final ConstraintAnchor$Type LEFT = null;
    public static final ConstraintAnchor$Type NONE = null;
    public static final ConstraintAnchor$Type RIGHT = null;
    public static final ConstraintAnchor$Type TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConstraintAnchor$Type[] f12555a = null;

    static {
        ConstraintAnchor$Type r5 = new ConstraintAnchor$Type("NONE", 0);
        NONE = r5;
        ConstraintAnchor$Type r10 = new ConstraintAnchor$Type("LEFT", 1);
        LEFT = r10;
        ConstraintAnchor$Type r11 = new ConstraintAnchor$Type("TOP", 2);
        TOP = r11;
        ConstraintAnchor$Type r12 = new ConstraintAnchor$Type("RIGHT", 3);
        RIGHT = r12;
        ConstraintAnchor$Type r13 = new ConstraintAnchor$Type("BOTTOM", 4);
        BOTTOM = r13;
        ConstraintAnchor$Type r14 = new ConstraintAnchor$Type("BASELINE", 5);
        BASELINE = r14;
        ConstraintAnchor$Type r15 = new ConstraintAnchor$Type("CENTER", 6);
        CENTER = r15;
        ConstraintAnchor$Type r16 = new ConstraintAnchor$Type("CENTER_X", 7);
        CENTER_X = r16;
        ConstraintAnchor$Type r17 = new ConstraintAnchor$Type("CENTER_Y", 8);
        CENTER_Y = r17;
        f12555a = new ConstraintAnchor$Type[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
    }

    public static ConstraintAnchor$Type valueOf(String r5) {
        return (ConstraintAnchor$Type) Enum.valueOf(ConstraintAnchor$Type.class, r5);
    }

    public static ConstraintAnchor$Type[] values() {
        return (ConstraintAnchor$Type[]) f12555a.clone();
    }
}
