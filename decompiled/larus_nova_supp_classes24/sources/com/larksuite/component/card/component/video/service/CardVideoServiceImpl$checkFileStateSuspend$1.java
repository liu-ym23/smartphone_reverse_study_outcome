package com.larksuite.component.card.component.video.service;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.card.component.video.service.CardVideoServiceImpl", f = "CardVideoServiceImpl.kt", i = {0, 0}, l = {460}, m = "checkFileStateSuspend", n = {"sessionID", "url"}, s = {"L$0", "L$1"})
final class CardVideoServiceImpl$checkFileStateSuspend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CardVideoServiceImpl this$0;

    public CardVideoServiceImpl$checkFileStateSuspend$1(CardVideoServiceImpl r1, Continuation<? super CardVideoServiceImpl$checkFileStateSuspend$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return CardVideoServiceImpl.m(this.this$0, null, null, this);
    }
}
