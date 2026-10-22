package com.bytedance.android.live.profile.seeselftransition;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements Action {
    public final /* synthetic */ Disposable a;
    public final /* synthetic */ Disposable b;

    public d(Disposable r1, Disposable r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        this.a.dispose();
        this.b.dispose();
    }
}
