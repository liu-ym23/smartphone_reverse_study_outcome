package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.obric.aiproactive.ui.util.ProactiveTopBarIconButton;
import com.obric.aiproactive.ui.widget.GradientTextView;
import com.obric.aiproactive.ui.widget.ProactiveAvatarView;
import com.obric.aiproactive.ui.widget.RequirementComposerSurface;
import com.obric.aiproactive.ui.widget.RequirementVoiceOverlayView;
import com.obric.aiproactive.ui.widget.RequirementVoiceVisualizerView;
import com.obric.aiproactive.ui.widget.VerticalNestedScrollableHost;
import com.obric.memorydata.plugin.R;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentProactiveFeedPageBinding implements ViewBinding {
    public final AppBarLayout appBar;
    public final ConstraintLayout avatarContainer;
    public final OButton btnEmptyHistory;
    public final ProactiveTopBarIconButton btnHistoryContainer;
    public final ProactiveTopBarIconButton btnMoreContainer;
    public final AppCompatImageButton btnUserRequirementInputMode;
    public final OIconButton btnUserRequirementSend;
    public final OButton btnWakeUp;
    public final CollapsingToolbarLayout collapsingToolbar;
    public final ConstraintLayout emptyContainer;
    public final OInputLayout inputUserRequirement;
    public final ImageView ivEmpty;
    public final ImageView ivSingleEventDirection;
    public final ImageView ivUserRequirementSending;
    public final LinearLayout llSingleEvent;
    public final VerticalNestedScrollableHost nestedHost;
    public final RecyclerView recyclerView;
    public final View requirementComposerBackdrop;
    public final RequirementComposerSurface requirementComposerContainer;
    public final RequirementVoiceOverlayView requirementVoiceOverlay;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final OBlurMaskView topBlurView;
    public final View topCutOff;
    public final TextSwitcher tsSingleEvent;
    public final TextView tvAvatarSubtitle;
    public final GradientTextView tvAvatarTitle;
    public final TextView tvEmptySubtitle1;
    public final TextView tvEmptyTitle;
    public final TextView tvLoading;
    public final TextView tvUserRequirementVoiceHold;
    public final TextView tvUserRequirementVoiceTip;
    public final LinearLayout userRequirementContentColumn;
    public final ProactiveAvatarView videoContainer;
    public final Space videoPlaceholder;
    public final RequirementVoiceVisualizerView voiceRequirementVisualizer;

    private FragmentProactiveFeedPageBinding(ConstraintLayout r3, AppBarLayout r4, ConstraintLayout r5, OButton r6, ProactiveTopBarIconButton r7, ProactiveTopBarIconButton r8, AppCompatImageButton r9, OIconButton r10, OButton r11, CollapsingToolbarLayout r12, ConstraintLayout r13, OInputLayout r14, ImageView r15, ImageView r16, ImageView r17, LinearLayout r18, VerticalNestedScrollableHost r19, RecyclerView r20, View r21, RequirementComposerSurface r22, RequirementVoiceOverlayView r23, ConstraintLayout r24, OBlurMaskView r25, View r26, TextSwitcher r27, TextView r28, GradientTextView r29, TextView r30, TextView r31, TextView r32, TextView r33, TextView r34, LinearLayout r35, ProactiveAvatarView r36, Space r37, RequirementVoiceVisualizerView r38) {
        this.rootView = r3;
        this.appBar = r4;
        this.avatarContainer = r5;
        this.btnEmptyHistory = r6;
        this.btnHistoryContainer = r7;
        this.btnMoreContainer = r8;
        this.btnUserRequirementInputMode = r9;
        this.btnUserRequirementSend = r10;
        this.btnWakeUp = r11;
        this.collapsingToolbar = r12;
        this.emptyContainer = r13;
        this.inputUserRequirement = r14;
        this.ivEmpty = r15;
        this.ivSingleEventDirection = r16;
        this.ivUserRequirementSending = r17;
        this.llSingleEvent = r18;
        this.nestedHost = r19;
        this.recyclerView = r20;
        this.requirementComposerBackdrop = r21;
        this.requirementComposerContainer = r22;
        this.requirementVoiceOverlay = r23;
        this.root = r24;
        this.topBlurView = r25;
        this.topCutOff = r26;
        this.tsSingleEvent = r27;
        this.tvAvatarSubtitle = r28;
        this.tvAvatarTitle = r29;
        this.tvEmptySubtitle1 = r30;
        this.tvEmptyTitle = r31;
        this.tvLoading = r32;
        this.tvUserRequirementVoiceHold = r33;
        this.tvUserRequirementVoiceTip = r34;
        this.userRequirementContentColumn = r35;
        this.videoContainer = r36;
        this.videoPlaceholder = r37;
        this.voiceRequirementVisualizer = r38;
    }

    public static FragmentProactiveFeedPageBinding bind(View r43) {
        int r1 = ZeusTransformUtils.mapRes(R.id.app_bar, OaidModel.KEY_ID, "app_bar");
        AppBarLayout r8 = (AppBarLayout) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), AppBarLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.avatar_container, OaidModel.KEY_ID, "avatar_container");
        ConstraintLayout r9 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_empty_history, OaidModel.KEY_ID, "btn_empty_history");
        OButton r10 = (OButton) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), OButton.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_history_container, OaidModel.KEY_ID, "btn_history_container");
        ProactiveTopBarIconButton r11 = (ProactiveTopBarIconButton) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), ProactiveTopBarIconButton.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_more_container, OaidModel.KEY_ID, "btn_more_container");
        ProactiveTopBarIconButton r12 = (ProactiveTopBarIconButton) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), ProactiveTopBarIconButton.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_user_requirement_input_mode, OaidModel.KEY_ID, "btn_user_requirement_input_mode");
        AppCompatImageButton r13 = (AppCompatImageButton) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), AppCompatImageButton.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_user_requirement_send, OaidModel.KEY_ID, "btn_user_requirement_send");
        OIconButton r14 = (OIconButton) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), OIconButton.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_wake_up, OaidModel.KEY_ID, "btn_wake_up");
        OButton r15 = (OButton) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), OButton.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.collapsing_toolbar, OaidModel.KEY_ID, "collapsing_toolbar");
        CollapsingToolbarLayout r16 = (CollapsingToolbarLayout) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), CollapsingToolbarLayout.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.empty_container, OaidModel.KEY_ID, "empty_container");
        ConstraintLayout r17 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.input_user_requirement, OaidModel.KEY_ID, "input_user_requirement");
        OInputLayout r18 = (OInputLayout) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), OInputLayout.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_empty, OaidModel.KEY_ID, "iv_empty");
        ImageView r19 = (ImageView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_single_event_direction, OaidModel.KEY_ID, "iv_single_event_direction");
        ImageView r20 = (ImageView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_user_requirement_sending, OaidModel.KEY_ID, "iv_user_requirement_sending");
        ImageView r21 = (ImageView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_single_event, OaidModel.KEY_ID, "ll_single_event");
        LinearLayout r22 = (LinearLayout) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.nested_host, OaidModel.KEY_ID, "nested_host");
        VerticalNestedScrollableHost r23 = (VerticalNestedScrollableHost) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), VerticalNestedScrollableHost.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.recycler_view, OaidModel.KEY_ID, "recycler_view");
        RecyclerView r24 = (RecyclerView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.requirement_composer_backdrop, OaidModel.KEY_ID, "requirement_composer_backdrop");
        View r25 = r43.findViewById(r1);
        if (r25 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.requirement_composer_container, OaidModel.KEY_ID, "requirement_composer_container");
        RequirementComposerSurface r26 = (RequirementComposerSurface) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), RequirementComposerSurface.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.requirement_voice_overlay, OaidModel.KEY_ID, "requirement_voice_overlay");
        RequirementVoiceOverlayView r27 = (RequirementVoiceOverlayView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), RequirementVoiceOverlayView.class, "com.obric.memorydata.plugin");
        if (r27 == null) goto L73;
        ConstraintLayout r28 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r43, ConstraintLayout.class, "com.obric.memorydata.plugin");
        r1 = ZeusTransformUtils.mapRes(R.id.top_blur_view, OaidModel.KEY_ID, "top_blur_view");
        OBlurMaskView r29 = (OBlurMaskView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), OBlurMaskView.class, "com.obric.memorydata.plugin");
        if (r29 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.top_cut_off, OaidModel.KEY_ID, "top_cut_off");
        View r30 = r43.findViewById(r1);
        if (r30 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.ts_single_event, OaidModel.KEY_ID, "ts_single_event");
        TextSwitcher r31 = (TextSwitcher) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), TextSwitcher.class, "com.obric.memorydata.plugin");
        if (r31 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_avatar_subtitle, OaidModel.KEY_ID, "tv_avatar_subtitle");
        TextView r32 = (TextView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r32 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_avatar_title, OaidModel.KEY_ID, "tv_avatar_title");
        GradientTextView r33 = (GradientTextView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), GradientTextView.class, "com.obric.memorydata.plugin");
        if (r33 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_empty_subtitle_1, OaidModel.KEY_ID, "tv_empty_subtitle_1");
        TextView r34 = (TextView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r34 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_empty_title, OaidModel.KEY_ID, "tv_empty_title");
        TextView r35 = (TextView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r35 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_loading, OaidModel.KEY_ID, "tv_loading");
        TextView r36 = (TextView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r36 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_user_requirement_voice_hold, OaidModel.KEY_ID, "tv_user_requirement_voice_hold");
        TextView r37 = (TextView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r37 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_user_requirement_voice_tip, OaidModel.KEY_ID, "tv_user_requirement_voice_tip");
        TextView r38 = (TextView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r38 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.user_requirement_content_column, OaidModel.KEY_ID, "user_requirement_content_column");
        LinearLayout r39 = (LinearLayout) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r39 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.video_container, OaidModel.KEY_ID, "video_container");
        ProactiveAvatarView r40 = (ProactiveAvatarView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), ProactiveAvatarView.class, "com.obric.memorydata.plugin");
        if (r40 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.video_placeholder, OaidModel.KEY_ID, "video_placeholder");
        Space r41 = (Space) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), Space.class, "com.obric.memorydata.plugin");
        if (r41 == null) goto L73;
        r1 = ZeusTransformUtils.mapRes(R.id.voice_requirement_visualizer, OaidModel.KEY_ID, "voice_requirement_visualizer");
        RequirementVoiceVisualizerView r42 = (RequirementVoiceVisualizerView) ZeusTransformUtils.preCheckCast(r43.findViewById(r1), RequirementVoiceVisualizerView.class, "com.obric.memorydata.plugin");
        if (r42 == null) goto L73;
        return new FragmentProactiveFeedPageBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r43, ConstraintLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42);
    L73:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r43, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static FragmentProactiveFeedPageBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentProactiveFeedPageBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.fragment_proactive_feed_page, "layout", "fragment_proactive_feed_page"), r4, false, "com.obric.memorydata.plugin");
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
