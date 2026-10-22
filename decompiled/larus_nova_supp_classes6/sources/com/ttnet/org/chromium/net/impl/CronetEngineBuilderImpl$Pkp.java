package com.ttnet.org.chromium.net.impl;

import java.util.Date;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronetEngineBuilderImpl$Pkp {
    final Date mExpirationDate;
    final byte[][] mHashes;
    final String mHost;
    final boolean mIncludeSubdomains;

    public CronetEngineBuilderImpl$Pkp(String r1, byte[][] r2, boolean r3, Date r4) {
        this.mHost = r1;
        this.mHashes = r2;
        this.mIncludeSubdomains = r3;
        this.mExpirationDate = r4;
    }
}
