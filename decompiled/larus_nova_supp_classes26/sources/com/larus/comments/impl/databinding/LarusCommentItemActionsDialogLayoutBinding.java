package com.larus.comments.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusCommentItemActionsDialogLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final View c;
    public final RecyclerView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusCommentItemActionsDialogLayoutBinding(ConstraintLayout r1, TextView r2, View r3, RecyclerView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
