package com.lynx.tasm.behavior.ui.view;

import android.content.Context;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.z;
import java.util.HashMap;
import ym.j;

/* JADX INFO: loaded from: classes2.dex */
public class UIComponent extends UIView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f10769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10771c;
    public UIListContainer d;

    public UIComponent(b0 r5, z r10) {
        super(r5, r10);
        this.f10771c = 0;
        if (r5.g() == false) goto L6;
        this.mOverflow = 3;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        this.f10769a = null;
        this.d = null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView
    public final b onCreateView(Context r5) {
        return new c(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        j r5 = this.f10769a;
        if (r5 == null) goto L6;
        ((UIListContainer) r5.f23302a).p(this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        UIListContainer r5 = this.d;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.e == true) goto L7;
        return;
    L7:
        if (r5.f10583v == false) goto L22;
        String r10 = this.f10770b;
        if (r10 == null) goto L23;
        boolean r11 = r5.f10584w.contains(r10);
        HashMap r12 = r5.f10586y;
        if (r11 == false) goto L14;
        r5.q(this, r12, true);
        return;
    L14:
        boolean r13 = r5.f10585x.contains(r10);
        HashMap r14 = r5.f10587z;
        if (r13 == false) goto L18;
        r5.q(this, r14, true);
        return;
    L18:
        r5.q(this, r12, false);
        r5.q(this, r14, false);
        return;
    L23:
        return;
    }

    @c0(name = "item-key")
    public void setItemKey(String r5) {
        this.f10770b = r5;
    }

    @c0(defaultInt = 0, name = "z-index")
    public void setZIndex(int r5) {
        this.f10771c = r5;
    }
}
