package j5;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18240c;
    public final String d;

    public c(int r5, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "errorMsg");
        Intrinsics.checkNotNullParameter(r11, "virtualAid");
        Intrinsics.checkNotNullParameter(r12, "biz");
        this.f18238a = r5;
        this.f18239b = r10;
        this.f18240c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        int r11 = r10.f18238a;
        if (this.f18238a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18239b, r10.f18239b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f18240c, r10.f18240c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f18238a) * 31;
        int r10 = kk.a.b(this.f18239b, r5, 31);
        int r11 = kk.a.b(this.f18240c, r10, 31);
        return this.d.hashCode() + r11;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ContainerError(errCode=");
        r5.append(this.f18238a);
        r5.append(", errorMsg=");
        r5.append(this.f18239b);
        r5.append(", virtualAid=");
        r5.append(this.f18240c);
        r5.append(", biz=");
        return j0.p(r5, this.d, ')');
    }
}
