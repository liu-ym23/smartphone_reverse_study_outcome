package com.obric.memorydata.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.divider.ODivider;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivitySettingPageBinding implements ViewBinding {
    public final FrameLayout arrowBackImageHotArea;
    public final ODivider dividerNavigation;
    public final LinearLayout headerLinearLayout;
    private final ConstraintLayout rootView;
    public final LinearLayout subSwitchLinearLayout;
    public final OSwitch switchInstantEntityIndex;
    public final OSwitch switchOnAvoidDataImport;
    public final AppCompatTextView textInstantEntityIndex;
    public final AppCompatTextView textOnAvoidDataImport;

    private ActivitySettingPageBinding(ConstraintLayout r1, FrameLayout r2, ODivider r3, LinearLayout r4, LinearLayout r5, OSwitch r6, OSwitch r7, AppCompatTextView r8, AppCompatTextView r9) {
        this.rootView = r1;
        this.arrowBackImageHotArea = r2;
        this.dividerNavigation = r3;
        this.headerLinearLayout = r4;
        this.subSwitchLinearLayout = r5;
        this.switchInstantEntityIndex = r6;
        this.switchOnAvoidDataImport = r7;
        this.textInstantEntityIndex = r8;
        this.textOnAvoidDataImport = r9;
    }

    public static ActivitySettingPageBinding bind(View r15) {
        int r0 = ZeusTransformUtils.mapRes(R.id.arrow_back_image_hot_area, OaidModel.KEY_ID, "arrow_back_image_hot_area");
        FrameLayout r7 = (FrameLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.divider_navigation, OaidModel.KEY_ID, "divider_navigation");
        ODivider r8 = (ODivider) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), ODivider.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.header_linear_layout, OaidModel.KEY_ID, "header_linear_layout");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.sub_switch_linear_layout, OaidModel.KEY_ID, "sub_switch_linear_layout");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.switch_instant_entity_index, OaidModel.KEY_ID, "switch_instant_entity_index");
        OSwitch r11 = (OSwitch) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OSwitch.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.switch_on_avoid_data_import, OaidModel.KEY_ID, "switch_on_avoid_data_import");
        OSwitch r12 = (OSwitch) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OSwitch.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.text_instant_entity_index, OaidModel.KEY_ID, "text_instant_entity_index");
        AppCompatTextView r13 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.text_on_avoid_data_import, OaidModel.KEY_ID, "text_on_avoid_data_import");
        AppCompatTextView r14 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L21;
        return new ActivitySettingPageBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r15, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12, r13, r14);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r15, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivitySettingPageBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivitySettingPageBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_setting_page, "layout", "activity_setting_page"), r4, false, "com.obric.memorydata.plugin");
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
