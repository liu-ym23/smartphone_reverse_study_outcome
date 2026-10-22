package com.ss.bduploader;

import com.bytedance.ttnet.TTNetInit;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class TTNetWrapper {
    public TTNetWrapper() {
    }

    public static List<InetAddress> dnsLookup(String r0) {
        return TTNetInit.dnsLookup(r0);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
