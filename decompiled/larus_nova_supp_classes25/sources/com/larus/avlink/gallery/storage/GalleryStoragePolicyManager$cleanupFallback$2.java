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
@DebugMetadata(c = "com.larus.avlink.gallery.storage.GalleryStoragePolicyManager$cleanupFallback$2", f = "GalleryStoragePolicyManager.kt", i = {0, 1, 2, 2}, l = {536, 118, 119}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "orphanResult"}, s = {"L$0", "L$0", "L$0", "L$1"})
public final class GalleryStoragePolicyManager$cleanupFallback$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super o>, Object> {
    Object L$0;
    Object L$1;
    int label;

    public GalleryStoragePolicyManager$cleanupFallback$2(Continuation<? super GalleryStoragePolicyManager$cleanupFallback$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new GalleryStoragePolicyManager$cleanupFallback$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super o> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v6, types: [kotlinx.coroutines.sync.a] */
    public final Object invokeSuspend(Object r12) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        kotlinx.coroutines.sync.a r2 = this.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L12;
        if (r2 != 3) goto L11;
        o r3 = (o) this.L$1;
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L30
        r2 = r4;
    L27:
        o r13 = (o) r12;     // Catch: Throwable -> L30
        o r5 = new o(r3.a + r13.a, r3.b + r13.b, "fallback(" + r3.c + ", " + r13.c + ')');     // Catch: Throwable -> L30
        r2.unlock(null);
        return r5;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L30
        kotlinx.coroutines.sync.a r7 = r6;
    L23:
        o r14 = (o) r12;     // Catch: Throwable -> L30
        GalleryStoragePolicyManager r8 = GalleryStoragePolicyManager.a;     // Catch: Throwable -> L30
        this.L$0 = r7;     // Catch: Throwable -> L30
        this.L$1 = r14;     // Catch: Throwable -> L30
        this.label = 3;     // Catch: Throwable -> L30
        Object r9 = GalleryStoragePolicyManager.b(r8, this);     // Catch: Throwable -> L30
        if (r9 != r1) goto L26;
        return r1;
    L26:
        r3 = r14;
        r12 = r9;
        r2 = r7;
        goto L27
    L15:
        kotlinx.coroutines.sync.a r10 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r12);
        kotlinx.coroutines.sync.a r11 = r10;
    L20:
        GalleryStoragePolicyManager r15 = GalleryStoragePolicyManager.a;     // Catch: Throwable -> L30
        this.L$0 = r11;     // Catch: Throwable -> L30
        this.label = 2;     // Catch: Throwable -> L30
        r12 = GalleryStoragePolicyManager.a(r15, this);     // Catch: Throwable -> L30
        r7 = r11;
        if (r12 != r1) goto L23;
        return r1;
    L16:
        ResultKt.throwOnFailure(r12);
        kotlinx.coroutines.sync.a r16 = GalleryStoragePolicyManager.b;
        this.L$0 = r16;
        this.label = 1;
        if (r16.a(null, this) != r1) goto L19;
        return r1;
    L19:
        r11 = r16;
    L30:
        th = move-exception;
        r2.unlock(null);
        throw th;
    }
}
