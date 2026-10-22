package com.larus.avlink.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LarusFragmentDiaryStyleBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RecyclerView b;
    public final SwipeRefreshLayout c;
    public final NovaTitleBarEx d;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentDiaryStyleBinding(ConstraintLayout r1, RecyclerView r2, SwipeRefreshLayout r3, NovaTitleBarEx r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
