package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraGRebindBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RecyclerView b;
    public final View c;
    public final NovaTitleBarEx d;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraGRebindBinding(ConstraintLayout r1, RecyclerView r2, View r3, NovaTitleBarEx r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
