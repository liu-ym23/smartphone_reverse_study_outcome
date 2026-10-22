package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chatwindow.launcher.transform.ChatLaunchService", f = "ChatLaunchService.kt", i = {0, 0}, l = {65}, m = "getOrCreateP2PChat-0E7RQCE", n = {"chatterId", "profileSource"}, s = {"L$0", "L$1"})
public final class ChatLaunchService$getOrCreateP2PChat$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatLaunchService this$0;

    public ChatLaunchService$getOrCreateP2PChat$1(ChatLaunchService r1, Continuation<? super ChatLaunchService$getOrCreateP2PChat$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        Object r3 = this.this$0.a(null, null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
