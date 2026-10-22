package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$create$1$1", f = "ChatP2PReadableViewModel.kt", i = {0}, l = {104}, m = "emit", n = {"banner"}, s = {"L$0"})
public final class ChatP2PReadableViewModel$create$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatP2PReadableViewModel.AnonymousClass1.C00781<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatP2PReadableViewModel$create$1$1$emit$1(ChatP2PReadableViewModel.AnonymousClass1.C00781<? super T> r1, Continuation<? super ChatP2PReadableViewModel$create$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        return this.this$0.a(null, (Continuation<? super Unit>) this);
    }
}
