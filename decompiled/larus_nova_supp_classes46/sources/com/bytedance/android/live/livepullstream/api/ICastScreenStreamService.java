package com.bytedance.android.live.livepullstream.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import gl0.e;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ServiceLookup("com.bytedance.android.live.livepullstream.service.CastScreenStreamService")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/livepullstream/api/ICastScreenStreamService;", "Lcom/bytedance/android/live/base/IService;", "Lorg/json/JSONObject;", "streamInfoObject", "Lgl0/e;", "getLiveStreamWrapper", "livepullstream-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ICastScreenStreamService extends IService {
    e getLiveStreamWrapper(JSONObject r1);
}
