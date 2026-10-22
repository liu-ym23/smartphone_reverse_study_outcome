package com.bytedance.android.live.core;

import android.app.Activity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
import t80.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u000b\u001a\u00020\nH&J6\u0010\u0015\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J<\u0010\u0019\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0018\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00172\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J>\u0010\u001b\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u0004H&J?\u0010\"\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00022\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001d2\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f\"\u00020 H&¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/core/ILiveCoreService;", "Lcom/bytedance/android/live/base/IService;", "", "serviceName", "Lorg/json/JSONObject;", "category", "metric", "extra", "", "reportUseTrace", "", "realNameUseTracePlatform", "Landroid/app/Activity;", "activity", "", "statusCode", "requestPage", "Lcom/bytedance/android/live/network/response/RequestError;", "error", "Lt80/a;", "onVerifyResultListener", "minorInterceptOld", "requestUrl", "Lcom/bytedance/android/live/network/response/BaseResponse;", "response", "liveRechargeIntercept", "result", "minorIntercept", "eventName", "", "extraParams", "", "", "args", "sendLog", "(Ljava/lang/String;Ljava/util/Map;[Ljava/lang/Object;)V", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCoreService extends IService {
    boolean liveRechargeIntercept(String r1, int r2, BaseResponse<?, ?> r3, String r4, RequestError r5);

    void minorIntercept(Activity r1, int r2, String r3, RequestError r4, a r5, JSONObject r6);

    void minorInterceptOld(Activity r1, int r2, String r3, RequestError r4, a r5);

    boolean realNameUseTracePlatform();

    void reportUseTrace(String r1, JSONObject r2, JSONObject r3, JSONObject r4);

    void sendLog(String r1, Map<String, String> r2, Object... r3);
}
