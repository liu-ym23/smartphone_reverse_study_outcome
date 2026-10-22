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
public final class ActivityRuleMemorySettingBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final RecyclerView rvAppList;
    public final OFloatingTitleBar title;

    private ActivityRuleMemorySettingBinding(FrameLayout r1, RecyclerView r2, OFloatingTitleBar r3) {
        this.rootView = r1;
        this.rvAppList = r2;
        this.title = r3;
    }

    public static ActivityRuleMemorySettingBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.rv_app_list, OaidModel.KEY_ID, "rv_app_list");
        RecyclerView r2 = (RecyclerView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title");
        OFloatingTitleBar r1 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new ActivityRuleMemorySettingBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityRuleMemorySettingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityRuleMemorySettingBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_rule_memory_setting, "layout", "activity_rule_memory_setting"), r4, false, "com.obric.memorydata.plugin");
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
