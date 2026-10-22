package com.larus.uaigc.chat.markdown.helper;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class h1 implements Function2 {
    public final /* synthetic */ rd8.b a;

    public /* synthetic */ h1(rd8.b r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, Object r3) {
        rd8.b r0 = this.a;
        String r4 = (String) r2;
        boolean r5 = ((Boolean) r3).booleanValue();
        if (r0 == null) goto L8;
        kh8.a r1 = r0.q3();
        if (r1 == null) goto L8;
        r1.j(r4, r5);
    L8:
        return Unit.INSTANCE;
    }
}
