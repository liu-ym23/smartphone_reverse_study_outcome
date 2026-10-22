package com.larus.audio.call.mgr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/audio/call/mgr/AVKitCoreStates$DownWaiting;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState$Active;", "triggerBy", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "(Lcom/larus/audio/call/mgr/StateTriggerEvent;)V", "getTriggerBy", "()Lcom/larus/audio/call/mgr/StateTriggerEvent;", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class AVKitCoreStates$DownWaiting implements AVKitDuplexState.DownState, AVKitDuplexState.DownState.Active {
    public final StateTriggerEvent a;

    @Override // com.larus.audio.call.mgr.AVKitDuplexState.DownState
    public final String toSimpleString() {
        return AVKitDuplexState.DownState.a.a(this);
    }

    @Override // com.larus.audio.call.mgr.AVKitDuplexState.DownState
    public final StateTriggerEvent getTriggerBy() {
        return this.a;
    }

    public AVKitCoreStates$DownWaiting(StateTriggerEvent r1) {
        this.a = r1;
    }
}
