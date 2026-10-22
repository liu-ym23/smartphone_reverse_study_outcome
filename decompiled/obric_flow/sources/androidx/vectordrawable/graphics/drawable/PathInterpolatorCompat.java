package androidx.vectordrawable.graphics.drawable;

import ai.j0;
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

    public PathInterpolatorCompat(Context r5, AttributeSet r10, XmlPullParser r11) {
        this(r5.getResources(), r5.getTheme(), r10, r11);
    }

    private void initCubic(float r10, float r11, float r12, float r13) {
        Path r14 = new Path();
        r14.moveTo(0.0f, 0.0f);
        r14.cubicTo(r10, r11, r12, r13, 1.0f, 1.0f);
        initPath(r14);
    }

    private void initPath(Path r11) {
        int r5 = 0;
        PathMeasure r10 = new PathMeasure(r11, false);
        float r12 = r10.getLength();
        int r13 = Math.min(MAX_NUM_POINTS, ((int) (r12 / 0.002f)) + 1);
        if (r13 <= 0) goto L30;
        this.mX = new float[r13];
        this.mY = new float[r13];
        float[] r14 = new float[2];
        int r15 = 0;
    L5:
        if (r15 >= r13) goto L8;
        r10.getPosTan((r15 * r12) / (r13 - 1), r14, null);
        this.mX[r15] = r14[0];
        this.mY[r15] = r14[1];
        r15 = r15 + 1;
        goto L5
    L8:
        if (Math.abs(this.mX[0]) <= 1.0E-5d) goto L10;
    L27:
        StringBuilder r16 = new StringBuilder("The Path must start at (0,0) and end at (1,1) start: ");
        r16.append(this.mX[0]);
        r16.append(",");
        r16.append(this.mY[0]);
        r16.append(" end:");
        int r17 = r13 - 1;
        r16.append(this.mX[r17]);
        r16.append(",");
        r16.append(this.mY[r17]);
        throw new IllegalArgumentException(r16.toString());
    L10:
        if (Math.abs(this.mY[0]) > 1.0E-5d) goto L27;
        int r18 = r13 - 1;
        if (Math.abs(this.mX[r18] - 1.0f) > 1.0E-5d) goto L27;
        if (Math.abs(this.mY[r18] - 1.0f) > 1.0E-5d) goto L27;
        float r19 = 0.0f;
        int r20 = 0;
    L16:
        if (r5 >= r13) goto L23;
        float[] r21 = this.mX;
        int r22 = r20 + 1;
        float r23 = r21[r20];
        if (r23 < r19) goto L21;
        r21[r5] = r23;
        r5 = r5 + 1;
        r19 = r23;
        r20 = r22;
        goto L16
    L21:
        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + r23);
    L23:
        if (r10.nextContour() == true) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
    L30:
        throw new IllegalArgumentException("The Path has a invalid length " + r12);
    }

    private void initQuad(float r5, float r10) {
        Path r11 = new Path();
        r11.moveTo(0.0f, 0.0f);
        r11.quadTo(r5, r10, 1.0f, 1.0f);
        initPath(r11);
    }

    private void parseInterpolatorFromTypeArray(TypedArray r10, XmlPullParser r11) {
        if (TypedArrayUtils.hasAttribute(r11, "pathData") == false) goto L10;
        String r12 = TypedArrayUtils.getNamedString(r10, r11, "pathData", 4);
        Path r13 = PathParser.createPathFromPathData(r12);
        if (r13 == null) goto L8;
        initPath(r13);
        return;
    L8:
        throw new InflateException(j0.C("The path is null, which is created from ", r12));
    L10:
        if (TypedArrayUtils.hasAttribute(r11, "controlX1") == false) goto L24;
        if (TypedArrayUtils.hasAttribute(r11, "controlY1") == false) goto L22;
        float r5 = TypedArrayUtils.getNamedFloat(r10, r11, "controlX1", 0, 0.0f);
        float r14 = TypedArrayUtils.getNamedFloat(r10, r11, "controlY1", 1, 0.0f);
        boolean r15 = TypedArrayUtils.hasAttribute(r11, "controlX2");
        if (r15 != TypedArrayUtils.hasAttribute(r11, "controlY2")) goto L20;
        if (r15 == true) goto L17;
        initQuad(r5, r14);
        return;
    L17:
        initCubic(r5, r14, TypedArrayUtils.getNamedFloat(r10, r11, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(r10, r11, "controlY2", 3, 0.0f));
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
        int r5 = this.mX.length - 1;
        int r11 = 0;
    L10:
        if ((r5 - r11) <= 1) goto L15;
        int r12 = (r11 + r5) / 2;
        if (r10 < this.mX[r12]) goto L13;
        r11 = r12;
        goto L10
    L13:
        r5 = r12;
        goto L10
    L15:
        float[] r13 = this.mX;
        float r14 = r13[r5];
        float r15 = r13[r11];
        float r16 = r14 - r15;
        if (r16 == 0.0f) goto L18;
        float[] r17 = this.mY;
        float r18 = r17[r11];
        float r19 = r17[r5];
        return j0.b(r19, r18, (r10 - r15) / r16, r18);
    L18:
        return this.mY[r11];
    }

    public PathInterpolatorCompat(Resources r5, Resources.Theme r10, AttributeSet r11, XmlPullParser r12) {
        TypedArray r13 = TypedArrayUtils.obtainAttributes(r5, r10, r11, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(r13, r12);
        r13.recycle();
    }
}
