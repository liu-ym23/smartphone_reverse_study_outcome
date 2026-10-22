package com.larus.utils.livedata;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.utils.livedata.LiveDataExtKt$suspendUntil$2", f = "LiveDataExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LiveDataExtKt$suspendUntil$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LiveDataExtKt$suspendUntil$observer$1 $observer;
    final /* synthetic */ LifecycleOwner $owner;
    final /* synthetic */ LiveData<Object> $this_suspendUntil;
    int label;

    public LiveDataExtKt$suspendUntil$2(LiveData<Object> r1, LifecycleOwner r2, LiveDataExtKt$suspendUntil$observer$1 r3, Continuation<? super LiveDataExtKt$suspendUntil$2> r4) {
        this.$this_suspendUntil = r1;
        this.$owner = r2;
        this.$observer = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new LiveDataExtKt$suspendUntil$2(this.$this_suspendUntil, this.$owner, this.$observer, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        this.$this_suspendUntil.observe(this.$owner, this.$observer);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
