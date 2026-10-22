package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDialogPrivacyPolicyBinding implements ViewBinding {
    public final FrameLayout a;
    public final RoundConstraintLayout b;
    public final AppCompatTextView c;
    public final ImageView d;
    public final UrlSpanTextView e;
    public final AppCompatTextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDialogPrivacyPolicyBinding(FrameLayout r1, RoundConstraintLayout r2, AppCompatTextView r3, ImageView r4, UrlSpanTextView r5, AppCompatTextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
