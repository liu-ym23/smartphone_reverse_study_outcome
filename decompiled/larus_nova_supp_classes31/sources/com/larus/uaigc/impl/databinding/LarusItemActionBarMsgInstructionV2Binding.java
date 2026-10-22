package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusItemActionBarMsgInstructionV2Binding implements ViewBinding {
    public final View a;
    public final TextView b;
    public final SimpleDraweeView c;

    public final View getRoot() {
        return this.a;
    }

    public static LarusItemActionBarMsgInstructionV2Binding a(LayoutInflater r2, ConstraintLayout r3) {
        if (r3 == null) goto L12;
        r2.inflate(2131562475, r3);
        int r4 = 2131369157;
        TextView r0 = (TextView) ViewBindings.findChildViewById(r3, 2131369157);
        if (r0 == null) goto L10;
        r4 = 2131374718;
        SimpleDraweeView r1 = ViewBindings.findChildViewById(r3, 2131374718);
        if (r1 == null) goto L10;
        return new LarusItemActionBarMsgInstructionV2Binding(r3, r0, r1);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r4)));
    L12:
        throw new NullPointerException("parent");
    }

    public LarusItemActionBarMsgInstructionV2Binding(ConstraintLayout r1, TextView r2, SimpleDraweeView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
