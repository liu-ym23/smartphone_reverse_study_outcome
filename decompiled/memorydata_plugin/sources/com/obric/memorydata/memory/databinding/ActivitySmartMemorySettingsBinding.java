package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivitySmartMemorySettingsBinding implements ViewBinding {
    public final View cutOff;
    private final FrameLayout rootView;
    public final RecyclerView rvAppSettings;
    public final ONestedScrollView smartMemorySettingsContainer;
    public final DeviceAdaptiveCardListItem smartMemorySwitch;
    public final OFloatingTitleBar viewTitle;

    private ActivitySmartMemorySettingsBinding(FrameLayout r1, View r2, RecyclerView r3, ONestedScrollView r4, DeviceAdaptiveCardListItem r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.cutOff = r2;
        this.rvAppSettings = r3;
        this.smartMemorySettingsContainer = r4;
        this.smartMemorySwitch = r5;
        this.viewTitle = r6;
    }

    public static ActivitySmartMemorySettingsBinding bind(View r9) {
        int r0 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r4 = r9.findViewById(r0);
        if (r4 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.rv_app_settings, OaidModel.KEY_ID, "rv_app_settings");
        RecyclerView r5 = (RecyclerView) ZeusTransformUtils.preCheckCast(r9.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.smart_memory_settings_container, OaidModel.KEY_ID, "smart_memory_settings_container");
        ONestedScrollView r6 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r9.findViewById(r0), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.smart_memory_switch, OaidModel.KEY_ID, "smart_memory_switch");
        DeviceAdaptiveCardListItem r7 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r9.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r8 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r9.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L15;
        return new ActivitySmartMemorySettingsBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r9, FrameLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivitySmartMemorySettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivitySmartMemorySettingsBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_smart_memory_settings, "layout", "activity_smart_memory_settings"), r4, false, "com.obric.memorydata.plugin");
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
