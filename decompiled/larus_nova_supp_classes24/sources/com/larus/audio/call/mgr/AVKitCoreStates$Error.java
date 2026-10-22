package com.larus.audio.call.mgr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0016\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/larus/audio/call/mgr/AVKitCoreStates$Error;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "errorCode", "", "errorMsg", "", "errorExtra", "", "", "triggerBy", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "(ILjava/lang/String;Ljava/util/Map;Lcom/larus/audio/call/mgr/StateTriggerEvent;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "getErrorExtra", "()Ljava/util/Map;", "getTriggerBy", "()Lcom/larus/audio/call/mgr/StateTriggerEvent;", "toSimpleString", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class AVKitCoreStates$Error implements AVKitDuplexState.UpState, AVKitDuplexState.DownState {
    public final int a;
    public final String b;
    public final Map<String, Object> c;
    public final StateTriggerEvent d;

    @Override // com.larus.audio.call.mgr.AVKitDuplexState.UpState, com.larus.audio.call.mgr.AVKitDuplexState.DownState
    public final String toSimpleString() {
        return "Error[code=" + this.a + ",msg=" + this.b + ",extra=" + this.c + ']';
    }

    @Override // com.larus.audio.call.mgr.AVKitDuplexState.UpState, com.larus.audio.call.mgr.AVKitDuplexState.DownState
    public final StateTriggerEvent getTriggerBy() {
        return this.d;
    }

    public AVKitCoreStates$Error(int r2, String r3, Map<String, ? extends Object> r4, StateTriggerEvent r5) {
        Intrinsics.checkNotNullParameter(r3, "errorMsg");
        Intrinsics.checkNotNullParameter(r4, "errorExtra");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
