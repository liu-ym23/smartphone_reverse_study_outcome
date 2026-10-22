package com.bytedance.android.live.livepullstream.service;

import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.ss.videoarch.strategy.network.IHttpExecutor;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements IHttpExecutor {

    public static final class a extends BDNetworkTagContextProviderAdapter {
        public final int triggerType() {
            return 0;
        }

        public a() {
        }
    }

    public b() {
    }

    public final String executeGet(String r3) {
        INetworkService r0 = (INetworkService) k.f(INetworkService.class);
        if (r0 == null) goto L10;
        LiveCall r4 = r0.get(r3, null);
        if (r4 == null) goto L10;
        HttpResponse r5 = (HttpResponse) r4.execute();
        if (r5 == null) goto L10;
        byte[] r6 = r5.getBody();
        if (r6 == null) goto L10;
    L12:
        return new String(r6, Charsets.UTF_8);
    L10:
        r6 = new byte[0];
        goto L12
    }

    public final String executePost(String r3, byte[] r4, String r5, String r6) {
        List r7 = CollectionsKt.listOf(new NameValuePair("x-tt-request-tag", (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new a()).second));
        INetworkService r0 = (INetworkService) k.f(INetworkService.class);
        if (r0 == null) goto L10;
        LiveCall r8 = r0.post(r3, r7, r6, r4);
        if (r8 == null) goto L10;
        HttpResponse r9 = (HttpResponse) r8.execute();
        if (r9 == null) goto L10;
        byte[] r10 = r9.getBody();
        if (r10 == null) goto L10;
    L12:
        return new String(r10, Charsets.UTF_8);
    L10:
        r10 = new byte[0];
        goto L12
    }
}
