package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/effect/api/IMiddlewareEffectServiceDelegate;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/e;", "baseEffectContext", "Lcom/bytedance/android/live/effect/api/g;", "baseEffectService", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager", "Lcom/bytedance/android/live/effect/api/f;", "baseEffectProxy", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareEffectServiceDelegate extends IService {
    e baseEffectContext(LiveEffectContextFactoryDelegate$Type r1);

    f baseEffectProxy();

    g baseEffectService(LiveEffectContextFactoryDelegate$Type r1);

    ILiveEffectComposerManager composerManager(LiveEffectContextFactoryDelegate$Type r1);
}
