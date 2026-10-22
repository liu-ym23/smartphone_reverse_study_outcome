package com.bytedance.pia.core.bridge.methods;

import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f6983a = null;

    static {
        f6983a = new ah.b("pia.internal.worker.create", PiaMethod$Scope.f6953b, new a(5));
    }

    @Override // ah.a
    public final void a(gh.c r5, Object r10, gh.b r11, n0 r12) {
        e0 r13 = (e0) r10;
        if (e0.a(r13) != null) goto L5;
        td.b.c("Parameter 'url' is required!", r12);
        return;
    L5:
        nh.d r14 = r5.f17099b;
        rh.f r15 = new rh.f();
        r15.f21749c = r14;
        r15.f21750h = e0.c(r13);
        r15.f21747a = e0.b(r13);
        r15.f21748b = e0.a(r13);
        r15.f21751i = r14.f20244o;
        rh.g r16 = r15.a();
        if (r16 != null) goto L26;
        r12.accept(new PiaMethod$Error(-10001));
        return;
    L26:
        rh.i r17 = new rh.i(r16);     // Catch: Throwable -> L15
        r17.h();     // Catch: Throwable -> L15
        if (r14.f20231b.get() == false) goto L12;
        String r18 = null;
    L17:
        if (r18 != null) goto L19;
        r12.accept(new PiaMethod$Error(-10002));     // Catch: Throwable -> L15
        return;
    L19:
        r17.d.b(new d0(r14, r5, r18, 0));     // Catch: Throwable -> L15
        r17.c(new d0(r14, r5, r18, 1));     // Catch: Throwable -> L15
        r11.accept(new f0(r18));     // Catch: Throwable -> L15
        return;
    L12:
        r18 = r17.hashCode() + String.valueOf(r14.hashCode());     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r18) == true) goto L17;
        r14.f20232c.putIfAbsent(r18, r17);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if ((th instanceof PiaMethod$Error) == false) goto L24;
        r12.accept(th);
        return;
    L24:
        r12.accept(new PiaMethod$Error(-10002, th.toString()));
    }
}
