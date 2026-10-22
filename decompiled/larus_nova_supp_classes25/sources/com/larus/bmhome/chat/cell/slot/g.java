package com.larus.bmhome.chat.cell.slot;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.larus.bmhome.chat.model.ChatDraftItem;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g extends ImageSpan {
    public g(Drawable r2) {
        super(r2, 1);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        Intrinsics.checkNotNullParameter(r2, "paint");
        return super.getSize(r2, r3, r4, r5, r6) + i5.Y();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r3, CharSequence r4, int r5, int r6, float r7, int r8, int r9, int r10, Paint r11) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        Intrinsics.checkNotNullParameter(r4, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r11, "paint");
        r3.save();
        r3.translate(0.0f, i5.z());     // Catch: Throwable -> L6
        super.draw(r3, r4, r5, r6, r7, r8, r9, r10, r11);     // Catch: Throwable -> L6
        r3.restore();
        return;
    L6:
        th = move-exception;
        r3.restore();
        throw th;
    }
}
