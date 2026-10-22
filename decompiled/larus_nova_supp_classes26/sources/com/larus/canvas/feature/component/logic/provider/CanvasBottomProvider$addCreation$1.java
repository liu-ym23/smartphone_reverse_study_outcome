package com.larus.canvas.feature.component.logic.provider;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.provider.CanvasBottomProvider", f = "CanvasBottomProvider.kt", i = {0}, l = {270, 273, 280}, m = "addCreation", n = {"privateStatus"}, s = {"I$0"})
final class CanvasBottomProvider$addCreation$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ i this$0;

    public CanvasBottomProvider$addCreation$1(i r1, Continuation<? super CanvasBottomProvider$addCreation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return i.y(this.this$0, this);
    }
}
