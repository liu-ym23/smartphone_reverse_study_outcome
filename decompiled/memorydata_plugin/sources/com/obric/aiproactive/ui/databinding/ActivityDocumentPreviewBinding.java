package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityDocumentPreviewBinding implements ViewBinding {
    public final OButton btnOpenExternal;
    public final LinearLayout layoutHtml;
    private final FrameLayout rootView;
    public final OScrollView scrollMarkdown;
    public final OFloatingTitleBar titleBar;
    public final OTextView tvHtmlNotice;
    public final MarkdownTextView tvMarkdown;
    public final OTextView tvState;
    public final WebView webHtml;

    private ActivityDocumentPreviewBinding(FrameLayout r1, OButton r2, LinearLayout r3, OScrollView r4, OFloatingTitleBar r5, OTextView r6, MarkdownTextView r7, OTextView r8, WebView r9) {
        this.rootView = r1;
        this.btnOpenExternal = r2;
        this.layoutHtml = r3;
        this.scrollMarkdown = r4;
        this.titleBar = r5;
        this.tvHtmlNotice = r6;
        this.tvMarkdown = r7;
        this.tvState = r8;
        this.webHtml = r9;
    }

    public static ActivityDocumentPreviewBinding bind(View r15) {
        int r0 = ZeusTransformUtils.mapRes(R.id.btn_open_external, OaidModel.KEY_ID, "btn_open_external");
        OButton r7 = (OButton) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.layout_html, OaidModel.KEY_ID, "layout_html");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.scroll_markdown, OaidModel.KEY_ID, "scroll_markdown");
        OScrollView r9 = (OScrollView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OScrollView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, OaidModel.KEY_ID, "title_bar");
        OFloatingTitleBar r10 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_html_notice, OaidModel.KEY_ID, "tv_html_notice");
        OTextView r11 = (OTextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_markdown, OaidModel.KEY_ID, "tv_markdown");
        MarkdownTextView r12 = (MarkdownTextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), MarkdownTextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_state, OaidModel.KEY_ID, "tv_state");
        OTextView r13 = (OTextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.web_html, OaidModel.KEY_ID, "web_html");
        WebView r14 = (WebView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), WebView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L21;
        return new ActivityDocumentPreviewBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r15, FrameLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12, r13, r14);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r15, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityDocumentPreviewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityDocumentPreviewBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_document_preview, "layout", "activity_document_preview"), r4, false, "com.obric.memorydata.plugin");
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
