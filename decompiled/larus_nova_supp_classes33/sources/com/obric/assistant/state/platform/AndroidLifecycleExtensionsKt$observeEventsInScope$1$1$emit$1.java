package com.obric.assistant.state.platform;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
public final class AndroidLifecycleExtensionsKt$observeEventsInScope$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidLifecycleExtensionsKt$observeEventsInScope$1.a<Object> this$0;

    public AndroidLifecycleExtensionsKt$observeEventsInScope$1$1$emit$1(AndroidLifecycleExtensionsKt$observeEventsInScope$1.a<Object> r1, Continuation<? super AndroidLifecycleExtensionsKt$observeEventsInScope$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        this.this$0.getClass();
        throw null;
    }
}
