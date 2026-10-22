package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusExpertCardBinding implements ViewBinding {
    public final LinearLayout a;
    public final AppCompatImageView b;
    public final LinearLayout c;
    public final FrameLayout d;
    public final AtMostHeightRecyclerView e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusExpertCardBinding(LinearLayout r1, AppCompatImageView r2, LinearLayout r3, FrameLayout r4, AtMostHeightRecyclerView r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
