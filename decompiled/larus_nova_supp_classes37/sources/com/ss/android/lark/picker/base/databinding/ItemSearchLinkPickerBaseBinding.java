package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ItemSearchLinkPickerBaseBinding implements ViewBinding {
    public final AppCompatImageView messageUrlOpenChatIv;
    public final RelativeLayout messageUrlOpenChatRl;
    public final TextView messageUrlSenderInfoTv;
    private final ConstraintLayout rootView;
    public final LKUIRoundedImageView urlAvatarIv;
    public final LinearLayout urlContentLayoutLl;
    public final TextView urlContentTv;
    public final TextView urlDetailTv;
    public final TextView urlNameTv;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3335getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public ConstraintLayout m3335getRoot() {
        return this.rootView;
    }

    public static ItemSearchLinkPickerBaseBinding bind(View r12) {
        int r0 = 2131380023;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r12, 2131380023);
        if (r4 == null) goto L21;
        r0 = 2131380024;
        RelativeLayout r5 = (RelativeLayout) ViewBindings.findChildViewById(r12, 2131380024);
        if (r5 == null) goto L21;
        r0 = 2131380025;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r12, 2131380025);
        if (r6 == null) goto L21;
        r0 = 2131391946;
        LKUIRoundedImageView r7 = ViewBindings.findChildViewById(r12, 2131391946);
        if (r7 == null) goto L21;
        r0 = 2131391950;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131391950);
        if (r8 == null) goto L21;
        r0 = 2131391951;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r12, 2131391951);
        if (r9 == null) goto L21;
        r0 = 2131391953;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r12, 2131391953);
        if (r10 == null) goto L21;
        r0 = 2131391958;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r12, 2131391958);
        if (r11 == null) goto L21;
        return new ItemSearchLinkPickerBaseBinding((ConstraintLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }

    public static ItemSearchLinkPickerBaseBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemSearchLinkPickerBaseBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131561684, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private ItemSearchLinkPickerBaseBinding(ConstraintLayout r1, AppCompatImageView r2, RelativeLayout r3, TextView r4, LKUIRoundedImageView r5, LinearLayout r6, TextView r7, TextView r8, TextView r9) {
        this.rootView = r1;
        this.messageUrlOpenChatIv = r2;
        this.messageUrlOpenChatRl = r3;
        this.messageUrlSenderInfoTv = r4;
        this.urlAvatarIv = r5;
        this.urlContentLayoutLl = r6;
        this.urlContentTv = r7;
        this.urlDetailTv = r8;
        this.urlNameTv = r9;
    }
}
