package com.bytedance.ug.cloud;

/* JADX INFO: loaded from: classes2.dex */
public class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3350a;

    public n(String r3) {
        this.f3350a = "[UGCloud " + r3 + "]";
    }

    @Override // com.bytedance.ug.cloud.m
    public void a(b r3) {
        int r0 = r3.f;
        String r2 = this.f3350a;
        if (r0 != 0) goto L5;
        a.a(r2, r3.d + ": success  " + r3.e);
        return;
    L5:
        a.b(r2, r3.d + ": " + r3.e + "  action = " + r3);
    }
}
