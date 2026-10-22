package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("net::android")
public class DnsStatus {
    private final List<InetAddress> mDnsServers;
    private final boolean mPrivateDnsActive;
    private final String mPrivateDnsServerName;
    private final String mSearchDomains;

    public DnsStatus(List<InetAddress> r3, boolean r4, String r5, String r6) {
        this.mDnsServers = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.mPrivateDnsActive = r4;
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        this.mPrivateDnsServerName = r5;
        if (r6 != null) goto L10;
        r6 = "";
    L10:
        this.mSearchDomains = r6;
    }

    public byte[][] getDnsServers() {
        byte[][] r0 = new byte[this.mDnsServers.size()][];
        int r1 = 0;
    L4:
        if (r1 >= this.mDnsServers.size()) goto L6;
        r0[r1] = ((InetAddress) ZeusTransformUtils.preCheckCast(this.mDnsServers.get(r1), InetAddress.class, "com.obric.memorydata.plugin")).getAddress();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public boolean getPrivateDnsActive() {
        return this.mPrivateDnsActive;
    }

    public String getPrivateDnsServerName() {
        return this.mPrivateDnsServerName;
    }

    public String getSearchDomains() {
        return this.mSearchDomains;
    }
}
