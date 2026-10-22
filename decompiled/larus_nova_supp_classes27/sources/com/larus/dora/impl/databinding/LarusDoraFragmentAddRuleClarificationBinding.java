package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.MaxHeightRecyclerView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraFragmentAddRuleClarificationBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LinearLayoutCompat b;
    public final ProgressBar c;
    public final TextView d;
    public final TextView e;
    public final MaxHeightRecyclerView f;
    public final DoraTextView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraFragmentAddRuleClarificationBinding(ConstraintLayout r1, LinearLayoutCompat r2, ProgressBar r3, TextView r4, TextView r5, MaxHeightRecyclerView r6, DoraTextView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
