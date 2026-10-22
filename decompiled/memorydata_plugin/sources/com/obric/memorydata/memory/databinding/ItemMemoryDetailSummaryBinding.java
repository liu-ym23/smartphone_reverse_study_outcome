package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.memorydata.memory.ui.list.FlowLayout;
import com.obric.memorydata.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMemoryDetailSummaryBinding implements ViewBinding {
    public final LinearLayout failedContainer;
    private final ConstraintLayout rootView;
    public final MarkdownTextView summaryText;
    public final OTextView summaryTextTip;
    public final FlowLayout tagsLinearLayout;
    public final TextView tvFailed;

    private ItemMemoryDetailSummaryBinding(ConstraintLayout r1, LinearLayout r2, MarkdownTextView r3, OTextView r4, FlowLayout r5, TextView r6) {
        this.rootView = r1;
        this.failedContainer = r2;
        this.summaryText = r3;
        this.summaryTextTip = r4;
        this.tagsLinearLayout = r5;
        this.tvFailed = r6;
    }

    public static ItemMemoryDetailSummaryBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.failed_container, OaidModel.KEY_ID, "failed_container");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.summary_text, OaidModel.KEY_ID, "summary_text");
        MarkdownTextView r8 = (MarkdownTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), MarkdownTextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.summary_text_tip, OaidModel.KEY_ID, "summary_text_tip");
        OTextView r9 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.tags_linear_layout, OaidModel.KEY_ID, "tags_linear_layout");
        FlowLayout r10 = (FlowLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), FlowLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_failed, OaidModel.KEY_ID, "tv_failed");
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L15;
        return new ItemMemoryDetailSummaryBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r12, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemMemoryDetailSummaryBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemoryDetailSummaryBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_detail_summary, "layout", "item_memory_detail_summary"), r4, false, "com.obric.memorydata.plugin");
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
