package com.lynx.xelement.input;

import android.graphics.Paint;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import android.widget.EditText;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import z6a.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxInputUtils {
    public static final Lazy<b> a = null;

    public static final class a {
    }

    public static final class b {
        public final Method a;
        public final Method b;
        public final Method c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "LocaleLineHeightMethods(isLocalePreferredLineHeightForMinimumUsed=" + this.a + ", getFontMetricsForLocale=" + this.b + ", setMinimumFontMetrics=" + this.c + ')';
        }

        public b(Method r2, Method r3, Method r4) {
            Intrinsics.checkNotNullParameter(r2, "isLocalePreferredLineHeightForMinimumUsed");
            Intrinsics.checkNotNullParameter(r3, "getFontMetricsForLocale");
            Intrinsics.checkNotNullParameter(r4, "setMinimumFontMetrics");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public LynxInputUtils() {
    }

    static {
        a = LazyKt.lazy(LynxInputUtils$Companion$localeLineHeightMethods$2.INSTANCE);
    }

    public static Layout a(CharSequence r13, EditText r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "charSequence");
        Intrinsics.checkNotNullParameter(r14, "editText");
        int r2 = r14.getGravity();
        if (r2 == 3) goto L10;
        if (r2 != 5) goto L6;
        Layout.Alignment r3 = Layout.Alignment.ALIGN_OPPOSITE;
    L11:
        Layout.Alignment r5 = r3;
        int r4 = Build.VERSION.SDK_INT;
        if (r4 < 23) goto L39;
        int r6 = r14.getTextDirection();
        if (r6 == 3) goto L20;
        if (r6 == 4) goto L19;
        if (r6 == 5) goto L18;
        TextDirectionHeuristic r7 = TextDirectionHeuristics.LTR;
    L21:
        StaticLayout.Builder r8 = StaticLayout.Builder.obtain(r13, 0, r13.length(), r14.getPaint(), r15).setAlignment(r5).setTextDirection(r7).setLineSpacing(r14.getLineSpacingExtra(), r14.getLineSpacingMultiplier()).setIncludePad(r14.getIncludeFontPadding());
        if (r4 < 28) goto L25;
        r8.setUseLineSpacingFromFallbacks(true);
    L25:
        if (r4 < 35) goto L38;
        b r0 = (b) a.getValue();
        if (r0 == null) goto L38;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L35
        if (Intrinsics.areEqual(r0.a.invoke(r14, new Object[0]), Boolean.TRUE) == false) goto L33;
        Paint.FontMetrics r10 = new Paint.FontMetrics();     // Catch: Throwable -> L35
        r0.b.invoke(r14.getPaint(), new Object[]{r10});     // Catch: Throwable -> L35
        r0.c.invoke(r8, new Object[]{r10});     // Catch: Throwable -> L35
    L33:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L38:
        return r8.build();
    L18:
        r7 = TextDirectionHeuristics.LOCALE;
        goto L21
    L19:
        r7 = TextDirectionHeuristics.RTL;
        goto L21
    L20:
        r7 = TextDirectionHeuristics.LTR;
        goto L21
    L39:
        int r11 = r14.getTextDirection();
        if (r11 == 3) goto L46;
        if (r11 == 4) goto L45;
        if (r11 == 5) goto L44;
        TextDirectionHeuristic r12 = TextDirectionHeuristics.LTR;
    L48:
        return p.a(r13, r13.length(), r14.getPaint(), r15, r5, r14.getLineSpacingMultiplier(), r14.getLineSpacingExtra(), r14.getIncludeFontPadding(), TextUtils.TruncateAt.END, -1, r12);
    L44:
        r12 = TextDirectionHeuristics.LOCALE;
        goto L48
    L45:
        r12 = TextDirectionHeuristics.RTL;
        goto L48
    L46:
        r12 = TextDirectionHeuristics.LTR;
        goto L48
    L6:
        if (r2 == 17) goto L8;
        r3 = Layout.Alignment.ALIGN_NORMAL;
        goto L11
    L8:
        r3 = Layout.Alignment.ALIGN_CENTER;
        goto L11
    L10:
        r3 = Layout.Alignment.ALIGN_NORMAL;
        goto L11
    }
}
