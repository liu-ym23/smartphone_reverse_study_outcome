package so8;

import com.larus.bmhome.chat.zoom.IZoomInAnimationProvider;
import com.larus.bmhome.chat.zoom.ZoomInAnimationAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public final String a;
    public final j b;
    public final ZoomInAnimationAction c;
    public final IZoomInAnimationProvider d;
    public final c e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "ZoomInAnimationItem(animationID=" + this.a + ", input=" + this.b + ", action=" + this.c + ", zoomInAnimationProvider=" + this.d + ", zoomInConfig=" + this.e + ')';
    }

    public static k a(k r6, ZoomInAnimationAction r7) {
        String r1 = r6.a;
        j r2 = r6.b;
        IZoomInAnimationProvider r4 = r6.d;
        c r5 = r6.e;
        Intrinsics.checkNotNullParameter(r1, "animationID");
        Intrinsics.checkNotNullParameter(r2, "input");
        Intrinsics.checkNotNullParameter(r7, "action");
        Intrinsics.checkNotNullParameter(r4, "zoomInAnimationProvider");
        Intrinsics.checkNotNullParameter(r5, "zoomInConfig");
        return new k(r1, r2, r7, r4, r5);
    }

    public k(String r2, j r3, ZoomInAnimationAction r4, IZoomInAnimationProvider r5, c r6) {
        Intrinsics.checkNotNullParameter(r2, "animationID");
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r5, "zoomInAnimationProvider");
        Intrinsics.checkNotNullParameter(r6, "zoomInConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
