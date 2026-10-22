package j0;

import android.graphics.Rect;
import android.view.Gravity;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    public static class a {
        public static void a(int r8, int r10, int r11, Rect r12, int r13, int r14, Rect r15, int r16) {
            Gravity.apply(r8, r10, r11, r12, r13, r14, r15, r16);
        }

        public static void b(int r8, int r10, int r11, Rect r12, Rect r13, int r14) {
            Gravity.apply(r8, r10, r11, r12, r13, r14);
        }

        public static void c(int r8, Rect r10, Rect r11, int r12) {
            Gravity.applyDisplay(r8, r10, r11, r12);
        }
    }

    public static int a(int r8, int r10) {
        return Gravity.getAbsoluteGravity(r8, r10);
    }
}
