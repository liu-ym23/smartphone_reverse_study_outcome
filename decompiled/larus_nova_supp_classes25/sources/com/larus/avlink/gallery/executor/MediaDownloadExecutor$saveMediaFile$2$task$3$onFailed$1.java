package com.larus.avlink.gallery.executor;

import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.socialbase.downloader.exception.BaseException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaDownloadExecutor$saveMediaFile$2$task$3$onFailed$1", f = "MediaDownloadExecutor.kt", i = {}, l = {513}, m = "invokeSuspend", n = {}, s = {})
public final class MediaDownloadExecutor$saveMediaFile$2$task$3$onFailed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseException $e;
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ MediaDownloadExecutor this$0;

    public MediaDownloadExecutor$saveMediaFile$2$task$3$onFailed$1(MediaDownloadExecutor r1, String r2, BaseException r3, Continuation<? super MediaDownloadExecutor$saveMediaFile$2$task$3$onFailed$1> r4) {
        this.this$0 = r1;
        this.$id = r2;
        this.$e = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MediaDownloadExecutor$saveMediaFile$2$task$3$onFailed$1(this.this$0, this.$id, this.$e, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L15:
        MediaDownloadExecutor.a(this.this$0);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MediaLifecycleStateManager r7 = this.this$0.c;
        String r2 = this.$id;
        StringBuilder r3 = new StringBuilder("Download failed: ");
        BaseException r4 = this.$e;
        if (r4 == null) goto L11;
        String r5 = r4.getMessage();
    L12:
        r3.append(r5);
        String r8 = r3.toString();
        this.label = 1;
        if (r7.b(r2, r8, this) != r0) goto L15;
        return r0;
    L11:
        r5 = null;
        goto L12
    }
}
