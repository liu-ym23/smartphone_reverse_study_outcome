package com.larus.agents.impl.webfetch;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.webfetch.WebFetchCommandProcessor", f = "WebFetchCommandProcessor.kt", i = {}, l = {126}, m = "fetch", n = {}, s = {})
public final class WebFetchCommandProcessor$fetch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebFetchCommandProcessor this$0;

    public WebFetchCommandProcessor$fetch$1(WebFetchCommandProcessor r1, Continuation<? super WebFetchCommandProcessor$fetch$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        WebFetchCommandProcessor r3 = this.this$0;
        int r0 = WebFetchCommandProcessor.i;
        return r3.b(null, this);
    }
}
