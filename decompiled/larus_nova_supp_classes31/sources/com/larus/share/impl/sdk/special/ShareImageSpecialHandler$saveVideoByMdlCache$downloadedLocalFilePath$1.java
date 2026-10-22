package com.larus.share.impl.sdk.special;

import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.sdk.special.ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1", f = "ShareImageSpecialHandler.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
final class ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ String $downloadUrl;
    private /* synthetic */ Object L$0;
    int label;

    public ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1(String r1, String r2, Continuation<? super ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1> r3) {
        this.$downloadUrl = r1;
        this.$cacheKey = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1 r0 = new ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1(this.$downloadUrl, this.$cacheKey, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L19
    L15:
        String r8 = (String) r7;     // Catch: Throwable -> L19
    L17:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L19
    L21:
        String r2 = this.$cacheKey;
        Throwable r3 = Result.exceptionOrNull-impl(r9);
        if (r3 == null) goto L28;
        if ((r3 instanceof CancellationException) == true) goto L26;
        FLogger.a.e("ShareImageSpecialHandler", "[saveVideoByMdlCache] mdl download exception, key=" + r2 + ", " + r3);
        goto L28
    L26:
        throw r3;
    L28:
        if (Result.isFailure-impl(r9) == false) goto L31;
        return null;
    L31:
        return r9;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        String r11 = this.$downloadUrl;
        String r4 = this.$cacheKey;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L19
        Lazy r6 = q3.a;     // Catch: Throwable -> L19
        z3 r12 = q3.a();     // Catch: Throwable -> L19
        if (r12 == null) goto L16;
        this.label = 1;     // Catch: Throwable -> L19
        r7 = r12.h(r11, r4, this);     // Catch: Throwable -> L19
        if (r7 != r0) goto L15;
        return r0;
    L16:
        r8 = null;
    L19:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }
}
