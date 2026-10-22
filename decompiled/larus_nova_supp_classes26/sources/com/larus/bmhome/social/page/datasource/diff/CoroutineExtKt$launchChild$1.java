package com.larus.bmhome.social.page.datasource.diff;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.diff.CoroutineExtKt", f = "CoroutineExt.kt", i = {0}, l = {23}, m = "launchChild", n = {"launchJob"}, s = {"L$0"})
public final class CoroutineExtKt$launchChild$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public CoroutineExtKt$launchChild$1(Continuation<? super CoroutineExtKt$launchChild$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CoroutineExtKt.a(null, null, this);
    }
}
