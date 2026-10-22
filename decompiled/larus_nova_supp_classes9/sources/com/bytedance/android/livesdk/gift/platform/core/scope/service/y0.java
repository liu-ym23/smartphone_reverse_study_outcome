package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y0 implements Disposable {
    public boolean a;
    public final /* synthetic */ a1 b;
    public final /* synthetic */ Observer c;

    public final void dispose() {
        this.b.c.removeObserver("data_link_state", this.c);
        this.a = true;
    }

    public final boolean isDisposed() {
        return this.a;
    }

    public y0(a1 r1, z0 r2) {
        this.b = r1;
        this.c = r2;
    }
}
