package com.larus.bmhome.video.download;

import android.content.Context;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import hq9.t0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.download.VideoDownloadLoadingMgr$saveVideoFile$2$startTimer$1", f = "VideoDownloadLoadingMgr.kt", i = {0}, l = {571}, m = "invokeSuspend", n = {"timeoutMs"}, s = {"L$0"})
final class VideoDownloadLoadingMgr$saveVideoFile$2$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.IntRef $downloadId;
    final /* synthetic */ String $downloadTaskKey;
    Object L$0;
    int label;
    final /* synthetic */ VideoDownloadLoadingMgr this$0;

    public VideoDownloadLoadingMgr$saveVideoFile$2$startTimer$1(VideoDownloadLoadingMgr r1, String r2, Context r3, Ref.IntRef r4, Continuation<? super VideoDownloadLoadingMgr$saveVideoFile$2$startTimer$1> r5) {
        this.this$0 = r1;
        this.$downloadTaskKey = r2;
        this.$context = r3;
        this.$downloadId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new VideoDownloadLoadingMgr$saveVideoFile$2$startTimer$1(this.this$0, this.$downloadTaskKey, this.$context, this.$downloadId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Long r2 = (Long) this.L$0;
        ResultKt.throwOnFailure(r9);
    L26:
        FLogger.a.e(this.this$0.b, "Download video timeout, timeoutMs: " + r2 + ", downloadTaskKey " + this.$downloadTaskKey);
        Downloader.getInstance(this.$context).cancel(this.$downloadId.element);
        VideoDownloadLoadingMgr.d(this.this$0, this.$downloadId.element, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        t0 r10 = z2.a.getCreationDownloaderConfig();
        if (r10 == null) goto L11;
        Long r11 = r10.callbackTimeoutMs;
    L12:
        long r4 = 0;
        if (r11 == null) goto L15;
        long r6 = r11.longValue();
    L17:
        if (r6 <= 0) goto L19;
        if (r11 == null) goto L22;
        r4 = r11.longValue();
    L22:
        this.L$0 = r11;
        this.label = 1;
        if (DelayKt.delay(r4, this) != r0) goto L25;
        return r0;
    L25:
        r2 = r11;
        goto L26
    L19:
        return Unit.INSTANCE;
    L15:
        r6 = 0;
        goto L17
    L11:
        r11 = null;
        goto L12
    }
}
