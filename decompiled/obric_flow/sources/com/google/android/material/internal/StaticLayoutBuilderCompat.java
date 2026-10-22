package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class StaticLayoutBuilderCompat {
    static final int DEFAULT_HYPHENATION_FREQUENCY = 0;
    static final float DEFAULT_LINE_SPACING_ADD = 0.0f;
    static final float DEFAULT_LINE_SPACING_MULTIPLIER = 1.0f;
    private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final String TEXT_DIR_CLASS_LTR = "LTR";
    private static final String TEXT_DIR_CLASS_RTL = "RTL";

    @Nullable
    private static Constructor<StaticLayout> constructor;
    private static boolean initialized;

    @Nullable
    private static Object textDirection;
    private Layout.Alignment alignment;

    @Nullable
    private TextUtils.TruncateAt ellipsize;
    private int end;
    private int hyphenationFrequency;
    private boolean includePad;
    private boolean isRtl;
    private float lineSpacingAdd;
    private float lineSpacingMultiplier;
    private int maxLines;
    private final TextPaint paint;
    private CharSequence source;
    private int start;

    @Nullable
    private StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer;
    private final int width;

    public static class StaticLayoutBuilderCompatException extends Exception {
        public StaticLayoutBuilderCompatException(Throwable r5) {
            super(androidx.room.jarjarred.org.antlr.runtime.a.x(r5, new StringBuilder("Error thrown initializing StaticLayout ")), r5);
        }
    }

    static {
        DEFAULT_HYPHENATION_FREQUENCY = 1;
    }

    private StaticLayoutBuilderCompat(CharSequence r5, TextPaint r10, int r11) {
        this.source = r5;
        this.paint = r10;
        this.width = r11;
        this.start = 0;
        this.end = r5.length();
        this.alignment = Layout.Alignment.ALIGN_NORMAL;
        this.maxLines = Integer.MAX_VALUE;
        this.lineSpacingAdd = 0.0f;
        this.lineSpacingMultiplier = 1.0f;
        this.hyphenationFrequency = DEFAULT_HYPHENATION_FREQUENCY;
        this.includePad = true;
        this.ellipsize = null;
    }

    private void createConstructorWithReflection() throws StaticLayoutBuilderCompatException {
        if (initialized == false) goto L15;
        return;
    L15:
    L8:
        e = move-exception;
        throw new StaticLayoutBuilderCompatException(e);
    L6:
        if (this.isRtl == false) goto L10;
        TextDirectionHeuristic r14 = TextDirectionHeuristics.RTL;     // Catch: Exception -> L8
    L11:
        textDirection = r14;     // Catch: Exception -> L8
        Class r13 = Integer.TYPE;     // Catch: Exception -> L8
        Class r10 = Float.TYPE;     // Catch: Exception -> L8
        Constructor<StaticLayout> r15 = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, r13, r13, TextPaint.class, r13, Layout.Alignment.class, TextDirectionHeuristic.class, r10, r10, Boolean.TYPE, TextUtils.TruncateAt.class, r13, r13});     // Catch: Exception -> L8
        constructor = r15;     // Catch: Exception -> L8
        r15.setAccessible(true);     // Catch: Exception -> L8
        initialized = true;     // Catch: Exception -> L8
        return;
    L10:
        r14 = TextDirectionHeuristics.LTR;     // Catch: Exception -> L8
        goto L11
    }

    @NonNull
    public static StaticLayoutBuilderCompat obtain(@NonNull CharSequence r5, @NonNull TextPaint r10, @IntRange(from = 0) int r11) {
        return new StaticLayoutBuilderCompat(r5, r10, r11);
    }

    public StaticLayout build() throws StaticLayoutBuilderCompatException {
        if (this.source != null) goto L5;
        this.source = "";
    L5:
        int r5 = Math.max(0, this.width);
        CharSequence r10 = this.source;
        if (this.maxLines != 1) goto L8;
        r10 = TextUtils.ellipsize(r10, this.paint, r5, this.ellipsize);
    L8:
        int r11 = Math.min(r10.length(), this.end);
        this.end = r11;
        if (this.isRtl == true) goto L11;
    L13:
        StaticLayout.Builder r12 = StaticLayout.Builder.obtain(r10, this.start, r11, this.paint, r5);
        r12.setAlignment(this.alignment);
        r12.setIncludePad(this.includePad);
        if (this.isRtl == false) goto L16;
        TextDirectionHeuristic r13 = TextDirectionHeuristics.RTL;
    L17:
        r12.setTextDirection(r13);
        TextUtils.TruncateAt r14 = this.ellipsize;
        if (r14 == null) goto L20;
        r12.setEllipsize(r14);
    L20:
        r12.setMaxLines(this.maxLines);
        float r15 = this.lineSpacingAdd;
        if (r15 == 0.0f) goto L23;
    L24:
        r12.setLineSpacing(r15, this.lineSpacingMultiplier);
    L26:
        if (this.maxLines <= 1) goto L28;
        r12.setHyphenationFrequency(this.hyphenationFrequency);
    L28:
        StaticLayoutBuilderConfigurer r16 = this.staticLayoutBuilderConfigurer;
        if (r16 == null) goto L32;
        r16.configure(r12);
    L32:
        return r12.build();
    L23:
        if (this.lineSpacingMultiplier == 1.0f) goto L26;
    L16:
        r13 = TextDirectionHeuristics.LTR;
        goto L17
    L11:
        if (this.maxLines != 1) goto L13;
        this.alignment = Layout.Alignment.ALIGN_OPPOSITE;
        goto L13
    }

    @NonNull
    public StaticLayoutBuilderCompat setAlignment(@NonNull Layout.Alignment r5) {
        this.alignment = r5;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEllipsize(@Nullable TextUtils.TruncateAt r5) {
        this.ellipsize = r5;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEnd(@IntRange(from = 0) int r5) {
        this.end = r5;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setHyphenationFrequency(int r5) {
        this.hyphenationFrequency = r5;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setIncludePad(boolean r5) {
        this.includePad = r5;
        return this;
    }

    public StaticLayoutBuilderCompat setIsRtl(boolean r5) {
        this.isRtl = r5;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setLineSpacing(float r5, float r10) {
        this.lineSpacingAdd = r5;
        this.lineSpacingMultiplier = r10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setMaxLines(@IntRange(from = 0) int r5) {
        this.maxLines = r5;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setStart(@IntRange(from = 0) int r5) {
        this.start = r5;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setStaticLayoutBuilderConfigurer(@Nullable StaticLayoutBuilderConfigurer r5) {
        this.staticLayoutBuilderConfigurer = r5;
        return this;
    }
}
