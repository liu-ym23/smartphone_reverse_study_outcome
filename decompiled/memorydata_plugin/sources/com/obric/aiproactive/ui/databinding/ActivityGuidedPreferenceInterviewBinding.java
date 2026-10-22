package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.ui.util.ProactiveTopBarIconButton;
import com.obric.memorydata.plugin.R;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityGuidedPreferenceInterviewBinding implements ViewBinding {
    public final ProactiveTopBarIconButton btnGuidedBack;
    public final ProactiveTopBarIconButton btnGuidedClose;
    public final OButton btnGuidedPrimary;
    public final ImageView imgGuidedBg;
    public final FrameLayout layoutGuidedOptionGroup;
    public final LinearLayout layoutGuidedScrollContent;
    public final ConstraintLayout layoutGuidedTopbar;
    private final ConstraintLayout rootView;
    public final RecyclerView rvGuidedOptions;
    public final ONestedScrollView scrollGuidedContent;
    public final TextView tvGuidedProgress;
    public final TextView tvGuidedSubtitle;
    public final TextView tvGuidedTitle;
    public final View viewGuidedBgScrim;
    public final OBlurMaskView viewGuidedKeyboardBlur;

    private ActivityGuidedPreferenceInterviewBinding(ConstraintLayout r1, ProactiveTopBarIconButton r2, ProactiveTopBarIconButton r3, OButton r4, ImageView r5, FrameLayout r6, LinearLayout r7, ConstraintLayout r8, RecyclerView r9, ONestedScrollView r10, TextView r11, TextView r12, TextView r13, View r14, OBlurMaskView r15) {
        this.rootView = r1;
        this.btnGuidedBack = r2;
        this.btnGuidedClose = r3;
        this.btnGuidedPrimary = r4;
        this.imgGuidedBg = r5;
        this.layoutGuidedOptionGroup = r6;
        this.layoutGuidedScrollContent = r7;
        this.layoutGuidedTopbar = r8;
        this.rvGuidedOptions = r9;
        this.scrollGuidedContent = r10;
        this.tvGuidedProgress = r11;
        this.tvGuidedSubtitle = r12;
        this.tvGuidedTitle = r13;
        this.viewGuidedBgScrim = r14;
        this.viewGuidedKeyboardBlur = r15;
    }

    public static ActivityGuidedPreferenceInterviewBinding bind(View r22) {
        int r1 = ZeusTransformUtils.mapRes(R.id.btn_guided_back, OaidModel.KEY_ID, "btn_guided_back");
        ProactiveTopBarIconButton r8 = (ProactiveTopBarIconButton) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), ProactiveTopBarIconButton.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_guided_close, OaidModel.KEY_ID, "btn_guided_close");
        ProactiveTopBarIconButton r9 = (ProactiveTopBarIconButton) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), ProactiveTopBarIconButton.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_guided_primary, OaidModel.KEY_ID, "btn_guided_primary");
        OButton r10 = (OButton) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OButton.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.img_guided_bg, OaidModel.KEY_ID, "img_guided_bg");
        ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.layout_guided_option_group, OaidModel.KEY_ID, "layout_guided_option_group");
        FrameLayout r12 = (FrameLayout) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.layout_guided_scroll_content, OaidModel.KEY_ID, "layout_guided_scroll_content");
        LinearLayout r13 = (LinearLayout) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.layout_guided_topbar, OaidModel.KEY_ID, "layout_guided_topbar");
        ConstraintLayout r14 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.rv_guided_options, OaidModel.KEY_ID, "rv_guided_options");
        RecyclerView r15 = (RecyclerView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.scroll_guided_content, OaidModel.KEY_ID, "scroll_guided_content");
        ONestedScrollView r16 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_guided_progress, OaidModel.KEY_ID, "tv_guided_progress");
        TextView r17 = (TextView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_guided_subtitle, OaidModel.KEY_ID, "tv_guided_subtitle");
        TextView r18 = (TextView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_guided_title, OaidModel.KEY_ID, "tv_guided_title");
        TextView r19 = (TextView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.view_guided_bg_scrim, OaidModel.KEY_ID, "view_guided_bg_scrim");
        View r20 = r22.findViewById(r1);
        if (r20 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.view_guided_keyboard_blur, OaidModel.KEY_ID, "view_guided_keyboard_blur");
        OBlurMaskView r21 = (OBlurMaskView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OBlurMaskView.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L33;
        return new ActivityGuidedPreferenceInterviewBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r22, ConstraintLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r22, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityGuidedPreferenceInterviewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityGuidedPreferenceInterviewBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_guided_preference_interview, "layout", "activity_guided_preference_interview"), r4, false, "com.obric.memorydata.plugin");
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
