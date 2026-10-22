package com.bytedance.badger.x;

import com.bytedance.badger.data.BadgerResult;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class t extends Lambda implements Function1 {
    final /* synthetic */ f0 a;
    final /* synthetic */ long b;
    final /* synthetic */ z c;
    final /* synthetic */ a0 d;

    public t(f0 r1, long r2, z r4, a0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        a((a0) r1);
        return Unit.INSTANCE;
    }

    public final void a(a0 r15) {
        if (r15.a == false) goto L6;
        f0 r3 = this.a;
        long r4 = this.b;
        z r9 = this.c;
        String r10 = r15.b;
        r3.f.getClass();
        r3.c(r4, new y(0, "success", r9, r10, "service", 32), f0.a(this.a, this.d.d, "provider: "), f0.a(this.a, r15.d, "service: "));
        return;
    L6:
        StringBuilder r0 = new StringBuilder("provider: ");
        Throwable r5 = (Throwable) CollectionsKt.firstOrNull(this.d.d);
        String r6 = null;
        if (r5 == null) goto L9;
        String r7 = r5.getMessage();
    L10:
        r0.append(r7);
        r0.append(" service: ");
        Throwable r8 = (Throwable) CollectionsKt.firstOrNull(r15.d);
        if (r8 == null) goto L13;
        r6 = r8.getMessage();
    L13:
        r0.append(r6);
        String r12 = r0.toString();
        f0 r1 = this.a;
        r1.c(this.b, new y(BadgerResult.ERROR, r12, this.c, null, null, 56), f0.a(r1, this.d.d, "provider: "), f0.a(this.a, r15.d, "service: "));
        return;
    L9:
        r7 = null;
        goto L10
    }
}
