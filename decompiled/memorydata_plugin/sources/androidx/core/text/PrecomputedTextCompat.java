package androidx.core.text;

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
import androidx.core.os.TraceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class PrecomputedTextCompat implements Spannable {
    private static final char LINE_FEED = '\n';
    private static Executor sExecutor;
    private static final Object sLock = null;
    private final int[] mParagraphEnds;
    private final Params mParams;
    private final Spannable mText;
    private final PrecomputedText mWrapped;

    static class Api28Impl {
        private Api28Impl() {
        }

        static Spannable castToSpannable(PrecomputedText r0) {
            return r0;
        }
    }

    public static final class Params {
        private final int mBreakStrategy;
        private final int mHyphenationFrequency;
        private final TextPaint mPaint;
        private final TextDirectionHeuristic mTextDir;
        final PrecomputedText.Params mWrapped;

        public static class Builder {
            private int mBreakStrategy;
            private int mHyphenationFrequency;
            private final TextPaint mPaint;
            private TextDirectionHeuristic mTextDir;

            public Builder(TextPaint r2) {
                this.mPaint = r2;
                if (Build.VERSION.SDK_INT < 23) goto L5;
                this.mBreakStrategy = 1;
                this.mHyphenationFrequency = 1;
            L7:
                if (Build.VERSION.SDK_INT < 18) goto L9;
                TextDirectionHeuristic r3 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            L10:
                this.mTextDir = r3;
                return;
            L9:
                r3 = null;
                goto L10
            L5:
                this.mHyphenationFrequency = 0;
                this.mBreakStrategy = 0;
                goto L7
            }

            public Params build() {
                return new Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
            }

            public Builder setBreakStrategy(int r1) {
                this.mBreakStrategy = r1;
                return this;
            }

            public Builder setHyphenationFrequency(int r1) {
                this.mHyphenationFrequency = r1;
                return this;
            }

            public Builder setTextDirection(TextDirectionHeuristic r3) {
                this.mTextDir = (TextDirectionHeuristic) ZeusTransformUtils.wrapperContextForParams(r3, TextDirectionHeuristic.class, "com.obric.memorydata.plugin");
                return this;
            }
        }

        public Params(PrecomputedText.Params r3) {
            this.mPaint = r3.getTextPaint();
            this.mTextDir = r3.getTextDirection();
            this.mBreakStrategy = r3.getBreakStrategy();
            this.mHyphenationFrequency = r3.getHyphenationFrequency();
            if (Build.VERSION.SDK_INT >= 29) goto L6;
            r3 = null;
        L6:
            this.mWrapped = r3;
        }

        Params(TextPaint r3, TextDirectionHeuristic r4, int r5, int r6) {
            TextDirectionHeuristic r7 = (TextDirectionHeuristic) ZeusTransformUtils.wrapperContextForParams(r4, TextDirectionHeuristic.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 29) goto L5;
            PrecomputedText.Params r0 = new PrecomputedText.Params.Builder(r3).setBreakStrategy(r5).setHyphenationFrequency(r6).setTextDirection(r7).build();
        L6:
            this.mWrapped = r0;
            this.mPaint = r3;
            this.mTextDir = r7;
            this.mBreakStrategy = r5;
            this.mHyphenationFrequency = r6;
            return;
        L5:
            r0 = null;
            goto L6
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Params.class) == true) goto L8;
            return false;
        L8:
            Params r6 = (Params) ZeusTransformUtils.preCheckCast(r5, Params.class, "com.obric.memorydata.plugin");
            if (equalsWithoutTextDirection(r6) == true) goto L12;
            return false;
        L12:
            if (Build.VERSION.SDK_INT >= 18) goto L14;
        L16:
            return true;
        L14:
            if (this.mTextDir == r6.getTextDirection()) goto L16;
            return false;
        }

        public boolean equalsWithoutTextDirection(Params r4) {
            if (Build.VERSION.SDK_INT < 23) goto L11;
            if (this.mBreakStrategy == r4.getBreakStrategy()) goto L8;
            return false;
        L8:
            if (this.mHyphenationFrequency == r4.getHyphenationFrequency()) goto L11;
            return false;
        L11:
            if (this.mPaint.getTextSize() == r4.getTextPaint().getTextSize()) goto L14;
            return false;
        L14:
            if (this.mPaint.getTextScaleX() == r4.getTextPaint().getTextScaleX()) goto L17;
            return false;
        L17:
            if (this.mPaint.getTextSkewX() == r4.getTextPaint().getTextSkewX()) goto L20;
            return false;
        L20:
            if (Build.VERSION.SDK_INT < 21) goto L28;
            if (this.mPaint.getLetterSpacing() == r4.getTextPaint().getLetterSpacing()) goto L25;
            return false;
        L25:
            if (TextUtils.equals(this.mPaint.getFontFeatureSettings(), r4.getTextPaint().getFontFeatureSettings()) == true) goto L28;
            return false;
        L28:
            if (this.mPaint.getFlags() == r4.getTextPaint().getFlags()) goto L31;
            return false;
        L31:
            if (Build.VERSION.SDK_INT < 24) goto L36;
            if (this.mPaint.getTextLocales().equals(r4.getTextPaint().getTextLocales()) == true) goto L41;
            return false;
        L41:
            if (this.mPaint.getTypeface() != null) goto L46;
            if (r4.getTextPaint().getTypeface() == null) goto L48;
            return false;
        L48:
            return true;
        L46:
            if (this.mPaint.getTypeface().equals(r4.getTextPaint().getTypeface()) == true) goto L50;
            return false;
        L50:
            return true;
        L36:
            if (Build.VERSION.SDK_INT < 17) goto L41;
            if (this.mPaint.getTextLocale().equals(r4.getTextPaint().getTextLocale()) == true) goto L41;
            return false;
        }

        public int getBreakStrategy() {
            return this.mBreakStrategy;
        }

        public int getHyphenationFrequency() {
            return this.mHyphenationFrequency;
        }

        public TextDirectionHeuristic getTextDirection() {
            return this.mTextDir;
        }

        public TextPaint getTextPaint() {
            return this.mPaint;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT < 24) goto L7;
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        L7:
            if (Build.VERSION.SDK_INT < 21) goto L11;
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        L11:
            if (Build.VERSION.SDK_INT < 18) goto L15;
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        L15:
            if (Build.VERSION.SDK_INT < 17) goto L19;
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        L19:
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("{");
            r0.append("textSize=" + this.mPaint.getTextSize());
            r0.append(", textScaleX=" + this.mPaint.getTextScaleX());
            r0.append(", textSkewX=" + this.mPaint.getTextSkewX());
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r0.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
            r0.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
        L6:
            if (Build.VERSION.SDK_INT < 24) goto L10;
            StringBuilder r1 = new StringBuilder().append(", textLocale=");
            Object r2 = this.mPaint.getTextLocales();
        L8:
            r0.append(r1.append(r2).toString());
        L12:
            r0.append(", typeface=" + this.mPaint.getTypeface());
            if (Build.VERSION.SDK_INT < 26) goto L15;
            r0.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
        L15:
            r0.append(", textDir=" + this.mTextDir);
            r0.append(", breakStrategy=" + this.mBreakStrategy);
            r0.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            r0.append("}");
            return r0.toString();
        L10:
            if (Build.VERSION.SDK_INT < 17) goto L12;
            r1 = new StringBuilder().append(", textLocale=");
            r2 = this.mPaint.getTextLocale();
            goto L8
        }
    }

    private static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        private static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
            private Params mParams;
            private CharSequence mText;

            PrecomputedTextCallback(Params r3, CharSequence r4) {
                CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
                this.mParams = r3;
                this.mText = r5;
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

        PrecomputedTextFutureTask(Params r3, CharSequence r4) {
            super(new PrecomputedTextCallback(r3, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin")));
        }
    }

    static {
        sLock = new Object();
    }

    private PrecomputedTextCompat(PrecomputedText r3, Params r4) {
        this.mText = Api28Impl.castToSpannable(r3);
        this.mParams = r4;
        this.mParagraphEnds = null;
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        r3 = null;
    L6:
        this.mWrapped = r3;
    }

    private PrecomputedTextCompat(CharSequence r3, Params r4, int[] r5) {
        this.mText = new SpannableString((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        this.mParams = r4;
        this.mParagraphEnds = r5;
        this.mWrapped = null;
    }

    public static PrecomputedTextCompat create(CharSequence r11, Params r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        Preconditions.checkNotNull(r13);
        Preconditions.checkNotNull(r12);
        TraceCompat.beginSection("PrecomputedText");     // Catch: Throwable -> L30
        if (Build.VERSION.SDK_INT >= 29) goto L6;
    L10:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L30
        int r2 = r13.length();     // Catch: Throwable -> L30
        int r4 = 0;
    L11:
        if (r4 >= r2) goto L17;
        int r5 = TextUtils.indexOf(r13, LINE_FEED, r4, r2);     // Catch: Throwable -> L30
        if (r5 >= 0) goto L15;
        r4 = r2;
    L16:
        r0.add(Integer.valueOf(r4));     // Catch: Throwable -> L30
        goto L11
    L15:
        r4 = r5 + 1;     // Catch: Throwable -> L30
        goto L16
    L17:
        int[] r10 = new int[r0.size()];     // Catch: Throwable -> L30
        int r3 = 0;
    L19:
        if (r3 >= r0.size()) goto L22;
        r10[r3] = ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r3), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L30
        r3 = r3 + 1;     // Catch: Throwable -> L30
        goto L19
    L22:
        if (Build.VERSION.SDK_INT < 23) goto L25;
        StaticLayout.Builder.obtain(r13, 0, r13.length(), r12.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(r12.getBreakStrategy()).setHyphenationFrequency(r12.getHyphenationFrequency()).setTextDirection(r12.getTextDirection()).build();     // Catch: Throwable -> L30
    L27:
        PrecomputedTextCompat r1 = new PrecomputedTextCompat(r13, r12, r10);     // Catch: Throwable -> L30
        TraceCompat.endSection();
        return r1;
    L25:
        if (Build.VERSION.SDK_INT < 21) goto L27;
        new StaticLayout(r13, r12.getTextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);     // Catch: Throwable -> L30
        goto L27
    L6:
        if (r12.mWrapped == null) goto L10;
        PrecomputedTextCompat r6 = new PrecomputedTextCompat(PrecomputedText.create(r13, r12.mWrapped), r12);     // Catch: Throwable -> L30
        TraceCompat.endSection();
        return r6;
    L30:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    public static Future<PrecomputedTextCompat> getTextFuture(CharSequence r2, Params r3, Executor r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        PrecomputedTextFutureTask r0 = new PrecomputedTextFutureTask(r3, r5);
        if (r6 != null) goto L15;
        Object r7 = sLock;
        monitor-enter(r7);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (sExecutor != null) goto L9;
        sExecutor = Executors.newFixedThreadPool(1);     // Catch: Throwable -> L12
    L9:
        r6 = sExecutor;     // Catch: Throwable -> L12
        monitor-exit(r7);     // Catch: Throwable -> L12
    L15:
        r6.execute(r0);
        return r0;
    }

    @Override // java.lang.CharSequence
    public char charAt(int r1) {
        return this.mText.charAt(r1);
    }

    public int getParagraphCount() {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return this.mWrapped.getParagraphCount();
    L7:
        return this.mParagraphEnds.length;
    }

    public int getParagraphEnd(int r4) {
        Preconditions.checkArgumentInRange(r4, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return this.mWrapped.getParagraphEnd(r4);
    L7:
        return this.mParagraphEnds[r4];
    }

    public int getParagraphStart(int r4) {
        Preconditions.checkArgumentInRange(r4, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        if (r4 != 0) goto L9;
        return 0;
    L9:
        return this.mParagraphEnds[r4 - 1];
    L5:
        return this.mWrapped.getParagraphStart(r4);
    }

    public Params getParams() {
        return this.mParams;
    }

    public PrecomputedText getPrecomputedText() {
        if (ZeusTransformUtils.instanceOf(this.mText, PrecomputedText.class) == true) goto L5;
        return null;
    L5:
        return (PrecomputedText) ZeusTransformUtils.preCheckCast(this.mText, PrecomputedText.class, "com.obric.memorydata.plugin");
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object r1) {
        return this.mText.getSpanEnd(r1);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object r1) {
        return this.mText.getSpanFlags(r1);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object r1) {
        return this.mText.getSpanStart(r1);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int r3, int r4, Class<T> r5) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return (T[]) this.mWrapped.getSpans(r3, r4, r5);
    L7:
        return (T[]) this.mText.getSpans(r3, r4, r5);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mText.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int r1, int r2, Class r3) {
        return this.mText.nextSpanTransition(r1, r2, r3);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, MetricAffectingSpan.class) == true) goto L10;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        this.mWrapped.removeSpan(r3);
        return;
    L7:
        this.mText.removeSpan(r3);
        return;
    L10:
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object r3, int r4, int r5, int r6) {
        if (ZeusTransformUtils.instanceOf(r3, MetricAffectingSpan.class) == true) goto L10;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        this.mWrapped.setSpan(r3, r4, r5, r6);
        return;
    L7:
        this.mText.setSpan(r3, r4, r5, r6);
        return;
    L10:
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r1, int r2) {
        return this.mText.subSequence(r1, r2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.mText.toString();
    }
}
