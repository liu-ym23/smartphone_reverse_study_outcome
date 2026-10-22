package com.larus.bmhome.video.download;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.larus.utils.r;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.download.VideoDownloadLoadingMgr$copyMdlCacheFile$2", f = "VideoDownloadLoadingMgr.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VideoDownloadLoadingMgr$copyMdlCacheFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ String $downloadTaskKey;
    final /* synthetic */ String $localFilePath;
    final /* synthetic */ String $resultPath;
    final /* synthetic */ String $suffix;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VideoDownloadLoadingMgr this$0;

    public VideoDownloadLoadingMgr$copyMdlCacheFile$2(String r1, VideoDownloadLoadingMgr r2, String r3, String r4, String r5, String r6, Continuation<? super VideoDownloadLoadingMgr$copyMdlCacheFile$2> r7) {
        this.$localFilePath = r1;
        this.this$0 = r2;
        this.$cacheKey = r3;
        this.$resultPath = r4;
        this.$suffix = r5;
        this.$downloadTaskKey = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        VideoDownloadLoadingMgr$copyMdlCacheFile$2 r8 = new VideoDownloadLoadingMgr$copyMdlCacheFile$2(this.$localFilePath, this.this$0, this.$cacheKey, this.$resultPath, this.$suffix, this.$downloadTaskKey, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        char r12 = r.a;
        if (r.k(this.$localFilePath) == true) goto L8;
        FLogger.a.i(this.this$0.b, "[copyMdlCacheFile] local file miss, key=" + this.$cacheKey + ", localPath=" + this.$localFilePath);
        return null;
    L8:
        String r13 = this.$resultPath;
        String r1 = this.$suffix;
        String r2 = this.$localFilePath;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        PolarisFileWrapper r4 = new PolarisFileWrapper(r13);     // Catch: Throwable -> L14
        if (r4.exists() == true) goto L12;
        r4.mkdirs();     // Catch: Throwable -> L14
    L12:
        PolarisFileWrapper r14 = new PolarisFileWrapper(r4, System.currentTimeMillis() + r1);     // Catch: Throwable -> L14
        FilesKt.copyTo$default(new PolarisFileWrapper(r2), r14, true, 0, 4, null);     // Catch: Throwable -> L14
        Object r15 = Result.constructor-impl(r14.getAbsolutePath());     // Catch: Throwable -> L14
    L16:
        VideoDownloadLoadingMgr r5 = this.this$0;
        String r6 = this.$cacheKey;
        String r7 = this.$downloadTaskKey;
        if (Result.isSuccess-impl(r15) == false) goto L19;
        FLogger.a.i(r5.b, "[copyMdlCacheFile] hit, key=" + r6 + ", path=" + ((String) r15) + ", downloadTaskKey=" + r7);
    L19:
        VideoDownloadLoadingMgr r8 = this.this$0;
        String r9 = this.$cacheKey;
        String r16 = this.$downloadTaskKey;
        Throwable r17 = Result.exceptionOrNull-impl(r15);
        if (r17 == null) goto L23;
        FLogger.a.e(r8.b, "[copyMdlCacheFile] copy failed, key=" + r9 + ", downloadTaskKey=" + r16 + ", " + r17);
    L23:
        if (Result.isFailure-impl(r15) == false) goto L26;
        return null;
    L26:
        return r15;
    L14:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
