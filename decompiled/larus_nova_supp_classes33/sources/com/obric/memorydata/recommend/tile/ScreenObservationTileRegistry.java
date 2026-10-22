package com.obric.memorydata.recommend.tile;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class ScreenObservationTileRegistry {
    private static IScreenObservationTileDelegate sDelegate;

    public ScreenObservationTileRegistry() {
    }

    public static void unregisterDelegate() {
        sDelegate = null;
    }

    public static IScreenObservationTileDelegate getDelegate() {
        return sDelegate;
    }

    public static void registerDelegate(IScreenObservationTileDelegate r0) {
        sDelegate = r0;
    }
}
