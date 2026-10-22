package p8a;

import android.content.Context;
import android.view.Choreographer;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends com.lynx.tasm.behavior.ui.view.a {
    public d a;
    public b b;

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.invalidate();
        return;
    }

    public c(Context r1) {
        super(r1);
        this.b = null;
        setWillNotDraw(true);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [p8a.b] */
    public void setBundle(a r3) {
        if (this.b != null) goto L5;
        this.b = new b(this);
        Choreographer.getInstance().postFrameCallback(this.b);
    L5:
        if (r3 == null) goto L12;
        View r0 = r3.a;
        View r1 = this.a;
        if (r0 == r1) goto L13;
        if (r1 == null) goto L10;
        removeView(r1);
    L10:
        d r4 = r3.a;
        this.a = r4;
        addView(r4);
        return;
    L13:
        return;
    }
}
