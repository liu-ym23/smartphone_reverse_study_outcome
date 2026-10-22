package com.ss.android.lark.chatwindow.launcher;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chatwindow.launcher.ChatLauncherV2", f = "ChatLauncherV2.kt", i = {0, 0, 1, 1}, l = {223, 186}, m = "openChat", n = {"context", "launchContext", "transformResult", "chatBundle"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class ChatLauncherV2$openChat$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatLauncherV2 this$0;

    public ChatLauncherV2$openChat$2(ChatLauncherV2 r1, Continuation<? super ChatLauncherV2$openChat$2> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        return this.this$0.a(null, null, null, this);
    }
}
