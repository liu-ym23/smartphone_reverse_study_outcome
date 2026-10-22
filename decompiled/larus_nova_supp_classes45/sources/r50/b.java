package r50;

import com.bytedance.android.live.core.gl.primitive.Align;
import kotlin.jvm.internal.Intrinsics;
import m50.c;
import m50.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends r50.a {
    public static final /* synthetic */ int d = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: r50.b$b, reason: collision with other inner class name */
    public static final class C0270b {
        public static final /* synthetic */ int h = 0;
        public final Align a;
        public float b;
        public float c;
        public final float d;
        public final float e;
        public int f;
        public com.bytedance.android.live.core.gl.primitive.b g;

        /* JADX INFO: renamed from: r50.b$b$a */
        public static final class a {
            public static float[] b(float r11, float r12, boolean r13, boolean r14) {
                if (r11 > 0.0f) goto L5;
                return null;
            L5:
                if (r12 > 0.0f) goto L8;
                return null;
            L8:
                if (r13 == true) goto L11;
                if (r14 == true) goto L11;
                float r15 = r11 * 0.0f;
                float r0 = 0.0f * r12;
                float r16 = r12 * 1.0f;
                float r17 = r11 * 1.0f;
                return new float[]{r15, r0, r15, r16, r17, r16, r17, r0};
            L11:
                if (r13 == false) goto L14;
                if (r14 == true) goto L14;
                float r18 = r11 * 0.0f;
                float r8 = r12 * 1.0f;
                float r19 = r12 * 0.0f;
                float r110 = r11 * 1.0f;
                return new float[]{r18, r8, r18, r19, r110, r19, r110, r8};
            L14:
                if (r13 == true) goto L17;
                if (r14 == false) goto L17;
                float r111 = r11 * 1.0f;
                float r9 = r12 * 0.0f;
                float r112 = r12 * 1.0f;
                float r113 = r11 * 0.0f;
                return new float[]{r111, r9, r111, r112, r113, r112, r113, r9};
            L17:
                float r114 = r11 * 1.0f;
                float r115 = 1.0f * r12;
                float r116 = r12 * 0.0f;
                float r117 = r11 * 0.0f;
                return new float[]{r114, r115, r114, r116, r117, r116, r117, r115};
            }

            public static float[] a(boolean r0, boolean r1) {
                if (r0 == true) goto L6;
                return null;
            L6:
                if (r1 == false) goto L9;
                return new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
            L9:
                return new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
            }

            public static float[] c(float r17, float r18, boolean r19, Align r21) {
                Intrinsics.checkNotNullParameter(r21, "align");
                if (r19 == false) goto L6;
                return new float[]{-r21.getLeftMargin(r17), r21.getTopMargin(r18), 0.0f, -r21.getLeftMargin(r17), -r21.getBottomMargin(r18), 0.0f, r21.getRightMargin(r17), -r21.getBottomMargin(r18), 0.0f, r21.getRightMargin(r17), r21.getTopMargin(r18), 0.0f};
            L6:
                return new float[]{-r21.getLeftMargin(r17), 0.0f, r21.getTopMargin(r18), -r21.getLeftMargin(r17), 0.0f, -r21.getBottomMargin(r18), r21.getRightMargin(r17), 0.0f, -r21.getBottomMargin(r18), r21.getRightMargin(r17), 0.0f, r21.getTopMargin(r18)};
            }
        }

        static {
        }

        public final b a() {
            b r4 = new b(a.c(this.b, this.c, true, this.a), a.b(this.d, this.e, false, false), a.a(false, true), new short[]{1, 2, 3, 1, 3, 0});
            int r0 = this.f;
            if (r0 == (-1)) goto L5;
            r4.c.a = r0;
        L5:
            Intrinsics.checkNotNullParameter(this.a, "<set-?>");
            m50.a r1 = r4.b;
            e r2 = r1.a;
            if (r2 == null) goto L8;
            r2.e = null;
        L8:
            e r3 = r1.c;
            if (r3 == null) goto L11;
            r3.e = null;
        L11:
            e r5 = r1.b;
            if (r5 == null) goto L14;
            r5.e = null;
        L14:
            e r6 = r1.d;
            if (r6 == null) goto L17;
            r6.e = null;
        L17:
            c r7 = r1.e;
            if (r7 == null) goto L20;
            r7.e = null;
        L20:
            return r4;
        }

        public C0270b() {
            this.a = Align.CENTER;
            this.b = 1.0f;
            this.c = 1.0f;
            this.d = 1.0f;
            this.e = 1.0f;
            this.f = -1;
        }

        public final void b(float r2, float r3) {
            com.bytedance.android.live.core.gl.primitive.b r0 = this.g;
            if (r0 == null) goto L5;
            r2 = r0.b(r2);
        L5:
            this.b = r2;
            com.bytedance.android.live.core.gl.primitive.b r4 = this.g;
            if (r4 == null) goto L8;
            r3 = r4.b(r3);
        L8:
            this.c = r3;
        }
    }

    static {
    }

    public b(float[] r12, float[] r13, float[] r14, short[] r15) {
        Align r0 = Align.CENTER;
        Intrinsics.checkNotNullParameter(r0, "align");
        m50.a r5 = this.b;
        int r1 = C0270b.h;
        r5.b(C0270b.a.c(1.0f, 1.0f, true, r0), C0270b.a.b(1.0f, 1.0f, false, false), C0270b.a.a(false, true), null, new short[]{1, 2, 3, 1, 3, 0});
        this.b.a();
        this.b.d();
        this.b.b(r12, r13, r14, null, r15);
        this.b.a();
        this.b.d();
    }
}
