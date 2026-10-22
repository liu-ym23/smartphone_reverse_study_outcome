package com.airbnb.lottie.model.layer;

/* JADX INFO: loaded from: classes.dex */
public final enum Layer$LayerType extends Enum<Layer$LayerType> {
    public static final Layer$LayerType IMAGE = null;
    public static final Layer$LayerType NULL = null;
    public static final Layer$LayerType PRE_COMP = null;
    public static final Layer$LayerType SHAPE = null;
    public static final Layer$LayerType SOLID = null;
    public static final Layer$LayerType TEXT = null;
    public static final Layer$LayerType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Layer$LayerType[] f1291a = null;

    static {
        Layer$LayerType r5 = new Layer$LayerType("PRE_COMP", 0);
        PRE_COMP = r5;
        Layer$LayerType r10 = new Layer$LayerType("SOLID", 1);
        SOLID = r10;
        Layer$LayerType r11 = new Layer$LayerType("IMAGE", 2);
        IMAGE = r11;
        Layer$LayerType r12 = new Layer$LayerType("NULL", 3);
        NULL = r12;
        Layer$LayerType r13 = new Layer$LayerType("SHAPE", 4);
        SHAPE = r13;
        Layer$LayerType r14 = new Layer$LayerType("TEXT", 5);
        TEXT = r14;
        Layer$LayerType r15 = new Layer$LayerType("UNKNOWN", 6);
        UNKNOWN = r15;
        f1291a = new Layer$LayerType[]{r5, r10, r11, r12, r13, r14, r15};
    }

    public static Layer$LayerType valueOf(String r5) {
        return (Layer$LayerType) Enum.valueOf(Layer$LayerType.class, r5);
    }

    public static Layer$LayerType[] values() {
        return (Layer$LayerType[]) f1291a.clone();
    }
}
