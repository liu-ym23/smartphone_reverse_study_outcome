package com.larus.avlink.gallery.executor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaSyncExecutor$checkDeletedMedia$1$1", f = "MediaSyncExecutor.kt", i = {0}, l = {289}, m = "invokeSuspend", n = {"deletedFiles"}, s = {"L$0"})
public final class MediaSyncExecutor$checkDeletedMedia$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public MediaSyncExecutor$checkDeletedMedia$1$1(Continuation<? super MediaSyncExecutor$checkDeletedMedia$1$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new MediaSyncExecutor$checkDeletedMedia$1$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        List r2 = (List) this.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L27
    L16:
        if ((!r2.isEmpty()) == false) goto L25;
        w88.a r7 = MediaSyncExecutor.i;     // Catch: Exception -> L27
        if (r7 == null) goto L24;
        List r3 = r2;     // Catch: Exception -> L27
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));     // Catch: Exception -> L27
        Iterator r5 = r3.iterator();     // Catch: Exception -> L27
    L21:
        if (r5.hasNext() == false) goto L23;
        r4.add(((File) r5.next()).getAbsolutePath());     // Catch: Exception -> L27
        goto L21
    L23:
        r7.qU(r4);     // Catch: Exception -> L27
    L24:
        FLogger.a.i("MediaSyncExecutor", "=== Full Check Completed: " + r2.size() + " file(s) deleted ===");     // Catch: Exception -> L27
    L30:
        return Unit.INSTANCE;
    L25:
        FLogger.a.i("MediaSyncExecutor", "=== Full Check Completed: No files deleted ===");     // Catch: Exception -> L27
        goto L30
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r6);
        FLogger.a.i("MediaSyncExecutor", "Starting full delete check");     // Catch: Exception -> L27
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L27
        MediaSyncExecutor r9 = MediaSyncExecutor.a;     // Catch: Exception -> L27
        this.L$0 = r8;     // Catch: Exception -> L27
        this.label = 1;     // Catch: Exception -> L27
        if (MediaSyncExecutor.a(r9, r8, this) != r0) goto L14;
        return r0;
    L14:
        r2 = r8;
    L27:
        e = move-exception;
        FLogger.a.e("MediaSyncExecutor", "Error in full delete check: " + e.getMessage(), e);
        goto L30
    }
}
