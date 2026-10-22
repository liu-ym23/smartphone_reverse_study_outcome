package com.larus.drive.biz.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusPageDriveUploadListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final ImageView c;
    public final ConstraintLayout d;
    public final TextView e;
    public final RecyclerView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageDriveUploadListBinding(ConstraintLayout r1, ConstraintLayout r2, ImageView r3, ConstraintLayout r4, TextView r5, RecyclerView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
