package com.bytedance.bmmt.video;

import android.graphics.Matrix;
import android.graphics.Point;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class RendererCommon {
    private static float BALANCED_VISIBLE_FRACTION = 0.5625f;

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.RendererCommon$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType = null;

        static {
            int[] r0 = new int[ScalingType.values().length];
            $SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType = r0;
            r0[ScalingType.SCALE_ASPECT_FIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_FILL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_BALANCED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public interface GlDrawer {
        void drawOes(int r1, float[] r2, int r3, int r4, int r5, int r6, int r7, int r8);

        void drawOes(int r1, float[] r2, int r3, int r4, int r5, int r6, int r7, int r8, FilterType r9, int r10, int r11);

        void drawOes(int r1, float[] r2, int r3, int r4, int r5, int r6, int r7, int r8, FilterType r9, int r10, int r11, int r12, int r13);

        void drawRgb(int r1, float[] r2, int r3, int r4, int r5, int r6, int r7, int r8);

        void drawRgb(int r1, float[] r2, int r3, int r4, int r5, int r6, int r7, int r8, FilterType r9, int r10, int r11);

        void drawRgb(int r1, float[] r2, int r3, int r4, int r5, int r6, int r7, int r8, FilterType r9, int r10, int r11, int r12, int r13);

        void drawYuv(int[] r1, float[] r2, int r3, int r4, int r5, int r6, int r7, int r8);

        void drawYuv(int[] r1, float[] r2, int r3, int r4, int r5, int r6, int r7, int r8, FilterType r9, int r10, int r11);

        void drawYuv(int[] r1, float[] r2, int r3, int r4, int r5, int r6, int r7, int r8, FilterType r9, int r10, int r11, int r12, int r13);

        void release();
    }

    public interface RendererEvents {
        void onFirstFrameRendered();

        void onFrameResolutionChanged(int r1, int r2, int r3);
    }

    public static final enum ScalingType extends Enum<ScalingType> {
        private static final /* synthetic */ ScalingType[] $VALUES = null;
        public static final ScalingType SCALE_ASPECT_BALANCED = null;
        public static final ScalingType SCALE_ASPECT_FILL = null;
        public static final ScalingType SCALE_ASPECT_FIT = null;

        private static /* synthetic */ ScalingType[] $values() {
            return new ScalingType[]{SCALE_ASPECT_FIT, SCALE_ASPECT_FILL, SCALE_ASPECT_BALANCED};
        }

        static {
            SCALE_ASPECT_FIT = new ScalingType("SCALE_ASPECT_FIT", 0);
            SCALE_ASPECT_FILL = new ScalingType("SCALE_ASPECT_FILL", 1);
            SCALE_ASPECT_BALANCED = new ScalingType("SCALE_ASPECT_BALANCED", 2);
            $VALUES = $values();
        }

        public static ScalingType[] values() {
            return (ScalingType[]) $VALUES.clone();
        }

        public static ScalingType valueOf(String r1) {
            return (ScalingType) r27.a.a(ScalingType.class, r1);
        }

        private ScalingType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class VideoLayoutMeasure {
        private ScalingType scalingTypeMatchOrientation;
        private ScalingType scalingTypeMismatchOrientation;

        public VideoLayoutMeasure() {
            ScalingType r0 = ScalingType.SCALE_ASPECT_BALANCED;
            this.scalingTypeMatchOrientation = r0;
            this.scalingTypeMismatchOrientation = r0;
        }

        public void setScalingType(ScalingType r1) {
            this.scalingTypeMatchOrientation = r1;
            this.scalingTypeMismatchOrientation = r1;
        }

        public void setScalingType(ScalingType r1, ScalingType r2) {
            this.scalingTypeMatchOrientation = r1;
            this.scalingTypeMismatchOrientation = r2;
        }

        public Point measure(int r7, int r8, int r9, int r10) {
            int r1 = View.getDefaultSize(Integer.MAX_VALUE, r7);
            int r0 = View.getDefaultSize(Integer.MAX_VALUE, r8);
            if (r9 == 0) goto L27;
            if (r10 == 0) goto L27;
            if (r1 == 0) goto L27;
            if (r0 == 0) goto L27;
            float r11 = r9 / r10;
            float r12 = r1 / r0;
            boolean r2 = true;
            if (r11 <= 1.0f) goto L11;
            boolean r5 = true;
        L13:
            if (r12 > 1.0f) goto L16;
            r2 = false;
        L16:
            if (r5 != r2) goto L18;
            ScalingType r13 = this.scalingTypeMatchOrientation;
        L19:
            Point r14 = RendererCommon.getDisplaySize(r13, r11, r1, r0);
            if (View.MeasureSpec.getMode(r7) != 1073741824) goto L23;
            r14.x = r1;
        L23:
            if (View.MeasureSpec.getMode(r8) != 1073741824) goto L25;
            r14.y = r0;
        L25:
            return r14;
        L18:
            r13 = this.scalingTypeMismatchOrientation;
            goto L19
        L11:
            r5 = false;
        L27:
            return new Point(r1, r0);
        }
    }

    public RendererCommon() {
    }

    private static void adjustOrigin(float[] r7) {
        float r1 = r7[12] - ((r7[0] + r7[4]) * 0.5f);
        r7[12] = r1;
        float r4 = r7[13] - ((r7[1] + r7[5]) * 0.5f);
        r7[13] = r4;
        r7[12] = r1 + 0.5f;
        r7[13] = r4 + 0.5f;
    }

    public static float[] convertMatrixFromAndroidGraphicsMatrix(Matrix r8) {
        float[] r1 = new float[9];
        r8.getValues(r1);
        return new float[]{r1[0], r1[3], 0.0f, r1[6], r1[1], r1[4], 0.0f, r1[7], 0.0f, 0.0f, 1.0f, 0.0f, r1[2], r1[5], 0.0f, r1[8]};
    }

    public static Matrix convertMatrixToAndroidGraphicsMatrix(float[] r5) {
        float[] r0 = {r5[0], r5[4], r5[12], r5[1], r5[5], r5[13], r5[3], r5[7], r5[15]};
        Matrix r6 = new Matrix();
        r6.setValues(r0);
        return r6;
    }

    private static float convertScalingTypeToVisibleFraction(ScalingType r1) {
        int r2 = AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType[r1.ordinal()];
        if (r2 != 1) goto L5;
        return 1.0f;
    L5:
        if (r2 != 2) goto L7;
        return 0.0f;
    L7:
        if (r2 != 3) goto L11;
        return BALANCED_VISIBLE_FRACTION;
    L11:
        throw new IllegalArgumentException();
    }

    public static float[] getLayoutMatrix(boolean r2, float r3, float r4) {
        if (r4 <= r3) goto L5;
        float r5 = r3 / r4;
        float r6 = 1.0f;
    L6:
        if (r2 == false) goto L8;
        r6 = r6 * (-1.0f);
    L8:
        float[] r7 = new float[16];
        android.opengl.Matrix.setIdentityM(r7, 0);
        android.opengl.Matrix.scaleM(r7, 0, r6, r5, 1.0f);
        adjustOrigin(r7);
        return r7;
    L5:
        r6 = r4 / r3;
        r5 = 1.0f;
        goto L6
    }

    private static Point getDisplaySize(float r2, float r3, int r4, int r5) {
        if (r2 == 0.0f) goto L10;
        if (r3 == 0.0f) goto L10;
        return new Point(Math.min(r4, Math.round((r5 / r2) * r3)), Math.min(r5, Math.round((r4 / r2) / r3)));
    L10:
        return new Point(r4, r5);
    }

    public static Point getDisplaySize(ScalingType r0, float r1, int r2, int r3) {
        return getDisplaySize(convertScalingTypeToVisibleFraction(r0), r1, r2, r3);
    }
}
