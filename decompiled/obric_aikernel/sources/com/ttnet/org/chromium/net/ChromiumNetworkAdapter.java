package com.ttnet.org.chromium.net;

import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes2.dex */
public final class ChromiumNetworkAdapter {
    private ChromiumNetworkAdapter() {
    }

    public static URLConnection openConnection(URL r10, NetworkTrafficAnnotationTag r11) {
        return r10.openConnection();
    }

    public static URLConnection openConnection(URL r10, Proxy r11, NetworkTrafficAnnotationTag r12) {
        return r10.openConnection(r11);
    }

    public static InputStream openStream(URL r10, NetworkTrafficAnnotationTag r11) {
        return r10.openStream();
    }
}
