package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ICronetEngineBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class NativeCronetEngineBuilderWithLibraryLoaderImpl extends NativeCronetEngineBuilderImpl {
    private VersionSafeCallbacks.LibraryLoader mLibraryLoader;

    public VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return this.mLibraryLoader;
    }

    /* JADX INFO: renamed from: setLibraryLoader, reason: collision with other method in class */
    public CronetEngineBuilderImpl m44setLibraryLoader(CronetEngine.Builder.LibraryLoader r2) {
        this.mLibraryLoader = new VersionSafeCallbacks.LibraryLoader(r2);
        return this;
    }

    @Override // com.ttnet.org.chromium.net.impl.NativeCronetEngineBuilderImpl
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r1) {
        return m44setLibraryLoader(r1);
    }

    public NativeCronetEngineBuilderWithLibraryLoaderImpl(Context r1, boolean r2) {
        super(r1, r2);
    }
}
