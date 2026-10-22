package com.larus.audio.call.mgr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import s68.j;
import s68.k;
import s68.l;
import s68.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ObricContTalkStateMachine {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/call/mgr/ObricContTalkStateMachine$RecPreEnding;", "Lcom/larus/audio/call/mgr/AVKitCoreStates$Recognizing;", "triggerBy", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "(Lcom/larus/audio/call/mgr/StateTriggerEvent;)V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class RecPreEnding extends AVKitCoreStates$Recognizing {
        public RecPreEnding(StateTriggerEvent r1) {
            super(r1);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J.\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/audio/call/mgr/ObricContTalkStateMachine$Reducer;", "Lcom/larus/audio/call/mgr/DuplexReducer;", "<init>", "()V", "reduceUp", "Lcom/larus/audio/call/mgr/Transition;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;", "state", "event", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "pending", "Lcom/larus/audio/call/mgr/PendingSlot;", "reduceDown", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Reducer implements UpStateReducer, DownStateReducer {
        public Reducer() {
        }

        @Override // com.larus.audio.call.mgr.UpStateReducer
        public final h a(AVKitDuplexState.UpState r6, StateTriggerEvent r7, b.C0080b r8) {
            Intrinsics.checkNotNullParameter(r6, "state");
            Intrinsics.checkNotNullParameter(r7, "event");
            Intrinsics.checkNotNullParameter(r8, "pending");
            int r9 = ObricContTalkStateMachine.a;
            if ((r6 instanceof AVKitCoreStates$Finished) == false) goto L8;
            if (Intrinsics.areEqual(r7, StateTriggerEvent.Reset.a) == false) goto L8;
            h r10 = i.a(new AVKitCoreStates$Invalid());
        L66:
            if (r10 == null) goto L68;
            com.larus.audio.call.util.e.a.i("ObricContTalkStateMachine", "[reduceUpState-move]: current:" + r6.toSimpleString() + " -> event:" + Reflection.getOrCreateKotlinClass(r7.getClass()).getSimpleName() + " -> new:" + ((AVKitDuplexState.UpState) r10.a).toSimpleString());
        L69:
            return r10;
        L68:
            com.larus.audio.call.util.e.a.w("ObricContTalkStateMachine", "[reduceUpState-skip] current:" + r6.toSimpleString() + " -> event:" + Reflection.getOrCreateKotlinClass(r7.getClass()).getSimpleName());
        L8:
            if (Intrinsics.areEqual(r7, StateTriggerEvent.Stop.a) == false) goto L11;
            r10 = i.a(new AVKitCoreStates$Finished(r7));
            goto L66
        L11:
            if ((r6 instanceof AVKitCoreStates$Invalid) == false) goto L16;
            if (Intrinsics.areEqual(r7, StateTriggerEvent.Connect.a) == false) goto L16;
            r10 = i.a(new AVKitCoreStates$Connecting(r7));
        L16:
            if ((r6 instanceof AVKitDuplexState.UpState.Active) == false) goto L21;
            if ((r7 instanceof StateTriggerEvent.Error) == false) goto L21;
            int r11 = i.a;
            StateTriggerEvent.Error r0 = (StateTriggerEvent.Error) r7;
            r10 = i.a(new AVKitCoreStates$Error(r0.a, r0.b, r0.c, r7));
        L21:
            if ((r6 instanceof AVKitCoreStates$Error) == false) goto L26;
            if (Intrinsics.areEqual(r7, StateTriggerEvent.Connect.a) == false) goto L26;
            r10 = i.a(new AVKitCoreStates$Connecting(r7));
        L26:
            if ((r6 instanceof AVKitCoreStates$Connecting) == true) goto L28;
        L30:
            boolean r12 = r6 instanceof AVKitCoreStates$Listening;
            if (r12 == true) goto L33;
        L36:
            if (r12 == true) goto L38;
        L40:
            boolean r13 = r6 instanceof AVKitCoreStates$Recognizing;
            if (r13 == false) goto L48;
            if ((r6 instanceof RecPreEnding) == true) goto L48;
            if (Intrinsics.areEqual(r7, ObricContTalkStateMachine$TriggerEvent$PrefetchASR.INSTANCE) == false) goto L48;
            r10 = i.a(new RecPreEnding(r7));
        L48:
            if ((r6 instanceof RecPreEnding) == true) goto L50;
        L52:
            if (r13 == true) goto L54;
        L56:
            if (r13 == true) goto L58;
        L60:
            if (r13 == true) goto L62;
        L64:
            r10 = null;
            goto L66
        L62:
            if (Intrinsics.areEqual(r7, ObricContTalkStateMachine$TriggerEvent$QueryRejected.INSTANCE) == false) goto L64;
            r10 = i.a(new AVKitCoreStates$Listening(r7));
            goto L66
        L58:
            if ((r7 instanceof StateTriggerEvent.QueryEnd) == false) goto L60;
            r10 = i.a(new AVKitCoreStates$Listening(r7));
            goto L66
        L54:
            if (Intrinsics.areEqual(r7, StateTriggerEvent.Pause.a) == false) goto L56;
            int r14 = i.a;
            AVKitCoreStates$Paused r15 = new AVKitCoreStates$Paused(r7, null);
            Function1 r2 = new j();
            Intrinsics.checkNotNullParameter(r15, "next");
            Intrinsics.checkNotNullParameter(r2, "configurePending");
            int r3 = h.c;
            Intrinsics.checkNotNullParameter(r15, "next");
            Intrinsics.checkNotNullParameter(r2, "configurePending");
            h r1 = new h(r15, r2);
        L35:
            r10 = r1;
            goto L66
        L50:
            if (Intrinsics.areEqual(r7, ObricContTalkStateMachine$TriggerEvent$NormalASR.INSTANCE) == false) goto L52;
            r10 = i.a(new AVKitCoreStates$Recognizing(r7));
            goto L66
        L38:
            if (Intrinsics.areEqual(r7, StateTriggerEvent.QueryBegin.a) == false) goto L40;
            r10 = i.a(new AVKitCoreStates$Recognizing(r7));
            goto L66
        L33:
            if (Intrinsics.areEqual(r7, StateTriggerEvent.Pause.a) == false) goto L36;
            int r16 = i.a;
            AVKitCoreStates$Paused r17 = new AVKitCoreStates$Paused(r7, null);
            Function1 r4 = new s68.i();
            Intrinsics.checkNotNullParameter(r17, "next");
            Intrinsics.checkNotNullParameter(r4, "configurePending");
            int r5 = h.c;
            Intrinsics.checkNotNullParameter(r17, "next");
            Intrinsics.checkNotNullParameter(r4, "configurePending");
            r1 = new h(r17, r4);
            goto L35
        L28:
            if (Intrinsics.areEqual(r7, StateTriggerEvent.Connected.a) == false) goto L30;
            r10 = i.a(new AVKitCoreStates$Listening(r7));
            goto L66
        }

        @Override // com.larus.audio.call.mgr.DownStateReducer
        public final h b(AVKitDuplexState.DownState r4, StateTriggerEvent r5, b.C0080b r6) {
            Intrinsics.checkNotNullParameter(r4, "state");
            Intrinsics.checkNotNullParameter(r5, "event");
            Intrinsics.checkNotNullParameter(r6, "pending");
            int r7 = ObricContTalkStateMachine.a;
            if ((r4 instanceof AVKitCoreStates$Finished) == false) goto L8;
            if (Intrinsics.areEqual(r5, StateTriggerEvent.Reset.a) == false) goto L8;
            return e.a(new AVKitCoreStates$Invalid());
        L8:
            if (Intrinsics.areEqual(r5, StateTriggerEvent.Stop.a) == false) goto L11;
            return e.a(new AVKitCoreStates$Finished(r5));
        L11:
            if ((r4 instanceof AVKitCoreStates$Invalid) == false) goto L16;
            if (Intrinsics.areEqual(r5, StateTriggerEvent.Connect.a) == false) goto L16;
            return e.b(new AVKitCoreStates$Connecting(r5), new k());
        L16:
            if ((r4 instanceof AVKitDuplexState.DownState.Active) == false) goto L21;
            if ((r5 instanceof StateTriggerEvent.Error) == false) goto L21;
            int r8 = e.a;
            StateTriggerEvent.Error r9 = (StateTriggerEvent.Error) r5;
            return e.a(new AVKitCoreStates$Error(r9.a, r9.b, r9.c, r5));
        L21:
            if ((r4 instanceof AVKitCoreStates$Error) == false) goto L26;
            if (Intrinsics.areEqual(r5, StateTriggerEvent.Connect.a) == false) goto L26;
            return e.a(new AVKitCoreStates$Connecting(r5));
        L26:
            if ((r4 instanceof AVKitCoreStates$Connecting) == true) goto L28;
        L30:
            boolean r10 = r4 instanceof AVKitCoreStates$DownWaiting;
            if (r10 == false) goto L38;
            if ((r5 instanceof StateTriggerEvent.QueryEnd) == false) goto L38;
            if (((StateTriggerEvent.QueryEnd) r5).a == true) goto L38;
            return e.a(new AVKitCoreStates$Thinking(r5));
        L38:
            if (r10 == true) goto L40;
        L42:
            if (r10 == true) goto L44;
        L46:
            boolean r11 = r4 instanceof AVKitCoreStates$Thinking;
            if (r11 == true) goto L49;
        L51:
            if (r11 == true) goto L53;
        L55:
            boolean r1 = r4 instanceof AVKitCoreStates$Speaking;
            if (r1 == true) goto L58;
        L60:
            if (r1 == true) goto L62;
        L64:
            if (r1 == true) goto L66;
        L70:
            if (r1 == true) goto L72;
        L74:
            if (r11 == true) goto L77;
            if (r1 == true) goto L77;
        L81:
            if (r1 == false) goto L88;
            if ((r4 instanceof WhisperSpeaking) == true) goto L88;
            if (Intrinsics.areEqual(r5, ObricContTalkStateMachine$TriggerEvent$PreInterrupt.INSTANCE) == false) goto L88;
            return e.a(new WhisperSpeaking(r5));
        L88:
            if ((r4 instanceof WhisperSpeaking) == false) goto L93;
            if (Intrinsics.areEqual(r5, ObricContTalkStateMachine$TriggerEvent$QueryRejected.INSTANCE) == false) goto L93;
            return e.a(new AVKitCoreStates$Speaking(r5));
        L93:
            return null;
        L77:
            if ((r5 instanceof StateTriggerEvent.QueryEnd) == false) goto L81;
            if (((StateTriggerEvent.QueryEnd) r5).a == false) goto L81;
            return e.a(new AVKitCoreStates$DownWaiting(r5));
        L72:
            if (Intrinsics.areEqual(r5, StateTriggerEvent.Pause.a) == false) goto L74;
            return e.b(new AVKitCoreStates$Paused(r5, null), new m());
        L66:
            if ((r5 instanceof StateTriggerEvent.QueryEnd) == false) goto L70;
            if (((StateTriggerEvent.QueryEnd) r5).a == true) goto L70;
            return e.a(new AVKitCoreStates$Thinking(r5));
        L62:
            if (Intrinsics.areEqual(r5, StateTriggerEvent.Interrupt.a) == false) goto L64;
            return e.a(new AVKitCoreStates$DownWaiting(r5));
        L58:
            if (Intrinsics.areEqual(r5, StateTriggerEvent.PlayEnd.a) == false) goto L60;
            return e.a(new AVKitCoreStates$DownWaiting(r5));
        L53:
            if (Intrinsics.areEqual(r5, StateTriggerEvent.Interrupt.a) == false) goto L55;
            return e.a(new AVKitCoreStates$DownWaiting(r5));
        L49:
            if (Intrinsics.areEqual(r5, StateTriggerEvent.ReplyStart.a) == false) goto L51;
            return e.a(new AVKitCoreStates$Speaking(r5));
        L44:
            if (Intrinsics.areEqual(r5, StateTriggerEvent.ReplyStart.a) == false) goto L46;
            return e.a(new AVKitCoreStates$Speaking(r5));
        L40:
            if (Intrinsics.areEqual(r5, StateTriggerEvent.Pause.a) == false) goto L42;
            return e.b(new AVKitCoreStates$Paused(r5, null), new l());
        L28:
            if (Intrinsics.areEqual(r5, StateTriggerEvent.Connected.a) == false) goto L30;
            return e.a(new AVKitCoreStates$DownWaiting(r5));
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/call/mgr/ObricContTalkStateMachine$WhisperSpeaking;", "Lcom/larus/audio/call/mgr/AVKitCoreStates$Speaking;", "triggerBy", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "(Lcom/larus/audio/call/mgr/StateTriggerEvent;)V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class WhisperSpeaking extends AVKitCoreStates$Speaking {
        public WhisperSpeaking(StateTriggerEvent r1) {
            super(r1);
        }
    }

    static {
    }
}
