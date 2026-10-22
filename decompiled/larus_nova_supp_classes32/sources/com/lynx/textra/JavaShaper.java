package com.lynx.textra;

import android.graphics.Paint;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class JavaShaper {
    private BBufferOutputStream bs;
    private JavaFontManager mFontManager;
    private HashMap<Integer, JavaTypeface> mFontMap;
    private Paint mPaint;

    public JavaShapeResult OnShapeTextNew(String r1, JavaTypeface r2, float r3, boolean r4, boolean r5) {
        return null;
    }

    public JavaShaper(JavaFontManager r3) {
        this.mFontMap = new HashMap(10);
        this.mFontManager = null;
        this.bs = null;
        this.mPaint = new Paint();
        this.mFontManager = r3;
    }

    public float[] OnShapeText(String r2, JavaTypeface r3, float r4, boolean r5, boolean r6) {
        float[] r7 = new float[r2.length()];
        this.mPaint.setTypeface(r3.mTypeface);
        this.mPaint.setTextSize(TTTextUtils.Dp2Px(r4));
        this.mPaint.getTextWidths(r2, r7);
        int r8 = 0;
    L4:
        if (r8 >= r2.length()) goto L6;
        r7[r8] = TTTextUtils.Px2Dp(r7[r8]);
        r8 = r8 + 1;
        goto L4
    L6:
        r3.GetFontMetrics(r4);
        return r7;
    }
}
