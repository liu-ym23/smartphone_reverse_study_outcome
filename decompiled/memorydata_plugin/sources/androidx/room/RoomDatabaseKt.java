package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.cv;
import kotlinx.coroutines.cw;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001aL\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a9\u0010\u000f\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\u00020\u00022\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"createTransactionContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/room/RoomDatabase;", "dispatcher", "Lkotlin/coroutines/ContinuationInterceptor;", "startTransactionCoroutine", "R", "context", "transactionBlock", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "block", "Lkotlin/Function1;", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RoomDatabaseKt {
    public static final /* synthetic */ CoroutineContext access$createTransactionContext(RoomDatabase r2, ContinuationInterceptor r3) {
        return createTransactionContext(r2, (ContinuationInterceptor) ZeusTransformUtils.wrapperContextForParams(r3, ContinuationInterceptor.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$startTransactionCoroutine(RoomDatabase r2, CoroutineContext r3, Function2 r4, Continuation r5) {
        return startTransactionCoroutine(r2, (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private static final CoroutineContext createTransactionContext(RoomDatabase r3, ContinuationInterceptor r4) {
        ContinuationInterceptor r5 = (ContinuationInterceptor) ZeusTransformUtils.wrapperContextForParams(r4, ContinuationInterceptor.class, "com.obric.memorydata.plugin");
        TransactionElement r0 = new TransactionElement(r5);
        cv r6 = cw.a(r3.getSuspendingTransactionId(), Integer.valueOf(System.identityHashCode(r0)));
        return r5.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(r0, CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(r6, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    private static final <R> Object startTransactionCoroutine(final RoomDatabase r5, CoroutineContext r6, Function2<? super al, ? super Continuation<? super R>, ? extends Object> r7, Continuation<? super R> r8) {
        final CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r6, CoroutineContext.class, "com.obric.memorydata.plugin");
        final Function2 r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r7, Function2.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        o r0 = new o(IntrinsicsKt.intercepted(r11), 1);
        r0.e();
        final n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
        r5.getTransactionExecutor().execute((Runnable) ZeusTransformUtils.preCheckCast(new RoomDatabaseKt$startTransactionCoroutine$2$1(r9, r2, r5, r10), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: RejectedExecutionException -> L5
    L7:
        Object r12 = r0.h();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L10:
        return r12;
    L5:
        e = move-exception;
        r2.b((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
        goto L7
    }

    public static final <R> Object withTransaction(RoomDatabase r5, Function1<? super Continuation<? super R>, ? extends Object> r6, Continuation<? super R> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        ContinuationInterceptor r2 = null;
        Function2 r10 = (Function2) ZeusTransformUtils.preCheckCast(new RoomDatabaseKt$withTransaction$transactionBlock$1(r5, r8, null), Function2.class, "com.obric.memorydata.plugin");
        TransactionElement r0 = (TransactionElement) ZeusTransformUtils.preCheckCast(r9.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(TransactionElement.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), TransactionElement.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r2 = r0.getTransactionDispatcher$room_ktx_release();
    L5:
        if (r2 == null) goto L9;
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(r2, CoroutineContext.class, "com.obric.memorydata.plugin"), r10, r9);
    L9:
        return startTransactionCoroutine(r5, r9.getContext(), r10, r9);
    }
}
