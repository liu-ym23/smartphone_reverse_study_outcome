package com.bytedance.android.ec.core.hybrid.prefetch;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/ec/core/hybrid/prefetch/NativePrefetch$startPrefetchWithMultipleConfig$job$1$2$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch$startPrefetchWithMultipleConfig$job$1$2$1", f = "NativePrefetch.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NativePrefetch$startPrefetchWithMultipleConfig$job$1$invokeSuspend$$inlined$also$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $it;
    int label;
    final /* synthetic */ NativePrefetch$startPrefetchWithMultipleConfig$job$1 this$0;

    public NativePrefetch$startPrefetchWithMultipleConfig$job$1$invokeSuspend$$inlined$also$lambda$1(JSONObject r1, Continuation r10, NativePrefetch$startPrefetchWithMultipleConfig$job$1 r11) {
        this.$it = r1;
        this.this$0 = r11;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new NativePrefetch$startPrefetchWithMultipleConfig$job$1$invokeSuspend$$inlined$also$lambda$1(this.$it, r11, this.this$0);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        ConcurrentHashMap<String, NativePrefetch> r11 = NativePrefetchUtil.a;
        NativePrefetchUtil.k("NativePrefetch", "start request thread is " + ThreadMethodProxy.currentThread());
        NativePrefetch$startPrefetchWithMultipleConfig$job$1 r12 = this.this$0;
        NativePrefetch.e(r12.this$0, this.$it, r12.$uri, 1, r12.$requestId, r12.$requestConfig);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
