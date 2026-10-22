package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = 0.0f;
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle;
    private float mMaximumTangent;
    private float mMinimumHorizontalAngle;
    private float mMinimumHorizontalTangent;
    private float mMinimumVerticalAngle;
    private float mMinimumVerticalTangent;

    static {
        DEFAULT_MAX_TANGENT = (float) Math.tan(Math.toRadians(35.0d));
    }

    public ArcMotion() {
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.ARC_MOTION);
        XmlPullParser r13 = (XmlPullParser) r11;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(r12, r13, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(r12, r13, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(r12, r13, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        r12.recycle();
    }

    private static float toTangent(float r10) {
        if (r10 < 0.0f) goto L9;
        if (r10 > 90.0f) goto L9;
        return (float) Math.tan(Math.toRadians(r10 / 2.0f));
    L9:
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float r12, float r13, float r14, float r15) {
        Path r10 = new Path();
        r10.moveTo(r12, r13);
        float r11 = r14 - r12;
        float r16 = r15 - r13;
        float r17 = (r11 * r11) + (r16 * r16);
        float r18 = (r12 + r14) / 2.0f;
        float r19 = (r13 + r15) / 2.0f;
        float r20 = 0.25f * r17;
        if (r13 <= r15) goto L5;
        boolean r21 = true;
    L7:
        if (Math.abs(r11) >= Math.abs(r16)) goto L13;
        float r22 = Math.abs(r17 / (r16 * 2.0f));
        if (r21 == false) goto L11;
        float r23 = r22 + r15;
        float r24 = r14;
    L12:
        float r25 = this.mMinimumVerticalTangent;
    L18:
        float r26 = (r20 * r25) * r25;
        float r27 = r18 - r24;
        float r28 = r19 - r23;
        float r29 = (r27 * r27) + (r28 * r28);
        float r110 = this.mMaximumTangent;
        float r30 = (r20 * r110) * r110;
        if (r29 < r26) goto L26;
        if (r29 <= r30) goto L24;
        r26 = r30;
        goto L26
    L24:
        r26 = 0.0f;
    L26:
        if (r26 == 0.0f) goto L28;
        float r111 = (float) Math.sqrt(r26 / r29);
        r24 = ((r24 - r18) * r111) + r18;
        r23 = r19 + (r111 * (r23 - r19));
    L28:
        r10.cubicTo((r12 + r24) / 2.0f, (r13 + r23) / 2.0f, (r24 + r14) / 2.0f, (r23 + r15) / 2.0f, r14, r15);
        return r10;
    L11:
        r23 = r22 + r13;
        r24 = r12;
        goto L12
    L13:
        float r31 = r17 / (r11 * 2.0f);
        if (r21 == false) goto L16;
        r23 = r13;
        r24 = r31 + r12;
    L17:
        r25 = this.mMinimumHorizontalTangent;
        goto L18
    L16:
        r24 = r14 - r31;
        r23 = r15;
        goto L17
    L5:
        r21 = false;
        goto L7
    }

    public void setMaximumAngle(float r10) {
        this.mMaximumAngle = r10;
        this.mMaximumTangent = toTangent(r10);
    }

    public void setMinimumHorizontalAngle(float r10) {
        this.mMinimumHorizontalAngle = r10;
        this.mMinimumHorizontalTangent = toTangent(r10);
    }

    public void setMinimumVerticalAngle(float r10) {
        this.mMinimumVerticalAngle = r10;
        this.mMinimumVerticalTangent = toTangent(r10);
    }
}
