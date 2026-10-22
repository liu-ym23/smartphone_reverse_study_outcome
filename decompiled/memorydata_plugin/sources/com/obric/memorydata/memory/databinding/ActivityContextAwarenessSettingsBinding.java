package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityContextAwarenessSettingsBinding implements ViewBinding {
    public final DeviceAdaptiveCardListItem ambientVoice;
    public final DeviceAdaptiveCardListItem blockRules;
    public final DeviceAdaptiveCardListItem cellularUpload;
    public final ONestedScrollView contextAwarenessContainer;
    public final View cutOff;
    public final TextView dataManagementSectionTitle;
    public final TextView debugSectionTitle;
    public final DeviceAdaptiveCardListItem deviceState;
    public final DeviceAdaptiveCardListItem enhancedTimeliness;
    public final DeviceAdaptiveCardListItem location;
    public final DeviceAdaptiveCardListItem motionState;
    public final DeviceAdaptiveCardListItem notificationContent;
    public final DeviceAdaptiveCardListItem recorderAmbientVoiceCollectionDebug;
    private final FrameLayout rootView;
    public final DeviceAdaptiveCardListItem screenContent;
    public final DeviceAdaptiveCardListItem smartGlasses;
    public final TextView sourceSectionTitle;
    public final DeviceAdaptiveCardListItem systemAppData;
    public final OFloatingTitleBar viewTitle;

    private ActivityContextAwarenessSettingsBinding(FrameLayout r3, DeviceAdaptiveCardListItem r4, DeviceAdaptiveCardListItem r5, DeviceAdaptiveCardListItem r6, ONestedScrollView r7, View r8, TextView r9, TextView r10, DeviceAdaptiveCardListItem r11, DeviceAdaptiveCardListItem r12, DeviceAdaptiveCardListItem r13, DeviceAdaptiveCardListItem r14, DeviceAdaptiveCardListItem r15, DeviceAdaptiveCardListItem r16, DeviceAdaptiveCardListItem r17, DeviceAdaptiveCardListItem r18, TextView r19, DeviceAdaptiveCardListItem r20, OFloatingTitleBar r21) {
        this.rootView = r3;
        this.ambientVoice = r4;
        this.blockRules = r5;
        this.cellularUpload = r6;
        this.contextAwarenessContainer = r7;
        this.cutOff = r8;
        this.dataManagementSectionTitle = r9;
        this.debugSectionTitle = r10;
        this.deviceState = r11;
        this.enhancedTimeliness = r12;
        this.location = r13;
        this.motionState = r14;
        this.notificationContent = r15;
        this.recorderAmbientVoiceCollectionDebug = r16;
        this.screenContent = r17;
        this.smartGlasses = r18;
        this.sourceSectionTitle = r19;
        this.systemAppData = r20;
        this.viewTitle = r21;
    }

    public static ActivityContextAwarenessSettingsBinding bind(View r26) {
        int r1 = ZeusTransformUtils.mapRes(R.id.ambient_voice, OaidModel.KEY_ID, "ambient_voice");
        DeviceAdaptiveCardListItem r8 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.block_rules, OaidModel.KEY_ID, "block_rules");
        DeviceAdaptiveCardListItem r9 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.cellular_upload, OaidModel.KEY_ID, "cellular_upload");
        DeviceAdaptiveCardListItem r10 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.context_awareness_container, OaidModel.KEY_ID, "context_awareness_container");
        ONestedScrollView r11 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r12 = r26.findViewById(r1);
        if (r12 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.data_management_section_title, OaidModel.KEY_ID, "data_management_section_title");
        TextView r13 = (TextView) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.debug_section_title, OaidModel.KEY_ID, "debug_section_title");
        TextView r14 = (TextView) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.device_state, OaidModel.KEY_ID, "device_state");
        DeviceAdaptiveCardListItem r15 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.enhanced_timeliness, OaidModel.KEY_ID, "enhanced_timeliness");
        DeviceAdaptiveCardListItem r16 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.location, OaidModel.KEY_ID, "location");
        DeviceAdaptiveCardListItem r17 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.motion_state, OaidModel.KEY_ID, "motion_state");
        DeviceAdaptiveCardListItem r18 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.notification_content, OaidModel.KEY_ID, "notification_content");
        DeviceAdaptiveCardListItem r19 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.recorder_ambient_voice_collection_debug, OaidModel.KEY_ID, "recorder_ambient_voice_collection_debug");
        DeviceAdaptiveCardListItem r20 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.screen_content, OaidModel.KEY_ID, "screen_content");
        DeviceAdaptiveCardListItem r21 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.smart_glasses, OaidModel.KEY_ID, "smart_glasses");
        DeviceAdaptiveCardListItem r22 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.source_section_title, OaidModel.KEY_ID, "source_section_title");
        TextView r23 = (TextView) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.system_app_data, OaidModel.KEY_ID, "system_app_data");
        DeviceAdaptiveCardListItem r24 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L41;
        r1 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r25 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r26.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L41;
        return new ActivityContextAwarenessSettingsBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r26, FrameLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r26, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityContextAwarenessSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityContextAwarenessSettingsBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_context_awareness_settings, "layout", "activity_context_awareness_settings"), r4, false, "com.obric.memorydata.plugin");
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
