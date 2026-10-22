package com.tom_roush.fontbox.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class x extends ah {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16020b;

    x(ad r1) {
        super(r1);
    }

    public b a() {
        if (this.f16020b == false) goto L7;
        return (b) ZeusTransformUtils.preCheckCast(c("CFF "), b.class, "com.obric.memorydata.plugin");
    L7:
        throw new UnsupportedOperationException("TTF fonts do not have a CFF table");
    }

    @Override // com.tom_roush.fontbox.f.ah
    void a(float r3) {
        if (Float.floatToIntBits(r3) != 1184802985) goto L5;
        boolean r0 = true;
    L6:
        this.f16020b = r0;
        super.a(r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.tom_roush.fontbox.f.ah
    public j e() {
        if (this.f16020b == true) goto L7;
        return super.e();
    L7:
        throw new UnsupportedOperationException("OTF fonts do not have a glyf table");
    }

    public boolean f() {
        return this.f15978a.containsKey("CFF ");
    }
}
