package com.bytedance.badger.utils;

import android.content.Context;
import android.content.ServiceConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class r extends Lambda implements Function2 {
    final /* synthetic */ Object a;
    final /* synthetic */ Ref.BooleanRef b;
    final /* synthetic */ Ref.BooleanRef c;
    final /* synthetic */ Context d;

    public r(Object r1, Ref.BooleanRef r2, Ref.BooleanRef r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        super(2);
    }

    public final void a(ServiceConnection r7, ServiceConnection r8) {
        Object r0 = this.a;
        monitor-enter(r0);
        Ref.BooleanRef r1 = this.b;     // Catch: Throwable -> L18
        boolean r2 = r1.element;     // Catch: Throwable -> L18
        Ref.BooleanRef r3 = this.c;     // Catch: Throwable -> L18
        boolean r4 = r3.element;     // Catch: Throwable -> L18
        r1.element = false;     // Catch: Throwable -> L18
        r3.element = false;     // Catch: Throwable -> L18
        monitor-exit(r0);
        if (r2 == true) goto L24;
    L12:
        if (r4 == false) goto L28;
        this.d.unbindService(r7);     // Catch: Throwable -> L15 IllegalArgumentException -> L21
        goto L30
    L29:
        return;
    L15:
        th = move-exception;
        com.bytedance.badger.e.c("vivo#", "Failed to unbind account service", th);
        return;
    L30:
        return;
    L28:
        return;
    L24:
        this.d.unbindService(r8);     // Catch: Throwable -> L9 IllegalArgumentException -> L11
    L9:
        th = move-exception;
        com.bytedance.badger.e.c("vivo#", "Failed to unbind isolated service", th);
    L18:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        a((ServiceConnection) r1, (ServiceConnection) r2);
        return Unit.INSTANCE;
    }
}
