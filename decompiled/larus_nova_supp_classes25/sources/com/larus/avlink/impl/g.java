package com.larus.avlink.impl;

import com.larus.avlink.gallery.view.s1;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ g(s1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        Function1 r0 = this.a;
        boolean r6 = ((Boolean) r5).booleanValue();
        int r1 = DoraAVLinkServiceImpl.n;
        FLogger.a.i("DoraAVLinkServiceImpl", "shareAlbumZip completed, success=" + r6);
        r0.invoke(Boolean.valueOf(r6));
        return Unit.INSTANCE;
    }
}
