package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricCardItemStyleScheduleBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public ObricCardItemStyleScheduleBinding(ConstraintLayout r1, SimpleDraweeView r2, TextView r3, TextView r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
