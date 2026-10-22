package com.obric.oui.constraintlayout.core.widgets.analyzer;

/* JADX INFO: loaded from: classes3.dex */
final enum DependencyNode$Type extends Enum<DependencyNode$Type> {
    public static final DependencyNode$Type BASELINE = null;
    public static final DependencyNode$Type BOTTOM = null;
    public static final DependencyNode$Type HORIZONTAL_DIMENSION = null;
    public static final DependencyNode$Type LEFT = null;
    public static final DependencyNode$Type RIGHT = null;
    public static final DependencyNode$Type TOP = null;
    public static final DependencyNode$Type UNKNOWN = null;
    public static final DependencyNode$Type VERTICAL_DIMENSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DependencyNode$Type[] f12557a = null;

    static {
        DependencyNode$Type r5 = new DependencyNode$Type("UNKNOWN", 0);
        UNKNOWN = r5;
        DependencyNode$Type r10 = new DependencyNode$Type("HORIZONTAL_DIMENSION", 1);
        HORIZONTAL_DIMENSION = r10;
        DependencyNode$Type r11 = new DependencyNode$Type("VERTICAL_DIMENSION", 2);
        VERTICAL_DIMENSION = r11;
        DependencyNode$Type r12 = new DependencyNode$Type("LEFT", 3);
        LEFT = r12;
        DependencyNode$Type r13 = new DependencyNode$Type("RIGHT", 4);
        RIGHT = r13;
        DependencyNode$Type r14 = new DependencyNode$Type("TOP", 5);
        TOP = r14;
        DependencyNode$Type r15 = new DependencyNode$Type("BOTTOM", 6);
        BOTTOM = r15;
        DependencyNode$Type r16 = new DependencyNode$Type("BASELINE", 7);
        BASELINE = r16;
        f12557a = new DependencyNode$Type[]{r5, r10, r11, r12, r13, r14, r15, r16};
    }

    public static DependencyNode$Type valueOf(String r5) {
        return (DependencyNode$Type) Enum.valueOf(DependencyNode$Type.class, r5);
    }

    public static DependencyNode$Type[] values() {
        return (DependencyNode$Type[]) f12557a.clone();
    }
}
