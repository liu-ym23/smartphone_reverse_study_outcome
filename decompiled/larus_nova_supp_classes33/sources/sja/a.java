package sja;

import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {

    /* JADX INFO: renamed from: sja.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0072a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ScaleType.values().length];
            a = r0;
            r0[ScaleType.ScaleAspectFitCenter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            a[ScaleType.ScaleAspectFill.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            a[ScaleType.TopFill.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            a[ScaleType.BottomFill.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            a[ScaleType.LeftFill.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            a[ScaleType.RightFill.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            a[ScaleType.TopFit.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            a[ScaleType.BottomFit.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            a[ScaleType.LeftFit.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            a[ScaleType.RightFit.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static float[] a(float r6, float r7, float r8, float r9) {
        float r10 = (r6 / 2.0f) + 0.5f;
        float r11 = r9 + 0.0f;
        float r12 = 1.0f - (r8 / 2.0f);
        float r13 = 1.0f - r7;
        return new float[]{-1.0f, -1.0f, 0.0f, r10, r11, 1.0f, -1.0f, 0.0f, r12, r11, -1.0f, 1.0f, 0.0f, r10, r13, 1.0f, 1.0f, 0.0f, r12, r13};
    }

    public static float[] b(float r6, float r7, float r8, float r9) {
        float r10 = (r6 * 2.0f) - 1.0f;
        float r11 = (r9 * 2.0f) - 1.0f;
        float r12 = 1.0f - (r8 * 2.0f);
        float r13 = 1.0f - (r7 * 2.0f);
        return new float[]{r10, r11, 0.0f, 0.5f, 0.0f, r12, r11, 0.0f, 1.0f, 0.0f, r10, r13, 0.0f, 0.5f, 1.0f, r12, r13, 0.0f, 1.0f, 1.0f};
    }
}
