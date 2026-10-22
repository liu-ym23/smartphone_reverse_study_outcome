package com.larus.business.markdown.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.ui.MaxHeightLinearLayout;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class MarkdownCodeViewLayoutBinding implements ViewBinding {
    public final FrameLayout markdownCodeContainer;
    public final ImageView markdownCodeCopyButton;
    public final TextView markdownCodeFoldDesc;
    public final ImageView markdownCodeFullscreenButton;
    public final LinearLayout markdownCodeHeader;
    public final TextView markdownCodeLanguage;
    public final ImageView markdownCodePreviewButton;
    private final MaxHeightLinearLayout rootView;

    private MarkdownCodeViewLayoutBinding(MaxHeightLinearLayout r1, FrameLayout r2, ImageView r3, TextView r4, ImageView r5, LinearLayout r6, TextView r7, ImageView r8) {
        this.rootView = r1;
        this.markdownCodeContainer = r2;
        this.markdownCodeCopyButton = r3;
        this.markdownCodeFoldDesc = r4;
        this.markdownCodeFullscreenButton = r5;
        this.markdownCodeHeader = r6;
        this.markdownCodeLanguage = r7;
        this.markdownCodePreviewButton = r8;
    }

    public static MarkdownCodeViewLayoutBinding bind(View r14) {
        int r0 = ZeusTransformUtils.mapRes(R.id.markdownCodeContainer, OaidModel.KEY_ID, "markdownCodeContainer");
        FrameLayout r7 = (FrameLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.markdownCodeCopyButton, OaidModel.KEY_ID, "markdownCodeCopyButton");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.markdownCodeFoldDesc, OaidModel.KEY_ID, "markdownCodeFoldDesc");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.markdownCodeFullscreenButton, OaidModel.KEY_ID, "markdownCodeFullscreenButton");
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.markdownCodeHeader, OaidModel.KEY_ID, "markdownCodeHeader");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.markdownCodeLanguage, OaidModel.KEY_ID, "markdownCodeLanguage");
        TextView r12 = (TextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.markdownCodePreviewButton, OaidModel.KEY_ID, "markdownCodePreviewButton");
        ImageView r13 = (ImageView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L19;
        return new MarkdownCodeViewLayoutBinding((MaxHeightLinearLayout) ZeusTransformUtils.preCheckCast(r14, MaxHeightLinearLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12, r13);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static MarkdownCodeViewLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MarkdownCodeViewLayoutBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.markdown_code_view_layout, "layout", "markdown_code_view_layout"), r4, false, "com.obric.memorydata.plugin");
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
    public MaxHeightLinearLayout getRoot() {
        return this.rootView;
    }
}
