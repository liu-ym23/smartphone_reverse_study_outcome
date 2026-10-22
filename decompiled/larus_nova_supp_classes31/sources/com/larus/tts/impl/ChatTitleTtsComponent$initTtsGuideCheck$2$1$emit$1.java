package com.larus.tts.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$initTtsGuideCheck$2$1", f = "ChatTitleTtsComponent.kt", i = {0}, l = {688}, m = "emit", n = {"newIsTtsCheck"}, s = {"I$0"})
public final class ChatTitleTtsComponent$initTtsGuideCheck$2$1$emit$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatTitleTtsComponent$initTtsGuideCheck$2.AnonymousClass1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatTitleTtsComponent$initTtsGuideCheck$2$1$emit$1(ChatTitleTtsComponent$initTtsGuideCheck$2.AnonymousClass1<? super T> r1, Continuation<? super ChatTitleTtsComponent$initTtsGuideCheck$2$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, (Continuation<? super Unit>) this);
    }
}
