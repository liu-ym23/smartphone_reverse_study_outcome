package com.ss.ugc.live.sdk.msg.dispatch;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.k;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class Dispatcher implements e, h, k, d {
    public static final /* synthetic */ int B = 0;
    public final /* synthetic */ d A;
    public final List<tlc.d> a;
    public final List<vlc.b> b;
    public final List<vlc.h> c;
    public final List<vlc.j> d;
    public final SparseArray<Set<l>> e;
    public final ConcurrentHashMap<String, Set<l>> f;
    public final ulc.a g;
    public final k h;
    public final long[] i;
    public int j;
    public int k;
    public final List<com.ss.ugc.live.sdk.msg.dispatch.a> l;
    public final Set<String> m;
    public final long n;
    public final long o;
    public final g p;
    public final com.ss.ugc.live.sdk.msg.dispatch.b q;
    public final i r;
    public final dmc.f s;
    public final c t;
    public final HashMap<String, bmc.a> u;
    public boolean v;
    public int w;
    public final LinkedList<tlc.d> x;
    public final List<tlc.d> y;
    public final com.ss.ugc.live.sdk.msg.c z;

    public static final class a {
    }

    public static final class b implements g {
        public b() {
        }

        @Override // com.ss.ugc.live.sdk.msg.dispatch.g
        public final int a(List<? extends tlc.d> r3, h r4) {
            Intrinsics.checkNotNullParameter(r3, "messages");
            Intrinsics.checkNotNullParameter(r4, "dispatcher");
            ArrayList r5 = (ArrayList) r3;
            Iterator r0 = r5.iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            r4.onMessage((tlc.d) r0.next());
            goto L4
        L7:
            return r5.size();
        }
    }

    static {
    }

    @Override // com.ss.ugc.live.sdk.msg.dispatch.d
    public final long a() {
        return this.A.a();
    }

    @Override // com.ss.ugc.live.sdk.msg.dispatch.d
    public final long d() {
        return this.A.d();
    }

    public final boolean k() {
        return this.z.isRunning();
    }

    @Override // com.ss.ugc.live.sdk.msg.dispatch.e
    public final void c(List<? extends tlc.d> r6) {
        List<? extends tlc.d> r0 = r6;
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return;
    L12:
        if (this.v == false) goto L14;
        h(r6);
        return;
    L14:
        tlc.d r3 = (tlc.d) CollectionsKt.firstOrNull(r6);
        if (r3 != null) goto L17;
    L19:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "receive not first request messages before can dispatch, size: " + r6.size());
        this.x.addAll(r6);
        if (this.w <= 0) goto L35;
        int r7 = this.x.size() - this.w;
        if (r7 <= 0) goto L36;
    L23:
        if (r1 >= r7) goto L28;
        if ((!this.x.isEmpty()) == false) goto L27;
        this.x.removeFirst();
    L27:
        r1 = r1 + 1;
        goto L23
    L28:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "buffer queue over size: " + this.w + ", remove " + r7 + " older messages");
        return;
    L36:
        return;
    L35:
        return;
    L17:
        if (r3.isFromFirstRequest() != true) goto L19;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "receive first request messages before can dispatch, size: " + r6.size());
        ((ArrayList) this.y).addAll(r6);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public final void h(List<? extends tlc.d> r3) {
        List<? extends tlc.d> r0 = r3;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        this.t.obtainMessage(201, r3).sendToTarget();
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.ugc.live.sdk.msg.dispatch.Dispatcher$dispatchMessage$1] */
    public final void i(final tlc.d r6) {
        ?? r0 = new Dispatcher$dispatchMessage$1(this, r6);
        Set<l> r1 = this.e.get(r6.getIntType());
        Set<l> r2 = r1;
        boolean r3 = false;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L14;
        Iterator<l> r5 = r1.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        r0.invoke(r5.next());
    L14:
        String r7 = r6.getMessageMethod();
        if (r7 == null) goto L17;
        Set<l> r8 = this.f.get(r7);
    L18:
        Set<l> r9 = r8;
        if (r9 != null) goto L21;
    L22:
        r3 = true;
    L23:
        if (r3 == true) goto L28;
        Iterator<l> r10 = r8.iterator();
    L26:
        if (r10.hasNext() == false) goto L28;
        r0.invoke(r10.next());
    L28:
        dmc.f r11 = this.s;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r6, INotificationHitPoint.NoticeType.MESSAGE);
        if (r11.a == false) goto L46;
        dmc.b r12 = r11.b;
        if (r12 == null) goto L45;
        Intrinsics.checkNotNullParameter(r6, INotificationHitPoint.NoticeType.MESSAGE);
        r12.a.addLast(r6);
        LinkedList<tlc.d> r13 = r12.b.get(Integer.valueOf(r6.getIntType()));
        if (r13 != null) goto L37;
        r13 = new LinkedList();
        r12.b.put(Integer.valueOf(r6.getIntType()), r13);
    L37:
        r13.addLast(r6);
        LinkedList<tlc.d> r14 = r12.c.get(r6.getMessageMethod());
        if (r14 != null) goto L41;
        r14 = new LinkedList();
        r12.c.put(r6.getMessageMethod(), r14);
    L41:
        r14.addLast(r6);
        r12.a();
        return;
    L45:
        return;
    L46:
        return;
    L21:
        if (r9.isEmpty() == false) goto L23;
    L17:
        r8 = null;
        goto L18
    L5:
        if (r2.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }

    public final void l(l r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        int r0 = this.e.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        Set<l> r2 = this.e.valueAt(r1);
        if (r2 == null) goto L7;
        r2.remove(r4);
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        if ((!this.f.isEmpty()) == false) goto L14;
        Iterator<Map.Entry<String, Set<l>>> r3 = this.f.entrySet().iterator();
    L12:
        if (r3.hasNext() == false) goto L19;
        r3.next().getValue().remove(r4);
        goto L12
    L19:
        return;
    }

    @Override // com.ss.ugc.live.sdk.msg.dispatch.h
    public final void onMessage(tlc.d r6) {
        Intrinsics.checkNotNullParameter(r6, INotificationHitPoint.NoticeType.MESSAGE);
        this.q.b++;
        r6.setConsumeTime(System.currentTimeMillis());
        if (r6.isFromFirstRequest() == true) goto L22;
        Iterator r0 = ((CopyOnWriteArrayList) this.b).iterator();
    L7:
        if (r0.hasNext() == false) goto L22;
        vlc.b r1 = (vlc.b) r0.next();
        if (r1.onMessage(r6) == false) goto L7;
        Iterator r2 = ((CopyOnWriteArrayList) this.d).iterator();
    L12:
        if (r2.hasNext() == false) goto L21;
        vlc.j r3 = (vlc.j) r2.next();
        if ((r1 instanceof ulc.b) == true) goto L16;
        vlc.b r4 = null;
    L17:
        ulc.b r5 = (ulc.b) r4;
        if (r5 == null) goto L20;
        r5.getName();
    L20:
        r3.I(r6);
        goto L12
    L16:
        r4 = r1;
        goto L17
    L21:
        boolean r7 = true;
    L23:
        if (r7 == false) goto L26;
        return;
    L26:
        if (com.ss.ugc.live.sdk.msg.utils.a.b(r6) == false) goto L28;
        this.r.d(r6);
    L28:
        i(r6);
        return;
    L22:
        r7 = false;
        goto L23
    }

    public final void f(String r3, l r4) {
        Intrinsics.checkNotNullParameter(r3, "messageMethod");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Set<l> r0 = this.f.get(r3);
        if (r0 != null) goto L5;
        r0 = new CopyOnWriteArraySet();
        this.f.put(r3, r0);
    L5:
        r0.add(r4);
    }

    public final void j(tlc.d r3, boolean r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.setIsInsert(true);
        r3.setReceiveTime(System.currentTimeMillis());
        r3.setEnqueueDispatchTime(System.currentTimeMillis());
        if (r4 == false) goto L7;
        i(r3);
        return;
    L7:
        onMessage(r3);
    }

    public final void m(boolean r3, int r4) {
        if (this.v == true) goto L6;
        return;
    L6:
        if (k() == true) goto L8;
        return;
    L8:
        if (this.t.hasMessages(202) == true) goto L17;
        Message r5 = this.t.obtainMessage(202, Integer.valueOf(r4));
        if (r3 == true) goto L13;
        this.t.removeMessages(202);
        this.t.sendMessage(r5);
        return;
    L13:
        this.t.sendMessageDelayed(r5, this.n);
        return;
    }

    public final void g(String r3, l r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (r3 == null) goto L14;
        Set<l> r0 = this.f.get(r3);
        if (r0 != null) goto L7;
        r0 = new CopyOnWriteArraySet();
        this.f.put(r3, r0);
    L7:
        r0.add(r4);
        Map<String, xlc.b> r1 = this.r.b;
        HashMap r2 = (HashMap) r1;
        Object r6 = r2.get(i.a(r3, r5));
        if ((r6 instanceof tlc.d) == true) goto L10;
        r6 = null;
    L10:
        tlc.d r7 = (tlc.d) r6;
        if (r7 == null) goto L15;
        r4.onMessage(r7);
        return;
    L15:
        return;
    }

    @Override // vlc.k
    public final void b(long r10, int r12, int r13, long r14) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "onMessageDuplicated, id: " + r10 + ", first from " + r12 + ", this from " + r13 + ", delay: " + r14);
        k r2 = this.h;
        if (r2 == null) goto L6;
        r2.b(r10, r12, r13, r14);
        return;
    }

    public final void e(int r3, l r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        Set<l> r0 = this.e.get(r3);
        if (r0 != null) goto L5;
        r0 = new CopyOnWriteArraySet();
        this.e.put(r3, r0);
    L5:
        r0.add(r4);
        if (r5 == false) goto L11;
        tlc.d r7 = this.r.c(r3, r6);
        if (r7 == null) goto L12;
        r4.onMessage(r7);
        return;
    L12:
        return;
    }

    public Dispatcher(long r7, com.ss.ugc.live.sdk.msg.c r9, amc.b r10, cmc.a r11, List r12) {
        Intrinsics.checkNotNullParameter(r9, "messageContext");
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "dispatcherInfo");
        Intrinsics.checkNotNullParameter(r12, "plugins");
        this.A = r11;
        this.z = r9;
        this.a = new ArrayList();
        CopyOnWriteArrayList r13 = new CopyOnWriteArrayList();
        this.b = r13;
        this.c = new CopyOnWriteArrayList();
        CopyOnWriteArrayList r0 = new CopyOnWriteArrayList();
        this.d = r0;
        this.e = new SparseArray();
        this.f = new ConcurrentHashMap();
        ulc.a r1 = new ulc.a(this, r10.j());
        this.g = r1;
        this.i = new long[5];
        this.k = 1;
        List<com.ss.ugc.live.sdk.msg.dispatch.a> r3 = r10.b();
        if (r3 != null) goto L6;
        r3 = CollectionsKt.emptyList();
    L6:
        this.l = r3;
        Set<String> r4 = r10.h();
        if (r4 != null) goto L10;
        r4 = SetsKt.emptySet();
    L10:
        this.m = r4;
        this.n = r10.a();
        this.o = r10.d();
        g r5 = r10.g();
        if (r5 == null) goto L13;
        g r6 = r5;
    L14:
        this.p = r6;
        if (r5 == null) goto L17;
        boolean r8 = true;
    L18:
        this.q = new com.ss.ugc.live.sdk.msg.dispatch.b(r8);
        i r14 = new i(r7, r9);
        this.r = r14;
        this.s = new dmc.f(r9);
        this.t = new c(this, Looper.getMainLooper());
        this.u = new HashMap();
        this.v = true;
        this.x = new LinkedList();
        this.y = new ArrayList();
        if (r10.c() == false) goto L21;
        r13.add(r1);
    L21:
        r13.add(r14);
        List<vlc.b> r15 = r10.getInterceptors();
        if (r15 != null) goto L25;
        r15 = CollectionsKt.emptyList();
    L25:
        r13.addAll(r15);
        List<vlc.j> r16 = r10.i();
        if (r16 != null) goto L29;
        r16 = CollectionsKt.emptyList();
    L29:
        r0.addAll(r16);
        this.h = r10.f();
        Iterator r17 = r12.iterator();
    L31:
        if (r17.hasNext() == false) goto L33;
        bmc.a r18 = (bmc.a) r17.next();
        e(r18.dB(), r18, false, null);
        this.u.put(r18.kM(), r18);
        goto L31
    L33:
        return;
    L17:
        r8 = false;
        goto L18
    L13:
        r6 = new b();
        goto L14
    }
}
