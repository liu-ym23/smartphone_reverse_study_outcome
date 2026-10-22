package com.larus.agents.impl.webfetch;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.webfetch.WebPageFetcher", f = "WebPageFetcher.kt", i = {0, 0, 0, 0}, l = {45}, m = "fetchWebPageHtml", n = {"stage", "httpStatus", "logCommandId", "startedAtNanos"}, s = {"L$0", "L$1", "L$2", "J$0"})
public final class WebPageFetcher$fetchWebPageHtml$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebPageFetcher this$0;

    public WebPageFetcher$fetchWebPageHtml$1(WebPageFetcher r1, Continuation<? super WebPageFetcher$fetchWebPageHtml$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return this.this$0.b(null, null, false, 0, 0, this);
    }
}
