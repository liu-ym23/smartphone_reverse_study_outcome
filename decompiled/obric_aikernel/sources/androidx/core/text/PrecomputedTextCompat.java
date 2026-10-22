package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.os.TraceCompat;
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

            public Builder(@NonNull TextPaint r10) {
                this.mPaint = r10;
                int r11 = Build.VERSION.SDK_INT;
                if (r11 < 23) goto L5;
                this.mBreakStrategy = 1;
                this.mHyphenationFrequency = 1;
            L7:
                if (r11 < 18) goto L9;
                TextDirectionHeuristic r12 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            L10:
                this.mTextDir = r12;
                return;
            L9:
                r12 = null;
                goto L10
            L5:
                this.mHyphenationFrequency = 0;
                this.mBreakStrategy = 0;
                goto L7
            }

            @NonNull
            public Params build() {
                return new Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
            }

            @RequiresApi(23)
            public Builder setBreakStrategy(int r10) {
                this.mBreakStrategy = r10;
                return this;
            }

            @RequiresApi(23)
            public Builder setHyphenationFrequency(int r10) {
                this.mHyphenationFrequency = r10;
                return this;
            }

            @RequiresApi(18)
            public Builder setTextDirection(@NonNull TextDirectionHeuristic r10) {
                this.mTextDir = r10;
                return this;
            }
        }

        @RequiresApi(28)
        public Params(@NonNull PrecomputedText.Params r10) {
            this.mPaint = r10.getTextPaint();
            this.mTextDir = r10.getTextDirection();
            this.mBreakStrategy = r10.getBreakStrategy();
            this.mHyphenationFrequency = r10.getHyphenationFrequency();
            if (Build.VERSION.SDK_INT >= 29) goto L6;
            r10 = null;
        L6:
            this.mWrapped = r10;
        }

        Params(@NonNull TextPaint r10, @NonNull TextDirectionHeuristic r11, int r12, int r13) {
            if (Build.VERSION.SDK_INT < 29) goto L5;
            PrecomputedText.Params r14 = new PrecomputedText.Params.Builder(r10).setBreakStrategy(r12).setHyphenationFrequency(r13).setTextDirection(r11).build();
        L6:
            this.mWrapped = r14;
            this.mPaint = r10;
            this.mTextDir = r11;
            this.mBreakStrategy = r12;
            this.mHyphenationFrequency = r13;
            return;
        L5:
            r14 = null;
            goto L6
        }

        public boolean equals(@Nullable Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof Params) == true) goto L8;
            return false;
        L8:
            Params r11 = (Params) r10;
            if (equalsWithoutTextDirection(r11) == true) goto L12;
            return false;
        L12:
            if (Build.VERSION.SDK_INT >= 18) goto L14;
        L16:
            return true;
        L14:
            if (this.mTextDir == r11.getTextDirection()) goto L16;
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean equalsWithoutTextDirection(@NonNull Params r10) {
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 23) goto L11;
            if (this.mBreakStrategy == r10.getBreakStrategy()) goto L8;
            return false;
        L8:
            if (this.mHyphenationFrequency == r10.getHyphenationFrequency()) goto L11;
            return false;
        L11:
            if (this.mPaint.getTextSize() == r10.getTextPaint().getTextSize()) goto L14;
            return false;
        L14:
            if (this.mPaint.getTextScaleX() == r10.getTextPaint().getTextScaleX()) goto L17;
            return false;
        L17:
            if (this.mPaint.getTextSkewX() == r10.getTextPaint().getTextSkewX()) goto L20;
            return false;
        L20:
            if (r11 < 21) goto L28;
            if (this.mPaint.getLetterSpacing() == r10.getTextPaint().getLetterSpacing()) goto L25;
            return false;
        L25:
            if (TextUtils.equals(this.mPaint.getFontFeatureSettings(), r10.getTextPaint().getFontFeatureSettings()) == true) goto L28;
            return false;
        L28:
            if (this.mPaint.getFlags() == r10.getTextPaint().getFlags()) goto L31;
            return false;
        L31:
            if (r11 < 24) goto L36;
            if (this.mPaint.getTextLocales().equals(r10.getTextPaint().getTextLocales()) == true) goto L41;
            return false;
        L41:
            if (this.mPaint.getTypeface() != null) goto L46;
            if (r10.getTextPaint().getTypeface() == null) goto L48;
            return false;
        L48:
            return true;
        L46:
            if (this.mPaint.getTypeface().equals(r10.getTextPaint().getTypeface()) == true) goto L50;
            return false;
        L50:
            return true;
        L36:
            if (r11 < 17) goto L41;
            if (this.mPaint.getTextLocale().equals(r10.getTextPaint().getTextLocale()) == true) goto L41;
            return false;
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
        @RequiresApi(18)
        public TextDirectionHeuristic getTextDirection() {
            return this.mTextDir;
        }

        @NonNull
        public TextPaint getTextPaint() {
            return this.mPaint;
        }

        public int hashCode() {
            int r10 = Build.VERSION.SDK_INT;
            if (r10 < 24) goto L7;
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        L7:
            if (r10 < 21) goto L11;
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        L11:
            if (r10 < 18) goto L15;
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        L15:
            if (r10 < 17) goto L19;
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        L19:
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder("{");
            r10.append("textSize=" + this.mPaint.getTextSize());
            r10.append(", textScaleX=" + this.mPaint.getTextScaleX());
            r10.append(", textSkewX=" + this.mPaint.getTextSkewX());
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 21) goto L6;
            r10.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
            r10.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
        L6:
            if (r11 < 24) goto L10;
            StringBuilder r12 = new StringBuilder();
            r12.append(", textLocale=");
            Object r13 = this.mPaint.getTextLocales();
        L8:
            r12.append(r13);
            r10.append(r12.toString());
        L12:
            r10.append(", typeface=" + this.mPaint.getTypeface());
            if (r11 < 26) goto L15;
            r10.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
        L15:
            r10.append(", textDir=" + this.mTextDir);
            r10.append(", breakStrategy=" + this.mBreakStrategy);
            r10.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            r10.append("}");
            return r10.toString();
        L10:
            if (r11 < 17) goto L12;
            r12 = new StringBuilder();
            r12.append(", textLocale=");
            r13 = this.mPaint.getTextLocale();
            goto L8
        }
    }

    private static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        private static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
            private Params mParams;
            private CharSequence mText;

            PrecomputedTextCallback(@NonNull Params r10, @NonNull CharSequence r11) {
                this.mParams = r10;
                this.mText = r11;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PrecomputedTextCompat call() {
                return PrecomputedTextCompat.create(this.mText, this.mParams);
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ PrecomputedTextCompat call() {
                return call();
            }
        }

        PrecomputedTextFutureTask(@NonNull Params r10, @NonNull CharSequence r11) {
            super(new PrecomputedTextCallback(r10, r11));
        }
    }

    static {
        sLock = new Object();
    }

    @RequiresApi(28)
    private PrecomputedTextCompat(@NonNull PrecomputedText r10, @NonNull Params r11) {
        this.mText = r10;
        this.mParams = r11;
        this.mParagraphEnds = null;
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        r10 = null;
    L6:
        this.mWrapped = r10;
    }

    private PrecomputedTextCompat(@NonNull CharSequence r10, @NonNull Params r11, @NonNull int[] r12) {
        this.mText = new SpannableString(r10);
        this.mParams = r11;
        this.mParagraphEnds = r12;
        this.mWrapped = null;
    }

    @SuppressLint({"WrongConstant"})
    public static PrecomputedTextCompat create(@NonNull CharSequence r11, @NonNull Params r12) {
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r12);
        TraceCompat.beginSection("PrecomputedText");     // Catch: Throwable -> L30
        if (Build.VERSION.SDK_INT < 29) goto L10;
        PrecomputedText.Params r10 = r12.mWrapped;     // Catch: Throwable -> L30
        if (r10 == null) goto L10;
        PrecomputedTextCompat r13 = new PrecomputedTextCompat(PrecomputedText.create(r11, r10), r12);     // Catch: Throwable -> L30
        TraceCompat.endSection();
        return r13;
    L10:
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L30
        int r15 = r11.length();     // Catch: Throwable -> L30
        int r16 = 0;
    L11:
        if (r16 >= r15) goto L17;
        int r17 = TextUtils.indexOf(r11, LINE_FEED, r16, r15);     // Catch: Throwable -> L30
        if (r17 >= 0) goto L15;
        r16 = r15;
    L16:
        r14.add(Integer.valueOf(r16));     // Catch: Throwable -> L30
        goto L11
    L15:
        r16 = r17 + 1;     // Catch: Throwable -> L30
        goto L16
    L17:
        int[] r18 = new int[r14.size()];     // Catch: Throwable -> L30
        int r19 = 0;
    L19:
        if (r19 >= r14.size()) goto L21;
        r18[r19] = ((Integer) r14.get(r19)).intValue();     // Catch: Throwable -> L30
        r19 = r19 + 1;     // Catch: Throwable -> L30
        goto L19
    L21:
        int r20 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L30
        if (r20 < 23) goto L25;
        StaticLayout.Builder.obtain(r11, 0, r11.length(), r12.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(r12.getBreakStrategy()).setHyphenationFrequency(r12.getHyphenationFrequency()).setTextDirection(r12.getTextDirection()).build();     // Catch: Throwable -> L30
    L27:
        PrecomputedTextCompat r21 = new PrecomputedTextCompat(r11, r12, r18);     // Catch: Throwable -> L30
        TraceCompat.endSection();
        return r21;
    L25:
        if (r20 < 21) goto L27;
        new StaticLayout(r11, r12.getTextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    @UiThread
    public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence r10, @NonNull Params r11, @Nullable Executor r12) {
        PrecomputedTextFutureTask r13 = new PrecomputedTextFutureTask(r11, r10);
        if (r12 != null) goto L15;
        Object r14 = sLock;
        monitor-enter(r14);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (sExecutor != null) goto L9;
        sExecutor = Executors.newFixedThreadPool(1);     // Catch: Throwable -> L12
    L9:
        r12 = sExecutor;     // Catch: Throwable -> L12
        monitor-exit(r14);     // Catch: Throwable -> L12
    L15:
        r12.execute(r13);
        return r13;
    }

    @Override // java.lang.CharSequence
    public char charAt(int r10) {
        return this.mText.charAt(r10);
    }

    @IntRange(from = 0)
    public int getParagraphCount() {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return this.mWrapped.getParagraphCount();
    L7:
        return this.mParagraphEnds.length;
    }

    @IntRange(from = 0)
    public int getParagraphEnd(@IntRange(from = 0) int r10) {
        Preconditions.checkArgumentInRange(r10, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return this.mWrapped.getParagraphEnd(r10);
    L7:
        return this.mParagraphEnds[r10];
    }

    @IntRange(from = 0)
    public int getParagraphStart(@IntRange(from = 0) int r10) {
        Preconditions.checkArgumentInRange(r10, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        if (r10 != 0) goto L9;
        return 0;
    L9:
        return this.mParagraphEnds[r10 - 1];
    L5:
        return this.mWrapped.getParagraphStart(r10);
    }

    @NonNull
    public Params getParams() {
        return this.mParams;
    }

    @Nullable
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PrecomputedText getPrecomputedText() {
        Spannable r10 = this.mText;
        if ((r10 instanceof PrecomputedText) == true) goto L5;
        return null;
    L5:
        return (PrecomputedText) r10;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object r10) {
        return this.mText.getSpanEnd(r10);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object r10) {
        return this.mText.getSpanFlags(r10);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object r10) {
        return this.mText.getSpanStart(r10);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int r10, int r11, Class<T> r12) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return (T[]) this.mWrapped.getSpans(r10, r11, r12);
    L7:
        return (T[]) this.mText.getSpans(r10, r11, r12);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mText.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int r10, int r11, Class r12) {
        return this.mText.nextSpanTransition(r10, r11, r12);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object r10) {
        if ((r10 instanceof MetricAffectingSpan) == true) goto L10;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        this.mWrapped.removeSpan(r10);
        return;
    L7:
        this.mText.removeSpan(r10);
        return;
    L10:
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object r10, int r11, int r12, int r13) {
        if ((r10 instanceof MetricAffectingSpan) == true) goto L10;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        this.mWrapped.setSpan(r10, r11, r12, r13);
        return;
    L7:
        this.mText.setSpan(r10, r11, r12, r13);
        return;
    L10:
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r10, int r11) {
        return this.mText.subSequence(r10, r11);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.mText.toString();
    }
}
