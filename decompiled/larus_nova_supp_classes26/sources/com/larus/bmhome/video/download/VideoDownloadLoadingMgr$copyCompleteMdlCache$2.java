package com.larus.bmhome.video.download;

import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import com.larus.utils.r;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.download.VideoDownloadLoadingMgr$copyCompleteMdlCache$2", f = "VideoDownloadLoadingMgr.kt", i = {}, l = {493}, m = "invokeSuspend", n = {}, s = {})
final class VideoDownloadLoadingMgr$copyCompleteMdlCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ String $downloadTaskKey;
    final /* synthetic */ String $resultPath;
    final /* synthetic */ String $suffix;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VideoDownloadLoadingMgr this$0;

    public VideoDownloadLoadingMgr$copyCompleteMdlCache$2(VideoDownloadLoadingMgr r1, String r2, String r3, String r4, String r5, Continuation<? super VideoDownloadLoadingMgr$copyCompleteMdlCache$2> r6) {
        this.this$0 = r1;
        this.$cacheKey = r2;
        this.$downloadTaskKey = r3;
        this.$resultPath = r4;
        this.$suffix = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        VideoDownloadLoadingMgr$copyCompleteMdlCache$2 r7 = new VideoDownloadLoadingMgr$copyCompleteMdlCache$2(this.this$0, this.$cacheKey, this.$downloadTaskKey, this.$resultPath, this.$suffix, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L42:
        return r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        String r16 = this.$cacheKey;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        Lazy r4 = q3.a;     // Catch: Throwable -> L15
        z3 r5 = q3.a();     // Catch: Throwable -> L15
        if (r5 == null) goto L12;
        yq9.a r17 = r5.g(r16);     // Catch: Throwable -> L15
    L13:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L15
    L17:
        VideoDownloadLoadingMgr r6 = this.this$0;
        String r7 = this.$cacheKey;
        Throwable r8 = Result.exceptionOrNull-impl(r18);
        if (r8 == null) goto L21;
        FLogger.a.e(r6.b, "[copyCompleteMdlCache] get cache failed, key=" + r7 + ", " + r8);
    L21:
        if (Result.isFailure-impl(r18) == false) goto L23;
        r18 = null;
    L23:
        yq9.a r19 = (yq9.a) r18;
        if (r19 == null) goto L26;
        String r9 = r19.c;
    L27:
        if (r9 != null) goto L29;
    L31:
        String r10 = null;
    L32:
        if (r19 == null) goto L43;
        long r11 = r19.a;
        if (r11 <= 0) goto L43;
        if (r19.b < r11) goto L43;
        if (r10 == null) goto L43;
        VideoDownloadLoadingMgr r12 = this.this$0;
        String r13 = this.$downloadTaskKey;
        String r20 = this.$cacheKey;
        String r21 = this.$resultPath;
        String r110 = this.$suffix;
        this.label = 1;
        r12.getClass();
        r14 = BuildersKt.withContext(Dispatchers.getIO(), new VideoDownloadLoadingMgr$copyMdlCacheFile$2(r10, r12, r20, r21, r110, r13, null), this);
        if (r14 != r0) goto L42;
        return r0;
    L43:
        FLogger r2 = FLogger.a;
        String r22 = this.this$0.b;
        StringBuilder r23 = new StringBuilder("[copyCompleteMdlCache] miss, key=");
        r23.append(this.$cacheKey);
        r23.append(", mediaSize=");
        if (r19 == null) goto L46;
        Long r24 = Boxing.boxLong(r19.a);
    L47:
        r23.append(r24);
        r23.append(", cacheSize=");
        if (r19 == null) goto L50;
        Long r111 = Boxing.boxLong(r19.b);
    L51:
        r23.append(r111);
        r23.append(", localPath=");
        r23.append(r9);
        r23.append(", downloadTaskKey=");
        r23.append(this.$downloadTaskKey);
        r2.i(r22, r23.toString());
        return null;
    L50:
        r111 = null;
        goto L51
    L46:
        r24 = null;
        goto L47
    L29:
        if (r.k(r9) == false) goto L31;
        r10 = r9;
        goto L32
    L26:
        r9 = null;
        goto L27
    L12:
        r17 = null;
    L15:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
