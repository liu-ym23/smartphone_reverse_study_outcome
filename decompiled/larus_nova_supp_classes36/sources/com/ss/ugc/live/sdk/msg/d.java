package com.ss.ugc.live.sdk.msg;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ugc.live.sdk.msg.dispatch.Dispatcher;
import com.ss.ugc.live.sdk.msg.network.WSState;
import com.ss.ugc.live.sdk.msg.network.k;
import com.ss.ugc.live.sdk.msg.utils.g;
import com.ss.ugc.live.sdk.msg.utils.i;
import com.ss.ugc.live.sdk.msg.utils.task.TaskState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vlc.f;
import vlc.h;
import vlc.j;
import vlc.l;
import vlc.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class d implements vlc.e, b, xlc.a, dmc.a, f {
    public final vlc.c a;
    public final b b;
    public final com.ss.ugc.live.sdk.msg.utils.task.c c;
    public final amc.c d;
    public final MessageState e;
    public final c f;
    public final WSState g;
    public final cmc.a h;
    public final cmc.c i;
    public final ArrayList<cmc.b<?>> j;
    public final cmc.e k;
    public final Dispatcher l;
    public final lmc.a m;
    public final amc.e n;
    public final List<bmc.a> o;

    public static final class a implements amc.c {
        public a() {
        }

        @Override // amc.c
        public final boolean f() {
            return false;
        }
    }

    @Override // vlc.f
    public final boolean c() {
        return this.g.c();
    }

    @Override // vlc.e
    public final boolean isPaused() {
        return Intrinsics.areEqual(this.e.a.b(), MessageState.c.C0204c.a);
    }

    @Override // vlc.e
    public final boolean isRunning() {
        return this.e.isRunning();
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public final void onInit() {
        b r0 = this.b;
        if (r0 == null) goto L5;
        r0.onInit();
    L5:
        Iterator<T> r1 = this.j.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((cmc.b) r1.next()).onInit();
        goto L7
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public final void onRelease() {
        b r0 = this.b;
        if (r0 == null) goto L5;
        r0.onRelease();
    L5:
        Iterator<cmc.b<?>> r1 = this.j.iterator();
    L6:
        Looper r2 = null;
        if (r1.hasNext() == false) goto L9;
        cmc.b<?> r3 = r1.next();
        r3.a = null;
        r3.onRelease();
        goto L6
    L9:
        com.ss.ugc.live.sdk.msg.utils.task.c r4 = this.c;
        r4.getClass();
        boolean r5 = true;
        r4.c.clear();     // Catch: Throwable -> L46
        com.ss.ugc.live.sdk.msg.utils.task.c.a r6 = r4.b.getAndSet(null);     // Catch: Throwable -> L46
        if (r6 == null) goto L15;
        TaskState<?, ?, com.ss.ugc.live.sdk.msg.utils.task.b<?, ?>> r7 = r6.b.a;     // Catch: Throwable -> L46
        int r8 = g.a;     // Catch: Throwable -> L46
        g.b r9 = g.a.a(new Throwable("Task cancel"));     // Catch: Throwable -> L46
        r7.getClass();     // Catch: Throwable -> L46
        Intrinsics.checkNotNullParameter(r9, "result");     // Catch: Throwable -> L46
        r7.d.d(new TaskState.a.C0233a(r9));     // Catch: Throwable -> L46
        Future<?> r10 = r6.a;     // Catch: Throwable -> L46
        if (r10 == null) goto L15;
        r10.cancel(true);     // Catch: Throwable -> L46
    L15:
        cmc.a r11 = this.h;
        r11.g.removeCallbacksAndMessages(null);
        r11.h.removeCallbacksAndMessages(null);
        r11.g.sendMessage(r11.g.obtainMessage(2106, "release"));
        this.i.g.removeCallbacksAndMessages(null);
        this.k.g.removeCallbacksAndMessages(null);
        lmc.a r12 = this.m;
        if (r12 == null) goto L33;
        com.ss.ugc.live.sdk.msg.utils.a.c(r12.l, "uplink release");
        r12.i.f();
        i r13 = r12.c;
        if (r13 == null) goto L20;
        r13.removeCallbacksAndMessages(null);
    L20:
        i r14 = r12.d;
        if (r14 == null) goto L23;
        r14.removeCallbacksAndMessages(null);
    L23:
        i r15 = r12.e;
        if (r15 == null) goto L26;
        r15.removeCallbacksAndMessages(null);
    L26:
        lmc.c r16 = r12.b;
        if (r16 == null) goto L29;
        r2 = r16.getLooper();
    L29:
        if (r2 == null) goto L33;
        i r17 = r12.e;
        if (r17 == null) goto L33;
        r17.sendEmptyMessage(lmc.a.p);
    L33:
        this.n.b().e();
        Dispatcher r18 = this.l;
        com.ss.ugc.live.sdk.msg.dispatch.b r19 = r18.q;
        c r20 = r18.z;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "monitor");
        if (r19.a == 0) goto L41;
        JSONObject r21 = new JSONObject();
        if (r19.b >= r19.a) goto L40;
        r5 = false;
    L40:
        r21.put("all_dispatched", r5);
        r21.put("use_dispatch_delegate", r19.c);
        JSONObject r22 = new JSONObject();
        r22.put("dispatch_rate", Float.valueOf(r19.b / r19.a));
        r22.put("receive_count", r19.a);
        r22.put("dispatch_count", r19.b);
        r22.put("remain_count", r19.a - r19.b);
        r20.e("msg_dispatch_status_all", r21, r22, new JSONObject());
    L41:
        r18.e.clear();
        r18.f.clear();
        ((ArrayList) r18.y).clear();
        r18.x.clear();
        ((CopyOnWriteArrayList) r18.c).clear();
        ((CopyOnWriteArrayList) r18.d).clear();
        ((CopyOnWriteArrayList) r18.b).clear();
        ((ArrayList) r18.a).clear();
        ((HashMap) r18.r.b).clear();
        dmc.f r23 = r18.s;
        r23.t();
        dmc.b r24 = r23.b;
        if (r24 == null) goto L44;
        r24.a.clear();
    L44:
        r23.c.clear();
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public final void onResume() {
        b r0 = this.b;
        if (r0 == null) goto L5;
        r0.onResume();
    L5:
        Iterator<cmc.b<?>> r1 = this.j.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().onResume();
        goto L7
    L9:
        this.h.h.obtainMessage(2101).sendToTarget();
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Thread, lmc.c] */
    @Override // com.ss.ugc.live.sdk.msg.b
    public final void onStart() {
        b r0 = this.b;
        if (r0 == null) goto L5;
        r0.onStart();
    L5:
        Iterator<cmc.b<?>> r1 = this.j.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().onStart();
        goto L7
    L9:
        this.h.h.obtainMessage(2101).sendToTarget();
        lmc.a r2 = this.m;
        if (r2 == null) goto L14;
        com.ss.ugc.live.sdk.msg.utils.a.c(r2.l, "uplink client start");
        r2.i.h(r2);
        ?? r3 = new lmc.c(r2);
        ThreadMethodProxy.start(r3);
        Unit r4 = Unit.INSTANCE;
        r2.b = r3;
        return;
    }

    @Override // vlc.d
    public final void release() {
        this.e.a.d(MessageState.a.c.a);
    }

    @Override // vlc.d
    public final void startMessage() {
        if (Intrinsics.areEqual(this.e.a.b(), MessageState.c.C0204c.a) == false) goto L5;
        this.e.a.d(MessageState.a.d.a);
        return;
    L5:
        this.e.a.d(MessageState.a.e.a);
    }

    @Override // dmc.a
    public final void t() {
        this.l.s.t();
    }

    @Override // vlc.e
    public final amc.e q() {
        return this.n;
    }

    @Override // vlc.d
    public final void B(tlc.d r3) {
        if (r3 == null) goto L5;
        this.l.j(r3, false);
        return;
    }

    @Override // dmc.a
    public final void C(dmc.e r6) {
        if (r6 == null) goto L27;
        Dispatcher r0 = this.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "replayMessageListener");
        Iterator<T> r1 = r6.a.iterator();
    L5:
        if (r1.hasNext() == false) goto L7;
        r0.e(((Number) r1.next()).intValue(), r6, false, null);
        goto L5
    L7:
        Iterator<T> r2 = r6.b.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        r0.f((String) r2.next(), r6);
        goto L9
    L11:
        r0.s.C(r6);
        dmc.f r7 = r0.s;
        if (r7.a == false) goto L21;
        dmc.b r8 = r7.b;
        if (r8 == null) goto L21;
        if (r8.a.size() <= 0) goto L18;
        boolean r9 = true;
    L19:
        if (r9 != true) goto L21;
        boolean r10 = true;
    L22:
        if (r10 == false) goto L28;
        r0.m(true, 0);
        return;
    L28:
        return;
    L18:
        r9 = false;
    L21:
        r10 = false;
        goto L22
    }

    @Override // vlc.d
    public final void F(h r3) {
        if (r3 == null) goto L5;
        Dispatcher r0 = this.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "requestMessageListener");
        ((CopyOnWriteArrayList) r0.c).remove(r3);
        return;
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public final void a(boolean r4) {
        b r0 = this.b;
        if (r0 == null) goto L5;
        r0.a(r4);
    L5:
        Iterator<cmc.b<?>> r1 = this.j.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().a(r4);
        goto L7
    L9:
        this.h.h.obtainMessage(2102, Boolean.valueOf(r4)).sendToTarget();
        Dispatcher r2 = this.l;
        r2.t.removeCallbacksAndMessages(null);
        if (r4 == false) goto L14;
        ulc.a r5 = r2.g;
        r5.b.clear();
        r5.c.clear();
        ((HashMap) r2.r.b).clear();
        return;
    }

    @Override // vlc.d
    public final void h(vlc.b r3) {
        if (r3 == null) goto L5;
        Dispatcher r0 = this.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "interceptor");
        ((CopyOnWriteArrayList) r0.b).add(r3);
        return;
    }

    @Override // vlc.d
    public final void k(j r3) {
        if (r3 == null) goto L5;
        Dispatcher r0 = this.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((CopyOnWriteArrayList) r0.d).add(r3);
        return;
    }

    @Override // xlc.a
    public final tlc.d l(String r3) {
        com.ss.ugc.live.sdk.msg.dispatch.i r0 = this.l.r;
        Object r1 = null;
        if (r3 == null) goto L9;
        Map<String, xlc.b> r2 = r0.b;
        HashMap r4 = (HashMap) r2;
        Object r5 = r4.get(com.ss.ugc.live.sdk.msg.dispatch.i.a(r3, null));
        if ((r5 instanceof tlc.d) == false) goto L11;
        r1 = r5;
    L11:
        return (tlc.d) r1;
    L9:
        r0.getClass();
        return null;
    }

    @Override // vlc.d
    public final void n(h r3) {
        if (r3 == null) goto L5;
        Dispatcher r0 = this.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "requestMessageListener");
        ((CopyOnWriteArrayList) r0.c).add(r3);
        return;
    }

    @Override // dmc.a
    public final void o(dmc.e r3) {
        if (r3 == null) goto L5;
        Dispatcher r0 = this.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "replayMessageListener");
        r0.l(r3);
        r0.s.getClass();
        return;
    }

    @Override // vlc.f
    public final void p(n r2) {
        this.h.f = r2;
    }

    @Override // vlc.d
    public final void r(boolean r3) {
        this.e.a.d(new MessageState.a.b(r3));
    }

    @Override // vlc.d
    public final void removeMessageListener(l r2) {
        if (r2 == null) goto L5;
        this.l.l(r2);
        return;
    }

    @Override // dmc.a
    public final void s(dmc.c r3) {
        Intrinsics.checkNotNullParameter(r3, "replayBufferConfig");
        Dispatcher r1 = this.l;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "replayBufferConfig");
        r1.s.s(r3);
    }

    @Override // xlc.a
    public final tlc.d u(int r3) {
        return this.l.r.c(r3, null);
    }

    @Override // vlc.d
    public final void v(j r3) {
        if (r3 == null) goto L5;
        Dispatcher r0 = this.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((CopyOnWriteArrayList) r0.d).remove(r3);
        return;
    }

    @Override // vlc.f
    public final boolean w(tlc.f r3) {
        Intrinsics.checkNotNullParameter(r3, "payloadItem");
        if (c() == false) goto L14;
        WSState r1 = this.g;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "payloadItem");
        if (r1.c() == false) goto L13;
        k r0 = r1.a;
        if ((r0 instanceof com.ss.ugc.live.sdk.msg.network.j) == true) goto L10;
        r0 = null;
    L10:
        com.ss.ugc.live.sdk.msg.network.j r2 = (com.ss.ugc.live.sdk.msg.network.j) r0;
        if (r2 == null) goto L13;
        r2.b(r3);
    L13:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(amc.e r19, List<? extends bmc.a> r20) {
        Intrinsics.checkNotNullParameter(r19, "config");
        Intrinsics.checkNotNullParameter(r20, "plugins");
        this.n = r19;
        this.o = r20;
        vlc.c r15 = r19.getLogger();
        this.a = r15;
        bc2.e r16 = r19.getMonitor();
        this.b = r19.c();
        com.ss.ugc.live.sdk.msg.utils.task.c r13 = new com.ss.ugc.live.sdk.msg.utils.task.c(r19.g().a);
        this.c = r13;
        lmc.a r17 = null;
        if ((r19 instanceof amc.c) == true) goto L5;
        amc.e r2 = null;
    L6:
        amc.c r3 = (amc.c) r2;
        if (r3 != null) goto L10;
        r3 = new a();
    L10:
        amc.c r14 = r3;
        this.d = r14;
        MessageState r7 = new MessageState(this, r15);
        this.e = r7;
        c r6 = new c(r15, r16, r7, r13, r14);
        this.f = r6;
        com.ss.ugc.live.sdk.msg.network.l r4 = r19.getNetworkConfig().f();
        if (r4 != null) goto L14;
        r4 = new com.ss.ugc.live.sdk.msg.network.a();
    L14:
        WSState r9 = new WSState(r4);
        this.g = r9;
        cmc.a r10 = new cmc.a(this.f, this.g, r19.getNetworkConfig(), this.o);
        this.h = r10;
        this.i = new cmc.c(this.f, r19.getNetworkConfig());
        ArrayList<cmc.b<?>> r11 = new ArrayList();
        List<cmc.b<?>> r5 = r19.e();
        if (r5 != null) goto L18;
        r5 = CollectionsKt.emptyList();
    L18:
        r11.addAll(r5);
        Unit r8 = Unit.INSTANCE;
        this.j = r11;
        this.k = new cmc.e(this.f, r19.getNetworkConfig());
        Dispatcher r12 = new Dispatcher(r19.getRoomId(), r6, r19.b(), r10, r20);
        this.l = r12;
        lmc.h r18 = r19.d().c();
        if (r18 == null) goto L21;
        lmc.h r21 = r18;
    L23:
        if (r19.d().enable() == false) goto L25;
        r17 = new lmc.a(r19.d(), r21, r19.getNetworkConfig().d(), r16, r15);
    L25:
        this.m = r17;
        r7.a.d(MessageState.a.C0202a.a);
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r6.b = r12;
        Iterator<cmc.b<?>> r1 = r11.iterator();
    L27:
        if (r1.hasNext() == false) goto L29;
        cmc.b<?> r22 = r1.next();
        c r23 = this.f;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "messageContext");
        r22.a = r23;
        goto L27
    L29:
        return;
    L21:
        r21 = r9;
        goto L23
    L5:
        r2 = r19;
        goto L6
    }

    @Override // vlc.e
    public final void E(tlc.a r4, vlc.i r5) {
        Intrinsics.checkNotNullParameter(r4, "fetchParams");
        tlc.b r0 = new tlc.b(r4, r5);
        if (this.d.f() == false) goto L5;
        cmc.c r6 = this.i;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "request");
        r6.g.obtainMessage(10001, r0).sendToTarget();
        return;
    L5:
        c r7 = this.f;
        if (r7.e == true) goto L8;
    L10:
        cmc.c r8 = this.i;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "request");
        r8.g.obtainMessage(10001, r0).sendToTarget();
        return;
    L8:
        if (Intrinsics.areEqual(r7.a, r7.c) == false) goto L10;
    }

    @Override // vlc.e
    public final void G(tlc.e r4, r42.c.a r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "listener");
        cmc.e r1 = this.k;
        tlc.g r2 = new tlc.g(r5);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r2, "request");
        r1.e = r2.a;
        r1.f = r4;
        r1.g.obtainMessage(19873).sendToTarget();
    }

    @Override // xlc.a
    public final tlc.d H(int r2, String r3) {
        return this.l.r.c(r2, r3);
    }

    @Override // vlc.d
    public final void addMessageListener(int r4, l r5) {
        if (r5 == null) goto L5;
        Dispatcher r0 = this.l;
        int r1 = Dispatcher.B;
        r0.e(r4, r5, false, null);
        return;
    }

    @Override // xlc.a
    public final tlc.d e(String r3, String r4) {
        com.ss.ugc.live.sdk.msg.dispatch.i r0 = this.l.r;
        Object r1 = null;
        if (r3 == null) goto L9;
        Map<String, xlc.b> r2 = r0.b;
        HashMap r5 = (HashMap) r2;
        Object r6 = r5.get(com.ss.ugc.live.sdk.msg.dispatch.i.a(r3, r4));
        if ((r6 instanceof tlc.d) == false) goto L11;
        r1 = r6;
    L11:
        return (tlc.d) r1;
    L9:
        r0.getClass();
        return null;
    }

    @Override // xlc.a
    public final void g(String r3, l r4) {
        if (r4 == null) goto L5;
        this.l.g(r3, r4, null);
        return;
    }

    @Override // vlc.d
    public final void j(tlc.d r2, boolean r3) {
        if (r2 == null) goto L5;
        this.l.j(r2, r3);
        return;
    }

    @Override // vlc.d
    public final void removeMessageListener(String r3, l r4) {
        if (r3 == null) goto L14;
        if (r4 == null) goto L15;
        Dispatcher r0 = this.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "messageMethod");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Set<l> r5 = r0.f.get(r3);
        Set<l> r1 = r5;
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L16;
        r5.remove(r4);
        return;
    L16:
        return;
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
        goto L11
    L15:
        return;
    }

    @Override // xlc.a
    public final void y(int r4, l r5) {
        if (r5 == null) goto L5;
        this.l.e(r4, r5, true, null);
        return;
    }

    @Override // vlc.d
    public final void addMessageListener(String r2, l r3) {
        if (r2 == null) goto L6;
        if (r3 == null) goto L7;
        this.l.f(r2, r3);
        return;
    L7:
        return;
    }

    @Override // vlc.d
    public final void removeMessageListener(int r3, l r4) {
        if (r4 == null) goto L13;
        Dispatcher r0 = this.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "listener");
        Set<l> r5 = r0.e.get(r3);
        Set<l> r1 = r5;
        if (r1 != null) goto L6;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L14;
        r5.remove(r4);
        return;
    L14:
        return;
    L6:
        if (r1.isEmpty() == true) goto L9;
        r2 = false;
        goto L10
    }

    @Override // xlc.a
    public final void D(int r3, l r4, String r5) {
        if (r4 == null) goto L5;
        this.l.e(r3, r4, true, r5);
        return;
    }

    @Override // xlc.a
    public final void i(String r2, l r3, String r4) {
        if (r3 == null) goto L5;
        this.l.g(r2, r3, r4);
        return;
    }

    @Override // vlc.e
    public final void z(long r2, com.ss.ugc.live.sdk.msg.network.f r4, ac2.f.a r5) {
        if (r4 == null) goto L7;
        lmc.a r0 = this.m;
        if (r0 == null) goto L8;
        r0.f(r2, r4, r5);
        return;
    L8:
        return;
    }
}
