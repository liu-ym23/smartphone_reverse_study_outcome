package com.larus.audio.call.mgr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import s68.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final ReentrantLock a;
    public final List<UpStateReducer> b;
    public final List<DownStateReducer> c;
    public final C0080b<AVKitDuplexState.UpState> d;
    public final C0080b<AVKitDuplexState.DownState> e;
    public final StateFlowImpl f;
    public final StateFlowImpl g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.audio.call.mgr.b$b, reason: collision with other inner class name */
    public static final class C0080b<S> implements n<S> {
        public final Function1<S, StateTriggerEvent> a;
        public final Map<StateTriggerEvent, h<S>> b;
        public boolean c;

        public final Map<StateTriggerEvent, h<S>> b() {
            return MapsKt.toMap(this.b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0080b(Function1<? super S, ? extends StateTriggerEvent> r2) {
            Intrinsics.checkNotNullParameter(r2, "extractTriggerBy");
            this.a = r2;
            this.b = new LinkedHashMap();
        }

        @Override // s68.n
        public final void a(S r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            Object r0 = this.a.invoke(r4);
            if (r0 == null) goto L7;
            Map<StateTriggerEvent, h<S>> r1 = this.b;
            int r2 = h.c;
            r1.put((StateTriggerEvent) r0, h.a.a(r4));
            this.c = true;
            return;
        L7:
            throw new IllegalArgumentException(("pending state must carry non-null triggerBy as its pending key, got: " + r4).toString());
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReducerPosition.values().length];
            r0[ReducerPosition.APPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ReducerPosition.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public b() {
        this.a = new ReentrantLock();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new C0080b(new s68.d());
        this.e = new C0080b(new s68.e());
        StateFlowImpl r0 = j1.a(new AVKitDuplexState(new AVKitCoreStates$Invalid(), new AVKitCoreStates$Invalid()));
        this.f = r0;
        this.g = r0;
    }

    public static String b(String r2) {
        if (r2 != null) goto L6;
        return "";
    L6:
        return " (by " + r2 + ')';
    }

    public final void a(StateTriggerEvent r29) {
        Intrinsics.checkNotNullParameter(r29, "event");
        ReentrantLock r15 = this.a;
        r15.lock();
        AVKitDuplexState r9 = (AVKitDuplexState) this.f.getValue();     // Catch: Throwable -> L20
        AVKitDuplexState.UpState r10 = r9.getUpState();     // Catch: Throwable -> L20
        AVKitDuplexState.DownState r11 = r9.getDownState();     // Catch: Throwable -> L20
        Map<StateTriggerEvent, h<AVKitDuplexState.UpState>> r14 = this.d.b();     // Catch: Throwable -> L20
        Map<StateTriggerEvent, h<AVKitDuplexState.DownState>> r13 = this.e.b();     // Catch: Throwable -> L20
        C0080b<AVKitDuplexState.UpState> r1 = this.d;     // Catch: Throwable -> L20
        r1.getClass();     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(r29, "event");     // Catch: Throwable -> L20
        h r2 = (h) ((LinkedHashMap) r1.b).get(r29);     // Catch: Throwable -> L20
        String r12 = "reducer=";
        StateTriggerEvent r16 = null;
        boolean r6 = false;
        boolean r5 = true;
        if (r2 == null) goto L7;
        C0080b<AVKitDuplexState.UpState> r3 = this.d;     // Catch: Throwable -> L20
        ((LinkedHashMap) r3.b).clear();     // Catch: Throwable -> L20
        r3.c = true;     // Catch: Throwable -> L20
        r2.b.invoke(this.d);     // Catch: Throwable -> L20
        this.d.c = false;     // Catch: Throwable -> L20
        AVKitDuplexState.UpState r7 = (AVKitDuplexState.UpState) r2.a;     // Catch: Throwable -> L20
        r15 = r15;
        String r19 = "pending-hit";
        boolean r17 = true;
        boolean r110 = true;
    L25:
        if ((r11 instanceof AVKitCoreStates$Paused) == false) goto L27;
        AVKitCoreStates$Paused r8 = (AVKitCoreStates$Paused) r11;     // Catch: Throwable -> L58
    L28:
        if (r8 == null) goto L30;
        AVKitDuplexState.DownState r4 = r8.b;     // Catch: Throwable -> L58
    L31:
        if (r4 != null) goto L33;
    L47:
        boolean r21 = false;
    L48:
        C0080b<AVKitDuplexState.DownState> r20 = this.e;     // Catch: Throwable -> L58
        r20.getClass();     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r29, "event");     // Catch: Throwable -> L58
        h r22 = (h) ((LinkedHashMap) r20.b).get(r29);     // Catch: Throwable -> L58
        if (r22 == null) goto L60;
        C0080b<AVKitDuplexState.DownState> r23 = this.e;     // Catch: Throwable -> L58
        ((LinkedHashMap) r23.b).clear();     // Catch: Throwable -> L58
        r23.c = r17;     // Catch: Throwable -> L58
        r22.b.invoke(this.e);     // Catch: Throwable -> L58
        this.e.c = false;     // Catch: Throwable -> L58
        if (r21 == true) goto L53;
        AVKitDuplexState.DownState r24 = (AVKitDuplexState.DownState) r22.a;     // Catch: Throwable -> L58
    L57:
        r7 = r7;
        String r25 = "pending-hit";
        boolean r26 = true;
    L86:
        if (r7 == r10) goto L88;
        boolean r27 = true;
    L89:
        if (r24 == r11) goto L91;
        boolean r210 = true;
    L93:
        if (r27 == true) goto L101;
        if (r210 == true) goto L101;
        if (r110 == true) goto L100;
        if (r26 == true) goto L100;
        com.larus.audio.call.util.e.a.w("AVKitStateMachine", c(r29, r9));     // Catch: Throwable -> L58
    L102:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L58
        r15.unlock();
        return;
    L100:
        com.larus.audio.call.util.e.a.i("AVKitStateMachine", d(r29, r14, r13));     // Catch: Throwable -> L58
    L101:
        AVKitDuplexState r111 = new AVKitDuplexState(r7, r24);     // Catch: Throwable -> L58
        this.f.setValue(r111);     // Catch: Throwable -> L58
        com.larus.audio.call.util.e r30 = com.larus.audio.call.util.e.a;     // Catch: Throwable -> L58
        r30.i("AVKitStateMachine", f(r29, r9, r111, r27, r210, r19, r25));     // Catch: Throwable -> L58
        r30.i("AVKitStateMachine", d(r29, r14, r13));     // Catch: Throwable -> L58
        goto L102
    L91:
        r210 = false;
        goto L93
    L88:
        r27 = false;
        goto L89
    L53:
        if (r8 == null) goto L55;
        r16 = r8.getTriggerBy();     // Catch: Throwable -> L58
    L55:
        r24 = new AVKitCoreStates$Paused(r16, (AVKitDuplexState.DownState) r22.a);     // Catch: Throwable -> L58
        goto L57
    L60:
        if (r21 == false) goto L65;
        if (r4 == null) goto L64;
        AVKitDuplexState.DownState r31 = r4;
    L66:
        Iterator r112 = ((ArrayList) this.c).iterator();     // Catch: Throwable -> L58
        Map<StateTriggerEvent, h<AVKitDuplexState.DownState>> r211 = r13;
        boolean r32 = false;
    L68:
        if (r112.hasNext() == false) goto L77;
        DownStateReducer r33 = (DownStateReducer) r112.next();     // Catch: Throwable -> L58
        C0080b<AVKitDuplexState.DownState> r34 = this.e;     // Catch: Throwable -> L58
        r34.c = false;     // Catch: Throwable -> L58
        h r35 = r33.b(r31, r29, r34);     // Catch: Throwable -> L58
        if (r35 != null) goto L71;
        C0080b<AVKitDuplexState.DownState> r36 = this.e;     // Catch: Throwable -> L58
        if (r36.c == false) goto L76;
        Map<StateTriggerEvent, h<AVKitDuplexState.DownState>> r113 = r36.b();     // Catch: Throwable -> L58
        g("down", r33, r29, r211, r113);     // Catch: Throwable -> L58
        r211 = r113;
        r32 = true;
    L76:
        r4 = r4;
        r7 = r7;
        r31 = r31;
        r8 = r8;
        r12 = r12;
        goto L68
    L71:
        AVKitDuplexState.DownState r37 = (AVKitDuplexState.DownState) r35.a;     // Catch: Throwable -> L58
        C0080b<AVKitDuplexState.DownState> r38 = this.e;     // Catch: Throwable -> L58
        ((LinkedHashMap) r38.b).clear();     // Catch: Throwable -> L58
        r38.c = true;     // Catch: Throwable -> L58
        r35.b.invoke(this.e);     // Catch: Throwable -> L58
        r25 = r12 + Reflection.getOrCreateKotlinClass(r33.getClass()).getSimpleName();     // Catch: Throwable -> L58
        r24 = r37;
        r26 = true;
    L78:
        if (r21 == false) goto L86;
        if (r24 != r4) goto L82;
        r24 = (AVKitCoreStates$Paused) r11;     // Catch: Throwable -> L58
        goto L86
    L82:
        if (r8 == 0) goto L85;
        r16 = r8.getTriggerBy();     // Catch: Throwable -> L58
    L85:
        r24 = new AVKitCoreStates$Paused(r16, r24);     // Catch: Throwable -> L58
        goto L86
    L77:
        r26 = r32;
        r25 = null;
        r24 = r31;
        goto L78
    L64:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L58
    L65:
        r31 = r11;
        goto L66
    L33:
        if (Intrinsics.areEqual(r29, StateTriggerEvent.Resume.a) == true) goto L47;
        if (Intrinsics.areEqual(r29, StateTriggerEvent.Pause.a) == true) goto L47;
        if (Intrinsics.areEqual(r29, StateTriggerEvent.Connect.a) == true) goto L47;
        if (Intrinsics.areEqual(r29, StateTriggerEvent.Connected.a) == true) goto L47;
        if (Intrinsics.areEqual(r29, StateTriggerEvent.Stop.a) == true) goto L47;
        if (Intrinsics.areEqual(r29, StateTriggerEvent.Reset.a) == true) goto L47;
        if ((r29 instanceof StateTriggerEvent.Error) == true) goto L47;
        r21 = true;
        goto L48
    L30:
        r4 = null;
        goto L31
    L27:
        r8 = null;
        goto L28
    L7:
        Iterator r114 = ((ArrayList) this.b).iterator();     // Catch: Throwable -> L20
        Map<StateTriggerEvent, h<AVKitDuplexState.UpState>> r115 = r14;
        boolean r39 = false;
    L9:
        if (r114.hasNext() == false) goto L22;
        UpStateReducer r40 = (UpStateReducer) r114.next();     // Catch: Throwable -> L20
        C0080b<AVKitDuplexState.UpState> r41 = this.d;     // Catch: Throwable -> L20
        r41.c = r6;     // Catch: Throwable -> L20
        h r42 = r40.a(r10, r29, r41);     // Catch: Throwable -> L20
        if (r42 != null) goto L12;
        C0080b<AVKitDuplexState.UpState> r43 = this.d;     // Catch: Throwable -> L20
        if (r43.c == false) goto L19;
        Map<StateTriggerEvent, h<AVKitDuplexState.UpState>> r212 = r43.b();     // Catch: Throwable -> L20
        ReentrantLock r213 = r15;
        g("up", r40, r29, r115, r212);     // Catch: Throwable -> L58
        r115 = r212;
        r15 = r213;
        r39 = true;
        r5 = true;
    L58:
        th = th;
    L105:
        r213.unlock();
        throw th;
    L19:
        r6 = false;
        goto L9
    L12:
        AVKitDuplexState.UpState r44 = (AVKitDuplexState.UpState) r42.a;     // Catch: Throwable -> L20
        C0080b<AVKitDuplexState.UpState> r45 = this.d;     // Catch: Throwable -> L20
        ((LinkedHashMap) r45.b).clear();     // Catch: Throwable -> L20
        r45.c = r5;     // Catch: Throwable -> L20
        r42.b.invoke(this.d);     // Catch: Throwable -> L20
        String r46 = "reducer=" + Reflection.getOrCreateKotlinClass(r40.getClass()).getSimpleName();     // Catch: Throwable -> L20
        r17 = true;
    L23:
        r7 = r44;
        r19 = r46;
        r110 = r5;
        goto L25
    L22:
        r17 = true;
        r5 = r39;
        r44 = r10;
        r46 = null;
    L20:
        th = th;
        r213 = r15;
        goto L105
    }

    public final String e(Map<StateTriggerEvent, ? extends h<?>> r10) {
        if (r10.isEmpty() == false) goto L7;
        return "{}";
    L7:
        return CollectionsKt.joinToString$default(r10.entrySet(), null, "{", "}", 0, null, new s68.a(this), 25, null);
    }

    public static String c(StateTriggerEvent r3, AVKitDuplexState r4) {
        String r5 = Reflection.getOrCreateKotlinClass(r3.getClass()).getSimpleName();
        if (r4.getUpState() != r4.getDownState()) goto L5;
        String r0 = " (shared)";
    L7:
        return "[sm][noop] event=" + r5 + " | up=" + r4.getUpState().toSimpleString() + " | down=" + r4.getDownState().toSimpleString() + r0;
    L5:
        r0 = "";
        goto L7
    }

    public final void h(final DownStateReducer r7, ReducerPosition r8) {
        Intrinsics.checkNotNullParameter(r7, "reducer");
        Intrinsics.checkNotNullParameter(r8, "position");
        ReentrantLock r0 = this.a;
        r0.lock();
    L24:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if ((r7 instanceof UpStateReducer) == false) goto L13;
        CollectionsKt.removeAll(this.b, new s68.b(r7));     // Catch: Throwable -> L24
        int r1 = c.a[r8.ordinal()];     // Catch: Throwable -> L24
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L10;
        ((ArrayList) this.b).add(0, r7);     // Catch: Throwable -> L24
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L24
    L11:
        ((ArrayList) this.b).add(r7);     // Catch: Throwable -> L24
    L13:
        if ((r7 instanceof DownStateReducer) == false) goto L21;
        CollectionsKt.removeAll(this.c, new s68.c(r7));     // Catch: Throwable -> L24
        int r9 = c.a[r8.ordinal()];     // Catch: Throwable -> L24
        if (r9 == 1) goto L20;
        if (r9 != 2) goto L19;
        ((ArrayList) this.c).add(0, r7);     // Catch: Throwable -> L24
        goto L21
    L19:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L24
    L20:
        ((ArrayList) this.c).add(r7);     // Catch: Throwable -> L24
    L21:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r0.unlock();
    }

    public final String d(StateTriggerEvent r7, Map<StateTriggerEvent, h<AVKitDuplexState.UpState>> r8, Map<StateTriggerEvent, h<AVKitDuplexState.DownState>> r9) {
        String r10 = Reflection.getOrCreateKotlinClass(r7.getClass()).getSimpleName();
        Map<StateTriggerEvent, h<AVKitDuplexState.UpState>> r0 = this.d.b();
        Map<StateTriggerEvent, h<AVKitDuplexState.DownState>> r1 = this.e.b();
        String r3 = "=";
        if (Intrinsics.areEqual(r8, r0) == false) goto L5;
        String r2 = "=";
    L7:
        if (Intrinsics.areEqual(r9, r1) == true) goto L11;
        r3 = "->";
    L11:
        return "[sm][pending-diff] event=" + r10 + " | upPending: " + e(r8) + r2 + e(r0) + " | downPending: " + e(r9) + r3 + e(r1);
    L5:
        r2 = "->";
        goto L7
    }

    public final void g(String r4, s68.h r5, StateTriggerEvent r6, Map<StateTriggerEvent, ? extends h<?>> r7, Map<StateTriggerEvent, ? extends h<?>> r8) {
        com.larus.audio.call.util.e.a.i("AVKitStateMachine", "[sm][slot-diff] side=" + r4 + " event=" + Reflection.getOrCreateKotlinClass(r6.getClass()).getSimpleName() + " reducer=" + Reflection.getOrCreateKotlinClass(r5.getClass()).getSimpleName() + " | " + r4 + "Pending: " + e(r7) + " -> " + e(r8));
    }

    public static String f(StateTriggerEvent r6, AVKitDuplexState r7, AVKitDuplexState r8, boolean r9, boolean r10, String r11, String r12) {
        String r13 = Reflection.getOrCreateKotlinClass(r6.getClass()).getSimpleName();
        if (r7.getUpState() != r7.getDownState()) goto L5;
    L8:
        boolean r0 = true;
    L9:
        String r2 = " (shared)";
        if (r9 == false) goto L17;
        if (r10 == false) goto L17;
        if (r8.getUpState() != r8.getDownState()) goto L17;
        if (Intrinsics.areEqual(r11, r12) == false) goto L17;
        String r14 = "up&down: " + r7.getUpState().toSimpleString() + " -> " + ((AVKitDuplexState.DownState) r8.getUpState()).toSimpleString() + b(r11) + " (shared)";
    L28:
        return "[sm][state-move] event=" + r13 + " | " + r14;
    L17:
        if (r9 == false) goto L19;
        String r15 = "up: " + r7.getUpState().toSimpleString() + " -> " + r8.getUpState().toSimpleString() + b(r11);
    L20:
        if (r10 == false) goto L22;
        String r16 = "down: " + r7.getDownState().toSimpleString() + " -> " + r8.getDownState().toSimpleString() + b(r12);
    L23:
        if (r0 == true) goto L26;
        r2 = "";
    L26:
        r14 = r15 + " | " + r16 + r2;
        goto L28
    L22:
        r16 = "down= " + r7.getDownState().toSimpleString();
        goto L23
    L19:
        r15 = "up= " + r7.getUpState().toSimpleString();
        goto L20
    L5:
        if (r8.getUpState() == r8.getDownState()) goto L8;
        r0 = false;
        goto L9
    }
}
