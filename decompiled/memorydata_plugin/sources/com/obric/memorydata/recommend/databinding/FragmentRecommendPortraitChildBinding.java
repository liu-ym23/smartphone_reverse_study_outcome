package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class FragmentRecommendPortraitChildBinding implements ViewBinding {
    public final LinearLayout layoutEmpty;
    private final ConstraintLayout rootView;
    public final RecyclerView rvMemoryList;

    private FragmentRecommendPortraitChildBinding(ConstraintLayout r1, LinearLayout r2, RecyclerView r3) {
        this.rootView = r1;
        this.layoutEmpty = r2;
        this.rvMemoryList = r3;
    }

    public static FragmentRecommendPortraitChildBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.layout_empty, OaidModel.KEY_ID, "layout_empty");
        LinearLayout r2 = (LinearLayout) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.rv_memory_list, OaidModel.KEY_ID, "rv_memory_list");
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new FragmentRecommendPortraitChildBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static FragmentRecommendPortraitChildBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentRecommendPortraitChildBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.fragment_recommend_portrait_child, "layout", "fragment_recommend_portrait_child"), r4, false, "com.obric.memorydata.plugin");
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
