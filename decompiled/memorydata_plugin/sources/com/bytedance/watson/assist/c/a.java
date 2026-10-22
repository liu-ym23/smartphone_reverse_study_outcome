package com.bytedance.watson.assist.c;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f3379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3380b;
    private File c;

    public a(String r2) {
        this.f3379a = null;
        this.f3380b = null;
        this.c = null;
        this.f3380b = r2;
    }

    public b a() {
        if (this.f3380b != null) goto L7;
        com.bytedance.watson.assist.d.b.c("refresh and path null");
        return null;
    L7:
        if (this.c != null) goto L9;
        this.c = new File(this.f3380b);
    L9:
        b r0 = a(this.c);
        this.f3379a = r0;
        return r0;
    }

    public b a(File r1) {
        return null;
    }

    public String toString() {
        return "BaseStatFile{mPath='" + this.f3380b + "', mFile=" + this.c + ", mLastInfo=" + this.f3379a + '}';
    }
}
