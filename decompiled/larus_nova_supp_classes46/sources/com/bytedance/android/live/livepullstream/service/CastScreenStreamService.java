package com.bytedance.android.live.livepullstream.service;

import com.bytedance.android.live.livepullstream.api.ICastScreenStreamService;
import com.bytedance.android.livesdk.player.z;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/livepullstream/service/CastScreenStreamService;", "Lcom/bytedance/android/live/livepullstream/api/ICastScreenStreamService;", "Lorg/json/JSONObject;", "streamInfoObject", "Lgl0/e;", "getLiveStreamWrapper", "<init>", "()V", "livepullstream-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CastScreenStreamService implements ICastScreenStreamService {
    public CastScreenStreamService() {
        k.l(ICastScreenStreamService.class, this);
    }

    @Override // com.bytedance.android.live.livepullstream.api.ICastScreenStreamService
    public gl0.e getLiveStreamWrapper(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "streamInfoObject");
        return new z(r2);
    }
}
