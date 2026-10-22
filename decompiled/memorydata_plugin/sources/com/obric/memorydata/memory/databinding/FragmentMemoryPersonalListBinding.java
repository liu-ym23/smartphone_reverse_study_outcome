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
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentMemoryPersonalListBinding implements ViewBinding {
    public final View cutOff;
    public final OButtonFloating memoryDelete;
    public final OBottomActionBarFloating memoryOperationContainer;
    public final OTabLayout memoryPersonalTagsScrollable;
    public final ViewPager2 personalFragmentContainer;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final OUILinearLayout tagsContainerCollapse;
    public final OBlurMaskView titleBarContainer;
    public final LinearLayout titleBarLayout;
    public final OFloatingTitleBar viewTitleNormal;

    private FragmentMemoryPersonalListBinding(ConstraintLayout r1, View r2, OButtonFloating r3, OBottomActionBarFloating r4, OTabLayout r5, ViewPager2 r6, ConstraintLayout r7, OUILinearLayout r8, OBlurMaskView r9, LinearLayout r10, OFloatingTitleBar r11) {
        this.rootView = r1;
        this.cutOff = r2;
        this.memoryDelete = r3;
        this.memoryOperationContainer = r4;
        this.memoryPersonalTagsScrollable = r5;
        this.personalFragmentContainer = r6;
        this.rootLayout = r7;
        this.tagsContainerCollapse = r8;
        this.titleBarContainer = r9;
        this.titleBarLayout = r10;
        this.viewTitleNormal = r11;
    }

    public static FragmentMemoryPersonalListBinding bind(View r14) {
        int r0 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r4 = r14.findViewById(r0);
        if (r4 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_delete, OaidModel.KEY_ID, "memory_delete");
        OButtonFloating r5 = (OButtonFloating) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OButtonFloating.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_operation_container, OaidModel.KEY_ID, "memory_operation_container");
        OBottomActionBarFloating r6 = (OBottomActionBarFloating) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OBottomActionBarFloating.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_personal_tags_scrollable, OaidModel.KEY_ID, "memory_personal_tags_scrollable");
        OTabLayout r7 = (OTabLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OTabLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.personal_fragment_container, OaidModel.KEY_ID, "personal_fragment_container");
        ViewPager2 r8 = (ViewPager2) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), ViewPager2.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L23;
        ConstraintLayout r9 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r14, ConstraintLayout.class, "com.obric.memorydata.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.tags_container_collapse, OaidModel.KEY_ID, "tags_container_collapse");
        OUILinearLayout r10 = (OUILinearLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OUILinearLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container");
        OBlurMaskView r11 = (OBlurMaskView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OBlurMaskView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar_layout, OaidModel.KEY_ID, "title_bar_layout");
        LinearLayout r12 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.view_title_normal, OaidModel.KEY_ID, "view_title_normal");
        OFloatingTitleBar r13 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L23;
        return new FragmentMemoryPersonalListBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r14, ConstraintLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static FragmentMemoryPersonalListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentMemoryPersonalListBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.fragment_memory_personal_list, "layout", "fragment_memory_personal_list"), r4, false, "com.obric.memorydata.plugin");
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
