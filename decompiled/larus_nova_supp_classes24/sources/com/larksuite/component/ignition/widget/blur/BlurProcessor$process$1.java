package com.larksuite.component.ignition.widget.blur;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.ignition.widget.blur.BlurProcessor", f = "BlurProcessor.kt", i = {0, 0}, l = {25}, m = "process", n = {"context", "color"}, s = {"L$0", "I$0"})
public final class BlurProcessor$process$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BlurProcessor this$0;

    public BlurProcessor$process$1(BlurProcessor r1, Continuation<? super BlurProcessor$process$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return this.this$0.b(null, null, 0, this);
    }
}
