package com.facebook.binaryresource;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class FileBinaryResource implements BinaryResource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f7574a;

    public FileBinaryResource(File r5) {
        this.f7574a = r5;
    }

    public final boolean equals(Object r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if ((r5 instanceof FileBinaryResource) == true) goto L7;
        return false;
    L7:
        return this.f7574a.equals(((FileBinaryResource) r5).f7574a);
    }

    public final int hashCode() {
        return this.f7574a.hashCode();
    }
}
