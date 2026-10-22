package com.obric.assistant.remote_card_container.manager;

import com.obric.capabilitykit.common.ErrorCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.manager.RemoteCardManager", f = "RemoteCardManager.kt", i = {}, l = {ErrorCode.APP_VERSION_TOO_LOW}, m = "getCard", n = {}, s = {})
public final class RemoteCardManager$getCard$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteCardManager this$0;

    public RemoteCardManager$getCard$1(RemoteCardManager r1, Continuation<? super RemoteCardManager$getCard$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, false, this);
    }
}
