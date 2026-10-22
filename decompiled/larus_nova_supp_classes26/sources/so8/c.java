package so8;

import android.graphics.Rect;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEndStrategy;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEnqueueStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final int a;
    public final long b;
    public final ZoomInAnimationEnqueueStrategy c;
    public final ZoomInAnimationEndStrategy d;
    public final Rect e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        return ((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "ZoomInAnimationConfig(height=" + this.a + ", duration=" + this.b + ", enqueueStrategy=" + this.c + ", animationEndStrategy=" + this.d + ", marginRect=" + this.e + ')';
    }

    public c(int r3, ZoomInAnimationEnqueueStrategy r4, ZoomInAnimationEndStrategy r5, Rect r6) {
        Intrinsics.checkNotNullParameter(r4, "enqueueStrategy");
        Intrinsics.checkNotNullParameter(r5, "animationEndStrategy");
        Intrinsics.checkNotNullParameter(r6, "marginRect");
        this.a = r3;
        this.b = 1000;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
