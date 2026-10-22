package com.bytedance.ies.xelement.viewpager.childitem;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.google.android.material.tabs.TabLayout;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.u0;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.view.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xe.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/childitem/LynxTabbarItem;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/lynx/tasm/behavior/ui/view/b;", "Lcom/lynx/tasm/behavior/u0;", "", "select", "", "setSelect", "(Z)V", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxTabbarItem extends UIGroup<b> implements u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f6545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TabLayout.Tab f6546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f6547c;
    public boolean d;
    public ze.a e;
    public boolean f;

    @Override // com.lynx.tasm.behavior.u0
    public final void b() {
        if (this.f == false) goto L14;
        this.f = false;
        if (this.d == false) goto L15;
        ze.a r5 = this.e;
        if (r5 == null) goto L16;
        Integer r10 = this.f6545a;
        if (r10 == null) goto L17;
        Intrinsics.checkNotNull(r10);
        TabLayout.Tab r11 = r5.getTabAt(r10.intValue());
        if (r11 == null) goto L18;
        r11.select();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        return new b(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        ViewParent r5 = ((b) this.mView).getParent();
        if ((r5 instanceof a) == false) goto L5;
        a r10 = (a) r5;
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        r10.setOverflow(getOverflow());
        return;
    L5:
        r10 = null;
        goto L6
    }

    @c0(name = "select")
    public final void setSelect(boolean r5) {
        if (this.d != r5) goto L5;
        return;
    L5:
        this.f = true;
        this.d = r5;
        if (r5 == false) goto L15;
        ze.a r10 = this.e;
        if (r10 == null) goto L16;
        Integer r11 = this.f6545a;
        if (r11 == null) goto L17;
        Intrinsics.checkNotNull(r11);
        TabLayout.Tab r12 = r10.getTabAt(r11.intValue());
        if (r12 == null) goto L18;
        r12.select();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }
}
