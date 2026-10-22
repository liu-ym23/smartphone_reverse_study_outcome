package j0;

import android.graphics.Rect;
import android.view.DisplayCutout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisplayCutout f8375a;

    public static class a {
        public static DisplayCutout a(Rect r8, List<Rect> r10) {
            return new DisplayCutout(r8, r10);
        }

        public static List<Rect> b(DisplayCutout r8) {
            return r8.getBoundingRects();
        }

        public static int c(DisplayCutout r8) {
            return r8.getSafeInsetBottom();
        }

        public static int d(DisplayCutout r8) {
            return r8.getSafeInsetLeft();
        }

        public static int e(DisplayCutout r8) {
            return r8.getSafeInsetRight();
        }

        public static int f(DisplayCutout r8) {
            return r8.getSafeInsetTop();
        }
    }

    public c(DisplayCutout r8) {
        this.f8375a = r8;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L5;
        return true;
    L5:
        if (r8 != null) goto L7;
        return false;
    L7:
        if (c.class == r8.getClass()) goto L10;
        return false;
    L10:
        return i0.b.a(this.f8375a, ((c) r8).f8375a);
    }

    public final int hashCode() {
        DisplayCutout r8 = this.f8375a;
        if (r8 != null) goto L6;
        return 0;
    L6:
        return r8.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f8375a + "}";
    }
}
