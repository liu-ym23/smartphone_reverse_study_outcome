package com.bytedance.badger.x;

import android.content.Context;
import android.os.Build;
import com.bytedance.badger.monitor.c;
import com.bytedance.badger.network.z0;
import com.bytedance.badger.v.d;
import com.bytedance.badger.z.c1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f0 {
    public static final Lazy g = null;
    public static final x h = null;
    public final AtomicBoolean a;
    public long b;
    public final CopyOnWriteArrayList c;
    public final z0 d;
    public final r e;
    public final u f;

    public f0() {
        this.a = new AtomicBoolean(false);
        this.c = new CopyOnWriteArrayList();
        this.d = new z0("dp1", 1, 8);
        this.e = new r();
        this.f = new u();
    }

    public static String b(Throwable r2) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.getClass().getName());
        String r3 = r2.getMessage();
        if (r3 == null) goto L11;
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L11;
        r0.append(" ");
        r0.append(r3);
    L11:
        return r0.toString();
    }

    public static boolean g() {
        if (Build.VERSION.SDK_INT < 23) goto L12;
        boolean r0 = p.h();     // Catch: Throwable -> L6
    L7:
        if (r0 == false) goto L13;
        return true;
    L13:
        return false;
    L6:
        r0 = false;
        goto L7
    L12:
        return false;
    }

    public final void d(Context r12, q r13, List r14, Function1 r15) {
        new v(this, r13, r12, r15, new ArrayList(), r14.size() + 1, r14).a(1, 0);
    }

    static {
        h = new x();
        g = LazyKt.lazy(m.a);
    }

    public final void e(Context r7, c1 r8) {
        this.c.add(r8);
        boolean r0 = false;
        if (this.a.compareAndSet(false, true) == true) goto L12;
        long r2 = System.currentTimeMillis() - this.b;
        d.f0.getClass();
        com.bytedance.badger.v.g r9 = d.H;
        KProperty r4 = d.a[34];
        if (r2 < ((com.bytedance.badger.v.w) r9.a()).a) goto L8;
        r0 = true;
    L8:
        if (r0 == true) goto L11;
        com.bytedance.badger.e.f("DeviceFp1Task", "execute not exceed max time, lastStartTime:" + this.b + ", currentTime:" + System.currentTimeMillis());
        return;
    L11:
        com.bytedance.badger.e.f("DeviceFp1Task", "execute exceed max time, lastStartTime:" + this.b + ", currentTime:" + System.currentTimeMillis());
    L12:
        this.d.a(new e0(this, r7));
    }

    public static final String a(f0 r0, List r1, String r2) {
        r0.getClass();
        StringBuilder r3 = new StringBuilder();
        r3.append(r2);
        r3.append(" ");
        Iterator r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r3.append(b((Throwable) r4.next()));
        goto L4
    L7:
        return r3.toString();
    }

    public final void c(long r9, y r12, String r13, String r14) {
        long r0 = System.currentTimeMillis() - r9;
        boolean r10 = false;
        this.a.set(false);
        StringBuilder r15 = new StringBuilder("onExecuteComplete, executeDuration:");
        r15.append(r0);
        r15.append(", errCode:");
        r15.append(r12.a);
        r15.append(", errMsg:");
        r15.append(r12.b);
        r15.append(",  type:");
        r15.append(r12.e);
        r15.append(", has_ds0:");
        String r2 = r12.d;
        if (r2 == null) goto L5;
        int r3 = r2.length();
    L7:
        if (r3 <= 3) goto L9;
        r10 = true;
    L9:
        r15.append(r10);
        r15.append(" isSupportProvider:");
        r15.append(r12.c.a);
        r15.append(", isSupportService:");
        r15.append(r12.c.b);
        r15.append(" providerErrMsg:");
        r15.append(r13);
        r15.append(", serviceErrMsg:");
        r15.append(r14);
        com.bytedance.badger.e.f("DeviceFp1Task", r15.toString());
        f("execute", r12, r0, r14, r13);
        Iterator r16 = this.c.iterator();
    L11:
        if (r16.hasNext() == false) goto L13;
        ((b0) r16.next()).a(r12, r0);
        goto L11
    L13:
        this.c.clear();
        return;
    L5:
        r3 = 0;
        goto L7
    }

    public static void f(String r2, y r3, long r4, String r6, String r7) {
        HashMap r0 = new HashMap();
        r0.put("position", r2);
        r0.put("duration_ds0", Long.valueOf(r4));
        if (r6 == null) goto L5;
        r0.put("error_ds0_service", r6);
    L5:
        if (r7 == null) goto L7;
        r0.put("error_ds0_provider", r7);
    L7:
        String r5 = r3.d;
        boolean r8 = false;
        if (r5 == null) goto L10;
        int r9 = r5.length();
    L12:
        if (r9 <= 3) goto L14;
        boolean r10 = true;
    L15:
        r0.put("has_ds0", Boolean.valueOf(r10));
        String r12 = r3.e;
        if (r12 != null) goto L19;
        r12 = "";
    L19:
        r0.put("type_ds0", r12);
        z r13 = r3.c;
        if (r13.a == false) goto L22;
    L23:
        r8 = true;
    L24:
        r0.put("support_ds0", Boolean.valueOf(r8));
        r0.put("support_ds0_provider", Boolean.valueOf(r3.c.a));
        r0.put("support_ds0_service", Boolean.valueOf(r3.c.b));
        r0.put("error_ds0", r3.b);
        c.c.getClass();
        c.d("badger_loader_s_monitor", r0);
        return;
    L22:
        if (r13.b == false) goto L24;
    L14:
        r10 = false;
        goto L15
    L10:
        r9 = 0;
        goto L12
    }
}
