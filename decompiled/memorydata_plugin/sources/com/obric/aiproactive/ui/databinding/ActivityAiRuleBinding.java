package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.ui.util.ProactiveTopBarIconButton;
import com.obric.memorydata.plugin.R;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityAiRuleBinding implements ViewBinding {
    public final ConstraintLayout aiRuleRoot;
    public final View bottomNavInsetSpacer;
    public final ProactiveTopBarIconButton btnAddContainer;
    public final ProactiveTopBarIconButton btnBackContainer;
    public final LinearLayout layoutEmpty;
    private final ConstraintLayout rootView;
    public final FrameLayout ruleContentContainer;
    public final RecyclerView rvRules;
    public final OBlurMaskView topBlurView;
    public final View topCutOff;
    public final TextView tvEmptySubtitle;
    public final TextView tvEmptyTitle;
    public final TextView tvTitle;

    private ActivityAiRuleBinding(ConstraintLayout r1, ConstraintLayout r2, View r3, ProactiveTopBarIconButton r4, ProactiveTopBarIconButton r5, LinearLayout r6, FrameLayout r7, RecyclerView r8, OBlurMaskView r9, View r10, TextView r11, TextView r12, TextView r13) {
        this.rootView = r1;
        this.aiRuleRoot = r2;
        this.bottomNavInsetSpacer = r3;
        this.btnAddContainer = r4;
        this.btnBackContainer = r5;
        this.layoutEmpty = r6;
        this.ruleContentContainer = r7;
        this.rvRules = r8;
        this.topBlurView = r9;
        this.topCutOff = r10;
        this.tvEmptySubtitle = r11;
        this.tvEmptyTitle = r12;
        this.tvTitle = r13;
    }

    public static ActivityAiRuleBinding bind(View r17) {
        ConstraintLayout r5 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r17, ConstraintLayout.class, "com.obric.memorydata.plugin");
        int r1 = ZeusTransformUtils.mapRes(R.id.bottom_nav_inset_spacer, OaidModel.KEY_ID, "bottom_nav_inset_spacer");
        View r6 = r17.findViewById(r1);
        if (r6 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_add_container, OaidModel.KEY_ID, "btn_add_container");
        ProactiveTopBarIconButton r7 = (ProactiveTopBarIconButton) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), ProactiveTopBarIconButton.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_back_container, OaidModel.KEY_ID, "btn_back_container");
        ProactiveTopBarIconButton r8 = (ProactiveTopBarIconButton) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), ProactiveTopBarIconButton.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.layout_empty, OaidModel.KEY_ID, "layout_empty");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.rule_content_container, OaidModel.KEY_ID, "rule_content_container");
        FrameLayout r10 = (FrameLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.rv_rules, OaidModel.KEY_ID, "rv_rules");
        RecyclerView r11 = (RecyclerView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.top_blur_view, OaidModel.KEY_ID, "top_blur_view");
        OBlurMaskView r12 = (OBlurMaskView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OBlurMaskView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.top_cut_off, OaidModel.KEY_ID, "top_cut_off");
        View r13 = r17.findViewById(r1);
        if (r13 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_empty_subtitle, OaidModel.KEY_ID, "tv_empty_subtitle");
        TextView r14 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_empty_title, OaidModel.KEY_ID, "tv_empty_title");
        TextView r15 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title");
        TextView r16 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L27;
        return new ActivityAiRuleBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r17, ConstraintLayout.class, "com.obric.memorydata.plugin"), r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r17, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityAiRuleBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityAiRuleBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_ai_rule, "layout", "activity_ai_rule"), r4, false, "com.obric.memorydata.plugin");
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
