package com.ss.android.socialbase.downloader.b.a.d;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15266b;

    public h(int r1) {
        this.f15266b = r1;
    }

    public boolean a(boolean r3) {
        int r0 = this.f15265a;
        if (r0 < this.f15266b) goto L7;
        return false;
    L7:
        if (r3 == false) goto L9;
        this.f15265a = r0 + 1;
    L9:
        return true;
    }
}
