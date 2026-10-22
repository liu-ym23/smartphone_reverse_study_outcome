package com.larus.bmhome.video.download;

import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.download.VideoDownloadLoadingMgr$saveVideoByMdlCache$downloadedLocalFilePath$1", f = "VideoDownloadLoadingMgr.kt", i = {}, l = {448}, m = "invokeSuspend", n = {}, s = {})
public final class VideoDownloadLoadingMgr$saveVideoByMdlCache$downloadedLocalFilePath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ String $downloadTaskKey;
    final /* synthetic */ String $downloadUrl;
    int label;
    final /* synthetic */ VideoDownloadLoadingMgr this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.video.download.VideoDownloadLoadingMgr$saveVideoByMdlCache$downloadedLocalFilePath$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.video.download.VideoDownloadLoadingMgr$saveVideoByMdlCache$downloadedLocalFilePath$1$1", f = "VideoDownloadLoadingMgr.kt", i = {}, l = {450}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $cacheKey;
        final /* synthetic */ String $downloadTaskKey;
        final /* synthetic */ String $downloadUrl;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VideoDownloadLoadingMgr this$0;

        public AnonymousClass1(String r1, String r2, VideoDownloadLoadingMgr r3, String r4, Continuation<? super AnonymousClass1> r5) {
            this.$downloadUrl = r1;
            this.$cacheKey = r2;
            this.this$0 = r3;
            this.$downloadTaskKey = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.$downloadUrl, this.$cacheKey, this.this$0, this.$downloadTaskKey, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L19
        L15:
            String r10 = (String) r9;     // Catch: Throwable -> L19
        L17:
            Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L19
        L21:
            VideoDownloadLoadingMgr r2 = this.this$0;
            String r3 = this.$cacheKey;
            String r4 = this.$downloadTaskKey;
            Throwable r5 = Result.exceptionOrNull-impl(r11);
            if (r5 == null) goto L28;
            if ((r5 instanceof CancellationException) == true) goto L26;
            FLogger.a.e(r2.b, "[saveVideoByMdlCache] mdl download exception, key=" + r3 + ", downloadTaskKey=" + r4 + ", " + r5);
            goto L28
        L26:
            throw r5;
        L28:
            if (Result.isFailure-impl(r11) == false) goto L31;
            return null;
        L31:
            return r11;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r9);
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            String r13 = this.$downloadUrl;
            String r6 = this.$cacheKey;
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L19
            Lazy r8 = q3.a;     // Catch: Throwable -> L19
            z3 r14 = q3.a();     // Catch: Throwable -> L19
            if (r14 == null) goto L16;
            this.label = 1;     // Catch: Throwable -> L19
            r9 = r14.h(r13, r6, this);     // Catch: Throwable -> L19
            if (r9 != r0) goto L15;
            return r0;
        L16:
            r10 = null;
        L19:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L21
        }
    }

    public VideoDownloadLoadingMgr$saveVideoByMdlCache$downloadedLocalFilePath$1(String r1, String r2, VideoDownloadLoadingMgr r3, String r4, Continuation<? super VideoDownloadLoadingMgr$saveVideoByMdlCache$downloadedLocalFilePath$1> r5) {
        this.$downloadUrl = r1;
        this.$cacheKey = r2;
        this.this$0 = r3;
        this.$downloadTaskKey = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new VideoDownloadLoadingMgr$saveVideoByMdlCache$downloadedLocalFilePath$1(this.$downloadUrl, this.$cacheKey, this.this$0, this.$downloadTaskKey, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineDispatcher r11 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$downloadUrl, this.$cacheKey, this.this$0, this.$downloadTaskKey, null);
        this.label = 1;
        r10 = BuildersKt.withContext(r11, r2, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
