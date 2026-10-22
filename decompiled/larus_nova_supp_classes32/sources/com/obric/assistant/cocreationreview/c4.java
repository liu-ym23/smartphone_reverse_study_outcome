package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c4 {
    public static final void d(EditText r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        final Ref.FloatRef r0 = new Ref.FloatRef();
        r2.setOnTouchListener(new a4(r0));
    }

    public static final LinearLayout e(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        LinearLayout r0 = new LinearLayout(r1);
        r0.setOrientation(0);
        r0.setGravity(16);
        return r0;
    }

    public static final int g(int r3) {
        return Color.argb(24, Color.red(r3), Color.green(r3), Color.blue(r3));
    }

    public static final int i(int r3) {
        return Color.argb(61, Color.red(r3), Color.green(r3), Color.blue(r3));
    }

    public static final LinearLayout k(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        LinearLayout r0 = new LinearLayout(r1);
        r0.setOrientation(1);
        return r0;
    }

    public static final int c(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Resources r3 = r1.getResources();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }

    public static final void a(LinearLayout r2, View r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "view");
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, r4);
        r0.setMargins(0, r5, 0, r6);
        Unit r7 = Unit.INSTANCE;
        r2.addView(r3, r0);
    }

    public static final TextView f(Context r2, String r3, float r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "text");
        TextView r0 = new TextView(r2);
        r0.setText(r3);
        r0.setTextSize(r4);
        r0.setTextColor(r5);
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L7;
        Typeface r7 = Typeface.create(Typeface.DEFAULT, 2);
    L18:
        r0.setTypeface(r7);
        r0.setIncludeFontPadding(true);
        r0.setLineSpacing(0.0f, 1.15f);
        return r0;
    L7:
        if (r6 == 3) goto L10;
        r7 = Typeface.DEFAULT;
        goto L18
    L10:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        r7 = Typeface.create(Typeface.DEFAULT, 600, true);
        Intrinsics.checkNotNull(r7);
        goto L18
    L12:
        r7 = Typeface.create(Typeface.DEFAULT_BOLD, 2);
        Intrinsics.checkNotNull(r7);
        goto L18
    L15:
        if (Build.VERSION.SDK_INT < 28) goto L17;
        r7 = Typeface.create(Typeface.DEFAULT, 600, false);
        Intrinsics.checkNotNull(r7);
        goto L18
    L17:
        r7 = Typeface.DEFAULT_BOLD;
        Intrinsics.checkNotNull(r7);
        goto L18
    }

    public static final GradientDrawable h(Context r1, int r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(r2);
        r0.setCornerRadius(c(r1, r3));
        if (r5 <= 0) goto L5;
        r0.setStroke(c(r1, r5), r4);
    L5:
        return r0;
    }

    public static final TextView j(Context r5, String r6, boolean r7, int r8, final Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "text");
        Intrinsics.checkNotNullParameter(r9, "onClick");
        int r0 = -1;
        if (r7 == false) goto L5;
        int r1 = -1;
    L6:
        TextView r2 = f(r5, r6, 12.5f, r1, 1);
        r2.setText(r6);
        r2.setGravity(17);
        r2.setMinHeight(c(r5, 38));
        r2.setPadding(c(r5, 12), 0, c(r5, 12), 0);
        if (r7 == false) goto L9;
        r0 = r8;
    L9:
        r2.setBackground(h(r5, r0, 9, r8, 1));
        r2.setOnClickListener(new z3(r9));
        return r2;
    L5:
        r1 = r8;
        goto L6
    }

    public static /* synthetic */ void b(LinearLayout r2, View r3, int r4, int r5, int r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = -2;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = 0;
    L11:
        a(r2, r3, r4, r5, r6);
    }
}
