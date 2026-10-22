package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.menu.handler.CopyMessageLinkHandler$Companion", f = "CopyMessageLinkHandler.kt", i = {0, 0, 0, 0, 0}, l = {BubbleStyle.ColorType.PURPLE_HEADER_WHITE_BORDER}, m = "getMessageLink-BWLJW6A", n = {"from", "copiedIdList", "$this$getMessageLink_BWLJW6A_u24lambda_u241", "$completion$iv", "fromId"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
final class CopyMessageLinkHandler$Companion$getMessageLink$2 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public CopyMessageLinkHandler$Companion$getMessageLink$2(c r1, Continuation<? super CopyMessageLinkHandler$Companion$getMessageLink$2> r2) {
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        throw null;
    }
}
