package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityActiveMemorySettingsBinding implements ViewBinding {
    public final DeviceAdaptiveCardListItem activeGestureMemory;
    public final DeviceAdaptiveCardListItem activeKeyMemory;
    public final ONestedScrollView activeMemorySettingsContainer;
    public final DeviceAdaptiveCardListItem activeScreenMemory;
    public final DeviceAdaptiveCardListItem activeTextMemory;
    public final View cutOff;
    public final ImageView ivActiveMemory1;
    public final ImageView ivActiveMemory2;
    public final ImageView ivActiveMemory3;
    public final ImageView ivActiveMemory4;
    public final ConstraintLayout llActiveMemory1;
    public final ConstraintLayout llActiveMemory2;
    public final ConstraintLayout llActiveMemory3;
    public final ConstraintLayout llActiveMemory4;
    private final FrameLayout rootView;
    public final OFloatingTitleBar viewTitle;

    private ActivityActiveMemorySettingsBinding(FrameLayout r3, DeviceAdaptiveCardListItem r4, DeviceAdaptiveCardListItem r5, ONestedScrollView r6, DeviceAdaptiveCardListItem r7, DeviceAdaptiveCardListItem r8, View r9, ImageView r10, ImageView r11, ImageView r12, ImageView r13, ConstraintLayout r14, ConstraintLayout r15, ConstraintLayout r16, ConstraintLayout r17, OFloatingTitleBar r18) {
        this.rootView = r3;
        this.activeGestureMemory = r4;
        this.activeKeyMemory = r5;
        this.activeMemorySettingsContainer = r6;
        this.activeScreenMemory = r7;
        this.activeTextMemory = r8;
        this.cutOff = r9;
        this.ivActiveMemory1 = r10;
        this.ivActiveMemory2 = r11;
        this.ivActiveMemory3 = r12;
        this.ivActiveMemory4 = r13;
        this.llActiveMemory1 = r14;
        this.llActiveMemory2 = r15;
        this.llActiveMemory3 = r16;
        this.llActiveMemory4 = r17;
        this.viewTitle = r18;
    }

    public static ActivityActiveMemorySettingsBinding bind(View r23) {
        int r1 = ZeusTransformUtils.mapRes(R.id.active_gesture_memory, OaidModel.KEY_ID, "active_gesture_memory");
        DeviceAdaptiveCardListItem r8 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.active_key_memory, OaidModel.KEY_ID, "active_key_memory");
        DeviceAdaptiveCardListItem r9 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.active_memory_settings_container, OaidModel.KEY_ID, "active_memory_settings_container");
        ONestedScrollView r10 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.active_screen_memory, OaidModel.KEY_ID, "active_screen_memory");
        DeviceAdaptiveCardListItem r11 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.active_text_memory, OaidModel.KEY_ID, "active_text_memory");
        DeviceAdaptiveCardListItem r12 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r13 = r23.findViewById(r1);
        if (r13 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_active_memory_1, OaidModel.KEY_ID, "iv_active_memory_1");
        ImageView r14 = (ImageView) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_active_memory_2, OaidModel.KEY_ID, "iv_active_memory_2");
        ImageView r15 = (ImageView) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_active_memory_3, OaidModel.KEY_ID, "iv_active_memory_3");
        ImageView r16 = (ImageView) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_active_memory_4, OaidModel.KEY_ID, "iv_active_memory_4");
        ImageView r17 = (ImageView) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_active_memory_1, OaidModel.KEY_ID, "ll_active_memory_1");
        ConstraintLayout r18 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_active_memory_2, OaidModel.KEY_ID, "ll_active_memory_2");
        ConstraintLayout r19 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_active_memory_3, OaidModel.KEY_ID, "ll_active_memory_3");
        ConstraintLayout r20 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_active_memory_4, OaidModel.KEY_ID, "ll_active_memory_4");
        ConstraintLayout r21 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r22 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L35;
        return new ActivityActiveMemorySettingsBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r23, FrameLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r23, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityActiveMemorySettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityActiveMemorySettingsBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_active_memory_settings, "layout", "activity_active_memory_settings"), r4, false, "com.obric.memorydata.plugin");
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
