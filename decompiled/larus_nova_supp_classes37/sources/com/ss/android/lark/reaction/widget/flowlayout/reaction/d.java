package com.ss.android.lark.reaction.widget.flowlayout.reaction;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class d extends ClearCacheDynamicDrawableSpan {
    public float c;
    public float d;

    public void c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public d(int r1) {
        super(r1);
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.ClearCacheDynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas r3, CharSequence r4, int r5, int r6, float r7, int r8, int r9, int r10, Paint r11) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        Intrinsics.checkNotNullParameter(r11, "paint");
        r3.save();
        r3.translate(this.c, this.d);
        super.draw(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        r3.restore();
    }
}
