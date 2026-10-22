package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.dora.impl.view.DoraMovieView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraPageWakeupGestureBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ItemGroup b;
    public final ItemGroupTitle c;
    public final ImageView d;
    public final AppCompatTextView e;
    public final DoraMovieView f;
    public final ItemGroup g;
    public final View h;
    public final NovaTitleBarEx i;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraPageWakeupGestureBinding(ConstraintLayout r1, ItemGroup r2, ItemGroupTitle r3, ImageView r4, AppCompatTextView r5, DoraMovieView r6, ItemGroup r7, View r8, NovaTitleBarEx r9) {
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
