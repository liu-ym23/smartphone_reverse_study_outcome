package com.obric.aiagent.messenger.stub;

import com.mammon.audiosdk.enums.SAMICoreSessionRequestType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.ObricForegroundWidgetSyncServiceImpl", f = "ObricForegroundWidgetSyncServiceImpl.kt", i = {0}, l = {SAMICoreSessionRequestType.SAMICore_Session_RequestType_FirstPlatformASR}, m = "awaitWidgetUpdatesBeforeConversationPull", n = {"conversationId"}, s = {"L$0"})
public final class ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricForegroundWidgetSyncServiceImpl this$0;

    public ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1(ObricForegroundWidgetSyncServiceImpl r1, Continuation<? super ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
