package com.larus.avlink.gallery.executor;

import android.net.Uri;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaSyncExecutor$checkDeletedMedia$1$2", f = "MediaSyncExecutor.kt", i = {}, l = {315, 330}, m = "invokeSuspend", n = {}, s = {})
public final class MediaSyncExecutor$checkDeletedMedia$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public MediaSyncExecutor$checkDeletedMedia$1$2(Continuation<? super MediaSyncExecutor$checkDeletedMedia$1$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new MediaSyncExecutor$checkDeletedMedia$1$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L9;
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L12
    L29:
        List r9 = (List) r8;     // Catch: Exception -> L12
        if ((!r9.isEmpty()) == false) goto L39;
        w88.a r0 = MediaSyncExecutor.i;     // Catch: Exception -> L12
        if (r0 == null) goto L38;
        List r3 = r9;     // Catch: Exception -> L12
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));     // Catch: Exception -> L12
        Iterator r5 = r3.iterator();     // Catch: Exception -> L12
    L35:
        if (r5.hasNext() == false) goto L37;
        r4.add(((File) r5.next()).getAbsolutePath());     // Catch: Exception -> L12
        goto L35
    L37:
        r0.qU(r4);     // Catch: Exception -> L12
    L38:
        FLogger.a.i("MediaSyncExecutor", "=== Batch Delete Completed: " + r9.size() + " file(s) deleted, listener notified ===");     // Catch: Exception -> L12
    L48:
        return Unit.INSTANCE;
    L39:
        FLogger.a.i("MediaSyncExecutor", "=== Batch Delete Completed: No files deleted ===");     // Catch: Exception -> L12
        goto L48
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L12
    L18:
        Object r10 = MediaSyncExecutor.e;     // Catch: Exception -> L12
        monitor-enter(r10);     // Catch: Exception -> L12
        Set<Uri> r6 = MediaSyncExecutor.d;     // Catch: Throwable -> L40
        List r7 = CollectionsKt.toList(r6);     // Catch: Throwable -> L40
        r6.clear();     // Catch: Throwable -> L40
        monitor-exit(r10);     // Catch: Exception -> L12
        if (r7.isEmpty() == false) goto L26;
        FLogger.a.d("MediaSyncExecutor", "No URIs to process after debounce");     // Catch: Exception -> L12
        return Unit.INSTANCE;
    L26:
        FLogger.a.i("MediaSyncExecutor", "=== Batch Delete Check Started: " + r7.size() + " URI(s) ===");     // Catch: Exception -> L12
        MediaSyncExecutor r11 = MediaSyncExecutor.a;     // Catch: Exception -> L12
        this.label = 2;     // Catch: Exception -> L12
        r8 = MediaSyncExecutor.b(r11, r7, this);     // Catch: Exception -> L12
        if (r8 != r1) goto L29;
        return r1;
    L40:
        th = move-exception;
        throw th;     // Catch: Exception -> L12
    L14:
        ResultKt.throwOnFailure(r8);
        this.label = 1;     // Catch: Exception -> L12
        if (DelayKt.delay(300, this) != r1) goto L18;
        return r1;
    L12:
        e = move-exception;
        if ((e instanceof CancellationException) == false) goto L46;
        FLogger.a.d("MediaSyncExecutor", "Debounce job cancelled (new delete event received)");
        goto L48
    L46:
        FLogger.a.e("MediaSyncExecutor", "Error in batch delete check: " + e.getMessage(), e);
        goto L48
    }
}
