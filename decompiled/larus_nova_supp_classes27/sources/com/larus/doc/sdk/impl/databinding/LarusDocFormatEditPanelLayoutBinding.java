package com.larus.doc.sdk.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDocFormatEditPanelLayoutBinding implements ViewBinding {
    public final ImageView formatAlignCenter;
    public final ImageView formatAlignLeft;
    public final ImageView formatAlignRight;
    public final ImageView formatBlockquote;
    public final ImageView formatBold;
    public final ImageView formatCheckbox;
    public final TextView formatH1;
    public final TextView formatH2;
    public final TextView formatH3;
    public final ImageView formatIndentLeft;
    public final ImageView formatIndentRight;
    public final ImageView formatItalic;
    public final ImageView formatOrderedList;
    public final TextView formatPlaintext;
    public final ImageView formatStrikethrough;
    public final ImageView formatUnderline;
    public final ImageView formatUnorderedList;
    private final LinearLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m42getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public LinearLayout m42getRoot() {
        return this.rootView;
    }

    public static LarusDocFormatEditPanelLayoutBinding bind(View r22) {
        int r1 = 2131373191;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r22, 2131373191);
        if (r5 == null) goto L39;
        r1 = 2131373192;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r22, 2131373192);
        if (r6 == null) goto L39;
        r1 = 2131373193;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r22, 2131373193);
        if (r7 == null) goto L39;
        r1 = 2131373194;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r22, 2131373194);
        if (r8 == null) goto L39;
        r1 = 2131373195;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r22, 2131373195);
        if (r9 == null) goto L39;
        r1 = 2131373196;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r22, 2131373196);
        if (r10 == null) goto L39;
        r1 = 2131373197;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r22, 2131373197);
        if (r11 == null) goto L39;
        r1 = 2131373198;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r22, 2131373198);
        if (r12 == null) goto L39;
        r1 = 2131373199;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r22, 2131373199);
        if (r13 == null) goto L39;
        r1 = 2131373200;
        ImageView r14 = (ImageView) ViewBindings.findChildViewById(r22, 2131373200);
        if (r14 == null) goto L39;
        r1 = 2131373201;
        ImageView r15 = (ImageView) ViewBindings.findChildViewById(r22, 2131373201);
        if (r15 == null) goto L39;
        r1 = 2131373202;
        ImageView r16 = (ImageView) ViewBindings.findChildViewById(r22, 2131373202);
        if (r16 == null) goto L39;
        r1 = 2131373203;
        ImageView r17 = (ImageView) ViewBindings.findChildViewById(r22, 2131373203);
        if (r17 == null) goto L39;
        r1 = 2131373204;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r22, 2131373204);
        if (r18 == null) goto L39;
        r1 = 2131373206;
        ImageView r110 = (ImageView) ViewBindings.findChildViewById(r22, 2131373206);
        if (r110 == null) goto L39;
        r1 = 2131373208;
        ImageView r20 = (ImageView) ViewBindings.findChildViewById(r22, 2131373208);
        if (r20 == null) goto L39;
        r1 = 2131373209;
        ImageView r21 = (ImageView) ViewBindings.findChildViewById(r22, 2131373209);
        if (r21 == null) goto L39;
        return new LarusDocFormatEditPanelLayoutBinding((LinearLayout) r22, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21);
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r22.getResources().getResourceName(r1)));
    }

    public static LarusDocFormatEditPanelLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LarusDocFormatEditPanelLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131562121, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private LarusDocFormatEditPanelLayoutBinding(LinearLayout r3, ImageView r4, ImageView r5, ImageView r6, ImageView r7, ImageView r8, ImageView r9, TextView r10, TextView r11, TextView r12, ImageView r13, ImageView r14, ImageView r15, ImageView r16, TextView r17, ImageView r18, ImageView r110, ImageView r20) {
        this.rootView = r3;
        this.formatAlignCenter = r4;
        this.formatAlignLeft = r5;
        this.formatAlignRight = r6;
        this.formatBlockquote = r7;
        this.formatBold = r8;
        this.formatCheckbox = r9;
        this.formatH1 = r10;
        this.formatH2 = r11;
        this.formatH3 = r12;
        this.formatIndentLeft = r13;
        this.formatIndentRight = r14;
        this.formatItalic = r15;
        this.formatOrderedList = r16;
        this.formatPlaintext = r17;
        this.formatStrikethrough = r18;
        this.formatUnderline = r110;
        this.formatUnorderedList = r20;
    }
}
