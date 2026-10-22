package com.lynx.tasm.behavior.ui.scroll;

import android.view.ViewGroup;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class AbsLynxUIScroll<T extends ViewGroup> extends UISimpleView<T> {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            a = r0;
            r0[ReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[ReadableType.String.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public void M(LynxBaseUI r1, boolean r2, String r3, String r4) {
    }

    public abstract void N(boolean r1);

    public abstract void O(boolean r1);

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean isScrollable() {
        return true;
    }

    @LynxProp(defaultInt = 0, name = "scroll-to-index")
    public abstract void scrollToIndex(int r1);

    @LynxProp(defaultBoolean = false, name = "block-descendant-focusability")
    public void setBlockDescendantFocusability(boolean r1) {
    }

    @LynxProp(defaultBoolean = false, name = "enable-new-nested")
    public void setEnableNewNested(boolean r1) {
    }

    @LynxProp(defaultBoolean = true, name = "enable-scroll")
    public void setEnableScroll(boolean r1) {
    }

    @LynxProp(defaultBoolean = false, name = "forbid-fling-focus-change")
    public void setForbidFlingFocusChange(boolean r1) {
    }

    @LynxProp(defaultInt = 0, name = "lower-threshold")
    public abstract void setLowerThreshole(int r1);

    @LynxProp(defaultBoolean = false, name = "scroll-bar-enable")
    public abstract void setScrollBarEnable(boolean r1);

    @LynxProp(defaultInt = 0, name = "scroll-left")
    public abstract void setScrollLeft(int r1);

    @LynxProp(defaultBoolean = false, name = "scroll-tap")
    public abstract void setScrollTap(boolean r1);

    @LynxProp(defaultInt = 0, name = "scroll-top")
    public abstract void setScrollTop(int r1);

    @LynxProp(defaultInt = 0, name = "upper-threshold")
    public abstract void setUpperThreshole(int r1);

    @LynxProp(name = "scroll-x")
    public void setScrollX(f6a.a r3) {
        if (r3 != null) goto L4;
        N(false);
        return;
    L4:
        int r0 = a.a[r3.getType().ordinal()];
        if (r0 != 1) goto L7;
        N(r3.asBoolean());
        return;
    L7:
        if (r0 != 2) goto L14;
        N("true".equals(r3.asString()));
        return;
    }

    @LynxProp(name = "scroll-y")
    public void setScrollY(f6a.a r4) {
        if (r4 != null) goto L5;
        O(true);
        return;
    L5:
        int r1 = a.a[r4.getType().ordinal()];
        if (r1 != 1) goto L8;
        O(r4.asBoolean());
        return;
    L8:
        if (r1 != 2) goto L15;
        O("true".equals(r4.asString()));
        return;
    }

    public AbsLynxUIScroll(LynxContext r1, Object r2) {
        super(r1, r2);
    }
}
