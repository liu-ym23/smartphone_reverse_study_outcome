package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/* JADX INFO: loaded from: classes2.dex */
class CronetHttpURLStreamHandler extends URLStreamHandler {
    private final ExperimentalCronetEngine mCronetEngine;

    public CronetHttpURLStreamHandler(ExperimentalCronetEngine r10) {
        this.mCronetEngine = r10;
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL r10) {
        return this.mCronetEngine.openConnection(r10);
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL r10, Proxy r11) {
        return this.mCronetEngine.openConnection(r10, r11);
    }
}
