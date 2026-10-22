package com.larksuite.component.universe_design.notice.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UdLayoutNoticeBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public UdLayoutNoticeBinding(ConstraintLayout r1, ImageView r2, ImageView r3, TextView r4, TextView r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
