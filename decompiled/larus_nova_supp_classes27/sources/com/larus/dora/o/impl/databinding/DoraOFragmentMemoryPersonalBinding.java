package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.o.impl.memory.OViewPager2FixLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOFragmentMemoryPersonalBinding implements ViewBinding {
    public final OViewPager2FixLayout a;
    public final LinearLayout b;
    public final TextView c;
    public final RecyclerView d;
    public final ProgressBar e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public DoraOFragmentMemoryPersonalBinding(OViewPager2FixLayout r1, LinearLayout r2, TextView r3, RecyclerView r4, ProgressBar r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
