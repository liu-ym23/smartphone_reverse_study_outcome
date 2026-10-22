package com.larus.audio.call;

import com.larus.audio.call.mgr.AVKitCoreStates$Invalid;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.MajorState;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import r58.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a {
    public static final /* synthetic */ int r = 0;
    public Function1<? super String, Unit> a;
    public Function0<Unit> b;
    public int c;
    public MajorState d;
    public Function0<Unit> e;
    public Function0<Unit> f;
    public Function1<? super String, Unit> g;
    public Function1<? super d, Unit> h;
    public Function1<? super byte[], Unit> i;
    public final MutableSharedFlow<Integer> j;
    public final MutableSharedFlow k;
    public final MutableSharedFlow<Pair<MajorState, Integer>> l;
    public final MutableSharedFlow m;
    public final StateFlowImpl n;
    public final StateFlowImpl o;
    public Function1<? super Long, Unit> p;
    public Function0<Unit> q;

    /* JADX INFO: renamed from: com.larus.audio.call.a$a, reason: collision with other inner class name */
    public static final class C0077a {
    }

    static {
    }

    public void a(RealtimeCallParam r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public void b() {
    }

    public void c() {
    }

    public void d(RealtimeCallParam r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public void e(RealtimeCallParam r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public abstract void g(String r1);

    public a() {
        this.c = -1;
        MutableSharedFlow<Integer> r5 = SharedFlowKt.MutableSharedFlow$default(1, 3, null, 4, null);
        this.j = r5;
        this.k = r5;
        MutableSharedFlow<Pair<MajorState, Integer>> r1 = SharedFlowKt.MutableSharedFlow$default(1, 3, null, 4, null);
        this.l = r1;
        this.m = r1;
        StateFlowImpl r0 = j1.a(TuplesKt.to(new AVKitDuplexState(new AVKitCoreStates$Invalid(), new AVKitCoreStates$Invalid()), -1));
        this.n = r0;
        this.o = r0;
    }

    public final void f(MajorState r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "majorState");
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        r0.i("AbsRealtimeCallService", "onUIStateChanged, Major from:" + this.d + " to:" + r6);
        this.l.tryEmit(TuplesKt.to(r6, Integer.valueOf(r7)));
        r0.i("AbsRealtimeCallService", "onUIStateChanged, from:" + this.c + " to:" + r7);
        this.j.tryEmit(Integer.valueOf(r7));
        this.d = r6;
        this.c = r7;
    }
}
