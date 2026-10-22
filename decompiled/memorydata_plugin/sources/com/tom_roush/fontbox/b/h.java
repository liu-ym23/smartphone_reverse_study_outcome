package com.tom_roush.fontbox.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class h implements com.tom_roush.fontbox.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f15908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Map<String, Object> f15909b;
    protected b c;
    protected byte[][] d;
    protected byte[][] e;
    private k.a f;

    public h() {
        this.f15909b = new LinkedHashMap();
    }

    void a(b r1) {
        this.c = r1;
    }

    final void a(k.a r3) {
        this.f = (k.a) ZeusTransformUtils.wrapperContextForParams(r3, k.a.class, "com.obric.memorydata.plugin");
    }

    public void a(String r1, Object r2) {
        if (r2 == null) goto L5;
        this.f15909b.put(r1, r2);
        return;
    }

    void a(byte[][] r1) {
        this.e = r1;
    }

    @Override // com.tom_roush.fontbox.b
    public String b() {
        return this.f15908a;
    }

    @Override // com.tom_roush.fontbox.b
    public com.tom_roush.fontbox.g.a c() {
        return new com.tom_roush.fontbox.g.a((List) ZeusTransformUtils.preCheckCast(this.f15909b.get("FontBBox"), List.class, "com.obric.memorydata.plugin"));
    }

    void e(String r1) {
        this.f15908a = r1;
    }

    public b h() {
        return this.c;
    }

    public String toString() {
        return getClass().getSimpleName() + "[name=" + this.f15908a + ", topDict=" + this.f15909b + ", charset=" + this.c + ", charStrings=" + Arrays.deepToString(this.d) + "]";
    }
}
