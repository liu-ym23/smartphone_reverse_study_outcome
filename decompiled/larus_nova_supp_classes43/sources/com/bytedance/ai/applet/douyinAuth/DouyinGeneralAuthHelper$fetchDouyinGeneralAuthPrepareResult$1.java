package com.bytedance.ai.applet.douyinAuth;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper", f = "DouyinGeneralAuthHelper.kt", i = {0, 0}, l = {339}, m = "fetchDouyinGeneralAuthPrepareResult", n = {BdpAwemeConstant.KEY_APP_ID, "timeoutFailure"}, s = {"L$0", "I$0"})
public final class DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DouyinGeneralAuthHelper this$0;

    public DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1(DouyinGeneralAuthHelper r1, Continuation<? super DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        DouyinGeneralAuthHelper r11 = this.this$0;
        DouyinGeneralAuthHelper r0 = DouyinGeneralAuthHelper.a;
        return r11.b(null, this);
    }
}
