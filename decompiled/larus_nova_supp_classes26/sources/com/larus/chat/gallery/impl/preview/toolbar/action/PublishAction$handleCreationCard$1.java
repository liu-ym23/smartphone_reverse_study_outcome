package com.larus.chat.gallery.impl.preview.toolbar.action;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.PublishAction", f = "PublishAction.kt", i = {1}, l = {107, 110, 114, 118}, m = "handleCreationCard", n = {"context"}, s = {"L$0"})
public final class PublishAction$handleCreationCard$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PublishAction this$0;

    public PublishAction$handleCreationCard$1(PublishAction r1, Continuation<? super PublishAction$handleCreationCard$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        PublishAction r3 = this.this$0;
        int r0 = PublishAction.a;
        return r3.e(null, this);
    }
}
