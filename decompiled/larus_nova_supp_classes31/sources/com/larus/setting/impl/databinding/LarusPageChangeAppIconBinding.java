package com.larus.setting.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusPageChangeAppIconBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RecyclerView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final RoundFrameLayout f;
    public final TextView g;
    public final ItemGroup h;
    public final ItemTextArrow i;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageChangeAppIconBinding(ConstraintLayout r1, RecyclerView r2, ImageView r3, TextView r4, TextView r5, RoundFrameLayout r6, TextView r7, ItemGroup r8, ItemTextArrow r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
