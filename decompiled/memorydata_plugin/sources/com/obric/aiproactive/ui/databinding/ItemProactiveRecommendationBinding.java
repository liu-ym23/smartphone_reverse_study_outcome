package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemProactiveRecommendationBinding implements ViewBinding {
    public final View basicLine;
    public final ImageView imgStatus;
    public final LinearLayout llActions;
    public final LinearLayout llArtifacts;
    public final FrameLayout llStatusChip;
    private final ConstraintLayout rootView;
    public final MarkdownTextView tvContent;
    public final TextView tvMeta;
    public final TextView tvNotRecommend;
    public final AppCompatTextView tvStatusEmoji;

    private ItemProactiveRecommendationBinding(ConstraintLayout r1, View r2, ImageView r3, LinearLayout r4, LinearLayout r5, FrameLayout r6, MarkdownTextView r7, TextView r8, TextView r9, AppCompatTextView r10) {
        this.rootView = r1;
        this.basicLine = r2;
        this.imgStatus = r3;
        this.llActions = r4;
        this.llArtifacts = r5;
        this.llStatusChip = r6;
        this.tvContent = r7;
        this.tvMeta = r8;
        this.tvNotRecommend = r9;
        this.tvStatusEmoji = r10;
    }

    public static ItemProactiveRecommendationBinding bind(View r13) {
        int r0 = ZeusTransformUtils.mapRes(R.id.basic_line, OaidModel.KEY_ID, "basic_line");
        View r4 = r13.findViewById(r0);
        if (r4 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.img_status, OaidModel.KEY_ID, "img_status");
        ImageView r5 = (ImageView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.ll_actions, OaidModel.KEY_ID, "ll_actions");
        LinearLayout r6 = (LinearLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.ll_artifacts, OaidModel.KEY_ID, "ll_artifacts");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.ll_status_chip, OaidModel.KEY_ID, "ll_status_chip");
        FrameLayout r8 = (FrameLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_content, OaidModel.KEY_ID, "tv_content");
        MarkdownTextView r9 = (MarkdownTextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), MarkdownTextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_meta, OaidModel.KEY_ID, "tv_meta");
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_not_recommend, OaidModel.KEY_ID, "tv_not_recommend");
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_status_emoji, OaidModel.KEY_ID, "tv_status_emoji");
        AppCompatTextView r12 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L23;
        return new ItemProactiveRecommendationBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r13, ConstraintLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemProactiveRecommendationBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemProactiveRecommendationBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_proactive_recommendation, "layout", "item_proactive_recommendation"), r4, false, "com.obric.memorydata.plugin");
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
