package com.bytedance.badger.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.v.d;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final /* synthetic */ KProperty[] a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final f d = null;

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(f.class), "transferThread", "getTransferThread()Landroid/os/HandlerThread;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(f.class), "transferHandler", "getTransferHandler()Landroid/os/Handler;"))};
        d = new f();
        b = LazyKt.lazy(D.a);
        c = LazyKt.lazy(C.a);
    }

    public f() {
    }

    public static final Handler a(f r2) {
        r2.getClass();
        Lazy r3 = c;
        KProperty r0 = a[1];
        return (Handler) r3.getValue();
    }

    public static b0 b(Context r28, Long r29, Function3 r30) {
        Context r0 = r28.getApplicationContext();
        AtomicBoolean r12 = new AtomicBoolean(false);
        CountDownLatch r14 = new CountDownLatch(1);
        AtomicInteger r13 = new AtomicInteger(0);
        long r16 = System.currentTimeMillis();
        AtomicReference r10 = new AtomicReference(null);
        AtomicReference r8 = new AtomicReference(null);
        Object r7 = new Object();
        Ref.BooleanRef r6 = new Ref.BooleanRef();
        r6.element = false;
        Ref.BooleanRef r5 = new Ref.BooleanRef();
        r5.element = false;
        r r4 = new r(r7, r5, r6, r0);
        t r3 = new t(r8, r12, r14, r4);
        AtomicReference r2 = new AtomicReference(null);
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        b r15 = new b(r12, r2, r7, r6, r0, r1, r3, r5);
        r1.element = new f0(r2, r3, r15, r13, r10, r29, r16, r30, r12, r14, r4, r8);
        Intent r9 = new Intent();
        d.getClass();
        BadgerCore.Companion.getClass();
        r9.setComponent(new ComponentName(com.bytedance.badger.j.b(1227696027139978936L), com.bytedance.badger.j.b(1497361586704392952L)));
        if (r0.bindService(r9, r15, 1) == true) goto L8;
        return new b0(null, -1003, "bind account service returned false");
    L8:
        monitor-enter(r7);
        r6.element = true;     // Catch: Throwable -> L37
        monitor-exit(r7);
        d.f0.getClass();
        com.bytedance.badger.v.g r17 = d.d0;
        KProperty r18 = d.a[56];
        com.bytedance.badger.v.w r19 = (com.bytedance.badger.v.w) r17.a();
        if (r14.await(r19.a, r19.b) == true) goto L16;
        r13.compareAndSet(0, 2);
        return new b0(null, Integer.valueOf(BadgerResult.ERROR), "Timeout");
    L16:
        Throwable r20 = (Throwable) r8.get();
        if (r20 == null) goto L24;
        String r22 = r20.getMessage();
        if (r22 != null) goto L23;
        r22 = "";
    L23:
        return new b0(null, -1003, r22);
    L24:
        String r23 = (String) r10.get();
        if (r23 != null) goto L28;
        r23 = "";
    L28:
        String r24 = StringsKt.trim(r23).toString();
        if (r24.length() != 0) goto L31;
        boolean r110 = true;
    L32:
        if (r110 == false) goto L36;
        return new b0(null, -1001, "empty");
    L36:
        return new b0(r24, null, null);
    L31:
        r110 = false;
    L37:
        th = move-exception;
        throw th;
    L41:
        th = move-exception;
        StringBuilder r25 = new StringBuilder();
        r25.append(th.getClass().getSimpleName());
        r25.append(": ");
        String r26 = th.getMessage();
        if (r26 != null) goto L46;
        r26 = "";
    L46:
        r25.append(r26);
        return new b0(null, -1003, r25.toString());
    }

    public static final void c(f r1, AtomicBoolean r2, CountDownLatch r3, Function0 r4) {
        r1.getClass();
        if (r2.compareAndSet(false, true) == false) goto L13;
        r4.invoke();     // Catch: Throwable -> L8
        r3.countDown();
        return;
    L8:
        th = move-exception;
        r3.countDown();
        throw th;
    }
}
