package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityAddressSettingBinding implements ViewBinding {
    public final ONestedScrollView addressSettingsContainer;
    public final DeviceAdaptiveCardListItem autoLearnSwitch;
    public final DeviceAdaptiveCardListItem companyAddressItem;
    public final View cutOff;
    public final DeviceAdaptiveCardListItem homeAddressItem;
    private final FrameLayout rootView;
    public final OFloatingTitleBar viewTitle;

    private ActivityAddressSettingBinding(FrameLayout r1, ONestedScrollView r2, DeviceAdaptiveCardListItem r3, DeviceAdaptiveCardListItem r4, View r5, DeviceAdaptiveCardListItem r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.addressSettingsContainer = r2;
        this.autoLearnSwitch = r3;
        this.companyAddressItem = r4;
        this.cutOff = r5;
        this.homeAddressItem = r6;
        this.viewTitle = r7;
    }

    public static ActivityAddressSettingBinding bind(View r13) {
        int r0 = ZeusTransformUtils.mapRes(R.id.address_settings_container, OaidModel.KEY_ID, "address_settings_container");
        ONestedScrollView r7 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.auto_learn_switch, OaidModel.KEY_ID, "auto_learn_switch");
        DeviceAdaptiveCardListItem r8 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.company_address_item, OaidModel.KEY_ID, "company_address_item");
        DeviceAdaptiveCardListItem r9 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r10 = r13.findViewById(r0);
        if (r10 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.home_address_item, OaidModel.KEY_ID, "home_address_item");
        DeviceAdaptiveCardListItem r11 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r12 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L17;
        return new ActivityAddressSettingBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r13, FrameLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityAddressSettingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityAddressSettingBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_address_setting, "layout", "activity_address_setting"), r4, false, "com.obric.memorydata.plugin");
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
