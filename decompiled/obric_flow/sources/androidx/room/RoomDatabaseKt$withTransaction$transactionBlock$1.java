package androidx.room;

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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.room.RoomDatabaseKt$withTransaction$transactionBlock$1", f = "RoomDatabaseExt.kt", i = {0}, l = {56}, m = "invokeSuspend", n = {"transactionElement"}, s = {"L$0"})
public final class RoomDatabaseKt$withTransaction$transactionBlock$1<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public RoomDatabaseKt$withTransaction$transactionBlock$1(RoomDatabase r5, Function1<? super Continuation<? super R>, ? extends Object> r10, Continuation<? super RoomDatabaseKt$withTransaction$transactionBlock$1> r11) {
        this.$this_withTransaction = r5;
        this.$block = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        RoomDatabaseKt$withTransaction$transactionBlock$1 r11 = new RoomDatabaseKt$withTransaction$transactionBlock$1(this.$this_withTransaction, this.$block, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Object r10) {
        return invoke(r5, (Continuation) r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 != 1) goto L11;
        TransactionElement r12 = (TransactionElement) this.L$0;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L8
        TransactionElement r13 = r12;
    L18:
        this.$this_withTransaction.setTransactionSuccessful();     // Catch: Throwable -> L8
        this.$this_withTransaction.endTransaction();     // Catch: Throwable -> L22
        r13.release();
        return r5;
    L8:
        Throwable th2 = th;
    L26:
        this.$this_withTransaction.endTransaction();     // Catch: Throwable -> L22
        throw th2;     // Catch: Throwable -> L22
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r5);
        CoroutineContext.Element r14 = ((CoroutineScope) this.L$0).getCoroutineContext().get(TransactionElement.Key);
        Intrinsics.checkNotNull(r14);
        TransactionElement r15 = (TransactionElement) r14;
        r15.acquire();
        this.$this_withTransaction.beginTransaction();     // Catch: Throwable -> L28
        Function1<Continuation<? super R>, Object> r16 = this.$block;     // Catch: Throwable -> L24
        this.L$0 = r15;     // Catch: Throwable -> L24
        this.label = 1;     // Catch: Throwable -> L24
        Object r17 = r16.invoke(this);     // Catch: Throwable -> L24
        if (r17 != r10) goto L17;
        return r10;
    L17:
        r13 = r15;
        r5 = r17;
    L24:
        th = move-exception;
        th2 = th;
    L28:
        th = th;
    L29:
        r15.release();
        throw th;
    L22:
        th = th;
        r15 = r10;
        goto L29
    }

    public final Object invoke(CoroutineScope r5, Continuation<? super R> r10) {
        return ((RoomDatabaseKt$withTransaction$transactionBlock$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
