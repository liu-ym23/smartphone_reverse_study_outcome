package com.bytedance.android.ec.core.toolbox.rxanimation;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements Action {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    public final void run() {
        g r0 = this.a;
        r0.a.setText(r0.e);
    }
}
