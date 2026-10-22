package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v implements s42.c {
    public static long a;
    public static long b;
    public static long c;
    public static long d;
    public static long e;
    public static long f;
    public static long g;
    public static long h;
    public static long i;
    public static long j;
    public static float k;
    public static long l;
    public static long m;
    public static long n;
    public static final v o = null;

    public v() {
    }

    @Override // s42.c
    public final void b(int r1) {
    }

    @Override // s42.c
    public final void d(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void e(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void f(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void h(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void k(tlc.d r1) {
    }

    @Override // s42.c
    public final void l(tlc.d r1) {
    }

    @Override // s42.c
    public final void n(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void o(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void p(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void q(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void r(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void t(tlc.d r1) {
    }

    static {
        o = new v();
    }

    public static void u() {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        j = 0;
        k = 0.0f;
        l = 0;
        m = 0;
        n = 0;
    }

    @Override // s42.c
    public final void i() {
        e += System.nanoTime() - d;
        f++;
    }

    @Override // s42.c
    public final void c() {
        d = System.nanoTime();
    }

    @Override // s42.c
    public final void g(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r7) {
        b += System.nanoTime() - a;
        c++;
    }

    @Override // s42.c
    public final void m(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r7) {
        a = System.nanoTime();
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.x == true) goto L12;
        r7.x = true;
        if (r7.w < r7.u) goto L13;
        m += ((System.nanoTime() - r7.w) + r7.u) - r7.t;
        n++;
        return;
    L13:
        return;
    }

    @Override // s42.c
    public final void j(IWidget r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "cause");
        s42.c.a.b(r2, r3);
    }

    @Override // s42.c
    public final void s(IWidget r8, IRoom r9, s42.c.b r10) {
        Intrinsics.checkNotNullParameter(r8, "widget");
        Intrinsics.checkNotNullParameter(r9, "room");
        Intrinsics.checkNotNullParameter(r8, "widget");
        Intrinsics.checkNotNullParameter(r9, "room");
        LinkedHashMap r11 = new LinkedHashMap();
        long r0 = b;
        long r2 = c;
        float r13 = 0.0f;
        if (r2 != 0) goto L5;
        float r1 = 0.0f;
    L6:
        r11.put("vhbind", String.valueOf(r1));
        r11.put("vhbind_cnt", String.valueOf(c));
        long r3 = e;
        long r4 = f;
        if (r4 != 0) goto L9;
        float r5 = 0.0f;
    L10:
        r11.put("vhcreate", String.valueOf(r5));
        r11.put("vhcreate_cnt", String.valueOf(f));
        long r6 = h;
        long r7 = i;
        if (r7 != 0) goto L13;
        float r14 = 0.0f;
    L14:
        r11.put("measure_time", String.valueOf(r14));
        r11.put("measure_cnt", String.valueOf(i));
        r11.put("layout_time", String.valueOf(k));
        r11.put("layout_cnt", String.valueOf(l));
        long r15 = m;
        long r16 = n;
        if (r16 == 0) goto L18;
        r13 = r15 / r16;
    L18:
        r11.put("before_bind", String.valueOf(r13));
        r11.put("before_bind_cnt", String.valueOf(n));
        r11.put("room_id", String.valueOf(r9.getId()));
        IMiddlewareUserService r17 = jc1.k.f(IMiddlewareUserService.class);
        if (r17 == null) goto L24;
        com.bytedance.android.livesdk.user.e r18 = r17.user();
        if (r18 == null) goto L24;
        String r19 = r18.n();
        if (r19 == null) goto L24;
    L25:
        r11.put("user_id", r19);
        j0.l().sendLog("ttlive_publicscreen_performance", r11, new Object[0]);
        u();
        return;
    L24:
        r19 = "0";
        goto L25
    L13:
        r14 = r6 / r7;
        goto L14
    L9:
        r5 = r3 / r4;
        goto L10
    L5:
        r1 = r0 / r2;
        goto L6
    }

    @Override // s42.c
    public final void a(TextMessageWidget r1, IRoom r2, boolean r3, boolean r4, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m r5) {
        Intrinsics.checkNotNullParameter(r1, "widget");
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r5, "publicScreenData");
        s42.c.a.a(r1, r2, r5);
        u();
    }
}
