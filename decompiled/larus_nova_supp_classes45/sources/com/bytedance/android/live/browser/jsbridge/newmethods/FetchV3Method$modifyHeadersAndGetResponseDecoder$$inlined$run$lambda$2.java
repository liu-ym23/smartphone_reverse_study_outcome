package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.model.HttpResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007¨\u0006\t"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "p1", "Lcom/bytedance/android/livesdkapi/model/HttpResponse;", "Lkotlin/ParameterName;", "name", "httpResponse", "invoke", "com/bytedance/android/live/browser/jsbridge/newmethods/FetchV3Method$modifyHeadersAndGetResponseDecoder$decoder$2$channel$2$1", "com/bytedance/android/live/browser/jsbridge/newmethods/FetchV3Method$$special$$inlined$run$lambda$1"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class FetchV3Method$modifyHeadersAndGetResponseDecoder$$inlined$run$lambda$2 extends FunctionReferenceImpl implements Function1<HttpResponse, JSONObject> {
    final /* synthetic */ String $dataMessageName$inlined;
    final /* synthetic */ boolean $dynamic$inlined;
    final /* synthetic */ String $extraMessageName$inlined;
    final /* synthetic */ FetchV3Method$modifyHeadersAndGetResponseDecoder$1 $fromJsonResponse$1$inlined;
    final /* synthetic */ String $pageUrl$inlined;
    final /* synthetic */ JSONObject $pbExtras$inlined;
    final /* synthetic */ boolean $reportMetric$inlined;
    final /* synthetic */ long $startCreateDecodeTs$inlined;

    public FetchV3Method$modifyHeadersAndGetResponseDecoder$$inlined$run$lambda$2(JSONObject r1, String r2, boolean r3, FetchV3Method$modifyHeadersAndGetResponseDecoder$1 r4, String r5, String r6, boolean r7, long r8) {
        this.$pbExtras$inlined = r1;
        this.$pageUrl$inlined = r2;
        this.$dynamic$inlined = r3;
        this.$fromJsonResponse$1$inlined = r4;
        this.$dataMessageName$inlined = r5;
        this.$extraMessageName$inlined = r6;
        this.$reportMetric$inlined = r7;
        this.$startCreateDecodeTs$inlined = r8;
        super(1, null, "fromJsonResponse", "invoke(Lcom/bytedance/android/livesdkapi/model/HttpResponse;)Lorg/json/JSONObject;", 0);
    }

    public final JSONObject invoke(HttpResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        return this.$fromJsonResponse$1$inlined.invoke(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((HttpResponse) r1);
    }
}
