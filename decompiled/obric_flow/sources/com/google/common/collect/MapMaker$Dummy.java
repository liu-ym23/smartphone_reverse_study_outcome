package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
final enum MapMaker$Dummy extends Enum<MapMaker$Dummy> {
    public static final MapMaker$Dummy VALUE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MapMaker$Dummy[] f8848a = null;

    static {
        MapMaker$Dummy r5 = new MapMaker$Dummy("VALUE", 0);
        VALUE = r5;
        f8848a = new MapMaker$Dummy[]{r5};
    }

    public static MapMaker$Dummy valueOf(String r5) {
        return (MapMaker$Dummy) Enum.valueOf(MapMaker$Dummy.class, r5);
    }

    public static MapMaker$Dummy[] values() {
        return (MapMaker$Dummy[]) f8848a.clone();
    }
}
