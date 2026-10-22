package dn;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.lynx.tasm.behavior.ui.text.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f16668q;

    public c(int r10, int r11, int[] r12, b r13) {
        super(r10, r11, r12);
        this.f16668q = r13;
        r13.c(this.g, this.f, 0, 0, 0, 0);
        r13.D = true;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void c(Drawable.Callback r5) {
        this.f10703o = r5;
        if (this.g > 0) goto L5;
        return;
    L5:
        if (this.f <= 0) goto L9;
        this.f16668q.q();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a, android.text.style.ReplacementSpan
    public final void draw(Canvas r5, CharSequence r10, int r11, int r12, float r13, int r14, int r15, int r16, Paint r17) {
        if (this.f10703o != null) goto L5;
        return;
    L5:
        super.draw(r5, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final Drawable e() {
        return this.f16668q.f16687j;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void f() {
        b r5 = this.f16668q;
        if (r5 == null) goto L10;
        com.lynx.animax.player.b r10 = r5.g0;
        if (r10 != null) goto L8;
        return;
    L8:
        r10.d();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void g() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void h() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void i() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void j() {
    }
}
