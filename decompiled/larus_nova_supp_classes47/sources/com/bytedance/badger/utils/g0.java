package com.bytedance.badger.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.badger.BadgerCore;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g0 implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ IBinder b;
    public final /* synthetic */ b c;

    public g0(b r1, IBinder r2, b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (this.a.a.get() == false) goto L5;
        return;
    L5:
        this.a.b.set(this.b);
        Object r0 = this.a.c;
        monitor-enter(r0);
        this.a.d.element = true;     // Catch: Throwable -> L34
        monitor-exit(r0);
        Intent r1 = new Intent();
        String r3 = this.a.e.getPackageName();
        f.d.getClass();
        BadgerCore.Companion.getClass();
        r1.setComponent(new ComponentName(r3, com.bytedance.badger.j.b(3281321789693851140L)));
        b r2 = this.a;     // Catch: Throwable -> L28
        Context r4 = r2.e;     // Catch: Throwable -> L28
        Object r5 = r2.f.element;     // Catch: Throwable -> L28
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("isolatedConnection");     // Catch: Throwable -> L28
    L13:
        if (r4.bindService(r1, (ServiceConnection) r5, 1) == true) goto L20;
        b r6 = this.a;
        t r7 = r6.g;
        b r8 = this.c;
        Object r9 = r6.f.element;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("isolatedConnection");
    L18:
        r7.a(r8, (ServiceConnection) r9, new IllegalStateException("bind isolated service returned false"));
        return;
    L20:
        Object r10 = this.a.c;
        monitor-enter(r10);
        this.a.h.element = true;     // Catch: Throwable -> L25
        monitor-exit(r10);
        return;
    L25:
        th = move-exception;
        throw th;
    L28:
        th = move-exception;
        b r12 = this.a;
        t r13 = r12.g;
        b r14 = this.c;
        Object r15 = r12.f.element;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("isolatedConnection");
    L32:
        r13.a(r14, (ServiceConnection) r15, th);
        return;
    L34:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
