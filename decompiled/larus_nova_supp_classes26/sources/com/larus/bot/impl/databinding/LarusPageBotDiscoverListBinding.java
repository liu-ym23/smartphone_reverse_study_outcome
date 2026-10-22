package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bot.impl.common.view.BlockBringChildSwipeRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusPageBotDiscoverListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RecyclerView b;
    public final LinearLayout c;
    public final BlockBringChildSwipeRefreshLayout d;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageBotDiscoverListBinding(ConstraintLayout r1, RecyclerView r2, LinearLayout r3, BlockBringChildSwipeRefreshLayout r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
