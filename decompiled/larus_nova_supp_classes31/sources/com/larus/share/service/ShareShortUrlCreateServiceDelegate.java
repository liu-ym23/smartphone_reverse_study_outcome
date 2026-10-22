package com.larus.share.service;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096A¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/share/service/ShareShortUrlCreateServiceDelegate;", "Lcom/larus/share/service/IShareShortUrlCreateService;", "<init>", "()V", "createShortUrls", "Lcom/larus/network/http/Async;", "Lcom/larus/share/service/ShareShortUrlCreateResponse;", "longUrls", "", "", "fallbackToLongUrl", "", "shareRecord", "Lorg/json/JSONObject;", "(Ljava/util/List;ZLorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ShareShortUrlCreateServiceDelegate implements IShareShortUrlCreateService {
    public static final ShareShortUrlCreateServiceDelegate b = null;
    public final /* synthetic */ IShareShortUrlCreateService a;

    static {
        b = new ShareShortUrlCreateServiceDelegate();
    }

    @Override // com.larus.share.service.IShareShortUrlCreateService
    public final Object a(List<String> r2, boolean r3, JSONObject r4, Continuation<? super com.larus.network.http.a<ShareShortUrlCreateResponse>> r5) {
        return this.a.a(r2, r3, r4, r5);
    }

    private ShareShortUrlCreateServiceDelegate() {
        IShareShortUrlCreateService r0 = (IShareShortUrlCreateService) ServiceManager.get().getService(IShareShortUrlCreateService.class);
        if (r0 != null) goto L5;
        r0 = new ShareShortUrlCreateServiceNoop();
    L5:
        this.a = r0;
    }
}
