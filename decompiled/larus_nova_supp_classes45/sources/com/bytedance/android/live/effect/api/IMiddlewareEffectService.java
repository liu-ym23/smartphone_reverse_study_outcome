package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/effect/api/IMiddlewareEffectService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/effect/api/h;", "type", "Lcom/bytedance/android/live/effect/api/i;", "effectContext", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryType;", "convertLiveEffectContextFactoryType", "Lcom/bytedance/android/live/effect/api/p;", "effectService", "Lcom/bytedance/android/live/effect/api/r;", "vrEffectService", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareEffectService extends IService {
    h convertLiveEffectContextFactoryType(LiveEffectContextFactoryType r1);

    i effectContext(LiveEffectContextFactoryType r1);

    i effectContext(h r1);

    p effectService(LiveEffectContextFactoryType r1);

    r vrEffectService();
}
