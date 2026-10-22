package com.obric.oui.constraintlayout.core.widgets.analyzer;

/* JADX INFO: loaded from: classes3.dex */
final enum WidgetRun$RunType extends Enum<WidgetRun$RunType> {
    public static final WidgetRun$RunType CENTER = null;
    public static final WidgetRun$RunType END = null;
    public static final WidgetRun$RunType NONE = null;
    public static final WidgetRun$RunType START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WidgetRun$RunType[] f12558a = null;

    static {
        WidgetRun$RunType r5 = new WidgetRun$RunType("NONE", 0);
        NONE = r5;
        WidgetRun$RunType r10 = new WidgetRun$RunType("START", 1);
        START = r10;
        WidgetRun$RunType r11 = new WidgetRun$RunType("END", 2);
        END = r11;
        WidgetRun$RunType r12 = new WidgetRun$RunType("CENTER", 3);
        CENTER = r12;
        f12558a = new WidgetRun$RunType[]{r5, r10, r11, r12};
    }

    public static WidgetRun$RunType valueOf(String r5) {
        return (WidgetRun$RunType) Enum.valueOf(WidgetRun$RunType.class, r5);
    }

    public static WidgetRun$RunType[] values() {
        return (WidgetRun$RunType[]) f12558a.clone();
    }
}
