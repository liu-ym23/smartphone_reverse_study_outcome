package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.room.RoomDatabaseKt$withTransaction$transactionBlock$1", f = "RoomDatabaseExt.kt", i = {0}, l = {56}, m = "invokeSuspend", n = {"transactionElement"}, s = {"L$0"})
final class RoomDatabaseKt$withTransaction$transactionBlock$1<R> extends SuspendLambda implements Function2<al, Continuation<? super R>, Object> {
    final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    private /* synthetic */ Object L$0;
    int label;

    RoomDatabaseKt$withTransaction$transactionBlock$1(RoomDatabase r3, Function1<? super Continuation<? super R>, ? extends Object> r4, Continuation<? super RoomDatabaseKt$withTransaction$transactionBlock$1> r5) {
        Function1<Continuation<? super R>, Object> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_withTransaction = r3;
        this.$block = r6;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        RoomDatabaseKt$withTransaction$transactionBlock$1 r0 = new RoomDatabaseKt$withTransaction$transactionBlock$1(this.$this_withTransaction, this.$block, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Object r4) {
        return invoke((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(al r3, Continuation<? super R> r4) {
        return ((RoomDatabaseKt$withTransaction$transactionBlock$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), RoomDatabaseKt$withTransaction$transactionBlock$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        TransactionElement r2 = (TransactionElement) ZeusTransformUtils.preCheckCast(this.L$0, TransactionElement.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L8
        TransactionElement r3 = r2;
    L18:
        this.$this_withTransaction.setTransactionSuccessful();     // Catch: Throwable -> L8
        this.$this_withTransaction.endTransaction();     // Catch: Throwable -> L26
        r3.release();
        return r7;
    L8:
        Throwable th = th;
    L24:
        this.$this_withTransaction.endTransaction();     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r7);
        CoroutineContext.Element r8 = ((al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin")).getCoroutineContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(TransactionElement.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r8);
        TransactionElement r9 = (TransactionElement) ZeusTransformUtils.preCheckCast(r8, TransactionElement.class, "com.obric.memorydata.plugin");
        r9.acquire();
        this.$this_withTransaction.beginTransaction();     // Catch: Throwable -> L28
        Function1<Continuation<? super R>, Object> r4 = this.$block;     // Catch: Throwable -> L22
        this.L$0 = r9;     // Catch: Throwable -> L22
        this.label = 1;     // Catch: Throwable -> L22
        Object r5 = r4.invoke(this);     // Catch: Throwable -> L22
        if (r5 != r0) goto L17;
        return r0;
    L17:
        r3 = r9;
        r7 = r5;
    L22:
        th = move-exception;
        th = th;
    L28:
        th = th;
    L29:
        r9.release();
        throw th;
    L26:
        th = th;
        r9 = r0;
        goto L29
    }
}
