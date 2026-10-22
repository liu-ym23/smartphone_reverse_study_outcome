package com.obric.memorydata.memory.review.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportRetryState;", "", "<init>", "()V", "KEY_RETRY_COUNT", "", "KEY_MESSAGE", "retryCount", "", "lastError", "nextFailure", "message", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final as f10425a = null;

    static {
        f10425a = new as();
    }

    private as() {
    }

    public final int a(String r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L20;
        return 0;
    L20:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        as r3 = (as) ZeusTransformUtils.preCheckCast(this, as.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Object r5 = Result.m1421constructorimpl(Integer.valueOf(new JSONObject(r4).optInt("retryCount", 0)));     // Catch: Throwable -> L13
    L16:
        if (Result.m1427isFailureimpl(r5) == false) goto L19;
        r5 = 0;
    L19:
        return RangesKt.coerceAtLeast(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue(), 0);
    L13:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final String a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        String r2 = new JSONObject().put("retryCount", a(r3) + 1).put("message", r4).toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return r2;
    }
}
