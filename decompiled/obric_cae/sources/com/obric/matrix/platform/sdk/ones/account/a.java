package com.obric.matrix.platform.sdk.ones.account;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6109b;

    public a(int r8, String r10) {
        super(null);
        this.f6108a = r8;
        this.f6109b = r10;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "code: " + this.f6108a + ", msg: " + this.f6109b + ", cause: " + getCause();
    }
}
