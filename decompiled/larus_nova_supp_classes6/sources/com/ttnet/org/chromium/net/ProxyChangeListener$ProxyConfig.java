package com.ttnet.org.chromium.net;

import android.net.ProxyInfo;
import android.net.Uri;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ProxyChangeListener$ProxyConfig {
    public static final ProxyChangeListener$ProxyConfig DIRECT = null;
    public final String[] mExclusionList;
    public final String mHost;
    public final String mPacUrl;
    public final int mPort;

    static {
        DIRECT = new ProxyChangeListener$ProxyConfig("", 0, "", new String[0]);
    }

    public static /* synthetic */ ProxyChangeListener$ProxyConfig access$300(ProxyInfo r0) {
        return fromProxyInfo(r0);
    }

    private static ProxyChangeListener$ProxyConfig fromProxyInfo(ProxyInfo r6) {
        String r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        String r1 = r6.getHost();
        Uri r2 = r6.getPacFileUrl();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        int r4 = r6.getPort();
        if (Uri.EMPTY.equals(r2) == true) goto L13;
        r0 = r2.toString();
    L13:
        return new ProxyChangeListener$ProxyConfig(r1, r4, r0, r6.getExclusionList());
    }

    public ProxyChangeListener$ProxyConfig(String r1, int r2, String r3, String[] r4) {
        this.mHost = r1;
        this.mPort = r2;
        this.mPacUrl = r3;
        this.mExclusionList = r4;
    }
}
