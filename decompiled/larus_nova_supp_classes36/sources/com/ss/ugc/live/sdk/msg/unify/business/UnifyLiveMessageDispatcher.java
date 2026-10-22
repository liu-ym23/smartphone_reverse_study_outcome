package com.ss.ugc.live.sdk.msg.unify.business;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.live.sdk.msg.dispatch.e;
import com.ss.ugc.live.sdk.msg.dispatch.g;
import com.ss.ugc.live.sdk.msg.dispatch.h;
import com.ss.ugc.live.sdk.msg.dispatch.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.j;
import vlc.k;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UnifyLiveMessageDispatcher implements e, h, k, imc.c {
    public final List<tlc.d> a;
    public final List<vlc.b> b;
    public final List<j> c;
    public final SparseArray<Set<l>> d;
    public final HashMap<String, Set<l>> e;
    public final ulc.a f;
    public final k g;
    public int h;
    public final List<com.ss.ugc.live.sdk.msg.dispatch.a> i;
    public final Set<String> j;
    public final long k;
    public final long l;
    public final g m;
    public final com.ss.ugc.live.sdk.msg.dispatch.b n;
    public final i o;
    public final c p;
    public final HashMap<String, bmc.a> q;
    public final long r;
    public final com.ss.ugc.live.sdk.msg.unify.business.a s;
    public final vlc.c t;

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

    public final void j() {
        this.d.clear();
        this.e.clear();
        ((CopyOnWriteArrayList) this.c).clear();
        ((CopyOnWriteArrayList) this.b).clear();
        ((ArrayList) this.a).clear();
        ((HashMap) this.o.b).clear();
    }

    @Override // imc.c
    public final void a(hmc.b r2) {
        Intrinsics.checkNotNullParameter(r2, "decodePacket");
        Object r3 = r2.b;
        if ((r3 instanceof d) == true) goto L5;
        r3 = null;
    L5:
        d r4 = (d) r3;
        if (r4 == null) goto L11;
        List<tlc.d> r5 = r4.b;
        if (r5 == null) goto L12;
        c(r5);
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.ArrayList] */
    @Override // com.ss.ugc.live.sdk.msg.dispatch.e
    public final void c(List<? extends tlc.d> r12) {
        List<? extends tlc.d> r0 = r12;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return;
    L11:
        vlc.c r4 = this.t;
        StringBuilder r5 = new StringBuilder("dispatch unify message: [service: ");
        r5.append(this.s.f);
        r5.append(", method: ");
        r5.append(this.s.g);
        r5.append(", roomId: ");
        r5.append(this.r);
        r5.append("], messages: [");
        int r6 = com.ss.ugc.live.sdk.msg.utils.c.a;
        if (r12 == null) goto L17;
        List<? extends tlc.d> r7 = r12;
        ?? r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L15:
        if (r9.hasNext() == false) goto L18;
        tlc.d r10 = (tlc.d) r9.next();
        r8.add(r10.getMessageMethod() + ':' + r10.getGeneralMessageType() + ':' + r10.getMessageId());
    L18:
        r5.append(TextUtils.join(",", (Iterable) r8));
        r5.append(']');
        com.ss.ugc.live.sdk.msg.utils.a.c(r4, r5.toString());
        if (r0 != null) goto L21;
    L24:
        if (r1 == true) goto L29;
        this.p.obtainMessage(201, r12).sendToTarget();
        return;
    L29:
        return;
    L21:
        if (r0.isEmpty() == true) goto L24;
        r1 = false;
        goto L24
    L17:
        r8 = CollectionsKt.emptyList();
        goto L18
    L5:
        if (r0.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.ugc.live.sdk.msg.unify.business.UnifyLiveMessageDispatcher$dispatchMessage$1] */
    public final void h(final tlc.d r6) {
        ?? r0 = new UnifyLiveMessageDispatcher$dispatchMessage$1(this, r6);
        Set<l> r1 = this.d.get(r6.getIntType());
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
        Set<l> r7 = this.e.get(r6.getMessageMethod());
        Set<l> r8 = r7;
        if (r8 != null) goto L17;
    L18:
        r3 = true;
    L19:
        if (r3 == true) goto L24;
        Iterator<l> r9 = r7.iterator();
    L22:
        if (r9.hasNext() == false) goto L27;
        r0.invoke(r9.next());
        goto L22
    L27:
        return;
    L24:
        return;
    L17:
        if (r8.isEmpty() == false) goto L19;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }

    public final void m(l r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        int r0 = this.d.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        Set<l> r2 = this.d.valueAt(r1);
        if (r2 == null) goto L7;
        r2.remove(r4);
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        if ((!this.e.isEmpty()) == false) goto L14;
        Iterator<Map.Entry<String, Set<l>>> r3 = this.e.entrySet().iterator();
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
        this.n.b++;
        r6.setConsumeTime(System.currentTimeMillis());
        if (r6.isFromFirstRequest() == true) goto L22;
        Iterator r0 = ((CopyOnWriteArrayList) this.b).iterator();
    L7:
        if (r0.hasNext() == false) goto L22;
        vlc.b r1 = (vlc.b) r0.next();
        if (r1.onMessage(r6) == false) goto L7;
        Iterator r2 = ((CopyOnWriteArrayList) this.c).iterator();
    L12:
        if (r2.hasNext() == false) goto L21;
        j r3 = (j) r2.next();
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
        this.o.d(r6);
    L28:
        h(r6);
        return;
    L22:
        r7 = false;
        goto L23
    }

    public final void e(String r3, l r4) {
        Intrinsics.checkNotNullParameter(r3, "messageMethod");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Set<l> r0 = this.e.get(r3);
        if (r0 != null) goto L5;
        r0 = new CopyOnWriteArraySet();
        this.e.put(r3, r0);
    L5:
        r0.add(r4);
    }

    public final void i(tlc.d r3, boolean r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.setIsInsert(true);
        r3.setReceiveTime(System.currentTimeMillis());
        r3.setEnqueueDispatchTime(System.currentTimeMillis());
        if (r4 == false) goto L7;
        h(r3);
        return;
    L7:
        onMessage(r3);
    }

    public final void k(int r2, l r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Set<l> r4 = this.d.get(r2);
        Set<l> r0 = r4;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r4.remove(r3);
        return;
    L12:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void l(String r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "messageMethod");
        Intrinsics.checkNotNullParameter(r3, "listener");
        Set<l> r4 = this.e.get(r2);
        Set<l> r0 = r4;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r4.remove(r3);
        return;
    L12:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void n(boolean r3, int r4) {
        if (this.p.hasMessages(202) == false) goto L5;
        return;
    L5:
        Message r5 = this.p.obtainMessage(202, Integer.valueOf(r4));
        if (r3 == true) goto L8;
        this.p.sendMessage(r5);
        return;
    L8:
        this.p.sendMessageDelayed(r5, this.k);
    }

    public final void f(String r3, l r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (r3 == null) goto L14;
        Set<l> r0 = this.e.get(r3);
        if (r0 != null) goto L7;
        r0 = new CopyOnWriteArraySet();
        this.e.put(r3, r0);
    L7:
        r0.add(r4);
        Map<String, xlc.b> r1 = this.o.b;
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
        com.ss.ugc.live.sdk.msg.utils.a.c(this.t, "onMessageDuplicated, id: " + r10 + ", first from " + r12 + ", this from " + r13 + ", delay: " + r14);
        k r2 = this.g;
        if (r2 == null) goto L6;
        r2.b(r10, r12, r13, r14);
        return;
    }

    public final void d(int r3, l r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        Set<l> r0 = this.d.get(r3);
        if (r0 != null) goto L5;
        r0 = new CopyOnWriteArraySet();
        this.d.put(r3, r0);
    L5:
        r0.add(r4);
        if (r5 == false) goto L11;
        tlc.d r7 = this.o.c(r3, r6);
        if (r7 == null) goto L12;
        r4.onMessage(r7);
        return;
    L12:
        return;
    }

    public UnifyLiveMessageDispatcher(long r6, com.ss.ugc.live.sdk.msg.unify.business.a r8, st2.c r9, rt2.d r10, List r11) {
        Intrinsics.checkNotNullParameter(r8, "unifyBusinessConfig");
        Intrinsics.checkNotNullParameter(r9, "config");
        Intrinsics.checkNotNullParameter(r10, "unifyLogger");
        Intrinsics.checkNotNullParameter(r11, "plugins");
        this.r = r6;
        this.s = r8;
        this.t = r10;
        this.a = new ArrayList();
        CopyOnWriteArrayList r12 = new CopyOnWriteArrayList();
        this.b = r12;
        CopyOnWriteArrayList r0 = new CopyOnWriteArrayList();
        this.c = r0;
        this.d = new SparseArray();
        this.e = new HashMap();
        ulc.a r1 = new ulc.a(this, 512);
        this.f = r1;
        this.h = 1;
        List<com.ss.ugc.live.sdk.msg.dispatch.a> r2 = CollectionsKt.emptyList();
        if (r2 != null) goto L6;
        r2 = CollectionsKt.emptyList();
    L6:
        this.i = r2;
        Set<String> r3 = r9.c;
        if (r3 != null) goto L10;
        r3 = SetsKt.emptySet();
    L10:
        this.j = r3;
        this.k = 200;
        this.l = 1200;
        this.m = new b();
        this.n = new com.ss.ugc.live.sdk.msg.dispatch.b(false);
        i r4 = new i(r6, r10);
        this.o = r4;
        this.p = new c(this, Looper.getMainLooper());
        this.q = new HashMap();
        r12.add(r1);
        r12.add(r4);
        Collection r7 = r9.a;
        if (r7 != null) goto L14;
        r7 = CollectionsKt.emptyList();
    L14:
        r12.addAll(r7);
        Collection r13 = r9.b;
        if (r13 != null) goto L18;
        r13 = CollectionsKt.emptyList();
    L18:
        r0.addAll(r13);
        this.g = null;
        Iterator r14 = r11.iterator();
    L20:
        if (r14.hasNext() == false) goto L22;
        bmc.a r15 = (bmc.a) r14.next();
        d(r15.dB(), r15, false, null);
        this.q.put(r15.kM(), r15);
        goto L20
    }

    public static /* synthetic */ void g(UnifyLiveMessageDispatcher r0, int r1, l r2, boolean r3, int r4) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.d(r1, r2, r3, null);
    }
}
