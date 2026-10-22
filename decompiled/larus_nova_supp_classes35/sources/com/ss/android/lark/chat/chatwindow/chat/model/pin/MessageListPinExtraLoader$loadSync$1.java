package com.ss.android.lark.chat.chatwindow.chat.model.pin;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.model.pin.MessageListPinExtraLoader", f = "MessageListPinExtraLoader.kt", i = {}, l = {BubbleStyle.ColorType.VIOLET_HEADER_WHITE_BORDER}, m = "loadSync", n = {}, s = {})
public final class MessageListPinExtraLoader$loadSync$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageListPinExtraLoader this$0;

    public MessageListPinExtraLoader$loadSync$1(MessageListPinExtraLoader r1, Continuation<? super MessageListPinExtraLoader$loadSync$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        MessageListPinExtraLoader r3 = this.this$0;
        int r0 = MessageListPinExtraLoader.j;
        return r3.f(this);
    }
}
