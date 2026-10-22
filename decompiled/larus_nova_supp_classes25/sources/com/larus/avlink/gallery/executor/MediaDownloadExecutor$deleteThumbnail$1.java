package com.larus.avlink.gallery.executor;

import com.larus.avlink.gallery.thumbnail.ThumbnailManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaDownloadExecutor$deleteThumbnail$1", f = "MediaDownloadExecutor.kt", i = {}, l = {646}, m = "invokeSuspend", n = {}, s = {})
final class MediaDownloadExecutor$deleteThumbnail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ String $sn;
    int label;

    public MediaDownloadExecutor$deleteThumbnail$1(String r1, String r2, Continuation<? super MediaDownloadExecutor$deleteThumbnail$1> r3) {
        this.$id = r1;
        this.$sn = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MediaDownloadExecutor$deleteThumbnail$1(this.$id, this.$sn, r4);
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
        if (r2 == 0) goto L11;
        if (r2 != 1) goto L10;
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L7
    L17:
        FLogger.a.i("MediaDownloadExecutor", "Deleted thumbnail for id: " + this.$id);     // Catch: Exception -> L7
    L21:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r8);
        Long r9 = StringsKt.toLongOrNull(this.$id);     // Catch: Exception -> L7
        if (r9 == null) goto L21;
        ThumbnailManager r3 = ThumbnailManager.a;     // Catch: Exception -> L7
        long r5 = r9.longValue();     // Catch: Exception -> L7
        String r10 = this.$sn;     // Catch: Exception -> L7
        this.label = 1;     // Catch: Exception -> L7
        if (r3.i(r5, r10, this) != r1) goto L17;
        return r1;
    L7:
        e = move-exception;
        FLogger.a.e("MediaDownloadExecutor", "Error deleting thumbnail: " + e.getMessage(), e);
        goto L21
    }
}
