package com.larus.audio.ttsV2;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.ttsV2.TtsClientManager", f = "TtsClientManager.kt", i = {0}, l = {1188}, m = "appendQueryBotId", n = {"result"}, s = {"L$0"})
public final class TtsClientManager$appendQueryBotId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TtsClientManager this$0;

    public TtsClientManager$appendQueryBotId$1(TtsClientManager r1, Continuation<? super TtsClientManager$appendQueryBotId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        TtsClientManager r3 = this.this$0;
        TtsClientManager r0 = TtsClientManager.a;
        return r3.q(null, null, this);
    }
}
