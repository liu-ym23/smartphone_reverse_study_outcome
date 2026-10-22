package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;
import com.larus.dora.o.impl.memory.OViewPager2FixLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOFragmentMemoryEventBinding implements ViewBinding {
    public final OViewPager2FixLayout a;
    public final TextView b;
    public final RecyclerView c;
    public final ProgressBar d;
    public final SuperSwipeRefreshLayout e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public DoraOFragmentMemoryEventBinding(OViewPager2FixLayout r1, TextView r2, RecyclerView r3, ProgressBar r4, SuperSwipeRefreshLayout r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
