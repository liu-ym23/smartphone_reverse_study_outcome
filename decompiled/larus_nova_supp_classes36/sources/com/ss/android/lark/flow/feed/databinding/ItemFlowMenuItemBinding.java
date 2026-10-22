package com.ss.android.lark.flow.feed.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ItemFlowMenuItemBinding implements ViewBinding {
    public final RelativeLayout a;
    public final LinearLayout b;
    public final AppCompatImageView c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public ItemFlowMenuItemBinding(RelativeLayout r1, LinearLayout r2, AppCompatImageView r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
