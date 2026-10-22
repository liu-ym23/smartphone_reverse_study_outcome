package com.larksuite.component.card.resources;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.audio.call.dora.CommandStatus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.card.resources.CardResourceServiceImpl", f = "CardResourceServiceImpl.kt", i = {0}, l = {CommandStatus.DORA_NO_SPEECH_BEFORE_END}, m = "forceLoadResource", n = {"params"}, s = {"L$0"})
public final class CardResourceServiceImpl$forceLoadResource$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CardResourceServiceImpl this$0;

    public CardResourceServiceImpl$forceLoadResource$1(CardResourceServiceImpl r1, Continuation<? super CardResourceServiceImpl$forceLoadResource$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return this.this$0.b(null, this);
    }
}
