package com.bytedance.ies.ugc.aweme.network;

import com.bytedance.bdinstall.Level;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.ugc.aweme.framework.services.annotation.DowngradeImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@DowngradeImpl
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"com/bytedance/ies/ugc/aweme/network/NetworkCommonParams$Default", "Lcom/bytedance/ies/ugc/aweme/network/NetworkCommonParams$INetworkCommonParams;", "<init>", "()V", "aweme-network-api_release"}, k = 1, mv = {1, 4, 1})
public final class NetworkCommonParams$Default implements NetworkCommonParams$INetworkCommonParams {
    public NetworkCommonParams$Default() {
    }

    @Override // com.bytedance.ies.ugc.aweme.network.NetworkCommonParams$INetworkCommonParams
    public final String loadTo(String r5, boolean r10, Level r11, Map r12) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r11, "level");
        return r5;
    }

    @Override // com.bytedance.ies.ugc.aweme.network.NetworkCommonParams$INetworkCommonParams
    public final void loadTo(Map r5, String r10, String r11, boolean r12, Level r13, Map r14) {
        Intrinsics.checkNotNullParameter(r5, "receiver");
        Intrinsics.checkNotNullParameter(r10, SVGRenderEngine.PATH);
        Intrinsics.checkNotNullParameter(r11, "domain");
        Intrinsics.checkNotNullParameter(r13, "level");
    }
}
