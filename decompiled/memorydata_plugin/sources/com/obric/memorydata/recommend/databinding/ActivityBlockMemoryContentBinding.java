package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ActivityBlockMemoryContentBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final RecyclerView rvBlockContent;
    public final OFloatingTitleBar title;

    private ActivityBlockMemoryContentBinding(FrameLayout r1, RecyclerView r2, OFloatingTitleBar r3) {
        this.rootView = r1;
        this.rvBlockContent = r2;
        this.title = r3;
    }

    public static ActivityBlockMemoryContentBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.rv_block_content, OaidModel.KEY_ID, "rv_block_content");
        RecyclerView r2 = (RecyclerView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title");
        OFloatingTitleBar r1 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new ActivityBlockMemoryContentBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityBlockMemoryContentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityBlockMemoryContentBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_block_memory_content, "layout", "activity_block_memory_content"), r4, false, "com.obric.memorydata.plugin");
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
