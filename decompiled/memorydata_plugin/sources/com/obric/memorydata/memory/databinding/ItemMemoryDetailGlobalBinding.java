package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.memorydata.memory.ui.detail.ChatListView;
import com.obric.memorydata.memory.ui.list.FlowLayout;
import com.obric.memorydata.plugin.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMemoryDetailGlobalBinding implements ViewBinding {
    public final FlowLayout capsuleLinearLayout;
    public final ChatListView chatListView;
    public final LinearLayout failedContainer;
    public final FrameLayout headerContainer;
    public final ImageView imageSource;
    public final View line;
    public final AppCompatImageView memorySourceIcon;
    public final TextView memorySourceTv;
    public final ConstraintLayout metaContainer;
    private final LinearLayout rootView;
    public final View shadowCover;
    public final OUIFrameLayout shadowView;
    public final OUIFrameLayout shadowWrapper;
    public final LinearLayout summaryContainer;
    public final MarkdownTextView summaryText;
    public final OTextView summaryTextTip;
    public final FlowLayout tagsLinearLayout;
    public final TextView titleText;
    public final View topOverlay;
    public final TextView tvFailed;
    public final TextView tvSourceContent;
    public final LinearLayout tvSourceContentContainer;
    public final TextView tvViewSource;
    public final View viewOverlay;

    private ItemMemoryDetailGlobalBinding(LinearLayout r3, FlowLayout r4, ChatListView r5, LinearLayout r6, FrameLayout r7, ImageView r8, View r9, AppCompatImageView r10, TextView r11, ConstraintLayout r12, View r13, OUIFrameLayout r14, OUIFrameLayout r15, LinearLayout r16, MarkdownTextView r17, OTextView r18, FlowLayout r19, TextView r20, View r21, TextView r22, TextView r23, LinearLayout r24, TextView r25, View r26) {
        this.rootView = r3;
        this.capsuleLinearLayout = r4;
        this.chatListView = r5;
        this.failedContainer = r6;
        this.headerContainer = r7;
        this.imageSource = r8;
        this.line = r9;
        this.memorySourceIcon = r10;
        this.memorySourceTv = r11;
        this.metaContainer = r12;
        this.shadowCover = r13;
        this.shadowView = r14;
        this.shadowWrapper = r15;
        this.summaryContainer = r16;
        this.summaryText = r17;
        this.summaryTextTip = r18;
        this.tagsLinearLayout = r19;
        this.titleText = r20;
        this.topOverlay = r21;
        this.tvFailed = r22;
        this.tvSourceContent = r23;
        this.tvSourceContentContainer = r24;
        this.tvViewSource = r25;
        this.viewOverlay = r26;
    }

    public static ItemMemoryDetailGlobalBinding bind(View r31) {
        int r1 = ZeusTransformUtils.mapRes(R.id.capsule_linear_layout, OaidModel.KEY_ID, "capsule_linear_layout");
        FlowLayout r8 = (FlowLayout) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), FlowLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.chat_list_view, OaidModel.KEY_ID, "chat_list_view");
        ChatListView r9 = (ChatListView) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), ChatListView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.failed_container, OaidModel.KEY_ID, "failed_container");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.header_container, OaidModel.KEY_ID, "header_container");
        FrameLayout r11 = (FrameLayout) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.image_source, OaidModel.KEY_ID, "image_source");
        ImageView r12 = (ImageView) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.line, OaidModel.KEY_ID, "line");
        View r13 = r31.findViewById(r1);
        if (r13 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_source_icon, OaidModel.KEY_ID, "memory_source_icon");
        AppCompatImageView r14 = (AppCompatImageView) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), AppCompatImageView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.memory_source_tv, OaidModel.KEY_ID, "memory_source_tv");
        TextView r15 = (TextView) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.meta_container, OaidModel.KEY_ID, "meta_container");
        ConstraintLayout r16 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.shadow_cover, OaidModel.KEY_ID, "shadow_cover");
        View r17 = r31.findViewById(r1);
        if (r17 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.shadow_view, OaidModel.KEY_ID, "shadow_view");
        OUIFrameLayout r18 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), OUIFrameLayout.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.shadow_wrapper, OaidModel.KEY_ID, "shadow_wrapper");
        OUIFrameLayout r19 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), OUIFrameLayout.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.summary_container, OaidModel.KEY_ID, "summary_container");
        LinearLayout r20 = (LinearLayout) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.summary_text, OaidModel.KEY_ID, "summary_text");
        MarkdownTextView r21 = (MarkdownTextView) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), MarkdownTextView.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.summary_text_tip, OaidModel.KEY_ID, "summary_text_tip");
        OTextView r22 = (OTextView) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), OTextView.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.tags_linear_layout, OaidModel.KEY_ID, "tags_linear_layout");
        FlowLayout r23 = (FlowLayout) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), FlowLayout.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.title_text, OaidModel.KEY_ID, "title_text");
        TextView r24 = (TextView) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.top_overlay, OaidModel.KEY_ID, "top_overlay");
        View r25 = r31.findViewById(r1);
        if (r25 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_failed, OaidModel.KEY_ID, "tv_failed");
        TextView r26 = (TextView) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_source_content, OaidModel.KEY_ID, "tv_source_content");
        TextView r27 = (TextView) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r27 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_source_content_container, OaidModel.KEY_ID, "tv_source_content_container");
        LinearLayout r28 = (LinearLayout) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r28 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_view_source, OaidModel.KEY_ID, "tv_view_source");
        TextView r29 = (TextView) ZeusTransformUtils.preCheckCast(r31.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r29 == null) goto L51;
        r1 = ZeusTransformUtils.mapRes(R.id.view_overlay, OaidModel.KEY_ID, "view_overlay");
        View r30 = r31.findViewById(r1);
        if (r30 == null) goto L51;
        return new ItemMemoryDetailGlobalBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r31, LinearLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    L51:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r31, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ItemMemoryDetailGlobalBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemoryDetailGlobalBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_detail_global, "layout", "item_memory_detail_global"), r4, false, "com.obric.memorydata.plugin");
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
