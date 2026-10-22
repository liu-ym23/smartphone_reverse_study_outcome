package com.ss.android.lark.chat.chatwindow.chat.model.data.decorator;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.feed.app.entity.RankConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.MessageUniversalPinExtraDecorator", f = "MessageUniversalPinExtraDecorator.kt", i = {0}, l = {RankConstants.PRIORITY_BANNER_ITEM}, m = "patchPinExtra", n = {"$this$patchPinExtra"}, s = {"L$0"})
final class MessageUniversalPinExtraDecorator$patchPinExtra$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ e this$0;

    public MessageUniversalPinExtraDecorator$patchPinExtra$1(e r1, Continuation<? super MessageUniversalPinExtraDecorator$patchPinExtra$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        return e.b(this.this$0, null, this);
    }
}
