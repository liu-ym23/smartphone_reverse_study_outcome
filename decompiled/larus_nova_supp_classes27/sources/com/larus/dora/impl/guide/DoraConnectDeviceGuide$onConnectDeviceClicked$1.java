package com.larus.dora.impl.guide;

import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraConnectDeviceGuide", f = "DoraConnectDeviceGuide.kt", i = {0, 1}, l = {193, BaiduNaviStatus.WRONG_AK_PARAM}, m = "onConnectDeviceClicked", n = {"fragment", "fragment"}, s = {"L$0", "L$0"})
final class DoraConnectDeviceGuide$onConnectDeviceClicked$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraConnectDeviceGuide this$0;

    public DoraConnectDeviceGuide$onConnectDeviceClicked$1(DoraConnectDeviceGuide r1, Continuation<? super DoraConnectDeviceGuide$onConnectDeviceClicked$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraConnectDeviceGuide.B(this.this$0, null, this);
    }
}
