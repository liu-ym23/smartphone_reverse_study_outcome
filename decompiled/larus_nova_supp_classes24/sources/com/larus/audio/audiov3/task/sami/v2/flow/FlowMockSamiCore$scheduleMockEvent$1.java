package com.larus.audio.audiov3.task.sami.v2.flow;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.audiov3.task.sami.v2.flow.FlowMockSamiCore", f = "FlowMockSamiCore.kt", i = {}, l = {188}, m = "scheduleMockEvent", n = {}, s = {})
final class FlowMockSamiCore$scheduleMockEvent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMockSamiCore this$0;

    public FlowMockSamiCore$scheduleMockEvent$1(FlowMockSamiCore r1, Continuation<? super FlowMockSamiCore$scheduleMockEvent$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return FlowMockSamiCore.j(this.this$0, this);
    }
}
