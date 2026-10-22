package com.larus.contextwindow.impl.membership;

import com.larus.contextwindow.impl.membership.model.MembershipQuotaSummaryDto;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class MembershipQuotaApi {
    public static final MembershipQuotaApi a = null;

    static {
        a = new MembershipQuotaApi();
    }

    public MembershipQuotaApi() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public final Object a(Continuation<? super e> r18) {
        if ((r18 instanceof MembershipQuotaApi$fetch$1) == false) goto L7;
        MembershipQuotaApi$fetch$1 r2 = (MembershipQuotaApi$fetch$1) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        MembershipQuotaApi$fetch$1 r14 = r2;
        Object r0 = r14.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r14.label;
        ?? r15 = "MembershipQuotaApi";
        if (r5 == 0) goto L15;
        if (r5 != 1) goto L14;
        ResultKt.throwOnFailure(r0);     // Catch: CancellationException -> L34 Throwable -> L36
        ?? r6 = "MembershipQuotaApi";
        r15 = r15;
    L21:
        y r1 = (com.larus.network.http.a) r0;     // Catch: Throwable -> L32 CancellationException -> L34
        if ((r1 instanceof y) == false) goto L28;
        MembershipQuotaSummaryDto r7 = (MembershipQuotaSummaryDto) ((com.larus.network.http.a) r1).b;     // Catch: Throwable -> L32 CancellationException -> L34
        if (r7 == null) goto L26;
        FLogger.a.i(r6, "quota summary request success path=/alice/commerce/sale/subscription/quota/summary/");     // Catch: Throwable -> L32 CancellationException -> L34
        return new e.b(r7);
    L26:
        FLogger.a.e(r6, "quota summary request empty path=/alice/commerce/sale/subscription/quota/summary/");     // Catch: Throwable -> L32 CancellationException -> L34
        return e.a.a;
    L28:
        if ((r1 instanceof com.larus.network.http.f) == false) goto L30;
        FLogger.a.e(r6, "quota summary request failed path=/alice/commerce/sale/subscription/quota/summary/ code=" + ((com.larus.network.http.f) r1).d.getCode());     // Catch: Throwable -> L32 CancellationException -> L34
        return e.a.a;
    L30:
        FLogger.a.e(r6, "quota summary request incomplete path=/alice/commerce/sale/subscription/quota/summary/");     // Catch: Throwable -> L32 CancellationException -> L34
        return e.a.a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r0);
        JSONObject r8 = new JSONObject().put("product_line", "membership");     // Catch: CancellationException -> L34 Throwable -> L36
        r14.label = 1;     // Catch: CancellationException -> L34 Throwable -> L36
        ?? r9 = "MembershipQuotaApi";
        r15 = 944(0x3b0, float:1.323E-42);
        r0 = HttpExtKt.k("Basic", MembershipQuotaSummaryDto.class, "/alice/commerce/sale/subscription/quota/summary/", r8, null, null, true, null, null, null, r14, 944);     // Catch: Throwable -> L32 CancellationException -> L34
        r6 = r9;
        if (r0 != r4) goto L21;
        return r4;
    L32:
        th = th;
    L38:
        FLogger.a.e(r9, "quota summary request exception path=/alice/commerce/sale/subscription/quota/summary/ type=".concat(th.getClass().getSimpleName()));
        return e.a.a;
    L34:
        e = move-exception;
        throw e;
    L36:
        th = th;
        r9 = r15;
    L7:
        r2 = new MembershipQuotaApi$fetch$1(this, r18);
        goto L8
    }
}
