package com.larus.security.api;

import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c extends BDNetworkTagContextProviderAdapter {
    public final /* synthetic */ boolean a;

    public c() {
        this.a = true;
    }

    public final int triggerType() {
        return !this.a ? 1 : 0;
    }
}
