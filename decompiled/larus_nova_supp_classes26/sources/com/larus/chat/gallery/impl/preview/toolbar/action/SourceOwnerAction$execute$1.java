package com.larus.chat.gallery.impl.preview.toolbar.action;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.SourceOwnerAction", f = "SourceOwnerAction.kt", i = {}, l = {20}, m = "execute", n = {}, s = {})
public final class SourceOwnerAction$execute$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SourceOwnerAction this$0;

    public SourceOwnerAction$execute$1(SourceOwnerAction r1, Continuation<? super SourceOwnerAction$execute$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
