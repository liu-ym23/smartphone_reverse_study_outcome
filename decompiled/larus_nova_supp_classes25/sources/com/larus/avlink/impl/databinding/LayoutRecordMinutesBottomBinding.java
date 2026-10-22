package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LayoutRecordMinutesBottomBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final TextView c;
    public final LinearLayout d;

    public final View getRoot() {
        return this.a;
    }

    public LayoutRecordMinutesBottomBinding(ConstraintLayout r1, ConstraintLayout r2, TextView r3, LinearLayout r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
