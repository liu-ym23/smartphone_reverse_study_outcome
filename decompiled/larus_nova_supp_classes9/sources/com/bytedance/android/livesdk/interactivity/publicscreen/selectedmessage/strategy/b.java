package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import io.reactivex.functions.Consumer;
import ju1.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        a r0 = this.a;
        int r1 = q.a;
        e r6 = q.h(r0.g, ((n) r5).b(r0.c), this.a.d);
        r0.f = r6;
        int r2 = ga2.d.a;
        ga2.d.c(r6.a, r6.b, r6.d);
        a.InterfaceC0192a r7 = r0.h;
        e r3 = r0.f;
        r7.update(r3.d, r3.a);
    }
}
