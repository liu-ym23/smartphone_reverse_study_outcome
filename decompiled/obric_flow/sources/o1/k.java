package o1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f20401c;

    public k(boolean r5, String r10, h r11) {
        Intrinsics.checkNotNullParameter(r10, "keyPath");
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        this.f20399a = r5;
        this.f20400b = r10;
        this.f20401c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r10 = (k) r5;
        boolean r11 = r10.f20399a;
        if (this.f20399a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20400b, r10.f20400b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20401c, r10.f20401c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = Boolean.hashCode(this.f20399a) * 31;
        int r10 = kk.a.b(this.f20400b, r5, 31);
        return this.f20401c.hashCode() + r10;
    }

    public final String toString() {
        return "ParamFieldModel(required=" + this.f20399a + ", keyPath=" + this.f20400b + ", defaultValue=" + this.f20401c + ')';
    }
}
