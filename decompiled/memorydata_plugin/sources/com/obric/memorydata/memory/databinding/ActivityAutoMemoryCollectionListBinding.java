package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityAutoMemoryCollectionListBinding implements ViewBinding {
    public final OBottomActionBarFloating bottomActionBar;
    public final View cutOff;
    public final LinearLayout emptyView;
    public final OButtonFloating memoryDelete;
    public final OFloatingTitleBar normalTitleBar;
    private final FrameLayout rootView;
    public final RecyclerView rvMemoryList;

    private ActivityAutoMemoryCollectionListBinding(FrameLayout r1, OBottomActionBarFloating r2, View r3, LinearLayout r4, OButtonFloating r5, OFloatingTitleBar r6, RecyclerView r7) {
        this.rootView = r1;
        this.bottomActionBar = r2;
        this.cutOff = r3;
        this.emptyView = r4;
        this.memoryDelete = r5;
        this.normalTitleBar = r6;
        this.rvMemoryList = r7;
    }

    public static ActivityAutoMemoryCollectionListBinding bind(View r13) {
        int r0 = ZeusTransformUtils.mapRes(R.id.bottom_action_bar, OaidModel.KEY_ID, "bottom_action_bar");
        OBottomActionBarFloating r7 = (OBottomActionBarFloating) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OBottomActionBarFloating.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r8 = r13.findViewById(r0);
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.empty_view, OaidModel.KEY_ID, "empty_view");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_delete, OaidModel.KEY_ID, "memory_delete");
        OButtonFloating r10 = (OButtonFloating) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OButtonFloating.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.normal_title_bar, OaidModel.KEY_ID, "normal_title_bar");
        OFloatingTitleBar r11 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.rv_memory_list, OaidModel.KEY_ID, "rv_memory_list");
        RecyclerView r12 = (RecyclerView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L17;
        return new ActivityAutoMemoryCollectionListBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r13, FrameLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityAutoMemoryCollectionListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityAutoMemoryCollectionListBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_auto_memory_collection_list, "layout", "activity_auto_memory_collection_list"), r4, false, "com.obric.memorydata.plugin");
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
