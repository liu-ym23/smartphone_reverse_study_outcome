package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoMemoryProActivityMemoryTaskSettingsBinding implements ViewBinding {
    public final FrameLayout bottomBar;
    public final OButton btnCreate;
    public final ODownloadProgressView createProgress;
    public final View cutOff;
    public final OCardListItem itemPaymentBehavior;
    public final OCardListItem itemPaymentInfo;
    public final OCardListItem itemSubtitleFormat;
    public final OCardListItem itemTitleFormat;
    public final OCardListItem itemUpdateRule;
    public final OCardListItem itemUseClientModel;
    public final TextView labelDisplay;
    public final OInputLayout nameInput;
    private final FrameLayout rootView;
    public final ONestedScrollView scrollContainer;
    public final TextView tvClientModelSection;
    public final OFloatingTitleBar viewTitle;

    private AutoMemoryProActivityMemoryTaskSettingsBinding(FrameLayout r3, FrameLayout r4, OButton r5, ODownloadProgressView r6, View r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, OCardListItem r11, OCardListItem r12, OCardListItem r13, TextView r14, OInputLayout r15, ONestedScrollView r16, TextView r17, OFloatingTitleBar r18) {
        this.rootView = r3;
        this.bottomBar = r4;
        this.btnCreate = r5;
        this.createProgress = r6;
        this.cutOff = r7;
        this.itemPaymentBehavior = r8;
        this.itemPaymentInfo = r9;
        this.itemSubtitleFormat = r10;
        this.itemTitleFormat = r11;
        this.itemUpdateRule = r12;
        this.itemUseClientModel = r13;
        this.labelDisplay = r14;
        this.nameInput = r15;
        this.scrollContainer = r16;
        this.tvClientModelSection = r17;
        this.viewTitle = r18;
    }

    public static AutoMemoryProActivityMemoryTaskSettingsBinding bind(View r23) {
        int r1 = ZeusTransformUtils.mapRes(R.id.bottom_bar, OaidModel.KEY_ID, "bottom_bar");
        FrameLayout r8 = (FrameLayout) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_create, OaidModel.KEY_ID, "btn_create");
        OButton r9 = (OButton) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), OButton.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.create_progress, OaidModel.KEY_ID, "create_progress");
        ODownloadProgressView r10 = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), ODownloadProgressView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r11 = r23.findViewById(r1);
        if (r11 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.item_payment_behavior, OaidModel.KEY_ID, "item_payment_behavior");
        OCardListItem r12 = (OCardListItem) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.item_payment_info, OaidModel.KEY_ID, "item_payment_info");
        OCardListItem r13 = (OCardListItem) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.item_subtitle_format, OaidModel.KEY_ID, "item_subtitle_format");
        OCardListItem r14 = (OCardListItem) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.item_title_format, OaidModel.KEY_ID, "item_title_format");
        OCardListItem r15 = (OCardListItem) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.item_update_rule, OaidModel.KEY_ID, "item_update_rule");
        OCardListItem r16 = (OCardListItem) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.item_use_client_model, OaidModel.KEY_ID, "item_use_client_model");
        OCardListItem r17 = (OCardListItem) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.label_display, OaidModel.KEY_ID, "label_display");
        TextView r18 = (TextView) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.name_input, OaidModel.KEY_ID, "name_input");
        OInputLayout r19 = (OInputLayout) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), OInputLayout.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.scroll_container, OaidModel.KEY_ID, "scroll_container");
        ONestedScrollView r20 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_client_model_section, OaidModel.KEY_ID, "tv_client_model_section");
        TextView r21 = (TextView) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L35;
        r1 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r22 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r23.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L35;
        return new AutoMemoryProActivityMemoryTaskSettingsBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r23, FrameLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r23, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static AutoMemoryProActivityMemoryTaskSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AutoMemoryProActivityMemoryTaskSettingsBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.auto_memory_pro_activity_memory_task_settings, "layout", "auto_memory_pro_activity_memory_task_settings"), r4, false, "com.obric.memorydata.plugin");
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
