package com.bytedance.android.livesdk.interactivity.zdanmaku.units;

import android.graphics.drawable.Drawable;
import com.facebook.drawee.generic.RootDrawable;
import q72.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> extends com.bytedance.live.zdanmaku.render.canvas.b {
    public RootDrawable d;
    public final T e;

    public final void d() {
        T r0 = this.e;
        if ((r0 instanceof q72.c) == true) goto L5;
        r0 = (T) null;
    L5:
        q72.c r1 = r0;
        if (r1 == null) goto L9;
        r1.d = null;
        return;
    }

    public final void e() {
        T r0 = this.e;
        boolean r1 = r0 instanceof q72.c;
        if (r1 == true) goto L5;
        q72.c r3 = null;
    L6:
        q72.c r4 = r3;
        if (r4 == null) goto L9;
        Drawable r5 = r4.d;
    L11:
        if ((r5 instanceof RootDrawable) == true) goto L13;
        r5 = null;
    L13:
        RootDrawable r6 = (RootDrawable) r5;
        this.d = r6;
        if (r1 == true) goto L16;
        q72.c r7 = null;
    L17:
        q72.c r8 = r7;
        if (r8 == null) goto L22;
        g r9 = r8.e;
        if (r9 == null) goto L22;
        int r10 = r9.a;
    L23:
        if (r1 == true) goto L25;
        r0 = (T) null;
    L25:
        q72.c r2 = r0;
        if (r2 == null) goto L30;
        g r11 = r2.e;
        if (r11 == null) goto L30;
        int r13 = r11.b;
    L31:
        if (r6 == null) goto L33;
        r6.setBounds(0, 0, r10, r13);
    L33:
        com.bytedance.live.artist.render.f r14 = c().c;
        r14.a = r10;
        r14.b = r13;
        return;
    L30:
        r13 = 0;
    L22:
        r10 = 0;
        goto L23
    L16:
        r7 = r0;
        goto L17
    L9:
        r5 = null;
        goto L11
    L5:
        r3 = r0;
        goto L6
    }

    public b(T r1) {
        this.e = r1;
    }
}
