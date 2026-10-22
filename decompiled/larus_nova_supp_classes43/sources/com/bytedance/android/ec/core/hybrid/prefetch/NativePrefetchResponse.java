package com.bytedance.android.ec.core.hybrid.prefetch;

import com.bytedance.android.ec.core.utils.k0;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/NativePrefetchResponse;", "Ljava/io/Serializable;", "()V", "data", "", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "ecNetRequestEnd", "", "getEcNetRequestEnd", "()Ljava/lang/Long;", "setEcNetRequestEnd", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "ttNetExtraInfo", "", "getTtNetExtraInfo", "()Ljava/lang/Object;", "setTtNetExtraInfo", "(Ljava/lang/Object;)V", "getEcNetReportJSON", "Lorg/json/JSONObject;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NativePrefetchResponse implements Serializable {
    private String data;
    private Long ecNetRequestEnd;
    private Object ttNetExtraInfo;

    public NativePrefetchResponse() {
    }

    public final JSONObject getEcNetReportJSON() {
        Object r0 = this.ttNetExtraInfo;
        if (r0 != null) goto L16;
        return null;
    L16:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        Object r1 = Result.constructor-impl(k0.a(com.bytedance.android.ec.hybrid.list.util.k.d(r0), this.ecNetRequestEnd));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r1) == false) goto L12;
        r1 = null;
    L12:
        di.d r11 = (di.d) r1;
        if (r11 != null) goto L15;
        return null;
    L15:
        return k0.i(r11);
    L7:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final String getData() {
        return this.data;
    }

    public final Long getEcNetRequestEnd() {
        return this.ecNetRequestEnd;
    }

    public final Object getTtNetExtraInfo() {
        return this.ttNetExtraInfo;
    }

    public final void setData(String r1) {
        this.data = r1;
    }

    public final void setEcNetRequestEnd(Long r1) {
        this.ecNetRequestEnd = r1;
    }

    public final void setTtNetExtraInfo(Object r1) {
        this.ttNetExtraInfo = r1;
    }
}
