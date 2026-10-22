package com.bytedance.android.live.openplatform.api;

import com.bytedance.android.live.base.IService;
import java.util.Map;
import ko0.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/IMiddlewareOpenPlatformService;", "Lcom/bytedance/android/live/base/IService;", "Lko0/c;", "getMiniAppLiveCastEntranceInfo", "", "cardType", "", "", "", "getMiniAppCommonCardExtraParams", "liveopenplatform-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareOpenPlatformService extends IService {
    Map<String, Object> getMiniAppCommonCardExtraParams(int r1);

    c getMiniAppLiveCastEntranceInfo();
}
