package com.obric.cae.location.geosdk.poi;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7219a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f7220b = null;
    public static final c c = null;
    public static final c d = null;
    public static final c e = null;
    public static final /* synthetic */ c[] f = null;

    static {
        c r0 = new c("DETECT_STOPPED", 0);
        f7219a = r0;
        c r1 = new c("INSIDE_AREA", 1);
        f7220b = r1;
        c r3 = new c("MONITORING", 2);
        c = r3;
        c r5 = new c("ENERGY_SAVING_SIT", 3);
        d = r5;
        c r7 = new c("ENERGY_SAVING_WALK", 4);
        e = r7;
        f = new c[]{r0, r1, r3, r5, r7};
    }

    public c(String r1, int r2) {
        super(r1, r2);
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.memorydata.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f.clone(), c[].class, "com.obric.memorydata.plugin");
    }
}
