package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDialogConnectFailedV2Binding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final MarkdownTextView c;
    public final DoraTextView d;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDoraDialogConnectFailedV2Binding a(LayoutInflater r4, ViewGroup r5) {
        View r6 = r4.inflate(2131562163, r5, false);
        int r7 = 2131369511;
        ImageView r0 = (ImageView) ViewBindings.findChildViewById(r6, 2131369511);
        if (r0 == null) goto L13;
        r7 = 2131369512;
        MarkdownTextView r1 = ViewBindings.findChildViewById(r6, 2131369512);
        if (r1 == null) goto L13;
        r7 = 2131369513;
        DoraTextView r2 = (DoraTextView) ViewBindings.findChildViewById(r6, 2131369513);
        if (r2 == null) goto L13;
        r7 = 2131369514;
        if (((DoraTextView) ViewBindings.findChildViewById(r6, 2131369514)) == null) goto L13;
        return new LarusDoraDialogConnectFailedV2Binding((FrameLayout) r6, r0, r1, r2);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }

    public LarusDoraDialogConnectFailedV2Binding(FrameLayout r1, ImageView r2, MarkdownTextView r3, DoraTextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
