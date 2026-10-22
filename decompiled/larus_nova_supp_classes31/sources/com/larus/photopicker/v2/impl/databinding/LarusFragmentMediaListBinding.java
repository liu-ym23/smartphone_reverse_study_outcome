package com.larus.photopicker.v2.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusFragmentMediaListBinding implements ViewBinding {
    public final FrameLayout a;
    public final TextView b;
    public final RecyclerView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentMediaListBinding(FrameLayout r1, TextView r2, RecyclerView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
