package com.larus.audio.call.mgr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&¨\u0006\n"}, d2 = {"Lcom/larus/audio/call/mgr/DownStateReducer;", "Lcom/larus/audio/call/mgr/IStateReducer;", "reduceDown", "Lcom/larus/audio/call/mgr/Transition;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "state", "event", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "pending", "Lcom/larus/audio/call/mgr/PendingSlot;", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface DownStateReducer extends s68.h {
    h b(AVKitDuplexState.DownState r1, StateTriggerEvent r2, b.C0080b r3);
}
