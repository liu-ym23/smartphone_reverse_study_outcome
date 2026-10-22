package com.bytedance.ies.bullet.service.webkit;

import android.content.Context;
import android.util.Pair;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.lynx.tasm.utils.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import ug.e;
import ym.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends tc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f6155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f6156c;
    public final k6.a d;

    public c(e r5, int r10) {
        if ((r10 & 2) == 0) goto L5;
        r5 = null;
    L5:
        this.f6155b = r5;
        this.f6156c = new AtomicBoolean(false);
        k6.a r11 = new k6.a();
        j r12 = new j();
        r12.f23302a = new com.lynx.tasm.utils.c(6);
        r11.f18623a = r12;
        this.d = r11;
    }

    public final void d(Context r10, k6.a r11) {
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("initWebX: " + r10 + ", " + r11, LogLevel.f5954b, "XWebKit");
        if (this.f6156c.get() == true) goto L51;
        this.f6156c.set(true);
        if (nk.b.f20269a != null) goto L8;
        nk.b.f20269a = r10.getApplicationContext();
        nk.b.f20270b = new t9.a();
    L8:
        b r12 = new b(this);
        HashMap r13 = nk.b.f20271c;
        List r14 = (List) r13.get("webx_webkit");
        if (r14 == null) goto L11;
    L21:
        Pair r15 = new Pair(sk.a.class, r12);
        monitor-enter(nk.b.class);
        r14.add(r15);     // Catch: Throwable -> L48
        monitor-exit(nk.b.class);     // Catch: Throwable -> L48
        Intrinsics.checkNotNullParameter(bd.b.class, "clazz");
        tc.c r16 = tc.c.f22119c;
        if (tc.c.f22119c.a(bd.b.class, this.f22117a) != null) goto L47;
        if (r11 != null) goto L30;
        r11 = null;
    L30:
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.web.WebKitServiceConfig");
        j r17 = (j) r11.f18623a;
        if (r17 == null) goto L59;
        ConcurrentHashMap r18 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.preload.c.class, "cls");
        if (((com.bytedance.ies.bullet.service.preload.c) yc.a.a(com.bytedance.ies.bullet.service.preload.c.class, "default_bid")) == null) goto L60;
        Intrinsics.checkNotNullParameter(r10, "application");
        Intrinsics.checkNotNullParameter(r17, "config");
        if (((com.lynx.tasm.utils.c) r17.f23302a) != null) goto L38;
        return;
    L38:
        if (k.f11181a != null) goto L40;
        z4.a r19 = new z4.a();
        r19.e = new Object();
        r19.f23390b = r10;
        r19.f23389a = new Object();
        r19.f23391c = new HashMap();
        k.f11181a = r19;
    L40:
        al.a r20 = new al.a();
        r20.f314b = new bd.d(r17);
        r20.f313a = 1;
        al.b r21 = new al.b(r20);
        z4.a r22 = k.f11181a;
        if (r22 == null) goto L56;
        HashMap r23 = (HashMap) r22.f23391c;
        if (r23.containsKey("webx_bullet") == true) goto L57;
        r23.put("webx_bullet", r21);
        return;
    L57:
        return;
    L56:
        return;
    L60:
        return;
    L59:
        return;
    L47:
        throw new ClassCastException();
    L48:
        th = move-exception;
        throw th;
    L11:
        monitor-enter(nk.b.class);
        r14 = (List) r13.get("webx_webkit");     // Catch: Throwable -> L15
        if (r14 != null) goto L17;
        r14 = new ArrayList();     // Catch: Throwable -> L15
        r13.put("webx_webkit", r14);     // Catch: Throwable -> L15
    L17:
        monitor-exit(nk.b.class);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}
