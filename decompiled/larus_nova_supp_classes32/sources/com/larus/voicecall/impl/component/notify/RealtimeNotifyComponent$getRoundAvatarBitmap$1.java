package com.larus.voicecall.impl.component.notify;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.notify.RealtimeNotifyComponent", f = "RealtimeNotifyComponent.kt", i = {}, l = {221}, m = "getRoundAvatarBitmap", n = {}, s = {})
final class RealtimeNotifyComponent$getRoundAvatarBitmap$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealtimeNotifyComponent this$0;

    public RealtimeNotifyComponent$getRoundAvatarBitmap$1(RealtimeNotifyComponent r1, Continuation<? super RealtimeNotifyComponent$getRoundAvatarBitmap$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return RealtimeNotifyComponent.h3(this.this$0, this);
    }
}
