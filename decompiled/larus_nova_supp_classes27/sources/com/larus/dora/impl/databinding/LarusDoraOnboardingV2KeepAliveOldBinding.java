package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.view.DoraUrlSpanTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraOnboardingV2KeepAliveOldBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final DoraUrlSpanTextView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraOnboardingV2KeepAliveOldBinding(ConstraintLayout r1, DoraUrlSpanTextView r2) {
        this.a = r1;
        this.b = r2;
    }

    public static LarusDoraOnboardingV2KeepAliveOldBinding a(LayoutInflater r2, ViewGroup r3) {
        ConstraintLayout r4 = r2.inflate(2131562244, r3, false);
        ConstraintLayout r5 = r4;
        int r0 = 2131369899;
        if (((ScrollView) ViewBindings.findChildViewById(r4, 2131369899)) == null) goto L9;
        r0 = 2131369900;
        DoraUrlSpanTextView r1 = (DoraUrlSpanTextView) ViewBindings.findChildViewById(r4, 2131369900);
        if (r1 == null) goto L9;
        return new LarusDoraOnboardingV2KeepAliveOldBinding(r5, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
