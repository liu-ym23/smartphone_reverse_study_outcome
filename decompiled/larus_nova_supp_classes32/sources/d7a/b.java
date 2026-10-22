package d7a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.behavior.ui.image.InlineImageShadowNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends com.lynx.tasm.behavior.ui.text.a {
    public f q;

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void e() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void f() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void g() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void h() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final Drawable c() {
        return this.q.j;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void d() {
        f r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        f.e r1 = r0.V1;
        if (r1 == null) goto L10;
        r1.b();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void j(Drawable.Callback r1) {
        this.o = r1;
        if (this.g > 0) goto L5;
        return;
    L5:
        if (this.f <= 0) goto L9;
        this.q.z();
        return;
    }

    public b(int r1, int r2, int[] r3) {
        super(r1, r2, r3);
    }

    public b(int r8, int r9, int[] r10, InlineImageShadowNode.a r11) {
        super(r8, r9, r10);
        this.q = r11;
        r11.l(this.g, this.f, 0, 0, 0, 0);
        this.q.F = true;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a, android.text.style.ReplacementSpan
    public final void draw(Canvas r2, CharSequence r3, int r4, int r5, float r6, int r7, int r8, int r9, Paint r10) {
        if (this.o != null) goto L5;
        return;
    L5:
        super.draw(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }
}
