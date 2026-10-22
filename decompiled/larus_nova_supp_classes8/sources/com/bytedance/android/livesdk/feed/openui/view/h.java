package com.bytedance.android.livesdk.feed.openui.view;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.q0;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends q0 {
    public final /* synthetic */ SimpleLiveView a;

    public final void f(k r1, Exception r2) {
    }

    public final void g(k r1) {
    }

    public h(SimpleLiveView r1) {
        this.a = r1;
    }

    public final void h(k r2, int r3, int r4) {
        ViewGroup.LayoutParams r5 = this.a.a(2131376143).getLayoutParams();
        r5.width = (int) (r5.height * (r3 / r4));
        this.a.a(2131376143).setLayoutParams(r5);
        this.a.post(new g(this, r5));
    }
}
