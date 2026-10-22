package com.larus.share.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusDialogFragmentLongImageShareBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final CardView c;
    public final RecyclerView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogFragmentLongImageShareBinding(ConstraintLayout r1, ImageView r2, CardView r3, RecyclerView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
