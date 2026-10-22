package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolatorCompat(Context r10, AttributeSet r11, XmlPullParser r12) {
        this(r10.getResources(), r10.getTheme(), r11, r12);
    }

    public PathInterpolatorCompat(Resources r10, Resources.Theme r11, AttributeSet r12, XmlPullParser r13) {
        TypedArray r14 = TypedArrayUtils.obtainAttributes(r10, r11, r12, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(r14, r13);
        r14.recycle();
    }

    private void initCubic(float r10, float r11, float r12, float r13) {
        Path r14 = new Path();
        r14.moveTo(0.0f, 0.0f);
        r14.cubicTo(r10, r11, r12, r13, 1.0f, 1.0f);
        initPath(r14);
    }

    private void initPath(Path r11) {
        int r10 = 0;
        PathMeasure r12 = new PathMeasure(r11, false);
        float r13 = r12.getLength();
        int r14 = Math.min(3000, ((int) (r13 / 0.002f)) + 1);
        if (r14 <= 0) goto L30;
        this.mX = new float[r14];
        this.mY = new float[r14];
        float[] r15 = new float[2];
        int r16 = 0;
    L5:
        if (r16 >= r14) goto L8;
        r12.getPosTan((r16 * r13) / (r14 - 1), r15, null);
        this.mX[r16] = r15[0];
        this.mY[r16] = r15[1];
        r16 = r16 + 1;
        goto L5
    L8:
        if (Math.abs(this.mX[0]) <= 1.0E-5d) goto L10;
    L27:
        StringBuilder r17 = new StringBuilder();
        r17.append("The Path must start at (0,0) and end at (1,1) start: ");
        r17.append(this.mX[0]);
        r17.append(",");
        r17.append(this.mY[0]);
        r17.append(" end:");
        int r18 = r14 - 1;
        r17.append(this.mX[r18]);
        r17.append(",");
        r17.append(this.mY[r18]);
        throw new IllegalArgumentException(r17.toString());
    L10:
        if (Math.abs(this.mY[0]) > 1.0E-5d) goto L27;
        int r19 = r14 - 1;
        if (Math.abs(this.mX[r19] - 1.0f) > 1.0E-5d) goto L27;
        if (Math.abs(this.mY[r19] - 1.0f) > 1.0E-5d) goto L27;
        float r110 = 0.0f;
        int r20 = 0;
    L16:
        if (r10 >= r14) goto L23;
        float[] r21 = this.mX;
        int r22 = r20 + 1;
        float r23 = r21[r20];
        if (r23 < r110) goto L21;
        r21[r10] = r23;
        r10 = r10 + 1;
        r110 = r23;
        r20 = r22;
        goto L16
    L21:
        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + r23);
    L23:
        if (r12.nextContour() == true) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
    L30:
        throw new IllegalArgumentException("The Path has a invalid length " + r13);
    }

    private void initQuad(float r10, float r11) {
        Path r12 = new Path();
        r12.moveTo(0.0f, 0.0f);
        r12.quadTo(r10, r11, 1.0f, 1.0f);
        initPath(r12);
    }

    private void parseInterpolatorFromTypeArray(TypedArray r10, XmlPullParser r11) {
        if (TypedArrayUtils.hasAttribute(r11, "pathData") == false) goto L10;
        String r12 = TypedArrayUtils.getNamedString(r10, r11, "pathData", 4);
        Path r13 = PathParser.createPathFromPathData(r12);
        if (r13 == null) goto L8;
        initPath(r13);
        return;
    L8:
        throw new InflateException("The path is null, which is created from " + r12);
    L10:
        if (TypedArrayUtils.hasAttribute(r11, "controlX1") == false) goto L24;
        if (TypedArrayUtils.hasAttribute(r11, "controlY1") == false) goto L22;
        float r14 = TypedArrayUtils.getNamedFloat(r10, r11, "controlX1", 0, 0.0f);
        float r15 = TypedArrayUtils.getNamedFloat(r10, r11, "controlY1", 1, 0.0f);
        boolean r16 = TypedArrayUtils.hasAttribute(r11, "controlX2");
        if (r16 != TypedArrayUtils.hasAttribute(r11, "controlY2")) goto L20;
        if (r16 == true) goto L17;
        initQuad(r14, r15);
        return;
    L17:
        initCubic(r14, r15, TypedArrayUtils.getNamedFloat(r10, r11, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(r10, r11, "controlY2", 3, 0.0f));
        return;
    L20:
        throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
    L22:
        throw new InflateException("pathInterpolator requires the controlY1 attribute");
    L24:
        throw new InflateException("pathInterpolator requires the controlX1 attribute");
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        if (r10 > 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r10 < 1.0f) goto L8;
        return 1.0f;
    L8:
        int r11 = 0;
        int r12 = this.mX.length - 1;
    L10:
        if ((r12 - r11) <= 1) goto L15;
        int r13 = (r11 + r12) / 2;
        if (r10 < this.mX[r13]) goto L13;
        r11 = r13;
        goto L10
    L13:
        r12 = r13;
        goto L10
    L15:
        float[] r14 = this.mX;
        float r15 = r14[r12] - r14[r11];
        if (r15 == 0.0f) goto L18;
        float r16 = (r10 - r14[r11]) / r15;
        float[] r17 = this.mY;
        float r18 = r17[r11];
        return r18 + (r16 * (r17[r12] - r18));
    L18:
        return this.mY[r11];
    }
}
