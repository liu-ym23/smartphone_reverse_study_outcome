package com.lynx.xelement.viewpager;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.xelement.viewpager.childitem.LynxUIViewPagerItemNG;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BehaviorGenerator {

    public static class a extends com.lynx.tasm.behavior.a {
        public a() {
            super("viewpager", false, true, false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new LynxUIViewPagerNG(r2, r3);
        }
    }

    public static class b extends com.lynx.tasm.behavior.a {
        public b() {
            super(LynxViewpagerItem.X_ELEMENT_TAG, false, true, false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new LynxUIViewPagerItemNG(r2, r3);
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
