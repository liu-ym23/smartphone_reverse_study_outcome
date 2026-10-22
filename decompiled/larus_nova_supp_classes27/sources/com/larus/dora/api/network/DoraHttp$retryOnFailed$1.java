package com.larus.dora.api.network;

import com.larus.network.http.a;
import com.larus.network.http.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.api.network.DoraHttp", f = "DoraHttp.kt", i = {0, 0, 0, 0}, l = {168}, m = "retryOnFailed", n = {"$this$retryOnFailed", "times", "interval", "currentRetry"}, s = {"L$0", "I$0", "J$0", "I$1"})
final class DoraHttp$retryOnFailed$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public DoraHttp$retryOnFailed$1(a r1, Continuation<? super DoraHttp$retryOnFailed$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        a r11 = this.this$0;
        r11.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        DoraHttp$retryOnFailed$1<T> r0 = this;
    L6:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L12;
        if (r3 != 1) goto L11;
        int r4 = r0.I$1;
        long r5 = r0.J$0;
        int r7 = r0.I$0;
        a r8 = (a) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L13:
        if (r4 >= r7) goto L24;
        if ((r8 instanceof y) == true) goto L31;
        r4 = r4 + 1;
        if (r4 >= r7) goto L24;
        r0.L$0 = r8;
        r0.I$0 = r7;
        r0.J$0 = r5;
        r0.I$1 = r4;
        r0.label = 1;
        if (DelayKt.delay(r5, r0) != r2) goto L13;
        return r2;
    L31:
        return ((a) ((y) r8)).b;
    L24:
        return null;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r12);
        r4 = 0;
        r5 = 0;
        r8 = null;
        r7 = 0;
        goto L13
    L5:
        r0 = new DoraHttp$retryOnFailed$1(r11, this);
        goto L6
    }
}
