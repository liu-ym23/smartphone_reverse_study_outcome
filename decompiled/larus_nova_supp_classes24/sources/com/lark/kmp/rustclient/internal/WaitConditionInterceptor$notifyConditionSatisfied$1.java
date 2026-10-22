package com.lark.kmp.rustclient.internal;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.WaitConditionInterceptor", f = "WaitConditionInterceptor.kt", i = {0, 0}, l = {114, 99}, m = "notifyConditionSatisfied", n = {"cacheCopy", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
public final class WaitConditionInterceptor$notifyConditionSatisfied$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WaitConditionInterceptor this$0;

    public WaitConditionInterceptor$notifyConditionSatisfied$1(WaitConditionInterceptor r1, Continuation<? super WaitConditionInterceptor$notifyConditionSatisfied$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return this.this$0.e(this);
    }
}
