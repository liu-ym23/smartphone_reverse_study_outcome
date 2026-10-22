package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricCardItemStyleIconTextBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;
    public final TextView c;

    public final View getRoot() {
        return this.a;
    }

    public ObricCardItemStyleIconTextBinding(ConstraintLayout r1, SimpleDraweeView r2, TextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
