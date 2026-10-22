package com.ss.android.lark.flow.chat.statistics.perf;

import android.os.SystemClock;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import mkb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements mkb.a, com.ss.android.lark.statistics.perf.a {
    public static final a a = null;
    public static final AtomicBoolean b = null;
    public static final ConcurrentHashMap<String, C0039a> c = null;
    public static final ConcurrentHashMap<String, b> d = null;
    public static final ConcurrentHashMap<String, b> e = null;
    public static final ConcurrentHashMap<String, b> f = null;
    public static final c g = null;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.statistics.perf.a$a, reason: collision with other inner class name */
    public static final class C0039a {
        public final long a;
        public final String b;
        public final int c;
        public volatile boolean d;
        public volatile boolean e;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0039a) == true) goto L8;
            return false;
        L8:
            C0039a r9 = (C0039a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c) * 31;
            int r2 = 1231;
            if (this.d == false) goto L5;
            int r3 = 1231;
        L6:
            int r4 = (r1 + r3) * 31;
            if (this.e == true) goto L11;
            r2 = 1237;
        L11:
            return r4 + r2;
        L5:
            r3 = 1237;
            goto L6
        }

        public final String toString() {
            return "PendingStart(tSendStart=" + this.a + ", chatId=" + this.b + ", chatType=" + this.c + ", hasEnterBackground=" + this.d + ", hasPageInvisible=" + this.e + ')';
        }

        public C0039a(long r2, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "chatId");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = false;
            this.e = false;
        }
    }

    public static final class b {
        public final String a;
        public final int b;
        public final String c;
        public final long d;
        public final long e;
        public String f;
        public String g;
        public long h;
        public long i;
        public volatile boolean j;
        public volatile boolean k;

        public b(String r2, String r3, int r4, String r5, long r6, long r8, boolean r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "chatId");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r8;
            this.f = null;
            this.g = null;
            this.h = 0;
            this.i = 0;
            this.j = r10;
            this.k = r11;
        }
    }

    public static final class c implements okb.a.b {
        public c() {
        }

        @Override // okb.a.b
        public final void a() {
            Iterator<T> r0 = a.c.values().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((C0039a) r0.next()).d = true;
            goto L4
        L6:
            Iterator r1 = SequencesKt.sequence(new DoubaoReplyLatencyTracker$markAllInFlightBackground$2(null)).iterator();
        L8:
            if (r1.hasNext() == false) goto L10;
            ((b) r1.next()).j = true;
            goto L8
        }
    }

    public a() {
    }

    @Override // mkb.a
    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "contextId");
        Intrinsics.checkNotNullParameter(r3, "cId");
    }

    static {
        a = new a();
        b = new AtomicBoolean(false);
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = new c();
    }

    @JvmStatic
    public static final void g() {
        if (b.compareAndSet(false, true) == false) goto L12;
        a r0 = a;
        CopyOnWriteArrayList<mkb.a> r1 = d.a;
        Intrinsics.checkNotNullParameter(r0, "listener");
        CopyOnWriteArrayList<mkb.a> r2 = d.a;
        if (r2.contains(r0) == true) goto L7;
        r2.add(r0);
    L7:
        CopyOnWriteArrayList r3 = com.ss.android.lark.statistics.perf.b.a;
        Intrinsics.checkNotNullParameter(r0, "listener");
        CopyOnWriteArrayList r4 = com.ss.android.lark.statistics.perf.b.a;
        if (r4.contains(r0) == true) goto L10;
        r4.add(r0);
    L10:
        ImSdkProxy.b().d(g);
        return;
    }

    @Override // mkb.a
    public final void f(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        d.remove(r2);
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // mkb.a
    public final void a(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "cId");
        Intrinsics.checkNotNullParameter(r3, "serverId");
        b r5 = d.remove(r2);
        if (r5 != null) goto L5;
        return;
    L5:
        r5.f = r3;
        r5.h = r4;
        e.put(r3, r5);
    }

    public final void b(String r3, MessageInfo r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r4, "messageInfo");
        Message r6 = r4.getMessage();
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.getType() == Message.Type.DOUBAO) goto L8;
        return;
    L8:
        Map r7 = r6.getExtras();
        if (r7 != null) goto L11;
        return;
    L11:
        Object r8 = r7.get(g5b.a.class);
        if ((r8 instanceof g5b.a) == false) goto L14;
        g5b.a r9 = (g5b.a) r8;
    L15:
        if (r9 != null) goto L17;
        return;
    L17:
        String r10 = r6.getId();
        if (r10.length() != 0) goto L20;
        boolean r0 = true;
    L21:
        if (r0 == false) goto L23;
        return;
    L23:
        String r11 = String.valueOf(r9.b);
        b r12 = e.remove(r11);
        if (r12 != null) goto L26;
        return;
    L26:
        r12.g = r10;
        r12.i = r5;
        f.put(r10, r12);
        return;
    L20:
        r0 = false;
        goto L21
    L14:
        r9 = null;
        goto L15
    }

    @Override // mkb.a
    public final void c(String r3, String r4, int r5, long r6) {
        Intrinsics.checkNotNullParameter(r3, "contextId");
        ConcurrentHashMap<String, C0039a> r0 = c;
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.put(r3, new C0039a(r6, r4, r5));
    }

    @Override // mkb.a
    public final void d(String r14, String r15, String r16, long r17) {
        Intrinsics.checkNotNullParameter(r14, "contextId");
        Intrinsics.checkNotNullParameter(r15, "cId");
        C0039a r0 = c.remove(r14);
        if (r0 != null) goto L5;
        return;
    L5:
        b r12 = new b(r15, r0.b, r0.c, r16, r0.a, SystemClock.elapsedRealtime(), r0.d, r0.e);
        ConcurrentHashMap<String, b> r1 = d;
        r1.put(r15, r12);
        final long r2 = SystemClock.elapsedRealtime();
        Function1<b, Boolean> r3 = new DoubaoReplyLatencyTracker$cleanupExpired$isExpired$1(r2);
        CollectionsKt.removeAll(r1.values(), r3);
        CollectionsKt.removeAll(e.values(), r3);
        CollectionsKt.removeAll(f.values(), r3);
    }
}
