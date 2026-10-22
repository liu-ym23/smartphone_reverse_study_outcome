package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LayoutRecordMinutesTitleBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final TextView c;

    public final View getRoot() {
        return this.a;
    }

    public LayoutRecordMinutesTitleBinding(ConstraintLayout r1, ImageView r2, ImageView r3, TextView r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }
}
