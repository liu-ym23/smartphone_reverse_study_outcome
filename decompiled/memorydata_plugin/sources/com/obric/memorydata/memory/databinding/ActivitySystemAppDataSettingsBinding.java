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
public final class ActivitySystemAppDataSettingsBinding implements ViewBinding {
    public final View cutOff;
    private final FrameLayout rootView;
    public final DeviceAdaptiveCardListItem systemAppAlarm;
    public final DeviceAdaptiveCardListItem systemAppCalendar;
    public final ONestedScrollView systemAppDataContainer;
    public final DeviceAdaptiveCardListItem systemAppFile;
    public final DeviceAdaptiveCardListItem systemAppGallery;
    public final DeviceAdaptiveCardListItem systemAppNote;
    public final DeviceAdaptiveCardListItem systemAppPhone;
    public final DeviceAdaptiveCardListItem systemAppRecorder;
    public final DeviceAdaptiveCardListItem systemAppSms;
    public final OFloatingTitleBar viewTitle;

    private ActivitySystemAppDataSettingsBinding(FrameLayout r1, View r2, DeviceAdaptiveCardListItem r3, DeviceAdaptiveCardListItem r4, ONestedScrollView r5, DeviceAdaptiveCardListItem r6, DeviceAdaptiveCardListItem r7, DeviceAdaptiveCardListItem r8, DeviceAdaptiveCardListItem r9, DeviceAdaptiveCardListItem r10, DeviceAdaptiveCardListItem r11, OFloatingTitleBar r12) {
        this.rootView = r1;
        this.cutOff = r2;
        this.systemAppAlarm = r3;
        this.systemAppCalendar = r4;
        this.systemAppDataContainer = r5;
        this.systemAppFile = r6;
        this.systemAppGallery = r7;
        this.systemAppNote = r8;
        this.systemAppPhone = r9;
        this.systemAppRecorder = r10;
        this.systemAppSms = r11;
        this.viewTitle = r12;
    }

    public static ActivitySystemAppDataSettingsBinding bind(View r15) {
        int r0 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r4 = r15.findViewById(r0);
        if (r4 == null) goto L27;
        r0 = ZeusTransformUtils.mapRes(R.id.system_app_alarm, OaidModel.KEY_ID, "system_app_alarm");
        DeviceAdaptiveCardListItem r5 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L27;
        r0 = ZeusTransformUtils.mapRes(R.id.system_app_calendar, OaidModel.KEY_ID, "system_app_calendar");
        DeviceAdaptiveCardListItem r6 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L27;
        r0 = ZeusTransformUtils.mapRes(R.id.system_app_data_container, OaidModel.KEY_ID, "system_app_data_container");
        ONestedScrollView r7 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L27;
        r0 = ZeusTransformUtils.mapRes(R.id.system_app_file, OaidModel.KEY_ID, "system_app_file");
        DeviceAdaptiveCardListItem r8 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L27;
        r0 = ZeusTransformUtils.mapRes(R.id.system_app_gallery, OaidModel.KEY_ID, "system_app_gallery");
        DeviceAdaptiveCardListItem r9 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L27;
        r0 = ZeusTransformUtils.mapRes(R.id.system_app_note, OaidModel.KEY_ID, "system_app_note");
        DeviceAdaptiveCardListItem r10 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L27;
        r0 = ZeusTransformUtils.mapRes(R.id.system_app_phone, OaidModel.KEY_ID, "system_app_phone");
        DeviceAdaptiveCardListItem r11 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L27;
        r0 = ZeusTransformUtils.mapRes(R.id.system_app_recorder, OaidModel.KEY_ID, "system_app_recorder");
        DeviceAdaptiveCardListItem r12 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L27;
        r0 = ZeusTransformUtils.mapRes(R.id.system_app_sms, OaidModel.KEY_ID, "system_app_sms");
        DeviceAdaptiveCardListItem r13 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L27;
        r0 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r14 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L27;
        return new ActivitySystemAppDataSettingsBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r15, FrameLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r15, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivitySystemAppDataSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivitySystemAppDataSettingsBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_system_app_data_settings, "layout", "activity_system_app_data_settings"), r4, false, "com.obric.memorydata.plugin");
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
