package com.bytedance.ai.applet.db;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.db.WidgetContextHelper", f = "WidgetContextHelper.kt", i = {0}, l = {49}, m = "queryConversationIdByCardId", n = {"cardId"}, s = {"L$0"})
public final class WidgetContextHelper$queryConversationIdByCardId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WidgetContextHelper this$0;

    public WidgetContextHelper$queryConversationIdByCardId$1(WidgetContextHelper r1, Continuation<? super WidgetContextHelper$queryConversationIdByCardId$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
