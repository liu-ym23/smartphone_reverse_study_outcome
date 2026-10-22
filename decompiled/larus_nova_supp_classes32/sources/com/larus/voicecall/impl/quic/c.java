package com.larus.voicecall.impl.quic;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.f;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements f.a {
    public final /* synthetic */ QuicCallService a;

    public c(QuicCallService r1) {
        this.a = r1;
    }

    public final void Q(MajorState r5, MajorState r6) {
        Intrinsics.checkNotNullParameter(r5, "prev");
        Intrinsics.checkNotNullParameter(r6, "current");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("CallStateManager connectionState, callId id : ");
        RealtimeCallParam r2 = this.a.t;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.e;
    L6:
        r1.append(r4);
        r1.append(" , room id : ");
        RealtimeCallParam r7 = this.a.t;
        if (r7 == null) goto L9;
        r3 = r7.d;
    L9:
        r1.append(r3);
        r1.append(" , prev:  ");
        r1.append(r5.b);
        r1.append(" -> current: ");
        r1.append(r6.b);
        r0.i("QuicCallService", r1.toString());
        if ((r6 instanceof MajorState.f) == false) goto L13;
        this.a.j();
        return;
    L13:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
