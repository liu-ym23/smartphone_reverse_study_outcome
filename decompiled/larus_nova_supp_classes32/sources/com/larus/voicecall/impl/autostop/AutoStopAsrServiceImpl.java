package com.larus.voicecall.impl.autostop;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AutoStopAsrServiceImpl implements a3a.c {
    public final f a;
    public final Object b;
    public LifecycleState c;
    public RealtimeCallParam d;
    public CompletableDeferred e;
    public CompletableDeferred f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/voicecall/impl/autostop/AutoStopAsrServiceImpl$LifecycleState;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "IDLE", "ACTIVE", "STOPPING", "RELEASING", "RELEASED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LifecycleState extends Enum<LifecycleState> {
        public static final LifecycleState ACTIVE = null;
        public static final LifecycleState IDLE = null;
        public static final LifecycleState RELEASED = null;
        public static final LifecycleState RELEASING = null;
        public static final LifecycleState STOPPING = null;
        public static final /* synthetic */ LifecycleState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LifecycleState> getEntries() {
            return b;
        }

        static {
            LifecycleState r0 = new LifecycleState("IDLE", 0);
            IDLE = r0;
            LifecycleState r1 = new LifecycleState("ACTIVE", 1);
            ACTIVE = r1;
            LifecycleState r3 = new LifecycleState("STOPPING", 2);
            STOPPING = r3;
            LifecycleState r5 = new LifecycleState("RELEASING", 3);
            RELEASING = r5;
            LifecycleState r7 = new LifecycleState("RELEASED", 4);
            RELEASED = r7;
            LifecycleState[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static LifecycleState[] values() {
            return (LifecycleState[]) a.clone();
        }

        public static LifecycleState valueOf(String r1) {
            return (LifecycleState) r27.a.a(LifecycleState.class, r1);
        }

        public LifecycleState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean a() {
        Object r0 = this.b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.c == LifecycleState.ACTIVE) goto L7;
        boolean r1 = false;
    L9:
        monitor-exit(r0);
        return r1;
    L7:
        this.c = LifecycleState.STOPPING;     // Catch: Throwable -> L11
        r1 = true;
        goto L9
    }

    @Override // a3a.c
    public final void p() {
        f r0 = this.a;
        r0.getClass();
        com.larus.voicecall.impl.plugins.q r1 = (com.larus.voicecall.impl.plugins.q) LLMCallController.y(r0, Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.plugins.q.class));
        if (r1 == null) goto L6;
        r1.p();
        return;
    }

    @Override // a3a.c
    public final void q() {
        Object r0 = this.b;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.c == LifecycleState.ACTIVE) goto L8;
        monitor-exit(r0);
        return;
    L8:
        final CompletableDeferred r1 = this.e;     // Catch: Throwable -> L15
        if (r1 != null) goto L12;
        monitor-exit(r0);
        return;
    L12:
        monitor-exit(r0);
        r1.invokeOnCompletion(new n(r1, this));
    }

    @Override // a3a.c
    public final void release() {
        Object r0 = this.b;
        monitor-enter(r0);
        LifecycleState r1 = this.c;     // Catch: Throwable -> L25
        LifecycleState r2 = LifecycleState.RELEASING;     // Catch: Throwable -> L25
        Job r3 = null;
        if (r1 != r2) goto L7;
    L17:
        boolean r4 = false;
    L18:
        monitor-exit(r0);
        if (r4 == true) goto L21;
        return;
    L21:
        if (r3 != null) goto L23;
        this.a.L().invokeOnCompletion(new p(this));
        return;
    L23:
        r3.invokeOnCompletion(new m(this));
        return;
    L7:
        if (r1 == LifecycleState.RELEASED) goto L17;
        this.c = r2;     // Catch: Throwable -> L25
        RealtimeCallParam r5 = this.d;     // Catch: Throwable -> L25
        if (r5 == null) goto L16;
        Job r6 = this.f;     // Catch: Throwable -> L25
        if (r6 != null) goto L15;
        r6 = this.a.T(r5);     // Catch: Throwable -> L25
        this.f = r6;     // Catch: Throwable -> L25
    L15:
        r3 = r6;
    L16:
        r4 = true;
    L25:
        th = move-exception;
        throw th;
    }

    public final void b(a3a.a.d r4) {
        if (a() == true) goto L14;
        return;
    L14:
        f r1 = this.a;     // Catch: Throwable -> L11
        r1.getClass();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r4, "event");     // Catch: Throwable -> L11
        b r2 = r1.B;     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        r2.j3(r4);     // Catch: Throwable -> L11
    L9:
        c(true);
        return;
    L11:
        th = move-exception;
        c(true);
        throw th;
    }

    public final void c(boolean r3) {
        if (r3 == false) goto L4;
    L23:
        Object r4 = this.b;     // Catch: Throwable -> L22
        monitor-enter(r4);     // Catch: Throwable -> L22
        RealtimeCallParam r0 = this.d;     // Catch: Throwable -> L15
        if (r0 != null) goto L12;
    L17:
        monitor-exit(r4);     // Catch: Throwable -> L22
        return;
    L12:
        if (this.f != null) goto L17;
        this.f = this.a.T(r0);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L26:
        return;
    L4:
        if (a() == true) goto L23;
    }

    @Override // a3a.c
    public final void r(RealtimeCallParam r6) {
        Intrinsics.checkNotNullParameter(r6, "param");
        Object r2 = this.b;     // Catch: Throwable -> L20
        monitor-enter(r2);     // Catch: Throwable -> L20
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L6:
        if (this.c != LifecycleState.IDLE) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L17;
        this.c = LifecycleState.ACTIVE;     // Catch: Throwable -> L14
        this.d = r6;     // Catch: Throwable -> L14
        final CompletableDeferred r7 = this.a.R(r6, false);     // Catch: Throwable -> L14
        this.e = r7;     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L20
        r7.invokeOnCompletion(new o(r7, this));
        return;
    L17:
        throw new IllegalStateException(("AutoStopAsrService can only start from IDLE, state=" + this.c).toString());     // Catch: Throwable -> L14
    L8:
        r3 = false;
    L20:
        th = move-exception;
        c(false);
        throw th;
    }

    @Override // a3a.c
    public final void updateScreenshotForAsr(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tosKey");
        f r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "tosKey");
        ((t) LLMCallController.w(r1, Reflection.getOrCreateKotlinClass(t.class))).updateScreenshotForAsr(r3);
    }

    public AutoStopAsrServiceImpl(com.larus.asr.session.clicktalk.s r3, Function0 r4, Function2 r5) {
        Intrinsics.checkNotNullParameter(r3, "eventListener");
        Intrinsics.checkNotNullParameter(r4, "lifecycleScope");
        this.a = new f(r3, new AutoStopAsrServiceImpl$controller$1(this), r5, r4);
        this.b = new Object();
        this.c = LifecycleState.IDLE;
    }
}
