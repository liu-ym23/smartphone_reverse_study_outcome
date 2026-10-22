package com.ss.android.lark.keyboard.edittext2.edittors.inlinecode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.LineBackgroundSpan;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import com.ss.android.lark.widget.span.o;
import com.ss.android.lark.widget.span.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends CharacterStyle implements LineBackgroundSpan, z {
    public final o a;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        if (r2 == null) goto L5;
        r2.setColor(0);
        return;
    }

    public a(Context r2, InlineCodeInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "spanInfo");
        this.a = new o(r2, r3);
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r15, Paint r16, int r17, int r18, int r19, int r20, int r21, CharSequence r22, int r23, int r24, int r25) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        Intrinsics.checkNotNullParameter(r16, "paint");
        Intrinsics.checkNotNullParameter(r22, "text");
        Spanned r10 = (Spanned) r22;
        int r1 = r10.getSpanStart(this);
        int r2 = r10.getSpanEnd(this);
        int r13 = Math.max(r1, r23);
        if (r13 < Math.min(r2, r24)) goto L5;
        return;
    L5:
        this.a.a(r15, r16, r17, r18, r19, r21, r10, r23, r24, r13);
    }
}
