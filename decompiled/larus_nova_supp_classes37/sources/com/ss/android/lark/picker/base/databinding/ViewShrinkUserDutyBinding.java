package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.framework.ui.PriorityLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ViewShrinkUserDutyBinding implements ViewBinding {
    public final AppCompatImageView ivDivider;
    private final PriorityLayout rootView;
    public final TextView tvDuty;
    public final TextView tvSection;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3350getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public PriorityLayout m3350getRoot() {
        return this.rootView;
    }

    public static ViewShrinkUserDutyBinding bind(View r4) {
        int r0 = 2131376182;
        AppCompatImageView r1 = ViewBindings.findChildViewById(r4, 2131376182);
        if (r1 == null) goto L11;
        r0 = 2131390542;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, 2131390542);
        if (r2 == null) goto L11;
        r0 = 2131391372;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, 2131391372);
        if (r3 == null) goto L11;
        return new ViewShrinkUserDutyBinding((PriorityLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }

    public static ViewShrinkUserDutyBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewShrinkUserDutyBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131568203, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private ViewShrinkUserDutyBinding(PriorityLayout r1, AppCompatImageView r2, TextView r3, TextView r4) {
        this.rootView = r1;
        this.ivDivider = r2;
        this.tvDuty = r3;
        this.tvSection = r4;
    }
}
