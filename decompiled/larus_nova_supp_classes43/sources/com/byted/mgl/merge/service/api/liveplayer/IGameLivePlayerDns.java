package com.byted.mgl.merge.service.api.liveplayer;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0001H&J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/IGameLivePlayerDns;", "", "getOptimizerInstance", "startOptimize", "", "stopOptimize", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public interface IGameLivePlayerDns {
    Object getOptimizerInstance();

    void startOptimize();

    void stopOptimize();
}
