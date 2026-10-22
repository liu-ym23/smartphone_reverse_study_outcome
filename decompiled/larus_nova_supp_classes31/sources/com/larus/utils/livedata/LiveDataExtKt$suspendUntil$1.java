package com.larus.utils.livedata;

import com.larus.platform.model.CollectionType;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.utils.livedata.LiveDataExtKt", f = "LiveDataExt.kt", i = {0, 0, 0}, l = {CollectionType.SINGLE_QISHUI_ALBUM, 106, 110}, m = "suspendUntil", n = {"deferred", "finished", "timeout"}, s = {"L$0", "L$1", "J$0"})
final class LiveDataExtKt$suspendUntil$1<T> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public LiveDataExtKt$suspendUntil$1(Continuation<? super LiveDataExtKt$suspendUntil$1> r1) {
        super(r1);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.utils.livedata.a] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.utils.livedata.LiveDataExtKt$suspendUntil$observer$1] */
    public final Object invokeSuspend(Object r13) {
        this.result = r13;
        int r14 = this.label | Integer.MIN_VALUE;
        this.label = r14;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r14 - Integer.MIN_VALUE;
        LiveDataExtKt$suspendUntil$1<T> r15 = this;
    L6:
        Object r0 = r15.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r15.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L14;
        if (r2 == 3) goto L14;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
    L31:
        return r0;
    L15:
        long r8 = r15.J$0;
        final Ref.BooleanRef r3 = (Ref.BooleanRef) r15.L$1;
        final CompletableDeferred r10 = (CompletableDeferred) r15.L$0;
        ResultKt.throwOnFailure(r0);
    L21:
        if (r8 > 0) goto L23;
    L27:
        r15.L$0 = null;
        r15.L$1 = null;
        r15.label = 3;
        r0 = r10.await(r15);
        if (r0 != r1) goto L31;
        return r1;
    L23:
        if (r3.element == true) goto L27;
        LiveDataExtKt$suspendUntil$result$1 r4 = new LiveDataExtKt$suspendUntil$result$1(r10, null);
        r15.L$0 = null;
        r15.L$1 = null;
        r15.label = 2;
        r0 = TimeoutKt.c(r8, r4, r15);
        if (r0 != r1) goto L31;
        return r1;
    L16:
        ResultKt.throwOnFailure(r0);
        r10 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r3 = new Ref.BooleanRef();
        final ?? r5 = new a(r3, r10);
        ?? r9 = new LiveDataExtKt$suspendUntil$observer$1(r5);
        MainCoroutineDispatcher r6 = Dispatchers.getMain();
        LiveDataExtKt$suspendUntil$2 r11 = new LiveDataExtKt$suspendUntil$2(null, null, r9, null);
        r15.L$0 = r10;
        r15.L$1 = r3;
        r15.J$0 = 0;
        r15.label = 1;
        if (BuildersKt.withContext(r6, r11, r15) == r1) goto L32;
        r8 = 0;
        goto L21
    L32:
        return r1;
    L5:
        r15 = new LiveDataExtKt$suspendUntil$1(this);
        goto L6
    }
}
