package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f9790c = null;
    public static final c d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PreserveAspectRatio$Alignment f9791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PreserveAspectRatio$Scale f9792b;

    static {
        f9790c = new c(PreserveAspectRatio$Alignment.f9729a, null);
        d = new c(PreserveAspectRatio$Alignment.f, PreserveAspectRatio$Scale.f9736a);
    }

    public c(PreserveAspectRatio$Alignment r5, PreserveAspectRatio$Scale r10) {
        this.f9791a = r5;
        this.f9792b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (c.class == r5.getClass()) goto L11;
        return false;
    L11:
        c r10 = (c) r5;
        if (this.f9791a == r10.f9791a) goto L14;
    L16:
        return false;
    L14:
        if (this.f9792b != r10.f9792b) goto L16;
        return true;
    }

    public final String toString() {
        return this.f9791a + " " + this.f9792b;
    }
}
