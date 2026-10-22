package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {
    private Path mOriginalPatternPath;

    @NonNull
    private final Path mPatternPath;
    private final Matrix mTempMatrix;

    public PatternPathMotion() {
        Path r5 = new Path();
        this.mPatternPath = r5;
        this.mTempMatrix = new Matrix();
        r5.lineTo(1.0f, 0.0f);
        this.mOriginalPatternPath = r5;
    }

    private static float distance(float r5, float r10) {
        return (float) Math.sqrt((r10 * r10) + (r5 * r5));
    }

    @Override // androidx.transition.PathMotion
    @NonNull
    public Path getPath(float r5, float r10, float r11, float r12) {
        float r13 = r11 - r5;
        float r14 = r12 - r10;
        float r15 = distance(r13, r14);
        double r16 = Math.atan2(r14, r13);
        this.mTempMatrix.setScale(r15, r15);
        this.mTempMatrix.postRotate((float) Math.toDegrees(r16));
        this.mTempMatrix.postTranslate(r5, r10);
        Path r17 = new Path();
        this.mPatternPath.transform(this.mTempMatrix, r17);
        return r17;
    }

    @NonNull
    public Path getPatternPath() {
        return this.mOriginalPatternPath;
    }

    public void setPatternPath(@NonNull Path r10) {
        PathMeasure r5 = new PathMeasure(r10, false);
        float[] r11 = new float[2];
        r5.getPosTan(r5.getLength(), r11, null);
        float r12 = r11[0];
        float r13 = r11[1];
        r5.getPosTan(0.0f, r11, null);
        float r14 = r11[0];
        float r15 = r11[1];
        if (r14 == r12) goto L5;
    L9:
        this.mTempMatrix.setTranslate(-r14, -r15);
        float r16 = r12 - r14;
        float r17 = r13 - r15;
        float r18 = 1.0f / distance(r16, r17);
        this.mTempMatrix.postScale(r18, r18);
        this.mTempMatrix.postRotate((float) Math.toDegrees(-Math.atan2(r17, r16)));
        r10.transform(this.mTempMatrix, this.mPatternPath);
        this.mOriginalPatternPath = r10;
        return;
    L5:
        if (r15 != r13) goto L9;
        throw new IllegalArgumentException("pattern must not end at the starting point");
    }

    public PatternPathMotion(@NonNull Context r5, @NonNull AttributeSet r10) {
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        TypedArray r11 = r5.obtainStyledAttributes(r10, Styleable.PATTERN_PATH_MOTION);
        String r12 = TypedArrayUtils.getNamedString(r11, (XmlPullParser) r10, "patternPathData", 0);     // Catch: Throwable -> L8
        if (r12 == null) goto L11;
        setPatternPath(PathParser.createPathFromPathData(r12));     // Catch: Throwable -> L8
        r11.recycle();
        return;
    L11:
        throw new RuntimeException("pathData must be supplied for patternPathMotion");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    public PatternPathMotion(@NonNull Path r5) {
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        setPatternPath(r5);
    }
}
