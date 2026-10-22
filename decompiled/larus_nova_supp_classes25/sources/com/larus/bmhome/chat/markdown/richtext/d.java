package com.larus.bmhome.chat.markdown.richtext;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d extends ReplacementSpan implements tsc.o {
    public final Resources a;
    public final p b;
    public final int c;
    public final int d;
    public String e;
    public RoundedBitmapDrawable f;

    public final void f(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "textView");
        Object r1 = r5.getTag(2131377343);
        if ((r1 instanceof AvatarBinding) == false) goto L5;
        AvatarBinding r2 = (AvatarBinding) r1;
    L6:
        if (r2 == null) goto L8;
        r2.a();
        r5.removeOnAttachStateChangeListener(r2);
    L8:
        r5.setTag(2131377343, null);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public d(Resources r2, p r3) {
        Intrinsics.checkNotNullParameter(r2, "resources");
        Intrinsics.checkNotNullParameter(r3, "avatar");
        this.a = r2;
        this.b = r3;
        this.c = c7.b(18);
        this.d = c7.b(4);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r3, CharSequence r4, int r5, int r6, Paint.FontMetricsInt r7) {
        Intrinsics.checkNotNullParameter(r3, "paint");
        Intrinsics.checkNotNullParameter(r4, ChatDraftItem.TYPE_TEXT);
        if (r7 == null) goto L5;
        r3.getFontMetricsInt(r7);
    L5:
        int r8 = this.c + this.d;
        if (r5 >= r6) goto L11;
        if (r4.charAt(r5) != '@') goto L11;
        r5 = r5 + 1;
    L11:
        return r8 + ((int) r3.measureText(r4, r5, r6));
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r14, CharSequence r15, int r16, int r17, float r18, int r19, int r20, int r21, Paint r22) {
        int r2 = r16;
        Intrinsics.checkNotNullParameter(r14, "canvas");
        Intrinsics.checkNotNullParameter(r15, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r22, "paint");
        Drawable r5 = this.f;
        String r8 = this.e;
        if (r8 == null) goto L7;
        p r10 = this.b;
        r10.getClass();
        MessageReferenceIconStore r11 = MessageReferenceIconStore.a;
        if (Intrinsics.areEqual(r8, MessageReferenceIconStore.a(r10.a, r10.b, r10.c)) == false) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L13;
        r14.save();
        r14.translate(r18, r20 + (((r22.getFontMetrics().ascent + r22.getFontMetrics().descent) - this.c) / 2.0f));
        int r12 = this.c;
        r5.setBounds(0, 0, r12, r12);
        r5.draw(r14);
        r14.restore();
    L15:
        if (r2 < r17) goto L17;
    L19:
        r14.drawText(r15, r2, r17, this.d + (this.c + r18), r20, r22);
        return;
    L17:
        if (r15.charAt(r16) != '@') goto L19;
        r2 = r2 + 1;
        goto L19
    L13:
        r14.drawText("@", r18, r20, r22);
    L7:
        r9 = false;
        goto L8
    }
}
