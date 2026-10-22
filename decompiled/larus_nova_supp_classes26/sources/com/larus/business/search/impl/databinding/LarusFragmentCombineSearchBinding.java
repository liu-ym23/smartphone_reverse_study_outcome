package com.larus.business.search.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.search.SearchBar;
import com.larus.common_ui.widget.LoadingWithRetryView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusFragmentCombineSearchBinding implements ViewBinding {
    public final RelativeLayout a;
    public final LoadingWithRetryView b;
    public final SearchBar c;
    public final FrameLayout d;
    public final RecyclerView e;
    public final RecyclerView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentCombineSearchBinding(RelativeLayout r1, LoadingWithRetryView r2, SearchBar r3, FrameLayout r4, RecyclerView r5, RecyclerView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
