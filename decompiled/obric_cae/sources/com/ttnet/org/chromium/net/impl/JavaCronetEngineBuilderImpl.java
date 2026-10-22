package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;

/* JADX INFO: loaded from: classes2.dex */
public class JavaCronetEngineBuilderImpl extends CronetEngineBuilderImpl {
    public JavaCronetEngineBuilderImpl(Context r8) {
        super(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public ExperimentalCronetEngine build() {
        if (getUserAgent() != null) goto L6;
        setUserAgent(getDefaultUserAgent());
    L6:
        return new JavaCronetEngine(this);
    }
}
