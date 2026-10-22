package com.larus.chat.search.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.RedDotTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusItemSearchSectionNormalBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final RedDotTextView c;

    public final View getRoot() {
        return this.a;
    }

    public static LarusItemSearchSectionNormalBinding a(LayoutInflater r2, ViewGroup r3) {
        ConstraintLayout r4 = r2.inflate(2131562658, r3, false);
        int r5 = 2131385722;
        AppCompatTextView r0 = ViewBindings.findChildViewById(r4, 2131385722);
        if (r0 == null) goto L9;
        r5 = 2131385728;
        RedDotTextView r1 = ViewBindings.findChildViewById(r4, 2131385728);
        if (r1 == null) goto L9;
        return new LarusItemSearchSectionNormalBinding(r4, r0, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r5)));
    }

    public LarusItemSearchSectionNormalBinding(ConstraintLayout r1, AppCompatTextView r2, RedDotTextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
