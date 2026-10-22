package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class a {
    public final RunnableC0023a a;
    public com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b b;
    public boolean c;
    public final Deque<com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b> d;
    public final List<com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b> e;
    public final b f;
    public final Handler g;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a$a, reason: collision with other inner class name */
    public final class RunnableC0023a implements Runnable {
        public final /* synthetic */ a a;

        @Override // java.lang.Runnable
        public final void run() {
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        L20:
            return;
        L3:
            if (this.a.d.isEmpty() == true) goto L14;
            a r0 = this.a;     // Catch: Throwable -> L11
            if (r0.c == true) goto L18;
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r1 = (com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b) ((LinkedList) r0.d).pollFirst();     // Catch: Throwable -> L11
            this.a.b = r1;     // Catch: Throwable -> L11
            if (r1 == null) goto L19;
            r1.a();     // Catch: Throwable -> L11
            return;
        L19:
            return;
        L18:
            return;
        }

        public RunnableC0023a(a r1) {
            this.a = r1;
        }
    }

    public static final class b implements q {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.q
        public final void a(com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r2) {
            Intrinsics.checkNotNullParameter(r2, "task");
            ((ArrayList) this.a.e).add(r2);
            this.a.c = true;
        }

        @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.q
        public final void b(com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r3) {
            Intrinsics.checkNotNullParameter(r3, "task");
            a r0 = this.a;
            r0.c = false;
            ((ArrayList) r0.e).remove(r3);
            a r4 = this.a;
            r4.g.removeCallbacks(r4.a);
            a r5 = this.a;
            r5.g.post(r5.a);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b b;
        public final /* synthetic */ boolean c;

        public c(a r1, com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r0 = (com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b) ((LinkedList) this.a.d).peekLast();
            Object r1 = null;
            if (r0 == null) goto L5;
            Class<?> r2 = r0.getClass();
        L6:
            boolean r3 = true;
            if (Intrinsics.areEqual(r2, this.b.getClass()) == true) goto L9;
        L11:
            boolean r4 = false;
        L12:
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r5 = this.a.b;
            if (r5 == null) goto L15;
            Class<?> r6 = r5.getClass();
        L17:
            if (Intrinsics.areEqual(r6, this.b.getClass()) == false) goto L24;
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r7 = this.a.b;
            if (r7 == null) goto L22;
            r1 = r7.c;
        L22:
            if (Intrinsics.areEqual(r1, this.b.c) == false) goto L24;
            boolean r8 = true;
        L25:
            a r9 = this.a;
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r10 = this.b;
            Iterator r11 = ((ArrayList) r9.e).iterator();
        L27:
            if (r11.hasNext() == false) goto L35;
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r12 = (com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b) r11.next();
            if (Intrinsics.areEqual(r12.getClass(), r10.getClass()) == false) goto L27;
            if (r12.b == false) goto L27;
            if (Intrinsics.areEqual(r12.c, r10.c) == false) goto L27;
            boolean r13 = true;
        L36:
            n.d("AnimationExecutor#execute.processing:" + this.a.c + ",force:" + this.c + ",isLastSame:" + r4 + ",isFirstSame:" + r8 + ",task:" + this.b + ",alreadyPlay," + r13 + "curTask:" + this.a.b + ",lastTaskInQueue:" + r0);
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r14 = this.b;
            if ((r14 instanceof RequestSongMicSeatView.UpdateScoreTask) == true) goto L42;
            if (r4 == true) goto L43;
            if (r8 == true) goto L43;
            if (r13 == false) goto L42;
        L43:
            if (r3 == false) goto L45;
            return;
        L45:
            ((LinkedList) this.a.d).add(r14);
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r15 = this.b;
            a r16 = this.a;
            r15.a = r16.f;
            if (r16.c == true) goto L48;
        L49:
            r16.g.removeCallbacks(r16.a);
            a r17 = this.a;
            r17.g.post(r17.a);
            return;
        L48:
            if (this.c == true) goto L49;
            return;
        L42:
            r3 = false;
            goto L43
        L35:
            r13 = false;
        L24:
            r8 = false;
            goto L25
        L15:
            r6 = null;
            goto L17
        L9:
            if (Intrinsics.areEqual(r0.c, this.b.c) == false) goto L11;
            r4 = true;
            goto L12
        L5:
            r2 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public void a() {
        ((LinkedList) this.d).clear();
        this.c = false;
        Iterator r1 = ((ArrayList) this.e).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b) r1.next()).b = false;
        goto L4
    L6:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r2 = this.b;
        if (r2 == null) goto L9;
        r2.b = false;
    L9:
        this.b = null;
    }

    public a(Handler r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.g = r2;
        this.a = new RunnableC0023a(this);
        this.d = new LinkedList();
        this.e = new ArrayList();
        this.f = new b(this);
    }

    public void b(com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r3, long r4, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "task");
        this.g.postDelayed(new c(this, r3, r6), r4);
    }

    public static /* synthetic */ void c(a r2, com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r3, boolean r4, int r5) {
        if ((r5 & 4) == 0) goto L5;
        r4 = false;
    L5:
        r2.b(r3, 0, r4);
    }
}
