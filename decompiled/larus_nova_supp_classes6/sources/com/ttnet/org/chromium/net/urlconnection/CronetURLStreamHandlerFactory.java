package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronetURLStreamHandlerFactory implements URLStreamHandlerFactory {
    private final ExperimentalCronetEngine mCronetEngine;

    public CronetURLStreamHandlerFactory(ExperimentalCronetEngine r2) {
        if (r2 == null) goto L7;
        this.mCronetEngine = r2;
        return;
    L7:
        throw new NullPointerException("CronetEngine is null.");
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(String r2) {
        if ("http".equals(r2) == true) goto L10;
        if ("https".equals(r2) == true) goto L10;
        return null;
    L10:
        return new CronetHttpURLStreamHandler(this.mCronetEngine);
    }
}
