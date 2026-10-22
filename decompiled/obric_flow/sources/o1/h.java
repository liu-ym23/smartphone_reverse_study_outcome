package o1;

import com.bytedance.ai.bridge.core.annotation.DefaultType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultType f20394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f20395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20396c;
    public final int d;
    public final boolean e;
    public final long f;

    public h(DefaultType r5, double r10, String r11, int r12, boolean r13, long r14) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r11, "stringValue");
        this.f20394a = r5;
        this.f20395b = r10;
        this.f20396c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof h) == true) goto L8;
        return false;
    L8:
        h r11 = (h) r10;
        DefaultType r5 = r11.f20394a;
        if (this.f20394a == r5) goto L12;
        return false;
    L12:
        if (Double.compare(this.f20395b, r11.f20395b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20396c, r11.f20396c) == true) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f20394a.hashCode() * 31;
        int r10 = (Double.hashCode(this.f20395b) + r5) * 31;
        int r11 = kk.a.b(this.f20396c, r10, 31);
        int r12 = kn.e.a(k5.d.a(this.d, r11), 31, this.e);
        return Long.hashCode(this.f) + r12;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("DefaultValue(type=");
        r5.append(this.f20394a);
        r5.append(", doubleValue=");
        r5.append(this.f20395b);
        r5.append(", stringValue=");
        r5.append(this.f20396c);
        r5.append(", intValue=");
        r5.append(this.d);
        r5.append(", boolValue=");
        r5.append(this.e);
        r5.append(", longValue=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.f, ')');
    }
}
