package com.facebook.imagepipeline.common;

/* JADX INFO: loaded from: classes2.dex */
public class RotationOptions {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RotationOptions f8054c = null;
    public static final RotationOptions d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8056b;

    static {
        f8054c = new RotationOptions(-1, false);
        d = new RotationOptions(-1, true);
    }

    public RotationOptions(int r5, boolean r10) {
        this.f8055a = r5;
        this.f8056b = r10;
    }

    public final boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof RotationOptions) == true) goto L8;
        return false;
    L8:
        RotationOptions r10 = (RotationOptions) r5;
        if (this.f8055a == r10.f8055a) goto L11;
    L13:
        return false;
    L11:
        if (this.f8056b != r10.f8056b) goto L13;
        return true;
    }

    public final int hashCode() {
        Integer r5 = Integer.valueOf(this.f8055a);
        Boolean r10 = Boolean.valueOf(this.f8056b);
        int r11 = r5.hashCode();
        int r12 = (r11 + 31) * 31;
        return r12 + r10.hashCode();
    }

    public final String toString() {
        return this.f8055a + " defer:" + this.f8056b;
    }
}
