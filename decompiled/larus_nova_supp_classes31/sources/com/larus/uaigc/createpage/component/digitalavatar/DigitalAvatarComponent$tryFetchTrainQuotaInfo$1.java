package com.larus.uaigc.createpage.component.digitalavatar;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent", f = "DigitalAvatarComponent.kt", i = {}, l = {450}, m = "tryFetchTrainQuotaInfo", n = {}, s = {})
final class DigitalAvatarComponent$tryFetchTrainQuotaInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DigitalAvatarComponent this$0;

    public DigitalAvatarComponent$tryFetchTrainQuotaInfo$1(DigitalAvatarComponent r1, Continuation<? super DigitalAvatarComponent$tryFetchTrainQuotaInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DigitalAvatarComponent.p3(this.this$0, this);
    }
}
