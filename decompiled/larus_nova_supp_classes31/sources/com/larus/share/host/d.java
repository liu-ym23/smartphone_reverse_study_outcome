package com.larus.share.host;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d extends in7.h.a {
    public final /* synthetic */ Function1<Integer, Unit> a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public final void a(kn7.b r4) {
        Integer r0 = Integer.valueOf(r4.a);
        if (r0 != null) goto L6;
    L10:
        if (r0 != null) goto L13;
    L17:
        FLogger.a.i("ShareRuntimeServiceImpl", "share result channel=" + this.b + " type=" + this.c + " code=" + Integer.valueOf(r4.a));
        return;
    L13:
        if (r0.intValue() != 10002) goto L17;
        Function1<Integer, Unit> r1 = this.a;
        if (r1 == null) goto L17;
        r1.invoke(2);
        goto L17
    L6:
        if (r0.intValue() != 10000) goto L10;
        Function1<Integer, Unit> r2 = this.a;
        if (r2 == null) goto L17;
        r2.invoke(1);
        goto L17
    }

    public d(com.larus.share.impl.sdk.b r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
