package com.larus.drive.biz.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDriveFileListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LinearLayout b;
    public final LinearLayout c;
    public final SwipeRefreshLayout d;
    public final RecyclerView e;
    public final CardView f;
    public final ImageView g;
    public final ImageView h;
    public final TextView i;
    public final ProgressBar j;
    public final ImageView k;

    public final View getRoot() {
        return this.a;
    }

    public LarusDriveFileListBinding(ConstraintLayout r1, LinearLayout r2, LinearLayout r3, SwipeRefreshLayout r4, RecyclerView r5, CardView r6, ImageView r7, ImageView r8, TextView r9, ProgressBar r10, ImageView r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }
}
