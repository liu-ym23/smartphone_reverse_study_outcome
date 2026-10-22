package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import java.io.Serializable;
import w9.a;

/* JADX INFO: loaded from: classes2.dex */
public class HostResolveJob implements Serializable, Comparable<HostResolveJob> {
    private long mCreatedTime;
    private String mHost;
    public a mHttpDnsCallback;
    private boolean mIsLocalDnsExpired;

    public HostResolveJob(String r5, a r10, boolean r11) {
        this.mHost = r5;
        this.mCreatedTime = System.currentTimeMillis();
        this.mIsLocalDnsExpired = r11;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(HostResolveJob r5) {
        return compareTo2(r5);
    }

    public String getHost() {
        return this.mHost;
    }

    public boolean isLocalDnsExpired() {
        return this.mIsLocalDnsExpired;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(HostResolveJob r5) {
        long r10 = r5.mCreatedTime;
        long r11 = this.mCreatedTime;
        if (r10 != r11) goto L7;
        return 0;
    L7:
        if (r10 >= r11) goto L9;
        return -1;
    L9:
        return 1;
    }
}
