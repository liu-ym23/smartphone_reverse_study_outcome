package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOFragmentDiaryStyleBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final OCardListItem b;
    public final TextView c;
    public final RecyclerView d;
    public final ProgressBar e;
    public final OFloatingTitleBar f;

    public final View getRoot() {
        return this.a;
    }

    public DoraOFragmentDiaryStyleBinding(ConstraintLayout r1, OCardListItem r2, TextView r3, RecyclerView r4, ProgressBar r5, OFloatingTitleBar r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
