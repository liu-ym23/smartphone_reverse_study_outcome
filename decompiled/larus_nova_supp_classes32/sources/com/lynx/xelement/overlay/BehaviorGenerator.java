package com.lynx.xelement.overlay;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BehaviorGenerator {

    public static class a extends com.lynx.tasm.behavior.a {
        public a() {
            super("overlay", false, false, false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new LynxUIOverlayNGShadowNode();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new LynxUIOverlayNG(r2, r3);
        }
    }

    public BehaviorGenerator() {
    }

    public static List<com.lynx.tasm.behavior.a> getBehaviors() {
        ArrayList r0 = new ArrayList();
        r0.add(new a());
        return r0;
    }
}
