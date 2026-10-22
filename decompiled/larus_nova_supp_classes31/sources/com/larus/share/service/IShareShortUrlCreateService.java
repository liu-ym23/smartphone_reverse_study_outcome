package com.larus.share.service;

import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH¦@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/larus/share/service/IShareShortUrlCreateService;", "", "createShortUrls", "Lcom/larus/network/http/Async;", "Lcom/larus/share/service/ShareShortUrlCreateResponse;", "longUrls", "", "", "fallbackToLongUrl", "", "shareRecord", "Lorg/json/JSONObject;", "(Ljava/util/List;ZLorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IShareShortUrlCreateService {
    Object a(List<String> r1, boolean r2, JSONObject r3, Continuation<? super com.larus.network.http.a<ShareShortUrlCreateResponse>> r4);
}
