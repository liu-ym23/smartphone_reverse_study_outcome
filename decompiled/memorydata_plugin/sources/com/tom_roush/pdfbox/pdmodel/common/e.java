package com.tom_roush.pdfbox.pdmodel.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16183a;

    public e() {
        this.f16183a = new com.tom_roush.pdfbox.a.d();
    }

    public e(com.tom_roush.pdfbox.a.d r1) {
        this.f16183a = r1;
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16183a;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, e.class) == true) goto L9;
        return false;
    L9:
        return this.f16183a.equals(((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.memorydata.plugin")).f16183a);
    }

    public int hashCode() {
        return this.f16183a.hashCode();
    }
}
