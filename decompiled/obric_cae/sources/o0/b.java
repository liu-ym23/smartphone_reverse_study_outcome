package o0;

import android.graphics.Rect;
import java.util.Comparator;
import k0.f;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public interface a<T> {
    }

    /* JADX INFO: renamed from: o0.b$b, reason: collision with other inner class name */
    public static class C0127b<T> implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f9583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f9584b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f9585m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final a<T> f9586n;

        public C0127b(boolean r8, o0.a.C0126a r10) {
            this.f9583a = new Rect();
            this.f9584b = new Rect();
            this.f9585m = r8;
            this.f9586n = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r8, T r10) {
            o0.a.C0126a r11 = (o0.a.C0126a) this.f9586n;
            r11.getClass();
            Rect r12 = this.f9583a;
            ((f) r8).d(r12);
            r11.getClass();
            Rect r13 = this.f9584b;
            ((f) r10).d(r13);
            int r14 = r12.top;
            int r15 = r13.top;
            if (r14 >= r15) goto L6;
            return -1;
        L6:
            if (r14 <= r15) goto L8;
            return 1;
        L8:
            int r16 = r12.left;
            int r17 = r13.left;
            boolean r18 = this.f9585m;
            if (r16 >= r17) goto L13;
            if (r18 == true) goto L12;
            return -1;
        L12:
            return 1;
        L13:
            if (r16 <= r17) goto L18;
            if (r18 == false) goto L17;
            return -1;
        L17:
            return 1;
        L18:
            int r19 = r12.bottom;
            int r20 = r13.bottom;
            if (r19 >= r20) goto L21;
            return -1;
        L21:
            if (r19 <= r20) goto L23;
            return 1;
        L23:
            int r21 = r12.right;
            int r22 = r13.right;
            if (r21 >= r22) goto L28;
            if (r18 == true) goto L27;
            return -1;
        L27:
            return 1;
        L28:
            if (r21 <= r22) goto L33;
            if (r18 == false) goto L32;
            return -1;
        L32:
            return 1;
        L33:
            return 0;
        }
    }

    public static boolean a(int r10, Rect r11, Rect r12, Rect r13) {
        boolean r8 = b(r10, r11, r12);
        if (b(r10, r11, r13) == true) goto L47;
        if (r8 == false) goto L47;
        if (r10 == 17) goto L23;
        if (r10 == 33) goto L20;
        if (r10 == 66) goto L17;
        if (r10 != 130) goto L15;
        if (r11.bottom <= r13.top) goto L24;
    L25:
        boolean r14 = false;
    L26:
        if (r14 == true) goto L28;
        return true;
    L28:
        if (r10 == 17) goto L46;
        if (r10 == 66) goto L46;
        int r15 = d(r10, r11, r12);
        if (r10 == 17) goto L41;
        if (r10 == 33) goto L40;
        if (r10 == 66) goto L39;
        if (r10 != 130) goto L38;
        int r16 = r13.bottom;
        int r17 = r11.bottom;
    L43:
        if (r15 < Math.max(1, r16 - r17)) goto L45;
        return false;
    L45:
        return true;
    L38:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L39:
        r16 = r13.right;
        r17 = r11.right;
        goto L43
    L40:
        r16 = r11.top;
        r17 = r13.top;
        goto L43
    L41:
        r16 = r11.left;
        r17 = r13.left;
    L46:
        return true;
    L24:
        r14 = true;
        goto L26
    L15:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L17:
        if (r11.right > r13.left) goto L25;
    L20:
        if (r11.top < r13.bottom) goto L25;
    L23:
        if (r11.left < r13.right) goto L25;
    L47:
        return false;
    }

    public static boolean b(int r8, Rect r10, Rect r11) {
        if (r8 == 17) goto L21;
        if (r8 == 33) goto L14;
        if (r8 == 66) goto L21;
        if (r8 == 130) goto L14;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L14:
        if (r11.right < r10.left) goto L19;
        if (r11.left > r10.right) goto L19;
        return true;
    L19:
        return false;
    L21:
        if (r11.bottom < r10.top) goto L26;
        if (r11.top > r10.bottom) goto L26;
        return true;
    L26:
        return false;
    }

    public static boolean c(int r8, Rect r10, Rect r11) {
        if (r8 != 17) goto L5;
        int r12 = r10.right;
        int r13 = r11.right;
        if (r12 > r13) goto L44;
        if (r10.left >= r13) goto L44;
    L47:
        return false;
    L44:
        if (r10.left <= r11.left) goto L47;
        return true;
    L5:
        if (r8 != 33) goto L7;
        int r14 = r10.bottom;
        int r15 = r11.bottom;
        if (r14 > r15) goto L35;
        if (r10.top >= r15) goto L35;
    L38:
        return false;
    L35:
        if (r10.top <= r11.top) goto L38;
        return true;
    L7:
        if (r8 != 66) goto L9;
        int r16 = r10.left;
        int r17 = r11.left;
        if (r16 < r17) goto L26;
        if (r10.right <= r17) goto L26;
    L29:
        return false;
    L26:
        if (r10.right >= r11.right) goto L29;
        return true;
    L9:
        if (r8 != 130) goto L20;
        int r18 = r10.top;
        int r19 = r11.top;
        if (r18 < r19) goto L15;
        if (r10.bottom <= r19) goto L15;
    L18:
        return false;
    L15:
        if (r10.bottom >= r11.bottom) goto L18;
        return true;
    L20:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    public static int d(int r8, Rect r10, Rect r11) {
        if (r8 != 17) goto L5;
        int r12 = r10.left;
        int r13 = r11.right;
    L17:
        return Math.max(0, r12 - r13);
    L5:
        if (r8 != 33) goto L7;
        r12 = r10.top;
        r13 = r11.bottom;
        goto L17
    L7:
        if (r8 != 66) goto L9;
        r12 = r11.left;
        r13 = r10.right;
        goto L17
    L9:
        if (r8 != 130) goto L12;
        r12 = r11.top;
        r13 = r10.bottom;
        goto L17
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    public static int e(int r8, Rect r10, Rect r11) {
        if (r8 != 17) goto L5;
    L14:
        int r12 = r10.top;
        int r13 = (r10.height() / 2) + r12;
        int r14 = r11.top;
        int r15 = r11.height();
    L16:
        return Math.abs(r13 - ((r15 / 2) + r14));
    L5:
        if (r8 != 33) goto L7;
    L13:
        int r16 = r10.left;
        r13 = (r10.width() / 2) + r16;
        r14 = r11.left;
        r15 = r11.width();
        goto L16
    L7:
        if (r8 == 66) goto L14;
        if (r8 == 130) goto L13;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
}
