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
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityMemorySearchBinding implements ViewBinding {
    public final View cutOff;
    public final LinearLayout layoutEmpty;
    public final LinearLayout layoutLoading;
    public final OButtonFloating memoryDelete;
    public final OBottomActionBarFloating memoryOperationContainer;
    public final OSearchBar memorySearchBar;
    public final LinearLayout memorySearchBarContainer;
    public final OIconButtonFloating memorySearchCancel;
    public final ODownloadProgressView progressViewProcessing3;
    private final FrameLayout rootView;
    public final RecyclerView rvMemoryList;
    public final LinearLayout searchHeaderContainer;
    public final OTabLayout searchTabContainer;
    public final OUILinearLayout searchTabGroup;
    public final OFloatingTitleBar viewTitleEdit;

    private ActivityMemorySearchBinding(FrameLayout r1, View r2, LinearLayout r3, LinearLayout r4, OButtonFloating r5, OBottomActionBarFloating r6, OSearchBar r7, LinearLayout r8, OIconButtonFloating r9, ODownloadProgressView r10, RecyclerView r11, LinearLayout r12, OTabLayout r13, OUILinearLayout r14, OFloatingTitleBar r15) {
        this.rootView = r1;
        this.cutOff = r2;
        this.layoutEmpty = r3;
        this.layoutLoading = r4;
        this.memoryDelete = r5;
        this.memoryOperationContainer = r6;
        this.memorySearchBar = r7;
        this.memorySearchBarContainer = r8;
        this.memorySearchCancel = r9;
        this.progressViewProcessing3 = r10;
        this.rvMemoryList = r11;
        this.searchHeaderContainer = r12;
        this.searchTabContainer = r13;
        this.searchTabGroup = r14;
        this.viewTitleEdit = r15;
    }

    public static ActivityMemorySearchBinding bind(View r19) {
        int r1 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r5 = r19.findViewById(r1);
        if (r5 == null) goto L34;
        r1 = ZeusTransformUtils.mapRes(R.id.layout_empty, OaidModel.KEY_ID, "layout_empty");
        LinearLayout r6 = (LinearLayout) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L34;
        r1 = ZeusTransformUtils.mapRes(R.id.layout_loading, OaidModel.KEY_ID, "layout_loading");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L34;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_delete, OaidModel.KEY_ID, "memory_delete");
        OButtonFloating r8 = (OButtonFloating) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OButtonFloating.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L34;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_operation_container, OaidModel.KEY_ID, "memory_operation_container");
        OBottomActionBarFloating r9 = (OBottomActionBarFloating) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OBottomActionBarFloating.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L34;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_search_bar, OaidModel.KEY_ID, "memory_search_bar");
        OSearchBar r10 = (OSearchBar) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OSearchBar.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L34;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_search_bar_container, OaidModel.KEY_ID, "memory_search_bar_container");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L34;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_search_cancel, OaidModel.KEY_ID, "memory_search_cancel");
        OIconButtonFloating r12 = (OIconButtonFloating) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OIconButtonFloating.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L34;
        r1 = ZeusTransformUtils.mapRes(R.id.progress_view_processing_3, OaidModel.KEY_ID, "progress_view_processing_3");
        ODownloadProgressView r13 = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), ODownloadProgressView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L34;
        r1 = ZeusTransformUtils.mapRes(R.id.rv_memory_list, OaidModel.KEY_ID, "rv_memory_list");
        RecyclerView r14 = (RecyclerView) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L34;
        r1 = ZeusTransformUtils.mapRes(R.id.search_header_container, OaidModel.KEY_ID, "search_header_container");
        LinearLayout r15 = (LinearLayout) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L34;
        int r2 = ZeusTransformUtils.mapRes(R.id.search_tab_container, OaidModel.KEY_ID, "search_tab_container");
        int r16 = r2;
        OTabLayout r3 = (OTabLayout) ZeusTransformUtils.preCheckCast(r19.findViewById(r2), OTabLayout.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L32;
        int r4 = ZeusTransformUtils.mapRes(R.id.search_tab_group, OaidModel.KEY_ID, "search_tab_group");
        r16 = r4;
        OUILinearLayout r17 = (OUILinearLayout) ZeusTransformUtils.preCheckCast(r19.findViewById(r4), OUILinearLayout.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L32;
        r1 = ZeusTransformUtils.mapRes(R.id.view_title_edit, OaidModel.KEY_ID, "view_title_edit");
        OFloatingTitleBar r18 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L34;
        return new ActivityMemorySearchBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r19, FrameLayout.class, "com.obric.memorydata.plugin"), r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r3, r17, r18);
    L32:
        r1 = r16;
    L34:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r19, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityMemorySearchBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityMemorySearchBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_memory_search, "layout", "activity_memory_search"), r4, false, "com.obric.memorydata.plugin");
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
