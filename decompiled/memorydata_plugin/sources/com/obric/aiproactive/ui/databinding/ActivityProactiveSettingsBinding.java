package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityProactiveSettingsBinding implements ViewBinding {
    public final OCardListItem allSkills;
    public final OCardListItem allTools;
    public final ONestedScrollView contentScroll;
    public final OCardListItem contextAwareness;
    public final OCardListItem desktopShortcut;
    public final LinearLayout featureHeader;
    public final OUIFrameLayout featureIconShadow;
    public final OCardListItem globalMemory;
    public final OCardListItem initiativeLevel;
    public final OCardListItem localDataSearch;
    public final OCardListItem lockedScreenUseAssistant;
    public final OCardListItem phoneOperation;
    public final OCardListItem proactiveFeatureSwitch;
    private final FrameLayout rootView;
    public final OFloatingTitleBar titleBar;

    private ActivityProactiveSettingsBinding(FrameLayout r1, OCardListItem r2, OCardListItem r3, ONestedScrollView r4, OCardListItem r5, OCardListItem r6, LinearLayout r7, OUIFrameLayout r8, OCardListItem r9, OCardListItem r10, OCardListItem r11, OCardListItem r12, OCardListItem r13, OCardListItem r14, OFloatingTitleBar r15) {
        this.rootView = r1;
        this.allSkills = r2;
        this.allTools = r3;
        this.contentScroll = r4;
        this.contextAwareness = r5;
        this.desktopShortcut = r6;
        this.featureHeader = r7;
        this.featureIconShadow = r8;
        this.globalMemory = r9;
        this.initiativeLevel = r10;
        this.localDataSearch = r11;
        this.lockedScreenUseAssistant = r12;
        this.phoneOperation = r13;
        this.proactiveFeatureSwitch = r14;
        this.titleBar = r15;
    }

    public static ActivityProactiveSettingsBinding bind(View r22) {
        int r1 = ZeusTransformUtils.mapRes(R.id.all_skills, OaidModel.KEY_ID, "all_skills");
        OCardListItem r8 = (OCardListItem) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.all_tools, OaidModel.KEY_ID, "all_tools");
        OCardListItem r9 = (OCardListItem) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.content_scroll, OaidModel.KEY_ID, "content_scroll");
        ONestedScrollView r10 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.context_awareness, OaidModel.KEY_ID, "context_awareness");
        OCardListItem r11 = (OCardListItem) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.desktop_shortcut, OaidModel.KEY_ID, "desktop_shortcut");
        OCardListItem r12 = (OCardListItem) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.feature_header, OaidModel.KEY_ID, "feature_header");
        LinearLayout r13 = (LinearLayout) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.feature_icon_shadow, OaidModel.KEY_ID, "feature_icon_shadow");
        OUIFrameLayout r14 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OUIFrameLayout.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.global_memory, OaidModel.KEY_ID, "global_memory");
        OCardListItem r15 = (OCardListItem) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.initiative_level, OaidModel.KEY_ID, "initiative_level");
        OCardListItem r16 = (OCardListItem) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.local_data_search, OaidModel.KEY_ID, "local_data_search");
        OCardListItem r17 = (OCardListItem) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.locked_screen_use_assistant, OaidModel.KEY_ID, "locked_screen_use_assistant");
        OCardListItem r18 = (OCardListItem) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.phone_operation, OaidModel.KEY_ID, "phone_operation");
        OCardListItem r19 = (OCardListItem) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.proactive_feature_switch, OaidModel.KEY_ID, "proactive_feature_switch");
        OCardListItem r20 = (OCardListItem) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.title_bar, OaidModel.KEY_ID, "title_bar");
        OFloatingTitleBar r21 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L33;
        return new ActivityProactiveSettingsBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r22, FrameLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r22, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityProactiveSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityProactiveSettingsBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_proactive_settings, "layout", "activity_proactive_settings"), r4, false, "com.obric.memorydata.plugin");
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
