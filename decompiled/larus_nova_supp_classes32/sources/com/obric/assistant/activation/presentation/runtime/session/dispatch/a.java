package com.obric.assistant.activation.presentation.runtime.session.dispatch;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureState;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningChildCoordinator;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a<T> {
    public final ArrayDeque<T> a;
    public boolean b;

    /* JADX INFO: renamed from: com.obric.assistant.activation.presentation.runtime.session.dispatch.a$a, reason: collision with other inner class name */
    public static final class C0074a {
    }

    public static final class b<T> {
        public final List<T> a;
        public final boolean b;
        public final List<T> c;

        public b() {
            this(null, false, null, 7);
        }

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return ((r0 + r1) * 31) + this.c.hashCode();
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Result(ready=" + this.a + ", buffered=" + this.b + ", dropped=" + this.c + ')';
        }

        public b(List r2, boolean r3, List r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r2 = CollectionsKt.emptyList();
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = false;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = CollectionsKt.emptyList();
        L11:
            Intrinsics.checkNotNullParameter(r2, "ready");
            Intrinsics.checkNotNullParameter(r4, "dropped");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public final b<T> g() {
        boolean r0 = this.b;
        int r1 = this.a.size();
        if (this.b == false) goto L5;
        b<T> r2 = f(null);
    L6:
        FLogger.a.i("AiKeySessionEventGate", "gate_release_pending_down: waitingBefore=" + r0 + " waitingAfter=" + this.b + " cachedBefore=" + r1 + " released=" + r2.a.size());
        return r2;
    L5:
        r2 = new b(null, false, null, 7);
        goto L6
    }

    public a() {
        this.a = new ArrayDeque();
        FLogger.a.i("AiKeySessionEventGate", "gate_initialized: capacity=32");
    }

    public final List<T> b() {
        List r0 = CollectionsKt.createListBuilder();
    L4:
        if ((!this.a.isEmpty()) == false) goto L7;
        r0.add(this.a.removeFirst());
        goto L4
    L7:
        return CollectionsKt.build(r0);
    }

    public static b e(InteractionSessionEventDispatcher.a r4) {
        return new b(CollectionsKt.listOf(r4), false, null, 6);
    }

    public final b c(InteractionSessionEventDispatcher.a r6) {
        boolean r0 = this.b;
        int r1 = this.a.size();
        if (this.b == false) goto L5;
        b r7 = a(r6, CollectionsKt.emptyList());
    L6:
        FLogger.a.i("AiKeySessionEventGate", "gate_on_following_event: waitingBefore=" + r0 + " waitingAfter=" + this.b + " cachedBefore=" + r1 + " cachedAfter=" + this.a.size() + " buffered=" + r7.b + " released=" + r7.a.size() + " dropped=" + r7.c.size());
        return r7;
    L5:
        r7 = e(r6);
        goto L6
    }

    public final b<T> f(T r7) {
        FLogger r0 = FLogger.a;
        r0.i("AiKeySessionEventGate", "release terminalEvent=" + r7);
        List r1 = CollectionsKt.toMutableList(b());
        if (r7 == null) goto L5;
        r1.add(r7);
    L5:
        this.b = false;
        StringBuilder r4 = new StringBuilder("gate_events_released: released=");
        r4.append(r1.size());
        r4.append(" hasTerminal=");
        if (r7 == null) goto L8;
        boolean r8 = true;
    L9:
        r4.append(r8);
        r0.i("AiKeySessionEventGate", r4.toString());
        return new b(r1, false, null, 6);
    L8:
        r8 = false;
        goto L9
    }

    public final b a(InteractionSessionEventDispatcher.a r5, List r6) {
        List r7 = CollectionsKt.toMutableList(r6);
        if (this.a.size() < 32) goto L5;
        r7.add(this.a.removeFirst());
        FLogger.a.w("AiKeySessionEventGate", "gate_capacity_overflow: capacity=32 cached=" + this.a.size() + " droppedOldest=1");
    L5:
        this.a.addLast(r5);
        FLogger.a.i("AiKeySessionEventGate", "gate_event_buffered: cached=" + this.a.size() + " dropped=" + r7.size());
        return new b(null, true, r7, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b d(int r9, InteractionSessionEventDispatcher.a.c r10) {
        boolean r0 = this.b;
        int r1 = this.a.size();
        if (r9 != 20) goto L15;
        ObricListeningChildCoordinator.a.getClass();
        cba.b r2 = ObricListeningChildCoordinator.g;
        if (r2 != null) goto L7;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L15;
        boolean r4 = true;
    L17:
        switch(r9) {
            case 20: goto L27;
            case 21: goto L24;
            case 22: goto L20;
            default: goto L18;
        };
    L18:
        b<T> r5 = e(r10);
    L30:
        FLogger.a.i("AiKeySessionEventGate", "gate_on_show: invocationType=" + r9 + " shouldGate=" + r4 + " waitingBefore=" + r0 + " waitingAfter=" + this.b + " cachedBefore=" + r1 + " cachedAfter=" + this.a.size() + " buffered=" + r5.b + " released=" + r5.a.size() + " dropped=" + r5.c.size());
        return r5;
    L27:
        if (r4 == false) goto L29;
        List<T> r6 = b();
        this.b = true;
        FLogger.a.i("AiKeySessionEventGate", "gate_down_started: replaced=" + r6.size() + " capacity=32");
        r5 = a(r10, r6);
        goto L30
    L29:
        r5 = e(r10);
        goto L30
    L20:
        if (this.b == false) goto L22;
        List<T> r11 = b();
        this.b = false;
        FLogger.a.i("AiKeySessionEventGate", "gate_round_cancelled: dropped=" + r11.size());
        r5 = new b(null, false, r11, 3);
        goto L30
    L22:
        r5 = e(r10);
        goto L30
    L24:
        if (this.b == false) goto L26;
        r5 = f(r10);
        goto L30
    L26:
        r5 = e(r10);
        goto L30
    L7:
        if (r2.d != ObricAiKeyGestureState.FIRST_DOWN) goto L9;
        boolean r7 = true;
    L10:
        if (r7 != true) goto L12;
        r3 = true;
        goto L13
    L9:
        r7 = false;
    L15:
        r4 = false;
        goto L17
    }
}
