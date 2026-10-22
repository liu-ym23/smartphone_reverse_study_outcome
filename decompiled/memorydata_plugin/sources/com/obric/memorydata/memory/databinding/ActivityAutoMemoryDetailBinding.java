package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityAutoMemoryDetailBinding implements ViewBinding {
    public final LinearLayout cardContainer;
    public final LinearLayout contentContainer;
    public final MarkdownTextView contentMarkdown;
    public final View cutOff;
    public final TextView disclaimer;
    public final FrameLayout rootContainer;
    private final FrameLayout rootView;
    public final OScrollView scrollView;
    public final TextView titleText;
    public final OFloatingTitleBar viewTitle;

    private ActivityAutoMemoryDetailBinding(FrameLayout r1, LinearLayout r2, LinearLayout r3, MarkdownTextView r4, View r5, TextView r6, FrameLayout r7, OScrollView r8, TextView r9, OFloatingTitleBar r10) {
        this.rootView = r1;
        this.cardContainer = r2;
        this.contentContainer = r3;
        this.contentMarkdown = r4;
        this.cutOff = r5;
        this.disclaimer = r6;
        this.rootContainer = r7;
        this.scrollView = r8;
        this.titleText = r9;
        this.viewTitle = r10;
    }

    public static ActivityAutoMemoryDetailBinding bind(View r17) {
        int r1 = ZeusTransformUtils.mapRes(R.id.card_container, OaidModel.KEY_ID, "card_container");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.content_container, OaidModel.KEY_ID, "content_container");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.content_markdown, OaidModel.KEY_ID, "content_markdown");
        MarkdownTextView r10 = (MarkdownTextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), MarkdownTextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r11 = r17.findViewById(r1);
        if (r11 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.disclaimer, OaidModel.KEY_ID, "disclaimer");
        TextView r12 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L21;
        FrameLayout r13 = (FrameLayout) ZeusTransformUtils.preCheckCast(r17, FrameLayout.class, "com.obric.memorydata.plugin");
        r1 = ZeusTransformUtils.mapRes(R.id.scroll_view, OaidModel.KEY_ID, "scroll_view");
        OScrollView r14 = (OScrollView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OScrollView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.title_text, OaidModel.KEY_ID, "title_text");
        TextView r15 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r16 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L21;
        return new ActivityAutoMemoryDetailBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r17, FrameLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r17, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityAutoMemoryDetailBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityAutoMemoryDetailBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_auto_memory_detail, "layout", "activity_auto_memory_detail"), r4, false, "com.obric.memorydata.plugin");
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
