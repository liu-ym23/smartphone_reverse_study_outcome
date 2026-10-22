package com.larus.audio;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.RtcEngineInitManager", f = "RtcEngineInitManager.kt", i = {0}, l = {444, 452, 461}, m = "ensureInitialized", n = {"caller"}, s = {"L$0"})
public final class RtcEngineInitManager$ensureInitialized$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RtcEngineInitManager this$0;

    public RtcEngineInitManager$ensureInitialized$1(RtcEngineInitManager r1, Continuation<? super RtcEngineInitManager$ensureInitialized$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return this.this$0.d(null, this);
    }
}
