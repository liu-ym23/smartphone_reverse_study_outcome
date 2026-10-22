package com.lynx.tasm.behavior.ui.scroll;

import android.view.ViewGroup;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsLynxUIScroll<T extends ViewGroup> extends UISimpleView<T> {
    public void b(LynxBaseUI r5, boolean r10, String r11, String r12) {
    }

    public abstract void c(boolean r5);

    public abstract void i(boolean r5);

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollable() {
        return true;
    }

    @c0(defaultInt = 0, name = "scroll-to-index")
    public abstract void scrollToIndex(int r5);

    @c0(defaultBoolean = false, name = "block-descendant-focusability")
    public void setBlockDescendantFocusability(boolean r5) {
    }

    @c0(defaultBoolean = false, name = "enable-new-nested")
    public void setEnableNewNested(boolean r5) {
    }

    @c0(defaultBoolean = true, name = "enable-scroll")
    public void setEnableScroll(boolean r5) {
    }

    @c0(defaultBoolean = false, name = "forbid-fling-focus-change")
    public void setForbidFlingFocusChange(boolean r5) {
    }

    @c0(defaultInt = 0, name = "lower-threshold")
    public abstract void setLowerThreshole(int r5);

    @c0(defaultBoolean = false, name = "scroll-bar-enable")
    public abstract void setScrollBarEnable(boolean r5);

    @c0(defaultInt = 0, name = "scroll-left")
    public abstract void setScrollLeft(int r5);

    @c0(defaultBoolean = false, name = "scroll-tap")
    public abstract void setScrollTap(boolean r5);

    @c0(defaultInt = 0, name = "scroll-top")
    public abstract void setScrollTop(int r5);

    @c0(name = "scroll-x")
    public void setScrollX(pm.a r5) {
        if (r5 != null) goto L5;
        c(false);
        return;
    L5:
        int r10 = gn.a.f17109a[r5.getType().ordinal()];
        if (r10 != 1) goto L8;
        c(r5.asBoolean());
        return;
    L8:
        if (r10 == 2) goto L10;
        return;
    L10:
        c("true".equals(r5.asString()));
    }

    @c0(name = "scroll-y")
    public void setScrollY(pm.a r5) {
        if (r5 != null) goto L6;
        i(true);
        return;
    L6:
        int r10 = gn.a.f17109a[r5.getType().ordinal()];
        if (r10 != 1) goto L9;
        i(r5.asBoolean());
        return;
    L9:
        if (r10 == 2) goto L11;
        return;
    L11:
        i("true".equals(r5.asString()));
    }

    @c0(defaultInt = 0, name = "upper-threshold")
    public abstract void setUpperThreshole(int r5);
}
