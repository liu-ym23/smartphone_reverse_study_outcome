package com.larus.avlink.gallery.storage;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import w88.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/api/GalleryStorageCleanupResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.storage.GalleryStoragePolicyManager$cleanupPackFiles$2", f = "GalleryStoragePolicyManager.kt", i = {0, 1}, l = {536, 135}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class GalleryStoragePolicyManager$cleanupPackFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super o>, Object> {
    Object L$0;
    int label;

    public GalleryStoragePolicyManager$cleanupPackFiles$2(Continuation<? super GalleryStoragePolicyManager$cleanupPackFiles$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new GalleryStoragePolicyManager$cleanupPackFiles$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super o> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L9
    L21:
        o r8 = (o) r7;     // Catch: Throwable -> L9
        r2.unlock(null);
        return r8;
    L9:
        th = move-exception;
        kotlinx.coroutines.sync.a r5 = r2;
        th = th;
        kotlinx.coroutines.sync.a r9 = r5;
    L26:
        r9.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r7);
        r9 = r3;
    L28:
        GalleryStoragePolicyManager r4 = GalleryStoragePolicyManager.a;     // Catch: Throwable -> L25
        this.L$0 = r9;     // Catch: Throwable -> L25
        this.label = 2;     // Catch: Throwable -> L25
        Object r6 = GalleryStoragePolicyManager.b(r4, this);     // Catch: Throwable -> L25
        if (r6 != r0) goto L20;
        return r0;
    L20:
        r2 = r9;
        r7 = r6;
    L25:
        th = th;
        goto L26
    L14:
        ResultKt.throwOnFailure(r7);
        r9 = GalleryStoragePolicyManager.b;
        this.L$0 = r9;
        this.label = 1;
        if (r9.a(null, this) != r0) goto L28;
        return r0;
    }
}
