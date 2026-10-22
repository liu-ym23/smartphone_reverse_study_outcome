package com.lynx.textra;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class JavaTypeface {
    private float dpi;
    public Font mFont;
    public FontKey mFontKey;
    private final Paint.FontMetrics mFontMetrics;
    public int mIndex;
    public long mNativeHandler;
    private float mTextSize;
    public Typeface mTypeface;

    public static class FontKey {
        String mFontFamily;
        int mFontWeight;
        boolean mItalic;

        public int hashCode() {
            return Objects.hash(new Object[]{this.mFontFamily, Integer.valueOf(this.mFontWeight), Boolean.valueOf(this.mItalic)});
        }

        public FontKey() {
            this.mFontFamily = NameKeys.UnloadStrategy_No_Strategy;
            this.mFontWeight = 400;
            this.mItalic = false;
        }

        public boolean equals(Object r4) {
            if (r4 != null) goto L5;
            return false;
        L5:
            if (getClass() != r4.getClass()) goto L19;
            FontKey r5 = (FontKey) r4;
            if (this.mFontWeight == r5.mFontWeight) goto L10;
            return false;
        L10:
            if (this.mItalic == r5.mItalic) goto L12;
            return false;
        L12:
            if (Objects.equals(this.mFontFamily, r5.mFontFamily) == false) goto L18;
            return true;
        L18:
            return false;
        L19:
            return false;
        }
    }

    public native void BindNativeHandler(long r1, JavaTypeface r3, int r4);

    public int hashCode() {
        return Objects.hash(new Object[]{this.mFontKey});
    }

    public float[] GetFontMetrics(float r5) {
        float[] r0 = new float[2];
        float r1 = this.mTextSize;
        if (r1 != 0.0f) goto L5;
    L8:
        TTText.mPainter.setTypeface(this.mTypeface);
        TTText.mPainter.setTextSize(TTTextUtils.Dp2Px(r5));
        TTText.mPainter.getFontMetrics(this.mFontMetrics);
        this.dpi = TTTextUtils.density_;
    L9:
        this.mTextSize = r5;
        r0[0] = TTTextUtils.Px2Dp(this.mFontMetrics.ascent);
        r0[1] = TTTextUtils.Px2Dp(this.mFontMetrics.descent);
        return r0;
    L5:
        if (this.dpi != TTTextUtils.density_) goto L8;
        float r2 = r5 / r1;
        Paint.FontMetrics r3 = this.mFontMetrics;
        r3.ascent *= r2;
        r3.descent *= r2;
        goto L9
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L15;
        if (this.mFontKey == ((JavaTypeface) r5).mFontKey) goto L16;
        return false;
    L16:
        return true;
    }

    public float[] GetTextBounds(char[] r4, float r5) {
        Paint r0 = TTText.mPainter;
        Rect r1 = new Rect();
        r0.setTypeface(this.mTypeface);
        r0.setTextSize(r5);
        r0.getTextBounds(r4, 0, r4.length, r1);
        return new float[]{r1.left, r1.top, r1.right, r1.bottom};
    }

    public JavaTypeface(int r2, Typeface r3, FontKey r4, long r5) {
        this.mTypeface = null;
        this.mFont = null;
        this.mFontMetrics = new Paint.FontMetrics();
        this.mTextSize = 0.0f;
        this.dpi = 1.0f;
        this.mIndex = r2;
        this.mTypeface = r3;
        this.mFontKey = r4;
        this.mNativeHandler = r5;
        GetFontMetrics(24.0f);
        BindNativeHandler(r5, this, this.mIndex);
    }

    public JavaTypeface(int r2, Font r3, FontKey r4, long r5) {
        this.mTypeface = null;
        this.mFont = null;
        this.mFontMetrics = new Paint.FontMetrics();
        this.mTextSize = 0.0f;
        this.dpi = 1.0f;
        this.mIndex = r2;
        this.mFont = r3;
        this.mFontKey = r4;
        this.mNativeHandler = r5;
        BindNativeHandler(r5, this, r2);
    }
}
