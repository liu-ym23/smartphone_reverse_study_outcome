package com.lynx.xelement.scroll.coordinator;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.xelement.scroll.coordinator.childitem.LynxUIScrollCoordinatorHeader;
import com.lynx.xelement.scroll.coordinator.childitem.LynxUIScrollCoordinatorSlot;
import com.lynx.xelement.scroll.coordinator.childitem.LynxUIScrollCoordinatorSlotDrag;
import com.lynx.xelement.scroll.coordinator.childitem.LynxUIScrollCoordinatorToolbar;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BehaviorGenerator {

    public static class a extends com.lynx.tasm.behavior.a {
        public a() {
            super("scroll-coordinator", false, true, false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new LynxUIScrollCoordinator(r2, r3);
        }
    }

    public static class b extends com.lynx.tasm.behavior.a {
        public b() {
            super("scroll-coordinator-slot", false, true, false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new LynxUIScrollCoordinatorSlot(r2, r3);
        }
    }

    public static class c extends com.lynx.tasm.behavior.a {
        public c() {
            super("scroll-coordinator-header", false, true, false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new LynxUIScrollCoordinatorHeader(r2, r3);
        }
    }

    public static class d extends com.lynx.tasm.behavior.a {
        public d() {
            super("scroll-coordinator-toolbar", false, true, false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new LynxUIScrollCoordinatorToolbar(r2, r3);
        }
    }

    public static class e extends com.lynx.tasm.behavior.a {
        public e() {
            super("scroll-coordinator-slot-drag", false, true, false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new LynxUIScrollCoordinatorSlotDrag(r2, r3);
        }
    }

    public BehaviorGenerator() {
    }

    public static List<com.lynx.tasm.behavior.a> getBehaviors() {
        ArrayList r0 = new ArrayList();
        r0.add(new a());
        r0.add(new b());
        r0.add(new c());
        r0.add(new d());
        r0.add(new e());
        return r0;
    }
}
