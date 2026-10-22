package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.memorydata.memory.ui.list.FlowLayout;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMemoryDetailContentBinding implements ViewBinding {
    public final LinearLayout bottomSourceContainer;
    public final LinearLayout memoryDetailCard;
    public final AppCompatImageView memorySourceIcon;
    public final TextView memorySourceTv;
    public final TextView memoryTimeTv;
    private final LinearLayout rootView;
    public final MarkdownTextView summaryText;
    public final TextView summaryTextTip;
    public final FlowLayout tagsLinearLayout;
    public final TextView titleText;

    private ItemMemoryDetailContentBinding(LinearLayout r1, LinearLayout r2, LinearLayout r3, AppCompatImageView r4, TextView r5, TextView r6, MarkdownTextView r7, TextView r8, FlowLayout r9, TextView r10) {
        this.rootView = r1;
        this.bottomSourceContainer = r2;
        this.memoryDetailCard = r3;
        this.memorySourceIcon = r4;
        this.memorySourceTv = r5;
        this.memoryTimeTv = r6;
        this.summaryText = r7;
        this.summaryTextTip = r8;
        this.tagsLinearLayout = r9;
        this.titleText = r10;
    }

    public static ItemMemoryDetailContentBinding bind(View r17) {
        int r1 = ZeusTransformUtils.mapRes(R.id.bottom_source_container, OaidModel.KEY_ID, "bottom_source_container");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L21;
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17, LinearLayout.class, "com.obric.memorydata.plugin");
        r1 = ZeusTransformUtils.mapRes(R.id.memory_source_icon, OaidModel.KEY_ID, "memory_source_icon");
        AppCompatImageView r10 = (AppCompatImageView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), AppCompatImageView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_source_tv, OaidModel.KEY_ID, "memory_source_tv");
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_time_tv, OaidModel.KEY_ID, "memory_time_tv");
        TextView r12 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.summary_text, OaidModel.KEY_ID, "summary_text");
        MarkdownTextView r13 = (MarkdownTextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), MarkdownTextView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.summary_text_tip, OaidModel.KEY_ID, "summary_text_tip");
        TextView r14 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.tags_linear_layout, OaidModel.KEY_ID, "tags_linear_layout");
        FlowLayout r15 = (FlowLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), FlowLayout.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.title_text, OaidModel.KEY_ID, "title_text");
        TextView r16 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L21;
        return new ItemMemoryDetailContentBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r17, LinearLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r17, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ItemMemoryDetailContentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemoryDetailContentBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_detail_content, "layout", "item_memory_detail_content"), r4, false, "com.obric.memorydata.plugin");
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
