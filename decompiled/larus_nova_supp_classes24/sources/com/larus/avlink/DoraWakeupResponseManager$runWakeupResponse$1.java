package com.larus.avlink;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.DoraWakeupResponseManager", f = "DoraWakeupResponseManager.kt", i = {1, 1, 1, 2, 2, 2}, l = {96, 103, 123}, m = "runWakeupResponse", n = {"taskId", "startTimeMs", "resolveStartMs", "taskId", "mp3Path", "startTimeMs"}, s = {"L$0", "J$0", "J$1", "L$0", "L$1", "J$0"})
final class DoraWakeupResponseManager$runWakeupResponse$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraWakeupResponseManager this$0;

    public DoraWakeupResponseManager$runWakeupResponse$1(DoraWakeupResponseManager r1, Continuation<? super DoraWakeupResponseManager$runWakeupResponse$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return DoraWakeupResponseManager.b(this.this$0, this);
    }
}
