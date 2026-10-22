package com.obric.cae.location.geosdk.poi;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ d[] f7221a = null;

    static {
        f7221a = new d[]{new d("ENTRY_CANDIDATE", 0), new d("WIFI_IDENTITY_VERIFY", 1)};
    }

    public d(String r1, int r2) {
        super(r1, r2);
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.memorydata.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(f7221a.clone(), d[].class, "com.obric.memorydata.plugin");
    }
}
