package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.model.HttpResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "p1", "Lcom/bytedance/android/livesdkapi/model/HttpResponse;", "Lkotlin/ParameterName;", "name", "httpResponse", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class FetchV3Method$modifyHeadersAndGetResponseDecoder$2 extends FunctionReferenceImpl implements Function1<HttpResponse, JSONObject> {
    final /* synthetic */ FetchV3Method$modifyHeadersAndGetResponseDecoder$1 $fromJsonResponse$1;

    public FetchV3Method$modifyHeadersAndGetResponseDecoder$2(FetchV3Method$modifyHeadersAndGetResponseDecoder$1 r7) {
        this.$fromJsonResponse$1 = r7;
        super(1, null, "fromJsonResponse", "invoke(Lcom/bytedance/android/livesdkapi/model/HttpResponse;)Lorg/json/JSONObject;", 0);
    }

    public final JSONObject invoke(HttpResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        return this.$fromJsonResponse$1.invoke(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((HttpResponse) r1);
    }
}
