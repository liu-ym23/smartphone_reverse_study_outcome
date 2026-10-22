package com.larus.account.saas.mfa.assist;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.account.saas.mfa.assist.MfaAssistManager", f = "MfaAssistManager.kt", i = {0, 0, 0}, l = {246}, m = "requestPushCode", n = {"uiState", "retryTimes", "retryCount"}, s = {"L$0", "I$0", "I$1"})
public final class MfaAssistManager$requestPushCode$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MfaAssistManager this$0;

    public MfaAssistManager$requestPushCode$1(MfaAssistManager r1, Continuation<? super MfaAssistManager$requestPushCode$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        MfaAssistManager r3 = this.this$0;
        MfaAssistManager r0 = MfaAssistManager.a;
        return r3.c(null, this);
    }
}
