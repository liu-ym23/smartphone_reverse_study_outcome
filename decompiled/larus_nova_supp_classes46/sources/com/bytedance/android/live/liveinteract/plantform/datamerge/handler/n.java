package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.message.model.za;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n extends a {
    public final CompositeDisposable b;
    public final ch0.c c;

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        ch0.c r0 = this.c;
        IKtvService r1 = jc1.k.f(IKtvService.class);
        if (r1 == null) goto L5;
        za r2 = r1.ktvCurrentSingerOrderInfo();
    L6:
        r0.a = r2;
        a().W0(this.c);
        IKtvService r3 = jc1.k.f(IKtvService.class);
        if (r3 == null) goto L14;
        com.bytedance.live.datacontext.k r4 = r3.ktvComponentSingerChangedEvent();
        if (r4 == null) goto L15;
        Disposable r5 = r4.onEvent().subscribe(new m(this));
        if (r5 == null) goto L16;
        RxUtilKt.c(r5, this.b);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.b.dispose();
    }

    public n() {
        this.b = new CompositeDisposable();
        this.c = new ch0.c();
    }
}
