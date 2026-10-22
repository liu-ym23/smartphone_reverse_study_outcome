package com.suite.lark.platform.feature.forward.doubao;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class z implements View.OnClickListener {
    public final /* synthetic */ ForwardDoubaoActivity a;

    public z(ForwardDoubaoActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.finish();
    }
}
