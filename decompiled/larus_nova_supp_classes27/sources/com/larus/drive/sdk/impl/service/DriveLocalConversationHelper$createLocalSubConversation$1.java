package com.larus.drive.sdk.impl.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.service.DriveLocalConversationHelper", f = "DriveLocalConversationHelper.kt", i = {1, 1, 1, 2, 2, 2, 3}, l = {31, 37, 42, 43}, m = "createLocalSubConversation", n = {"context", "inputLeftActionStyle", "customSuffix", "context", "inputLeftActionStyle", "customSuffix", "botModel"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0"})
public final class DriveLocalConversationHelper$createLocalSubConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveLocalConversationHelper this$0;

    public DriveLocalConversationHelper$createLocalSubConversation$1(DriveLocalConversationHelper r1, Continuation<? super DriveLocalConversationHelper$createLocalSubConversation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, this);
    }
}
