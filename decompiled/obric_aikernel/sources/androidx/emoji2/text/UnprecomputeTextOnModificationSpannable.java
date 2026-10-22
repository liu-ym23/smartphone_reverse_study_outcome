package androidx.emoji2.text;

import android.os.Build;
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
    private static class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
        }

        static IntStream chars(CharSequence r10) {
            return r10.chars();
        }

        static IntStream codePoints(CharSequence r10) {
            return r10.codePoints();
        }
    }

    static class PrecomputedTextDetector {
        PrecomputedTextDetector() {
        }

        boolean isPrecomputedText(CharSequence r10) {
            return r10 instanceof PrecomputedTextCompat;
        }
    }

    @RequiresApi(28)
    static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        PrecomputedTextDetector_28() {
        }

        @Override // androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector
        boolean isPrecomputedText(CharSequence r10) {
            if ((r10 instanceof PrecomputedText) == false) goto L5;
        L8:
            return true;
        L5:
            if ((r10 instanceof PrecomputedTextCompat) == true) goto L8;
            return false;
        }
    }

    UnprecomputeTextOnModificationSpannable(@NonNull Spannable r10) {
        this.mSafeToWrite = false;
        this.mDelegate = r10;
    }

    UnprecomputeTextOnModificationSpannable(@NonNull Spanned r10) {
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(r10);
    }

    UnprecomputeTextOnModificationSpannable(@NonNull CharSequence r10) {
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(r10);
    }

    private void ensureSafeWrites() {
        Spannable r10 = this.mDelegate;
        if (this.mSafeToWrite == false) goto L5;
    L7:
        this.mSafeToWrite = true;
        return;
    L5:
        if (precomputedTextDetector().isPrecomputedText(r10) == false) goto L7;
        this.mDelegate = new SpannableString(r10);
        goto L7
    }

    static PrecomputedTextDetector precomputedTextDetector() {
        if (Build.VERSION.SDK_INT >= 28) goto L6;
        return new PrecomputedTextDetector();
    L6:
        return new PrecomputedTextDetector_28();
    }

    @Override // java.lang.CharSequence
    public char charAt(int r10) {
        return this.mDelegate.charAt(r10);
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
    public int getSpanEnd(Object r10) {
        return this.mDelegate.getSpanEnd(r10);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object r10) {
        return this.mDelegate.getSpanFlags(r10);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object r10) {
        return this.mDelegate.getSpanStart(r10);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int r10, int r11, Class<T> r12) {
        return (T[]) this.mDelegate.getSpans(r10, r11, r12);
    }

    Spannable getUnwrappedSpannable() {
        return this.mDelegate;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mDelegate.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int r10, int r11, Class r12) {
        return this.mDelegate.nextSpanTransition(r10, r11, r12);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object r10) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(r10);
    }

    @Override // android.text.Spannable
    public void setSpan(Object r10, int r11, int r12, int r13) {
        ensureSafeWrites();
        this.mDelegate.setSpan(r10, r11, r12, r13);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public CharSequence subSequence(int r10, int r11) {
        return this.mDelegate.subSequence(r10, r11);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.mDelegate.toString();
    }
}
