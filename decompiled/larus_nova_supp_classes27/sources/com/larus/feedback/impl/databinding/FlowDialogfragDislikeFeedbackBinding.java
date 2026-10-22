package com.larus.feedback.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.NestedScrollEditText;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.feedback.api.view.FlowTagLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class FlowDialogfragDislikeFeedbackBinding implements ViewBinding {
    public final FrameLayout a;
    public final TextView b;
    public final RoundTextView c;
    public final RoundLinearLayout d;
    public final NestedScrollEditText e;
    public final FrameLayout f;
    public final FlowTagLayout g;
    public final AppCompatImageView h;
    public final AppCompatTextView i;

    public final View getRoot() {
        return this.a;
    }

    public FlowDialogfragDislikeFeedbackBinding(FrameLayout r1, TextView r2, RoundTextView r3, RoundLinearLayout r4, NestedScrollEditText r5, FrameLayout r6, FlowTagLayout r7, AppCompatImageView r8, AppCompatTextView r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
