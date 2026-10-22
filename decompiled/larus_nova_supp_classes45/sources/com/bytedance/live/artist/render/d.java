package com.bytedance.live.artist.render;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[EntityState.values().length];
        a = r0;
        r0[EntityState.Prepared.ordinal()] = 1;
        r0[EntityState.WaitDestroy.ordinal()] = 2;
        r0[EntityState.Destroyed.ordinal()] = 3;
    }
}
