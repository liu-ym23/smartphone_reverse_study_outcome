package com.larus.voicecall.impl.plugins;

import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.plugins.CommonCallTimingPlugin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g1 extends CommonCallTimingPlugin<r> {
    public final String u;

    public static final class a implements com.larus.im.service.audio.v {
        public final String a;
        public final /* synthetic */ g1 b;

        public final String getName() {
            return this.a;
        }

        public a(g1 r1) {
            this.b = r1;
            this.a = r1.u;
        }

        public final void O1(jd9.c r6, jd9.c r7) {
            Intrinsics.checkNotNullParameter(r6, "oldState");
            Intrinsics.checkNotNullParameter(r7, "newState");
            if ((r7 instanceof jd9.c.a) == false) goto L27;
            g1 r8 = this.b;
            com.larus.audio.call.arch.c r9 = r8.getContext();
            Intrinsics.checkNotNullParameter(r9, "context");
            Integer r0 = com.larus.audio.call.f.d().u;
            if (r0 != null) goto L7;
        L10:
            int r1 = r9.params().k.k;
        L11:
            int r2 = RangesKt.coerceAtLeast(r1 - ((int) (((CommonCallTimingPlugin) r8).i / ((long) 1000))), 1);
            ((CommonCallTimingPlugin) r8).i = 0;
            com.larus.audio.call.util.e r3 = com.larus.audio.call.util.e.a;
            r3.i(r8.u, "[startCountdownTimer] durationSecond:" + r2);
            if (com.larus.audio.call.f.f() == true) goto L14;
            MajorState r4 = r9.a().s1();
            if ((r4 instanceof MajorState.j) == false) goto L21;
            if (r8.l3(r9) == true) goto L21;
        L22:
            r3.i(r8.u, "[observeCallStateAndTryStartTriggerWaitTimer] try start wait trigger timer");
            ((CommonCallTimingPlugin) r8).q.b();
        L24:
            if (((CommonCallTimingPlugin) r8).g != null) goto L28;
            r3.i(r8.u, "[startCountdownTimer] create new timer");
            com.larus.audio.call.plugins.c0 r5 = new com.larus.audio.call.plugins.c0(r8, r9, ((long) r2) * 1000);
            ((CommonCallTimingPlugin) r8).g = r5;
            r5.d();
            return;
        L28:
            return;
        L21:
            if ((r4 instanceof MajorState.d) == false) goto L24;
        L14:
            if (com.larus.audio.call.plugins.d0.a((AVKitDuplexState) r9.a().y().getValue()) == false) goto L24;
            ((CommonCallTimingPlugin) r8).q.b();
            goto L24
        L7:
            if (r0.intValue() <= 0) goto L10;
            r1 = r0.intValue();
            goto L11
        }
    }

    public final com.larus.im.service.audio.v R2() {
        return new a(this);
    }

    public final void j3() {
        com.larus.voicecall.impl.q r0 = ((r) getContext()).h();
        if (r0 == null) goto L6;
        r0.d("reach_single_time_limit");
        return;
    }

    public final String T2() {
        return this.u;
    }

    public g1(r r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.u = "RealtimeCallTimingPlugin";
    }

    public final void k3(long r2) {
        com.larus.voicecall.impl.q r0 = ((r) getContext()).h();
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    public final boolean l3(com.larus.audio.call.arch.c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        com.larus.audio.call.plugins.y0 r3 = com.larus.audio.call.arch.b.d(r2);
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.b1();
    }
}
