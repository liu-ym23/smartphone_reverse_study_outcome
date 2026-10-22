package com.bytedance.android.live.effect.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/effect/api/MiddlewareEffectService;", "Lcom/bytedance/android/live/effect/api/IMiddlewareEffectService;", "Lcom/bytedance/android/live/effect/api/h;", "type", "Lcom/bytedance/android/live/effect/api/i;", "effectContext", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryType;", "convertLiveEffectContextFactoryType", "Lcom/bytedance/android/live/effect/api/p;", "effectService", "Lcom/bytedance/android/live/effect/api/r;", "vrEffectService", "Lcom/bytedance/android/live/effect/api/k0;", "vrEffectService$delegate", "Lkotlin/Lazy;", "getVrEffectService", "()Lcom/bytedance/android/live/effect/api/k0;", "<init>", "()V", "liveeffect-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MiddlewareEffectService implements IMiddlewareEffectService {
    private final Lazy vrEffectService$delegate;

    public final k0 getVrEffectService() {
        return (k0) this.vrEffectService$delegate.getValue();
    }

    public MiddlewareEffectService() {
        this.vrEffectService$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
    }

    @Override // com.bytedance.android.live.effect.api.IMiddlewareEffectService
    public r vrEffectService() {
        return getVrEffectService();
    }

    @Override // com.bytedance.android.live.effect.api.IMiddlewareEffectService
    public h convertLiveEffectContextFactoryType(LiveEffectContextFactoryType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        int r3 = e0.a[r2.ordinal()];
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L17;
        if (r3 == 3) goto L15;
        if (r3 == 4) goto L13;
        return LiveEffectContextFactoryDelegate$Type.DEFAULT;
    L13:
        return LiveEffectContextFactoryDelegate$Type.DIGIT_AVATAR;
    L15:
        return LiveEffectContextFactoryDelegate$Type.GIFT;
    L17:
        return LiveEffectContextFactoryDelegate$Type.LINK;
    L19:
        return LiveEffectContextFactoryDelegate$Type.DEFAULT;
    }

    @Override // com.bytedance.android.live.effect.api.IMiddlewareEffectService
    public i effectContext(LiveEffectContextFactoryType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return effectContext(convertLiveEffectContextFactoryType(r2));
    }

    @Override // com.bytedance.android.live.effect.api.IMiddlewareEffectService
    public p effectService(LiveEffectContextFactoryType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return effectContext(convertLiveEffectContextFactoryType(r2)).c();
    }

    @Override // com.bytedance.android.live.effect.api.IMiddlewareEffectService
    public i effectContext(h r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return new a0((LiveEffectContextFactoryDelegate$Type) r2);
    }
}
