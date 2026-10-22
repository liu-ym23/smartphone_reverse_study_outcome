package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.SystemClock;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"fromJsonResponse", "Lorg/json/JSONObject;", "httpResponse", "Lcom/bytedance/android/livesdkapi/model/HttpResponse;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class FetchV3Method$modifyHeadersAndGetResponseDecoder$1 extends Lambda implements Function1<HttpResponse, JSONObject> {
    final /* synthetic */ String $pageUrl;
    final /* synthetic */ boolean $reportMetric;
    final /* synthetic */ FetchV3Method this$0;

    public FetchV3Method$modifyHeadersAndGetResponseDecoder$1(FetchV3Method r1, String r2, boolean r3) {
        this.this$0 = r1;
        this.$pageUrl = r2;
        this.$reportMetric = r3;
        super(1);
    }

    public final JSONObject invoke(HttpResponse r9) {
        Intrinsics.checkNotNullParameter(r9, "httpResponse");
        long r0 = SystemClock.elapsedRealtime();
        String r3 = new String(r9.getBody(), Charsets.UTF_8);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        JSONObject r4 = new JSONObject(r3);     // Catch: Throwable -> L10
        String r5 = this.$pageUrl;     // Catch: Throwable -> L10
        if (r5 != null) goto L6;
    L8:
        Object r1 = Result.constructor-impl(FetchV3Method.j(this.this$0, r4, r9));     // Catch: Throwable -> L10
    L13:
        if (Result.isSuccess-impl(r1) == false) goto L17;
        return (JSONObject) r1;
    L17:
        if (Result.exceptionOrNull-impl(r1) == null) goto L24;
        String r11 = r9.header("x-tt-logid");
        if (r11 != null) goto L22;
        r11 = "";
    L22:
        throw new RawNotJsonException(r3, r11);
    L24:
        return new JSONObject();
    L6:
        if (this.$reportMetric == false) goto L8;
        FetchV3Method r6 = this.this$0;     // Catch: Throwable -> L10
        long r7 = SystemClock.elapsedRealtime() - r0;     // Catch: Throwable -> L10
        int r8 = FetchV3Method.e;     // Catch: Throwable -> L10
        r6.getClass();     // Catch: Throwable -> L10
        FetchV3Method.l(0, r5, r7);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((HttpResponse) r1);
    }
}
