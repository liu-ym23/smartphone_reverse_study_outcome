package com.larus.voicecall.impl.ui;

import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.CallDuplexStates;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import com.larus.audio.call.plugins.WaitingHello;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p {
    public static final MajorState a(AVKitDuplexState r3) {
        AVKitCoreStates.Error r0 = r3.getUpState();
        AVKitCoreStates.Error r4 = r3.getDownState();
        if ((r0 instanceof AVKitCoreStates.Invalid) == false) goto L6;
        return MajorState.c.c;
    L6:
        if ((r0 instanceof AVKitCoreStates.Error) == false) goto L9;
        return b(r0);
    L9:
        if ((r4 instanceof AVKitCoreStates.Error) == false) goto L12;
        return b(r4);
    L12:
        if ((r0 instanceof AVKitCoreStates.Connecting) == true) goto L68;
        if ((r4 instanceof AVKitCoreStates.Connecting) == true) goto L68;
        if ((r0 instanceof AVKitCoreStates.Paused) == true) goto L81;
        if ((r4 instanceof AVKitCoreStates.Paused) == true) goto L81;
        if ((r4 instanceof AVKitCoreStates.Speaking) == false) goto L25;
        return MajorState.h.c;
    L25:
        if ((r4 instanceof CallDuplexStates.DeepThinking) == false) goto L28;
        return new MajorState.i.a();
    L28:
        if ((r4 instanceof WaitingHello) == false) goto L31;
        return MajorState.j.c;
    L31:
        if ((r4 instanceof AVKitCoreStates.Thinking) == false) goto L34;
        return new MajorState.i();
    L34:
        if ((r0 instanceof AVKitCoreStates.Recognizing) == false) goto L42;
        MajorState.From r1 = MajorState.From.ASR;
        if (Intrinsics.areEqual(r4.getTriggerBy(), StateTriggerEvent.QueryBegin.a) == false) goto L38;
        MajorState.InterruptType r5 = MajorState.InterruptType.AUTO;
    L39:
        MajorState.d r2 = new MajorState.d(r1, r5);
    L76:
        return r2;
    L38:
        r5 = MajorState.InterruptType.NOTHING;
        goto L39
    L42:
        if ((r0 instanceof AVKitCoreStates.Listening) == false) goto L80;
        if ((r4 instanceof AVKitCoreStates.DownWaiting) == false) goto L80;
        StateTriggerEvent r6 = r4.getTriggerBy();
        if (Intrinsics.areEqual(r6, StateTriggerEvent.PlayEnd.a) == false) goto L48;
    L57:
        MajorState.From r7 = MajorState.From.PLAY_COMPLETE;
        StateTriggerEvent r8 = r4.getTriggerBy();
        if (Intrinsics.areEqual(r8, StateTriggerEvent.Interrupt.a) == false) goto L61;
        MajorState.InterruptType r9 = MajorState.InterruptType.USER;
    L64:
        r2 = new MajorState.d(r7, r9);
        goto L76
    L61:
        if (Intrinsics.areEqual(r8, StateTriggerEvent.QueryBegin.a) == false) goto L63;
        r9 = MajorState.InterruptType.AUTO;
        goto L64
    L63:
        r9 = MajorState.InterruptType.NOTHING;
        goto L64
    L48:
        if (Intrinsics.areEqual(r6, StateTriggerEvent.Interrupt.a) == true) goto L57;
        if (Intrinsics.areEqual(r6, StateTriggerEvent.TtsStreamEnd.a) == false) goto L54;
        return new MajorState.d(MajorState.From.TTS_ENDED, MajorState.InterruptType.NOTHING);
    L54:
        if (Intrinsics.areEqual(r6, StateTriggerEvent.Resume.a) == false) goto L79;
        return new MajorState.d(MajorState.From.RESUME, MajorState.InterruptType.NOTHING);
    L79:
        return MajorState.j.c;
    L80:
        return MajorState.c.c;
    L81:
        return new MajorState.g(MajorState.c.c);
    L68:
        return MajorState.a.c;
    }

    public static final MajorState.f b(AVKitCoreStates.Error r4) {
        Object r0 = r4.c.get("vui_error_code");
        Integer r2 = null;
        if ((r0 instanceof Integer) == false) goto L5;
        Integer r1 = (Integer) r0;
    L6:
        if (r1 == null) goto L8;
        int r3 = r1.intValue();
    L9:
        Object r5 = r4.c.get("sub_error_code");
        if ((r5 instanceof Integer) == false) goto L13;
        r2 = (Integer) r5;
    L13:
        return new MajorState.f(r4.a, r3, r4.b, r2);
    L8:
        r3 = -1;
        goto L9
    L5:
        r1 = null;
        goto L6
    }
}
