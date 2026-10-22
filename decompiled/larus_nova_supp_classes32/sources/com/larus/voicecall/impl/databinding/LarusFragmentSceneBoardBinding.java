package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusFragmentSceneBoardBinding implements ViewBinding {
    public final LinearLayout a;
    public final View b;
    public final RecyclerView c;
    public final View d;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentSceneBoardBinding(LinearLayout r1, View r2, RecyclerView r3, ConstraintLayout r4, View r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}
