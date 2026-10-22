package com.larus.chat.search.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.search.SearchBar;
import com.larus.common_ui.widget.LoadingWithRetryView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusFragmentChatSearchBinding implements ViewBinding {
    public final RelativeLayout a;
    public final LoadingWithRetryView b;
    public final SearchBar c;
    public final ScrollView d;
    public final LinearLayout e;
    public final RecyclerView f;
    public final RecyclerView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentChatSearchBinding(RelativeLayout r1, LoadingWithRetryView r2, SearchBar r3, ScrollView r4, LinearLayout r5, RecyclerView r6, RecyclerView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
