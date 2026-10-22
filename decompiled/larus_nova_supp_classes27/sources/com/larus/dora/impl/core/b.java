package com.larus.dora.impl.core;

import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import yj4.f;
import yj4.g;
import yj4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b implements Function1<Throwable, Unit> {
    public final /* synthetic */ h a;
    public final /* synthetic */ c b;

    public b(f r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r2) {
        Throwable r3 = (Throwable) r2;
        g49.d.d("DoraAdapterExt", "requestAlbumThumbnail: cancel");
        f r4 = this.a;
        c r0 = this.b;
        r4.getClass();
        int r5 = g.a;
        ((CopyOnWriteArraySet) h.D2).remove(r0);
        return Unit.INSTANCE;
    }
}
