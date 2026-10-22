package com.bytedance.bdinstall;

import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class d$a extends BDNetworkTagContextProviderAdapter {
    public final /* synthetic */ boolean a;

    public final int triggerType() {
        return 0;
    }

    public final boolean markAsNewUser() {
        return !this.a;
    }

    public d$a(boolean r1) {
        this.a = r1;
    }
}
