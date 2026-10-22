package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.segmentedtab.OBottomNavigationBar;
import com.obric.oui.titlebar.OFloatingTitleBarActionHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityMemoryListBinding implements ViewBinding {
    public final View cutOffBottom;
    public final OFloatingTitleBarActionHost floatingTitleBarActionHost;
    public final OBottomNavigationBar memoryContainerTabView;
    public final ViewPager2 memoryTabContainer;
    private final ConstraintLayout rootView;

    private ActivityMemoryListBinding(ConstraintLayout r1, View r2, OFloatingTitleBarActionHost r3, OBottomNavigationBar r4, ViewPager2 r5) {
        this.rootView = r1;
        this.cutOffBottom = r2;
        this.floatingTitleBarActionHost = r3;
        this.memoryContainerTabView = r4;
        this.memoryTabContainer = r5;
    }

    public static ActivityMemoryListBinding bind(View r8) {
        int r0 = ZeusTransformUtils.mapRes(R.id.cut_off_bottom, OaidModel.KEY_ID, "cut_off_bottom");
        View r4 = r8.findViewById(r0);
        if (r4 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.floating_title_bar_action_host, OaidModel.KEY_ID, "floating_title_bar_action_host");
        OFloatingTitleBarActionHost r5 = (OFloatingTitleBarActionHost) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), OFloatingTitleBarActionHost.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_container_tab_view, OaidModel.KEY_ID, "memory_container_tab_view");
        OBottomNavigationBar r6 = (OBottomNavigationBar) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), OBottomNavigationBar.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_tab_container, OaidModel.KEY_ID, "memory_tab_container");
        ViewPager2 r7 = (ViewPager2) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), ViewPager2.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        return new ActivityMemoryListBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r8, ConstraintLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityMemoryListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityMemoryListBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_memory_list, "layout", "activity_memory_list"), r4, false, "com.obric.memorydata.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return bind(r6);
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
