package com.larus.canvas.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusDialogInstructionFeatureSelectorBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RoundTextView b;
    public final RecyclerView c;
    public final NestedScrollView d;
    public final View e;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogInstructionFeatureSelectorBinding(ConstraintLayout r1, RoundTextView r2, RecyclerView r3, NestedScrollView r4, View r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
