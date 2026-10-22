package com.ss.android.lark.coremd.facade.plugins;

import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q extends MetricAffectingSpan {
    public final boolean a;
    public final int b;

    public q() {
        this.a = true;
        this.b = 320;
    }

    public final void a(TextPaint r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.a == false) goto L11;
        r4.setFakeBoldText(true);
        if (Build.VERSION.SDK_INT < 28) goto L9;
        r4.setTypeface(Typeface.create(Typeface.DEFAULT, this.b, false));
        return;
    L9:
        r4.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r1) {
        a(r1);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "textPaint");
        a(r2);
    }
}
