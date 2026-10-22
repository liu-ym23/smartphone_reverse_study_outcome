package com.lynx.tasm.behavior.ui.view;

import android.content.Context;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIComponent extends UIView {
    public b a;
    public String b;
    public int c;
    public a d;

    public interface a {
    }

    public interface b {
        void a(UIComponent r1);
    }

    public String getType() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView, com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        this.a = null;
        this.d = null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        b r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        super.onNodeReady();
        a r0 = this.d;
        if (r0 == null) goto L18;
        UIListContainer r1 = (UIListContainer) r0;
        if (r1.e == true) goto L7;
        return;
    L7:
        if (r1.v == false) goto L20;
        String r2 = this.b;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r1.w.contains(r2) == false) goto L14;
        r1.h0(this, r1.y, true);
        return;
    L14:
        if (r1.x.contains(r2) == false) goto L16;
        r1.h0(this, r1.z, true);
        return;
    L16:
        r1.h0(this, r1.y, false);
        r1.h0(this, r1.z, false);
        return;
    L20:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView
    public final com.lynx.tasm.behavior.ui.view.a onCreateView(Context r2) {
        return new com.lynx.tasm.behavior.ui.view.b(r2);
    }

    @LynxProp(name = "item-key")
    public void setItemKey(String r1) {
        this.b = r1;
    }

    @LynxProp(defaultInt = 0, name = "z-index")
    public void setZIndex(int r1) {
        this.c = r1;
    }

    public UIComponent(LynxContext r1, Object r2) {
        super(r1, r2);
        this.c = 0;
        if (r1.getDefaultOverflowVisible() == false) goto L6;
        this.mOverflow = 3;
        return;
    }
}
