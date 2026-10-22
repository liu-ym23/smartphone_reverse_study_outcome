package com.larus.audio.call.util;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.audio.call.dora.CommandStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.util.FlowExtKt$withPrevious$1$1", f = "FlowExt.kt", i = {0}, l = {CommandStatus.DORA_VISION_INTENTION}, m = "emit", n = {"curr"}, s = {"L$0"})
public final class FlowExtKt$withPrevious$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowExtKt$withPrevious$1.AnonymousClass1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtKt$withPrevious$1$1$emit$1(FlowExtKt$withPrevious$1.AnonymousClass1<? super T> r1, Continuation<? super FlowExtKt$withPrevious$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return this.this$0.emit(null, (Continuation<? super Unit>) this);
    }
}
