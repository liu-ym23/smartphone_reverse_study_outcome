package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityAddressEditBinding implements ViewBinding {
    public final FrameLayout addressContainer;
    public final LinearLayout addressEmptyView;
    public final LinearLayout addressHeaderContainer;
    public final OBlurMaskView addressHeaderMask;
    public final RecyclerView addressRecyclerView;
    public final RecyclerView addressSearchResultRecyclerView;
    public final View cutOff;
    private final FrameLayout rootView;
    public final OSearchBar searchBar;
    public final LinearLayout searchBarContainer;
    public final OIconButtonFloating searchCancelButton;
    public final FrameLayout searchContainer;
    public final OTextView searchEmptyView;
    public final OFloatingTitleBar titleBar;

    private ActivityAddressEditBinding(FrameLayout r1, FrameLayout r2, LinearLayout r3, LinearLayout r4, OBlurMaskView r5, RecyclerView r6, RecyclerView r7, View r8, OSearchBar r9, LinearLayout r10, OIconButtonFloating r11, FrameLayout r12, OTextView r13, OFloatingTitleBar r14) {
        this.rootView = r1;
        this.addressContainer = r2;
        this.addressEmptyView = r3;
        this.addressHeaderContainer = r4;
        this.addressHeaderMask = r5;
        this.addressRecyclerView = r6;
        this.addressSearchResultRecyclerView = r7;
        this.cutOff = r8;
        this.searchBar = r9;
        this.searchBarContainer = r10;
        this.searchCancelButton = r11;
        this.searchContainer = r12;
        this.searchEmptyView = r13;
        this.titleBar = r14;
    }

    public static ActivityAddressEditBinding bind(View r21) {
        int r1 = ZeusTransformUtils.mapRes(R.id.address_container, OaidModel.KEY_ID, "address_container");
        FrameLayout r8 = (FrameLayout) ZeusTransformUtils.preCheckCast(r21.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L31;
        r1 = ZeusTransformUtils.mapRes(R.id.address_empty_view, OaidModel.KEY_ID, "address_empty_view");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r21.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L31;
        r1 = ZeusTransformUtils.mapRes(R.id.address_header_container, OaidModel.KEY_ID, "address_header_container");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r21.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L31;
        r1 = ZeusTransformUtils.mapRes(R.id.address_header_mask, OaidModel.KEY_ID, "address_header_mask");
        OBlurMaskView r11 = (OBlurMaskView) ZeusTransformUtils.preCheckCast(r21.findViewById(r1), OBlurMaskView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L31;
        r1 = ZeusTransformUtils.mapRes(R.id.address_recycler_view, OaidModel.KEY_ID, "address_recycler_view");
        RecyclerView r12 = (RecyclerView) ZeusTransformUtils.preCheckCast(r21.findViewById(r1), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L31;
        r1 = ZeusTransformUtils.mapRes(R.id.address_search_result_recycler_view, OaidModel.KEY_ID, "address_search_result_recycler_view");
        RecyclerView r13 = (RecyclerView) ZeusTransformUtils.preCheckCast(r21.findViewById(r1), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L31;
        r1 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r14 = r21.findViewById(r1);
        if (r14 == null) goto L31;
        r1 = ZeusTransformUtils.mapRes(R.id.search_bar, OaidModel.KEY_ID, "search_bar");
        OSearchBar r15 = (OSearchBar) ZeusTransformUtils.preCheckCast(r21.findViewById(r1), OSearchBar.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L31;
        r1 = ZeusTransformUtils.mapRes(R.id.search_bar_container, OaidModel.KEY_ID, "search_bar_container");
        LinearLayout r16 = (LinearLayout) ZeusTransformUtils.preCheckCast(r21.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L31;
        r1 = ZeusTransformUtils.mapRes(R.id.search_cancel_button, OaidModel.KEY_ID, "search_cancel_button");
        OIconButtonFloating r17 = (OIconButtonFloating) ZeusTransformUtils.preCheckCast(r21.findViewById(r1), OIconButtonFloating.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L31;
        r1 = ZeusTransformUtils.mapRes(R.id.search_container, OaidModel.KEY_ID, "search_container");
        FrameLayout r18 = (FrameLayout) ZeusTransformUtils.preCheckCast(r21.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L31;
        r1 = ZeusTransformUtils.mapRes(R.id.search_empty_view, OaidModel.KEY_ID, "search_empty_view");
        OTextView r19 = (OTextView) ZeusTransformUtils.preCheckCast(r21.findViewById(r1), OTextView.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L31;
        r1 = ZeusTransformUtils.mapRes(R.id.title_bar, OaidModel.KEY_ID, "title_bar");
        OFloatingTitleBar r20 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r21.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L31;
        return new ActivityAddressEditBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r21, FrameLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r21, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityAddressEditBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityAddressEditBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_address_edit, "layout", "activity_address_edit"), r4, false, "com.obric.memorydata.plugin");
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
