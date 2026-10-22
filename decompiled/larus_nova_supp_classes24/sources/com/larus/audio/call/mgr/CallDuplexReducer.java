package com.larus.audio.call.mgr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J.\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/audio/call/mgr/CallDuplexReducer;", "Lcom/larus/audio/call/mgr/DuplexReducer;", "<init>", "()V", "reduceUp", "Lcom/larus/audio/call/mgr/Transition;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;", "state", "event", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "pending", "Lcom/larus/audio/call/mgr/PendingSlot;", "reduceDown", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CallDuplexReducer implements UpStateReducer, DownStateReducer {
    public CallDuplexReducer() {
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
    public final h b(AVKitDuplexState.DownState r4, StateTriggerEvent r5, b.C0080b r6) {
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r6, "pending");
        if ((r4 instanceof AVKitCoreStates$Finished) == false) goto L6;
    L88:
        return null;
    L6:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.Stop.a) == true) goto L90;
        boolean r7 = r4 instanceof AVKitCoreStates$Connecting;
        if (r7 == false) goto L11;
    L13:
        if (r7 == false) goto L18;
        if (Intrinsics.areEqual(r5, StateTriggerEvent.Connected.a) == false) goto L18;
        return e.a(new AVKitCoreStates$DownWaiting(r5));
    L18:
        if ((r5 instanceof StateTriggerEvent.Error) == false) goto L20;
        int r8 = e.a;
        StateTriggerEvent.Error r9 = (StateTriggerEvent.Error) r5;
        return e.a(new AVKitCoreStates$Error(r9.a, r9.b, r9.c, r5));
    L20:
        boolean r10 = r4 instanceof AVKitCoreStates$DownWaiting;
        if (r10 == true) goto L23;
    L25:
        boolean r0 = r4 instanceof AVKitCoreStates$Thinking;
        if (r0 == true) goto L28;
    L30:
        if (r10 == false) goto L35;
        if (Intrinsics.areEqual(r5, StateTriggerEvent.ReplyStart.a) == false) goto L35;
        return e.a(new AVKitCoreStates$Speaking(r5));
    L35:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.RequestThinking.a) == false) goto L42;
        if (r10 == true) goto L97;
        if (r0 == true) goto L97;
        if ((r4 instanceof AVKitCoreStates$Speaking) == false) goto L42;
    L97:
        return e.a(new AVKitCoreStates$Thinking(r5));
    L42:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.RequestSpeaking.a) == false) goto L47;
        if (r10 == true) goto L98;
        if (r0 == false) goto L47;
    L98:
        return e.a(new AVKitCoreStates$Speaking(r5));
    L47:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.RequestWaiting.a) == false) goto L52;
        if (r0 == true) goto L99;
        if ((r4 instanceof AVKitCoreStates$Speaking) == false) goto L52;
    L99:
        return e.a(new AVKitCoreStates$DownWaiting(r5));
    L52:
        boolean r1 = r4 instanceof AVKitCoreStates$Speaking;
        if (r1 == true) goto L55;
    L61:
        if (r0 == true) goto L64;
        if (r1 == true) goto L64;
    L68:
        if (r0 == true) goto L70;
    L74:
        if (r10 == true) goto L78;
        if (r0 == true) goto L78;
        if (r1 == true) goto L78;
    L81:
        if ((r4 instanceof AVKitCoreStates$Paused) == false) goto L88;
        if (Intrinsics.areEqual(r5, StateTriggerEvent.Resume.a) == false) goto L88;
        int r11 = e.a;
        AVKitDuplexState.DownState r12 = ((AVKitCoreStates$Paused) r4).b;
        if (r12 != null) goto L104;
        r12 = new AVKitCoreStates$DownWaiting(r5);
    L104:
        return e.a(r12);
    L78:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.Pause.a) == false) goto L81;
        return e.a(new AVKitCoreStates$Paused(r5, r4));
    L70:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.Interrupt.a) == true) goto L102;
        if (Intrinsics.areEqual(r5, StateTriggerEvent.QueryBegin.a) == false) goto L74;
    L102:
        return e.a(new AVKitCoreStates$DownWaiting(r5));
    L64:
        if ((r5 instanceof StateTriggerEvent.CurrentReplyPlayEnd) == false) goto L68;
        if (((StateTriggerEvent.CurrentReplyPlayEnd) r5).a != r4) goto L68;
        int r13 = e.a;
        return e.a(new AVKitCoreStates$DownWaiting(StateTriggerEvent.PlayEnd.a));
    L55:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.PlayEnd.a) == true) goto L100;
        if (Intrinsics.areEqual(r5, StateTriggerEvent.Interrupt.a) == true) goto L100;
        if (Intrinsics.areEqual(r5, StateTriggerEvent.QueryBegin.a) == false) goto L61;
    L100:
        return e.a(new AVKitCoreStates$DownWaiting(r5));
    L28:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.ReplyStart.a) == false) goto L30;
        return e.a(new AVKitCoreStates$Speaking(r5));
    L23:
        if ((r5 instanceof StateTriggerEvent.QueryEnd) == false) goto L25;
        return e.a(new AVKitCoreStates$Thinking(r5));
    L11:
        if (Intrinsics.areEqual(r5, StateTriggerEvent.Connect.a) == false) goto L13;
        return e.a(new AVKitCoreStates$Connecting(r5));
    L90:
        return e.a(new AVKitCoreStates$Finished(r5));
    }
}
