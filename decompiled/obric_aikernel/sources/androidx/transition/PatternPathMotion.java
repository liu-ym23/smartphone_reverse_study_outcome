package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {
    private Path mOriginalPatternPath;
    private final Path mPatternPath;
    private final Matrix mTempMatrix;

    public PatternPathMotion() {
        Path r10 = new Path();
        this.mPatternPath = r10;
        this.mTempMatrix = new Matrix();
        r10.lineTo(1.0f, 0.0f);
        this.mOriginalPatternPath = r10;
    }

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context r10, AttributeSet r11) {
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.PATTERN_PATH_MOTION);
        String r13 = TypedArrayUtils.getNamedString(r12, (XmlPullParser) r11, "patternPathData", 0);     // Catch: Throwable -> L10
        if (r13 == null) goto L9;
        setPatternPath(PathParser.createPathFromPathData(r13));     // Catch: Throwable -> L10
        r12.recycle();
        return;
    L9:
        throw new RuntimeException("pathData must be supplied for patternPathMotion");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    public PatternPathMotion(Path r10) {
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        setPatternPath(r10);
    }

    private static float distance(float r10, float r11) {
        return (float) Math.sqrt((r10 * r10) + (r11 * r11));
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float r10, float r11, float r12, float r13) {
        float r14 = r12 - r10;
        float r15 = r13 - r11;
        float r16 = distance(r14, r15);
        double r17 = Math.atan2(r15, r14);
        this.mTempMatrix.setScale(r16, r16);
        this.mTempMatrix.postRotate((float) Math.toDegrees(r17));
        this.mTempMatrix.postTranslate(r10, r11);
        Path r18 = new Path();
        this.mPatternPath.transform(this.mTempMatrix, r18);
        return r18;
    }

    public Path getPatternPath() {
        return this.mOriginalPatternPath;
    }

    public void setPatternPath(Path r10) {
        PathMeasure r11 = new PathMeasure(r10, false);
        float[] r12 = new float[2];
        r11.getPosTan(r11.getLength(), r12, null);
        float r13 = r12[0];
        float r14 = r12[1];
        r11.getPosTan(0.0f, r12, null);
        float r15 = r12[0];
        float r16 = r12[1];
        if (r15 == r13) goto L5;
    L9:
        this.mTempMatrix.setTranslate(-r15, -r16);
        float r17 = r13 - r15;
        float r18 = r14 - r16;
        float r19 = 1.0f / distance(r17, r18);
        this.mTempMatrix.postScale(r19, r19);
        this.mTempMatrix.postRotate((float) Math.toDegrees(-Math.atan2(r18, r17)));
        r10.transform(this.mTempMatrix, this.mPatternPath);
        this.mOriginalPatternPath = r10;
        return;
    L5:
        if (r16 != r14) goto L9;
        throw new IllegalArgumentException("pattern must not end at the starting point");
    }
}
