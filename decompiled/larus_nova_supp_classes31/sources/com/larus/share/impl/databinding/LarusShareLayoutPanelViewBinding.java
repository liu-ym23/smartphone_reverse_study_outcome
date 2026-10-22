package com.larus.share.impl.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusShareLayoutPanelViewBinding implements ViewBinding {
    public final LinearLayout a;
    public final LinearLayout b;
    public final RecyclerView c;
    public final FrameLayout d;
    public final EditText e;
    public final RecyclerView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusShareLayoutPanelViewBinding(LinearLayout r1, LinearLayout r2, RecyclerView r3, FrameLayout r4, EditText r5, RecyclerView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
