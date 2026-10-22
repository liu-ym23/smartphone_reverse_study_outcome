package com.obric.aikernel.res.update;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f5187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f5188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f5189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f5190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f5191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f5192i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f5193j;

    public h(String r10, int r11, int r12, long r13, long r14, long r15, int r16, String r17, String r18, String r19) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r17, "modelVersion");
        Intrinsics.checkNotNullParameter(r18, "bizName");
        Intrinsics.checkNotNullParameter(r19, "loraType");
        this.f5184a = r10;
        this.f5185b = r11;
        this.f5186c = r12;
        this.f5187d = r13;
        this.f5188e = r14;
        this.f5189f = r15;
        this.f5190g = r16;
        this.f5191h = r17;
        this.f5192i = r18;
        this.f5193j = r19;
    }

    public final String a() {
        return this.f5192i;
    }

    public final long b() {
        return this.f5188e;
    }

    public final long c() {
        return this.f5187d;
    }

    public final int d() {
        return this.f5186c;
    }

    public final int e() {
        return this.f5190g;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof h) == true) goto L8;
        return false;
    L8:
        h r11 = (h) r10;
        if (Intrinsics.areEqual(this.f5184a, r11.f5184a) == true) goto L12;
        return false;
    L12:
        if (this.f5185b == r11.f5185b) goto L15;
        return false;
    L15:
        if (this.f5186c == r11.f5186c) goto L18;
        return false;
    L18:
        if (this.f5187d == r11.f5187d) goto L21;
        return false;
    L21:
        if (this.f5188e == r11.f5188e) goto L24;
        return false;
    L24:
        if (this.f5189f == r11.f5189f) goto L27;
        return false;
    L27:
        if (this.f5190g == r11.f5190g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f5191h, r11.f5191h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f5192i, r11.f5192i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f5193j, r11.f5193j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final String f() {
        return this.f5193j;
    }

    public final String g() {
        return this.f5184a;
    }

    public final String h() {
        return this.f5191h;
    }

    public int hashCode() {
        return (((((((((((((((((this.f5184a.hashCode() * 31) + Integer.hashCode(this.f5185b)) * 31) + Integer.hashCode(this.f5186c)) * 31) + Long.hashCode(this.f5187d)) * 31) + Long.hashCode(this.f5188e)) * 31) + Long.hashCode(this.f5189f)) * 31) + Integer.hashCode(this.f5190g)) * 31) + this.f5191h.hashCode()) * 31) + this.f5192i.hashCode()) * 31) + this.f5193j.hashCode();
    }

    public final long i() {
        return this.f5189f;
    }

    public final int j() {
        return this.f5185b;
    }

    public String toString() {
        return "ModelDownloadResult(modelName=" + this.f5184a + ", status=" + this.f5185b + ", failureReason=" + this.f5186c + ", duration=" + this.f5187d + ", downloadDuration=" + this.f5188e + ", pauseDuration=" + this.f5189f + ", foreground=" + this.f5190g + ", modelVersion=" + this.f5191h + ", bizName=" + this.f5192i + ", loraType=" + this.f5193j + ')';
    }
}
