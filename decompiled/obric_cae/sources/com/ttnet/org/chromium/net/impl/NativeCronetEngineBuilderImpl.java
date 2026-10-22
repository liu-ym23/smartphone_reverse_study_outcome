package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;

/* JADX INFO: loaded from: classes2.dex */
public class NativeCronetEngineBuilderImpl extends CronetEngineBuilderImpl {
    public NativeCronetEngineBuilderImpl(Context r8) {
        super(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public ExperimentalCronetEngine build() {
        if (getUserAgent() != null) goto L5;
        setUserAgent(getDefaultUserAgent());
    L5:
        CronetUrlRequestContext r8 = new CronetUrlRequestContext(this);
        this.mMockCertVerifier = 0;
        return r8;
    }
}
