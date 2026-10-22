package com.bytedance.pia.core.bridge.methods;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f7016a = null;

    static {
        f7016a = new ah.b("pia.internal.worker.runTask", PiaMethod$Scope.f6953b, new a(7));
    }

    @Override // ah.a
    public final void a(gh.c r10, Object r11, gh.b r12, n0 r13) {
        o0 r14 = (o0) r11;
        if (o0.a(r14) != null) goto L6;
        td.b.c("Parameter 'url' is required!", r13);
        return;
    L6:
        if (TextUtils.isEmpty(o0.b(r14)) == true) goto L8;
        String r5 = o0.b(r14);
    L10:
        if (o0.c(r14) != null) goto L12;
        long r15 = 30;
    L19:
        if (o0.d(r14) != null) goto L21;
    L27:
        JsonObject r16 = new JsonObject();
    L28:
        nh.d r17 = r10.f17099b;
        rh.f r18 = new rh.f();
        r18.f21749c = r17;
        r18.f21750h = r5;
        r18.f21747a = o0.e(r14);
        r18.f21748b = o0.a(r14);
        r18.e = new l0(r12, 0);
        r18.f21751i = r17.f20244o;
        rh.g r19 = r18.a();
        if (r19 != null) goto L31;
        r13.accept(new PiaMethod$Error(-10001));
        return;
    L31:
        Object r110 = r17.a(r19.f21754c);
        if ((r110 instanceof String) == false) goto L56;
        Object r111 = r17.a((String) r110);
        if ((r111 instanceof rh.i) == false) goto L56;
        if (((rh.i) r111).e() == false) goto L56;
        r13.accept(new PiaMethod$Error(-10005));
        return;
    L56:
        rh.i r112 = new rh.i(r19);     // Catch: Throwable -> L44
        if (r17.f20231b.get() == false) goto L41;
        String r20 = null;
    L46:
        String r21 = r112.f21764i.toString();     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(r21) == false) goto L49;
        r21 = "javascript:" + r112.f21765j;     // Catch: Throwable -> L44
    L49:
        r17.b(r20, r21);     // Catch: Throwable -> L44
        ((Handler) com.bytedance.pia.core.utils.m.f7156b.getValue()).postDelayed(new androidx.room.f(new WeakReference(r17), 2, r20, r13), r15 * 1000);     // Catch: Throwable -> L44
        r112.f("!function(a){globalThis._pia_task_={params:a,callback:function(a){NativeModules.get(\"BaseModule\").terminateWithResult(a)}}}(" + r16 + ")");     // Catch: Throwable -> L44
        r112.h();     // Catch: Throwable -> L44
        r112.d.b(new m0());     // Catch: Throwable -> L44
        r112.c(new n0(0, r13, r112));     // Catch: Throwable -> L44
        return;
    L41:
        r20 = r112.hashCode() + String.valueOf(r17.hashCode());     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(r20) == true) goto L46;
        r17.f20232c.putIfAbsent(r20, r112);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        if ((th instanceof PiaMethod$Error) == false) goto L54;
        r13.accept(th);
        return;
    L54:
        r13.accept(new PiaMethod$Error(th.toString()));
        return;
    L21:
        if ((o0.d(r14) instanceof JsonNull) == true) goto L27;
        if ((o0.d(r14) instanceof JsonObject) == false) goto L26;
        r16 = (JsonObject) o0.d(r14);
        goto L28
    L26:
        td.b.c("Parameters 'params' must be an object!", r13);
        return;
    L12:
        if (o0.c(r14).longValue() >= 0) goto L14;
    L16:
        td.b.c("Parameter 'execute_time_limit' should be in range 0~600!", r13);
        return;
    L14:
        if (o0.c(r14).longValue() > 600) goto L16;
        r15 = o0.c(r14).longValue();
        goto L19
    L8:
        r5 = "RunTask";
        goto L10
    }
}
