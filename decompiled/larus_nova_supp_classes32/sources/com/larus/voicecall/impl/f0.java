package com.larus.voicecall.impl;

import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f0 {
    public static final StateTriggerEvent.Error a(AVKitDuplexState r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        AVKitCoreStates.Error r0 = r3.getUpState();
        if ((r0 instanceof AVKitCoreStates.Error) == false) goto L5;
        AVKitCoreStates.Error r1 = r0;
    L6:
        if (r1 == null) goto L8;
        StateTriggerEvent r2 = r1.getTriggerBy();
    L10:
        if ((r2 instanceof StateTriggerEvent.Error) == false) goto L12;
        StateTriggerEvent.Error r4 = (StateTriggerEvent.Error) r2;
    L13:
        if (r4 != null) goto L25;
        AVKitCoreStates.Error r5 = r3.getDownState();
        if ((r5 instanceof AVKitCoreStates.Error) == false) goto L17;
        AVKitCoreStates.Error r6 = r5;
    L18:
        if (r6 == null) goto L20;
        StateTriggerEvent r7 = r6.getTriggerBy();
    L22:
        if ((r7 instanceof StateTriggerEvent.Error) == true) goto L27;
        return null;
    L27:
        return (StateTriggerEvent.Error) r7;
    L20:
        r7 = null;
        goto L22
    L17:
        r6 = null;
        goto L18
    L25:
        return r4;
    L12:
        r4 = null;
        goto L13
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static final boolean b(c0 r3, String r4, AVKitDuplexState r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "callId");
        Intrinsics.checkNotNullParameter(r5, "state");
        if (Intrinsics.areEqual(r3.a, r4) == false) goto L26;
        StateTriggerEvent r6 = r3.b;
        AVKitCoreStates.Error r7 = r5.getUpState();
        StateTriggerEvent r2 = null;
        if ((r7 instanceof AVKitCoreStates.Error) == false) goto L7;
        AVKitCoreStates.Error r8 = r7;
    L8:
        if (r8 == null) goto L10;
        StateTriggerEvent r9 = r8.getTriggerBy();
    L12:
        if (r9 == r6) goto L22;
        AVKitCoreStates.Error r10 = r5.getDownState();
        if ((r10 instanceof AVKitCoreStates.Error) == false) goto L16;
        AVKitCoreStates.Error r11 = r10;
    L17:
        if (r11 == null) goto L19;
        r2 = r11.getTriggerBy();
    L19:
        if (r2 == r6) goto L22;
        boolean r12 = false;
    L23:
        if (r12 == false) goto L27;
        return true;
    L27:
        return false;
    L16:
        r11 = null;
    L22:
        r12 = true;
        goto L23
    L10:
        r9 = null;
        goto L12
    L7:
        r8 = null;
        goto L8
    L26:
        return false;
    }
}
