package com.byted.mgl.merge.service.api.aweme;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.ai.event.MessageIndication;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/byted/mgl/merge/service/api/aweme/OpenAwemeUserProfileCallback;", "", "onFailure", "", "code", "", MessageIndication.MESSAGE_TYPE_MSG, "", "onSuccess", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public interface OpenAwemeUserProfileCallback {
    void onFailure(int r1, String r10);

    void onSuccess();
}
