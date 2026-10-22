package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import com.google.android.material.navigation.NavigationBarItemView;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class NavigationRailItemView extends NavigationBarItemView {
    public NavigationRailItemView(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    public int getItemDefaultMarginResId() {
        return ZeusTransformUtils.mapRes(R.dimen.mtrl_navigation_rail_icon_margin, "dimen", "mtrl_navigation_rail_icon_margin");
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    public int getItemLayoutResId() {
        return ZeusTransformUtils.mapRes(R.layout.mtrl_navigation_rail_item, "layout", "mtrl_navigation_rail_item");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        if (View.MeasureSpec.getMode(r4) != 0) goto L6;
        int r5 = View.MeasureSpec.getSize(r4);
        int r6 = Math.max(getMeasuredHeight(), r5);
        setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(r6, r4, 0));
        return;
    }
}
