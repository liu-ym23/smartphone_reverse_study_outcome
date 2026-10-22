package com.larus.common.account.douyin;

import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DouyinHeartBeatServiceImpl$d extends BDNetworkTagContextProviderAdapter {
    public final /* synthetic */ boolean a;

    public final int triggerType() {
        return !this.a ? 1 : 0;
    }

    public final boolean markAsNewUser() {
        return super.markAsNewUser();
    }

    public DouyinHeartBeatServiceImpl$d(boolean r1) {
        this.a = r1;
    }
}
