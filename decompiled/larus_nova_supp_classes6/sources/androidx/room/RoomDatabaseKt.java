package androidx.room;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.e0;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\u00020\b\u001a9\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\u00020\b2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"acquireTransactionThread", "Lkotlin/coroutines/ContinuationInterceptor;", "Ljava/util/concurrent/Executor;", "controlJob", "Lkotlinx/coroutines/Job;", "(Ljava/util/concurrent/Executor;Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTransactionContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reflectGetSuspendingTransactionId", "Ljava/lang/ThreadLocal;", "", "withTransaction", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class RoomDatabaseKt {
    public static final ThreadLocal<Integer> reflectGetSuspendingTransactionId(RoomDatabase r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Method r0 = RoomDatabase.class.getDeclaredMethod("getSuspendingTransactionId", new Class[0]);
        r0.setAccessible(true);
        Object r5 = r0.invoke(r4, new Object[0]);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.ThreadLocal<kotlin.Int>");
        return (ThreadLocal) r5;
    }

    public static final /* synthetic */ Object access$createTransactionContext(RoomDatabase r0, Continuation r1) {
        return createTransactionContext(r0, r1);
    }

    private static final Object createTransactionContext(RoomDatabase r6, Continuation<? super CoroutineContext> r7) {
        if ((r7 instanceof createTransactionContext.1) == false) goto L7;
        createTransactionContext.1 r0 = (createTransactionContext.1) r7;
        int r1 = r0.label;
        if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
        r0.label = r1 - IWakeupSessionConstant.RC_ERROR;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        CompletableJob r9 = (CompletableJob) r0.L$1;
        RoomDatabase r4 = (RoomDatabase) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L21:
        ContinuationInterceptor r10 = (ContinuationInterceptor) r8;
        TransactionElement r5 = new TransactionElement(r9, r10);
        ThreadLocal<Integer> r11 = reflectGetSuspendingTransactionId(r4);
        e0 r12 = new e0(Boxing.boxInt(System.identityHashCode(r9)), r11);
        return r10.plus(r5).plus(r12);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        CompletableJob r13 = JobKt.Job$default(null, 1, null);
        Job r14 = r0.getContext().get(Job.Key);
        if (r14 == null) goto L17;
        r14.invokeOnCompletion(new createTransactionContext.2(r13));
    L17:
        Executor r15 = r6.getTransactionExecutor();
        r0.L$0 = r6;
        r0.L$1 = r13;
        r0.label = 1;
        Object r16 = acquireTransactionThread(r15, r13, r0);
        if (r16 != r2) goto L20;
        return r2;
    L20:
        r4 = r6;
        r9 = r13;
        r8 = r16;
    L7:
        r0 = new createTransactionContext.1(r7);
        goto L8
    }

    public static final /* synthetic */ Object access$acquireTransactionThread(Executor r0, Job r1, Continuation r2) {
        return acquireTransactionThread(r0, r1, r2);
    }

    private static final Object acquireTransactionThread(Executor r3, Job r4, Continuation<? super ContinuationInterceptor> r5) {
        j r0 = new j(IntrinsicsKt.intercepted(r5), 1);
        r0.C();
        r0.i(new acquireTransactionThread.2.1(r4));
        r3.execute(new acquireTransactionThread.2.2(r0, r4));     // Catch: RejectedExecutionException -> L5
    L7:
        Object r6 = r0.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L10:
        return r6;
    L5:
        e = move-exception;
        r0.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        goto L7
    }

    public static final <R> Object withTransaction(RoomDatabase r5, Function1<? super Continuation<? super R>, ? extends Object> r6, Continuation<? super R> r7) {
        if ((r7 instanceof withTransaction.1) == false) goto L7;
        withTransaction.1 r0 = (withTransaction.1) r7;
        int r1 = r0.label;
        if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
        r0.label = r1 - IWakeupSessionConstant.RC_ERROR;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
    L28:
        return r8;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = (Function1) r0.L$1;
        r5 = (RoomDatabase) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L24:
        CoroutineContext r9 = (CoroutineContext) r8;
    L25:
        withTransaction.2 r4 = new withTransaction.2(r5, r6, null);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        r8 = BuildersKt.withContext(r9, r4, r0);
        if (r8 != r2) goto L28;
        return r2;
    L16:
        ResultKt.throwOnFailure(r8);
        TransactionElement r10 = (TransactionElement) r0.getContext().get(TransactionElement.Key);
        if (r10 == null) goto L21;
        r9 = r10.getTransactionDispatcher$room_ktx_release();
        if (r9 != null) goto L25;
    L21:
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.label = 1;
        r8 = createTransactionContext(r5, r0);
        if (r8 != r2) goto L24;
        return r2;
    L7:
        r0 = new withTransaction.1(r7);
        goto L8
    }
}
