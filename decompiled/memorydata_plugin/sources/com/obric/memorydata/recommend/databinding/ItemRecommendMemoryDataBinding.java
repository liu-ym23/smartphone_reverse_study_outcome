package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemRecommendMemoryDataBinding implements ViewBinding {
    public final ConstraintLayout clExpandContainer;
    public final TextView createTimeText;
    public final ImageView ivCollapse;
    public final ImageView ivExpand;
    public final LinearLayout llBottom;
    public final LinearLayout llExpandContainer;
    public final MarkdownTextView markdownContent;
    public final LinearLayout memoryGeneralization;
    public final TextView observationText;
    private final LinearLayout rootView;
    public final TextView tvMarkdownBulletCount;
    public final TextView updateTimeText;

    private ItemRecommendMemoryDataBinding(LinearLayout r1, ConstraintLayout r2, TextView r3, ImageView r4, ImageView r5, LinearLayout r6, LinearLayout r7, MarkdownTextView r8, LinearLayout r9, TextView r10, TextView r11, TextView r12) {
        this.rootView = r1;
        this.clExpandContainer = r2;
        this.createTimeText = r3;
        this.ivCollapse = r4;
        this.ivExpand = r5;
        this.llBottom = r6;
        this.llExpandContainer = r7;
        this.markdownContent = r8;
        this.memoryGeneralization = r9;
        this.observationText = r10;
        this.tvMarkdownBulletCount = r11;
        this.updateTimeText = r12;
    }

    public static ItemRecommendMemoryDataBinding bind(View r19) {
        int r1 = ZeusTransformUtils.mapRes(R.id.cl_expand_container, OaidModel.KEY_ID, "cl_expand_container");
        ConstraintLayout r8 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.create_time_text, OaidModel.KEY_ID, "create_time_text");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_collapse, OaidModel.KEY_ID, "iv_collapse");
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_expand, OaidModel.KEY_ID, "iv_expand");
        ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_bottom, OaidModel.KEY_ID, "ll_bottom");
        LinearLayout r12 = (LinearLayout) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_expand_container, OaidModel.KEY_ID, "ll_expand_container");
        LinearLayout r13 = (LinearLayout) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.markdown_content, OaidModel.KEY_ID, "markdown_content");
        MarkdownTextView r14 = (MarkdownTextView) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), MarkdownTextView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L25;
        LinearLayout r15 = (LinearLayout) ZeusTransformUtils.preCheckCast(r19, LinearLayout.class, "com.obric.memorydata.plugin");
        r1 = ZeusTransformUtils.mapRes(R.id.observation_text, OaidModel.KEY_ID, "observation_text");
        TextView r16 = (TextView) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_markdown_bullet_count, OaidModel.KEY_ID, "tv_markdown_bullet_count");
        TextView r17 = (TextView) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.update_time_text, OaidModel.KEY_ID, "update_time_text");
        TextView r18 = (TextView) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L25;
        return new ItemRecommendMemoryDataBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r19, LinearLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r19, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ItemRecommendMemoryDataBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemRecommendMemoryDataBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_recommend_memory_data, "layout", "item_recommend_memory_data"), r4, false, "com.obric.memorydata.plugin");
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
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
