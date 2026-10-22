package com.obric.memorydata.memory.databinding;

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
public final class ActivityMemorySettingPageBinding implements ViewBinding {
    public final FrameLayout arrowBackImageHotArea;
    public final ODivider dividerNavigation;
    public final AppCompatTextView globalMemorySwtichDescText;
    public final LinearLayout headerLinearLayout;
    public final AppCompatTextView memoryTitle;
    private final ConstraintLayout rootView;
    public final LinearLayout subSwitchLinearLayout;
    public final FrameLayout switchContainerGlobalMemory;
    public final OSwitch switchGlobalMemory;
    public final OSwitch switchInstantEntityIndex;
    public final OSwitch switchOnScreenUseClientOcr;
    public final OSwitch switchPersonalContextKgUse;
    public final OSwitch switchRecommend;
    public final OSwitch switchRecommendTts;
    public final AppCompatTextView textGlobalMemory;
    public final AppCompatTextView textInstantEntityIndex;
    public final AppCompatTextView textOnScreenUseClientOcr;
    public final AppCompatTextView textPersonalContextKgAppUse;
    public final AppCompatTextView textRecommend;
    public final AppCompatTextView textRecommendTts;

    private ActivityMemorySettingPageBinding(ConstraintLayout r3, FrameLayout r4, ODivider r5, AppCompatTextView r6, LinearLayout r7, AppCompatTextView r8, LinearLayout r9, FrameLayout r10, OSwitch r11, OSwitch r12, OSwitch r13, OSwitch r14, OSwitch r15, OSwitch r16, AppCompatTextView r17, AppCompatTextView r18, AppCompatTextView r19, AppCompatTextView r20, AppCompatTextView r21, AppCompatTextView r22) {
        this.rootView = r3;
        this.arrowBackImageHotArea = r4;
        this.dividerNavigation = r5;
        this.globalMemorySwtichDescText = r6;
        this.headerLinearLayout = r7;
        this.memoryTitle = r8;
        this.subSwitchLinearLayout = r9;
        this.switchContainerGlobalMemory = r10;
        this.switchGlobalMemory = r11;
        this.switchInstantEntityIndex = r12;
        this.switchOnScreenUseClientOcr = r13;
        this.switchPersonalContextKgUse = r14;
        this.switchRecommend = r15;
        this.switchRecommendTts = r16;
        this.textGlobalMemory = r17;
        this.textInstantEntityIndex = r18;
        this.textOnScreenUseClientOcr = r19;
        this.textPersonalContextKgAppUse = r20;
        this.textRecommend = r21;
        this.textRecommendTts = r22;
    }

    public static ActivityMemorySettingPageBinding bind(View r27) {
        int r1 = ZeusTransformUtils.mapRes(R.id.arrow_back_image_hot_area, OaidModel.KEY_ID, "arrow_back_image_hot_area");
        FrameLayout r8 = (FrameLayout) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.divider_navigation, OaidModel.KEY_ID, "divider_navigation");
        ODivider r9 = (ODivider) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), ODivider.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.global_memory_swtich_desc_text, OaidModel.KEY_ID, "global_memory_swtich_desc_text");
        AppCompatTextView r10 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.header_linear_layout, OaidModel.KEY_ID, "header_linear_layout");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_title, OaidModel.KEY_ID, "memory_title");
        AppCompatTextView r12 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.sub_switch_linear_layout, OaidModel.KEY_ID, "sub_switch_linear_layout");
        LinearLayout r13 = (LinearLayout) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.switch_container_global_memory, OaidModel.KEY_ID, "switch_container_global_memory");
        FrameLayout r14 = (FrameLayout) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.switch_global_memory, OaidModel.KEY_ID, "switch_global_memory");
        OSwitch r15 = (OSwitch) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), OSwitch.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.switch_instant_entity_index, OaidModel.KEY_ID, "switch_instant_entity_index");
        OSwitch r16 = (OSwitch) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), OSwitch.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.switch_on_screen_use_client_ocr, OaidModel.KEY_ID, "switch_on_screen_use_client_ocr");
        OSwitch r17 = (OSwitch) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), OSwitch.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.switch_personal_context_kg_use, OaidModel.KEY_ID, "switch_personal_context_kg_use");
        OSwitch r18 = (OSwitch) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), OSwitch.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.switch_recommend, OaidModel.KEY_ID, "switch_recommend");
        OSwitch r19 = (OSwitch) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), OSwitch.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.switch_recommend_tts, OaidModel.KEY_ID, "switch_recommend_tts");
        OSwitch r20 = (OSwitch) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), OSwitch.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.text_global_memory, OaidModel.KEY_ID, "text_global_memory");
        AppCompatTextView r21 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.text_instant_entity_index, OaidModel.KEY_ID, "text_instant_entity_index");
        AppCompatTextView r22 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.text_on_screen_use_client_ocr, OaidModel.KEY_ID, "text_on_screen_use_client_ocr");
        AppCompatTextView r23 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.text_personal_context_kg_app_use, OaidModel.KEY_ID, "text_personal_context_kg_app_use");
        AppCompatTextView r24 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.text_recommend, OaidModel.KEY_ID, "text_recommend");
        AppCompatTextView r25 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.text_recommend_tts, OaidModel.KEY_ID, "text_recommend_tts");
        AppCompatTextView r26 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r27.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L43;
        return new ActivityMemorySettingPageBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r27, ConstraintLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r27, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityMemorySettingPageBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityMemorySettingPageBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_memory_setting_page, "layout", "activity_memory_setting_page"), r4, false, "com.obric.memorydata.plugin");
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
