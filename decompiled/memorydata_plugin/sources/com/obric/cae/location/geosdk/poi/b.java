package com.obric.cae.location.geosdk.poi;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f7218b = null;
    public static final b c = null;
    public static final /* synthetic */ b[] d = null;

    static {
        b r0 = new b("UNKNOWN", 0);
        f7217a = r0;
        b r1 = new b("SITTABLE", 1);
        f7218b = r1;
        b r3 = new b("WALKABLE", 2);
        c = r3;
        d = new b[]{r0, r1, r3};
    }

    public b(String r1, int r2) {
        super(r1, r2);
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.memorydata.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(d.clone(), b[].class, "com.obric.memorydata.plugin");
    }
}
