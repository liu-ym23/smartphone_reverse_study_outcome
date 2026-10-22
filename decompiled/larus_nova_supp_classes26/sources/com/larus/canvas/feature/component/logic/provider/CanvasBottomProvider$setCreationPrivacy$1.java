package com.larus.canvas.feature.component.logic.provider;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.provider.CanvasBottomProvider", f = "CanvasBottomProvider.kt", i = {0, 0, 0, 1, 1, 1}, l = {375, 394, 398}, m = "setCreationPrivacy", n = {"private", "previousStatus", "privateStatus", "creationId", "previousStatus", "privateStatus"}, s = {"Z$0", "I$0", "I$1", "L$0", "I$0", "I$1"})
final class CanvasBottomProvider$setCreationPrivacy$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ i this$0;

    public CanvasBottomProvider$setCreationPrivacy$1(i r1, Continuation<? super CanvasBottomProvider$setCreationPrivacy$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return i.z(this.this$0, false, this);
    }
}
