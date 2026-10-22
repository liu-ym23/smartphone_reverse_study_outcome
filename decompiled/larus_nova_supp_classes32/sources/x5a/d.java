package x5a;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.render.PlatformRendererContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends x6a.a {
    @Override // x6a.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // x6a.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // x6a.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // x6a.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // x6a.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    @Override // x6a.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    public d(LynxContext r1) {
        super(r1);
    }

    @Override // x6a.a, x6a.e
    public final x6a.i createRenderer(PlatformRendererContext r2, int r3) {
        return new com.lynx.component.svg.a(r2, r3);
    }
}
