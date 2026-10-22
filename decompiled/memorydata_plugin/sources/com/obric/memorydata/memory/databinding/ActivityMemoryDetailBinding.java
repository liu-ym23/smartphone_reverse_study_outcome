package com.obric.memorydata.memory.databinding;

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

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityMemoryDetailBinding implements ViewBinding {
    public final View cutOff;
    private final FrameLayout rootView;
    public final RecyclerView rvMemoryList;
    public final OFloatingTitleBar viewTitle;

    private ActivityMemoryDetailBinding(FrameLayout r1, View r2, RecyclerView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.cutOff = r2;
        this.rvMemoryList = r3;
        this.viewTitle = r4;
    }

    public static ActivityMemoryDetailBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r2 = r6.findViewById(r0);
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.rv_memory_list, OaidModel.KEY_ID, "rv_memory_list");
        RecyclerView r4 = (RecyclerView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r1 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new ActivityMemoryDetailBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r6, FrameLayout.class, "com.obric.memorydata.plugin"), r2, r4, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityMemoryDetailBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityMemoryDetailBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_memory_detail, "layout", "activity_memory_detail"), r4, false, "com.obric.memorydata.plugin");
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
