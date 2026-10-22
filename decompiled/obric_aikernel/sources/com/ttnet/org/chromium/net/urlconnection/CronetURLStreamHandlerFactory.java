package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class CronetURLStreamHandlerFactory implements URLStreamHandlerFactory {
    private final ExperimentalCronetEngine mCronetEngine;

    public CronetURLStreamHandlerFactory(ExperimentalCronetEngine r10) {
        Objects.requireNonNull(r10, "CronetEngine is null.");
        this.mCronetEngine = r10;
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(String r10) {
        if ("http".equals(r10) == true) goto L10;
        if ("https".equals(r10) == true) goto L10;
        return null;
    L10:
        return new CronetHttpURLStreamHandler(this.mCronetEngine);
    }
}
