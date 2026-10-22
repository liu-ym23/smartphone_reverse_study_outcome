package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k4$b {
    private final String directory;
    private final long downloadedBytes;
    private final String fileName;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k4$b) == true) goto L8;
        return false;
    L8:
        k4$b r9 = (k4$b) r8;
        if (Intrinsics.areEqual(this.directory, r9.directory) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileName, r9.fileName) == true) goto L15;
        return false;
    L15:
        if (this.downloadedBytes == r9.downloadedBytes) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.directory.hashCode() * 31) + this.fileName.hashCode()) * 31;
        long r1 = this.downloadedBytes;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "DownloadTarget(directory=" + this.directory + ", fileName=" + this.fileName + ", downloadedBytes=" + this.downloadedBytes + ')';
    }

    public final String a() {
        return this.directory;
    }

    public final long b() {
        return this.downloadedBytes;
    }

    public final String c() {
        return this.fileName;
    }

    public k4$b(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "directory");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        this.directory = r2;
        this.fileName = r3;
        this.downloadedBytes = r4;
    }
}
