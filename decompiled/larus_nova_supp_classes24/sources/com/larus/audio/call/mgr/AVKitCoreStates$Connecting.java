package com.larus.audio.call.mgr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/larus/audio/call/mgr/AVKitCoreStates$Connecting;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState$Active;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState$Active;", "triggerBy", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "(Lcom/larus/audio/call/mgr/StateTriggerEvent;)V", "getTriggerBy", "()Lcom/larus/audio/call/mgr/StateTriggerEvent;", "toSimpleString", "", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class AVKitCoreStates$Connecting implements AVKitDuplexState.UpState, AVKitDuplexState.DownState, AVKitDuplexState.UpState.Active, AVKitDuplexState.DownState.Active {
    public final StateTriggerEvent a;

    @Override // com.larus.audio.call.mgr.AVKitDuplexState.UpState, com.larus.audio.call.mgr.AVKitDuplexState.DownState
    public final String toSimpleString() {
        return "Connecting";
    }

    @Override // com.larus.audio.call.mgr.AVKitDuplexState.UpState, com.larus.audio.call.mgr.AVKitDuplexState.DownState
    public final StateTriggerEvent getTriggerBy() {
        return this.a;
    }

    public AVKitCoreStates$Connecting(StateTriggerEvent r1) {
        this.a = r1;
    }
}
