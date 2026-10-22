package com.bytedance.android.live.messagewindow.framework.process.card;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class SuspendCardPs extends a {
    public final CardPsId e;
    public final long f;

    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final CardPsId b() {
        return this.e;
    }

    public SuspendCardPs(long r1) {
        this.f = r1;
        this.e = CardPsId.SuspendCard;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final void d(h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r8) {
        Intrinsics.checkNotNullParameter(r8, "chain");
        final com.bytedance.android.live.messagewindow.framework.process.a r9 = (com.bytedance.android.live.messagewindow.framework.process.a) ((hm0.a) r8).a;
        d71.d r0 = r9.b.recordManager(r9.c.getPosition());
        if (r0 == null) goto L5;
        d71.b r1 = r0.l(r9.c);
    L6:
        final i71.a r2 = r9.b.scheduler();
        if (r1 == null) goto L15;
        long r3 = this.f;
        Function0<Unit> r4 = new SuspendCardPs$onProcess$1(r2, r9);
        Intrinsics.checkNotNullParameter(r4, "task");
        Disposable r10 = r1.c;
        if (r10 == null) goto L12;
        r10.dispose();
    L12:
        if (r3 > 0) goto L14;
        Disposables.empty();
        goto L15
    L14:
        r1.c = Observable.timer(r3, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d71.a(r1, r4));
    L15:
        e();
        return;
    L5:
        r1 = null;
        goto L6
    }
}
