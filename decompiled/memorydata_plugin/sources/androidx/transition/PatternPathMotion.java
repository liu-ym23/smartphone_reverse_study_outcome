package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {
    private Path mOriginalPatternPath;
    private final Path mPatternPath;
    private final Matrix mTempMatrix;

    public PatternPathMotion() {
        Path r0 = new Path();
        this.mPatternPath = r0;
        this.mTempMatrix = new Matrix();
        r0.lineTo(1.0f, 0.0f);
        this.mOriginalPatternPath = r0;
    }

    public PatternPathMotion(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        TypedArray r7 = r5.obtainStyledAttributes(r6, Styleable.PATTERN_PATH_MOTION);
        String r8 = TypedArrayUtils.getNamedString(r7, (XmlPullParser) ZeusTransformUtils.preCheckCast(r6, XmlPullParser.class, "com.obric.memorydata.plugin"), "patternPathData", 0);     // Catch: Throwable -> L10
        if (r8 == null) goto L9;
        setPatternPath(PathParser.createPathFromPathData(r8));     // Catch: Throwable -> L10
        r7.recycle();
        return;
    L9:
        throw new RuntimeException("pathData must be supplied for patternPathMotion");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    public PatternPathMotion(Path r2) {
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        setPatternPath(r2);
    }

    private static float distance(float r0, float r1) {
        return (float) Math.sqrt((r0 * r0) + (r1 * r1));
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float r4, float r5, float r6, float r7) {
        float r8 = r6 - r4;
        float r9 = r7 - r5;
        float r0 = distance(r8, r9);
        double r10 = Math.atan2(r9, r8);
        this.mTempMatrix.setScale(r0, r0);
        this.mTempMatrix.postRotate((float) Math.toDegrees(r10));
        this.mTempMatrix.postTranslate(r4, r5);
        Path r11 = new Path();
        this.mPatternPath.transform(this.mTempMatrix, r11);
        return r11;
    }

    public Path getPatternPath() {
        return this.mOriginalPatternPath;
    }

    public void setPatternPath(Path r9) {
        PathMeasure r0 = new PathMeasure(r9, false);
        float[] r3 = new float[2];
        r0.getPosTan(r0.getLength(), r3, null);
        float r2 = r3[0];
        float r6 = r3[1];
        r0.getPosTan(0.0f, r3, null);
        float r1 = r3[0];
        float r4 = r3[1];
        if (r1 == r2) goto L5;
    L9:
        this.mTempMatrix.setTranslate(-r1, -r4);
        float r5 = r2 - r1;
        float r7 = r6 - r4;
        float r8 = 1.0f / distance(r5, r7);
        this.mTempMatrix.postScale(r8, r8);
        this.mTempMatrix.postRotate((float) Math.toDegrees(-Math.atan2(r7, r5)));
        r9.transform(this.mTempMatrix, this.mPatternPath);
        this.mOriginalPatternPath = r9;
        return;
    L5:
        if (r4 != r6) goto L9;
        throw new IllegalArgumentException("pattern must not end at the starting point");
    }
}
