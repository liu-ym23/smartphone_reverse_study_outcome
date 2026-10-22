package com.larus.drive.biz.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.drive.biz.impl.view.widget.DriveTagListView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusPageDriveMainBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final NovaTitleBarEx b;
    public final DriveTagListView c;
    public final CardView d;
    public final ImageView e;
    public final ImageView f;
    public final TextView g;
    public final ProgressBar h;
    public final ImageView i;
    public final ViewPager2 j;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageDriveMainBinding(ConstraintLayout r1, NovaTitleBarEx r2, DriveTagListView r3, CardView r4, ImageView r5, ImageView r6, TextView r7, ProgressBar r8, ImageView r9, ViewPager2 r10) {
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
    }
}
