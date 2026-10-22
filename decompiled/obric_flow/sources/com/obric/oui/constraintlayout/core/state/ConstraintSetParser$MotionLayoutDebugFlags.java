package com.obric.oui.constraintlayout.core.state;

/* JADX INFO: loaded from: classes3.dex */
public final enum ConstraintSetParser$MotionLayoutDebugFlags extends Enum<ConstraintSetParser$MotionLayoutDebugFlags> {
    public static final ConstraintSetParser$MotionLayoutDebugFlags NONE = null;
    public static final ConstraintSetParser$MotionLayoutDebugFlags SHOW_ALL = null;
    public static final ConstraintSetParser$MotionLayoutDebugFlags UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConstraintSetParser$MotionLayoutDebugFlags[] f12548a = null;

    static {
        ConstraintSetParser$MotionLayoutDebugFlags r5 = new ConstraintSetParser$MotionLayoutDebugFlags("NONE", 0);
        NONE = r5;
        ConstraintSetParser$MotionLayoutDebugFlags r10 = new ConstraintSetParser$MotionLayoutDebugFlags("SHOW_ALL", 1);
        SHOW_ALL = r10;
        ConstraintSetParser$MotionLayoutDebugFlags r11 = new ConstraintSetParser$MotionLayoutDebugFlags("UNKNOWN", 2);
        UNKNOWN = r11;
        f12548a = new ConstraintSetParser$MotionLayoutDebugFlags[]{r5, r10, r11};
    }

    public static ConstraintSetParser$MotionLayoutDebugFlags valueOf(String r5) {
        return (ConstraintSetParser$MotionLayoutDebugFlags) Enum.valueOf(ConstraintSetParser$MotionLayoutDebugFlags.class, r5);
    }

    public static ConstraintSetParser$MotionLayoutDebugFlags[] values() {
        return (ConstraintSetParser$MotionLayoutDebugFlags[]) f12548a.clone();
    }
}
