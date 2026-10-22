package com.bytedance.android.live.openplatform.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.openplatform.LiveOpenApiCallback;
import java.util.Map;
import ko0.c;
import kotlin.Metadata;
import org.json.JSONObject;
import w20.lc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\u001c\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u000eH&J\u0016\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/IOpenPlatformService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/openplatform/api/IMiddlewareOpenPlatformService;", "Lko0/c;", "getMiniAppLiveCastEntranceInfo", "", "appId", "Lorg/json/JSONObject;", "params", "Lcom/bytedance/android/livesdkapi/openplatform/LiveOpenApiCallback;", "callback", "", "invokeLiveOpenApi", "schema", "Lw20/lc$a;", "openLiveMicroApp", "", "getCommonEventParams", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IOpenPlatformService extends IService, IMiddlewareOpenPlatformService {
    Map<String, String> getCommonEventParams();

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformService
    c getMiniAppLiveCastEntranceInfo();

    void invokeLiveOpenApi(String r1, JSONObject r2, LiveOpenApiCallback r3);

    void openLiveMicroApp(String r1, lc.a r2);
}
