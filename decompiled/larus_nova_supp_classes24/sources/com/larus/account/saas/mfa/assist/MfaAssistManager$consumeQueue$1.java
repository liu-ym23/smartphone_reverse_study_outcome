package com.larus.account.saas.mfa.assist;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.account.saas.mfa.assist.MfaAssistManager", f = "MfaAssistManager.kt", i = {0, 0}, l = {146}, m = "consumeQueue", n = {"this", "reducedUiState"}, s = {"L$0", "L$1"})
final class MfaAssistManager$consumeQueue$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MfaAssistManager this$0;

    public MfaAssistManager$consumeQueue$1(MfaAssistManager r1, Continuation<? super MfaAssistManager$consumeQueue$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return MfaAssistManager.a(this.this$0, this);
    }
}
