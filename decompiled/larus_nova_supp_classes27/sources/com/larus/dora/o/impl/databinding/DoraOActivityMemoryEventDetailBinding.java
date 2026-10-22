package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOActivityMemoryEventDetailBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final ScrollView c;
    public final TextView d;
    public final TextView e;
    public final OFloatingTitleBar f;

    public final View getRoot() {
        return this.a;
    }

    public DoraOActivityMemoryEventDetailBinding(ConstraintLayout r1, TextView r2, ScrollView r3, TextView r4, TextView r5, OFloatingTitleBar r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
