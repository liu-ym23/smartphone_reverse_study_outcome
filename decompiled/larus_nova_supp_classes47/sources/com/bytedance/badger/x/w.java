package com.bytedance.badger.x;

import android.content.Context;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class w extends Lambda implements Function1 {
    final /* synthetic */ f0 a;
    final /* synthetic */ long b;
    final /* synthetic */ z c;
    final /* synthetic */ Context d;
    final /* synthetic */ List e;

    public w(f0 r1, long r2, z r4, Context r5, List r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        super(1);
    }

    public Object invoke(Object r18) {
        a0 r6 = (a0) r18;
        boolean r1 = r6.a;
        f0 r7 = this.a;
        if (r1 == false) goto L5;
        long r8 = this.b;
        z r13 = this.c;
        String r14 = r6.b;
        r7.e.getClass();
        r7.c(r8, new y(0, "success", r13, r14, "provider", 32), f0.a(this.a, r6.d, "provider: "), null);
    L7:
        return Unit.INSTANCE;
    L5:
        Context r9 = this.d;
        long r3 = this.b;
        z r5 = this.c;
        List r10 = this.e;
        r7.d(r9, r7.f, r10, new t(r7, r3, r5, r6));
        goto L7
    }
}
