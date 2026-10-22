package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Rect;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes2.dex */
public class g extends h {
    public int e;

    public g(LynxContext r5) {
        super(r5);
        this.e = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.utils.h
    public /* bridge */ /* synthetic */ f a() {
        return m();
    }

    public final void j(int r5, int r10) {
        BackgroundDrawable r11 = (BackgroundDrawable) d();
        r11.getClass();
        if (r5 > 8) goto L21;
        if (r5 >= 0) goto L7;
        return;
    L7:
        if (r11.f10711k != null) goto L9;
        r11.f10711k = new BorderStyle[9];
    L9:
        if (r10 < 0) goto L13;
        if (r10 > 9) goto L13;
        BorderStyle r12 = BorderStyle.values()[r10];     // Catch: Throwable -> L18
    L14:
        BorderStyle[] r13 = r11.f10711k;     // Catch: Throwable -> L18
        if (r13[r5] == r12) goto L22;
        r13[r5] = r12;     // Catch: Throwable -> L18
        r11.invalidateSelf();     // Catch: Throwable -> L18
        return;
    L22:
        return;
    L24:
        return;
    L13:
        r12 = null;
        goto L14
    }

    public final void k(int r5, c r10) {
        BackgroundDrawable r11 = (BackgroundDrawable) d();
        r11.getClass();
        if (r5 > 0) goto L5;
        return;
    L5:
        if (r5 > 8) goto L17;
        d r12 = r11.f10725z;
        if (r12 != null) goto L10;
        r11.f10725z = new d();
        Rect r13 = r11.getBounds();
        r11.f10725z.a(r13.width(), r13.height());
    L12:
        if (r11.f10725z.b(r5 - 1, r10) == false) goto L16;
        r11.f10721v = true;
        r11.invalidateSelf();
        return;
    L16:
        return;
    L10:
        r12.d = null;
        goto L12
    }

    public final boolean l(int r5, ReadableArray r10) {
        int r11 = 0;
        if (r10 != null) goto L5;
    L14:
        if (r5 != 0) goto L18;
        int r12 = 0;
    L16:
        if (r12 >= 4) goto L19;
        r12 = r12 + 1;
        k(r12, new c());
    L19:
        return false;
    L18:
        k(r5, new c());
        goto L19
    L5:
        if (r10.size() <= 0) goto L14;
        if (r5 != 0) goto L11;
        r10.size();
    L9:
        if (r11 >= 4) goto L22;
        int r13 = r11 + 1;
        k(r13, c.a(r11 * 4, r10));
        r11 = r13;
        goto L9
    L22:
        return true;
    L11:
        r10.size();
        k(r5, c.a(0, r10));
        return true;
    }

    public BackgroundDrawable m() {
        return new BackgroundDrawable(this.f10749a, this.d);
    }

    public final d n() {
        f r5 = this.f10750b;
        if (r5 != null) goto L7;
        return null;
    L7:
        return ((BackgroundDrawable) r5).f10725z;
    }
}
