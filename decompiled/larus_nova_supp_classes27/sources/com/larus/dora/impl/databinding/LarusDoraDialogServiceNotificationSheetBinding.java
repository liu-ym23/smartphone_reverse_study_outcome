package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDialogServiceNotificationSheetBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RecyclerView b;
    public final AppCompatImageView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDialogServiceNotificationSheetBinding(ConstraintLayout r1, RecyclerView r2, AppCompatImageView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
