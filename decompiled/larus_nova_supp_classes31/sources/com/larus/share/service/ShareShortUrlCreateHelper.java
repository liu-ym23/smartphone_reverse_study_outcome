package com.larus.share.service;

import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutCancellationException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ShareShortUrlCreateHelper {
    public static final ShareShortUrlCreateHelper a = null;

    static {
        a = new ShareShortUrlCreateHelper();
    }

    public ShareShortUrlCreateHelper() {
    }

    public static /* synthetic */ Object b(String r7, Continuation r8) {
        return a.a(r7, true, null, z2.a.getSaasShareConfig().i(), r8);
    }

    public final Object a(String r20, boolean r21, JSONObject r22, long r23, Continuation<? super j> r25) {
        if ((r25 instanceof ShareShortUrlCreateHelper$createShortUrl$1) == false) goto L7;
        ShareShortUrlCreateHelper$createShortUrl$1 r1 = (ShareShortUrlCreateHelper$createShortUrl$1) r25;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L20;
        if (r4 != 1) goto L19;
        long r5 = r1.J$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14 CancellationException -> L16 TimeoutCancellationException -> L48
    L41:
        goto L46
    L55:
        return (j) r0;
    L46:
        FLogger.a.w("ShareShortUrlCreateHelper", "create short url timeout, timeoutMs=" + r5);
        return new j.c(r5);
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r0);
        Long r6 = null;
        if (StringsKt.isBlank(r20) == true) goto L23;
        Long r7 = Boxing.boxLong(r23);
        if (r7.longValue() <= 0) goto L27;
        boolean r8 = true;
    L28:
        if (r8 == false) goto L30;
        r6 = r7;
    L30:
        if (r6 == null) goto L32;
        long r9 = r6.longValue();
    L51:
        CoroutineDispatcher r10 = Dispatchers.getIO();     // Catch: Throwable -> L14 CancellationException -> L16 TimeoutCancellationException -> L45
        if (r21 == false) goto L36;
        boolean r16 = true;
    L37:
        ShareShortUrlCreateHelper$createShortUrl$2 r11 = new ShareShortUrlCreateHelper$createShortUrl$2(r9, r20, r16, r22, null);     // Catch: Throwable -> L14 CancellationException -> L16 TimeoutCancellationException -> L45
        r1.J$0 = r9;     // Catch: Throwable -> L14 CancellationException -> L16 TimeoutCancellationException -> L45
        r1.label = 1;     // Catch: Throwable -> L14 CancellationException -> L16 TimeoutCancellationException -> L45
        r0 = BuildersKt.withContext(r10, r11, r1);     // Catch: Throwable -> L14 CancellationException -> L16 TimeoutCancellationException -> L45
        if (r0 != r3) goto L40;
        return r3;
    L40:
        r5 = r9;
        goto L41
    L36:
        r16 = false;
    L45:
        r5 = r9;
        goto L46
    L32:
        r9 = 5000;
        goto L51
    L27:
        r8 = false;
        goto L28
    L23:
        return new j.a("long url is empty", null, 5);
    L16:
        e = move-exception;
        throw e;
    L14:
        th = move-exception;
        FLogger.a.e("ShareShortUrlCreateHelper", "create short url exception", th);
        return new j.a(th.getMessage(), th, 1);
    L7:
        r1 = new ShareShortUrlCreateHelper$createShortUrl$1(this, r25);
        goto L8
    }
}
