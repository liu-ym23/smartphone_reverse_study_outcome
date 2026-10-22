package com.bytedance.ies.xelement.viewpager.childitem;

import android.content.Context;
import android.view.View;
import bf.h;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.bytedance.ies.xelement.viewpager.viewpager.LynxViewPagerNG;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.view.b;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/childitem/LynxFoldSlot;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/lynx/tasm/behavior/ui/view/b;", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxFoldSlot extends UIGroup<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LynxTabBarView f6539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LynxFoldSlotDrag f6540b;

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        return new b(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r5, int r10) {
        super.insertChild(r5, r10);
        if ((r5 instanceof LynxUI) == false) goto L26;
        LynxUI r11 = (LynxUI) r5;
        r11.setParent(this);
        if ((r11 instanceof LynxViewPagerNG) == false) goto L19;
        T r12 = ((LynxViewPagerNG) r5).getView();
        if (r12 != 0) goto L9;
        return;
    L9:
        if ((r12 instanceof h) == false) goto L30;
        LynxFoldSlotDrag r13 = this.f6540b;
        if (r13 == null) goto L14;
        this.f6539a = r13.f6542a;
        h r14 = (h) r12;
        Intrinsics.checkNotNullParameter(r14, "viewPager");
        r13.f6543b = new WeakReference(r14);
    L14:
        LynxTabBarView r15 = this.f6539a;
        if (r15 == null) goto L28;
        h r16 = (h) r12;
        r16.setTabLayout(r15);
        r16.setTabBarElementAdded(false);
        return;
    L28:
        return;
    L30:
        return;
    L19:
        if ((r11 instanceof LynxTabBarView) == false) goto L23;
        this.f6539a = (LynxTabBarView) r5;
        return;
    L23:
        if ((r11 instanceof LynxFoldSlotDrag) == false) goto L29;
        this.f6540b = (LynxFoldSlotDrag) r5;
        return;
    L29:
        return;
    }
}
