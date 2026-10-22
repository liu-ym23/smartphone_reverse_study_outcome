package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryCalendarTabFragmentLayoutBinding implements ViewBinding {
    public final MemoryCalendarTopLayoutBinding calendarBarContainer;
    public final OButtonFloating memoryDelete;
    public final ViewPager2 memoryListContainer;
    public final OBottomActionBarFloating memoryOperationContainer;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final OBlurMaskView titleBarContainer;
    public final OFloatingTitleBar viewTitleNormal;

    private MemoryCalendarTabFragmentLayoutBinding(ConstraintLayout r1, MemoryCalendarTopLayoutBinding r2, OButtonFloating r3, ViewPager2 r4, OBottomActionBarFloating r5, ConstraintLayout r6, OBlurMaskView r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.calendarBarContainer = r2;
        this.memoryDelete = r3;
        this.memoryListContainer = r4;
        this.memoryOperationContainer = r5;
        this.rootLayout = r6;
        this.titleBarContainer = r7;
        this.viewTitleNormal = r8;
    }

    public static MemoryCalendarTabFragmentLayoutBinding bind(View r13) {
        int r0 = ZeusTransformUtils.mapRes(R.id.calendar_bar_container, OaidModel.KEY_ID, "calendar_bar_container");
        View r2 = r13.findViewById(r0);
        if (r2 == null) goto L17;
        MemoryCalendarTopLayoutBinding r6 = MemoryCalendarTopLayoutBinding.bind(r2);
        r0 = ZeusTransformUtils.mapRes(R.id.memory_delete, OaidModel.KEY_ID, "memory_delete");
        OButtonFloating r7 = (OButtonFloating) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OButtonFloating.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_list_container, OaidModel.KEY_ID, "memory_list_container");
        ViewPager2 r8 = (ViewPager2) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), ViewPager2.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_operation_container, OaidModel.KEY_ID, "memory_operation_container");
        OBottomActionBarFloating r9 = (OBottomActionBarFloating) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OBottomActionBarFloating.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        ConstraintLayout r10 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r13, ConstraintLayout.class, "com.obric.memorydata.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container");
        OBlurMaskView r11 = (OBlurMaskView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OBlurMaskView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.view_title_normal, OaidModel.KEY_ID, "view_title_normal");
        OFloatingTitleBar r12 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L17;
        return new MemoryCalendarTabFragmentLayoutBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r13, ConstraintLayout.class, "com.obric.memorydata.plugin"), r6, r7, r8, r9, r10, r11, r12);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static MemoryCalendarTabFragmentLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemoryCalendarTabFragmentLayoutBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.memory_calendar_tab_fragment_layout, "layout", "memory_calendar_tab_fragment_layout"), r4, false, "com.obric.memorydata.plugin");
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
