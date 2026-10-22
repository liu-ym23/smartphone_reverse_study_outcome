package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ItemSearchLinkCardPickerBaseBinding implements ViewBinding {
    public final ItemSearchLinkInnerCardBinding innerLink1;
    public final ItemSearchLinkInnerCardBinding innerLink2;
    public final TextView innerLinkMore;
    public final ConstraintLayout linkInnerCard;
    private final ConstraintLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3333getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public ConstraintLayout m3333getRoot() {
        return this.rootView;
    }

    public static ItemSearchLinkCardPickerBaseBinding bind(View r8) {
        int r0 = 2131375314;
        View r1 = ViewBindings.findChildViewById(r8, 2131375314);
        if (r1 == null) goto L11;
        ItemSearchLinkInnerCardBinding r4 = ItemSearchLinkInnerCardBinding.bind(r1);
        r0 = 2131375315;
        View r2 = ViewBindings.findChildViewById(r8, 2131375315);
        if (r2 == null) goto L11;
        ItemSearchLinkInnerCardBinding r5 = ItemSearchLinkInnerCardBinding.bind(r2);
        r0 = 2131375317;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, 2131375317);
        if (r6 == null) goto L11;
        ConstraintLayout r7 = (ConstraintLayout) r8;
        return new ItemSearchLinkCardPickerBaseBinding(r7, r4, r5, r6, r7);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }

    public static ItemSearchLinkCardPickerBaseBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemSearchLinkCardPickerBaseBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131561682, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private ItemSearchLinkCardPickerBaseBinding(ConstraintLayout r1, ItemSearchLinkInnerCardBinding r2, ItemSearchLinkInnerCardBinding r3, TextView r4, ConstraintLayout r5) {
        this.rootView = r1;
        this.innerLink1 = r2;
        this.innerLink2 = r3;
        this.innerLinkMore = r4;
        this.linkInnerCard = r5;
    }
}
