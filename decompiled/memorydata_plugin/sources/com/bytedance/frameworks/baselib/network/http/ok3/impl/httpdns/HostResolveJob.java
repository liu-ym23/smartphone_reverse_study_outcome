package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class HostResolveJob implements Serializable, Comparable<HostResolveJob> {
    private long mCreatedTime;
    private String mHost;
    public d mHttpDnsCallback;
    private boolean mIsLocalDnsExpired;

    public HostResolveJob(String r3, d r4, boolean r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        this.mHost = r3;
        this.mHttpDnsCallback = r6;
        this.mCreatedTime = System.currentTimeMillis();
        this.mIsLocalDnsExpired = r5;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(HostResolveJob r4) {
        long r0 = r4.mCreatedTime;
        long r3 = this.mCreatedTime;
        if (r0 != r3) goto L7;
        return 0;
    L7:
        if (r0 >= r3) goto L9;
        return -1;
    L9:
        return 1;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(HostResolveJob r3) {
        return compareTo2((HostResolveJob) ZeusTransformUtils.preCheckCast(r3, HostResolveJob.class, "com.obric.memorydata.plugin"));
    }

    public String getHost() {
        return this.mHost;
    }

    public boolean isLocalDnsExpired() {
        return this.mIsLocalDnsExpired;
    }
}
