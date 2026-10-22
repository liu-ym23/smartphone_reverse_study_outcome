package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityRecommendationDetailBinding implements ViewBinding {
    public final OButton btnValueOther;
    public final LinearLayout cardEvidence;
    public final LinearLayout cardMeta;
    public final LinearLayout cardReason;
    public final LinearLayout cardValueRating;
    public final FrameLayout flDetailBadge;
    public final FrameLayout flDetailSlot;
    public final FrameLayout flScrollContainer;
    public final HorizontalScrollView hsvSources;
    public final ImageView ivDetailBadgeIcon;
    public final LinearLayout llDetailActionItems;
    public final LinearLayout llDetailArtifacts;
    public final LinearLayout llScrollableContent;
    public final LinearLayout llSources;
    public final LinearLayout llSourcesGroup;
    private final FrameLayout rootView;
    public final ONestedScrollView scrollContent;
    public final OFloatingTitleBar titleBar;
    public final AppCompatTextView tvDetailBadgeEmoji;
    public final AppCompatTextView tvEvidenceContent;
    public final TextView tvEvidenceTitle;
    public final AppCompatTextView tvMain;
    public final AppCompatTextView tvReasonContent;
    public final TextView tvReasonTitle;
    public final TextView tvScoreLabel;
    public final TextView tvScoreValue;
    public final TextView tvSourcesTitle;
    public final TextView tvStatusLabel;
    public final TextView tvStatusValue;
    public final TextView tvValueRatingStatus;
    public final TextView tvValueRatingTitle;
    public final OTabLayout valueQuickTabs;

    private ActivityRecommendationDetailBinding(FrameLayout r3, OButton r4, LinearLayout r5, LinearLayout r6, LinearLayout r7, LinearLayout r8, FrameLayout r9, FrameLayout r10, FrameLayout r11, HorizontalScrollView r12, ImageView r13, LinearLayout r14, LinearLayout r15, LinearLayout r16, LinearLayout r17, LinearLayout r18, ONestedScrollView r19, OFloatingTitleBar r20, AppCompatTextView r21, AppCompatTextView r22, TextView r23, AppCompatTextView r24, AppCompatTextView r25, TextView r26, TextView r27, TextView r28, TextView r29, TextView r30, TextView r31, TextView r32, TextView r33, OTabLayout r34) {
        this.rootView = r3;
        this.btnValueOther = r4;
        this.cardEvidence = r5;
        this.cardMeta = r6;
        this.cardReason = r7;
        this.cardValueRating = r8;
        this.flDetailBadge = r9;
        this.flDetailSlot = r10;
        this.flScrollContainer = r11;
        this.hsvSources = r12;
        this.ivDetailBadgeIcon = r13;
        this.llDetailActionItems = r14;
        this.llDetailArtifacts = r15;
        this.llScrollableContent = r16;
        this.llSources = r17;
        this.llSourcesGroup = r18;
        this.scrollContent = r19;
        this.titleBar = r20;
        this.tvDetailBadgeEmoji = r21;
        this.tvEvidenceContent = r22;
        this.tvEvidenceTitle = r23;
        this.tvMain = r24;
        this.tvReasonContent = r25;
        this.tvReasonTitle = r26;
        this.tvScoreLabel = r27;
        this.tvScoreValue = r28;
        this.tvSourcesTitle = r29;
        this.tvStatusLabel = r30;
        this.tvStatusValue = r31;
        this.tvValueRatingStatus = r32;
        this.tvValueRatingTitle = r33;
        this.valueQuickTabs = r34;
    }

    public static ActivityRecommendationDetailBinding bind(View r39) {
        int r1 = ZeusTransformUtils.mapRes(R.id.btn_value_other, OaidModel.KEY_ID, "btn_value_other");
        OButton r8 = (OButton) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), OButton.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.card_evidence, OaidModel.KEY_ID, "card_evidence");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.card_meta, OaidModel.KEY_ID, "card_meta");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.card_reason, OaidModel.KEY_ID, "card_reason");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.card_value_rating, OaidModel.KEY_ID, "card_value_rating");
        LinearLayout r12 = (LinearLayout) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.fl_detail_badge, OaidModel.KEY_ID, "fl_detail_badge");
        FrameLayout r13 = (FrameLayout) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.fl_detail_slot, OaidModel.KEY_ID, "fl_detail_slot");
        FrameLayout r14 = (FrameLayout) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.fl_scroll_container, OaidModel.KEY_ID, "fl_scroll_container");
        FrameLayout r15 = (FrameLayout) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.hsv_sources, OaidModel.KEY_ID, "hsv_sources");
        HorizontalScrollView r16 = (HorizontalScrollView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), HorizontalScrollView.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_detail_badge_icon, OaidModel.KEY_ID, "iv_detail_badge_icon");
        ImageView r17 = (ImageView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_detail_action_items, OaidModel.KEY_ID, "ll_detail_action_items");
        LinearLayout r18 = (LinearLayout) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_detail_artifacts, OaidModel.KEY_ID, "ll_detail_artifacts");
        LinearLayout r19 = (LinearLayout) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_scrollable_content, OaidModel.KEY_ID, "ll_scrollable_content");
        LinearLayout r20 = (LinearLayout) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_sources, OaidModel.KEY_ID, "ll_sources");
        LinearLayout r21 = (LinearLayout) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_sources_group, OaidModel.KEY_ID, "ll_sources_group");
        LinearLayout r22 = (LinearLayout) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.scroll_content, OaidModel.KEY_ID, "scroll_content");
        ONestedScrollView r23 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.title_bar, OaidModel.KEY_ID, "title_bar");
        OFloatingTitleBar r24 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_detail_badge_emoji, OaidModel.KEY_ID, "tv_detail_badge_emoji");
        AppCompatTextView r25 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_evidence_content, OaidModel.KEY_ID, "tv_evidence_content");
        AppCompatTextView r26 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_evidence_title, OaidModel.KEY_ID, "tv_evidence_title");
        TextView r27 = (TextView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r27 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_main, OaidModel.KEY_ID, "tv_main");
        AppCompatTextView r28 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r28 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_reason_content, OaidModel.KEY_ID, "tv_reason_content");
        AppCompatTextView r29 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r29 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_reason_title, OaidModel.KEY_ID, "tv_reason_title");
        TextView r30 = (TextView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r30 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_score_label, OaidModel.KEY_ID, "tv_score_label");
        TextView r31 = (TextView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r31 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_score_value, OaidModel.KEY_ID, "tv_score_value");
        TextView r32 = (TextView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r32 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_sources_title, OaidModel.KEY_ID, "tv_sources_title");
        TextView r33 = (TextView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r33 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_status_label, OaidModel.KEY_ID, "tv_status_label");
        TextView r34 = (TextView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r34 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_status_value, OaidModel.KEY_ID, "tv_status_value");
        TextView r35 = (TextView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r35 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_value_rating_status, OaidModel.KEY_ID, "tv_value_rating_status");
        TextView r36 = (TextView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r36 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_value_rating_title, OaidModel.KEY_ID, "tv_value_rating_title");
        TextView r37 = (TextView) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r37 == null) goto L67;
        r1 = ZeusTransformUtils.mapRes(R.id.value_quick_tabs, OaidModel.KEY_ID, "value_quick_tabs");
        OTabLayout r38 = (OTabLayout) ZeusTransformUtils.preCheckCast(r39.findViewById(r1), OTabLayout.class, "com.obric.memorydata.plugin");
        if (r38 == null) goto L67;
        return new ActivityRecommendationDetailBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r39, FrameLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38);
    L67:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r39, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityRecommendationDetailBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityRecommendationDetailBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_recommendation_detail, "layout", "activity_recommendation_detail"), r4, false, "com.obric.memorydata.plugin");
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
