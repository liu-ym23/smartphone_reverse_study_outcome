package com.bytedance.ai.applet.db;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.db.WidgetContextHelper", f = "WidgetContextHelper.kt", i = {0}, l = {79}, m = "queryByCardId", n = {"cardId"}, s = {"L$0"})
public final class WidgetContextHelper$queryByCardId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WidgetContextHelper this$0;

    public WidgetContextHelper$queryByCardId$1(WidgetContextHelper r1, Continuation<? super WidgetContextHelper$queryByCardId$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        WidgetContextHelper r11 = this.this$0;
        WidgetContextHelper r0 = WidgetContextHelper.a;
        return r11.c(null, this);
    }
}
