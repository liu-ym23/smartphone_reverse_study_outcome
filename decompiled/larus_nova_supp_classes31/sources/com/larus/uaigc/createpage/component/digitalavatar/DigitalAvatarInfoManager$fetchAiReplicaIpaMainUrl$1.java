package com.larus.uaigc.createpage.component.digitalavatar;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager", f = "DigitalAvatarInfoManager.kt", i = {}, l = {116}, m = "fetchAiReplicaIpaMainUrl", n = {}, s = {})
public final class DigitalAvatarInfoManager$fetchAiReplicaIpaMainUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DigitalAvatarInfoManager this$0;

    public DigitalAvatarInfoManager$fetchAiReplicaIpaMainUrl$1(DigitalAvatarInfoManager r1, Continuation<? super DigitalAvatarInfoManager$fetchAiReplicaIpaMainUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
