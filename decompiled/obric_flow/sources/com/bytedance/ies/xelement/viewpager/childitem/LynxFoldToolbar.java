package com.bytedance.ies.xelement.viewpager.childitem;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.xelement.viewpager.foldview.FoldViewLayoutNG;
import com.bytedance.ies.xelement.viewpager.foldview.LynxFoldViewNG;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.a0;
import com.lynx.tasm.behavior.ui.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ye.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/childitem/LynxFoldToolbar;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lye/e;", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxFoldToolbar extends UIGroup<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6544a;

    public LynxFoldToolbar(b0 r5, z r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        return new e(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setNativeInteractionEnabled(boolean r5) {
        super.setNativeInteractionEnabled(r5);
        ((e) this.mView).setHandleGesture(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setOverflow(Integer r5) {
        super.setOverflow(r5);
        Object r10 = r5;
        if (r5 != null) goto L5;
        r10 = Boolean.FALSE;
    L5:
        boolean r11 = Intrinsics.areEqual(r10, 1);
        this.f6544a = !r11;
        ((e) this.mView).setClipChildren(r11);
        if ((getParent() instanceof LynxFoldViewNG) == false) goto L13;
        a0 r12 = getParent();
        if (r12 == null) goto L12;
        ((FoldViewLayoutNG) ((LynxFoldViewNG) r12).j()).d.setClipChildren(r11);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.xelement.viewpager.foldview.LynxFoldViewNG");
    }
}
