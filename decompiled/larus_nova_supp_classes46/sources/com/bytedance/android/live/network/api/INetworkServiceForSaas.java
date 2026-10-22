package com.bytedance.android.live.network.api;

import android.util.Pair;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface INetworkServiceForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.live.network.api.INetworkServiceForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static List $default$getBdTicketParams(INetworkServiceForSaas r0, String r1, String r2) {
            return null;
        }
    }

    List<Pair<String, String>> getBdTicketParams(String r1, String r2);
}
