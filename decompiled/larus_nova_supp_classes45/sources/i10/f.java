package i10;

import com.bytedance.android.live.broadcastgame.di.BdpLiveModuleFallback_ProvideBdpRegisterServiceFactory;
import com.bytedance.android.live.broadcastgame.di.BroadcastGameAnchorModule_ProvideGameAnchorServiceFactory;
import com.bytedance.android.live.broadcastgame.di.BroadcastGameAudienceModule_ProvideGameAudienceServiceFactory;
import com.bytedance.android.live.broadcastgame.f0;
import com.bytedance.android.live.broadcastgame.opengame.di.OpenPlatformModule_ProvideOpenPlatformServiceFactory;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements h {
    public final f a;
    public Provider<com.bytedance.android.live.broadcastgame.api.e> b;
    public Provider<com.bytedance.android.live.broadcastgame.api.f> c;
    public Provider<f0> d;
    public Provider<com.bytedance.android.live.broadcastgame.api.d> e;

    public f(b r1, c r2, p10.a r3, a r4) {
        this.a = this;
        this.b = DoubleCheck.provider(BroadcastGameAnchorModule_ProvideGameAnchorServiceFactory.create(r1));
        this.c = DoubleCheck.provider(BroadcastGameAudienceModule_ProvideGameAudienceServiceFactory.create(r2));
        this.d = DoubleCheck.provider(OpenPlatformModule_ProvideOpenPlatformServiceFactory.create(r3));
        this.e = DoubleCheck.provider(BdpLiveModuleFallback_ProvideBdpRegisterServiceFactory.create(r4));
    }
}
