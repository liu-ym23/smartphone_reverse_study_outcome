package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/* JADX INFO: loaded from: classes6.dex */
class CronetHttpURLStreamHandler extends URLStreamHandler {
    private final ExperimentalCronetEngine mCronetEngine;

    public CronetHttpURLStreamHandler(ExperimentalCronetEngine r1) {
        this.mCronetEngine = r1;
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL r1) {
        return this.mCronetEngine.openConnection(r1);
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL r1, Proxy r2) {
        return this.mCronetEngine.openConnection(r1, r2);
    }
}
