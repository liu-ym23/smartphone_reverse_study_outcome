package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class GlobalMemoryFragmentBinding implements ViewBinding {
    public final OIconButtonFloating btnSourceFilter;
    public final View cutOff;
    public final OButtonFloating memoryDelete;
    public final OBottomActionBarFloating memoryOperationContainer;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final OTabLayout rvSourceFilter;
    public final OUILinearLayout sourceFilterGroup;
    public final OBlurMaskView titleBarContainer;
    public final LinearLayout titleBarLayout;
    public final ViewPager2 viewPagerMemory;
    public final OFloatingTitleBar viewTitleNormal;

    private GlobalMemoryFragmentBinding(ConstraintLayout r1, OIconButtonFloating r2, View r3, OButtonFloating r4, OBottomActionBarFloating r5, ConstraintLayout r6, OTabLayout r7, OUILinearLayout r8, OBlurMaskView r9, LinearLayout r10, ViewPager2 r11, OFloatingTitleBar r12) {
        this.rootView = r1;
        this.btnSourceFilter = r2;
        this.cutOff = r3;
        this.memoryDelete = r4;
        this.memoryOperationContainer = r5;
        this.rootLayout = r6;
        this.rvSourceFilter = r7;
        this.sourceFilterGroup = r8;
        this.titleBarContainer = r9;
        this.titleBarLayout = r10;
        this.viewPagerMemory = r11;
        this.viewTitleNormal = r12;
    }

    public static GlobalMemoryFragmentBinding bind(View r19) {
        int r1 = ZeusTransformUtils.mapRes(R.id.btn_source_filter, OaidModel.KEY_ID, "btn_source_filter");
        OIconButtonFloating r8 = (OIconButtonFloating) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OIconButtonFloating.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r9 = r19.findViewById(r1);
        if (r9 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_delete, OaidModel.KEY_ID, "memory_delete");
        OButtonFloating r10 = (OButtonFloating) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OButtonFloating.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_operation_container, OaidModel.KEY_ID, "memory_operation_container");
        OBottomActionBarFloating r11 = (OBottomActionBarFloating) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OBottomActionBarFloating.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L25;
        ConstraintLayout r12 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r19, ConstraintLayout.class, "com.obric.memorydata.plugin");
        r1 = ZeusTransformUtils.mapRes(R.id.rv_source_filter, OaidModel.KEY_ID, "rv_source_filter");
        OTabLayout r13 = (OTabLayout) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OTabLayout.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.source_filter_group, OaidModel.KEY_ID, "source_filter_group");
        OUILinearLayout r14 = (OUILinearLayout) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OUILinearLayout.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container");
        OBlurMaskView r15 = (OBlurMaskView) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OBlurMaskView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.title_bar_layout, OaidModel.KEY_ID, "title_bar_layout");
        LinearLayout r16 = (LinearLayout) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.view_pager_memory, OaidModel.KEY_ID, "view_pager_memory");
        ViewPager2 r17 = (ViewPager2) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), ViewPager2.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.view_title_normal, OaidModel.KEY_ID, "view_title_normal");
        OFloatingTitleBar r18 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L25;
        return new GlobalMemoryFragmentBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r19, ConstraintLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r19, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static GlobalMemoryFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static GlobalMemoryFragmentBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.global_memory_fragment, "layout", "global_memory_fragment"), r4, false, "com.obric.memorydata.plugin");
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
