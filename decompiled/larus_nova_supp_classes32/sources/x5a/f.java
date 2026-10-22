package x5a;

import com.lynx.component.svg.UISvg;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends com.lynx.tasm.behavior.a {
    public f() {
        super(SVGRenderEngine.SVG, false, true, false, true);
    }

    @Override // com.lynx.tasm.behavior.a
    public final x6a.e createPlatformRendererHost(LynxContext r2) {
        return new d(r2);
    }

    @Override // com.lynx.tasm.behavior.a
    public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
        return new UISvg(r2, r3);
    }
}
