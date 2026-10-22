package com.bytedance.android.live.profit.privilege.service;

import com.bytedance.android.annie.api.card.HybridCard;
import io.reactivex.functions.Action;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements Action {
    public final /* synthetic */ WeakReference a;

    public g(WeakReference r1) {
        this.a = r1;
    }

    public final void run() {
        HybridCard r0 = (HybridCard) this.a.get();
        if (r0 == null) goto L6;
        r0.release();
        return;
    }
}
