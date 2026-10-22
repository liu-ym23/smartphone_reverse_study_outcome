package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/* JADX INFO: loaded from: classes2.dex */
class CronetHttpURLStreamHandler extends URLStreamHandler {
    private final ExperimentalCronetEngine mCronetEngine;

    public CronetHttpURLStreamHandler(ExperimentalCronetEngine r8) {
        this.mCronetEngine = r8;
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL r8) {
        return this.mCronetEngine.openConnection(r8);
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL r8, Proxy r10) {
        return this.mCronetEngine.openConnection(r8, r10);
    }
}
