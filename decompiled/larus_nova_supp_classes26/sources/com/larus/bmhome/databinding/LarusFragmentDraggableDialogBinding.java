package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusFragmentDraggableDialogBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final ProgressBar c;
    public final ProgressBar d;
    public final RecyclerView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentDraggableDialogBinding(ConstraintLayout r1, View r2, ProgressBar r3, ProgressBar r4, RecyclerView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
