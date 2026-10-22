package com.larus.voicecall.impl.plugins;

import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.DownStateReducer;
import com.larus.audio.call.mgr.StateTriggerEvent;
import com.larus.audio.call.mgr.UpStateReducer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J.\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/voicecall/impl/plugins/SceneDownReducer;", "Lcom/larus/audio/call/mgr/DuplexReducer;", "<init>", "()V", "reduceUp", "Lcom/larus/audio/call/mgr/Transition;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;", "state", "event", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "pending", "Lcom/larus/audio/call/mgr/PendingSlot;", "reduceDown", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SceneDownReducer implements UpStateReducer, DownStateReducer {
    public SceneDownReducer() {
    }

    public final com.larus.audio.call.mgr.h a(AVKitDuplexState.UpState r2, StateTriggerEvent r3, com.larus.audio.call.mgr.b.b r4) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "pending");
        if ((r2 instanceof AVKitCoreStates.Recognizing) == true) goto L5;
    L7:
        return null;
    L5:
        if (Intrinsics.areEqual(r3, StateTriggerEvent.SceneSwitched.a) == false) goto L7;
        return com.larus.audio.call.mgr.i.a(new AVKitCoreStates.Listening(r3));
    }

    public final com.larus.audio.call.mgr.h b(AVKitDuplexState.DownState r2, StateTriggerEvent r3, com.larus.audio.call.mgr.b.b r4) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "pending");
        if ((r2 instanceof AVKitDuplexState.DownState.Active) == false) goto L12;
        if ((r2 instanceof AVKitCoreStates.Connecting) == true) goto L12;
        if ((r2 instanceof AVKitCoreStates.Paused) == true) goto L12;
        if (Intrinsics.areEqual(r3, StateTriggerEvent.SceneSwitched.a) == false) goto L12;
        return com.larus.audio.call.mgr.e.a(new AVKitCoreStates.Connecting(r3));
    L12:
        if (Intrinsics.areEqual(r3, TriggerSceneHello.a) == true) goto L14;
    L24:
        return null;
    L14:
        if ((r2 instanceof AVKitCoreStates.DownWaiting) == true) goto L27;
        if ((r2 instanceof AVKitCoreStates.Thinking) == true) goto L27;
        if ((r2 instanceof AVKitCoreStates.Speaking) == true) goto L27;
        if ((r2 instanceof AVKitCoreStates.Connecting) == false) goto L24;
        if (Intrinsics.areEqual(((AVKitCoreStates.Connecting) r2).getTriggerBy(), StateTriggerEvent.SceneSwitched.a) == false) goto L24;
    L27:
        return com.larus.audio.call.mgr.e.a(new WaitingSceneHello(r3));
    }
}
