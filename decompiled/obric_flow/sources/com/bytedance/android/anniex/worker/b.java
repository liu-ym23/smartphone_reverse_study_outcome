package com.bytedance.android.anniex.worker;

import android.app.Application;
import android.os.Handler;
import com.airbnb.lottie.k;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.x;
import h.f;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f3506b = null;

    static {
        f3505a = new b();
        f3506b = LazyKt.lazy(AnnieXJSWorkerManager$handler$2.f3503a);
    }

    public static Boolean a() {
        tc.c r5 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r10 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r10 != null) goto L5;
        return null;
    L5:
        if (((com.bytedance.ies.bullet.service.base.d) r10.f6163b.getValue()) != null) goto L7;
        return null;
    L7:
        return Boolean.FALSE;
    }

    public static void c(KitType r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r5, "kitType");
        if (Intrinsics.areEqual(a(), Boolean.FALSE) == false) goto L5;
        return;
    L5:
        f.b(new k(r5, r10, r11), f.g);
    }

    public static final void d(String r5, HashMap r10) {
        tc.c r11 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r12 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r12 == null) goto L5;
        com.bytedance.ies.bullet.service.base.d r13 = (com.bytedance.ies.bullet.service.base.d) r12.f6163b.getValue();
    L6:
        if (r13 != null) goto L8;
        return;
    L8:
        if (true != r13.f5967i) goto L14;
        i r14 = (i) fj.a.a(tc.c.f22119c, i.class, i.class);
        if (r14 == null) goto L15;
        x r15 = new x(r5);
        JSONObject r16 = new JSONObject(r10);
        r16.put("is_worker_ready", false);
        r15.e = r16;
        ((com.bytedance.ies.bullet.service.monitor.i) r14).d(r15);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r13 = null;
        goto L6
    }

    public final synchronized void b(Application r5, String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "context");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r10, "url");     // Catch: Throwable -> L6
        tc.c r11 = tc.c.f22119c;     // Catch: Throwable -> L6
        com.bytedance.ies.bullet.settings.b r12 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);     // Catch: Throwable -> L6
        if (r12 == null) goto L8;
        com.bytedance.ies.bullet.service.base.d r13 = (com.bytedance.ies.bullet.service.base.d) r12.f6163b.getValue();     // Catch: Throwable -> L6
    L8:
        ConcurrentHashMap r14 = yc.a.f23246a;     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(e.class, "cls");     // Catch: Throwable -> L6
        e r15 = (e) yc.a.a(e.class, "default_bid");     // Catch: Throwable -> L6
        if (r15 == null) goto L13;
        xc.d r16 = (xc.d) r15.a(xc.d.class);     // Catch: Throwable -> L6
        if (r16 == null) goto L13;
        boolean r17 = r16.o();     // Catch: Throwable -> L6
    L14:
        if (r17 == false) goto L18;
        ((Handler) f3506b.getValue()).post(new a(0));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L18:
        monitor-exit(this);
        return;
    L13:
        r17 = true;
    L6:
        th = move-exception;
        throw th;
    }
}
