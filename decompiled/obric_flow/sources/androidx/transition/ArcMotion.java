package androidx.transition;

import ai.j0;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
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

    private static float toTangent(float r5) {
        if (r5 < 0.0f) goto L9;
        if (r5 > 90.0f) goto L9;
        return (float) Math.tan(Math.toRadians(r5 / 2.0f));
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
    @NonNull
    public Path getPath(float r12, float r13, float r14, float r15) {
        Path r10 = new Path();
        r10.moveTo(r12, r13);
        float r5 = r14 - r12;
        float r11 = r15 - r13;
        float r16 = (r11 * r11) + (r5 * r5);
        float r17 = (r12 + r14) / 2.0f;
        float r18 = (r13 + r15) / 2.0f;
        float r19 = 0.25f * r16;
        if (r13 <= r15) goto L5;
        boolean r20 = true;
    L7:
        if (Math.abs(r5) >= Math.abs(r11)) goto L14;
        float r21 = Math.abs(r16 / (r11 * 2.0f));
        if (r20 == false) goto L11;
        float r22 = r21 + r15;
        float r23 = r14;
    L12:
        float r24 = this.mMinimumVerticalTangent;
    L13:
        float r25 = (r19 * r24) * r24;
        float r26 = r17 - r23;
        float r27 = r18 - r22;
        float r28 = (r27 * r27) + (r26 * r26);
        float r110 = this.mMaximumTangent;
        float r29 = (r19 * r110) * r110;
        if (r28 < r25) goto L27;
        if (r28 <= r29) goto L25;
        r25 = r29;
        goto L27
    L25:
        r25 = 0.0f;
    L27:
        if (r25 == 0.0f) goto L29;
        float r111 = (float) Math.sqrt(r25 / r28);
        r23 = j0.b(r23, r17, r111, r17);
        r22 = j0.b(r22, r18, r111, r18);
    L29:
        r10.cubicTo((r12 + r23) / 2.0f, (r13 + r22) / 2.0f, (r23 + r14) / 2.0f, (r22 + r15) / 2.0f, r14, r15);
        return r10;
    L11:
        r22 = r21 + r13;
        r23 = r12;
        goto L12
    L14:
        float r30 = r16 / (r5 * 2.0f);
        if (r20 == false) goto L17;
        r22 = r13;
        r23 = r30 + r12;
    L18:
        r24 = this.mMinimumHorizontalTangent;
        goto L13
    L17:
        r23 = r14 - r30;
        r22 = r15;
        goto L18
    L5:
        r20 = false;
        goto L7
    }

    public void setMaximumAngle(float r5) {
        this.mMaximumAngle = r5;
        this.mMaximumTangent = toTangent(r5);
    }

    public void setMinimumHorizontalAngle(float r5) {
        this.mMinimumHorizontalAngle = r5;
        this.mMinimumHorizontalTangent = toTangent(r5);
    }

    public void setMinimumVerticalAngle(float r5) {
        this.mMinimumVerticalAngle = r5;
        this.mMinimumVerticalTangent = toTangent(r5);
    }

    public ArcMotion(@NonNull Context r5, @NonNull AttributeSet r10) {
        super(r5, r10);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray r11 = r5.obtainStyledAttributes(r10, Styleable.ARC_MOTION);
        XmlPullParser r12 = (XmlPullParser) r10;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(r11, r12, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(r11, r12, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(r11, r12, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        r11.recycle();
    }
}
