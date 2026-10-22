package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDialogSpanableBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final UrlSpanTextView b;
    public final TextView c;
    public final TextView d;
    public final UrlSpanTextView e;
    public final TextView f;
    public final ScrollView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogSpanableBinding(ConstraintLayout r1, UrlSpanTextView r2, TextView r3, TextView r4, UrlSpanTextView r5, TextView r6, ScrollView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
