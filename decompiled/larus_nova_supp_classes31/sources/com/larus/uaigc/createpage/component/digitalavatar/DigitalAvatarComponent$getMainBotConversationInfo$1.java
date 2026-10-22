package com.larus.uaigc.createpage.component.digitalavatar;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent", f = "DigitalAvatarComponent.kt", i = {0}, l = {275, 278}, m = "getMainBotConversationInfo", n = {"callback"}, s = {"L$0"})
final class DigitalAvatarComponent$getMainBotConversationInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DigitalAvatarComponent this$0;

    public DigitalAvatarComponent$getMainBotConversationInfo$1(DigitalAvatarComponent r1, Continuation<? super DigitalAvatarComponent$getMainBotConversationInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DigitalAvatarComponent.h3(this.this$0, null, this);
    }
}
