package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livesdkapi.ai.game.IAiPredictCallback;
import com.bytedance.android.livesdkapi.service.gamecp.IAiService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gamecp/AiService;", "Lcom/bytedance/android/livesdkapi/service/gamecp/IAiService;", "()V", "stopGameDetailPreloadPredict", "", "stopGamePredict", "triggerGameDetailPreloadPredict", "params", "Lorg/json/JSONObject;", "callback", "Lcom/bytedance/android/livesdkapi/ai/game/IAiPredictCallback;", "triggerGamePredict", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AiService implements IAiService {
    public AiService() {
    }

    public void stopGameDetailPreloadPredict() {
        com.bytedance.android.live.ai.api.IAiService r0 = jc1.k.f(com.bytedance.android.live.ai.api.IAiService.class);
        if (r0 == null) goto L6;
        r0.stopGameDetailPreloadPredict();
        return;
    }

    public void stopGamePredict() {
        com.bytedance.android.live.ai.api.IAiService r0 = jc1.k.f(com.bytedance.android.live.ai.api.IAiService.class);
        if (r0 == null) goto L6;
        r0.stopGamePredict();
        return;
    }

    public void triggerGameDetailPreloadPredict(JSONObject r2, IAiPredictCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        com.bytedance.android.live.ai.api.IAiService r0 = jc1.k.f(com.bytedance.android.live.ai.api.IAiService.class);
        if (r0 == null) goto L6;
        r0.triggerGameDetailPreloadPredict(r2, r3);
        return;
    }

    public void triggerGamePredict(JSONObject r2, IAiPredictCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        com.bytedance.android.live.ai.api.IAiService r0 = jc1.k.f(com.bytedance.android.live.ai.api.IAiService.class);
        if (r0 == null) goto L6;
        r0.triggerGamePredict(r2, r3);
        return;
    }
}
