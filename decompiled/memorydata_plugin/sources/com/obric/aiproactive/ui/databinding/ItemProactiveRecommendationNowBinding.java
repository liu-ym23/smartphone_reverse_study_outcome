package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemProactiveRecommendationNowBinding implements ViewBinding {
    public final OButton btnIgnore;
    public final FrameLayout contentSlot;
    public final FrameLayout flBadge;
    public final ImageView ivBadgeIcon;
    public final LinearLayout llActionItems;
    public final LinearLayout llActions;
    public final LinearLayout llArtifacts;
    private final ConstraintLayout rootView;
    public final AppCompatTextView tvBadgeEmoji;
    public final AppCompatTextView tvContent;
    public final AppCompatTextView tvSubtitle;

    private ItemProactiveRecommendationNowBinding(ConstraintLayout r1, OButton r2, FrameLayout r3, FrameLayout r4, ImageView r5, LinearLayout r6, LinearLayout r7, LinearLayout r8, AppCompatTextView r9, AppCompatTextView r10, AppCompatTextView r11) {
        this.rootView = r1;
        this.btnIgnore = r2;
        this.contentSlot = r3;
        this.flBadge = r4;
        this.ivBadgeIcon = r5;
        this.llActionItems = r6;
        this.llActions = r7;
        this.llArtifacts = r8;
        this.tvBadgeEmoji = r9;
        this.tvContent = r10;
        this.tvSubtitle = r11;
    }

    public static ItemProactiveRecommendationNowBinding bind(View r18) {
        int r1 = ZeusTransformUtils.mapRes(R.id.btn_ignore, OaidModel.KEY_ID, "btn_ignore");
        OButton r8 = (OButton) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), OButton.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.content_slot, OaidModel.KEY_ID, "content_slot");
        FrameLayout r9 = (FrameLayout) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.fl_badge, OaidModel.KEY_ID, "fl_badge");
        FrameLayout r10 = (FrameLayout) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_badge_icon, OaidModel.KEY_ID, "iv_badge_icon");
        ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_action_items, OaidModel.KEY_ID, "ll_action_items");
        LinearLayout r12 = (LinearLayout) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_actions, OaidModel.KEY_ID, "ll_actions");
        LinearLayout r13 = (LinearLayout) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_artifacts, OaidModel.KEY_ID, "ll_artifacts");
        LinearLayout r14 = (LinearLayout) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_badge_emoji, OaidModel.KEY_ID, "tv_badge_emoji");
        AppCompatTextView r15 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_content, OaidModel.KEY_ID, "tv_content");
        AppCompatTextView r16 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_subtitle, OaidModel.KEY_ID, "tv_subtitle");
        AppCompatTextView r17 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L25;
        return new ItemProactiveRecommendationNowBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r18, ConstraintLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r18, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ItemProactiveRecommendationNowBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemProactiveRecommendationNowBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_proactive_recommendation_now, "layout", "item_proactive_recommendation_now"), r4, false, "com.obric.memorydata.plugin");
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
