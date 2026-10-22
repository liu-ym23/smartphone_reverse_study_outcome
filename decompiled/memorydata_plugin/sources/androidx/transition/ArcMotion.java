package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public ArcMotion(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r7, r8);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray r9 = r7.obtainStyledAttributes(r8, Styleable.ARC_MOTION);
        XmlPullParser r10 = (XmlPullParser) ZeusTransformUtils.preCheckCast(r8, XmlPullParser.class, "com.obric.memorydata.plugin");
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(r9, r10, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(r9, r10, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(r9, r10, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        r9.recycle();
    }

    private static float toTangent(float r2) {
        if (r2 < 0.0f) goto L9;
        if (r2 > 90.0f) goto L9;
        return (float) Math.tan(Math.toRadians(r2 / 2.0f));
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
        Path r7 = new Path();
        r7.moveTo(r12, r13);
        float r0 = r14 - r12;
        float r1 = r15 - r13;
        float r2 = (r0 * r0) + (r1 * r1);
        float r3 = (r12 + r14) / 2.0f;
        float r5 = (r13 + r15) / 2.0f;
        float r6 = 0.25f * r2;
        if (r13 <= r15) goto L5;
        boolean r8 = true;
    L7:
        if (Math.abs(r0) >= Math.abs(r1)) goto L13;
        float r4 = Math.abs(r2 / (r1 * 2.0f));
        if (r8 == false) goto L11;
        float r9 = r4 + r15;
        float r10 = r14;
    L12:
        float r11 = this.mMinimumVerticalTangent;
    L18:
        float r16 = (r6 * r11) * r11;
        float r17 = r3 - r10;
        float r18 = r5 - r9;
        float r19 = (r17 * r17) + (r18 * r18);
        float r110 = this.mMaximumTangent;
        float r20 = (r6 * r110) * r110;
        if (r19 < r16) goto L26;
        if (r19 <= r20) goto L24;
        r16 = r20;
        goto L26
    L24:
        r16 = 0.0f;
    L26:
        if (r16 == 0.0f) goto L28;
        float r111 = (float) Math.sqrt(r16 / r19);
        r10 = ((r10 - r3) * r111) + r3;
        r9 = r5 + (r111 * (r9 - r5));
    L28:
        r7.cubicTo((r12 + r10) / 2.0f, (r13 + r9) / 2.0f, (r10 + r14) / 2.0f, (r9 + r15) / 2.0f, r14, r15);
        return r7;
    L11:
        r9 = r4 + r13;
        r10 = r12;
        goto L12
    L13:
        float r21 = r2 / (r0 * 2.0f);
        if (r8 == false) goto L16;
        r9 = r13;
        r10 = r21 + r12;
    L17:
        r11 = this.mMinimumHorizontalTangent;
        goto L18
    L16:
        r10 = r14 - r21;
        r9 = r15;
        goto L17
    L5:
        r8 = false;
        goto L7
    }

    public void setMaximumAngle(float r1) {
        this.mMaximumAngle = r1;
        this.mMaximumTangent = toTangent(r1);
    }

    public void setMinimumHorizontalAngle(float r1) {
        this.mMinimumHorizontalAngle = r1;
        this.mMinimumHorizontalTangent = toTangent(r1);
    }

    public void setMinimumVerticalAngle(float r1) {
        this.mMinimumVerticalAngle = r1;
        this.mMinimumVerticalTangent = toTangent(r1);
    }
}
