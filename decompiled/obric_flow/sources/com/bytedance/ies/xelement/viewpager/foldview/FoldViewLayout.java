package com.bytedance.ies.xelement.viewpager.foldview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ies.xelement.viewpager.CustomAppBarLayout;
import com.bytedance.ies.xelement.viewpager.FoldToolbarLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.obric.launcher.widget.R$layout;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/foldview/FoldViewLayout;", "Lcom/bytedance/ies/xelement/viewpager/FoldToolbarLayout;", "Lcom/bytedance/ies/xelement/viewpager/CustomAppBarLayout;", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FoldViewLayout extends FoldToolbarLayout<CustomAppBarLayout> {
    public FoldViewLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5);
    }

    @Override // com.bytedance.ies.xelement.viewpager.FoldToolbarLayout
    public final int a() {
        return R$layout.x_foldtoolbar_layout;
    }

    @Override // com.bytedance.ies.xelement.viewpager.FoldToolbarLayout
    public final void b(boolean r5) {
        CollapsingToolbarLayout r10 = this.f6511c;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof AppBarLayout.LayoutParams) == false) goto L9;
        if (r5 == true) goto L6;
        ((AppBarLayout.LayoutParams) r11).setScrollFlags(0);
    L7:
        r10.setLayoutParams(r11);
        return;
    L6:
        ((AppBarLayout.LayoutParams) r11).setScrollFlags(this.f6509a);
        goto L7
    }
}
