package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class FragmentBlockMemoryListBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final RecyclerView rvBlockContent;

    private FragmentBlockMemoryListBinding(ConstraintLayout r1, RecyclerView r2) {
        this.rootView = r1;
        this.rvBlockContent = r2;
    }

    public static FragmentBlockMemoryListBinding bind(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.rv_block_content, OaidModel.KEY_ID, "rv_block_content");
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        return new FragmentBlockMemoryListBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r4, ConstraintLayout.class, "com.obric.memorydata.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static FragmentBlockMemoryListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentBlockMemoryListBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.fragment_block_memory_list, "layout", "fragment_block_memory_list"), r4, false, "com.obric.memorydata.plugin");
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
