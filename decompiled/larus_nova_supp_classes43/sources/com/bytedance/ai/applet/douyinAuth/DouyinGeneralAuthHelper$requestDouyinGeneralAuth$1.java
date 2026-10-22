package com.bytedance.ai.applet.douyinAuth;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper", f = "DouyinGeneralAuthHelper.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {275, 284, 286, 298}, m = "requestDouyinGeneralAuth", n = {"app", "scope", "authSource", "containerType", "authTaskSession", "app", "scope", "authSource", "containerType", "authTaskSession", BdpAwemeConstant.KEY_APP_NAME, "trackInfo", "scope", "authSource", "containerType", "authTaskSession", BdpAwemeConstant.KEY_APP_NAME, "trackInfo"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class DouyinGeneralAuthHelper$requestDouyinGeneralAuth$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DouyinGeneralAuthHelper this$0;

    public DouyinGeneralAuthHelper$requestDouyinGeneralAuth$1(DouyinGeneralAuthHelper r1, Continuation<? super DouyinGeneralAuthHelper$requestDouyinGeneralAuth$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, null, null, null, this);
    }
}
