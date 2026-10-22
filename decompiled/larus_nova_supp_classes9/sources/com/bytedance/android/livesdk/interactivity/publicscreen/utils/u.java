package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdk.interactivity.utils.PublicScreenMessageMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import ec2.r0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u implements s42.c {
    public static final List<s42.c> a = null;
    public static final u b = null;

    public u() {
    }

    static {
        b = new u();
        Boolean r0 = (Boolean) r0.a.getValue();
        ArrayList r1 = new ArrayList();
        a = r1;
        r1.add(TextMessageTracer.b);
        r1.add(t.b);
        r1.add(c.a);
        r1.add(PublicScreenMessageMonitor.y);
        r1.add(i.b);
        if (r0.booleanValue() == false) goto L5;
        r1.add(v.o);
    L5:
        r1.add(a.a);
    }

    @Override // s42.c
    public final void c() {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).c();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void i() {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).i();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void b(int r4) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).b(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void d(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        Iterator r0 = ((ArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).d(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void e(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).e(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void f(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).f(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void g(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).g(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void h(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).h(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void k(tlc.d r4) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).k(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void l(tlc.d r4) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).l(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void m(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).m(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void n(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).n(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void o(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        Iterator r0 = ((ArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).o(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void p(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        Iterator r0 = ((ArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).p(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void q(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).q(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void r(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).r(r4);     // Catch: RuntimeException -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void t(tlc.d r4) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).t(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void j(IWidget r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        Intrinsics.checkNotNullParameter(r5, "cause");
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).j(r4, r5);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void s(IWidget r4, IRoom r5, s42.c.b r6) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        Intrinsics.checkNotNullParameter(r5, "room");
        Iterator r0 = ((ArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).s(r4, r5, r6);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }

    @Override // s42.c
    public final void a(TextMessageWidget r9, IRoom r10, boolean r11, boolean r13, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m r14) {
        Intrinsics.checkNotNullParameter(r9, "widget");
        Intrinsics.checkNotNullParameter(r10, "room");
        Intrinsics.checkNotNullParameter(r14, "publicScreenData");
        Iterator r0 = ((ArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((s42.c) r0.next()).a(r9, r10, r11, r13, r14);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("TextMessageMonitor", e);
        goto L4
    }
}
