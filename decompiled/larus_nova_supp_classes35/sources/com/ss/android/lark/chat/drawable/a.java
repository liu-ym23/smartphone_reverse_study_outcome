package com.ss.android.lark.chat.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.chat.utils.s0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends Drawable {
    public final Drawable a;
    public final Drawable b;
    public final InterfaceC0092a c;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.drawable.a$a, reason: collision with other inner class name */
    public interface InterfaceC0092a {
        float a();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        float r0 = this.c.a();
        Drawable r1 = this.a;
        if (r1 == null) goto L5;
        r1.setBounds(0, 0, getBounds().width(), (int) r0);
    L5:
        Drawable r2 = this.a;
        if (r2 == null) goto L9;
        r2.draw(r6);
    L9:
        if (this.b == null) goto L12;
        r6.save();
        r6.translate(0.0f, r0);
        this.b.setBounds(0, 0, getBounds().width(), getBounds().height() - ((int) r0));
        this.b.draw(r6);
        r6.restore();
        return;
    }

    public a(Drawable r2, RoundedDrawable r3, s0 r4) {
        Intrinsics.checkNotNullParameter(r4, "mDivideYProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
