package com.ss.android.lark.contact.customized.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ContactDbOfficeContactListItemBinding implements ViewBinding {
    public final LinearLayout a;
    public final LKUIRoundedImageView b;
    public final TextView c;
    public final LinearLayout d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public static ContactDbOfficeContactListItemBinding a(LayoutInflater r7, ViewGroup r8) {
        View r9 = r7.inflate(2131559922, r8, false);
        int r10 = 2131367710;
        LKUIRoundedImageView r3 = ViewBindings.findChildViewById(r9, 2131367710);
        if (r3 == null) goto L13;
        r10 = 2131367711;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r9, 2131367711);
        if (r4 == null) goto L13;
        r10 = 2131367713;
        if (((LinearLayout) ViewBindings.findChildViewById(r9, 2131367713)) == null) goto L13;
        LinearLayout r5 = (LinearLayout) r9;
        r10 = 2131367720;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, 2131367720);
        if (r6 == null) goto L13;
        return new ContactDbOfficeContactListItemBinding(r5, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r10)));
    }

    public ContactDbOfficeContactListItemBinding(LinearLayout r1, LKUIRoundedImageView r2, TextView r3, LinearLayout r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
