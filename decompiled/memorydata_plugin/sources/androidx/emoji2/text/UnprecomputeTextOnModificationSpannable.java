package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.core.text.PrecomputedTextCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
class UnprecomputeTextOnModificationSpannable implements Spannable {
    private Spannable mDelegate;
    private boolean mSafeToWrite;

    private static class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
        }

        static IntStream chars(CharSequence r2) {
            return ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin")).chars();
        }

        static IntStream codePoints(CharSequence r2) {
            return ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin")).codePoints();
        }
    }

    static class PrecomputedTextDetector {
        PrecomputedTextDetector() {
        }

        boolean isPrecomputedText(CharSequence r2) {
            return ZeusTransformUtils.instanceOf((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), PrecomputedTextCompat.class);
        }
    }

    static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        PrecomputedTextDetector_28() {
        }

        @Override // androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector
        boolean isPrecomputedText(CharSequence r2) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r1, PrecomputedText.class) == false) goto L5;
        L8:
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r1, PrecomputedTextCompat.class) == true) goto L8;
            return false;
        }
    }

    UnprecomputeTextOnModificationSpannable(Spannable r3) {
        Spannable r4 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r3, Spannable.class, "com.obric.memorydata.plugin");
        this.mSafeToWrite = false;
        this.mDelegate = r4;
    }

    UnprecomputeTextOnModificationSpannable(Spanned r3) {
        Spanned r4 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r3, Spanned.class, "com.obric.memorydata.plugin");
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(r4);
    }

    UnprecomputeTextOnModificationSpannable(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(r4);
    }

    private void ensureSafeWrites() {
        Spannable r0 = this.mDelegate;
        if (this.mSafeToWrite == false) goto L5;
    L7:
        this.mSafeToWrite = true;
        return;
    L5:
        if (precomputedTextDetector().isPrecomputedText(r0) == false) goto L7;
        this.mDelegate = new SpannableString(r0);
        goto L7
    }

    static PrecomputedTextDetector precomputedTextDetector() {
        if (Build.VERSION.SDK_INT >= 28) goto L6;
        return new PrecomputedTextDetector();
    L6:
        return new PrecomputedTextDetector_28();
    }

    @Override // java.lang.CharSequence
    public char charAt(int r1) {
        return this.mDelegate.charAt(r1);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return CharSequenceHelper_API24.chars(this.mDelegate);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return CharSequenceHelper_API24.codePoints(this.mDelegate);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object r1) {
        return this.mDelegate.getSpanEnd(r1);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object r1) {
        return this.mDelegate.getSpanFlags(r1);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object r1) {
        return this.mDelegate.getSpanStart(r1);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int r1, int r2, Class<T> r3) {
        return (T[]) this.mDelegate.getSpans(r1, r2, r3);
    }

    Spannable getUnwrappedSpannable() {
        return this.mDelegate;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mDelegate.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int r1, int r2, Class r3) {
        return this.mDelegate.nextSpanTransition(r1, r2, r3);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object r1) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(r1);
    }

    @Override // android.text.Spannable
    public void setSpan(Object r1, int r2, int r3, int r4) {
        ensureSafeWrites();
        this.mDelegate.setSpan(r1, r2, r3, r4);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r1, int r2) {
        return this.mDelegate.subSequence(r1, r2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.mDelegate.toString();
    }
}
