package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.actionbar.v2.OBottomActionBarNormalHorizontal;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ActivityGuideFeatureBinding implements ViewBinding {
    public final OBottomActionBarNormalHorizontal barGuideNext;
    private final FrameLayout rootView;
    public final RecyclerView rvFeatureList;
    public final OFloatingTitleBar viewTitle;

    private ActivityGuideFeatureBinding(FrameLayout r1, OBottomActionBarNormalHorizontal r2, RecyclerView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.barGuideNext = r2;
        this.rvFeatureList = r3;
        this.viewTitle = r4;
    }

    public static ActivityGuideFeatureBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.bar_guide_next, OaidModel.KEY_ID, "bar_guide_next");
        OBottomActionBarNormalHorizontal r2 = (OBottomActionBarNormalHorizontal) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OBottomActionBarNormalHorizontal.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.rv_feature_list, OaidModel.KEY_ID, "rv_feature_list");
        RecyclerView r3 = (RecyclerView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r1 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new ActivityGuideFeatureBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r6, FrameLayout.class, "com.obric.memorydata.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityGuideFeatureBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityGuideFeatureBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_guide_feature, "layout", "activity_guide_feature"), r4, false, "com.obric.memorydata.plugin");
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
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
