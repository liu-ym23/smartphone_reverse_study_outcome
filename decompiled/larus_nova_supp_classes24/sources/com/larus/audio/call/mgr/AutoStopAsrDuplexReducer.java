package com.larus.audio.call.mgr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J.\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/audio/call/mgr/AutoStopAsrDuplexReducer;", "Lcom/larus/audio/call/mgr/DuplexReducer;", "<init>", "()V", "reduceUp", "Lcom/larus/audio/call/mgr/Transition;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;", "state", "event", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "pending", "Lcom/larus/audio/call/mgr/PendingSlot;", "reduceDown", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AutoStopAsrDuplexReducer implements UpStateReducer, DownStateReducer {
    public AutoStopAsrDuplexReducer() {
    }

    @Override // com.larus.audio.call.mgr.UpStateReducer
    public final h a(AVKitDuplexState.UpState r4, StateTriggerEvent r5, b.C0080b r6) {
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r6, "pending");
        if ((r4 instanceof AVKitCoreStates$Finished) == false) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.Stop.a) == true) goto L43;
        boolean r7 = r4 instanceof AVKitCoreStates$Connecting;
        if (r7 == false) goto L11;
    L13:
        if (r7 == false) goto L18;
        if (Intrinsics.areEqual(r5, StateTriggerEvent.Connected.a) == false) goto L18;
        return i.a(new AVKitCoreStates$Listening(r5));
    L18:
        if ((r5 instanceof StateTriggerEvent.Error) == false) goto L20;
        int r8 = i.a;
        StateTriggerEvent.Error r9 = (StateTriggerEvent.Error) r5;
        return i.a(new AVKitCoreStates$Error(r9.a, r9.b, r9.c, r5));
    L20:
        boolean r10 = r4 instanceof AVKitCoreStates$Listening;
        if (r10 == true) goto L23;
    L25:
        boolean r1 = r4 instanceof AVKitCoreStates$Recognizing;
        if (r1 == true) goto L28;
    L32:
        if (r10 == true) goto L35;
        if (r1 == true) goto L35;
    L38:
        if ((r4 instanceof AVKitCoreStates$Paused) == true) goto L40;
        return null;
    L40:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.Resume.a) == true) goto L42;
        return null;
    L42:
        return i.a(new AVKitCoreStates$Listening(r5));
    L35:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.Pause.a) == false) goto L38;
        return i.a(new AVKitCoreStates$Paused(r5, null));
    L28:
        if ((r5 instanceof StateTriggerEvent.QueryEnd) == true) goto L48;
        if (Intrinsics.areEqual(r5, StateTriggerEvent.Interrupt.a) == false) goto L32;
    L48:
        return i.a(new AVKitCoreStates$Listening(r5));
    L23:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.QueryBegin.a) == false) goto L25;
        return i.a(new AVKitCoreStates$Recognizing(r5));
    L11:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.Connect.a) == false) goto L13;
        return i.a(new AVKitCoreStates$Connecting(r5));
    L43:
        return i.a(new AVKitCoreStates$Finished(r5));
    }

    @Override // com.larus.audio.call.mgr.DownStateReducer
    public final h b(AVKitDuplexState.DownState r3, StateTriggerEvent r4, b.C0080b r5) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "pending");
        if ((r3 instanceof AVKitCoreStates$Finished) == false) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r4, StateTriggerEvent.Stop.a) == true) goto L31;
        boolean r6 = r3 instanceof AVKitCoreStates$Connecting;
        if (r6 == false) goto L11;
    L13:
        if (r6 == false) goto L18;
        if (Intrinsics.areEqual(r4, StateTriggerEvent.Connected.a) == false) goto L18;
        return e.a(new AVKitCoreStates$DownWaiting(r4));
    L18:
        if ((r4 instanceof StateTriggerEvent.Error) == false) goto L21;
        int r7 = e.a;
        StateTriggerEvent.Error r8 = (StateTriggerEvent.Error) r4;
        return e.a(new AVKitCoreStates$Error(r8.a, r8.b, r8.c, r4));
    L21:
        if ((r3 instanceof AVKitCoreStates$DownWaiting) == false) goto L26;
        if (Intrinsics.areEqual(r4, StateTriggerEvent.Pause.a) == false) goto L26;
        return e.a(new AVKitCoreStates$Paused(r4, null));
    L26:
        if ((r3 instanceof AVKitCoreStates$Paused) == true) goto L28;
        return null;
    L28:
        if (Intrinsics.areEqual(r4, StateTriggerEvent.Resume.a) == true) goto L30;
        return null;
    L30:
        return e.a(new AVKitCoreStates$DownWaiting(r4));
    L11:
        if (Intrinsics.areEqual(r4, StateTriggerEvent.Connect.a) == false) goto L13;
        return e.a(new AVKitCoreStates$Connecting(r4));
    L31:
        return e.a(new AVKitCoreStates$Finished(r4));
    }
}
