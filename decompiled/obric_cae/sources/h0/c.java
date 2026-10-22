package h0;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Spannable {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextPaint f7880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f7881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7882c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f7883d;

        public a(PrecomputedText.Params r8) {
            this.f7880a = r8.getTextPaint();
            this.f7881b = r8.getTextDirection();
            this.f7882c = r8.getBreakStrategy();
            this.f7883d = r8.getHyphenationFrequency();
        }

        public final boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r10 = (a) r8;
            if (this.f7882c == r10.f7882c) goto L12;
        L10:
            boolean r11 = false;
        L44:
            if (r11 == true) goto L47;
            return false;
        L47:
            if (this.f7881b == r10.f7881b) goto L49;
            return false;
        L49:
            return true;
        L12:
            if (this.f7883d != r10.f7883d) goto L10;
            TextPaint r12 = this.f7880a;
            float r13 = r12.getTextSize();
            TextPaint r14 = r10.f7880a;
            if (r13 != r14.getTextSize()) goto L10;
            if (r12.getTextScaleX() != r14.getTextScaleX()) goto L10;
            if (r12.getTextSkewX() != r14.getTextSkewX()) goto L10;
            if (r12.getLetterSpacing() != r14.getLetterSpacing()) goto L10;
            if (TextUtils.equals(r12.getFontFeatureSettings(), r14.getFontFeatureSettings()) == false) goto L10;
            if (r12.getFlags() != r14.getFlags()) goto L10;
            if (r12.getTextLocales().equals(r14.getTextLocales()) == false) goto L10;
            if (r12.getTypeface() != null) goto L41;
            if (r14.getTypeface() != null) goto L10;
        L43:
            r11 = true;
            goto L44
        L41:
            if (r12.getTypeface().equals(r14.getTypeface()) == true) goto L43;
            goto L43
        }

        public final int hashCode() {
            TextPaint r8 = this.f7880a;
            return i0.b.b(new Object[]{Float.valueOf(r8.getTextSize()), Float.valueOf(r8.getTextScaleX()), Float.valueOf(r8.getTextSkewX()), Float.valueOf(r8.getLetterSpacing()), Integer.valueOf(r8.getFlags()), r8.getTextLocales(), r8.getTypeface(), Boolean.valueOf(r8.isElegantTextHeight()), this.f7881b, Integer.valueOf(this.f7882c), Integer.valueOf(this.f7883d)});
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder("{");
            StringBuilder r10 = new StringBuilder("textSize=");
            TextPaint r11 = this.f7880a;
            r10.append(r11.getTextSize());
            r8.append(r10.toString());
            r8.append(", textScaleX=" + r11.getTextScaleX());
            r8.append(", textSkewX=" + r11.getTextSkewX());
            r8.append(", letterSpacing=" + r11.getLetterSpacing());
            r8.append(", elegantTextHeight=" + r11.isElegantTextHeight());
            r8.append(", textLocale=" + r11.getTextLocales());
            r8.append(", typeface=" + r11.getTypeface());
            r8.append(", variationSettings=" + r11.getFontVariationSettings());
            r8.append(", textDir=" + this.f7881b);
            r8.append(", breakStrategy=" + this.f7882c);
            r8.append(", hyphenationFrequency=" + this.f7883d);
            r8.append("}");
            return r8.toString();
        }
    }

    @Override // java.lang.CharSequence
    public final char charAt(int r8) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object r8) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object r8) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object r8) {
        throw null;
    }

    @Override // android.text.Spanned
    public final <T> T[] getSpans(int r8, int r10, Class<T> r11) {
        throw null;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        throw null;
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int r8, int r10, Class r11) {
        throw null;
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object r8) {
        if ((r8 instanceof MetricAffectingSpan) == true) goto L7;
        throw null;
    L7:
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public final void setSpan(Object r8, int r10, int r11, int r12) {
        if ((r8 instanceof MetricAffectingSpan) == true) goto L7;
        throw null;
    L7:
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int r8, int r10) {
        throw null;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        throw null;
    }
}
