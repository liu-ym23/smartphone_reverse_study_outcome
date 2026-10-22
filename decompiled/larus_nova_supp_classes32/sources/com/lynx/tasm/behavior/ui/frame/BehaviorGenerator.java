package com.lynx.tasm.behavior.ui.frame;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.scroll.LynxUIScrollView;
import com.lynx.tasm.behavior.ui.swiper.SwiperShadowNode;
import com.lynx.tasm.behavior.ui.swiper.XSwiperUI;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BehaviorGenerator {

    public static class a extends com.lynx.tasm.behavior.a {
        public a() {
            super("scroll-view-new-arch", false, false, false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUI(LynxContext r2) {
            return new LynxUIScrollView(r2);
        }
    }

    public static class b extends com.lynx.tasm.behavior.a {
        public b() {
            super("frame", false, false, false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new FrameShadowNode();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new UIFrame(r2, r3);
        }
    }

    public static class c extends com.lynx.tasm.behavior.a {
        public c() {
            super("swiper", false, true, false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new SwiperShadowNode();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new XSwiperUI(r2, r3);
        }
    }

    public BehaviorGenerator() {
    }

    public static List<com.lynx.tasm.behavior.a> getBehaviors() {
        ArrayList r0 = new ArrayList();
        r0.add(new a());
        r0.add(new b());
        r0.add(new c());
        return r0;
    }
}
