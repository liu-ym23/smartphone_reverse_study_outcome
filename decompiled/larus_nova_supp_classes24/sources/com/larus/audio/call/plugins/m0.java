package com.larus.audio.call.plugins;

import com.larus.audio.call.mgr.AVKitCoreStates$Connecting;
import com.larus.audio.call.mgr.AVKitCoreStates$DownWaiting;
import com.larus.audio.call.mgr.AVKitCoreStates$Error;
import com.larus.audio.call.mgr.AVKitCoreStates$Invalid;
import com.larus.audio.call.mgr.AVKitCoreStates$Listening;
import com.larus.audio.call.mgr.AVKitCoreStates$Paused;
import com.larus.audio.call.mgr.AVKitCoreStates$Recognizing;
import com.larus.audio.call.mgr.AVKitCoreStates$Speaking;
import com.larus.audio.call.mgr.AVKitCoreStates$Thinking;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m0 {
    public static final boolean a(AVKitDuplexState r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1.getUpState() instanceof AVKitCoreStates$Listening) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r1.getDownState() instanceof AVKitCoreStates$DownWaiting) == false) goto L9;
        if (Intrinsics.areEqual(((AVKitCoreStates$DownWaiting) r1.getDownState()).getTriggerBy(), StateTriggerEvent.PlayEnd.a) == false) goto L9;
        return true;
    }

    public static final int b(AVKitDuplexState r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        AVKitDuplexState.UpState r0 = r4.getUpState();
        AVKitDuplexState.DownState r6 = r4.getDownState();
        if ((r0 instanceof AVKitCoreStates$Invalid) == false) goto L6;
        return -1;
    L6:
        if ((r0 instanceof AVKitCoreStates$Error) == false) goto L8;
    L62:
        return 6;
    L8:
        if ((r6 instanceof AVKitCoreStates$Error) == true) goto L62;
        if ((r0 instanceof AVKitCoreStates$Connecting) == false) goto L13;
    L53:
        StateTriggerEvent r7 = r0.getTriggerBy();
        StateTriggerEvent.SceneSwitched r1 = StateTriggerEvent.SceneSwitched.a;
        if (Intrinsics.areEqual(r7, r1) == false) goto L56;
    L59:
        boolean r8 = true;
    L60:
        if (r8 == false) goto L73;
        return 12;
    L73:
        return 1;
    L56:
        if (Intrinsics.areEqual(r6.getTriggerBy(), r1) == true) goto L59;
        r8 = false;
        goto L60
    L13:
        if ((r6 instanceof AVKitCoreStates$Connecting) == true) goto L53;
        if ((r0 instanceof AVKitCoreStates$Paused) == false) goto L18;
    L52:
        return 7;
    L18:
        if ((r6 instanceof AVKitCoreStates$Paused) == true) goto L52;
        boolean r2 = r0 instanceof AVKitCoreStates$Recognizing;
        if (r2 == false) goto L27;
        if ((r6 instanceof AVKitCoreStates$Speaking) == false) goto L27;
        if (r5 == false) goto L27;
        return 17;
    L27:
        if ((r6 instanceof AVKitCoreStates$Speaking) == false) goto L30;
        return 5;
    L30:
        if ((r6 instanceof WaitingHello) == false) goto L33;
        return 9;
    L33:
        if ((r6 instanceof AVKitCoreStates$Thinking) == false) goto L36;
        return 4;
    L36:
        if (r2 == false) goto L39;
    L37:
        return 3;
    L39:
        if ((r0 instanceof AVKitCoreStates$Listening) == true) goto L41;
        return -1;
    L41:
        if ((r6 instanceof AVKitCoreStates$DownWaiting) == false) goto L70;
        StateTriggerEvent r9 = r6.getTriggerBy();
        if (Intrinsics.areEqual(r9, StateTriggerEvent.PlayEnd.a) == true) goto L37;
        if (Intrinsics.areEqual(r9, StateTriggerEvent.Interrupt.a) == true) goto L37;
        if (Intrinsics.areEqual(r9, StateTriggerEvent.TtsStreamEnd.a) == true) goto L37;
        if (Intrinsics.areEqual(r9, StateTriggerEvent.Resume.a) == true) goto L37;
        return 2;
    L70:
        return -1;
    }
}
