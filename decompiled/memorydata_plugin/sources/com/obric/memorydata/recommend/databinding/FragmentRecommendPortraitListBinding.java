package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.ui.list.FlowTabLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class FragmentRecommendPortraitListBinding implements ViewBinding {
    public final FrameLayout portraitFragmentContainer;
    public final FlowTabLayout recommendPortraitTags;
    private final LinearLayout rootView;

    private FragmentRecommendPortraitListBinding(LinearLayout r1, FrameLayout r2, FlowTabLayout r3) {
        this.rootView = r1;
        this.portraitFragmentContainer = r2;
        this.recommendPortraitTags = r3;
    }

    public static FragmentRecommendPortraitListBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.portrait_fragment_container, OaidModel.KEY_ID, "portrait_fragment_container");
        FrameLayout r2 = (FrameLayout) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.recommend_portrait_tags, OaidModel.KEY_ID, "recommend_portrait_tags");
        FlowTabLayout r1 = (FlowTabLayout) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), FlowTabLayout.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new FragmentRecommendPortraitListBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static FragmentRecommendPortraitListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentRecommendPortraitListBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.fragment_recommend_portrait_list, "layout", "fragment_recommend_portrait_list"), r4, false, "com.obric.memorydata.plugin");
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
