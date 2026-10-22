package llc;

import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements com.ss.ugc.effectplatform.bridge.network.b {
    public final com.ss.ugc.effectplatform.bridge.network.b a;
    public final INetworkClient b;

    @Override // com.ss.ugc.effectplatform.bridge.network.b
    public final void cancel(String r2) {
        this.a.cancel(r2);
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.INetworkClient
    public final NetResponse fetchFromNetwork(NetRequest r2) {
        return this.b.fetchFromNetwork(r2);
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.b
    public final void pause(String r2) {
        this.a.pause(r2);
    }

    public d(b r1, INetworkClient r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.b
    public final NetResponse a(NetRequest r2, String r3, String r4, com.ss.ugc.effectplatform.bridge.network.a r5) {
        return this.a.a(r2, r3, r4, r5);
    }
}
