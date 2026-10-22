package com.larus.business.search.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.search.SearchBar;
import com.larus.common_ui.widget.LoadingWithRetryView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusFragmentGlobalSearchBinding implements ViewBinding {
    public final RelativeLayout a;
    public final LoadingWithRetryView b;
    public final SearchBar c;
    public final View d;
    public final ScrollView e;
    public final LinearLayout f;
    public final RecyclerView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentGlobalSearchBinding(RelativeLayout r1, LoadingWithRetryView r2, SearchBar r3, View r4, ScrollView r5, LinearLayout r6, RecyclerView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
