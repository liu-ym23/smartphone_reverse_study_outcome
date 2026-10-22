package com.bytedance.badger.x;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.monitor.c;
import com.bytedance.badger.v.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0 implements Runnable {
    public final /* synthetic */ f0 a;
    public final /* synthetic */ Context b;

    public e0(f0 r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        f0 r9 = this.a;
        Context r10 = this.b;
        r9.getClass();
        d.f0.getClass();
        com.bytedance.badger.v.f r0 = d.G;
        KProperty[] r2 = d.a;
        KProperty r3 = r2[33];
        String r4 = "";
        if (((Boolean) r0.a()).booleanValue() == false) goto L37;
        com.bytedance.badger.e.b("DeviceFp1Task", "executeV3 start");
        long r5 = System.currentTimeMillis();
        r9.b = r5;
        r9.e.getClass();
        if (Build.VERSION.SDK_INT >= 23) goto L62;
    L20:
        boolean r1 = false;
    L21:
        r9.f.getClass();
        PackageManager r6 = r10.getPackageManager();     // Catch: Throwable -> L24
        Intent r8 = new Intent();     // Catch: Throwable -> L24
        BadgerCore.Companion.getClass();     // Catch: Throwable -> L24
        r8.setPackage(com.bytedance.badger.j.b(8129550834698778238L));     // Catch: Throwable -> L24
        r8.setAction(com.bytedance.badger.j.b(2418618557650235769L));     // Catch: Throwable -> L24
        boolean r14 = !r6.queryIntentServices(r8, 0).isEmpty();
    L31:
        z r7 = new z(r1, r14);
        d.f0.getClass();
        com.bytedance.badger.v.i r12 = d.J;
        KProperty r13 = d.a[36];
        List r15 = CollectionsKt.toList((Collection) r12.a());
        if (r1 == true) goto L34;
        r9.d(r10, r9.f, r15, new t(r9, r5, r7, new a0(0, null, 14)));
        return;
    L34:
        r9.d(r10, r9.e, r15, new w(r9, r5, r7, r10, r15));
        return;
    L24:
        th = move-exception;
        HashMap r16 = new HashMap();
        r16.put("type", "service");
        StringBuilder r17 = new StringBuilder("is_supported: ");
        r17.append(th.getClass().getName());
        r17.append(' ');
        String r18 = th.getMessage();
        if (r18 == null) goto L28;
        r4 = r18;
    L28:
        r17.append(r4);
        String r19 = r17.toString();
        if (r19 == null) goto L36;
        r16.put("error_msg", StringsKt.trim(r19).toString());
        c.c.getClass();
        c.d("badger_loader_ds0_support_fail", r16);
        r14 = false;
        goto L31
    L36:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L62:
        boolean r20 = p.h();     // Catch: Throwable -> L8
    L16:
        if (r20 == false) goto L20;
        r1 = true;
    L8:
        th = move-exception;
        HashMap r22 = new HashMap();
        r22.put("type", "provider");
        StringBuilder r110 = new StringBuilder("is_supported: ");
        r110.append(th.getClass().getName());
        r110.append(' ');
        String r23 = th.getMessage();
        if (r23 != null) goto L13;
        r23 = "";
    L13:
        r110.append(r23);
        String r24 = r110.toString();
        if (r24 == null) goto L19;
        r22.put("error_msg", StringsKt.trim(r24).toString());
        c.c.getClass();
        c.d("badger_loader_ds0_support_fail", r22);
        r20 = false;
        goto L16
    L19:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L37:
        com.bytedance.badger.e.b("DeviceFp1Task", "execute start");
        long r111 = System.currentTimeMillis();
        r9.b = r111;
        Ref.ObjectRef r25 = new Ref.ObjectRef();
        r25.element = "";
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        r112.element = "";
        z r113 = new z(f0.g(), p.d(r10));
        if (f0.g() == true) goto L58;
    L48:
        p.b = new c0(r9, r111, r113, r112, r25);
        if (p.c == true) goto L51;
        Intent r26 = new Intent();
        com.bytedance.badger.j r27 = BadgerCore.Companion;
        r27.getClass();
        r26.setAction(com.bytedance.badger.j.b(2418618557650235769L));
        r27.getClass();
        r26.setPackage(com.bytedance.badger.j.b(8129550834698778238L));
        r27.getClass();
        r26.setComponent(new ComponentName(com.bytedance.badger.j.b(8129550834698778238L), com.bytedance.badger.j.b(1078607345834032513L)));
        p.c = r10.bindService(r26, p.d, 1);
        boolean r114 = p.c;
    L55:
        if (r114 == true) goto L66;
        r112.element = "service: init service failed";
        r9.c(r111, new y(BadgerResult.ERROR, ((String) r25.element) + ((String) r112.element), r113, null, null, 56), (String) r25.element, (String) r112.element);
        return;
    L66:
        return;
    L51:
        if (p.b == null) goto L53;
        com.bytedance.badger.e.b("DeviceFp1", "已经初始化，直接返回," + ThreadMethodProxy.currentThread().getName());
        ((c0) p.b).a();
    L53:
        r114 = true;
        goto L55
    L58:
        com.bytedance.badger.v.h r28 = d.I;     // Catch: Throwable -> L46
        KProperty r29 = r2[35];     // Catch: Throwable -> L46
        if (((Number) r28.a()).intValue() != 1) goto L43;
        String r30 = p.g();     // Catch: Throwable -> L46
    L44:
        r9.c(r111, new y(0, "success", r113, r30, "provider", 32), null, null);     // Catch: Throwable -> L46
        return;
    L43:
        r30 = p.f();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        com.bytedance.badger.e.c("DeviceFp1Task", "GetDeviceIdByAskProvider failed", th);
        r25.element = "provider: " + th.getClass().getName() + " " + th.getMessage();
        goto L48
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
