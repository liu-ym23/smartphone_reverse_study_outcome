package com.byted.mgl.merge.service.api.platform;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/byted/mgl/merge/service/api/platform/IPreloadGameService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "preloadGameEnv", "", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public interface IPreloadGameService extends IBdpService {
    void preloadGameEnv();
}
