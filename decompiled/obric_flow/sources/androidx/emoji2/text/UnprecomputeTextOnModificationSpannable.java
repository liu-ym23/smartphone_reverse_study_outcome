package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
class UnprecomputeTextOnModificationSpannable implements Spannable {

    @NonNull
    private Spannable mDelegate;
    private boolean mSafeToWrite;

    @RequiresApi(24)
    public static class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
        }

        public static IntStream chars(CharSequence r5) {
            return r5.chars();
        }

        public static IntStream codePoints(CharSequence r5) {
            return r5.codePoints();
        }
    }

    public static class PrecomputedTextDetector {
        public PrecomputedTextDetector() {
        }

        public boolean isPrecomputedText(CharSequence r5) {
            return r5 instanceof PrecomputedTextCompat;
        }
    }

    @RequiresApi(28)
    public static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        public PrecomputedTextDetector_28() {
        }

        @Override // androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector
        public boolean isPrecomputedText(CharSequence r5) {
            if ((r5 instanceof PrecomputedText) == false) goto L5;
        L8:
            return true;
        L5:
            if ((r5 instanceof PrecomputedTextCompat) == true) goto L8;
            return false;
        }
    }

    public UnprecomputeTextOnModificationSpannable(@NonNull Spannable r5) {
        this.mSafeToWrite = false;
        this.mDelegate = r5;
    }

    private void ensureSafeWrites() {
        Spannable r5 = this.mDelegate;
        if (this.mSafeToWrite == false) goto L5;
    L7:
        this.mSafeToWrite = true;
        return;
    L5:
        if (precomputedTextDetector().isPrecomputedText(r5) == false) goto L7;
        this.mDelegate = new SpannableString(r5);
        goto L7
    }

    public static PrecomputedTextDetector precomputedTextDetector() {
        return new PrecomputedTextDetector_28();
    }

    @Override // java.lang.CharSequence
    public char charAt(int r5) {
        return this.mDelegate.charAt(r5);
    }

    @Override // java.lang.CharSequence
    @NonNull
    @RequiresApi(api = 24)
    public IntStream chars() {
        return CharSequenceHelper_API24.chars(this.mDelegate);
    }

    @Override // java.lang.CharSequence
    @NonNull
    @RequiresApi(api = 24)
    public IntStream codePoints() {
        return CharSequenceHelper_API24.codePoints(this.mDelegate);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object r5) {
        return this.mDelegate.getSpanEnd(r5);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object r5) {
        return this.mDelegate.getSpanFlags(r5);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object r5) {
        return this.mDelegate.getSpanStart(r5);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int r5, int r10, Class<T> r11) {
        return (T[]) this.mDelegate.getSpans(r5, r10, r11);
    }

    public Spannable getUnwrappedSpannable() {
        return this.mDelegate;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mDelegate.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int r5, int r10, Class r11) {
        return this.mDelegate.nextSpanTransition(r5, r10, r11);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object r5) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(r5);
    }

    @Override // android.text.Spannable
    public void setSpan(Object r5, int r10, int r11, int r12) {
        ensureSafeWrites();
        this.mDelegate.setSpan(r5, r10, r11, r12);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public CharSequence subSequence(int r5, int r10) {
        return this.mDelegate.subSequence(r5, r10);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.mDelegate.toString();
    }

    public UnprecomputeTextOnModificationSpannable(@NonNull Spanned r5) {
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(r5);
    }

    public UnprecomputeTextOnModificationSpannable(@NonNull CharSequence r5) {
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(r5);
    }
}
