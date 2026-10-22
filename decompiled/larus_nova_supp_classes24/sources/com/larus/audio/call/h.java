package com.larus.audio.call;

import com.larus.audio.call.plugins.CommonCallTimingPlugin;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h {
    public final IRealtimeCallTracer a;
    public final a b;
    public final buc.e<HangUpState> c;

    public static abstract class a {
        public final com.larus.audio.call.tracer.b a;

        public abstract void a();

        public abstract void b(RealtimeCallParam r1);

        public abstract void c(RealtimeCallParam r1);

        public a(com.larus.audio.call.tracer.b r2) {
            Intrinsics.checkNotNullParameter(r2, "traceSpan");
            this.a = r2;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[HangUpState.values().length];
            r0[HangUpState.WAIT_LAST_AUDIO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[HangUpState.SEND_EVENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[HangUpState.IDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[HangUpState.FINISH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public final void a(HangUpState r2) {
        Intrinsics.checkNotNullParameter(r2, "target");
        this.c.d(r2);
    }

    public h(IRealtimeCallTracer r2, CommonCallTimingPlugin.c r3) {
        Intrinsics.checkNotNullParameter(r2, "tracer");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        this.a = r2;
        this.b = r3;
        this.c = buc.b.d(HangUpState.IDLE);
    }
}
