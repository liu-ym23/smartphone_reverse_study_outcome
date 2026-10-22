package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ICronetEngineBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class NativeCronetEngineBuilderWithLibraryLoaderImpl extends NativeCronetEngineBuilderImpl {
    private VersionSafeCallbacks.LibraryLoader mLibraryLoader;

    public NativeCronetEngineBuilderWithLibraryLoaderImpl(Context r10, boolean r11) {
        super(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl
    VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return this.mLibraryLoader;
    }

    @Override // com.ttnet.org.chromium.net.impl.NativeCronetEngineBuilderImpl, com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r10) {
        return setLibraryLoader(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.NativeCronetEngineBuilderImpl, com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLibraryLoader(CronetEngine.Builder.LibraryLoader r10) {
        this.mLibraryLoader = new VersionSafeCallbacks.LibraryLoader(r10);
        return this;
    }
}
