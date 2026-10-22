package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Rect;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class e extends f<BackgroundDrawable> {
    public int e;

    public BackgroundDrawable l() {
        return new BackgroundDrawable(this.a, this.d);
    }

    public final BorderRadius m() {
        T r0 = this.b;
        if (r0 != 0) goto L7;
        return null;
    L7:
        return ((BackgroundDrawable) r0).A;
    }

    @Override // com.lynx.tasm.behavior.ui.utils.f
    public /* bridge */ /* synthetic */ d a() {
        return l();
    }

    public e(LynxContext r1) {
        super(r1);
        this.e = 0;
    }

    public final void n(int r2) {
        this.e = r2;
        if (r2 == 0) goto L5;
    L7:
        b().setColor(r2);
        return;
    L5:
        if (this.b != 0) goto L7;
    }

    public final void p(int r4, Integer r5) {
        float r0 = 1.0E21f;
        if (r5 != null) goto L5;
        float r1 = 1.0E21f;
    L6:
        if (r5 == null) goto L9;
        r0 = r5.intValue() >>> 24;
    L9:
        o(r4, r1, r0);
        return;
    L5:
        r1 = r5.intValue() & 16777215;
        goto L6
    }

    public final boolean q(int r5, ReadableArray r6) {
        int r1 = 0;
        if (r6 != null) goto L5;
    L22:
        if (r5 != 0) goto L26;
        int r7 = 0;
    L24:
        if (r7 >= 4) goto L27;
        r7 = r7 + 1;
        r(r7, new BorderRadius.a());
    L27:
        return false;
    L26:
        r(r5, new BorderRadius.a());
        goto L27
    L5:
        if (r6.size() <= 0) goto L22;
        if (r5 != 0) goto L17;
        if (r6.size() != 16) goto L12;
        boolean r8 = true;
    L13:
        LLog.DCHECK(r8);
    L14:
        if (r1 >= 4) goto L21;
        int r9 = r1 + 1;
        r(r9, BorderRadius.a.a(r6, r1 * 4));
        r1 = r9;
    L21:
        return true;
    L12:
        r8 = false;
        goto L13
    L17:
        if (r6.size() != 4) goto L19;
        boolean r0 = true;
    L20:
        LLog.DCHECK(r0);
        r(r5, BorderRadius.a.a(r6, 0));
        goto L21
    L19:
        r0 = false;
        goto L20
    }

    public final void r(int r5, BorderRadius.a r6) {
        BackgroundDrawable r0 = b();
        r0.getClass();
        if (r5 > 0) goto L5;
        return;
    L5:
        if (r5 > 8) goto L17;
        BorderRadius r1 = r0.A;
        if (r1 != null) goto L10;
        r0.A = new BorderRadius();
        Rect r2 = r0.getBounds();
        r0.A.d(r2.width(), r2.height());
    L12:
        if (r0.A.c(r5 - 1, r6) == false) goto L16;
        r0.w = true;
        r0.invalidateSelf();
        return;
    L16:
        return;
    L10:
        r1.d = null;
        goto L12
    }

    public final void s(int r4, int r5) {
        BackgroundDrawable r0 = b();
        r0.getClass();
        if (r4 > 8) goto L16;
        if (r4 >= 0) goto L7;
        return;
    L7:
        if (r0.l != null) goto L14;
        r0.l = new BorderStyle[9];
    L14:
        BorderStyle r6 = BorderStyle.parse(r5);     // Catch: Throwable -> L13
        BorderStyle[] r1 = r0.l;     // Catch: Throwable -> L13
        if (r1[r4] == r6) goto L17;
        r1[r4] = r6;     // Catch: Throwable -> L13
        r0.invalidateSelf();     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L19:
        return;
    }

    public final void o(int r4, float r5, float r6) {
        BackgroundDrawable r0 = b();
        if (r0.j != null) goto L5;
        r0.j = new k(0.0f);
    L5:
        r0.j.b(r4, r5);
        if (r0.k != null) goto L8;
        r0.k = new k(255.0f);
    L8:
        r0.k.b(r4, r6);
    }
}
