package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.impl.view.DoraUrlSpanTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraOnboardingV2KeepAliveScrollableBinding implements ViewBinding {
    public final NestedScrollView a;
    public final NestedScrollView b;
    public final CircleSimpleDraweeView c;
    public final DoraUrlSpanTextView d;
    public final ItemGroup e;
    public final DoraTextView f;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDoraOnboardingV2KeepAliveScrollableBinding a(LayoutInflater r7, ViewGroup r8) {
        NestedScrollView r9 = r7.inflate(2131562245, r8, false);
        NestedScrollView r2 = r9;
        int r10 = 2131369898;
        CircleSimpleDraweeView r3 = (CircleSimpleDraweeView) ViewBindings.findChildViewById(r9, 2131369898);
        if (r3 == null) goto L13;
        r10 = 2131369900;
        DoraUrlSpanTextView r4 = (DoraUrlSpanTextView) ViewBindings.findChildViewById(r9, 2131369900);
        if (r4 == null) goto L13;
        r10 = 2131369938;
        ItemGroup r5 = ViewBindings.findChildViewById(r9, 2131369938);
        if (r5 == null) goto L13;
        r10 = 2131369940;
        DoraTextView r6 = (DoraTextView) ViewBindings.findChildViewById(r9, 2131369940);
        if (r6 == null) goto L13;
        return new LarusDoraOnboardingV2KeepAliveScrollableBinding(r2, r2, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r10)));
    }

    public LarusDoraOnboardingV2KeepAliveScrollableBinding(NestedScrollView r1, NestedScrollView r2, CircleSimpleDraweeView r3, DoraUrlSpanTextView r4, ItemGroup r5, DoraTextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
