package com.lynx.xelement.input;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BehaviorGenerator {

    public static class a extends com.lynx.tasm.behavior.a {
        public a() {
            super("x-textarea-ng", false, false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new LynxUITextAreaNGShadowNode();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new LynxUITextAreaNG(r2, r3);
        }
    }

    public static class b extends com.lynx.tasm.behavior.a {
        public b() {
            super("x-input-ng", false, false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new LynxUIInputNGShadowNode();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new LynxUIInputNG(r2, r3);
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
