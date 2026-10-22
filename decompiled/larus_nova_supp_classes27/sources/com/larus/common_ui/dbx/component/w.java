package com.larus.common_ui.dbx.component;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w extends FrameLayout {
    public final /* synthetic */ v a;

    @Override // android.view.ViewGroup
    public final void onViewAdded(View r1) {
        super.onViewAdded(r1);
        this.a.a();
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r1) {
        super.onViewRemoved(r1);
        removeCallbacks(this.a.n);
        post(this.a.n);
    }

    public w(FragmentActivity r1, v r2) {
        this.a = r2;
        super(r1);
    }
}
