package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/* JADX INFO: loaded from: classes2.dex */
public class CronetURLStreamHandlerFactory implements URLStreamHandlerFactory {
    private final ExperimentalCronetEngine mCronetEngine;

    public CronetURLStreamHandlerFactory(ExperimentalCronetEngine r8) {
        if (r8 == null) goto L7;
        this.mCronetEngine = r8;
        return;
    L7:
        throw new NullPointerException("CronetEngine is null.");
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(String r8) {
        if ("http".equals(r8) == true) goto L10;
        if (LocationInfoConst.HTTPS.equals(r8) == true) goto L10;
        return null;
    L10:
        return new CronetHttpURLStreamHandler(this.mCronetEngine);
    }
}
