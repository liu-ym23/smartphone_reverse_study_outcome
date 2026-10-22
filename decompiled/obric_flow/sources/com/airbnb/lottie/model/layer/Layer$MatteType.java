package com.airbnb.lottie.model.layer;

/* JADX INFO: loaded from: classes.dex */
public final enum Layer$MatteType extends Enum<Layer$MatteType> {
    public static final Layer$MatteType ADD = null;
    public static final Layer$MatteType INVERT = null;
    public static final Layer$MatteType NONE = null;
    public static final Layer$MatteType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Layer$MatteType[] f1292a = null;

    static {
        Layer$MatteType r5 = new Layer$MatteType("NONE", 0);
        NONE = r5;
        Layer$MatteType r10 = new Layer$MatteType("ADD", 1);
        ADD = r10;
        Layer$MatteType r11 = new Layer$MatteType("INVERT", 2);
        INVERT = r11;
        Layer$MatteType r12 = new Layer$MatteType("UNKNOWN", 3);
        UNKNOWN = r12;
        f1292a = new Layer$MatteType[]{r5, r10, r11, r12};
    }

    public static Layer$MatteType valueOf(String r5) {
        return (Layer$MatteType) Enum.valueOf(Layer$MatteType.class, r5);
    }

    public static Layer$MatteType[] values() {
        return (Layer$MatteType[]) f1292a.clone();
    }
}
