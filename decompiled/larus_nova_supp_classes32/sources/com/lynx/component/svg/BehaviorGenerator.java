package com.lynx.component.svg;

import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BehaviorGenerator {

    public static class a extends com.lynx.tasm.behavior.a {
        public a() {
            super(SVGRenderEngine.SVG, false, true, false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final x6a.e createPlatformRendererHost(LynxContext r2) {
            return new x5a.d(r2);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new UISvg(r2, r3);
        }
    }

    public static class b extends com.lynx.tasm.behavior.a {
        public b() {
            super("x-svg", false, true, false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final x6a.e createPlatformRendererHost(LynxContext r2) {
            return new x5a.d(r2);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new UISvg(r2, r3);
        }
    }

    public BehaviorGenerator() {
    }

    public static List<com.lynx.tasm.behavior.a> getBehaviors() {
        ArrayList r0 = new ArrayList();
        r0.add(new a());
        r0.add(new b());
        return r0;
    }
}
