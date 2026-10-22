package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.tabs.TabLayout;
import com.obric.memorydata.plugin.R;
import com.obric.oui.titlebar.OCTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ActivityRecommendMemoryListBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TabLayout tabMemory;
    public final ViewPager2 viewPagerMemory;
    public final OCTitleBar viewTitle;

    private ActivityRecommendMemoryListBinding(LinearLayout r1, TabLayout r2, ViewPager2 r3, OCTitleBar r4) {
        this.rootView = r1;
        this.tabMemory = r2;
        this.viewPagerMemory = r3;
        this.viewTitle = r4;
    }

    public static ActivityRecommendMemoryListBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.tab_memory, OaidModel.KEY_ID, "tab_memory");
        TabLayout r2 = (TabLayout) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), TabLayout.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.view_pager_memory, OaidModel.KEY_ID, "view_pager_memory");
        ViewPager2 r3 = (ViewPager2) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), ViewPager2.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OCTitleBar r1 = (OCTitleBar) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OCTitleBar.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new ActivityRecommendMemoryListBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r6, LinearLayout.class, "com.obric.memorydata.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityRecommendMemoryListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityRecommendMemoryListBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_recommend_memory_list, "layout", "activity_recommend_memory_list"), r4, false, "com.obric.memorydata.plugin");
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
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
