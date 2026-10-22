package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.LoadingWithRetryView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusPageTemplateBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RecyclerView b;
    public final SwipeRefreshLayout c;
    public final LoadingWithRetryView d;
    public final RecyclerView e;
    public final FrameLayout f;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageTemplateBinding(ConstraintLayout r1, RecyclerView r2, SwipeRefreshLayout r3, LoadingWithRetryView r4, RecyclerView r5, FrameLayout r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
