package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net::android")
public class DnsStatus {
    private final List<InetAddress> mDnsServers;
    private final boolean mPrivateDnsActive;
    private final String mPrivateDnsServerName;
    private final String mSearchDomains;

    public DnsStatus(List<InetAddress> r10, boolean r11, String r12, String r13) {
        this.mDnsServers = r10;
        this.mPrivateDnsActive = r11;
        if (r12 != null) goto L6;
        r12 = "";
    L6:
        this.mPrivateDnsServerName = r12;
        if (r13 != null) goto L10;
        r13 = "";
    L10:
        this.mSearchDomains = r13;
    }

    @CalledByNative
    public byte[][] getDnsServers() {
        byte[][] r10 = new byte[this.mDnsServers.size()][];
        int r11 = 0;
    L4:
        if (r11 >= this.mDnsServers.size()) goto L6;
        r10[r11] = this.mDnsServers.get(r11).getAddress();
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    @CalledByNative
    public boolean getPrivateDnsActive() {
        return this.mPrivateDnsActive;
    }

    @CalledByNative
    public String getPrivateDnsServerName() {
        return this.mPrivateDnsServerName;
    }

    @CalledByNative
    public String getSearchDomains() {
        return this.mSearchDomains;
    }
}
