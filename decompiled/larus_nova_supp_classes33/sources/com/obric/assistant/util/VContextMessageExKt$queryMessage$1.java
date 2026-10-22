package com.obric.assistant.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.util.VContextMessageExKt", f = "VContextMessageEx.kt", i = {}, l = {25}, m = "queryMessage", n = {}, s = {})
public final class VContextMessageExKt$queryMessage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public VContextMessageExKt$queryMessage$1(Continuation<? super VContextMessageExKt$queryMessage$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return VContextMessageExKt.a(null, null, this);
    }
}
