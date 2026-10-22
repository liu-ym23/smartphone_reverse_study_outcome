package com.larus.audio.call.plugins;

import com.larus.audio.call.HangUpState;
import com.larus.audio.call.dora.CommandStatus;
import com.larus.audio.call.mgr.MajorState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c0 extends com.larus.audio.call.p {
    public final /* synthetic */ CommonCallTimingPlugin<com.larus.audio.call.arch.c> g;
    public final /* synthetic */ com.larus.audio.call.arch.c h;

    @Override // com.larus.audio.call.p
    public final void b() {
        CommonCallTimingPlugin<com.larus.audio.call.arch.c> r0 = this.g;
        com.larus.audio.call.arch.c r1 = this.h;
        r0.getClass();
        com.larus.audio.call.util.e.a.i(r0.T2(), "[onFinishCallTimerFinish]");
        r0.q.a();
        MajorState r2 = r1.a().s1();
        if (((Boolean) r0.k.getValue()).booleanValue() == true) goto L6;
        r0.p.invoke(0L);
        return;
    L6:
        if ((r2 instanceof MajorState.g) == false) goto L12;
        com.larus.audio.call.h r3 = r0.l;
        if (r3 == null) goto L10;
        r3.a(HangUpState.FINISH);
    L10:
        r0.o.invoke();
        return;
    L12:
        if (r0.q.e == false) goto L17;
        com.larus.audio.call.h r4 = r0.l;
        if (r4 == null) goto L36;
        r4.a(HangUpState.WAIT_LAST_AUDIO);
        return;
    L36:
        return;
    L17:
        if ((r2 instanceof MajorState.i) == false) goto L19;
    L30:
        com.larus.audio.call.h r5 = r0.l;
        if (r5 == null) goto L41;
        r5.a(HangUpState.WAIT_LAST_AUDIO);
        return;
    L41:
        return;
    L19:
        if ((r2 instanceof MajorState.h) == true) goto L30;
        if ((r2 instanceof MajorState.f) == false) goto L27;
        com.larus.audio.call.h r6 = r0.l;
        if (r6 == null) goto L26;
        r6.a(HangUpState.FINISH);
    L26:
        r0.o.invoke();
        return;
    L27:
        r0.n.invoke("", r1.params().p.i);
        com.larus.audio.call.h r7 = r0.l;
        if (r7 == null) goto L39;
        r7.a(HangUpState.SEND_EVENT);
        return;
    }

    @Override // com.larus.audio.call.p
    public final void c(long r5) {
        CommonCallTimingPlugin<com.larus.audio.call.arch.c> r0 = this.g;
        if (((Boolean) r0.k.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        if (r5 >= 60000) goto L9;
        r0.p.invoke(Long.valueOf(r5 / ((long) CommandStatus.DORA_TRACE)));
        return;
    }

    public c0(com.larus.voicecall.impl.plugins.g1 r1, com.larus.audio.call.arch.c r2, long r3) {
        this.g = r1;
        this.h = r2;
        super(r3, 1000);
    }
}
