package com.loc;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends bo {
    public final byte[] k;
    public final Map<String, String> l;

    @Override // com.loc.bo
    public final Map<String, String> a() {
        return null;
    }

    @Override // com.loc.bo
    public final String c() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.loc.bo
    public final Map<String, String> h() {
        return this.l;
    }

    @Override // com.loc.bo
    public final byte[] i() {
        return this.k;
    }

    public b(byte[] r1, Map<String, String> r2) {
        this.k = r1;
        this.l = r2;
        this.i = bo.a.e;
        b(bo.c.b);
    }
}
