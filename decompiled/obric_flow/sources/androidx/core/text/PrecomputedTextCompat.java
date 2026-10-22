package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Trace;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class PrecomputedTextCompat implements Spannable {
    private static final char LINE_FEED = '\n';

    @NonNull
    @GuardedBy("sLock")
    private static Executor sExecutor;
    private static final Object sLock = null;

    @NonNull
    private final int[] mParagraphEnds;

    @NonNull
    private final Params mParams;

    @NonNull
    private final Spannable mText;

    @Nullable
    private final PrecomputedText mWrapped;

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static Spannable castToSpannable(PrecomputedText r5) {
            return r5;
        }
    }

    public static final class Params {
        private final int mBreakStrategy;
        private final int mHyphenationFrequency;

        @NonNull
        private final TextPaint mPaint;

        @Nullable
        private final TextDirectionHeuristic mTextDir;
        final PrecomputedText.Params mWrapped;

        public static class Builder {
            private int mBreakStrategy;
            private int mHyphenationFrequency;

            @NonNull
            private final TextPaint mPaint;
            private TextDirectionHeuristic mTextDir;

            public Builder(@NonNull TextPaint r5) {
                this.mPaint = r5;
                this.mBreakStrategy = 1;
                this.mHyphenationFrequency = 1;
                this.mTextDir = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            @NonNull
            public Params build() {
                return new Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
            }

            @RequiresApi(23)
            public Builder setBreakStrategy(int r5) {
                this.mBreakStrategy = r5;
                return this;
            }

            @RequiresApi(23)
            public Builder setHyphenationFrequency(int r5) {
                this.mHyphenationFrequency = r5;
                return this;
            }

            public Builder setTextDirection(@NonNull TextDirectionHeuristic r5) {
                this.mTextDir = r5;
                return this;
            }
        }

        public Params(@NonNull TextPaint r5, @NonNull TextDirectionHeuristic r10, int r11, int r12) {
            this.mWrapped = new PrecomputedText.Params.Builder(r5).setBreakStrategy(r11).setHyphenationFrequency(r12).setTextDirection(r10).build();
            this.mPaint = r5;
            this.mTextDir = r10;
            this.mBreakStrategy = r11;
            this.mHyphenationFrequency = r12;
        }

        public boolean equals(@Nullable Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof Params) == true) goto L8;
            return false;
        L8:
            Params r10 = (Params) r5;
            if (equalsWithoutTextDirection(r10) == true) goto L12;
            return false;
        L12:
            if (this.mTextDir != r10.getTextDirection()) goto L15;
            return true;
        L15:
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean equalsWithoutTextDirection(@NonNull Params r5) {
            if (this.mBreakStrategy == r5.getBreakStrategy()) goto L6;
            return false;
        L6:
            if (this.mHyphenationFrequency == r5.getHyphenationFrequency()) goto L9;
            return false;
        L9:
            if (this.mPaint.getTextSize() == r5.getTextPaint().getTextSize()) goto L12;
            return false;
        L12:
            if (this.mPaint.getTextScaleX() == r5.getTextPaint().getTextScaleX()) goto L15;
            return false;
        L15:
            if (this.mPaint.getTextSkewX() == r5.getTextPaint().getTextSkewX()) goto L18;
            return false;
        L18:
            if (this.mPaint.getLetterSpacing() == r5.getTextPaint().getLetterSpacing()) goto L21;
            return false;
        L21:
            if (TextUtils.equals(this.mPaint.getFontFeatureSettings(), r5.getTextPaint().getFontFeatureSettings()) == true) goto L24;
            return false;
        L24:
            if (this.mPaint.getFlags() == r5.getTextPaint().getFlags()) goto L27;
            return false;
        L27:
            if (this.mPaint.getTextLocales().equals(r5.getTextPaint().getTextLocales()) == true) goto L30;
            return false;
        L30:
            if (this.mPaint.getTypeface() != null) goto L35;
            if (r5.getTextPaint().getTypeface() == null) goto L37;
            return false;
        L37:
            return true;
        L35:
            if (this.mPaint.getTypeface().equals(r5.getTextPaint().getTypeface()) == true) goto L39;
            return false;
        L39:
            return true;
        }

        @RequiresApi(23)
        public int getBreakStrategy() {
            return this.mBreakStrategy;
        }

        @RequiresApi(23)
        public int getHyphenationFrequency() {
            return this.mHyphenationFrequency;
        }

        @Nullable
        public TextDirectionHeuristic getTextDirection() {
            return this.mTextDir;
        }

        @NonNull
        public TextPaint getTextPaint() {
            return this.mPaint;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("{");
            r5.append("textSize=" + this.mPaint.getTextSize());
            r5.append(", textScaleX=" + this.mPaint.getTextScaleX());
            r5.append(", textSkewX=" + this.mPaint.getTextSkewX());
            r5.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
            r5.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
            r5.append(", textLocale=" + this.mPaint.getTextLocales());
            r5.append(", typeface=" + this.mPaint.getTypeface());
            r5.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
            r5.append(", textDir=" + this.mTextDir);
            r5.append(", breakStrategy=" + this.mBreakStrategy);
            r5.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            r5.append("}");
            return r5.toString();
        }

        @RequiresApi(28)
        public Params(@NonNull PrecomputedText.Params r5) {
            this.mPaint = r5.getTextPaint();
            this.mTextDir = r5.getTextDirection();
            this.mBreakStrategy = r5.getBreakStrategy();
            this.mHyphenationFrequency = r5.getHyphenationFrequency();
            this.mWrapped = r5;
        }
    }

    public static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        public static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
            private Params mParams;
            private CharSequence mText;

            public PrecomputedTextCallback(@NonNull Params r5, @NonNull CharSequence r10) {
                this.mParams = r5;
                this.mText = r10;
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ PrecomputedTextCompat call() throws Exception {
                return call();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PrecomputedTextCompat call() throws Exception {
                return PrecomputedTextCompat.create(this.mText, this.mParams);
            }
        }

        public PrecomputedTextFutureTask(@NonNull Params r5, @NonNull CharSequence r10) {
            super(new PrecomputedTextCallback(r5, r10));
        }
    }

    static {
        sLock = new Object();
    }

    private PrecomputedTextCompat(@NonNull CharSequence r5, @NonNull Params r10, @NonNull int[] r11) {
        this.mText = new SpannableString(r5);
        this.mParams = r10;
        this.mParagraphEnds = r11;
        this.mWrapped = null;
    }

    @SuppressLint({"WrongConstant"})
    public static PrecomputedTextCompat create(@NonNull CharSequence r5, @NonNull Params r10) {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r10);
        Trace.beginSection("PrecomputedText");     // Catch: Throwable -> L8
        PrecomputedText.Params r11 = r10.mWrapped;     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        PrecomputedTextCompat r12 = new PrecomputedTextCompat(PrecomputedText.create(r5, r11), r10);     // Catch: Throwable -> L8
        Trace.endSection();
        return r12;
    L10:
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L8
        int r14 = r5.length();     // Catch: Throwable -> L8
        int r15 = 0;
    L11:
        if (r15 >= r14) goto L17;
        int r16 = TextUtils.indexOf(r5, LINE_FEED, r15, r14);     // Catch: Throwable -> L8
        if (r16 >= 0) goto L15;
        r15 = r14;
    L16:
        r13.add(Integer.valueOf(r15));     // Catch: Throwable -> L8
        goto L11
    L15:
        r15 = r16 + 1;     // Catch: Throwable -> L8
        goto L16
    L17:
        int[] r17 = new int[r13.size()];     // Catch: Throwable -> L8
        int r18 = 0;
    L19:
        if (r18 >= r13.size()) goto L21;
        r17[r18] = ((Integer) r13.get(r18)).intValue();     // Catch: Throwable -> L8
        r18 = r18 + 1;     // Catch: Throwable -> L8
        goto L19
    L21:
        StaticLayout.Builder.obtain(r5, 0, r5.length(), r10.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(r10.getBreakStrategy()).setHyphenationFrequency(r10.getHyphenationFrequency()).setTextDirection(r10.getTextDirection()).build();     // Catch: Throwable -> L8
        PrecomputedTextCompat r19 = new PrecomputedTextCompat(r5, r10, r17);     // Catch: Throwable -> L8
        Trace.endSection();
        return r19;
    L8:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    @UiThread
    public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence r5, @NonNull Params r10, @Nullable Executor r11) {
        PrecomputedTextFutureTask r12 = new PrecomputedTextFutureTask(r10, r5);
        if (r11 != null) goto L16;
        Object r13 = sLock;
        monitor-enter(r13);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sExecutor != null) goto L11;
        sExecutor = Executors.newFixedThreadPool(1);     // Catch: Throwable -> L9
    L11:
        r11 = sExecutor;     // Catch: Throwable -> L9
        monitor-exit(r13);     // Catch: Throwable -> L9
    L16:
        r11.execute(r12);
        return r12;
    }

    @Override // java.lang.CharSequence
    public char charAt(int r5) {
        return this.mText.charAt(r5);
    }

    @IntRange(from = 0)
    public int getParagraphCount() {
        return this.mWrapped.getParagraphCount();
    }

    @IntRange(from = 0)
    public int getParagraphEnd(@IntRange(from = 0) int r5) {
        Preconditions.checkArgumentInRange(r5, 0, getParagraphCount(), "paraIndex");
        return this.mWrapped.getParagraphEnd(r5);
    }

    @IntRange(from = 0)
    public int getParagraphStart(@IntRange(from = 0) int r5) {
        Preconditions.checkArgumentInRange(r5, 0, getParagraphCount(), "paraIndex");
        return this.mWrapped.getParagraphStart(r5);
    }

    @NonNull
    public Params getParams() {
        return this.mParams;
    }

    @Nullable
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PrecomputedText getPrecomputedText() {
        Spannable r5 = this.mText;
        if ((r5 instanceof PrecomputedText) == true) goto L5;
        return null;
    L5:
        return (PrecomputedText) r5;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object r5) {
        return this.mText.getSpanEnd(r5);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object r5) {
        return this.mText.getSpanFlags(r5);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object r5) {
        return this.mText.getSpanStart(r5);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int r5, int r10, Class<T> r11) {
        return (T[]) this.mWrapped.getSpans(r5, r10, r11);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mText.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int r5, int r10, Class r11) {
        return this.mText.nextSpanTransition(r5, r10, r11);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object r5) {
        if ((r5 instanceof MetricAffectingSpan) == true) goto L7;
        this.mWrapped.removeSpan(r5);
        return;
    L7:
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object r5, int r10, int r11, int r12) {
        if ((r5 instanceof MetricAffectingSpan) == true) goto L7;
        this.mWrapped.setSpan(r5, r10, r11, r12);
        return;
    L7:
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r5, int r10) {
        return this.mText.subSequence(r5, r10);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.mText.toString();
    }

    @RequiresApi(28)
    private PrecomputedTextCompat(@NonNull PrecomputedText r5, @NonNull Params r10) {
        this.mText = Api28Impl.castToSpannable(r5);
        this.mParams = r10;
        this.mParagraphEnds = null;
        this.mWrapped = r5;
    }
}
