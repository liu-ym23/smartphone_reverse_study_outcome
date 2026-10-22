package com.larus.share.service;

import com.larus.network.http.AsyncThrowable;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/share/service/ShareShortUrlCreateServiceNoop;", "Lcom/larus/share/service/IShareShortUrlCreateService;", "<init>", "()V", "createShortUrls", "Lcom/larus/network/http/Async;", "Lcom/larus/share/service/ShareShortUrlCreateResponse;", "longUrls", "", "", "fallbackToLongUrl", "", "shareRecord", "Lorg/json/JSONObject;", "(Ljava/util/List;ZLorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ShareShortUrlCreateServiceNoop implements IShareShortUrlCreateService {
    public ShareShortUrlCreateServiceNoop() {
    }

    @Override // com.larus.share.service.IShareShortUrlCreateService
    public final Object a(List<String> r3, boolean r4, JSONObject r5, Continuation<? super com.larus.network.http.a<ShareShortUrlCreateResponse>> r6) {
        return new com.larus.network.http.f(new AsyncThrowable(-999, "share short url service is null", new Throwable()), null);
    }
}
