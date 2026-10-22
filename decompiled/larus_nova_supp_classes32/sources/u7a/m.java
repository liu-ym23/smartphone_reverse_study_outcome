package u7a;

import android.graphics.Matrix;
import android.graphics.Rect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m {

    public static abstract class a implements b {
        public a() {
        }

        public abstract void b(Matrix r1, float r2, float r3, float r4, float r5, float r6, float r7);

        @Override // u7a.m.b
        public final Matrix a(Matrix r10, Rect r11, int r12, int r13) {
            b(r10, r11.width(), r11.height(), r12, r13, r11.left, r11.top);
            return r10;
        }
    }

    public interface b {
        public static final f a = null;
        public static final e b = null;
        public static final c c = null;
        public static final d d = null;

        Matrix a(Matrix r1, Rect r2, int r3, int r4);

        static {
            a = f.e;
            b = e.e;
            c = c.e;
            d = d.e;
        }
    }

    public static class c extends a {
        public static final c e = null;

        public final String toString() {
            return "center";
        }

        static {
            e = new c();
        }

        public c() {
        }

        @Override // u7a.m.a
        public final void b(Matrix r1, float r2, float r3, float r4, float r5, float r6, float r7) {
            float r8 = com.lynx.tasm.utils.i.b(1.0f, 0.0f);
            float r9 = Math.round((r2 - (r4 * r8)) * 0.5f);
            float r10 = Math.round((r3 - (r5 * r8)) * 0.5f);
            r1.setScale(r8, r8);
            r1.postTranslate(r9, r10);
        }
    }

    public static class d extends a {
        public static final d e = null;

        public final String toString() {
            return "center_crop";
        }

        static {
            e = new d();
        }

        public d() {
        }

        @Override // u7a.m.a
        public final void b(Matrix r5, float r6, float r7, float r8, float r9, float r10, float r11) {
            float r0 = r6 / r8;
            float r1 = r7 / r9;
            if (r0 <= r1) goto L5;
            r5.setScale(r0, r0);
            r5.postTranslate(r10, ((r7 - (r9 * r0)) / 2.0f) + r11);
            return;
        L5:
            r5.setScale(r1, r1);
            r5.postTranslate(((r6 - (r8 * r1)) / 2.0f) + r10, r11);
        }
    }

    public static class e extends a {
        public static final e e = null;

        public final String toString() {
            return "fit_center";
        }

        static {
            e = new e();
        }

        public e() {
        }

        @Override // u7a.m.a
        public final void b(Matrix r5, float r6, float r7, float r8, float r9, float r10, float r11) {
            float r0 = r6 / r8;
            float r1 = r7 / r9;
            if (r0 <= r1) goto L5;
            r5.setScale(r1, r1);
            r5.postTranslate(((r6 - (r8 * r1)) / 2.0f) + r10, r11);
            return;
        L5:
            r5.setScale(r0, r0);
            r5.postTranslate(r10, ((r7 - (r9 * r0)) / 2.0f) + r11);
        }
    }

    public static class f extends a {
        public static final f e = null;

        public final String toString() {
            return "fit_xy";
        }

        static {
            e = new f();
        }

        public f() {
        }

        @Override // u7a.m.a
        public final void b(Matrix r1, float r2, float r3, float r4, float r5, float r6, float r7) {
            r1.setScale(r2 / r4, r3 / r5);
            r1.postTranslate(r6, r7);
        }
    }

    public m() {
    }
}
