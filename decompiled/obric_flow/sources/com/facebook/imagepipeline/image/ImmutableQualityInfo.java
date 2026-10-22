package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes2.dex */
public class ImmutableQualityInfo implements QualityInfo {
    public static final ImmutableQualityInfo d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8193c;

    static {
        d = new ImmutableQualityInfo(Integer.MAX_VALUE, true, true);
    }

    public ImmutableQualityInfo(int r5, boolean r10, boolean r11) {
        this.f8191a = r5;
        this.f8192b = r10;
        this.f8193c = r11;
    }

    public final boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImmutableQualityInfo) == true) goto L8;
        return false;
    L8:
        ImmutableQualityInfo r10 = (ImmutableQualityInfo) r5;
        if (this.f8191a == r10.f8191a) goto L11;
    L15:
        return false;
    L11:
        if (this.f8192b != r10.f8192b) goto L15;
        if (this.f8193c != r10.f8193c) goto L15;
        return true;
    }

    public final int hashCode() {
        int r5 = this.f8191a;
        int r10 = 0;
        if (this.f8192b == false) goto L5;
        int r11 = 4194304;
    L6:
        int r12 = r5 ^ r11;
        if (this.f8193c == false) goto L10;
        r10 = 8388608;
    L10:
        return r12 ^ r10;
    L5:
        r11 = 0;
        goto L6
    }
}
