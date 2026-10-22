package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.CronetEngine$Builder$LibraryLoader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class VersionSafeCallbacks$LibraryLoader extends CronetEngine$Builder$LibraryLoader {
    private final CronetEngine$Builder$LibraryLoader mWrappedLoader;

    public VersionSafeCallbacks$LibraryLoader(CronetEngine$Builder$LibraryLoader r1) {
        this.mWrappedLoader = r1;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine$Builder$LibraryLoader
    public void loadLibrary(String r2) {
        this.mWrappedLoader.loadLibrary(r2);
    }
}
