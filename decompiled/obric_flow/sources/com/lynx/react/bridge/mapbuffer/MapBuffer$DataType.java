package com.lynx.react.bridge.mapbuffer;

/* JADX INFO: loaded from: classes2.dex */
public final enum MapBuffer$DataType extends Enum<MapBuffer$DataType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MapBuffer$DataType f9948a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MapBuffer$DataType f9949b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MapBuffer$DataType f9950c = null;
    public static final MapBuffer$DataType d = null;
    public static final MapBuffer$DataType e = null;
    public static final MapBuffer$DataType f = null;
    public static final /* synthetic */ MapBuffer$DataType[] g = null;

    static {
        MapBuffer$DataType r5 = new MapBuffer$DataType("NULL", 0);
        MapBuffer$DataType r10 = new MapBuffer$DataType("BOOL", 1);
        f9948a = r10;
        MapBuffer$DataType r11 = new MapBuffer$DataType("INT", 2);
        f9949b = r11;
        MapBuffer$DataType r12 = new MapBuffer$DataType("LONG", 3);
        f9950c = r12;
        MapBuffer$DataType r13 = new MapBuffer$DataType("DOUBLE", 4);
        d = r13;
        MapBuffer$DataType r14 = new MapBuffer$DataType("STRING", 5);
        e = r14;
        MapBuffer$DataType r15 = new MapBuffer$DataType("ARRAY", 6);
        f = r15;
        g = new MapBuffer$DataType[]{r5, r10, r11, r12, r13, r14, r15};
    }

    public MapBuffer$DataType(String r5, int r10) {
        super(r5, r10);
    }

    public static MapBuffer$DataType valueOf(String r5) {
        return (MapBuffer$DataType) Enum.valueOf(MapBuffer$DataType.class, r5);
    }

    public static MapBuffer$DataType[] values() {
        return (MapBuffer$DataType[]) g.clone();
    }
}
