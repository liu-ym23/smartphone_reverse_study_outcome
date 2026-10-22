package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.ui.settings.ForceTouchOBanner;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.banner.BannerFriendlyFrameLayout;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.indicator.OCarouselIndicator;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityMemorySettingsBinding implements ViewBinding {
    public final DeviceAdaptiveCardListItem activeMemory;
    public final DeviceAdaptiveCardListItem aiLab;
    public final DeviceAdaptiveCardListItem authSwitch;
    public final DeviceAdaptiveCardListItem commonLocationManager;
    public final DeviceAdaptiveCardListItem contextAwareness;
    public final View cutOff;
    public final DeviceAdaptiveCardListItem dataExport;
    public final DeviceAdaptiveCardListItem lifelogApp;
    public final TextView memoryAppTitle;
    public final FrameLayout memoryBannerContainer;
    public final OCarouselIndicator memoryBannerIndicator;
    public final DeviceAdaptiveCardListItem memoryBuildDataPackage;
    public final DeviceAdaptiveCardListItem memoryData;
    public final TextView memoryMethodTitle;
    public final ForceTouchOBanner memorySettingsBannerInnerWrapper;
    public final ConstraintLayout memorySettingsBannerWrapper;
    public final ONestedScrollView memorySettingsContainer;
    public final DeviceAdaptiveCardListItem pinIcon;
    public final DeviceAdaptiveCardListItem privacyPolicy;
    public final DeviceAdaptiveCardListItem proactiveUi;
    private final BannerFriendlyFrameLayout rootView;
    public final DeviceAdaptiveCardListItem smartMemory;
    public final DeviceAdaptiveCardListItem uxpSwitch;
    public final OFloatingTitleBar viewTitle;
    public final DeviceAdaptiveCardListItem voice;

    private ActivityMemorySettingsBinding(BannerFriendlyFrameLayout r3, DeviceAdaptiveCardListItem r4, DeviceAdaptiveCardListItem r5, DeviceAdaptiveCardListItem r6, DeviceAdaptiveCardListItem r7, DeviceAdaptiveCardListItem r8, View r9, DeviceAdaptiveCardListItem r10, DeviceAdaptiveCardListItem r11, TextView r12, FrameLayout r13, OCarouselIndicator r14, DeviceAdaptiveCardListItem r15, DeviceAdaptiveCardListItem r16, TextView r17, ForceTouchOBanner r18, ConstraintLayout r19, ONestedScrollView r20, DeviceAdaptiveCardListItem r21, DeviceAdaptiveCardListItem r22, DeviceAdaptiveCardListItem r23, DeviceAdaptiveCardListItem r24, DeviceAdaptiveCardListItem r25, OFloatingTitleBar r26, DeviceAdaptiveCardListItem r27) {
        this.rootView = r3;
        this.activeMemory = r4;
        this.aiLab = r5;
        this.authSwitch = r6;
        this.commonLocationManager = r7;
        this.contextAwareness = r8;
        this.cutOff = r9;
        this.dataExport = r10;
        this.lifelogApp = r11;
        this.memoryAppTitle = r12;
        this.memoryBannerContainer = r13;
        this.memoryBannerIndicator = r14;
        this.memoryBuildDataPackage = r15;
        this.memoryData = r16;
        this.memoryMethodTitle = r17;
        this.memorySettingsBannerInnerWrapper = r18;
        this.memorySettingsBannerWrapper = r19;
        this.memorySettingsContainer = r20;
        this.pinIcon = r21;
        this.privacyPolicy = r22;
        this.proactiveUi = r23;
        this.smartMemory = r24;
        this.uxpSwitch = r25;
        this.viewTitle = r26;
        this.voice = r27;
    }

    public static ActivityMemorySettingsBinding bind(View r32) {
        int r1 = ZeusTransformUtils.mapRes(R.id.activeMemory, OaidModel.KEY_ID, "activeMemory");
        DeviceAdaptiveCardListItem r8 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.ai_lab, OaidModel.KEY_ID, "ai_lab");
        DeviceAdaptiveCardListItem r9 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.authSwitch, OaidModel.KEY_ID, "authSwitch");
        DeviceAdaptiveCardListItem r10 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.commonLocationManager, OaidModel.KEY_ID, "commonLocationManager");
        DeviceAdaptiveCardListItem r11 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.contextAwareness, OaidModel.KEY_ID, "contextAwareness");
        DeviceAdaptiveCardListItem r12 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r13 = r32.findViewById(r1);
        if (r13 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.data_export, OaidModel.KEY_ID, "data_export");
        DeviceAdaptiveCardListItem r14 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.lifelogApp, OaidModel.KEY_ID, "lifelogApp");
        DeviceAdaptiveCardListItem r15 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.memoryAppTitle, OaidModel.KEY_ID, "memoryAppTitle");
        TextView r16 = (TextView) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_banner_container, OaidModel.KEY_ID, "memory_banner_container");
        FrameLayout r17 = (FrameLayout) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_banner_indicator, OaidModel.KEY_ID, "memory_banner_indicator");
        OCarouselIndicator r18 = (OCarouselIndicator) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), OCarouselIndicator.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_build_data_package, OaidModel.KEY_ID, "memory_build_data_package");
        DeviceAdaptiveCardListItem r19 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.memoryData, OaidModel.KEY_ID, "memoryData");
        DeviceAdaptiveCardListItem r20 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.memoryMethodTitle, OaidModel.KEY_ID, "memoryMethodTitle");
        TextView r21 = (TextView) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_settings_banner_inner_wrapper, OaidModel.KEY_ID, "memory_settings_banner_inner_wrapper");
        ForceTouchOBanner r22 = (ForceTouchOBanner) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), ForceTouchOBanner.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_settings_banner_wrapper, OaidModel.KEY_ID, "memory_settings_banner_wrapper");
        ConstraintLayout r23 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_settings_container, OaidModel.KEY_ID, "memory_settings_container");
        ONestedScrollView r24 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.pinIcon, OaidModel.KEY_ID, "pinIcon");
        DeviceAdaptiveCardListItem r25 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.privacy_policy, OaidModel.KEY_ID, "privacy_policy");
        DeviceAdaptiveCardListItem r26 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.proactiveUi, OaidModel.KEY_ID, "proactiveUi");
        DeviceAdaptiveCardListItem r27 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r27 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.smartMemory, OaidModel.KEY_ID, "smartMemory");
        DeviceAdaptiveCardListItem r28 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r28 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.uxp_switch, OaidModel.KEY_ID, "uxp_switch");
        DeviceAdaptiveCardListItem r29 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r29 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r30 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r30 == null) goto L53;
        r1 = ZeusTransformUtils.mapRes(R.id.voice, OaidModel.KEY_ID, "voice");
        DeviceAdaptiveCardListItem r31 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r32.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r31 == null) goto L53;
        return new ActivityMemorySettingsBinding((BannerFriendlyFrameLayout) ZeusTransformUtils.preCheckCast(r32, BannerFriendlyFrameLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31);
    L53:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r32, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityMemorySettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityMemorySettingsBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_memory_settings, "layout", "activity_memory_settings"), r4, false, "com.obric.memorydata.plugin");
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
    public BannerFriendlyFrameLayout getRoot() {
        return this.rootView;
    }
}
