package com.loc;

import com.bytedance.apm6.util.constant.NetConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends fs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f5620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5621b;

    public p(byte[] r3, String r4) {
        this.f5621b = "1";
        this.f5620a = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        this.f5621b = r4;
        a(bo.a.e);
        a(bo.c.f5373a);
    }

    @Override // com.loc.bo
    public final Map<String, String> a() {
        HashMap r0 = new HashMap();
        r0.put(NetConst.KEY_CONTENT_TYPE, "application/zip");
        r0.put("Content-Length", String.valueOf(this.f5620a.length));
        return r0;
    }

    @Override // com.loc.bo
    public final Map<String, String> b() {
        return null;
    }

    @Override // com.loc.bo
    public final String c() {
        String r0 = fx.c(b.f5344b);
        byte[] r3 = fx.a(b.f5343a);
        byte[] r4 = new byte[r3.length + 50];
        System.arraycopy(this.f5620a, 0, r4, 0, 50);
        System.arraycopy(r3, 0, r4, 50, r3.length);
        return String.format(r0, new Object[]{"1", this.f5621b, "1", "open", ft.a(r4)});
    }

    @Override // com.loc.bo
    public final byte[] d() {
        return this.f5620a;
    }

    @Override // com.loc.bo
    public final boolean e() {
        return false;
    }
}
