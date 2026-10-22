package com.bytedance.android.ec.core.widget.price;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import com.bytedance.services.apm.api.EnsureManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static class a extends MetricAffectingSpan {
        public final float a;

        public a(float r1) {
            this.a = r1;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r10) {
            Intrinsics.checkNotNullParameter(r10, "textPaint");
            r10.baselineShift += (int) ((r10.ascent() + r10.descent()) * this.a);
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r10) {
            Intrinsics.checkNotNullParameter(r10, "textPaint");
            r10.baselineShift += (int) ((r10.ascent() + r10.descent()) * this.a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.widget.price.b$b, reason: collision with other inner class name */
    public static final class C0148b extends CharacterStyle {
        public final com.bytedance.android.ec.core.widget.price.a.b a;

        public C0148b(com.bytedance.android.ec.core.widget.price.a.b r10) {
            Intrinsics.checkNotNullParameter(r10, "shadow");
            this.a = r10;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r10) {
            if (r10 == null) goto L5;
            com.bytedance.android.ec.core.widget.price.a.b r0 = this.a;
            r10.setShadowLayer(r0.a, r0.b, r0.c, r0.d);
            return;
        }
    }

    public static final class c extends ReplacementSpan {
        public final Paint a;
        public final int b;

        public c(int r10) {
            this.b = r10;
            Paint r11 = new Paint();
            this.a = r11;
            r11.setColor(0);
            r11.setStyle(Paint.Style.FILL);
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r1, CharSequence r10, int r11, int r12, Paint.FontMetricsInt r13) {
            Intrinsics.checkNotNullParameter(r1, "paint");
            Intrinsics.checkNotNullParameter(r10, "text");
            return this.b;
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r10, CharSequence r11, int r12, int r13, float r14, int r15, int r16, int r17, Paint r18) {
            Intrinsics.checkNotNullParameter(r10, "canvas");
            Intrinsics.checkNotNullParameter(r11, "text");
            Intrinsics.checkNotNullParameter(r18, "paint");
            r10.drawRect(r14, r15, r14 + this.b, r17, this.a);
        }
    }

    static {
    }

    @JvmStatic
    public static final long a(String r10) {
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L15
        if (r10 != null) goto L6;
    L9:
        boolean r12 = true;
    L10:
        if (r12 == false) goto L12;
        long r13 = 0;
    L13:
        Object r14 = Result.constructor-impl(Long.valueOf(r13));     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r14) == false) goto L20;
        r14 = null;
    L20:
        Long r15 = (Long) r14;
        if (r15 != null) goto L27;
        EnsureManager.ensureNotReachHere("price is illegal, it is " + r10);
        return 0;
    L27:
        return r15.longValue();
    L12:
        r13 = new BigDecimal(r10).multiply(new BigDecimal(100)).longValue();     // Catch: Throwable -> L15
        goto L13
    L6:
        if (StringsKt.isBlank(r10) == true) goto L9;
        r12 = false;
    L15:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public static String b(long r11, boolean r13) {
        if (r13 == false) goto L5;
        StringCompanionObject r14 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r11 / 100.0d)}, 1));
    L5:
        long r10 = 100;
        if ((r11 % r10) != 0) goto L9;
        return String.valueOf(r11 / r10);
    L9:
        if ((r11 % ((long) 10)) != 0) goto L11;
        StringCompanionObject r15 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r11 / 100.0d)}, 1));
    L11:
        StringCompanionObject r16 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r11 / 100.0d)}, 1));
    }
}
