package com.obric.assistant.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricFragmentPersonalContextSettingBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RecyclerView b;
    public final OFloatingTitleBar c;

    public final View getRoot() {
        return this.a;
    }

    public static ObricFragmentPersonalContextSettingBinding a(LayoutInflater r3, ViewGroup r4) {
        ConstraintLayout r5 = r3.inflate(2131564005, r4, false);
        ConstraintLayout r6 = r5;
        int r0 = 2131384076;
        RecyclerView r1 = ViewBindings.findChildViewById(r5, 2131384076);
        if (r1 == null) goto L9;
        r0 = 2131389118;
        OFloatingTitleBar r2 = ViewBindings.findChildViewById(r5, 2131389118);
        if (r2 == null) goto L9;
        return new ObricFragmentPersonalContextSettingBinding(r6, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r0)));
    }

    public ObricFragmentPersonalContextSettingBinding(ConstraintLayout r1, RecyclerView r2, OFloatingTitleBar r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
