package com.larus.voicecall.impl.autostop;

import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import com.larus.im.service.audio.a1;
import com.larus.im.service.audio.z0;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pf9.a0;
import pf9.c0;
import pf9.f0;
import pf9.k0;
import pf9.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> {
    public final a3a.b f;
    public final Function1<a3a.a.d, Unit> g;
    public final String h;
    public boolean i;
    public final C0013b j;

    public static final class a extends a1 {
        public final String a;
        public final /* synthetic */ b b;

        public final String g() {
            return this.a;
        }

        public a(b r1) {
            this.b = r1;
            this.a = r1.h;
        }

        public final void n(z0.a r5) {
            Intrinsics.checkNotNullParameter(r5, "event");
            if ((r5 instanceof pf9.q) == false) goto L6;
            a3a.a r0 = new a3a.a.b(((pf9.q) r5).a);
        L34:
            if (r0 == null) goto L39;
            this.b.j3(r0);
            return;
        L39:
            return;
        L6:
            if ((r5 instanceof z) == false) goto L9;
            this.b.getContext().a().t();
            r0 = new a3a.a.f(((z) r5).b);
            goto L34
        L9:
            if ((r5 instanceof c0) == false) goto L11;
            r0 = new a3a.a.h(((c0) r5).a);
            goto L34
        L11:
            boolean r1 = false;
            if ((r5 instanceof a0) == false) goto L20;
            b r2 = this.b;
            r2.i = true;
            r2.getContext().a().n2(new StateTriggerEvent.QueryEnd(((a0) r5).c));     // Catch: Throwable -> L16
            this.b.i = false;
            r0 = new a3a.a.g(((a0) r5).c);
        L16:
            th = move-exception;
            this.b.i = false;
            throw th;
        L20:
            if ((r5 instanceof f0) == false) goto L33;
            k0 r6 = ((f0) r5).b;
            if (r6 == null) goto L33;
            String r7 = r6.g;
            if (r7 == null) goto L33;
            if (r7.length() <= 0) goto L28;
            r1 = true;
        L28:
            if (r1 == true) goto L31;
            r7 = null;
        L31:
            if (r7 == null) goto L33;
            r0 = new a3a.a.c(r7);
        L33:
            r0 = null;
            goto L34
        }

        public final void q(String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            int r4 = r2.hashCode();
            if (r4 == (-1381107413)) goto L18;
            if (r4 == 1624133454) goto L14;
            if (r4 == 2027072059) goto L10;
            return;
        L10:
            if (r2.equals("OTHER_EVENT_REQUEST_RETRIED_TOAST") == false) goto L25;
            this.b.j3(a3a.a.j.a);
            return;
        L25:
            return;
        L14:
            if (r2.equals("OTHER_EVENT_CALL_DISCONNECTED_WITH_RETRY_TOAST") == false) goto L26;
            this.b.j3(a3a.a.i.a);
            return;
        L26:
            return;
        L18:
            if (r2.equals("OTHER_EVENT_TASK_FAILED_TOAST") == false) goto L27;
            this.b.j3(a3a.a.k.a);
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.autostop.b$b, reason: collision with other inner class name */
    public static final class C0013b implements com.larus.audio.call.mgr.f.a {
        public final /* synthetic */ b a;

        public C0013b(b r1) {
            this.a = r1;
        }

        public final void Q(MajorState r7, MajorState r8) {
            Intrinsics.checkNotNullParameter(r7, "prev");
            Intrinsics.checkNotNullParameter(r8, "current");
            boolean r1 = false;
            if (this.a.i == true) goto L5;
        L9:
            boolean r0 = false;
        L10:
            if (r0 == true) goto L12;
            this.a.j3(new a3a.a.e(r7, r8));
        L12:
            b r2 = this.a;
            int r4 = r7.a;
            int r5 = r8.a;
            if ((r7 instanceof MajorState.a) == true) goto L15;
        L17:
            r2.j3(new a3a.a.l(r4, r5, r1));
            if ((r8 instanceof MajorState.f) == false) goto L21;
            MajorState.f r9 = (MajorState.f) r8;
            this.a.g.invoke(new a3a.a.d(Integer.valueOf(r9.c), Integer.valueOf(r9.d), r9.e, r9.f));
            return;
        L21:
            return;
        L15:
            if (Intrinsics.areEqual(r8, MajorState.j.c) == false) goto L17;
            r1 = true;
            goto L17
        L5:
            if ((r7 instanceof MajorState.d) == false) goto L9;
            if (Intrinsics.areEqual(r8, MajorState.j.c) == false) goto L9;
            r0 = true;
            goto L10
        }
    }

    public final z0 S2() {
        return new a(this);
    }

    public final void a3() {
        getContext().a().M0(this.j);
    }

    public final void f3() {
        getContext().a().V(this.j);
    }

    public final void g3() {
        getContext().a().V(this.j);
        j3(new a3a.a.e(new MajorState.i(), MajorState.c.c));
        super.g3();
    }

    public final String T2() {
        return this.h;
    }

    public final void j3(a3a.a r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        this.f.onEvent(r5);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e(this.h, "event listener failed, event=".concat(r5.getClass().getSimpleName()), e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(com.larus.audio.call.arch.c r2, a3a.b r3, Function1<? super a3a.a.d, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "eventListener");
        Intrinsics.checkNotNullParameter(r4, "onFailure");
        super(r2);
        this.f = r3;
        this.g = r4;
        this.h = "AutoStopAsrEventPlugin";
        this.j = new C0013b(this);
    }
}
