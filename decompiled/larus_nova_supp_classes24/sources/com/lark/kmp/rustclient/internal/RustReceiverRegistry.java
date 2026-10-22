package com.lark.kmp.rustclient.internal;

import com.bytedance.larksuite.wire.CommandScope;
import com.lark.kmp.logger.LarkLogger;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.Packet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class RustReceiverRegistry implements q, t {
    public final Object a;
    public final CoroutineScope b;
    public final Set<q> c;
    public final Map<b, q> d;
    public final ArrayDeque<Pair<Long, rpc.c>> e;
    public final LinkedHashMap<Long, rpc.a> f;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final Pair<Long, Long> b;
        public final Long c;
        public final Long d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Pair<Long, Long> r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "UserContainerIdentity(userId=" + this.a + ", componentIds=" + this.b + ')';
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            this.a = r2;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CommandScope.values().length];
            r0[CommandScope.GlobalScope.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CommandScope.UserScope.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public RustReceiverRegistry() {
        this.a = new Object();
        CoroutineDispatcher r0 = Dispatchers.getDefault().limitedParallelism(1);
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(r0));
        this.c = new LinkedHashSet();
        this.d = new LinkedHashMap();
        this.e = new ArrayDeque();
        this.f = new LinkedHashMap();
    }

    @Override // com.lark.kmp.rustclient.internal.t
    public final void b(p r3) {
        Intrinsics.checkNotNullParameter(r3, "receiver");
        Object r0 = this.a;
        monitor-enter(r0);
        this.c.add(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void c(rpc.c r6) {
        Object r0 = this.a;
        monitor-enter(r0);
        ArrayDeque<Pair<Long, rpc.c>> r1 = this.e;     // Catch: Throwable -> L14
        Long r3 = r6.b.getUser_container_id();     // Catch: Throwable -> L14
        if (r3 == null) goto L7;
        long r4 = r3.longValue();     // Catch: Throwable -> L14
    L8:
        r1.addLast(new Pair(Long.valueOf(r4), r6));     // Catch: Throwable -> L14
        if (this.e.size() <= 1000) goto L11;
        this.e.removeFirst();     // Catch: Throwable -> L14
    L11:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return;
    L7:
        r4 = 0;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.lark.kmp.rustclient.internal.q
    public final boolean d(long r6) {
        Object r0 = this.a;
        monitor-enter(r0);
        Set<q> r1 = this.c;     // Catch: Throwable -> L33
        boolean r3 = false;
        if ((r1 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r2 = r1.iterator();     // Catch: Throwable -> L33
    L11:
        if (r2.hasNext() == false) goto L15;
        if (((q) r2.next()).d(r6) == false) goto L11;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L30;
        Collection r5 = ((LinkedHashMap) this.d).values();     // Catch: Throwable -> L33
        if ((r5 instanceof Collection) == true) goto L20;
    L22:
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L33
    L23:
        if (r7.hasNext() == false) goto L28;
        if (((q) r7.next()).d(r6) == false) goto L23;
        boolean r8 = true;
    L29:
        if (r8 == true) goto L30;
    L31:
        monitor-exit(r0);
        return r3;
    L28:
        r8 = false;
        goto L29
    L20:
        if (r5.isEmpty() == false) goto L22;
    L30:
        r3 = true;
    L15:
        r4 = false;
        goto L16
    L7:
        if (r1.isEmpty() == false) goto L9;
    L33:
        th = move-exception;
        throw th;
    }

    public final void g(byte[] r8) {
        Intrinsics.checkNotNullParameter(r8, "data");
        BuildersKt.launch$default(this.b, null, null, new RustReceiverRegistry$dispatchPushCallback$1(r8, this, null), 3, null);
    }

    public final void h(rpc.a r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        Object r0 = this.a;
        monitor-enter(r0);
        List r1 = CollectionsKt.toList(SetsKt.plus(this.c, ((LinkedHashMap) this.d).values()));     // Catch: Throwable -> L28
        monitor-exit(r0);
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        q r3 = (q) r2.next();
        if (r3.d(r6.a) == false) goto L8;
        r3.h(r6);
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        return;
    L15:
        if (r6.f == true) goto L38;
        Object r5 = this.a;
        monitor-enter(r5);
        this.f.put(Long.valueOf(r6.a), r6);     // Catch: Throwable -> L24
        if (this.f.size() <= 1000) goto L21;
        this.f.remove(Long.valueOf(((Number) CollectionsKt.first(this.f.keySet())).longValue()));     // Catch: Throwable -> L24
    L21:
        LarkLogger r7 = LarkLogger.a;     // Catch: Throwable -> L24
        LarkLogger.c("RustReceiverRegistry", "add async callback cache taskId = " + r6.a);     // Catch: Throwable -> L24
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r5);
        return;
    L24:
        th = move-exception;
        throw th;
    L38:
        return;
    L12:
        r4 = false;
    L28:
        th = move-exception;
        throw th;
    }

    public final void i(rpc.c r15) {
        Intrinsics.checkNotNullParameter(r15, "data");
        Long r0 = r15.b.getTask_id();
        long r1 = 0;
        if (r0 == null) goto L5;
        long r6 = r0.longValue();
    L7:
        if (r6 > 0) goto L52;
        Object r2 = this.a;
        monitor-enter(r2);
        Set r3 = CollectionsKt.toSet(this.c);     // Catch: Throwable -> L49
        monitor-exit(r2);
        Object r4 = this.a;
        monitor-enter(r4);
        Set r5 = CollectionsKt.toSet(((LinkedHashMap) this.d).values());     // Catch: Throwable -> L46
        monitor-exit(r4);
        Iterator r7 = r3.iterator();
    L18:
        if (r7.hasNext() == false) goto L20;
        ((q) r7.next()).i(r15);
        goto L18
    L20:
        Command r8 = r15.b.getCmd();
        if (r8 != null) goto L23;
        r8 = Command.UNKNOWN_COMMAND;
    L23:
        int r9 = c.a[com.lark.kmp.rustclient.internal.c.a(r8).ordinal()];
        if (r9 != 1) goto L26;
        Iterator r10 = r5.iterator();
    L44:
        if (r10.hasNext() == false) goto L82;
        ((q) r10.next()).i(r15);
        goto L44
    L82:
        return;
    L26:
        if (r9 != 2) goto L41;
        Long r11 = r15.b.getUser_container_id();
        if (r11 == null) goto L30;
        r1 = r11.longValue();
    L30:
        String r12 = r15.b.getUser_id();
        if (r12 != null) goto L33;
        r12 = "";
    L33:
        Collection<q> r13 = f(r1, r12);
        if ((!r13.isEmpty()) == false) goto L39;
        Iterator<T> r14 = r13.iterator();
    L37:
        if (r14.hasNext() == false) goto L81;
        ((q) r14.next()).i(r15);
        goto L37
    L81:
        return;
    L39:
        c(r15);
        return;
    L41:
        throw new NoWhenBranchMatchedException();
    L46:
        th = move-exception;
        throw th;
    L49:
        th = move-exception;
        throw th;
    L52:
        Boolean r16 = r15.b.is_err();
        if (r16 == null) goto L55;
        boolean r17 = r16.booleanValue();
    L56:
        ByteString r19 = r15.b.getPayload();
        if (r19 == null) goto L60;
        byte[] r20 = r19.toByteArray();
        if (r20 == null) goto L60;
    L61:
        byte[] r21 = r20;
        String r22 = r15.b.getUser_id();
        if (r22 != null) goto L64;
        r22 = "";
    L64:
        String r110 = r22;
        Boolean r23 = r15.b.getVerify_user_id();
        if (r23 == null) goto L67;
        boolean r111 = r23.booleanValue();
    L68:
        Packet.StreamStatus r112 = r15.b.getStream_status();
        if (r112 != null) goto L71;
        r112 = Packet.StreamStatus.ACTIVE;
    L71:
        h(new rpc.a(r6, r17, r21, r110, r111, r112, 32));
        return;
    L67:
        r111 = false;
    L60:
        r20 = new byte[0];
        goto L61
    L55:
        r17 = false;
        goto L56
    L5:
        r6 = 0;
        goto L7
    }

    @Override // com.lark.kmp.rustclient.internal.t
    public final void a(String r4, e0 r5) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r5, "receiver");
        Object r0 = this.a;
        monitor-enter(r0);
        this.d.put(new b(r4), r5);     // Catch: Throwable -> L7
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final Collection<q> f(long r11, String r13) {
        Object r0 = this.a;
        monitor-enter(r0);
        Iterator r1 = ((LinkedHashMap) this.d).entrySet().iterator();     // Catch: Throwable -> L47
    L5:
        Object r5 = null;
        if (r1.hasNext() == false) goto L22;
        Object r2 = r1.next();     // Catch: Throwable -> L47
        b r6 = (b) ((Map.Entry) r2).getKey();     // Catch: Throwable -> L47
        Long r7 = r6.c;     // Catch: Throwable -> L47
        if (r7 != null) goto L11;
    L12:
        Long r8 = r6.d;     // Catch: Throwable -> L47
        if (r8 != null) goto L16;
    L18:
        boolean r9 = false;
    L20:
        if (r9 == false) goto L5;
    L23:
        Map.Entry r3 = (Map.Entry) r2;     // Catch: Throwable -> L47
        if (r3 != null) goto L37;
        Iterator r12 = ((LinkedHashMap) this.d).entrySet().iterator();     // Catch: Throwable -> L47
    L27:
        if (r12.hasNext() == false) goto L36;
        Object r14 = r12.next();     // Catch: Throwable -> L47
        Map.Entry r4 = (Map.Entry) r14;     // Catch: Throwable -> L47
        if (Intrinsics.areEqual(((b) r4.getKey()).a, r13) == true) goto L31;
    L33:
        boolean r10 = false;
    L34:
        if (r10 == false) goto L27;
        r5 = r14;
        goto L36
    L31:
        if (((b) r4.getKey()).b != null) goto L33;
        r10 = true;
    L36:
        r3 = (Map.Entry) r5;     // Catch: Throwable -> L47
    L37:
        if (r3 == null) goto L43;
        q r15 = (q) r3.getValue();     // Catch: Throwable -> L47
        if (r15 == null) goto L43;
        List r16 = CollectionsKt.listOf(r15);     // Catch: Throwable -> L47
        if (r16 == null) goto L43;
    L44:
        List r17 = r16;     // Catch: Throwable -> L47
        monitor-exit(r0);
        return r17;
    L43:
        r16 = CollectionsKt.emptyList();     // Catch: Throwable -> L47
        goto L44
    L16:
        if (r8.longValue() != r11) goto L18;
    L19:
        r9 = true;
        goto L20
    L11:
        if (r7.longValue() == r11) goto L19;
    L22:
        r2 = null;
    L47:
        th = move-exception;
        throw th;
    }
}
