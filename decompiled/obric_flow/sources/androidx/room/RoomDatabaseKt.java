package androidx.room;

import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001aL\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a9\u0010\u000f\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\u00020\u00022\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"createTransactionContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/room/RoomDatabase;", "dispatcher", "Lkotlin/coroutines/ContinuationInterceptor;", "startTransactionCoroutine", "R", "context", "transactionBlock", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "block", "Lkotlin/Function1;", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "RoomDatabaseKt")
public final class RoomDatabaseKt {
    public static final /* synthetic */ CoroutineContext access$createTransactionContext(RoomDatabase r5, ContinuationInterceptor r10) {
        return createTransactionContext(r5, r10);
    }

    public static final /* synthetic */ Object access$startTransactionCoroutine(RoomDatabase r5, CoroutineContext r10, Function2 r11, Continuation r12) {
        return startTransactionCoroutine(r5, r10, r11, r12);
    }

    private static final CoroutineContext createTransactionContext(RoomDatabase r5, ContinuationInterceptor r10) {
        TransactionElement r11 = new TransactionElement(r10);
        ThreadLocal<Integer> r12 = r5.getSuspendingTransactionId();
        w r13 = new w(Integer.valueOf(System.identityHashCode(r11)), r12);
        return r10.plus(r11).plus(r13);
    }

    private static final <R> Object startTransactionCoroutine(final RoomDatabase r5, final CoroutineContext r10, final Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> r11, Continuation<? super R> r12) {
        final l r13 = new l(1, IntrinsicsKt.intercepted(r12));
        r13.w();
        r5.getTransactionExecutor().execute(new RoomDatabaseKt$startTransactionCoroutine$2$1(r10, r13, r5, r11));     // Catch: RejectedExecutionException -> L5
    L7:
        Object r14 = r13.v();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L10:
        return r14;
    L5:
        e = move-exception;
        r13.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        goto L7
    }

    public static final <R> Object withTransaction(RoomDatabase r5, Function1<? super Continuation<? super R>, ? extends Object> r10, Continuation<? super R> r11) {
        ContinuationInterceptor r12 = null;
        RoomDatabaseKt$withTransaction$transactionBlock$1 r13 = new RoomDatabaseKt$withTransaction$transactionBlock$1(r5, r10, null);
        TransactionElement r14 = (TransactionElement) r11.getContext().get(TransactionElement.Key);
        if (r14 == null) goto L5;
        r12 = r14.getTransactionDispatcher$room_ktx_release();
    L5:
        if (r12 == null) goto L9;
        return BuildersKt.withContext(r12, r13, r11);
    L9:
        return startTransactionCoroutine(r5, r11.getContext(), r13, r11);
    }
}
